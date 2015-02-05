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
    final /* synthetic */ ImDbShrinkStatic aYl;

    private j(ImDbShrinkStatic imDbShrinkStatic) {
        this.aYl = imDbShrinkStatic;
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
        LinkedList<ImMessageCenterPojo> MX = k.MU().MX();
        if (MX == null || MX.size() == 0) {
            return false;
        }
        j = ImDbShrinkStatic.aYj;
        if (j < 0) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                ImDbShrinkStatic.aYj = statFs.getAvailableBlocks() * statFs.getBlockSize();
                j2 = ImDbShrinkStatic.aYj;
                if (j2 > 2147483648L) {
                    ImDbShrinkStatic.aYk = 5000;
                } else {
                    j3 = ImDbShrinkStatic.aYj;
                    if (j3 > 1073741824) {
                        ImDbShrinkStatic.aYk = 3000;
                    } else {
                        ImDbShrinkStatic.aYk = 1000;
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        i = ImDbShrinkStatic.aYk;
        if (i < 1000) {
            ImDbShrinkStatic.aYk = 1000;
        }
        try {
            g.MP().MQ();
            for (ImMessageCenterPojo imMessageCenterPojo : MX) {
                if (isCancelled()) {
                    g.MP().endTransaction();
                    return false;
                } else if (imMessageCenterPojo.getCustomGroupType() == 1) {
                    c ML = c.ML();
                    String gid = imMessageCenterPojo.getGid();
                    i2 = ImDbShrinkStatic.aYk;
                    ML.w(gid, i2);
                } else if (imMessageCenterPojo.getCustomGroupType() == 2) {
                    o Nf = o.Nf();
                    String gid2 = imMessageCenterPojo.getGid();
                    i3 = ImDbShrinkStatic.aYk;
                    Nf.w(gid2, i3);
                } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                    n Ne = n.Ne();
                    String gid3 = imMessageCenterPojo.getGid();
                    i4 = ImDbShrinkStatic.aYk;
                    Ne.w(gid3, i4);
                } else if (imMessageCenterPojo.getCustomGroupType() == -2) {
                    d MM = d.MM();
                    String gid4 = imMessageCenterPojo.getGid();
                    i5 = ImDbShrinkStatic.aYk;
                    MM.w(gid4, i5);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        } finally {
            g.MP().endTransaction();
        }
        return true;
    }
}
