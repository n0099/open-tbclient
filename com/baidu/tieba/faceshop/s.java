package com.baidu.tieba.faceshop;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s extends com.baidu.tieba.m {
    final /* synthetic */ FacePackageDetailActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FacePackageDetailActivity facePackageDetailActivity) {
        super(facePackageDetailActivity);
        this.b = facePackageDetailActivity;
    }

    @Override // com.baidu.tieba.m
    public void a(Object... objArr) {
        z zVar;
        z zVar2;
        w wVar;
        this.b.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            zVar = this.b.b;
            if (zVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    zVar2 = this.b.b;
                    wVar = this.b.a;
                    zVar2.a(wVar);
                    if (!bool.booleanValue()) {
                        this.b.e = true;
                        return;
                    } else {
                        this.b.showProgressBar();
                        return;
                    }
                } else if (facePackageDetailData.usermsg != null) {
                    this.b.showToast(facePackageDetailData.usermsg);
                    return;
                } else {
                    this.b.showToast(R.string.neterror);
                    return;
                }
            }
            return;
        }
        this.b.showToast(R.string.neterror);
    }
}
