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
    private static i dWr;
    private static long dWu = -1;
    private static int dWv = 0;
    private a dWs = new a();
    private b dWt = null;

    public static i aDh() {
        if (dWr == null) {
            synchronized (i.class) {
                if (dWr == null) {
                    dWr = new i();
                }
            }
        }
        return dWr;
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
                    i.aDh().dWs.removeMessages(1);
                    i.aDh().execute();
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
                        i.this.dWs.sendMessageDelayed(i.this.dWs.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.dWs.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dWt != null) {
            this.dWt.cancel();
            this.dWt = null;
        }
        this.dWt = new b();
        this.dWt.setParallel(TiebaIMConfig.getParallel());
        this.dWt.setPriority(4);
        this.dWt.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dWt != null) {
            this.dWt.cancel();
            this.dWt = null;
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
            LinkedList<ImMessageCenterPojo> aDl = j.aDi().aDl();
            if (aDl == null || aDl.size() == 0) {
                return false;
            }
            if (i.dWu < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.dWu = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.dWu > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.dWv = 5000;
                    } else if (i.dWu > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.dWv = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = i.dWv = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.dWv < 1000) {
                int unused5 = i.dWv = 1000;
            }
            try {
                h.aDf().aDg();
                for (ImMessageCenterPojo imMessageCenterPojo : aDl) {
                    if (isCancelled()) {
                        h.aDf().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aCY().ae(imMessageCenterPojo.getGid(), i.dWv);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aDq().ae(imMessageCenterPojo.getGid(), i.dWv);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aDo().ae(imMessageCenterPojo.getGid(), i.dWv);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aCZ().ae(imMessageCenterPojo.getGid(), i.dWv);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aDf().endTransaction();
            }
            return true;
        }
    }
}
