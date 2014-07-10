package com.baidu.tieba.faceshop;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class ah extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(FacePackageDetailActivity facePackageDetailActivity, BaseActivity baseActivity) {
        super();
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        ao aoVar;
        ao aoVar2;
        am amVar;
        this.a.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            aoVar = this.a.b;
            if (aoVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    aoVar2 = this.a.b;
                    amVar = this.a.a;
                    aoVar2.a(amVar);
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
