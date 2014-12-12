package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Object, Boolean> {
    final /* synthetic */ ImDbShrinkStatic aWQ;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.aWQ = imDbShrinkStatic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ImDbShrinkStatic imDbShrinkStatic, j jVar) {
        this(imDbShrinkStatic);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [194=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        long j;
        long j2;
        long j3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        LinkedList<ImMessageCenterPojo> MG = k.MD().MG();
        if (MG == null || MG.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.aWO;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.aWO = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.aWO;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.aWP = 5000;
                } else {
                    j3 = ImDbShrinkStatic.aWO;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.aWP = 3000;
                    } else {
                        ImDbShrinkStatic.aWP = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.aWP;
        if (i < 1000) {
            ImDbShrinkStatic.aWP = 1000;
        }
        try {
            g.My().Mz();
            for (ImMessageCenterPojo imMessageCenterPojo : MG) {
                if (isCancelled()) {
                    g.My().endTransaction();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c Mu = c.Mu();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.aWP;
                    Mu.w(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    o MO = o.MO();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.aWP;
                    MO.w(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    n MN = n.MN();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.aWP;
                    MN.w(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d Mv = d.Mv();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.aWP;
                    Mv.w(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.My().endTransaction();
        }
        return true;
    }
}
