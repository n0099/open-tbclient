package com.baidu.tieba.faceshop;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class ai extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(FacePackageDetailActivity facePackageDetailActivity, BaseActivity baseActivity) {
        super();
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        ap apVar;
        ap apVar2;
        an anVar;
        this.a.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            apVar = this.a.b;
            if (apVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    apVar2 = this.a.b;
                    anVar = this.a.a;
                    apVar2.a(anVar);
                    if (!bool.booleanValue()) {
                        this.a.e = true;
                        return;
                    } else {
                        this.a.showProgressBar();
                        return;
                    }
                } else if (facePackageDetailData.usermsg != null) {
                    this.a.showToast(facePackageDetailData.usermsg);
                    return;
                } else {
                    this.a.showToast(com.baidu.tieba.y.neterror);
                    return;
                }
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.y.neterror);
    }
}
