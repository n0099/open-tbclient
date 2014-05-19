package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends com.baidu.adp.base.g {
    final /* synthetic */ bp a;
    private final /* synthetic */ FacePackageData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar, FacePackageData facePackageData) {
        this.a = bpVar;
        this.b = facePackageData;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        if (obj == null || !(obj instanceof FacePackageDownloadData)) {
            context = this.a.c;
            UtilHelper.showToast(context, com.baidu.tieba.u.neterror);
            return;
        }
        FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
        if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
            this.b.packUrl = facePackageDownloadData.packUrl;
            g.a().a(String.valueOf(this.b.pid), this.b.pname, this.b.packUrl);
        } else if (facePackageDownloadData.usermsg != null) {
            context3 = this.a.c;
            UtilHelper.showToast(context3, facePackageDownloadData.usermsg);
        } else {
            context2 = this.a.c;
            UtilHelper.showToast(context2, com.baidu.tieba.u.neterror);
        }
    }
}
