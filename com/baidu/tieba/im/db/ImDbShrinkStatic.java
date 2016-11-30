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
    private static ImDbShrinkStatic dgn;
    private static long dgq = -1;
    private static int dgr = 0;
    private a dgo = new a(null);
    private b dgp = null;

    static {
        auH();
    }

    public static ImDbShrinkStatic auH() {
        if (dgn == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (dgn == null) {
                    dgn = new ImDbShrinkStatic();
                }
            }
        }
        return dgn;
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
                    ImDbShrinkStatic.auH().dgo.removeMessages(1);
                    ImDbShrinkStatic.auH().execute();
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
        if (this.dgp != null) {
            this.dgp.cancel();
            this.dgp = null;
        }
        this.dgp = new b(this, null);
        this.dgp.setParallel(TiebaIMConfig.getParallel());
        this.dgp.setPriority(4);
        this.dgp.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.dgp != null) {
            this.dgp.cancel();
            this.dgp = null;
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
            LinkedList<ImMessageCenterPojo> auN = i.auK().auN();
            if (auN == null || auN.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.dgq < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.dgq = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.dgq > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        ImDbShrinkStatic.dgr = 5000;
                    } else if (ImDbShrinkStatic.dgq > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        ImDbShrinkStatic.dgr = 3000;
                    } else {
                        ImDbShrinkStatic.dgr = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.dgr < 1000) {
                ImDbShrinkStatic.dgr = 1000;
            }
            try {
                g.auF().auG();
                for (ImMessageCenterPojo imMessageCenterPojo : auN) {
                    if (isCancelled()) {
                        g.auF().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.auB().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.dgr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.auQ().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.dgr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.auP().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.dgr);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.auC().Z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.dgr);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.auF().endTransaction();
            }
            return true;
        }
    }
}
