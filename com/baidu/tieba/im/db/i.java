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
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i eqt;
    private static long eqw = -1;
    private static int eqx = 0;
    private a equ = new a();
    private b eqv = null;

    public static i aJF() {
        if (eqt == null) {
            synchronized (i.class) {
                if (eqt == null) {
                    eqt = new i();
                }
            }
        }
        return eqt;
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
                    i.aJF().equ.removeMessages(1);
                    i.aJF().execute();
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
                        i.this.equ.sendMessageDelayed(i.this.equ.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.equ.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eqv != null) {
            this.eqv.cancel();
            this.eqv = null;
        }
        this.eqv = new b();
        this.eqv.setParallel(TiebaIMConfig.getParallel());
        this.eqv.setPriority(4);
        this.eqv.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eqv != null) {
            this.eqv.cancel();
            this.eqv = null;
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
            LinkedList<ImMessageCenterPojo> aJJ = j.aJG().aJJ();
            if (aJJ == null || aJJ.size() == 0) {
                return false;
            }
            if (i.eqw < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eqw = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eqw > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.eqx = 5000;
                    } else if (i.eqw > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eqx = 3000;
                    } else {
                        int unused4 = i.eqx = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eqx < 1000) {
                int unused5 = i.eqx = 1000;
            }
            try {
                h.aJD().aJE();
                for (ImMessageCenterPojo imMessageCenterPojo : aJJ) {
                    if (isCancelled()) {
                        h.aJD().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aJw().ac(imMessageCenterPojo.getGid(), i.eqx);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aJO().ac(imMessageCenterPojo.getGid(), i.eqx);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aJM().ac(imMessageCenterPojo.getGid(), i.eqx);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aJx().ac(imMessageCenterPojo.getGid(), i.eqx);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aJD().endTransaction();
            }
            return true;
        }
    }
}
