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
    private static h dmO;
    private static long dmR = -1;
    private static int dmS = 0;
    private a dmP = new a();
    private b dmQ = null;

    public static h atX() {
        if (dmO == null) {
            synchronized (h.class) {
                if (dmO == null) {
                    dmO = new h();
                }
            }
        }
        return dmO;
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
                    h.atX().dmP.removeMessages(1);
                    h.atX().execute();
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
                        h.this.dmP.sendMessageDelayed(h.this.dmP.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dmP.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dmQ != null) {
            this.dmQ.cancel();
            this.dmQ = null;
        }
        this.dmQ = new b();
        this.dmQ.setParallel(TiebaIMConfig.getParallel());
        this.dmQ.setPriority(4);
        this.dmQ.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dmQ != null) {
            this.dmQ.cancel();
            this.dmQ = null;
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
            LinkedList<ImMessageCenterPojo> aub = i.atY().aub();
            if (aub == null || aub.size() == 0) {
                return false;
            }
            if (h.dmR < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dmR = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dmR > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dmS = 5000;
                    } else if (h.dmR > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dmS = 3000;
                    } else {
                        int unused4 = h.dmS = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dmS < 1000) {
                int unused5 = h.dmS = 1000;
            }
            try {
                g.atV().atW();
                for (ImMessageCenterPojo imMessageCenterPojo : aub) {
                    if (isCancelled()) {
                        g.atV().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.atR().S(imMessageCenterPojo.getGid(), h.dmS);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.aue().S(imMessageCenterPojo.getGid(), h.dmS);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aud().S(imMessageCenterPojo.getGid(), h.dmS);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.atS().S(imMessageCenterPojo.getGid(), h.dmS);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.atV().endTransaction();
            }
            return true;
        }
    }
}
