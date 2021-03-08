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
    private static i kHj;
    private static long kHm = -1;
    private static int kHn = 0;
    private a kHk = new a();
    private b kHl = null;

    public static i cVQ() {
        if (kHj == null) {
            synchronized (i.class) {
                if (kHj == null) {
                    kHj = new i();
                }
            }
        }
        return kHj;
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
                    i.cVQ().kHk.removeMessages(1);
                    i.cVQ().execute();
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
                        i.this.kHk.sendMessageDelayed(i.this.kHk.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.kHk.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.kHl != null) {
            this.kHl.cancel();
            this.kHl = null;
        }
        this.kHl = new b();
        this.kHl.setParallel(TiebaIMConfig.getParallel());
        this.kHl.setPriority(4);
        this.kHl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.kHl != null) {
            this.kHl.cancel();
            this.kHl = null;
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
            LinkedList<ImMessageCenterPojo> cVU = j.cVR().cVU();
            if (cVU == null || cVU.size() == 0) {
                return false;
            }
            if (i.kHm < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.kHm = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.kHm > KsMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.kHn = 5000;
                    } else if (i.kHm > KsMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.kHn = 3000;
                    } else {
                        int unused4 = i.kHn = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.kHn < 1000) {
                int unused5 = i.kHn = 1000;
            }
            try {
                h.cVN().cVO();
                for (ImMessageCenterPojo imMessageCenterPojo : cVU) {
                    if (isCancelled()) {
                        h.cVN().cVP();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cVG().bi(imMessageCenterPojo.getGid(), i.kHn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cWa().bi(imMessageCenterPojo.getGid(), i.kHn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cVX().bi(imMessageCenterPojo.getGid(), i.kHn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cVH().bi(imMessageCenterPojo.getGid(), i.kHn);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cVN().cVP();
            }
            return true;
        }
    }
}
