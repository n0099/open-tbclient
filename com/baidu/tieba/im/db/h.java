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
    private static h dIj;
    private static long dIm = -1;
    private static int dIn = 0;
    private a dIk = new a();
    private b dIl = null;

    public static h azo() {
        if (dIj == null) {
            synchronized (h.class) {
                if (dIj == null) {
                    dIj = new h();
                }
            }
        }
        return dIj;
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
                    h.azo().dIk.removeMessages(1);
                    h.azo().execute();
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
                        h.this.dIk.sendMessageDelayed(h.this.dIk.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dIk.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dIl != null) {
            this.dIl.cancel();
            this.dIl = null;
        }
        this.dIl = new b();
        this.dIl.setParallel(TiebaIMConfig.getParallel());
        this.dIl.setPriority(4);
        this.dIl.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dIl != null) {
            this.dIl.cancel();
            this.dIl = null;
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
            LinkedList<ImMessageCenterPojo> azt = i.azq().azt();
            if (azt == null || azt.size() == 0) {
                return false;
            }
            if (h.dIm < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dIm = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dIm > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dIn = 5000;
                    } else if (h.dIm > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dIn = 3000;
                    } else {
                        int unused4 = h.dIn = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dIn < 1000) {
                int unused5 = h.dIn = 1000;
            }
            try {
                g.azm().azn();
                for (ImMessageCenterPojo imMessageCenterPojo : azt) {
                    if (isCancelled()) {
                        g.azm().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.azi().Z(imMessageCenterPojo.getGid(), h.dIn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.azx().Z(imMessageCenterPojo.getGid(), h.dIn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.azw().Z(imMessageCenterPojo.getGid(), h.dIn);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.azj().Z(imMessageCenterPojo.getGid(), h.dIn);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.azm().endTransaction();
            }
            return true;
        }
    }
}
