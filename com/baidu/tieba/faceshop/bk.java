package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.base.h {
    final /* synthetic */ bi auE;
    private final /* synthetic */ FacePackageData auF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar, FacePackageData facePackageData) {
        this.auE = biVar;
        this.auF = facePackageData;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        if (obj == null || !(obj instanceof FacePackageDownloadData)) {
            context = this.auE.mContext;
            UtilHelper.showToast(context, cb.neterror);
            return;
        }
        FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
        if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
            this.auF.pack_url = facePackageDownloadData.pack_url;
            g.CJ().l(String.valueOf(this.auF.pid), this.auF.pname, this.auF.pack_url);
        } else if (facePackageDownloadData.usermsg != null) {
            context3 = this.auE.mContext;
            UtilHelper.showToast(context3, facePackageDownloadData.usermsg);
        } else {
            context2 = this.auE.mContext;
            UtilHelper.showToast(context2, cb.neterror);
        }
    }
}
