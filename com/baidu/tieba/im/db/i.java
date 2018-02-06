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
    private static i eBM;
    private static long eBP = -1;
    private static int eBQ = 0;
    private a eBN = new a();
    private b eBO = null;

    public static i aIi() {
        if (eBM == null) {
            synchronized (i.class) {
                if (eBM == null) {
                    eBM = new i();
                }
            }
        }
        return eBM;
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
                    i.aIi().eBN.removeMessages(1);
                    i.aIi().execute();
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
                        i.this.eBN.sendMessageDelayed(i.this.eBN.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.eBN.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eBO != null) {
            this.eBO.cancel();
            this.eBO = null;
        }
        this.eBO = new b();
        this.eBO.setParallel(TiebaIMConfig.getParallel());
        this.eBO.setPriority(4);
        this.eBO.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eBO != null) {
            this.eBO.cancel();
            this.eBO = null;
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
            LinkedList<ImMessageCenterPojo> aIn = j.aIk().aIn();
            if (aIn == null || aIn.size() == 0) {
                return false;
            }
            if (i.eBP < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eBP = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eBP > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.eBQ = 5000;
                    } else if (i.eBP > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eBQ = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = i.eBQ = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eBQ < 1000) {
                int unused5 = i.eBQ = 1000;
            }
            try {
                h.aIg().aIh();
                for (ImMessageCenterPojo imMessageCenterPojo : aIn) {
                    if (isCancelled()) {
                        h.aIg().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aHZ().ac(imMessageCenterPojo.getGid(), i.eBQ);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aIs().ac(imMessageCenterPojo.getGid(), i.eBQ);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aIq().ac(imMessageCenterPojo.getGid(), i.eBQ);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aIa().ac(imMessageCenterPojo.getGid(), i.eBQ);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aIg().endTransaction();
            }
            return true;
        }
    }
}
