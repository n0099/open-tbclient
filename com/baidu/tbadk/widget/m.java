package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView atG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbImageView tbImageView) {
        this.atG = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        n nVar;
        long j;
        n nVar2;
        this.atG.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        nVar = this.atG.att;
        if (nVar != null) {
            if (aVar != null) {
                this.atG.atE = aVar.getWidth();
                this.atG.atF = aVar.getHeight();
            }
            nVar2 = this.atG.att;
            nVar2.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Gm != null) {
                this.atG.atC.Go = aVar.Gm.Go;
                this.atG.atC.isSuccess = aVar.Gm.Gq;
                this.atG.atC.Gp = aVar.Gm.Gp;
            }
        } else {
            this.atG.atC.Go = "net";
            this.atG.atC.isSuccess = false;
            z zVar = this.atG.atC;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.atG.atD;
            zVar.Gp = currentTimeMillis - j;
        }
        this.atG.uq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void am(String str) {
        n nVar;
        n nVar2;
        super.am(str);
        this.atG.stopLoading();
        nVar = this.atG.att;
        if (nVar != null) {
            nVar2 = this.atG.att;
            nVar2.onCancel();
        }
    }
}
