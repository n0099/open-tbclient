package com.baidu.tieba.faceshop;

import com.baidu.tbadk.download.DownloadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.h {
    final /* synthetic */ FacePackageDetailActivity att;
    private final /* synthetic */ DownloadData atu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FacePackageDetailActivity facePackageDetailActivity, DownloadData downloadData) {
        this.att = facePackageDetailActivity;
        this.atu = downloadData;
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
                akVar = this.att.atj;
                akVar.eQ(str);
                akVar2 = this.att.atj;
                if (akVar2.Da() != null) {
                    akVar3 = this.att.atj;
                    if (akVar3.Da().faces_list != null) {
                        FacePackageDetailActivity facePackageDetailActivity = this.att;
                        akVar4 = this.att.atj;
                        String pid = akVar4.getPid();
                        akVar5 = this.att.atj;
                        facePackageDetailActivity.m(pid, akVar5.Da().faces_list.pname, str);
                        return;
                    }
                    return;
                }
                return;
            } else if (facePackageDownloadData.usermsg != null) {
                this.att.showToast(facePackageDownloadData.usermsg);
                return;
            } else {
                g.CJ().a(this.atu);
                return;
            }
        }
        g.CJ().a(this.atu);
    }
}
