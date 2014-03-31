package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aj extends BdAsyncTask<String, Integer, ak> {
    final /* synthetic */ ah a;
    private com.baidu.tbadk.core.util.ak b = null;
    private String c;
    private String d;
    private final boolean e;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ ak a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(ak akVar) {
        ai aiVar;
        ai unused;
        ak akVar2 = akVar;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (akVar2 != null) {
            aiVar = this.a.e;
            if (aiVar != null) {
                unused = this.a.e;
                String str = akVar2.a;
                byte[] bArr = akVar2.b;
            }
            Bitmap bitmap = akVar2.c;
            if (bitmap == null) {
                this.a.b.k();
            } else if (com.baidu.adp.lib.util.i.a(akVar2.b)) {
                this.a.b.a(akVar2.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(akVar2.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar, String str, boolean z) {
        this.a = ahVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = bc.f(str);
        this.e = z;
    }

    private ak a() {
        boolean z;
        String str;
        Exception e;
        ak akVar;
        Bitmap a;
        byte[] bArr;
        String str2;
        boolean z2;
        Bitmap bitmap;
        int lastIndexOf;
        boolean z3 = true;
        if (this.c == null || this.d == null) {
            return null;
        }
        if (this.c != null && this.c.startsWith("width=")) {
            this.a.f = false;
        }
        z = this.a.f;
        if (z) {
            str = this.c;
        } else {
            str = String.valueOf(com.baidu.tbadk.core.data.n.d) + (String.valueOf(String.valueOf(this.c) + "&imgtype=0") + "&qulity=" + bd.a().d());
        }
        try {
            byte[] imageData = this.a.b.getImageData();
            a = imageData != null ? com.baidu.tbadk.core.util.g.a(imageData) : null;
            if (a == null) {
                if (this.e && this.c.startsWith("/")) {
                    com.baidu.adp.lib.util.b.a();
                    a = com.baidu.adp.lib.util.b.a(this.c);
                    if (a != null && imageData == null) {
                        com.baidu.adp.lib.util.b.a();
                        imageData = com.baidu.adp.lib.util.b.a(a, 100);
                    }
                } else {
                    imageData = com.baidu.tbadk.core.util.w.e("image", this.d);
                    if (imageData != null) {
                        a = com.baidu.tbadk.core.util.g.a(imageData);
                    }
                }
            }
            if (a == null) {
                if (!(TbadkApplication.j().au() && com.baidu.adp.lib.a.f.a().b("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) {
                    z3 = false;
                    str2 = str;
                } else {
                    str2 = String.valueOf(str.substring(0, lastIndexOf)) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                }
                this.b = new com.baidu.tbadk.core.util.ak(str2);
                com.baidu.tbadk.core.util.a.b a2 = this.b.a().a();
                z2 = this.a.f;
                a2.e = z2;
                if (this.a.c != null && (this.a.c instanceof com.baidu.tbadk.coreExtra.data.e)) {
                    if (((com.baidu.tbadk.coreExtra.data.e) this.a.c).a() != null) {
                        this.b.a("fid", ((com.baidu.tbadk.coreExtra.data.e) this.a.c).a());
                    }
                    if (((com.baidu.tbadk.coreExtra.data.e) this.a.c).b() != null) {
                        this.b.a("tid", ((com.baidu.tbadk.coreExtra.data.e) this.a.c).b());
                    }
                    if (((com.baidu.tbadk.coreExtra.data.e) this.a.c).c() != null) {
                        this.b.a("fname", ((com.baidu.tbadk.coreExtra.data.e) this.a.c).c());
                    }
                }
                this.b.a().a().a().e = true;
                byte[] h = this.b.h();
                if (this.b.a().b().b()) {
                    a = com.baidu.tbadk.core.util.g.a(h);
                    if (z3 && a == null) {
                        com.baidu.adp.lib.util.f.b("Webp decoding failed: " + str2);
                        TiebaStatic.a(this.b.a().a().f, -1012, "Webp decoding failed.", str2);
                        TbadkApplication.j().av();
                        this.b.a(str);
                        h = this.b.h();
                        if (this.b.a().b().b()) {
                            bitmap = com.baidu.tbadk.core.util.g.a(h);
                            com.baidu.tbadk.core.util.w.a("image", this.d, h);
                            a = bitmap;
                            bArr = h;
                        }
                    }
                }
                bitmap = a;
                com.baidu.tbadk.core.util.w.a("image", this.d, h);
                a = bitmap;
                bArr = h;
            } else {
                bArr = imageData;
            }
            akVar = new ak(this.a, (byte) 0);
        } catch (Exception e2) {
            e = e2;
            akVar = null;
        }
        try {
            akVar.a = this.c;
            akVar.b = bArr;
            akVar.c = a;
            return akVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return akVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
