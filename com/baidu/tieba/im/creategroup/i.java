package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.af;
/* loaded from: classes.dex */
class i extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ h a;

    private i(h hVar) {
        this.a = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(h hVar, i iVar) {
        this(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return af.c(null, "tieba_group_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        super.a((i) bitmap);
        if (bitmap != null) {
            this.a.c.setVisibility(0);
            h.a(this.a, new com.baidu.adp.widget.ImageView.b(bitmap, false, null));
            h.a(this.a).a(this.a.c);
        }
    }
}
