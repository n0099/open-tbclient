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
import com.kwai.video.player.KsMediaMeta;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    private static i kFh;
    private static long kFk = -1;
    private static int kFl = 0;
    private a kFi = new a();
    private b kFj = null;

    public static i cVJ() {
        if (kFh == null) {
            synchronized (i.class) {
                if (kFh == null) {
                    kFh = new i();
                }
            }
        }
        return kFh;
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
                    i.cVJ().kFi.removeMessages(1);
                    i.cVJ().execute();
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
                        i.this.kFi.sendMessageDelayed(i.this.kFi.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kFi.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kFj != null) {
            this.kFj.cancel();
            this.kFj = null;
        }
        this.kFj = new b();
        this.kFj.setParallel(TiebaIMConfig.getParallel());
        this.kFj.setPriority(4);
        this.kFj.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kFj != null) {
            this.kFj.cancel();
            this.kFj = null;
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
            LinkedList<ImMessageCenterPojo> cVN = j.cVK().cVN();
            if (cVN == null || cVN.size() == 0) {
                return false;
            }
            if (i.kFk < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kFk = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kFk > KsMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.kFl = 5000;
                    } else if (i.kFk > KsMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.kFl = 3000;
                    } else {
                        int unused4 = i.kFl = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kFl < 1000) {
                int unused5 = i.kFl = 1000;
            }
            try {
                h.cVG().cVH();
                for (ImMessageCenterPojo imMessageCenterPojo : cVN) {
                    if (isCancelled()) {
                        h.cVG().cVI();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cVz().bi(imMessageCenterPojo.getGid(), i.kFl);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cVT().bi(imMessageCenterPojo.getGid(), i.kFl);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cVQ().bi(imMessageCenterPojo.getGid(), i.kFl);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cVA().bi(imMessageCenterPojo.getGid(), i.kFl);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cVG().cVI();
            }
            return true;
        }
    }
}
