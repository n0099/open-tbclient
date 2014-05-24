package com.baidu.tieba.faceshop;

import com.baidu.tbadk.download.DownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.e {
    final /* synthetic */ FacePackageDetailActivity a;
    private final /* synthetic */ DownloadData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FacePackageDetailActivity facePackageDetailActivity, DownloadData downloadData) {
        this.a = facePackageDetailActivity;
        this.b = downloadData;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        an anVar5;
        if (obj != null && (obj instanceof FacePackageDownloadData)) {
            FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
            if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                String str = facePackageDownloadData.packUrl;
                anVar = this.a.a;
                anVar.a(str);
                anVar2 = this.a.a;
                if (anVar2.a() != null) {
                    anVar3 = this.a.a;
                    if (anVar3.a().facePackage != null) {
                        FacePackageDetailActivity facePackageDetailActivity = this.a;
                        anVar4 = this.a.a;
                        String e = anVar4.e();
                        anVar5 = this.a.a;
                        facePackageDetailActivity.a(e, anVar5.a().facePackage.pname, str);
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
