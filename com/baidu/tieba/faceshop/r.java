package com.baidu.tieba.faceshop;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class r extends com.baidu.tieba.i {
    final /* synthetic */ FacePackageDetailActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FacePackageDetailActivity facePackageDetailActivity, com.baidu.tieba.f fVar) {
        super(fVar);
        this.b = facePackageDetailActivity;
    }

    @Override // com.baidu.tieba.i
    public final void a(Object... objArr) {
        x xVar;
        x xVar2;
        v vVar;
        this.b.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            xVar = this.b.b;
            if (xVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    xVar2 = this.b.b;
                    vVar = this.b.a;
                    if (vVar != null) {
                        xVar2.a(vVar);
                    }
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
