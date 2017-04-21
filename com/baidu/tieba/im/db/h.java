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
    private static h cVu;
    private static long cVx = -1;
    private static int cVy = 0;
    private a cVv = new a(null);
    private b cVw = null;

    public static h aqB() {
        if (cVu == null) {
            synchronized (h.class) {
                if (cVu == null) {
                    cVu = new h();
                }
            }
        }
        return cVu;
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
                    h.aqB().cVv.removeMessages(1);
                    h.aqB().execute();
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
        if (this.cVw != null) {
            this.cVw.cancel();
            this.cVw = null;
        }
        this.cVw = new b(this, null);
        this.cVw.setParallel(TiebaIMConfig.getParallel());
        this.cVw.setPriority(4);
        this.cVw.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cVw != null) {
            this.cVw.cancel();
            this.cVw = null;
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
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> aqH = j.aqE().aqH();
            if (aqH == null || aqH.size() == 0) {
                return false;
            }
            if (h.cVx < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    h.cVx = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.cVx > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        h.cVy = 5000;
                    } else if (h.cVx > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        h.cVy = 3000;
                    } else {
                        h.cVy = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.cVy < 1000) {
                h.cVy = 1000;
            }
            try {
                g.aqz().aqA();
                for (ImMessageCenterPojo imMessageCenterPojo : aqH) {
                    if (isCancelled()) {
                        g.aqz().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aqv().Q(imMessageCenterPojo.getGid(), h.cVy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aqK().Q(imMessageCenterPojo.getGid(), h.cVy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aqJ().Q(imMessageCenterPojo.getGid(), h.cVy);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aqw().Q(imMessageCenterPojo.getGid(), h.cVy);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aqz().endTransaction();
            }
            return true;
        }
    }
}
