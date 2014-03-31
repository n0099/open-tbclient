package com.baidu.tbplugin;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbplugin.exceptions.InstallException;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ a a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Void a(Void... voidArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        i iVar;
        i unused;
        Integer[] numArr2 = numArr;
        iVar = this.a.b;
        if (iVar != null) {
            unused = this.a.b;
            numArr2[0].intValue();
            numArr2[1].intValue();
        }
    }

    private b(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized Void a() {
        i iVar;
        Void r0;
        i iVar2;
        Class cls;
        com.baidu.tbplugin.a.c cVar;
        Class cls2;
        Context context;
        i iVar3;
        i iVar4;
        boolean z;
        Class cls3;
        Context context2;
        Context unused;
        try {
            cls = this.a.a;
            cVar = (com.baidu.tbplugin.a.c) cls.getAnnotation(com.baidu.tbplugin.a.c.class);
        } catch (InstallException e) {
            iVar = this.a.b;
            if (iVar != null) {
                iVar2 = this.a.b;
                iVar2.a(e.getErr(), e.getMessage());
            }
            if (e.getErr() != 9) {
                unused = this.a.c;
                String pluginName = e.getPluginName();
                String message = e.getMessage();
                com.baidu.adp.lib.stats.g.a().a("plugin", "install", 1, "failed", message, pluginName);
                com.baidu.adp.lib.util.f.b("Plugin install failed: " + pluginName + ": " + message);
            }
            r0 = null;
        }
        if (cVar == null || cVar.a().equals("")) {
            throw new InstallException("", 1);
        }
        this.b = cVar.a();
        cls2 = this.a.a;
        com.baidu.tbplugin.a.c cVar2 = (com.baidu.tbplugin.a.c) cls2.getAnnotation(com.baidu.tbplugin.a.c.class);
        if (cVar2 != null && FileUtils.getFile(k.a().e(), new StringBuilder().append(cVar2).append(".xml").toString()).exists()) {
            z = this.a.d;
            if (!z) {
                throw new InstallException(this.b, 9);
            }
            cls3 = this.a.a;
            context2 = this.a.c;
            new m(cls3, context2, null).a();
        }
        File e2 = e();
        c((Object[]) new Integer[]{2, 0});
        try {
            context = this.a.c;
            new d(context.getAssets().open(String.valueOf(this.b) + ".tbplugin"), e2.getAbsolutePath()).a();
            c((Object[]) new Integer[]{2, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
            File file = FileUtils.getFile(e2, "plugin.xml");
            c((Object[]) new Integer[]{3, 0});
            l lVar = new l(file);
            c((Object[]) new Integer[]{3, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
            if (lVar == null) {
                throw new InstallException(this.b, 16);
            }
            a(lVar, e2);
            try {
                c((Object[]) new Integer[]{5, 0});
                if (this.c) {
                    FileUtils.copyFileToDirectory(new File(String.valueOf(e2.getAbsolutePath()) + "/jar/" + lVar.b()), k.a().b());
                }
                c((Object[]) new Integer[]{5, 68});
                if (this.d) {
                    FileUtils.copyDirectory(new File(String.format("%s/so/%s/", e2.getAbsolutePath(), k.a)), k.a().d());
                }
                c((Object[]) new Integer[]{5, 136});
                if (this.e) {
                    FileUtils.copyFileToDirectory(new File(String.valueOf(e2.getAbsolutePath()) + "/res/" + lVar.c()), k.a().c());
                }
                c((Object[]) new Integer[]{5, 187});
                FileUtils.copyFile(new File(String.valueOf(e2.getAbsolutePath()) + "/plugin.xml"), FileUtils.getFile(k.a().e(), String.valueOf(this.b) + ".xml"));
                c((Object[]) new Integer[]{5, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
                try {
                    FileUtils.deleteDirectory(e2);
                    iVar3 = this.a.b;
                    if (iVar3 != null) {
                        iVar4 = this.a.b;
                        iVar4.a(0, null);
                    }
                    r0 = null;
                } catch (Exception e3) {
                    throw new InstallException(this.b, 8);
                }
            } catch (Exception e4) {
                throw new InstallException(this.b, 7);
            }
        } catch (Exception e5) {
            throw new InstallException(this.b, 3);
        }
        return r0;
    }

    private File e() {
        Context context;
        c((Object[]) new Integer[]{1, 0});
        try {
            context = this.a.c;
            File file = FileUtils.getFile(context.getFilesDir(), "tmp" + File.separator + this.b);
            if (file != null) {
                FileUtils.deleteDirectory(file);
                FileUtils.forceMkdir(file);
            }
            c((Object[]) new Integer[]{1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
            return file;
        } catch (Exception e) {
            throw new InstallException(this.b, 2);
        }
    }

    private boolean a(l lVar, File file) {
        Class cls;
        boolean z;
        Class cls2;
        boolean z2;
        Class cls3;
        boolean z3;
        c((Object[]) new Integer[]{4, 0});
        if (this.b.equals(lVar.a())) {
            cls = this.a.a;
            com.baidu.tbplugin.a.a aVar = (com.baidu.tbplugin.a.a) cls.getAnnotation(com.baidu.tbplugin.a.a.class);
            boolean z4 = (aVar == null || aVar.a().length() == 0) ? false : true;
            String b = lVar.b();
            if (b == null || b.length() == 0) {
                z = false;
            } else if (!new File(String.valueOf(file.getAbsolutePath()) + "/jar/" + b).exists()) {
                throw new InstallException(this.b, 4);
            } else {
                z = true;
            }
            this.c = z4 && z && b.equals(aVar.a());
            c((Object[]) new Integer[]{4, 85});
            cls2 = this.a.a;
            com.baidu.tbplugin.a.d dVar = (com.baidu.tbplugin.a.d) cls2.getAnnotation(com.baidu.tbplugin.a.d.class);
            boolean z5 = (dVar == null || dVar.a().length() == 0) ? false : true;
            String c = lVar.c();
            if (c == null || c.length() == 0) {
                z2 = false;
            } else if (!new File(String.valueOf(file.getAbsolutePath()) + "/res/" + c).exists()) {
                throw new InstallException(this.b, 5);
            } else {
                z2 = true;
            }
            this.e = z5 && z2 && c.equals(dVar.a());
            c((Object[]) new Integer[]{4, 170});
            cls3 = this.a.a;
            com.baidu.tbplugin.a.b bVar = (com.baidu.tbplugin.a.b) cls3.getAnnotation(com.baidu.tbplugin.a.b.class);
            if (bVar != null) {
                String[] a = bVar.a();
                int length = a.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z3 = true;
                        break;
                    } else if (a[i].length() == 0) {
                        z3 = false;
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                z3 = false;
            }
            List<String> d = lVar.d();
            boolean z6 = (d == null || d.size() == 0) ? false : true;
            if (z3 && z6 && d.size() == bVar.a().length) {
                this.d = true;
                Iterator<String> it = d.iterator();
                while (it.hasNext()) {
                    if (!new File(String.format("%s/so/%s/%s", file.getAbsolutePath(), k.a, it.next())).exists()) {
                        throw new InstallException(this.b, 6);
                    }
                }
                String[] a2 = bVar.a();
                int length2 = a2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    } else if (d.contains(a2[i2])) {
                        i2++;
                    } else {
                        this.d = false;
                        break;
                    }
                }
            }
            c((Object[]) new Integer[]{4, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
            return true;
        }
        throw new InstallException(this.b, 1);
    }
}
