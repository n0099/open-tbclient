package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.g {
    final /* synthetic */ FacePackageDetailActivity a;
    private final /* synthetic */ com.baidu.tieba.d.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FacePackageDetailActivity facePackageDetailActivity, com.baidu.tieba.d.a aVar) {
        this.a = facePackageDetailActivity;
        this.b = aVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        if (obj != null && (obj instanceof FacePackageDownloadData)) {
            FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
            if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                String str = facePackageDownloadData.packUrl;
                vVar = this.a.a;
                vVar.a(str);
                vVar2 = this.a.a;
                if (vVar2.a() != null) {
                    vVar3 = this.a.a;
                    if (vVar3.a().facePackage != null) {
                        FacePackageDetailActivity facePackageDetailActivity = this.a;
                        vVar4 = this.a.a;
                        String e = vVar4.e();
                        vVar5 = this.a.a;
                        facePackageDetailActivity.a(e, vVar5.a().facePackage.pname, str);
                        return;
                    }
                    return;
                }
                return;
            } else if (facePackageDownloadData.usermsg != null) {
                this.a.showToast(facePackageDownloadData.usermsg);
                return;
            } else {
                com.baidu.tieba.d.d.a().a(this.b);
                return;
            }
        }
        com.baidu.tieba.d.d.a().a(this.b);
    }
}
