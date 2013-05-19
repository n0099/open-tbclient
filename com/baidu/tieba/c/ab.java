package com.baidu.tieba.c;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.lib.a.a {
    final /* synthetic */ aa a;
    private String b;

    public ab(aa aaVar, String str) {
        this.a = aaVar;
        this.b = null;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        if (this.b != null && !this.b.equals("tieba_resized_image")) {
            com.baidu.tieba.d.o.e("photos/" + this.b, "tieba_resized_image");
        }
        return com.baidu.tieba.d.e.a(com.baidu.tieba.d.e.a(com.baidu.tieba.d.o.c(null, "tieba_resized_image_display")), 5.0f);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        this.a.e = null;
        eVar = this.a.b;
        if (eVar != null) {
            eVar2 = this.a.b;
            eVar2.a(null);
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) bitmap);
        this.a.e = null;
        com.baidu.tieba.d.ae.a(getClass().getName(), "onPostExecute", "is Null?" + String.valueOf(bitmap == null));
        eVar = this.a.b;
        if (eVar != null) {
            eVar2 = this.a.b;
            eVar2.a(bitmap);
        }
    }
}
