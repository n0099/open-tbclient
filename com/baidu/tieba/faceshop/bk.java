package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.base.h {
    final /* synthetic */ bi auv;
    private final /* synthetic */ FacePackageData auw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar, FacePackageData facePackageData) {
        this.auv = biVar;
        this.auw = facePackageData;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        if (obj == null || !(obj instanceof FacePackageDownloadData)) {
            context = this.auv.mContext;
            UtilHelper.showToast(context, cb.neterror);
            return;
        }
        FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
        if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
            this.auw.pack_url = facePackageDownloadData.pack_url;
            g.CH().l(String.valueOf(this.auw.pid), this.auw.pname, this.auw.pack_url);
        } else if (facePackageDownloadData.usermsg != null) {
            context3 = this.auv.mContext;
            UtilHelper.showToast(context3, facePackageDownloadData.usermsg);
        } else {
            context2 = this.auv.mContext;
            UtilHelper.showToast(context2, cb.neterror);
        }
    }
}
