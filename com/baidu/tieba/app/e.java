package com.baidu.tieba.app;

import android.content.pm.PackageInfo;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e arq;

    public static synchronized e Cb() {
        e eVar;
        synchronized (e.class) {
            if (arq == null) {
                arq = new e();
            }
            eVar = arq;
        }
        return eVar;
    }

    public a Cc() {
        int i = 0;
        a aVar = new a();
        List<PackageInfo> installedPackages = TbadkApplication.getInst().getApp().getPackageManager().getInstalledPackages(0);
        while (true) {
            int i2 = i;
            if (i2 < installedPackages.size()) {
                PackageInfo packageInfo = installedPackages.get(i2);
                b bVar = new b();
                bVar.arm = packageInfo.applicationInfo.loadLabel(TbadkApplication.getInst().getApp().getPackageManager()).toString();
                bVar.mPackageName = packageInfo.packageName;
                bVar.arn = packageInfo.versionName;
                bVar.aro = packageInfo.versionCode;
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    aVar.arl.add(bVar);
                } else {
                    aVar.ark.add(bVar);
                }
                i = i2 + 1;
            } else {
                return aVar;
            }
        }
    }
}
