package com.baidu.tbadk.coreExtra.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<String, Integer, ay> {
    final /* synthetic */ av a;
    private com.baidu.tbadk.core.util.httpNet.k b = null;
    private String c;
    private String d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar, String str, boolean z) {
        this.a = avVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = ba.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public ay doInBackground(String... strArr) {
        boolean z;
        String str;
        ay ayVar;
        Exception e;
        boolean z2;
        String str2;
        boolean z3;
        byte[] bArr;
        Bitmap bitmap;
        boolean z4;
        int lastIndexOf;
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
            str = String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(this.c) + "&imgtype=0") + "&qulity=" + bb.a().d());
        }
        try {
            byte[] imageData = this.a.b.getImageData();
            Bitmap a = imageData != null ? com.baidu.tbadk.core.util.d.a(imageData) : null;
            if (a == null) {
                if (this.e && this.c.startsWith("/")) {
                    a = com.baidu.adp.lib.util.b.a().a(this.c);
                    if (a != null && imageData == null) {
                        imageData = com.baidu.adp.lib.util.b.a().a(a, 100);
                    }
                } else {
                    imageData = this.a.a(this.c);
                    if (imageData != null) {
                        a = com.baidu.tbadk.core.util.d.a(imageData);
                    }
                }
            }
            if (a == null) {
                if (!(TbadkApplication.m252getInst().getCapabilityOfWebp() && com.baidu.adp.lib.a.f.a().b("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) {
                    z2 = false;
                    str2 = str;
                } else {
                    z2 = true;
                    str2 = String.valueOf(str.substring(0, lastIndexOf)) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                }
                this.b = new com.baidu.tbadk.core.util.httpNet.k();
                com.baidu.tbadk.core.util.httpNet.k kVar = this.b;
                z3 = this.a.f;
                byte[] a2 = kVar.a(str2, !z3);
                if (this.b.b()) {
                    a = com.baidu.tbadk.core.util.d.a(a2);
                    if (z2 && a == null) {
                        TiebaStatic.imgError(this.b.a, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str2);
                        TbadkApplication.m252getInst().incWebpFailureCount();
                        com.baidu.tbadk.core.util.httpNet.k kVar2 = this.b;
                        z4 = this.a.f;
                        bArr = kVar2.a(str, !z4);
                        bitmap = (bArr == null || !this.b.b()) ? a : com.baidu.tbadk.core.util.d.a(bArr);
                        this.a.a(this.c, bArr, false);
                        a = bitmap;
                        imageData = bArr;
                    }
                }
                bArr = a2;
                bitmap = a;
                this.a.a(this.c, bArr, false);
                a = bitmap;
                imageData = bArr;
            }
            ayVar = new ay(this.a, null);
            try {
                ayVar.a = this.c;
                ayVar.b = imageData;
                ayVar.c = a;
                return ayVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return ayVar;
            }
        } catch (Exception e3) {
            ayVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ay ayVar) {
        aw awVar;
        aw awVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (ayVar != null) {
            awVar = this.a.e;
            if (awVar != null) {
                awVar2 = this.a.e;
                awVar2.a(ayVar.a, ayVar.b);
            }
            Bitmap bitmap = ayVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.adp.lib.util.j.a(ayVar.b)) {
                this.a.b.a(ayVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(ayVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.a.b.setImageDrawable(null);
        this.a.a.setVisibility(0);
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.a();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
