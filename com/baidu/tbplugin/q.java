package com.baidu.tbplugin;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbplugin.exceptions.UninstallException;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ o a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Void r2) {
        p pVar;
        p unused;
        pVar = this.a.c;
        if (pVar != null) {
            unused = this.a.c;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(Integer... numArr) {
        p pVar;
        p unused;
        Integer[] numArr2 = numArr;
        pVar = this.a.c;
        if (pVar != null) {
            unused = this.a.c;
            f.a(numArr2[0].intValue(), numArr2[1].intValue());
        }
    }

    private q(o oVar) {
        this.a = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(o oVar, byte b) {
        this(oVar);
    }

    private Void d() {
        Class cls;
        Class cls2;
        Context context;
        p pVar;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        p unused;
        c((Object[]) new Integer[]{1, 0});
        j a = j.a();
        cls = this.a.a;
        a.b(cls);
        c((Object[]) new Integer[]{1, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
        cls2 = this.a.a;
        String a2 = ((com.baidu.tbplugin.a.c) f.a(cls2, com.baidu.tbplugin.a.c.class)).a();
        context = this.a.b;
        File file = FileUtils.getFile(context.getDir("/plugins/", 0), a2);
        c((Object[]) new Integer[]{2, 0});
        k kVar = new k(file);
        c((Object[]) new Integer[]{2, Integer.valueOf((int) MotionEventCompat.ACTION_MASK)});
        try {
            c((Object[]) new Integer[]{3, 0});
            try {
                if (kVar.b() != null) {
                    context5 = this.a.b;
                    FileUtils.forceDelete(FileUtils.getFile(context5.getDir("/plugins/libs/", 0), kVar.b()));
                }
                c((Object[]) new Integer[]{3, Integer.valueOf((int) SocialAPIErrorCodes.ERROR_INVALID_SESSION_KEY)});
                if (kVar.d() != null) {
                    Iterator<String> it = kVar.d().iterator();
                    while (it.hasNext()) {
                        context4 = this.a.b;
                        FileUtils.forceDelete(FileUtils.getFile(context4.getDir(j.b, 0), it.next()));
                    }
                }
                c((Object[]) new Integer[]{3, 170});
                if (kVar.c() != null) {
                    context3 = this.a.b;
                    FileUtils.forceDelete(FileUtils.getFile(context3.getDir("/plugins/resources/", 0), kVar.c()));
                }
                c((Object[]) new Integer[]{3, 204});
                context2 = this.a.b;
                FileUtils.forceDelete(FileUtils.getFile(context2.getDir("/plugins/", 0), String.valueOf(kVar.a()) + ".xml"));
                return null;
            } catch (IOException e) {
                throw new UninstallException("Files delete failed");
            }
        } catch (UninstallException e2) {
            pVar = this.a.c;
            if (pVar != null) {
                unused = this.a.c;
                e2.getMessage();
                return null;
            }
            return null;
        }
    }
}
