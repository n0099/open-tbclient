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
public class h {
    private static h cTd;
    private static long cTg = -1;
    private static int cTh = 0;
    private a cTe = new a(null);
    private b cTf = null;

    public static h apA() {
        if (cTd == null) {
            synchronized (h.class) {
                if (cTd == null) {
                    cTd = new h();
                }
            }
        }
        return cTd;
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
                    h.apA().cTe.removeMessages(1);
                    h.apA().execute();
                    return;
                default:
                    return;
            }
        }
    }

    private h() {
        MessageManager.getInstance().registerListener(new i(this, CmdConfigCustom.CMD_BACKGROUND_SWTICH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void execute() {
        if (this.cTf != null) {
            this.cTf.cancel();
            this.cTf = null;
        }
        this.cTf = new b(this, null);
        this.cTf.setParallel(TiebaIMConfig.getParallel());
        this.cTf.setPriority(4);
        this.cTf.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cTf != null) {
            this.cTf.cancel();
            this.cTf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Object, Boolean> {
        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [179=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> apG = j.apD().apG();
            if (apG == null || apG.size() == 0) {
                return false;
            }
            if (h.cTg < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    h.cTg = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.cTg > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        h.cTh = 5000;
                    } else if (h.cTg > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        h.cTh = 3000;
                    } else {
                        h.cTh = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.cTh < 1000) {
                h.cTh = 1000;
            }
            try {
                g.apy().apz();
                for (ImMessageCenterPojo imMessageCenterPojo : apG) {
                    if (isCancelled()) {
                        g.apy().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.apu().Q(imMessageCenterPojo.getGid(), h.cTh);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.apJ().Q(imMessageCenterPojo.getGid(), h.cTh);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.apI().Q(imMessageCenterPojo.getGid(), h.cTh);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.apv().Q(imMessageCenterPojo.getGid(), h.cTh);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.apy().endTransaction();
            }
            return true;
        }
    }
}
