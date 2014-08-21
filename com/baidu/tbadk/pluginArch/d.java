package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class d {
    private static d c;
    public Context a;
    private final h d;
    private final i f;
    final TreeMap<String, c> b = new TreeMap<>();
    private final v e = new v();

    public static void a(Context context) {
        if (c == null) {
            c = new d(context);
            c.i();
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
        this.d = new h(context);
        this.f = new i(context);
    }

    private void i() {
        this.d.a();
        a(r.a().b());
    }

    public void b() {
        a(r.a().c());
    }

    private void a(HashMap<String, q> hashMap) {
        if (hashMap != null) {
            for (q qVar : hashMap.values()) {
                if (qVar.a != null) {
                    f(qVar.a);
                }
            }
        }
    }

    public c a(String str) {
        if (str == null) {
            return null;
        }
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

    public void e() {
        if (UtilHelper.getNetStatusInfo(this.a) == UtilHelper.NetworkStateInfo.WIFI) {
            ArrayList arrayList = new ArrayList();
            if (!a().c("motu")) {
                arrayList.add("motu");
            }
            if (!a().c("browser")) {
                arrayList.add("browser");
            }
            if (!p.b() && !a().c("live")) {
                arrayList.add("live");
            }
            if (!a().c("lightapp")) {
                arrayList.add("lightapp");
            }
            this.f.a((String[]) arrayList.toArray(new String[arrayList.size()]), new f(this));
        }
    }

    public void a(ConfigInfos.PluginConfig pluginConfig, j jVar) {
        this.f.a(pluginConfig, jVar);
    }

    public void f() {
        this.f.a();
    }

    public void a(String str, b bVar) {
        if (str != null && !c(str)) {
            new s(this.a, str, new g(this, str, bVar)).a();
        }
    }

    public void a(String str, String str2, b bVar) {
        if (!c(str2) || e(str2)) {
            new s(str, str2, new g(this, str2, bVar)).a();
        }
    }

    public h g() {
        return this.d;
    }

    public boolean c(String str) {
        return str != null && r.a().b().containsKey(str);
    }

    public boolean d(String str) {
        return o.a().b(str);
    }

    public void a(String str, boolean z) {
        o.a().a(str, z);
    }

    public boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return z.a(str);
    }

    public boolean h() {
        for (String str : this.b.keySet()) {
            if (e(str)) {
                return true;
            }
        }
        return false;
    }

    private void f(String str) {
        if (str != null) {
            a(n.d(str));
        }
    }

    private void a(File file) {
        aa b;
        if (file != null && (b = b(file)) != null) {
            if ((b.a == null || this.b.get(b.a) == null) && b != null && b.h != null) {
                a(b);
            }
        }
    }

    private aa b(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        ab abVar = new ab(file);
        abVar.a();
        return abVar.a;
    }

    private void a(aa aaVar) {
        c cVar = new c(aaVar);
        cVar.b();
        if (cVar.a() != null) {
            this.b.put(cVar.a(), cVar);
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(n.c(str), System.mapLibraryName(str2));
            if (file != null && file.isFile()) {
                try {
                    System.load(file.getAbsolutePath());
                    u.a("plugin_use");
                } catch (Throwable th) {
                    th.printStackTrace();
                    u.a("plugin_use", th.getMessage(), str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2) {
        aa b;
        if (i == 0 && (b = b(n.d(str2))) != null) {
            q qVar = new q();
            qVar.a = str2;
            qVar.b = b.e;
            a(b);
            r.a().a(qVar);
        }
    }
}
