package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i eBA;
    private static long eBD = -1;
    private static int eBE = 0;
    private a eBB = new a();
    private b eBC = null;

    public static i aIh() {
        if (eBA == null) {
            synchronized (i.class) {
                if (eBA == null) {
                    eBA = new i();
                }
            }
        }
        return eBA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    i.aIh().eBB.removeMessages(1);
                    i.aIh().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private i() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001011) { // from class: com.baidu.tieba.im.db.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        i.this.eBB.sendMessageDelayed(i.this.eBB.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.eBB.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eBC != null) {
            this.eBC.cancel();
            this.eBC = null;
        }
        this.eBC = new b();
        this.eBC.setParallel(TiebaIMConfig.getParallel());
        this.eBC.setPriority(4);
        this.eBC.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eBC != null) {
            this.eBC.cancel();
            this.eBC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [185=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> aIm = j.aIj().aIm();
            if (aIm == null || aIm.size() == 0) {
                return false;
            }
            if (i.eBD < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eBD = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eBD > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.eBE = 5000;
                    } else if (i.eBD > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eBE = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = i.eBE = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eBE < 1000) {
                int unused5 = i.eBE = 1000;
            }
            try {
                h.aIf().aIg();
                for (ImMessageCenterPojo imMessageCenterPojo : aIm) {
                    if (isCancelled()) {
                        h.aIf().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aHY().ac(imMessageCenterPojo.getGid(), i.eBE);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aIr().ac(imMessageCenterPojo.getGid(), i.eBE);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aIp().ac(imMessageCenterPojo.getGid(), i.eBE);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aHZ().ac(imMessageCenterPojo.getGid(), i.eBE);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aIf().endTransaction();
            }
            return true;
        }
    }
}
