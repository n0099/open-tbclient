package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<String, Integer, ax> {
    final /* synthetic */ au a;
    private com.baidu.tbadk.core.util.al b = null;
    private String c;
    private String d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar, String str, boolean z) {
        this.a = auVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = be.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ax doInBackground(String... strArr) {
        boolean z;
        String str;
        Exception e;
        ax axVar;
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
            str = String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(this.c) + "&imgtype=0") + "&qulity=" + bf.a().d());
        }
        try {
            byte[] imageData = this.a.b.getImageData();
            a = imageData != null ? com.baidu.tbadk.core.util.g.a(imageData) : null;
            if (a == null) {
                if (this.e && this.c.startsWith("/")) {
                    a = com.baidu.adp.lib.util.b.a().a(this.c);
                    if (a != null && imageData == null) {
                        imageData = com.baidu.adp.lib.util.b.a().a(a, 100);
                    }
                } else {
                    imageData = this.a.a(this.c);
                    if (imageData != null) {
                        a = com.baidu.tbadk.core.util.g.a(imageData);
                    }
                }
            }
            if (a == null) {
                if (!(TbadkApplication.m252getInst().getCapabilityOfWebp() && com.baidu.adp.lib.a.f.a().b("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) {
                    z3 = false;
                    str2 = str;
                } else {
                    str2 = String.valueOf(str.substring(0, lastIndexOf)) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                }
                this.b = new com.baidu.tbadk.core.util.al(str2);
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
                        BdLog.e("Webp decoding failed: " + str2);
                        TiebaStatic.imgError(this.b.a().a().f, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str2);
                        TbadkApplication.m252getInst().incWebpFailureCount();
                        this.b.a(str);
                        h = this.b.h();
                        if (this.b.a().b().b()) {
                            bitmap = com.baidu.tbadk.core.util.g.a(h);
                            this.a.a(this.c, h, false);
                            a = bitmap;
                            bArr = h;
                        }
                    }
                }
                bitmap = a;
                this.a.a(this.c, h, false);
                a = bitmap;
                bArr = h;
            } else {
                bArr = imageData;
            }
            axVar = new ax(this.a, null);
        } catch (Exception e2) {
            e = e2;
            axVar = null;
        }
        try {
            axVar.a = this.c;
            axVar.b = bArr;
            axVar.c = a;
            return axVar;
        } catch (Exception e3) {
            e = e3;
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return axVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ax axVar) {
        av avVar;
        av avVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (axVar != null) {
            avVar = this.a.e;
            if (avVar != null) {
                avVar2 = this.a.e;
                avVar2.a(axVar.a, axVar.b);
            }
            Bitmap bitmap = axVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.adp.lib.util.h.a(axVar.b)) {
                this.a.b.a(axVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(axVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
