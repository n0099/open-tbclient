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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class i {
    private static i iQh;
    private static long iQk = -1;
    private static int iQl = 0;
    private a iQi = new a();
    private b iQj = null;

    public static i cpK() {
        if (iQh == null) {
            synchronized (i.class) {
                if (iQh == null) {
                    iQh = new i();
                }
            }
        }
        return iQh;
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
                    i.cpK().iQi.removeMessages(1);
                    i.cpK().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private i() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.im.db.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        i.this.iQi.sendMessageDelayed(i.this.iQi.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.iQi.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.iQj != null) {
            this.iQj.cancel();
            this.iQj = null;
        }
        this.iQj = new b();
        this.iQj.setParallel(TiebaIMConfig.getParallel());
        this.iQj.setPriority(4);
        this.iQj.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.iQj != null) {
            this.iQj.cancel();
            this.iQj = null;
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
            LinkedList<ImMessageCenterPojo> cpO = j.cpL().cpO();
            if (cpO == null || cpO.size() == 0) {
                return false;
            }
            if (i.iQk < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.iQk = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.iQk > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.iQl = 5000;
                    } else if (i.iQk > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.iQl = 3000;
                    } else {
                        int unused4 = i.iQl = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.iQl < 1000) {
                int unused5 = i.iQl = 1000;
            }
            try {
                h.cpH().cpI();
                for (ImMessageCenterPojo imMessageCenterPojo : cpO) {
                    if (isCancelled()) {
                        h.cpH().cpJ();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.cpA().aU(imMessageCenterPojo.getGid(), i.iQl);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.cpT().aU(imMessageCenterPojo.getGid(), i.iQl);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.cpR().aU(imMessageCenterPojo.getGid(), i.iQl);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.cpB().aU(imMessageCenterPojo.getGid(), i.iQl);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.cpH().cpJ();
            }
            return true;
        }
    }
}
