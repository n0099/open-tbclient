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
    private static ImDbShrinkStatic cUG;
    private static long cUJ = -1;
    private static int cUK = 0;
    private a cUH = new a(null);
    private b cUI = null;

    static {
        apH();
    }

    public static ImDbShrinkStatic apH() {
        if (cUG == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (cUG == null) {
                    cUG = new ImDbShrinkStatic();
                }
            }
        }
        return cUG;
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
                    ImDbShrinkStatic.apH().cUH.removeMessages(1);
                    ImDbShrinkStatic.apH().execute();
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
        if (this.cUI != null) {
            this.cUI.cancel();
            this.cUI = null;
        }
        this.cUI = new b(this, null);
        this.cUI.setParallel(TiebaIMConfig.getParallel());
        this.cUI.setPriority(4);
        this.cUI.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cUI != null) {
            this.cUI.cancel();
            this.cUI = null;
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
            LinkedList<ImMessageCenterPojo> apN = i.apK().apN();
            if (apN == null || apN.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.cUJ < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.cUJ = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.cUJ > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        ImDbShrinkStatic.cUK = 5000;
                    } else if (ImDbShrinkStatic.cUJ > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        ImDbShrinkStatic.cUK = 3000;
                    } else {
                        ImDbShrinkStatic.cUK = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.cUK < 1000) {
                ImDbShrinkStatic.cUK = 1000;
            }
            try {
                g.apF().apG();
                for (ImMessageCenterPojo imMessageCenterPojo : apN) {
                    if (isCancelled()) {
                        g.apF().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.apB().Q(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cUK);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.apQ().Q(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cUK);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.apP().Q(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cUK);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.apC().Q(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cUK);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.apF().endTransaction();
            }
            return true;
        }
    }
}
