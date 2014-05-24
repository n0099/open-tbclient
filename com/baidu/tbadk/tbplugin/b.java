package com.baidu.tbadk.tbplugin;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.tbplugin.exceptions.InstallException;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ a a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;

    private b(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public synchronized Void doInBackground(Void... voidArr) {
        k kVar;
        Context context;
        k kVar2;
        k kVar3;
        Context context2;
        k kVar4;
        File b;
        s b2;
        k kVar5;
        k kVar6;
        try {
            a();
            b = b();
            a(b);
            b2 = b(FileUtils.getFile(b, "plugin.xml"));
        } catch (InstallException e) {
            kVar3 = this.a.b;
            if (kVar3 != null) {
                kVar4 = this.a.b;
                kVar4.onFinish(e.getErr(), e.getMessage());
            }
            if (e.getErr() != 9) {
                context2 = this.a.c;
                i.a(context2, e.getPluginName(), e.getMessage());
            }
        } catch (StackOverflowError e2) {
            kVar = this.a.b;
            if (kVar != null) {
                kVar2 = this.a.b;
                kVar2.onFinish(-1, e2.getMessage());
            }
            context = this.a.c;
            i.a(context, "unknown", e2.getMessage());
        }
        if (b2 == null) {
            throw new InstallException(this.b, 16);
        }
        a(b2, b);
        b(b2, b);
        c(b);
        kVar5 = this.a.b;
        if (kVar5 != null) {
            kVar6 = this.a.b;
            kVar6.onFinish(0, null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        k kVar;
        k kVar2;
        kVar = this.a.b;
        if (kVar != null) {
            kVar2 = this.a.b;
            kVar2.onProgress(i.a(numArr[0].intValue(), numArr[1].intValue()));
        }
    }

    private void a() {
        Class cls;
        Class cls2;
        boolean z;
        Class cls3;
        Context context;
        cls = this.a.a;
        com.baidu.tbadk.tbplugin.a.c cVar = (com.baidu.tbadk.tbplugin.a.c) i.a(cls, com.baidu.tbadk.tbplugin.a.c.class);
        if (cVar == null || cVar.a().equals("")) {
            throw new InstallException("", 1);
        }
        this.b = cVar.a();
        cls2 = this.a.a;
        if (i.a(cls2)) {
            z = this.a.d;
            if (z) {
                cls3 = this.a.a;
                context = this.a.c;
                new t(cls3, context, null).a();
                return;
            }
            throw new InstallException(this.b, 9);
        }
    }

    private File b() {
        Context context;
        publishProgress(1, 0);
        try {
            context = this.a.c;
            File file = FileUtils.getFile(context.getFilesDir(), "tmp" + File.separator + this.b);
            if (file != null) {
                FileUtils.deleteDirectory(file);
                FileUtils.forceMkdir(file);
            }
            publishProgress(1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
            return file;
        } catch (Exception e) {
            throw new InstallException(this.b, 2);
        }
    }

    private void a(File file) {
        Context context;
        publishProgress(2, 0);
        try {
            context = this.a.c;
            new c(context.getAssets().open(String.valueOf(this.b) + ".tbplugin"), file.getAbsolutePath()).a();
            publishProgress(2, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        } catch (Exception e) {
            throw new InstallException(this.b, 3);
        }
    }

    private s b(File file) {
        publishProgress(3, 0);
        s sVar = new s(file);
        publishProgress(3, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        return sVar;
    }

    private boolean a(s sVar, File file) {
        Class cls;
        boolean z;
        Class cls2;
        boolean z2;
        Class cls3;
        boolean z3;
        publishProgress(4, 0);
        if (this.b.equals(sVar.a())) {
            cls = this.a.a;
            com.baidu.tbadk.tbplugin.a.a aVar = (com.baidu.tbadk.tbplugin.a.a) i.a(cls, com.baidu.tbadk.tbplugin.a.a.class);
            boolean z4 = (aVar == null || aVar.a().length() == 0) ? false : true;
            String b = sVar.b();
            if (b == null || b.length() == 0) {
                z = false;
            } else if (!new File(String.valueOf(file.getAbsolutePath()) + "/jar/" + b).exists()) {
                throw new InstallException(this.b, 4);
            } else {
                z = true;
            }
            this.c = z4 && z && b.equals(aVar.a());
            publishProgress(4, 85);
            cls2 = this.a.a;
            com.baidu.tbadk.tbplugin.a.d dVar = (com.baidu.tbadk.tbplugin.a.d) i.a(cls2, com.baidu.tbadk.tbplugin.a.d.class);
            boolean z5 = (dVar == null || dVar.a().length() == 0) ? false : true;
            String d = sVar.d();
            if (d == null || d.length() == 0) {
                z2 = false;
            } else if (!new File(String.valueOf(file.getAbsolutePath()) + "/res/" + d).exists()) {
                throw new InstallException(this.b, 5);
            } else {
                z2 = true;
            }
            this.e = z5 && z2 && d.equals(dVar.a());
            publishProgress(4, 170);
            cls3 = this.a.a;
            com.baidu.tbadk.tbplugin.a.b bVar = (com.baidu.tbadk.tbplugin.a.b) i.a(cls3, com.baidu.tbadk.tbplugin.a.b.class);
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
            List<String> e = sVar.e();
            boolean z6 = (e == null || e.size() == 0) ? false : true;
            if (z3 && z6 && e.size() == bVar.a().length) {
                this.d = true;
                Iterator<String> it = e.iterator();
                while (it.hasNext()) {
                    if (!new File(String.format("%s/so/%s/%s", file.getAbsolutePath(), m.a, it.next())).exists()) {
                        throw new InstallException(this.b, 6);
                    }
                }
                String[] a2 = bVar.a();
                int length2 = a2.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    } else if (e.contains(a2[i2])) {
                        i2++;
                    } else {
                        this.d = false;
                        break;
                    }
                }
            }
            publishProgress(4, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
            return true;
        }
        throw new InstallException(this.b, 1);
    }

    private void b(s sVar, File file) {
        try {
            publishProgress(5, 0);
            if (this.c) {
                FileUtils.copyFileToDirectory(new File(String.valueOf(file.getAbsolutePath()) + "/jar/" + sVar.b()), i.a());
            }
            publishProgress(5, 68);
            if (this.d) {
                FileUtils.copyDirectory(new File(String.format("%s/so/%s/", file.getAbsolutePath(), m.a)), i.c());
            }
            publishProgress(5, 136);
            if (this.e) {
                FileUtils.copyFileToDirectory(new File(String.valueOf(file.getAbsolutePath()) + "/res/" + sVar.d()), i.b());
            }
            publishProgress(5, 187);
            FileUtils.copyFile(new File(String.valueOf(file.getAbsolutePath()) + "/plugin.xml"), FileUtils.getFile(i.d(), String.valueOf(this.b) + ".xml"));
            publishProgress(5, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        } catch (Exception e) {
            throw new InstallException(this.b, 7);
        }
    }

    private void c(File file) {
        try {
            FileUtils.deleteDirectory(file);
        } catch (Exception e) {
            throw new InstallException(this.b, 8);
        }
    }
}
