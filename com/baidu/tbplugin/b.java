package com.baidu.tbplugin;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbplugin.exceptions.InstallException;
import java.io.File;
import java.io.IOException;
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
    public final /* synthetic */ Void a(Void... voidArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        h hVar;
        h unused;
        Integer[] numArr2 = numArr;
        hVar = this.a.b;
        if (hVar != null) {
            unused = this.a.b;
            f.a(numArr2[0].intValue(), numArr2[1].intValue());
        }
    }

    private b(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    private synchronized Void d() {
        h hVar;
        h hVar2;
        h hVar3;
        Class cls;
        Class cls2;
        Context context;
        h hVar4;
        h hVar5;
        Class cls3;
        Context context2;
        try {
            hVar3 = this.a.b;
        } catch (InstallException e) {
            hVar = this.a.b;
            if (hVar != null) {
                hVar2 = this.a.b;
                hVar2.a(1, e.getMessage());
            }
        }
        if (hVar3 == null) {
            throw new InstallException("No installation callback");
        }
        cls = this.a.a;
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) f.a(cls, com.baidu.tbplugin.a.c.class);
        if (cVar == null || cVar.a().equals("")) {
            throw new InstallException("Plugin has no name");
        }
        this.b = cVar.a();
        cls2 = this.a.a;
        if (f.a(cls2)) {
            cls3 = this.a.a;
            context2 = this.a.c;
            new o(cls3, context2, null).a();
        }
        File e2 = e();
        c((Object[]) new Integer[]{2, 0});
        try {
            context = this.a.c;
            new c(context.getAssets().open(String.valueOf(this.b) + ".tbplugin"), e2.getAbsolutePath()).a();
            c((Object[]) new Integer[]{2, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
            File file = FileUtils.getFile(e2, "plugin.xml");
            c((Object[]) new Integer[]{3, 0});
            k kVar = new k(file);
            c((Object[]) new Integer[]{3, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
            a(kVar, e2);
            try {
                c((Object[]) new Integer[]{5, 0});
                if (this.c) {
                    FileUtils.copyFileToDirectory(new File(String.valueOf(e2.getAbsolutePath()) + "/jar/" + kVar.b()), f.a());
                }
                c((Object[]) new Integer[]{5, 68});
                if (this.d) {
                    FileUtils.copyDirectory(new File(String.format("%s/so/%s/", e2.getAbsolutePath(), j.a)), f.c());
                }
                c((Object[]) new Integer[]{5, 136});
                if (this.e) {
                    FileUtils.copyFileToDirectory(new File(String.valueOf(e2.getAbsolutePath()) + "/res/" + kVar.c()), f.b());
                }
                c((Object[]) new Integer[]{5, 187});
                FileUtils.copyFile(new File(String.valueOf(e2.getAbsolutePath()) + "/plugin.xml"), FileUtils.getFile(f.d(), String.valueOf(this.b) + ".xml"));
                c((Object[]) new Integer[]{5, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
                try {
                    FileUtils.deleteDirectory(e2);
                    hVar4 = this.a.b;
                    if (hVar4 != null) {
                        hVar5 = this.a.b;
                        hVar5.a(0, null);
                    }
                } catch (IOException e3) {
                    throw new InstallException("Delete temporary files failed");
                }
            } catch (Exception e4) {
                throw new InstallException("Nested exception: " + e4.getMessage());
            }
        } catch (IOException e5) {
            throw new InstallException("Plugin files decompress failed.");
        }
        return null;
    }

    private File e() {
        Context context;
        c((Object[]) new Integer[]{1, 0});
        try {
            context = this.a.c;
            File file = FileUtils.getFile(context.getFilesDir(), "tmp" + File.separator + this.b);
            FileUtils.deleteDirectory(file);
            FileUtils.forceMkdir(file);
            c((Object[]) new Integer[]{1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
            return file;
        } catch (IOException e) {
            throw new InstallException("Directory create failed: " + e.getMessage());
        }
    }

    private boolean a(k kVar, File file) {
        Class cls;
        boolean z;
        Class cls2;
        boolean z2;
        Class cls3;
        boolean z3;
        File file2;
        File file3;
        File file4;
        c((Object[]) new Integer[]{4, 0});
        if (kVar.a().equals(this.b)) {
            cls = this.a.a;
            com.baidu.tbplugin.a.a aVar = (com.baidu.tbplugin.a.a) f.a(cls, com.baidu.tbplugin.a.a.class);
            boolean z4 = (aVar == null || aVar.a().length() == 0) ? false : true;
            String b = kVar.b();
            if (b == null || b.length() == 0) {
                z = false;
            } else {
                if (!new File(String.valueOf(file.getAbsolutePath()) + "/jar/" + b).exists()) {
                    throw new InstallException("Plugin missing jar files: " + file4.getAbsoluteFile());
                }
                z = true;
            }
            this.c = z4 && z && b.equals(aVar.a());
            c((Object[]) new Integer[]{4, 85});
            cls2 = this.a.a;
            com.baidu.tbplugin.a.d dVar = (com.baidu.tbplugin.a.d) f.a(cls2, com.baidu.tbplugin.a.d.class);
            boolean z5 = (dVar == null || dVar.a().length() == 0) ? false : true;
            String c = kVar.c();
            if (c == null || c.length() == 0) {
                z2 = false;
            } else {
                if (!new File(String.valueOf(file.getAbsolutePath()) + "/res/" + c).exists()) {
                    throw new InstallException("Plugin missing res files " + file3.getAbsolutePath());
                }
                z2 = true;
            }
            this.e = z5 && z2 && c.equals(dVar.a());
            c((Object[]) new Integer[]{4, 170});
            cls3 = this.a.a;
            com.baidu.tbplugin.a.b bVar = (com.baidu.tbplugin.a.b) f.a(cls3, com.baidu.tbplugin.a.b.class);
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
            List<String> d = kVar.d();
            boolean z6 = (d == null || d.size() == 0) ? false : true;
            if (z3 && z6 && d.size() == bVar.a().length) {
                this.d = true;
                Iterator<String> it = d.iterator();
                while (it.hasNext()) {
                    if (!new File(String.format("%s/so/%s/%s", file.getAbsolutePath(), j.a, it.next())).exists()) {
                        throw new InstallException("Plugin missing SO files " + file2.getAbsolutePath());
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
        throw new InstallException("Plugin has no name");
    }
}
