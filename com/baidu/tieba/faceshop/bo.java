package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bo extends com.baidu.adp.a.h {
    final /* synthetic */ bm a;
    private final /* synthetic */ FacePackageData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar, FacePackageData facePackageData) {
        this.a = bmVar;
        this.b = facePackageData;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        if (obj == null || !(obj instanceof FacePackageDownloadData)) {
            context = this.a.c;
            UtilHelper.a(context, com.baidu.tieba.a.k.neterror);
            return;
        }
        FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
        if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
            this.b.packUrl = facePackageDownloadData.packUrl;
            f.a().a(String.valueOf(this.b.pid), this.b.pname, this.b.packUrl);
        } else if (facePackageDownloadData.usermsg != null) {
            context3 = this.a.c;
            UtilHelper.a(context3, facePackageDownloadData.usermsg);
        } else {
            context2 = this.a.c;
            UtilHelper.a(context2, com.baidu.tieba.a.k.neterror);
        }
    }
}
