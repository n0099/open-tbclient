package com.baidu.tbadk.tbplugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public class m implements n, r {
    public static final String a = i.g();
    public static final String b = "/plugins/" + a;
    static final Map<String, String> c = Collections.synchronizedMap(new HashMap());
    private static m f;
    private boolean d;
    private Executor e;
    private Map<String, Object> g = new HashMap();
    private e h;
    private final File i;
    private final File j;
    private final File k;
    private final File l;
    private final File m;
    private final File n;
    private final d o;
    private final PluginSync p;
    private Context q;

    @SuppressLint({"SdCardPath"})
    private m(Context context) {
        this.q = context;
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File("/data/data/" + context.getPackageName() + "/files/");
            try {
                if (!filesDir.exists()) {
                    FileUtils.forceMkdir(filesDir);
                }
            } catch (IOException e) {
                i.b(context, String.valueOf(filesDir.getAbsolutePath()) + " directory create failed");
            }
        }
        String absolutePath = filesDir.getAbsolutePath();
        this.l = new File(String.valueOf(absolutePath) + "/plugins/");
        this.i = new File(String.valueOf(absolutePath) + "/plugins/libs/");
        this.j = new File(String.valueOf(absolutePath) + b);
        this.k = new File(String.valueOf(absolutePath) + "/plugins/resources/");
        this.m = new File(String.valueOf(absolutePath) + "/plugins/optimised/");
        this.n = new File(String.valueOf(absolutePath) + "/plugins/download/");
        this.h = new l(context);
        this.o = new d(context);
        this.e = Executors.newSingleThreadExecutor();
        this.p = new o(this.q, this);
    }

    private void r() {
        for (Class<?> cls : this.h.a(3)) {
            com.baidu.tbadk.tbplugin.a.c cVar = (com.baidu.tbadk.tbplugin.a.c) i.a(cls, com.baidu.tbadk.tbplugin.a.c.class);
            Object a2 = a(cls);
            if (a2 != null) {
                this.g.put(cVar.a(), a2);
            }
        }
    }

    public static void a(Context context) {
        f = new m(context);
    }

    public static m a() {
        return f;
    }

    public <P> P a(Class<P> cls) {
        if (cls == null) {
            return null;
        }
        com.baidu.tbadk.tbplugin.a.a aVar = (com.baidu.tbadk.tbplugin.a.a) i.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbadk.tbplugin.a.a.class);
        if (aVar != null) {
            try {
                return (P) this.o.c().loadClass(aVar.b()).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                i.a(this.q, String.valueOf(cls.getName()) + " Nested Exception: " + e.getMessage());
            }
        }
        return null;
    }

    public synchronized <P> P b(Class<P> cls) {
        P p;
        if (!this.d) {
            j();
        }
        com.baidu.tbadk.tbplugin.a.c cVar = (com.baidu.tbadk.tbplugin.a.c) i.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbadk.tbplugin.a.c.class);
        if (cVar != null) {
            p = !b(cVar.a()) ? null : (P) this.g.get(cVar.a());
        } else {
            p = null;
        }
        return p;
    }

    public <P> void c(Class<P> cls) {
        com.baidu.tbadk.tbplugin.a.c cVar = (com.baidu.tbadk.tbplugin.a.c) i.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbadk.tbplugin.a.c.class);
        for (Object obj : this.g.values()) {
            if (obj.getClass().equals(cls)) {
                this.g.remove(cVar.a());
                return;
            }
        }
    }

    public void a(String str, String str2) {
        c.put(str, str2);
    }

    public Class<?> a(String str) {
        try {
            return Class.forName(c.get(str));
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NullPointerException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File b() {
        if (!this.i.exists()) {
            try {
                FileUtils.forceMkdir(this.i);
            } catch (IOException e) {
                i.b(this.q, String.valueOf(this.i.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c() {
        if (!this.k.exists()) {
            try {
                FileUtils.forceMkdir(this.k);
            } catch (IOException e) {
                i.b(this.q, String.valueOf(this.k.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File d() {
        if (!this.j.exists()) {
            try {
                FileUtils.forceMkdir(this.j);
            } catch (IOException e) {
                i.b(this.q, String.valueOf(this.j.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File e() {
        if (!this.l.exists()) {
            try {
                FileUtils.forceMkdir(this.l);
            } catch (IOException e) {
                i.b(this.q, String.valueOf(this.l.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File f() {
        if (!this.m.exists()) {
            try {
                FileUtils.forceMkdir(this.m);
            } catch (IOException e) {
                i.b(this.q, String.valueOf(this.m.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File g() {
        if (!this.n.exists()) {
            try {
                FileUtils.forceMkdir(this.n);
            } catch (IOException e) {
                i.b(this.q, String.valueOf(this.n.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor h() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginsConfig i() {
        return this.p.a();
    }

    public synchronized void j() {
        this.o.a();
        r();
        this.d = true;
    }

    public d k() {
        return this.o;
    }

    @Override // com.baidu.tbadk.tbplugin.n
    public void l() {
        this.p.a(this);
    }

    @Override // com.baidu.tbadk.tbplugin.n
    public void m() {
    }

    @Override // com.baidu.tbadk.tbplugin.r
    public void a(PluginsConfig pluginsConfig) {
        if (pluginsConfig != null) {
            BdLog.d(pluginsConfig.toString());
        }
    }

    public boolean b(String str) {
        for (String str2 : o()) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean c(String str) {
        for (Class<?> cls : this.h.a(3)) {
            if (((com.baidu.tbadk.tbplugin.a.c) i.a(cls, com.baidu.tbadk.tbplugin.a.c.class)).a().equals(str)) {
                return i.a(str);
            }
        }
        return false;
    }

    public boolean n() {
        for (Class<?> cls : this.h.a(3)) {
            if (i.a(((com.baidu.tbadk.tbplugin.a.c) i.a(cls, com.baidu.tbadk.tbplugin.a.c.class)).a())) {
                return true;
            }
        }
        return false;
    }

    public String[] o() {
        List<Class<?>> a2 = this.h.a(3);
        String[] strArr = new String[a2.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a2.size()) {
                strArr[i2] = ((com.baidu.tbadk.tbplugin.a.c) i.a(a2.get(i2), com.baidu.tbadk.tbplugin.a.c.class)).a();
                i = i2 + 1;
            } else {
                return strArr;
            }
        }
    }

    public PluginsConfig p() {
        return this.p.a();
    }

    public PluginsConfig.PluginConfig d(String str) {
        PluginsConfig a2;
        if (str != null && (a2 = this.p.a()) != null) {
            for (PluginsConfig.PluginConfig pluginConfig : a2.plugin_config) {
                if (pluginConfig.name.equals(str)) {
                    return pluginConfig;
                }
            }
            return null;
        }
        return null;
    }

    public void a(r rVar) {
        this.p.a(rVar);
    }

    public void q() {
        this.o.b();
        j();
    }

    public <P> String d(Class<P> cls) {
        return ((com.baidu.tbadk.tbplugin.a.c) i.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbadk.tbplugin.a.c.class)).a();
    }

    public <P> boolean e(Class<P> cls) {
        return e(d(cls));
    }

    public boolean e(String str) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            currentAccount = com.baidu.tbadk.core.account.a.c().getID();
        }
        if ("BdSocialShareSdk".equals(str)) {
            return com.baidu.tbadk.i.a().a("is_share_forbidden_" + currentAccount, false);
        }
        if ("motusdk".equals(str)) {
            return com.baidu.tbadk.i.a().b("is_motu_forbidden_" + currentAccount, false);
        }
        if ("browser".equals(str)) {
            return com.baidu.tbadk.i.a().a("is_browser_forbidden_" + currentAccount, false);
        }
        return false;
    }

    public void a(String str, boolean z) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if ("BdSocialShareSdk".equals(str)) {
            com.baidu.tbadk.i.a().c("is_share_forbidden_" + currentAccount, z);
        } else if ("motusdk".equals(str)) {
            com.baidu.tbadk.i.a().d("is_motu_forbidden_" + currentAccount, z);
        } else if ("browser".equals(str)) {
            com.baidu.tbadk.i.a().c("is_browser_forbidden_" + currentAccount, z);
        }
    }
}
