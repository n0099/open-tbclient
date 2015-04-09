package com.baidu.tieba.im.db;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Object, Boolean> {
    final /* synthetic */ ImDbShrinkStatic bcJ;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.bcJ = imDbShrinkStatic;
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
        LinkedList<ImMessageCenterPojo> Qj = k.Qg().Qj();
        if (Qj == null || Qj.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.bcH;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.bcH = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.bcH;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.bcI = 5000;
                } else {
                    j3 = ImDbShrinkStatic.bcH;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.bcI = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bcI = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.bcI;
        if (i < 1000) {
            ImDbShrinkStatic.bcI = 1000;
        }
        try {
            g.Qb().Qc();
            for (ImMessageCenterPojo imMessageCenterPojo : Qj) {
                if (isCancelled()) {
                    g.Qb().endTransaction();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c PX = c.PX();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.bcI;
                    PX.v(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    n Qm = n.Qm();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.bcI;
                    Qm.v(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    m Ql = m.Ql();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.bcI;
                    Ql.v(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d PY = d.PY();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.bcI;
                    PY.v(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.Qb().endTransaction();
        }
        return true;
    }
}
