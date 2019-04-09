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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i ghd;
    private static long ghg = -1;
    private static int ghh = 0;
    private a ghe = new a();
    private b ghf = null;

    public static i bsn() {
        if (ghd == null) {
            synchronized (i.class) {
                if (ghd == null) {
                    ghd = new i();
                }
            }
        }
        return ghd;
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
                    i.bsn().ghe.removeMessages(1);
                    i.bsn().execute();
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
                        i.this.ghe.sendMessageDelayed(i.this.ghe.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.ghe.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.ghf != null) {
            this.ghf.cancel();
            this.ghf = null;
        }
        this.ghf = new b();
        this.ghf.setParallel(TiebaIMConfig.getParallel());
        this.ghf.setPriority(4);
        this.ghf.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.ghf != null) {
            this.ghf.cancel();
            this.ghf = null;
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
            LinkedList<ImMessageCenterPojo> bsr = j.bso().bsr();
            if (bsr == null || bsr.size() == 0) {
                return false;
            }
            if (i.ghg < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.ghg = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.ghg > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.ghh = UIMsg.m_AppUI.MSG_APP_GPS;
                    } else if (i.ghg > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.ghh = 3000;
                    } else {
                        int unused4 = i.ghh = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.ghh < 1000) {
                int unused5 = i.ghh = 1000;
            }
            try {
                h.bsl().bsm();
                for (ImMessageCenterPojo imMessageCenterPojo : bsr) {
                    if (isCancelled()) {
                        h.bsl().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bse().aI(imMessageCenterPojo.getGid(), i.ghh);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bsw().aI(imMessageCenterPojo.getGid(), i.ghh);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bsu().aI(imMessageCenterPojo.getGid(), i.ghh);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bsf().aI(imMessageCenterPojo.getGid(), i.ghh);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bsl().endTransaction();
            }
            return true;
        }
    }
}
