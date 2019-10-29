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
    private static i gFl;
    private static long gFo = -1;
    private static int gFp = 0;
    private a gFm = new a();
    private b gFn = null;

    public static i bAv() {
        if (gFl == null) {
            synchronized (i.class) {
                if (gFl == null) {
                    gFl = new i();
                }
            }
        }
        return gFl;
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
                    i.bAv().gFm.removeMessages(1);
                    i.bAv().execute();
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
                        i.this.gFm.sendMessageDelayed(i.this.gFm.obtainMessage(1), StatisticConfig.MIN_UPLOAD_INTERVAL);
                        return;
                    }
                    i.this.gFm.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.gFn != null) {
            this.gFn.cancel();
            this.gFn = null;
        }
        this.gFn = new b();
        this.gFn.setParallel(TiebaIMConfig.getParallel());
        this.gFn.setPriority(4);
        this.gFn.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.gFn != null) {
            this.gFn.cancel();
            this.gFn = null;
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
            LinkedList<ImMessageCenterPojo> bAA = j.bAx().bAA();
            if (bAA == null || bAA.size() == 0) {
                return false;
            }
            if (i.gFo < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.gFo = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.gFo > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.gFp = 5000;
                    } else if (i.gFo > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.gFp = 3000;
                    } else {
                        int unused4 = i.gFp = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.gFp < 1000) {
                int unused5 = i.gFp = 1000;
            }
            try {
                h.bAs().bAt();
                for (ImMessageCenterPojo imMessageCenterPojo : bAA) {
                    if (isCancelled()) {
                        h.bAs().bAu();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bAl().aC(imMessageCenterPojo.getGid(), i.gFp);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bAF().aC(imMessageCenterPojo.getGid(), i.gFp);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bAD().aC(imMessageCenterPojo.getGid(), i.gFp);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bAm().aC(imMessageCenterPojo.getGid(), i.gFp);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bAs().bAu();
            }
            return true;
        }
    }
}
