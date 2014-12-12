package com.baidu.tieba.app;

import android.content.pm.PackageInfo;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e aqm;

    public static synchronized e By() {
        e eVar;
        synchronized (e.class) {
            if (aqm == null) {
                aqm = new e();
            }
            eVar = aqm;
        }
        return eVar;
    }

    public a Bz() {
        int i = 0;
        a aVar = new a();
        List<PackageInfo> installedPackages = TbadkApplication.getInst().getApp().getPackageManager().getInstalledPackages(0);
        while (true) {
            int i2 = i;
            if (i2 < installedPackages.size()) {
                PackageInfo packageInfo = installedPackages.get(i2);
                b bVar = new b();
                bVar.aqi = packageInfo.applicationInfo.loadLabel(TbadkApplication.getInst().getApp().getPackageManager()).toString();
                bVar.mPackageName = packageInfo.packageName;
                bVar.aqj = packageInfo.versionName;
                bVar.aqk = packageInfo.versionCode;
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    aVar.aqh.add(bVar);
                } else {
                    aVar.aqg.add(bVar);
                }
                i = i2 + 1;
            } else {
                return aVar;
            }
        }
    }
}
