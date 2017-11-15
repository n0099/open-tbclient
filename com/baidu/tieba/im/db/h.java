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
    private static h dAv;
    private static long dAy = -1;
    private static int dAz = 0;
    private a dAw = new a();
    private b dAx = null;

    public static h axO() {
        if (dAv == null) {
            synchronized (h.class) {
                if (dAv == null) {
                    dAv = new h();
                }
            }
        }
        return dAv;
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
                    h.axO().dAw.removeMessages(1);
                    h.axO().execute();
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
                        h.this.dAw.sendMessageDelayed(h.this.dAw.obtainMessage(1), 30000L);
                        return;
                    }
                    h.this.dAw.removeMessages(1);
                    h.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.dAx != null) {
            this.dAx.cancel();
            this.dAx = null;
        }
        this.dAx = new b();
        this.dAx.setParallel(TiebaIMConfig.getParallel());
        this.dAx.setPriority(4);
        this.dAx.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dAx != null) {
            this.dAx.cancel();
            this.dAx = null;
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
            LinkedList<ImMessageCenterPojo> axT = i.axQ().axT();
            if (axT == null || axT.size() == 0) {
                return false;
            }
            if (h.dAy < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = h.dAy = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.dAy > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = h.dAz = 5000;
                    } else if (h.dAy > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = h.dAz = 3000;
                    } else {
                        int unused4 = h.dAz = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.dAz < 1000) {
                int unused5 = h.dAz = 1000;
            }
            try {
                g.axM().axN();
                for (ImMessageCenterPojo imMessageCenterPojo : axT) {
                    if (isCancelled()) {
                        g.axM().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.axI().X(imMessageCenterPojo.getGid(), h.dAz);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.axX().X(imMessageCenterPojo.getGid(), h.dAz);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.axW().X(imMessageCenterPojo.getGid(), h.dAz);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.axJ().X(imMessageCenterPojo.getGid(), h.dAz);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.axM().endTransaction();
            }
            return true;
        }
    }
}
