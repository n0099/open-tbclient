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
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i hwa;
    private static long hwd = -1;
    private static int hwe = 0;
    private a hwb = new a();
    private b hwc = null;

    public static i bSS() {
        if (hwa == null) {
            synchronized (i.class) {
                if (hwa == null) {
                    hwa = new i();
                }
            }
        }
        return hwa;
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
                    i.bSS().hwb.removeMessages(1);
                    i.bSS().execute();
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
                        i.this.hwb.sendMessageDelayed(i.this.hwb.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.hwb.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.hwc != null) {
            this.hwc.cancel();
            this.hwc = null;
        }
        this.hwc = new b();
        this.hwc.setParallel(TiebaIMConfig.getParallel());
        this.hwc.setPriority(4);
        this.hwc.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.hwc != null) {
            this.hwc.cancel();
            this.hwc = null;
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
            LinkedList<ImMessageCenterPojo> bSW = j.bST().bSW();
            if (bSW == null || bSW.size() == 0) {
                return false;
            }
            if (i.hwd < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.hwd = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.hwd > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.hwe = 5000;
                    } else if (i.hwd > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.hwe = 3000;
                    } else {
                        int unused4 = i.hwe = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.hwe < 1000) {
                int unused5 = i.hwe = 1000;
            }
            try {
                h.bSP().bSQ();
                for (ImMessageCenterPojo imMessageCenterPojo : bSW) {
                    if (isCancelled()) {
                        h.bSP().bSR();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.bSI().aM(imMessageCenterPojo.getGid(), i.hwe);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.bTb().aM(imMessageCenterPojo.getGid(), i.hwe);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.bSZ().aM(imMessageCenterPojo.getGid(), i.hwe);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.bSJ().aM(imMessageCenterPojo.getGid(), i.hwe);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.bSP().bSR();
            }
            return true;
        }
    }
}
