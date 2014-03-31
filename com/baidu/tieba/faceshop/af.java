package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
final class af extends com.baidu.tbadk.d {
    final /* synthetic */ FacePackageDetailActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(FacePackageDetailActivity facePackageDetailActivity, com.baidu.tbadk.a aVar) {
        super(aVar);
        this.b = facePackageDetailActivity;
    }

    @Override // com.baidu.tbadk.d
    public final void a(Object... objArr) {
        am amVar;
        am amVar2;
        ak akVar;
        this.b.hideProgressBar();
        Object obj = objArr[0];
        Boolean bool = (Boolean) objArr[1];
        if (obj != null && (obj instanceof FacePackageDetailData)) {
            amVar = this.b.b;
            if (amVar != null) {
                FacePackageDetailData facePackageDetailData = (FacePackageDetailData) obj;
                if (facePackageDetailData.errno == 0 && facePackageDetailData.usermsg != null) {
                    amVar2 = this.b.b;
                    akVar = this.b.a;
                    if (akVar != null) {
                        amVar2.a(akVar);
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
                    this.b.showToast(com.baidu.tieba.a.k.neterror);
                    return;
                }
            }
            return;
        }
        this.b.showToast(com.baidu.tieba.a.k.neterror);
    }
}
