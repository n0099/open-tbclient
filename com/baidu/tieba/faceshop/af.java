package com.baidu.tieba.faceshop;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class af extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(FacePackageDetailActivity facePackageDetailActivity, BaseActivity baseActivity) {
        super();
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        am amVar;
        am amVar2;
        ak akVar;
        this.a.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            amVar = this.a.b;
            if (amVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    amVar2 = this.a.b;
                    akVar = this.a.a;
                    amVar2.a(akVar);
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
                    this.a.showToast(com.baidu.tieba.x.neterror);
                    return;
                }
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.x.neterror);
    }
}
