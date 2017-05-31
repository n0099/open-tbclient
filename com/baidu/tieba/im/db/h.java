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
    private static h cUU;
    private static long cUX = -1;
    private static int cUY = 0;
    private a cUV = new a(null);
    private b cUW = null;

    public static h aou() {
        if (cUU == null) {
            synchronized (h.class) {
                if (cUU == null) {
                    cUU = new h();
                }
            }
        }
        return cUU;
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
                    h.aou().cUV.removeMessages(1);
                    h.aou().execute();
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
        if (this.cUW != null) {
            this.cUW.cancel();
            this.cUW = null;
        }
        this.cUW = new b(this, null);
        this.cUW.setParallel(TiebaIMConfig.getParallel());
        this.cUW.setPriority(4);
        this.cUW.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.cUW != null) {
            this.cUW.cancel();
            this.cUW = null;
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
            LinkedList<ImMessageCenterPojo> aoA = j.aox().aoA();
            if (aoA == null || aoA.size() == 0) {
                return false;
            }
            if (h.cUX < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    h.cUX = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (h.cUX > IjkMediaMeta.AV_CH_WIDE_LEFT) {
                        h.cUY = 5000;
                    } else if (h.cUX > IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                        h.cUY = 3000;
                    } else {
                        h.cUY = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (h.cUY < 1000) {
                h.cUY = 1000;
            }
            try {
                g.aos().aot();
                for (ImMessageCenterPojo imMessageCenterPojo : aoA) {
                    if (isCancelled()) {
                        g.aos().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.aoo().R(imMessageCenterPojo.getGid(), h.cUY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        m.aoD().R(imMessageCenterPojo.getGid(), h.cUY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        l.aoC().R(imMessageCenterPojo.getGid(), h.cUY);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.aop().R(imMessageCenterPojo.getGid(), h.cUY);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.aos().endTransaction();
            }
            return true;
        }
    }
}
