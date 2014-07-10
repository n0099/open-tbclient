package com.baidu.tbadk.tbplugin;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public class l implements e {
    public l(Context context) {
    }

    @Override // com.baidu.tbadk.tbplugin.e
    public List<Class<?>> a(int i) {
        switch (i) {
            case 3:
                return a();
            default:
                return null;
        }
    }

    public List<Class<?>> a() {
        ArrayList arrayList = new ArrayList(m.c.size());
        try {
            for (String str : m.c.values()) {
                try {
                    Class<?> loadClass = m.a().k().c().loadClass(str);
                    if (a(loadClass)) {
                        arrayList.add(loadClass);
                    }
                } catch (Exception e) {
                    i.b(BdBaseApplication.getInst().getContext(), "Discovery installed failed: Nested Exception: " + e.getMessage());
                }
            }
        } catch (ConcurrentModificationException e2) {
            i.b(BdBaseApplication.getInst().getContext(), "Discovery installed failed: Nested Exception: " + e2.getMessage());
        }
        return arrayList;
    }

    private boolean a(Class<?> cls) {
        boolean z;
        com.baidu.tbadk.tbplugin.a.c cVar = (com.baidu.tbadk.tbplugin.a.c) i.a(cls, com.baidu.tbadk.tbplugin.a.c.class);
        if (cVar == null || cVar.a().equals("")) {
            return false;
        }
        File file = FileUtils.getFile(i.d(), String.valueOf(cVar.a()) + ".xml");
        if (file.exists() && i.b(s.a(file))) {
            com.baidu.tbadk.tbplugin.a.a aVar = (com.baidu.tbadk.tbplugin.a.a) i.a(cls, com.baidu.tbadk.tbplugin.a.a.class);
            if (aVar == null || FileUtils.getFile(i.a(), aVar.a()).exists()) {
                com.baidu.tbadk.tbplugin.a.b bVar = (com.baidu.tbadk.tbplugin.a.b) i.a(cls, com.baidu.tbadk.tbplugin.a.b.class);
                if (bVar != null) {
                    String[] a = bVar.a();
                    int length = a.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = false;
                            break;
                        }
                        if (!FileUtils.getFile(i.c(), a[i]).exists()) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (z) {
                        return false;
                    }
                }
                com.baidu.tbadk.tbplugin.a.d dVar = (com.baidu.tbadk.tbplugin.a.d) i.a(cls, com.baidu.tbadk.tbplugin.a.d.class);
                return dVar == null || FileUtils.getFile(i.b(), dVar.a()).exists();
            }
            return false;
        }
        return false;
    }
}
