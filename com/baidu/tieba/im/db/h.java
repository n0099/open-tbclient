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
    private static h dlw;
    private a dlx = new a();
    private b dly = null;
    private static long dlz = -1;
    private static int dlA = 0;

    public static h atL() {
        if (dlw == null) {
            synchronized (h.class) {
                if (dlw == null) {
                    dlw = new h();
                }
            }
        }
        return dlw;
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
                    h.atL().dlx.removeMessages(1);
                    h.atL().execute();
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
                        h.this.dlx.sendMessageDelayed(h.this.dlx.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dlx.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dly != null) {
            this.dly.cancel();
            this.dly = null;
        }
        this.dly = new b();
        this.dly.setParallel(TiebaIMConfig.getParallel());
        this.dly.setPriority(4);
        this.dly.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dly != null) {
            this.dly.cancel();
            this.dly = null;
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
            LinkedList<ImMessageCenterPojo> atQ = i.atN().atQ();
            if (atQ == null || atQ.size() == 0) {
                return false;
            }
            if (h.dlz < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dlz = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dlz > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dlA = 5000;
                    } else if (h.dlz > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dlA = 3000;
                    } else {
                        int unused4 = h.dlA = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dlA < 1000) {
                int unused5 = h.dlA = 1000;
            }
            try {
                g.atJ().atK();
                for (ImMessageCenterPojo imMessageCenterPojo : atQ) {
                    if (isCancelled()) {
                        g.atJ().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.atF().S(imMessageCenterPojo.getGid(), h.dlA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.atT().S(imMessageCenterPojo.getGid(), h.dlA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.atS().S(imMessageCenterPojo.getGid(), h.dlA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.atG().S(imMessageCenterPojo.getGid(), h.dlA);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.atJ().endTransaction();
            }
            return true;
        }
    }
}
