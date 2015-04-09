package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView asd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbImageView tbImageView) {
        this.asd = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        n nVar;
        long j;
        n nVar2;
        this.asd.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        nVar = this.asd.arP;
        if (nVar != null) {
            if (aVar != null) {
                this.asd.asa = aVar.getWidth();
                this.asd.asb = aVar.getHeight();
            }
            nVar2 = this.asd.arP;
            nVar2.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Gw != null) {
                this.asd.arY.Gy = aVar.Gw.Gy;
                this.asd.arY.isSuccess = aVar.Gw.GA;
                this.asd.arY.Gz = aVar.Gw.Gz;
            }
        } else {
            this.asd.arY.Gy = "net";
            this.asd.arY.isSuccess = false;
            z zVar = this.asd.arY;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.asd.arZ;
            zVar.Gz = currentTimeMillis - j;
        }
        this.asd.tK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        n nVar;
        n nVar2;
        super.onCancelled(str);
        this.asd.stopLoading();
        nVar = this.asd.arP;
        if (nVar != null) {
            nVar2 = this.asd.arP;
            nVar2.onCancel();
        }
    }
}
