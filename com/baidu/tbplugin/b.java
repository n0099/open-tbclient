package com.baidu.tbplugin;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.view.MotionEventCompat;
import com.baidu.tbplugin.exceptions.InstallException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends AsyncTask<Void, Integer, Void> {
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public synchronized Void doInBackground(Void... voidArr) {
        h hVar;
        h hVar2;
        try {
            a();
            File b = b();
            a(b);
            k b2 = b(FileUtils.getFile(b, "plugin.xml"));
            a(b2, b);
            b(b2, b);
            c(b);
            hVar2 = this.a.b;
            hVar2.a(0, null);
        } catch (InstallException e) {
            hVar = this.a.b;
            hVar.a(1, e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        h hVar;
        hVar = this.a.b;
        hVar.a(f.a(numArr[0].intValue(), numArr[1].intValue()));
    }

    private void a() {
        h hVar;
        Class cls;
        hVar = this.a.b;
        if (hVar != null) {
            cls = this.a.a;
            com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) f.a(cls, com.baidu.tbplugin.a.c.class);
            if (cVar == null || cVar.a().equals("")) {
                throw new InstallException("Plugin has no name");
            }
            this.b = cVar.a();
            return;
        }
        throw new InstallException("No installation callback");
    }

    private File b() {
        Context context;
        publishProgress(1, 0);
        try {
            context = this.a.c;
            File file = FileUtils.getFile(context.getFilesDir(), "tmp" + File.separator + this.b);
            FileUtils.deleteDirectory(file);
            FileUtils.forceMkdir(file);
            publishProgress(1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
            return file;
        } catch (IOException e) {
            throw new InstallException("Directory create failed: " + e.getMessage());
        }
    }

    private void a(File file) {
        Context context;
        publishProgress(2, 0);
        try {
            context = this.a.c;
            new c(context.getAssets().open(String.valueOf(this.b) + ".tbplugin"), file.getAbsolutePath()).a();
            publishProgress(2, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        } catch (IOException e) {
            throw new InstallException("Plugin files decompress failed.");
        }
    }

    private k b(File file) {
        publishProgress(3, 0);
        k kVar = new k(file);
        publishProgress(3, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        return kVar;
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
        publishProgress(4, 0);
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
            publishProgress(4, 85);
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
            publishProgress(4, 170);
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
            publishProgress(4, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
            return true;
        }
        throw new InstallException("Plugin has no name");
    }

    private void b(k kVar, File file) {
        try {
            publishProgress(5, 0);
            if (this.c) {
                FileUtils.copyFileToDirectory(new File(String.valueOf(file.getAbsolutePath()) + "/jar/" + kVar.b()), f.a());
            }
            publishProgress(5, 68);
            if (this.d) {
                FileUtils.copyDirectory(new File(String.format("%s/so/%s/", file.getAbsolutePath(), j.a)), f.c());
            }
            publishProgress(5, 136);
            if (this.e) {
                FileUtils.copyFileToDirectory(new File(String.valueOf(file.getAbsolutePath()) + "/res/" + kVar.c()), f.b());
            }
            publishProgress(5, 187);
            FileUtils.copyFile(new File(String.valueOf(file.getAbsolutePath()) + "/plugin.xml"), FileUtils.getFile(f.d(), String.valueOf(this.b) + ".xml"));
            publishProgress(5, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        } catch (Exception e) {
            throw new InstallException("Nested exception: " + e.getMessage());
        }
    }

    private void c(File file) {
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            throw new InstallException("Delete temporary files failed");
        }
    }
}
