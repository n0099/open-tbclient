package com.baidu.tbplugin;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public final class i implements e {
    @Override // com.baidu.tbplugin.e
    public final List<Class<?>> a(int i) {
        switch (i) {
            case 1:
                return j.c;
            case 2:
            default:
                return null;
            case 3:
                ArrayList arrayList = new ArrayList(j.c.size());
                for (Class<?> cls : j.c) {
                    if (a(cls)) {
                        arrayList.add(cls);
                    }
                }
                return arrayList;
        }
    }

    private static boolean a(Class<?> cls) {
        boolean z;
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) f.a(cls, com.baidu.tbplugin.a.c.class);
        if (cVar == null || cVar.a().equals("")) {
            return false;
        }
        com.baidu.tbplugin.a.a aVar = (com.baidu.tbplugin.a.a) f.a(cls, com.baidu.tbplugin.a.a.class);
        if (aVar == null || FileUtils.getFile(f.a(), aVar.a()).exists()) {
            com.baidu.tbplugin.a.b bVar = (com.baidu.tbplugin.a.b) f.a(cls, com.baidu.tbplugin.a.b.class);
            if (bVar != null) {
                String[] a = bVar.a();
                int length = a.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (!FileUtils.getFile(f.c(), a[i]).exists()) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    return false;
                }
            }
            com.baidu.tbplugin.a.d dVar = (com.baidu.tbplugin.a.d) f.a(cls, com.baidu.tbplugin.a.d.class);
            return dVar == null || FileUtils.getFile(f.b(), dVar.a()).exists();
        }
        return false;
    }
}
