package com.baidu.tieba.f;

import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import com.baidu.adp.lib.util.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class b {
    private static final ArrayList<String> a = new ArrayList<>();

    public static void a() {
        try {
            PackageInfo packageInfo = com.baidu.adp.a.b.a().b().getPackageManager().getPackageInfo(com.baidu.adp.a.b.a().b().getPackageName(), 7);
            a(packageInfo.activities);
            a(packageInfo.services);
            a(packageInfo.receivers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            try {
                Class.forName(it.next());
            } catch (Exception e2) {
                f.b(e2.getMessage());
            }
        }
        b();
    }

    private static void a(ComponentInfo[] componentInfoArr) {
        if (componentInfoArr != null) {
            for (ComponentInfo componentInfo : componentInfoArr) {
                try {
                    Class.forName(componentInfo.name);
                } catch (Exception e) {
                    f.b(e.getMessage());
                }
            }
        }
    }

    private static void b() {
    }
}
