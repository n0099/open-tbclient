package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import java.io.File;
import java.util.HashMap;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class d {
    private static d c;
    public Context a;
    private final g d;
    private final h f;
    final TreeMap<String, c> b = new TreeMap<>();
    private final u e = new u();

    public static void a(Context context) {
        if (c == null) {
            c = new d(context);
            c.h();
            if (TbadkApplication.m252getInst().isMainProcess(false)) {
                c.c();
            }
        }
    }

    public static d a() {
        return c;
    }

    private d(Context context) {
        this.a = context;
        this.d = new g(context);
        this.f = new h(context);
    }

    private void h() {
        this.d.a();
        for (p pVar : q.a().b().values()) {
            if (pVar.a != null) {
                f(pVar.a);
            }
        }
    }

    public void b() {
        HashMap<String, p> c2 = q.a().c();
        if (c2 != null) {
            for (p pVar : c2.values()) {
                if (pVar.a != null) {
                    f(pVar.a);
                }
            }
        }
    }

    public c a(String str) {
        return this.b.get(str);
    }

    public ConfigInfos c() {
        return this.e.a(new e(this));
    }

    public ConfigInfos d() {
        return this.e.a();
    }

    public void a(ConfigInfos configInfos) {
        this.e.a(configInfos);
    }

    public ConfigInfos.PluginConfig b(String str) {
        ConfigInfos d;
        if (!TextUtils.isEmpty(str) && (d = d()) != null) {
            for (ConfigInfos.PluginConfig pluginConfig : d.getConfigs()) {
                if (str.equals(pluginConfig.name)) {
                    return pluginConfig;
                }
            }
            return null;
        }
        return null;
    }

    public void a(ConfigInfos.PluginConfig pluginConfig, i iVar) {
        this.f.a(pluginConfig, iVar);
    }

    public void e() {
        this.f.a();
    }

    public void a(String str, b bVar) {
        if (!c(str)) {
            new r(this.a, str, new f(this, str, bVar)).a();
        }
    }

    public void a(String str, String str2, b bVar) {
        if (!c(str2) || e(str2)) {
            new r(str, str2, new f(this, str2, bVar)).a();
        }
    }

    public g f() {
        return this.d;
    }

    public boolean c(String str) {
        return str != null && q.a().b().containsKey(str);
    }

    public boolean d(String str) {
        if (str == null) {
            return false;
        }
        com.baidu.tbadk.pluginArch.bean.a a = n.a().a(str);
        if (a == null) {
            return true;
        }
        if (a.b == null || a.b.size() == 0) {
            return true;
        }
        String a2 = o.a();
        String str2 = TextUtils.isEmpty(a2) ? null : a2;
        for (String str3 : a.b) {
            if (TextUtils.isEmpty(str3)) {
                str3 = null;
            }
            if (str3 == null) {
                if (str3 == str2) {
                    return false;
                }
            } else if (str3.equals(str2)) {
                return false;
            }
        }
        return true;
    }

    public void a(String str, boolean z) {
        com.baidu.tbadk.pluginArch.bean.a a;
        if (str != null && (a = n.a().a(str)) != null) {
            String a2 = o.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = null;
            }
            if (z) {
                if (!a.b.contains(a2)) {
                    a.b.add(a2);
                }
            } else if (a.b.contains(a2)) {
                a.b.remove(a2);
            }
            n.a().a(a);
            if (TbadkApplication.m252getInst().isMainProcess(false)) {
                ab.a().a(str);
            }
        }
    }

    public boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return y.a(str);
    }

    public boolean g() {
        for (String str : this.b.keySet()) {
            if (e(str)) {
                return true;
            }
        }
        return false;
    }

    private void f(String str) {
        if (str != null) {
            a(m.d(str));
        }
    }

    private void a(File file) {
        z b = b(file);
        if (this.b.get(b.a) == null && b != null && b.h != null) {
            a(b);
        }
    }

    private z b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        aa aaVar = new aa(file);
        aaVar.a();
        return aaVar.a;
    }

    private void a(z zVar) {
        c cVar = new c(zVar);
        cVar.b();
        if (cVar.a() != null) {
            this.b.put(cVar.a(), cVar);
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(m.c(str), System.mapLibraryName(str2));
            if (file != null && file.isFile()) {
                try {
                    System.load(file.getAbsolutePath());
                    t.a("plugin_use");
                } catch (Throwable th) {
                    th.printStackTrace();
                    t.a("plugin_use", th.getMessage(), str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        z b;
        if (i == 0 && (b = b(m.d(str2))) != null) {
            p pVar = new p();
            pVar.a = str2;
            pVar.b = b.e;
            a(b);
            q.a().a(pVar);
        }
    }
}
