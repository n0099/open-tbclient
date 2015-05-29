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
    final /* synthetic */ ImDbShrinkStatic bfn;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.bfn = imDbShrinkStatic;
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
        LinkedList<ImMessageCenterPojo> Ry = k.Rv().Ry();
        if (Ry == null || Ry.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.bfl;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.bfl = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.bfl;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.bfm = 5000;
                } else {
                    j3 = ImDbShrinkStatic.bfl;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.bfm = LocationClientOption.MIN_SCAN_SPAN_NETWORK;
                    } else {
                        ImDbShrinkStatic.bfm = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.bfm;
        if (i < 1000) {
            ImDbShrinkStatic.bfm = 1000;
        }
        try {
            g.Rq().Rr();
            for (ImMessageCenterPojo imMessageCenterPojo : Ry) {
                if (isCancelled()) {
                    g.Rq().endTransaction();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c Rm = c.Rm();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.bfm;
                    Rm.v(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    n RB = n.RB();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.bfm;
                    RB.v(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    m RA = m.RA();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.bfm;
                    RA.v(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d Rn = d.Rn();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.bfm;
                    Rn.v(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.Rq().endTransaction();
        }
        return true;
    }
}
