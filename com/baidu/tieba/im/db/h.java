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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class h {
    private static h dAb;
    private static long dAe = -1;
    private static int dAf = 0;
    private a dAc = new a();
    private b dAd = null;

    public static h axx() {
        if (dAb == null) {
            synchronized (h.class) {
                if (dAb == null) {
                    dAb = new h();
                }
            }
        }
        return dAb;
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
                    h.axx().dAc.removeMessages(1);
                    h.axx().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private h() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.db.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        h.this.dAc.sendMessageDelayed(h.this.dAc.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dAc.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dAd != null) {
            this.dAd.cancel();
            this.dAd = null;
        }
        this.dAd = new b();
        this.dAd.setParallel(TiebaIMConfig.getParallel());
        this.dAd.setPriority(4);
        this.dAd.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dAd != null) {
            this.dAd.cancel();
            this.dAd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [179=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> axC = i.axz().axC();
            if (axC == null || axC.size() == 0) {
                return false;
            }
            if (h.dAe < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dAe = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dAe > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dAf = 5000;
                    } else if (h.dAe > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dAf = 3000;
                    } else {
                        int unused4 = h.dAf = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dAf < 1000) {
                int unused5 = h.dAf = 1000;
            }
            try {
                g.axv().axw();
                for (ImMessageCenterPojo imMessageCenterPojo : axC) {
                    if (isCancelled()) {
                        g.axv().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.axr().X(imMessageCenterPojo.getGid(), h.dAf);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.axF().X(imMessageCenterPojo.getGid(), h.dAf);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.axE().X(imMessageCenterPojo.getGid(), h.dAf);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.axs().X(imMessageCenterPojo.getGid(), h.dAf);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.axv().endTransaction();
            }
            return true;
        }
    }
}
