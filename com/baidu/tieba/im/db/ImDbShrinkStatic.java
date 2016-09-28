package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic daB;
    private static long daE = -1;
    private static int daF = 0;
    private a daC = new a(null);
    private b daD = null;

    static {
        asK();
    }

    public static ImDbShrinkStatic asK() {
        if (daB == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (daB == null) {
                    daB = new ImDbShrinkStatic();
                }
            }
        }
        return daB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends Handler {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    ImDbShrinkStatic.asK().daC.removeMessages(1);
                    ImDbShrinkStatic.asK().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.daD != null) {
            this.daD.cancel();
            this.daD = null;
        }
        this.daD = new b(this, null);
        this.daD.setParallel(TiebaIMConfig.getParallel());
        this.daD.setPriority(4);
        this.daD.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.daD != null) {
            this.daD.cancel();
            this.daD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* synthetic */ b(ImDbShrinkStatic imDbShrinkStatic, b bVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> asQ = i.asN().asQ();
            if (asQ == null || asQ.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.daE < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.daE = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.daE > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        ImDbShrinkStatic.daF = 5000;
                    } else if (ImDbShrinkStatic.daE > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        ImDbShrinkStatic.daF = 3000;
                    } else {
                        ImDbShrinkStatic.daF = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.daF < 1000) {
                ImDbShrinkStatic.daF = 1000;
            }
            try {
                g.asI().asJ();
                for (ImMessageCenterPojo imMessageCenterPojo : asQ) {
                    if (isCancelled()) {
                        g.asI().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.asE().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.daF);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.asT().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.daF);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.asS().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.daF);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.asF().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.daF);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.asI().endTransaction();
            }
            return true;
        }
    }
}
