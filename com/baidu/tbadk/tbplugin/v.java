package com.baidu.tbadk.tbplugin;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.tbplugin.exceptions.UninstallException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ t a;

    private v(t tVar) {
        this.a = tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(t tVar, v vVar) {
        this(tVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        Class cls;
        Context context;
        u uVar;
        u uVar2;
        a();
        cls = this.a.a;
        String a = ((com.baidu.tbadk.tbplugin.a.c) i.a(cls, com.baidu.tbadk.tbplugin.a.c.class)).a();
        context = this.a.b;
        try {
            a(a(FileUtils.getFile(context.getDir("/plugins/", 0), a)));
            return null;
        } catch (UninstallException e) {
            uVar = this.a.c;
            if (uVar != null) {
                uVar2 = this.a.c;
                uVar2.a(1, e.getMessage());
                return null;
            }
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Void r4) {
        u uVar;
        u uVar2;
        uVar = this.a.c;
        if (uVar != null) {
            uVar2 = this.a.c;
            uVar2.a(0, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        u uVar;
        u uVar2;
        uVar = this.a.c;
        if (uVar != null) {
            uVar2 = this.a.c;
            uVar2.a(i.a(numArr[0].intValue(), numArr[1].intValue()));
        }
    }

    private void a() {
        Class cls;
        publishProgress(1, 0);
        m a = m.a();
        cls = this.a.a;
        a.c(cls);
        publishProgress(1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
    }

    private s a(File file) {
        publishProgress(2, 0);
        s sVar = new s(file);
        publishProgress(2, Integer.valueOf((int) MotionEventCompat.ACTION_MASK));
        return sVar;
    }

    private void a(s sVar) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        publishProgress(3, 0);
        try {
            if (sVar.b() != null) {
                context4 = this.a.b;
                FileUtils.forceDelete(FileUtils.getFile(context4.getDir("/plugins/libs/", 0), sVar.b()));
            }
            publishProgress(3, 102);
            if (sVar.e() != null) {
                Iterator<String> it = sVar.e().iterator();
                while (it.hasNext()) {
                    context3 = this.a.b;
                    FileUtils.forceDelete(FileUtils.getFile(context3.getDir(m.b, 0), it.next()));
                }
            }
            publishProgress(3, 170);
            if (sVar.d() != null) {
                context2 = this.a.b;
                FileUtils.forceDelete(FileUtils.getFile(context2.getDir("/plugins/resources/", 0), sVar.d()));
            }
            publishProgress(3, 204);
            context = this.a.b;
            FileUtils.forceDelete(FileUtils.getFile(context.getDir("/plugins/", 0), String.valueOf(sVar.a()) + ".xml"));
        } catch (IOException e) {
            throw new UninstallException("Files delete failed");
        }
    }
}
