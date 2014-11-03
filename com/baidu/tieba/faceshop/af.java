package com.baidu.tieba.faceshop;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class af extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ FacePackageDetailActivity att;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(FacePackageDetailActivity facePackageDetailActivity, BaseActivity baseActivity) {
        super();
        this.att = facePackageDetailActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        am amVar;
        am amVar2;
        ak akVar;
        this.att.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            amVar = this.att.atk;
            if (amVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    amVar2 = this.att.atk;
                    akVar = this.att.atj;
                    amVar2.g(akVar);
                    if (!bool.booleanValue()) {
                        this.att.atp = true;
                        return;
                    } else {
                        this.att.showProgressBar();
                        return;
                    }
                } else if (facePackageDetailData.usermsg != null) {
                    this.att.showToast(facePackageDetailData.usermsg);
                    return;
                } else {
                    this.att.showToast(cb.neterror);
                    return;
                }
            }
            return;
        }
        this.att.showToast(cb.neterror);
    }
}
