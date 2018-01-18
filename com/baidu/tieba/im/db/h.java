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
    private static h ewU;
    private static long ewX = -1;
    private static int ewY = 0;
    private a ewV = new a();
    private b ewW = null;

    public static h aGD() {
        if (ewU == null) {
            synchronized (h.class) {
                if (ewU == null) {
                    ewU = new h();
                }
            }
        }
        return ewU;
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
                    h.aGD().ewV.removeMessages(1);
                    h.aGD().execute();
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
                        h.this.ewV.sendMessageDelayed(h.this.ewV.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.ewV.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.ewW != null) {
            this.ewW.cancel();
            this.ewW = null;
        }
        this.ewW = new b();
        this.ewW.setParallel(TiebaIMConfig.getParallel());
        this.ewW.setPriority(4);
        this.ewW.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.ewW != null) {
            this.ewW.cancel();
            this.ewW = null;
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
            LinkedList<ImMessageCenterPojo> aGI = i.aGF().aGI();
            if (aGI == null || aGI.size() == 0) {
                return false;
            }
            if (h.ewX < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.ewX = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.ewX > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.ewY = 5000;
                    } else if (h.ewX > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.ewY = PushConstants.WORK_RECEIVER_EVENTCORE_ERROR;
                    } else {
                        int unused4 = h.ewY = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.ewY < 1000) {
                int unused5 = h.ewY = 1000;
            }
            try {
                g.aGB().aGC();
                for (ImMessageCenterPojo imMessageCenterPojo : aGI) {
                    if (isCancelled()) {
                        g.aGB().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aGx().ae(imMessageCenterPojo.getGid(), h.ewY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.aGM().ae(imMessageCenterPojo.getGid(), h.ewY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aGL().ae(imMessageCenterPojo.getGid(), h.ewY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aGy().ae(imMessageCenterPojo.getGid(), h.ewY);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aGB().endTransaction();
            }
            return true;
        }
    }
}
