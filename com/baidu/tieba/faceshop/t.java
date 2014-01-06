package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.a.g {
    final /* synthetic */ com.baidu.tieba.c.a a;
    final /* synthetic */ FacePackageDetailActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FacePackageDetailActivity facePackageDetailActivity, com.baidu.tieba.c.a aVar) {
        this.b = facePackageDetailActivity;
        this.a = aVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        if (obj != null && (obj instanceof FacePackageDownloadData)) {
            FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
            if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                String str = facePackageDownloadData.packUrl;
                wVar = this.b.a;
                wVar.a(str);
                wVar2 = this.b.a;
                if (wVar2.a() != null) {
                    wVar3 = this.b.a;
                    if (wVar3.a().facePackage != null) {
                        FacePackageDetailActivity facePackageDetailActivity = this.b;
                        wVar4 = this.b.a;
                        String e = wVar4.e();
                        wVar5 = this.b.a;
                        facePackageDetailActivity.a(e, wVar5.a().facePackage.pname, str);
                        return;
                    }
                    return;
                }
                return;
            } else if (facePackageDownloadData.usermsg != null) {
                this.b.showToast(facePackageDownloadData.usermsg);
                return;
            } else {
                com.baidu.tieba.c.d.a().a(this.a);
                return;
            }
        }
        com.baidu.tieba.c.d.a().a(this.a);
    }
}
