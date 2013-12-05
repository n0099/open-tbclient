package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.x;
/* loaded from: classes.dex */
class h extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1624a;

    private h(f fVar) {
        this.f1624a = fVar;
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
        return x.c(null, "tieba_group_image");
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
        super.a((h) bitmap);
        if (bitmap != null) {
            this.f1624a.c.setVisibility(0);
            f.a(this.f1624a, new com.baidu.adp.widget.ImageView.e(bitmap, false, null));
            f.a(this.f1624a).a(this.f1624a.c);
        }
    }
}
