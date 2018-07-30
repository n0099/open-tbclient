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
    private static long eqA = -1;
    private static int eqB = 0;
    private static i eqx;
    private a eqy = new a();
    private b eqz = null;

    public static i aJI() {
        if (eqx == null) {
            synchronized (i.class) {
                if (eqx == null) {
                    eqx = new i();
                }
            }
        }
        return eqx;
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
                    i.aJI().eqy.removeMessages(1);
                    i.aJI().execute();
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
                        i.this.eqy.sendMessageDelayed(i.this.eqy.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.eqy.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eqz != null) {
            this.eqz.cancel();
            this.eqz = null;
        }
        this.eqz = new b();
        this.eqz.setParallel(TiebaIMConfig.getParallel());
        this.eqz.setPriority(4);
        this.eqz.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eqz != null) {
            this.eqz.cancel();
            this.eqz = null;
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
            LinkedList<ImMessageCenterPojo> aJM = j.aJJ().aJM();
            if (aJM == null || aJM.size() == 0) {
                return false;
            }
            if (i.eqA < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eqA = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eqA > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.eqB = 5000;
                    } else if (i.eqA > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eqB = 3000;
                    } else {
                        int unused4 = i.eqB = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eqB < 1000) {
                int unused5 = i.eqB = 1000;
            }
            try {
                h.aJG().aJH();
                for (ImMessageCenterPojo imMessageCenterPojo : aJM) {
                    if (isCancelled()) {
                        h.aJG().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aJz().ac(imMessageCenterPojo.getGid(), i.eqB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aJR().ac(imMessageCenterPojo.getGid(), i.eqB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aJP().ac(imMessageCenterPojo.getGid(), i.eqB);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aJA().ac(imMessageCenterPojo.getGid(), i.eqB);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aJG().endTransaction();
            }
            return true;
        }
    }
}
