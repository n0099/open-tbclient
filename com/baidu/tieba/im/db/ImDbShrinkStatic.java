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
    private static ImDbShrinkStatic btF;
    private static long btI = -1;
    private static int btJ = 0;
    private a btG = new a(null);
    private b btH = null;

    static {
        Td();
    }

    public static ImDbShrinkStatic Td() {
        if (btF == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (btF == null) {
                    btF = new ImDbShrinkStatic();
                }
            }
        }
        return btF;
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
                    ImDbShrinkStatic.Td().btG.removeMessages(1);
                    ImDbShrinkStatic.Td().execute();
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
        if (this.btH != null) {
            this.btH.cancel();
            this.btH = null;
        }
        this.btH = new b(this, null);
        this.btH.setParallel(TiebaIMConfig.getParallel());
        this.btH.setPriority(4);
        this.btH.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        if (this.btH != null) {
            this.btH.cancel();
            this.btH = null;
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
            LinkedList<ImMessageCenterPojo> Tj = i.Tg().Tj();
            if (Tj == null || Tj.size() == 0) {
                return false;
            }
            if (ImDbShrinkStatic.btI < 0) {
                try {
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                    ImDbShrinkStatic.btI = statFs.getAvailableBlocks() * statFs.getBlockSize();
                    if (ImDbShrinkStatic.btI > 2147483648L) {
                        ImDbShrinkStatic.btJ = 5000;
                    } else if (ImDbShrinkStatic.btI > 1073741824) {
                        ImDbShrinkStatic.btJ = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.btJ = 1000;
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            if (ImDbShrinkStatic.btJ < 1000) {
                ImDbShrinkStatic.btJ = 1000;
            }
            try {
                g.Tb().Tc();
                for (ImMessageCenterPojo imMessageCenterPojo : Tj) {
                    if (isCancelled()) {
                        g.Tb().endTransaction();
                        return false;
                    } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                        c.SX().z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btJ);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        l.Tm().z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btJ);
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        k.Tl().z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btJ);
                    } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                        d.SY().z(imMessageCenterPojo.getGid(), ImDbShrinkStatic.btJ);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            } finally {
                g.Tb().endTransaction();
            }
            return true;
        }
    }
}
