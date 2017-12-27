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
    private static h evw;
    private a evx = new a();
    private b evy = null;
    private static long evz = -1;
    private static int evA = 0;

    public static h aGy() {
        if (evw == null) {
            synchronized (h.class) {
                if (evw == null) {
                    evw = new h();
                }
            }
        }
        return evw;
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
                    h.aGy().evx.removeMessages(1);
                    h.aGy().execute();
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
                        h.this.evx.sendMessageDelayed(h.this.evx.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.evx.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.evy != null) {
            this.evy.cancel();
            this.evy = null;
        }
        this.evy = new b();
        this.evy.setParallel(TiebaIMConfig.getParallel());
        this.evy.setPriority(4);
        this.evy.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.evy != null) {
            this.evy.cancel();
            this.evy = null;
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
            LinkedList<ImMessageCenterPojo> aGD = i.aGA().aGD();
            if (aGD == null || aGD.size() == 0) {
                return false;
            }
            if (h.evz < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.evz = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.evz > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.evA = 5000;
                    } else if (h.evz > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.evA = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = h.evA = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.evA < 1000) {
                int unused5 = h.evA = 1000;
            }
            try {
                g.aGw().aGx();
                for (ImMessageCenterPojo imMessageCenterPojo : aGD) {
                    if (isCancelled()) {
                        g.aGw().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aGs().ac(imMessageCenterPojo.getGid(), h.evA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.aGH().ac(imMessageCenterPojo.getGid(), h.evA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aGG().ac(imMessageCenterPojo.getGid(), h.evA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aGt().ac(imMessageCenterPojo.getGid(), h.evA);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aGw().endTransaction();
            }
            return true;
        }
    }
}
