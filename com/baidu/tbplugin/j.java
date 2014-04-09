package com.baidu.tbplugin;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public final class j implements f {
    @Override // com.baidu.tbplugin.f
    public final List<Class<?>> a(int i) {
        return a();
    }

    private List<Class<?>> a() {
        ArrayList arrayList = new ArrayList(k.c.size());
        try {
            for (String str : k.c) {
                try {
                    Class<?> loadClass = k.a().i().b().loadClass(str);
                    if (a(loadClass)) {
                        arrayList.add(loadClass);
                    }
                } catch (Exception e) {
                    g.a(com.baidu.adp.a.b.a().c(), "Discovery installed failed: Nested Exception: " + e.getMessage());
                }
            }
        } catch (ConcurrentModificationException e2) {
            g.a(com.baidu.adp.a.b.a().c(), "Discovery installed failed: Nested Exception: " + e2.getMessage());
        }
        return arrayList;
    }

    private static boolean a(Class<?> cls) {
        boolean z;
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) cls.getAnnotation(com.baidu.tbplugin.a.c.class);
        if (cVar == null || cVar.a().equals("")) {
            return false;
        }
        com.baidu.tbplugin.a.a aVar = (com.baidu.tbplugin.a.a) cls.getAnnotation(com.baidu.tbplugin.a.a.class);
        if (aVar == null || FileUtils.getFile(k.a().b(), aVar.a()).exists()) {
            com.baidu.tbplugin.a.b bVar = (com.baidu.tbplugin.a.b) cls.getAnnotation(com.baidu.tbplugin.a.b.class);
            if (bVar != null) {
                String[] a = bVar.a();
                int length = a.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (!FileUtils.getFile(k.a().d(), a[i]).exists()) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    return false;
                }
            }
            com.baidu.tbplugin.a.d dVar = (com.baidu.tbplugin.a.d) cls.getAnnotation(com.baidu.tbplugin.a.d.class);
            return dVar == null || FileUtils.getFile(k.a().c(), dVar.a()).exists();
        }
        return false;
    }
}
