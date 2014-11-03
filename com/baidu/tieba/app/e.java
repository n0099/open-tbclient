package com.baidu.tieba.app;

import android.content.pm.PackageInfo;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e aja;

    public static synchronized e yh() {
        e eVar;
        synchronized (e.class) {
            if (aja == null) {
                aja = new e();
            }
            eVar = aja;
        }
        return eVar;
    }

    public a yi() {
        int i = 0;
        a aVar = new a();
        List<PackageInfo> installedPackages = TbadkApplication.m251getInst().getApp().getPackageManager().getInstalledPackages(0);
        while (true) {
            int i2 = i;
            if (i2 < installedPackages.size()) {
                PackageInfo packageInfo = installedPackages.get(i2);
                b bVar = new b();
                bVar.aiW = packageInfo.applicationInfo.loadLabel(TbadkApplication.m251getInst().getApp().getPackageManager()).toString();
                bVar.mPackageName = packageInfo.packageName;
                bVar.aiX = packageInfo.versionName;
                bVar.aiY = packageInfo.versionCode;
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    aVar.aiV.add(bVar);
                } else {
                    aVar.aiU.add(bVar);
                }
                i = i2 + 1;
            } else {
                return aVar;
            }
        }
    }
}
