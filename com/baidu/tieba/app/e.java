package com.baidu.tieba.app;

import android.content.pm.PackageInfo;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e a;

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public a b() {
        int i = 0;
        a aVar = new a();
        List<PackageInfo> installedPackages = TbadkApplication.m252getInst().getApp().getPackageManager().getInstalledPackages(0);
        while (true) {
            int i2 = i;
            if (i2 < installedPackages.size()) {
                PackageInfo packageInfo = installedPackages.get(i2);
                b bVar = new b();
                bVar.a = packageInfo.applicationInfo.loadLabel(TbadkApplication.m252getInst().getApp().getPackageManager()).toString();
                bVar.b = packageInfo.packageName;
                bVar.c = packageInfo.versionName;
                bVar.d = packageInfo.versionCode;
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    aVar.b.add(bVar);
                } else {
                    aVar.a.add(bVar);
                }
                i = i2 + 1;
            } else {
                return aVar;
            }
        }
    }
}
