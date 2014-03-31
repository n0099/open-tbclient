package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ah extends com.baidu.adp.a.h {
    final /* synthetic */ FacePackageDetailActivity a;
    private final /* synthetic */ com.baidu.tieba.download.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FacePackageDetailActivity facePackageDetailActivity, com.baidu.tieba.download.a aVar) {
        this.a = facePackageDetailActivity;
        this.b = aVar;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        if (obj != null && (obj instanceof FacePackageDownloadData)) {
            FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
            if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                String str = facePackageDownloadData.packUrl;
                akVar = this.a.a;
                akVar.a(str);
                akVar2 = this.a.a;
                if (akVar2.a() != null) {
                    akVar3 = this.a.a;
                    if (akVar3.a().facePackage != null) {
                        FacePackageDetailActivity facePackageDetailActivity = this.a;
                        akVar4 = this.a.a;
                        String e = akVar4.e();
                        akVar5 = this.a.a;
                        FacePackageDetailActivity.a(e, akVar5.a().facePackage.pname, str);
                        return;
                    }
                    return;
                }
                return;
            } else if (facePackageDownloadData.usermsg != null) {
                this.a.showToast(facePackageDownloadData.usermsg);
                return;
            } else {
                f.a();
                f.a(this.b);
                return;
            }
        }
        f.a();
        f.a(this.b);
    }
}
