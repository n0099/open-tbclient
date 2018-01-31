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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class h {
    private static h exp;
    private static long exs = -1;
    private static int exu = 0;
    private a exq = new a();
    private b exr = null;

    public static h aGI() {
        if (exp == null) {
            synchronized (h.class) {
                if (exp == null) {
                    exp = new h();
                }
            }
        }
        return exp;
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
                    h.aGI().exq.removeMessages(1);
                    h.aGI().execute();
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
                        h.this.exq.sendMessageDelayed(h.this.exq.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.exq.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.exr != null) {
            this.exr.cancel();
            this.exr = null;
        }
        this.exr = new b();
        this.exr.setParallel(TiebaIMConfig.getParallel());
        this.exr.setPriority(4);
        this.exr.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.exr != null) {
            this.exr.cancel();
            this.exr = null;
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
            LinkedList<ImMessageCenterPojo> aGN = i.aGK().aGN();
            if (aGN == null || aGN.size() == 0) {
                return false;
            }
            if (h.exs < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.exs = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.exs > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.exu = 5000;
                    } else if (h.exs > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.exu = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = h.exu = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.exu < 1000) {
                int unused5 = h.exu = 1000;
            }
            try {
                g.aGG().aGH();
                for (ImMessageCenterPojo imMessageCenterPojo : aGN) {
                    if (isCancelled()) {
                        g.aGG().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aGC().ae(imMessageCenterPojo.getGid(), h.exu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.aGR().ae(imMessageCenterPojo.getGid(), h.exu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aGQ().ae(imMessageCenterPojo.getGid(), h.exu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aGD().ae(imMessageCenterPojo.getGid(), h.exu);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aGG().endTransaction();
            }
            return true;
        }
    }
}
