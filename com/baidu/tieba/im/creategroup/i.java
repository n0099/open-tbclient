package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ h a;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(Object... objArr) {
        return af.c(null, "tieba_group_image");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        super.a((i) bitmap2);
        if (bitmap2 != null) {
            this.a.c.setVisibility(0);
            h.a(this.a, new com.baidu.adp.widget.ImageView.b(bitmap2, false, null));
            h.a(this.a).a(this.a.c);
        }
    }

    private i(h hVar) {
        this.a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(h hVar, byte b) {
        this(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }
}
