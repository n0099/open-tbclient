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
    private static ImDbShrinkStatic cLi;
    private static long cLl = -1;
    private static int cLm = 0;
    private a cLj = new a(null);
    private b cLk = null;

    static {
        apg();
    }

    public static ImDbShrinkStatic apg() {
        if (cLi == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (cLi == null) {
                    cLi = new ImDbShrinkStatic();
                }
            }
        }
        return cLi;
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
                    ImDbShrinkStatic.apg().cLj.removeMessages(1);
                    ImDbShrinkStatic.apg().execute();
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
        if (this.cLk != null) {
            this.cLk.cancel();
            this.cLk = null;
        }
        this.cLk = new b(this, null);
        this.cLk.setParallel(TiebaIMConfig.getParallel());
        this.cLk.setPriority(4);
        this.cLk.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cLk != null) {
            this.cLk.cancel();
            this.cLk = null;
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
            LinkedList<ImMessageCenterPojo> apm = i.apj().apm();
            if (apm == null || apm.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.cLl < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.cLl = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.cLl > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        ImDbShrinkStatic.cLm = 5000;
                    } else if (ImDbShrinkStatic.cLl > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        ImDbShrinkStatic.cLm = 3000;
                    } else {
                        ImDbShrinkStatic.cLm = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.cLm < 1000) {
                ImDbShrinkStatic.cLm = 1000;
            }
            try {
                g.ape().apf();
                for (ImMessageCenterPojo imMessageCenterPojo : apm) {
                    if (isCancelled()) {
                        g.ape().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.apa().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cLm);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.app().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cLm);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.apo().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cLm);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.apb().X(imMessageCenterPojo.getGid(), ImDbShrinkStatic.cLm);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.ape().endTransaction();
            }
            return true;
        }
    }
}
