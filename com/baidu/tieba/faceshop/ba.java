package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.g {
    final /* synthetic */ FacePackageData a;
    final /* synthetic */ ay b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ay ayVar, FacePackageData facePackageData) {
        this.b = ayVar;
        this.a = facePackageData;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        if (obj == null || !(obj instanceof FacePackageDownloadData)) {
            context = this.b.c;
            UtilHelper.a(context, (int) R.string.neterror);
            return;
        }
        FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
        if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
            this.a.packUrl = facePackageDownloadData.packUrl;
            com.baidu.tieba.c.d.a().a(String.valueOf(this.a.pid), this.a.pname, this.a.packUrl);
        } else if (facePackageDownloadData.usermsg != null) {
            context3 = this.b.c;
            UtilHelper.b(context3, facePackageDownloadData.usermsg);
        } else {
            context2 = this.b.c;
            UtilHelper.a(context2, (int) R.string.neterror);
        }
    }
}
