package com.baidu.tieba.app;

import android.content.pm.PackageInfo;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e aiR;

    public static synchronized e yf() {
        e eVar;
        synchronized (e.class) {
            if (aiR == null) {
                aiR = new e();
            }
            eVar = aiR;
        }
        return eVar;
    }

    public a yg() {
        int i = 0;
        a aVar = new a();
        List<PackageInfo> installedPackages = TbadkApplication.m251getInst().getApp().getPackageManager().getInstalledPackages(0);
        while (true) {
            int i2 = i;
            if (i2 < installedPackages.size()) {
                PackageInfo packageInfo = installedPackages.get(i2);
                b bVar = new b();
                bVar.aiN = packageInfo.applicationInfo.loadLabel(TbadkApplication.m251getInst().getApp().getPackageManager()).toString();
                bVar.mPackageName = packageInfo.packageName;
                bVar.aiO = packageInfo.versionName;
                bVar.aiP = packageInfo.versionCode;
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    aVar.aiM.add(bVar);
                } else {
                    aVar.aiL.add(bVar);
                }
                i = i2 + 1;
            } else {
                return aVar;
            }
        }
    }
}
