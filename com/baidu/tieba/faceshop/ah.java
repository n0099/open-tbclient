package com.baidu.tieba.faceshop;

import com.baidu.tbadk.download.DownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.h {
    final /* synthetic */ FacePackageDetailActivity atk;
    private final /* synthetic */ DownloadData atl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FacePackageDetailActivity facePackageDetailActivity, DownloadData downloadData) {
        this.atk = facePackageDetailActivity;
        this.atl = downloadData;
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
                String str = facePackageDownloadData.pack_url;
                akVar = this.atk.ata;
                akVar.eQ(str);
                akVar2 = this.atk.ata;
                if (akVar2.CY() != null) {
                    akVar3 = this.atk.ata;
                    if (akVar3.CY().faces_list != null) {
                        FacePackageDetailActivity facePackageDetailActivity = this.atk;
                        akVar4 = this.atk.ata;
                        String pid = akVar4.getPid();
                        akVar5 = this.atk.ata;
                        facePackageDetailActivity.m(pid, akVar5.CY().faces_list.pname, str);
                        return;
                    }
                    return;
                }
                return;
            } else if (facePackageDownloadData.usermsg != null) {
                this.atk.showToast(facePackageDownloadData.usermsg);
                return;
            } else {
                g.CH().a(this.atl);
                return;
            }
        }
        g.CH().a(this.atl);
    }
}
