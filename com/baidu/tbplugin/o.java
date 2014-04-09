package com.baidu.tbplugin;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbplugin.exceptions.UninstallException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ m a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Void a(Void... voidArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Void r2) {
        n nVar;
        n unused;
        nVar = this.a.c;
        if (nVar != null) {
            unused = this.a.c;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        n nVar;
        n unused;
        Integer[] numArr2 = numArr;
        nVar = this.a.c;
        if (nVar != null) {
            unused = this.a.c;
            numArr2[0].intValue();
            numArr2[1].intValue();
        }
    }

    private o(m mVar) {
        this.a = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(m mVar, byte b) {
        this(mVar);
    }

    private Void a() {
        Class cls;
        Class cls2;
        Context context;
        n nVar;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        n unused;
        c((Object[]) new Integer[]{1, 0});
        k a = k.a();
        cls = this.a.a;
        a.b(cls);
        c((Object[]) new Integer[]{1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
        cls2 = this.a.a;
        String a2 = ((com.baidu.tbplugin.a.c) cls2.getAnnotation(com.baidu.tbplugin.a.c.class)).a();
        context = this.a.b;
        File file = FileUtils.getFile(context.getDir("/plugins/", 0), a2);
        c((Object[]) new Integer[]{2, 0});
        l lVar = new l(file);
        c((Object[]) new Integer[]{2, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
        try {
            c((Object[]) new Integer[]{3, 0});
            try {
                if (lVar.b() != null) {
                    context5 = this.a.b;
                    FileUtils.forceDelete(FileUtils.getFile(context5.getDir("/plugins/libs/", 0), lVar.b()));
                }
                c((Object[]) new Integer[]{3, 102});
                if (lVar.d() != null) {
                    Iterator<String> it = lVar.d().iterator();
                    while (it.hasNext()) {
                        context4 = this.a.b;
                        FileUtils.forceDelete(FileUtils.getFile(context4.getDir(k.b, 0), it.next()));
                    }
                }
                c((Object[]) new Integer[]{3, 170});
                if (lVar.c() != null) {
                    context3 = this.a.b;
                    FileUtils.forceDelete(FileUtils.getFile(context3.getDir("/plugins/resources/", 0), lVar.c()));
                }
                c((Object[]) new Integer[]{3, 204});
                context2 = this.a.b;
                FileUtils.forceDelete(FileUtils.getFile(context2.getDir("/plugins/", 0), String.valueOf(lVar.a()) + ".xml"));
                return null;
            } catch (IOException e) {
                throw new UninstallException("Files delete failed");
            }
        } catch (UninstallException e2) {
            nVar = this.a.c;
            if (nVar != null) {
                unused = this.a.c;
                e2.getMessage();
                return null;
            }
            return null;
        }
    }
}
