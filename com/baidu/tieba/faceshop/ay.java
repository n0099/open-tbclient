package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.a.g {
    final /* synthetic */ aw a;
    private final /* synthetic */ FacePackageData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, FacePackageData facePackageData) {
        this.a = awVar;
        this.b = facePackageData;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        if (obj == null || !(obj instanceof FacePackageDownloadData)) {
            context = this.a.c;
            UtilHelper.a(context, (int) R.string.neterror);
            return;
        }
        FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
        if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
            this.b.packUrl = facePackageDownloadData.packUrl;
            com.baidu.tieba.d.d.a().a(String.valueOf(this.b.pid), this.b.pname, this.b.packUrl);
        } else if (facePackageDownloadData.usermsg != null) {
            context3 = this.a.c;
            UtilHelper.b(context3, facePackageDownloadData.usermsg);
        } else {
            context2 = this.a.c;
            UtilHelper.a(context2, (int) R.string.neterror);
        }
    }
}
