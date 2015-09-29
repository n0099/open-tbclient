package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbImageView tbImageView) {
        this.aAR = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.aAR.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.aAR.aAE;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aAR.aAP = aVar.getWidth();
                this.aAR.aAQ = aVar.getHeight();
            }
            aVar3 = this.aAR.aAE;
            aVar3.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Gn != null) {
                this.aAR.aAN.Gp = aVar.Gn.Gp;
                this.aAR.aAN.isSuccess = aVar.Gn.Gr;
                this.aAR.aAN.Gq = aVar.Gn.Gq;
            }
        } else {
            this.aAR.aAN.Gp = "net";
            this.aAR.aAN.isSuccess = false;
            s sVar = this.aAR.aAN;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aAR.aAO;
            sVar.Gq = currentTimeMillis - j;
        }
        this.aAR.vr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void al(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.al(str);
        this.aAR.stopLoading();
        aVar = this.aAR.aAE;
        if (aVar != null) {
            aVar2 = this.aAR.aAE;
            aVar2.onCancel();
        }
    }
}
