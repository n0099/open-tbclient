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
    private static long dsC = -1;
    private static int dsD = 0;
    private static h dsz;
    private a dsA = new a();
    private b dsB = null;

    public static h avh() {
        if (dsz == null) {
            synchronized (h.class) {
                if (dsz == null) {
                    dsz = new h();
                }
            }
        }
        return dsz;
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
                    h.avh().dsA.removeMessages(1);
                    h.avh().execute();
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
                        h.this.dsA.sendMessageDelayed(h.this.dsA.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dsA.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dsB != null) {
            this.dsB.cancel();
            this.dsB = null;
        }
        this.dsB = new b();
        this.dsB.setParallel(TiebaIMConfig.getParallel());
        this.dsB.setPriority(4);
        this.dsB.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dsB != null) {
            this.dsB.cancel();
            this.dsB = null;
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
            LinkedList<ImMessageCenterPojo> avm = i.avj().avm();
            if (avm == null || avm.size() == 0) {
                return false;
            }
            if (h.dsC < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dsC = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dsC > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dsD = 5000;
                    } else if (h.dsC > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dsD = 3000;
                    } else {
                        int unused4 = h.dsD = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dsD < 1000) {
                int unused5 = h.dsD = 1000;
            }
            try {
                g.avf().avg();
                for (ImMessageCenterPojo imMessageCenterPojo : avm) {
                    if (isCancelled()) {
                        g.avf().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.avb().R(imMessageCenterPojo.getGid(), h.dsD);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.avp().R(imMessageCenterPojo.getGid(), h.dsD);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.avo().R(imMessageCenterPojo.getGid(), h.dsD);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.avc().R(imMessageCenterPojo.getGid(), h.dsD);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.avf().endTransaction();
            }
            return true;
        }
    }
}
