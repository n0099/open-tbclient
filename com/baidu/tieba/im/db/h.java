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
    private static h dJm;
    private static long dJp = -1;
    private static int dJq = 0;
    private a dJn = new a();
    private b dJo = null;

    public static h azw() {
        if (dJm == null) {
            synchronized (h.class) {
                if (dJm == null) {
                    dJm = new h();
                }
            }
        }
        return dJm;
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
                    h.azw().dJn.removeMessages(1);
                    h.azw().execute();
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
                        h.this.dJn.sendMessageDelayed(h.this.dJn.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dJn.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dJo != null) {
            this.dJo.cancel();
            this.dJo = null;
        }
        this.dJo = new b();
        this.dJo.setParallel(TiebaIMConfig.getParallel());
        this.dJo.setPriority(4);
        this.dJo.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dJo != null) {
            this.dJo.cancel();
            this.dJo = null;
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
            LinkedList<ImMessageCenterPojo> azB = i.azy().azB();
            if (azB == null || azB.size() == 0) {
                return false;
            }
            if (h.dJp < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dJp = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dJp > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dJq = 5000;
                    } else if (h.dJp > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dJq = 3000;
                    } else {
                        int unused4 = h.dJq = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dJq < 1000) {
                int unused5 = h.dJq = 1000;
            }
            try {
                g.azu().azv();
                for (ImMessageCenterPojo imMessageCenterPojo : azB) {
                    if (isCancelled()) {
                        g.azu().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.azq().aa(imMessageCenterPojo.getGid(), h.dJq);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.azF().aa(imMessageCenterPojo.getGid(), h.dJq);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.azE().aa(imMessageCenterPojo.getGid(), h.dJq);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.azr().aa(imMessageCenterPojo.getGid(), h.dJq);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.azu().endTransaction();
            }
            return true;
        }
    }
}
