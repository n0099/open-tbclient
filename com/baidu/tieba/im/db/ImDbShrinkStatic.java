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
    private static ImDbShrinkStatic cSq;
    private static long cSt = -1;
    private static int cSu = 0;
    private a cSr = new a(null);
    private b cSs = null;

    static {
        aqn();
    }

    public static ImDbShrinkStatic aqn() {
        if (cSq == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (cSq == null) {
                    cSq = new ImDbShrinkStatic();
                }
            }
        }
        return cSq;
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
                    ImDbShrinkStatic.aqn().cSr.removeMessages(1);
                    ImDbShrinkStatic.aqn().execute();
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
        if (this.cSs != null) {
            this.cSs.cancel();
            this.cSs = null;
        }
        this.cSs = new b(this, null);
        this.cSs.setParallel(TiebaIMConfig.getParallel());
        this.cSs.setPriority(4);
        this.cSs.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cSs != null) {
            this.cSs.cancel();
            this.cSs = null;
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
            LinkedList<ImMessageCenterPojo> aqt = i.aqq().aqt();
            if (aqt == null || aqt.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.cSt < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.cSt = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.cSt > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        ImDbShrinkStatic.cSu = 5000;
                    } else if (ImDbShrinkStatic.cSt > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        ImDbShrinkStatic.cSu = 3000;
                    } else {
                        ImDbShrinkStatic.cSu = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.cSu < 1000) {
                ImDbShrinkStatic.cSu = 1000;
            }
            try {
                g.aql().aqm();
                for (ImMessageCenterPojo imMessageCenterPojo : aqt) {
                    if (isCancelled()) {
                        g.aql().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aqh().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cSu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.aqw().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cSu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.aqv().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cSu);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aqi().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cSu);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aql().endTransaction();
            }
            return true;
        }
    }
}
