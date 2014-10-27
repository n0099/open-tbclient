package com.baidu.tieba.faceshop;

import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class af extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ FacePackageDetailActivity atk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(FacePackageDetailActivity facePackageDetailActivity, BaseActivity baseActivity) {
        super();
        this.atk = facePackageDetailActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        am amVar;
        am amVar2;
        ak akVar;
        this.atk.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            amVar = this.atk.atb;
            if (amVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    amVar2 = this.atk.atb;
                    akVar = this.atk.ata;
                    amVar2.g(akVar);
                    if (!bool.booleanValue()) {
                        this.atk.atg = true;
                        return;
                    } else {
                        this.atk.showProgressBar();
                        return;
                    }
                } else if (facePackageDetailData.usermsg != null) {
                    this.atk.showToast(facePackageDetailData.usermsg);
                    return;
                } else {
                    this.atk.showToast(cb.neterror);
                    return;
                }
            }
            return;
        }
        this.atk.showToast(cb.neterror);
    }
}
