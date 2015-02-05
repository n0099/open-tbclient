package com.baidu.tieba.app;

import android.content.pm.PackageInfo;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e arn;

    public static synchronized e BV() {
        e eVar;
        synchronized (e.class) {
            if (arn == null) {
                arn = new e();
            }
            eVar = arn;
        }
        return eVar;
    }

    public a BW() {
        int i = 0;
        a aVar = new a();
        List<PackageInfo> installedPackages = TbadkApplication.getInst().getApp().getPackageManager().getInstalledPackages(0);
        while (true) {
            int i2 = i;
            if (i2 < installedPackages.size()) {
                PackageInfo packageInfo = installedPackages.get(i2);
                b bVar = new b();
                bVar.arj = packageInfo.applicationInfo.loadLabel(TbadkApplication.getInst().getApp().getPackageManager()).toString();
                bVar.mPackageName = packageInfo.packageName;
                bVar.ark = packageInfo.versionName;
                bVar.arl = packageInfo.versionCode;
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    aVar.ari.add(bVar);
                } else {
                    aVar.arh.add(bVar);
                }
                i = i2 + 1;
            } else {
                return aVar;
            }
        }
    }
}
