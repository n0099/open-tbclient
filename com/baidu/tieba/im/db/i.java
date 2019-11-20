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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i gEu;
    private static long gEx = -1;
    private static int gEy = 0;
    private a gEv = new a();
    private b gEw = null;

    public static i bAt() {
        if (gEu == null) {
            synchronized (i.class) {
                if (gEu == null) {
                    gEu = new i();
                }
            }
        }
        return gEu;
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
                    i.bAt().gEv.removeMessages(1);
                    i.bAt().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private i() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.db.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        i.this.gEv.sendMessageDelayed(i.this.gEv.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.gEv.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.gEw != null) {
            this.gEw.cancel();
            this.gEw = null;
        }
        this.gEw = new b();
        this.gEw.setParallel(TiebaIMConfig.getParallel());
        this.gEw.setPriority(4);
        this.gEw.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.gEw != null) {
            this.gEw.cancel();
            this.gEw = null;
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
            LinkedList<ImMessageCenterPojo> bAy = j.bAv().bAy();
            if (bAy == null || bAy.size() == 0) {
                return false;
            }
            if (i.gEx < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.gEx = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.gEx > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.gEy = 5000;
                    } else if (i.gEx > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.gEy = 3000;
                    } else {
                        int unused4 = i.gEy = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.gEy < 1000) {
                int unused5 = i.gEy = 1000;
            }
            try {
                h.bAq().bAr();
                for (ImMessageCenterPojo imMessageCenterPojo : bAy) {
                    if (isCancelled()) {
                        h.bAq().bAs();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bAj().aC(imMessageCenterPojo.getGid(), i.gEy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bAD().aC(imMessageCenterPojo.getGid(), i.gEy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bAB().aC(imMessageCenterPojo.getGid(), i.gEy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bAk().aC(imMessageCenterPojo.getGid(), i.gEy);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bAq().bAs();
            }
            return true;
        }
    }
}
