package com.baidu.tieba.faceshop;

import com.baidu.tbadk.download.DownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.h {
    final /* synthetic */ FacePackageDetailActivity a;
    private final /* synthetic */ DownloadData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FacePackageDetailActivity facePackageDetailActivity, DownloadData downloadData) {
        this.a = facePackageDetailActivity;
        this.b = downloadData;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
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
                        facePackageDetailActivity.a(e, akVar5.a().facePackage.pname, str);
                        return;
                    }
                    return;
                }
                return;
            } else if (facePackageDownloadData.usermsg != null) {
                this.a.showToast(facePackageDownloadData.usermsg);
                return;
            } else {
                g.a().a(this.b);
                return;
            }
        }
        g.a().a(this.b);
    }
}
