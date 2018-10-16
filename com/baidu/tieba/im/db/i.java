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
    private static long eFB = -1;
    private static int eFC = 0;
    private static i eFy;
    private a eFz = new a();
    private b eFA = null;

    public static i aPj() {
        if (eFy == null) {
            synchronized (i.class) {
                if (eFy == null) {
                    eFy = new i();
                }
            }
        }
        return eFy;
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
                    i.aPj().eFz.removeMessages(1);
                    i.aPj().execute();
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
                        i.this.eFz.sendMessageDelayed(i.this.eFz.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.eFz.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.eFA != null) {
            this.eFA.cancel();
            this.eFA = null;
        }
        this.eFA = new b();
        this.eFA.setParallel(TiebaIMConfig.getParallel());
        this.eFA.setPriority(4);
        this.eFA.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.eFA != null) {
            this.eFA.cancel();
            this.eFA = null;
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
            LinkedList<ImMessageCenterPojo> aPn = j.aPk().aPn();
            if (aPn == null || aPn.size() == 0) {
                return false;
            }
            if (i.eFB < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.eFB = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.eFB > 2147483648L) {
                        int unused2 = i.eFC = 5000;
                    } else if (i.eFB > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.eFC = 3000;
                    } else {
                        int unused4 = i.eFC = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.eFC < 1000) {
                int unused5 = i.eFC = 1000;
            }
            try {
                h.aPh().aPi();
                for (ImMessageCenterPojo imMessageCenterPojo : aPn) {
                    if (isCancelled()) {
                        h.aPh().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aPa().al(imMessageCenterPojo.getGid(), i.eFC);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aPs().al(imMessageCenterPojo.getGid(), i.eFC);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aPq().al(imMessageCenterPojo.getGid(), i.eFC);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aPb().al(imMessageCenterPojo.getGid(), i.eFC);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.aPh().endTransaction();
            }
            return true;
        }
    }
}
