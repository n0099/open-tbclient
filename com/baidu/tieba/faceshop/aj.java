package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aj extends com.baidu.adp.a.h {
    final /* synthetic */ FacePackageDetailActivity a;
    private final /* synthetic */ com.baidu.tieba.download.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FacePackageDetailActivity facePackageDetailActivity, com.baidu.tieba.download.a aVar) {
        this.a = facePackageDetailActivity;
        this.b = aVar;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        if (obj != null && (obj instanceof FacePackageDownloadData)) {
            FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
            if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                String str = facePackageDownloadData.packUrl;
                amVar = this.a.a;
                amVar.a(str);
                amVar2 = this.a.a;
                if (amVar2.a() != null) {
                    amVar3 = this.a.a;
                    if (amVar3.a().facePackage != null) {
                        FacePackageDetailActivity facePackageDetailActivity = this.a;
                        amVar4 = this.a.a;
                        String e = amVar4.e();
                        amVar5 = this.a.a;
                        FacePackageDetailActivity.a(e, amVar5.a().facePackage.pname, str);
                        return;
                    }
                    return;
                }
                return;
            } else if (facePackageDownloadData.usermsg != null) {
                this.a.showToast(facePackageDownloadData.usermsg);
                return;
            } else {
                g.a();
                g.a(this.b);
                return;
            }
        }
        g.a();
        g.a(this.b);
    }
}
