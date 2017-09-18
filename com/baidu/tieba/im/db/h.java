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
    private static h dwj;
    private static long dwm = -1;
    private static int dwn = 0;
    private a dwk = new a();
    private b dwl = null;

    public static h aww() {
        if (dwj == null) {
            synchronized (h.class) {
                if (dwj == null) {
                    dwj = new h();
                }
            }
        }
        return dwj;
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
                    h.aww().dwk.removeMessages(1);
                    h.aww().execute();
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
                        h.this.dwk.sendMessageDelayed(h.this.dwk.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dwk.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dwl != null) {
            this.dwl.cancel();
            this.dwl = null;
        }
        this.dwl = new b();
        this.dwl.setParallel(TiebaIMConfig.getParallel());
        this.dwl.setPriority(4);
        this.dwl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dwl != null) {
            this.dwl.cancel();
            this.dwl = null;
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
            LinkedList<ImMessageCenterPojo> awB = i.awy().awB();
            if (awB == null || awB.size() == 0) {
                return false;
            }
            if (h.dwm < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dwm = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dwm > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dwn = 5000;
                    } else if (h.dwm > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dwn = 3000;
                    } else {
                        int unused4 = h.dwn = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dwn < 1000) {
                int unused5 = h.dwn = 1000;
            }
            try {
                g.awu().awv();
                for (ImMessageCenterPojo imMessageCenterPojo : awB) {
                    if (isCancelled()) {
                        g.awu().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.awq().S(imMessageCenterPojo.getGid(), h.dwn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.awE().S(imMessageCenterPojo.getGid(), h.dwn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.awD().S(imMessageCenterPojo.getGid(), h.dwn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.awr().S(imMessageCenterPojo.getGid(), h.dwn);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.awu().endTransaction();
            }
            return true;
        }
    }
}
