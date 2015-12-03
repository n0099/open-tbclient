package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic bMw;
    private a bMx = new a(null);
    private b bMy = null;
    private static long bMz = -1;
    private static int bMA = 0;

    static {
        Xi();
    }

    public static ImDbShrinkStatic Xi() {
        if (bMw == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bMw == null) {
                    bMw = new ImDbShrinkStatic();
                }
            }
        }
        return bMw;
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
                    ImDbShrinkStatic.Xi().bMx.removeMessages(1);
                    ImDbShrinkStatic.Xi().execute();
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
        if (this.bMy != null) {
            this.bMy.cancel();
            this.bMy = null;
        }
        this.bMy = new b(this, null);
        this.bMy.setParallel(TiebaIMConfig.getParallel());
        this.bMy.setPriority(4);
        this.bMy.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.bMy != null) {
            this.bMy.cancel();
            this.bMy = null;
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
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            LinkedList<ImMessageCenterPojo> Xo = i.Xl().Xo();
            if (Xo == null || Xo.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.bMz < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.bMz = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.bMz > 2147483648L) {
                        ImDbShrinkStatic.bMA = 5000;
                    } else if (ImDbShrinkStatic.bMz > 1073741824) {
                        ImDbShrinkStatic.bMA = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bMA = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.bMA < 1000) {
                ImDbShrinkStatic.bMA = 1000;
            }
            try {
                g.Xg().Xh();
                for (ImMessageCenterPojo imMessageCenterPojo : Xo) {
                    if (isCancelled()) {
                        g.Xg().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.Xc().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bMA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.Xr().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bMA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.Xq().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bMA);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.Xd().G(imMessageCenterPojo.getGid(), ImDbShrinkStatic.bMA);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.Xg().endTransaction();
            }
            return true;
        }
    }
}
