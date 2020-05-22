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
    private static i iyp;
    private static long iys = -1;
    private static int iyt = 0;
    private a iyq = new a();
    private b iyr = null;

    public static i clL() {
        if (iyp == null) {
            synchronized (i.class) {
                if (iyp == null) {
                    iyp = new i();
                }
            }
        }
        return iyp;
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
                    i.clL().iyq.removeMessages(1);
                    i.clL().execute();
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
                        i.this.iyq.sendMessageDelayed(i.this.iyq.obtainMessage(1), 30000L);
                        return;
                    }
                    i.this.iyq.removeMessages(1);
                    i.this.stop();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.iyr != null) {
            this.iyr.cancel();
            this.iyr = null;
        }
        this.iyr = new b();
        this.iyr.setParallel(TiebaIMConfig.getParallel());
        this.iyr.setPriority(4);
        this.iyr.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.iyr != null) {
            this.iyr.cancel();
            this.iyr = null;
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
            LinkedList<ImMessageCenterPojo> clP = j.clM().clP();
            if (clP == null || clP.size() == 0) {
                return false;
            }
            if (i.iys < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    long unused = i.iys = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (i.iys > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        int unused2 = i.iyt = 5000;
                    } else if (i.iys > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        int unused3 = i.iyt = 3000;
                    } else {
                        int unused4 = i.iyt = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (i.iyt < 1000) {
                int unused5 = i.iyt = 1000;
            }
            try {
                h.clI().clJ();
                for (ImMessageCenterPojo imMessageCenterPojo : clP) {
                    if (isCancelled()) {
                        h.clI().clK();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.clB().aV(imMessageCenterPojo.getGid(), i.iyt);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.clU().aV(imMessageCenterPojo.getGid(), i.iyt);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.clS().aV(imMessageCenterPojo.getGid(), i.iyt);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.clC().aV(imMessageCenterPojo.getGid(), i.iyt);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                h.clI().clK();
            }
            return true;
        }
    }
}
