package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbImageView tbImageView) {
        this.aAQ = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.aAQ.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.aAQ.aAD;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aAQ.aAO = aVar.getWidth();
                this.aAQ.aAP = aVar.getHeight();
            }
            aVar3 = this.aAQ.aAD;
            aVar3.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Gn != null) {
                this.aAQ.aAM.Gp = aVar.Gn.Gp;
                this.aAQ.aAM.isSuccess = aVar.Gn.Gr;
                this.aAQ.aAM.Gq = aVar.Gn.Gq;
            }
        } else {
            this.aAQ.aAM.Gp = "net";
            this.aAQ.aAM.isSuccess = false;
            s sVar = this.aAQ.aAM;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aAQ.aAN;
            sVar.Gq = currentTimeMillis - j;
        }
        this.aAQ.vu();
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
        this.aAQ.stopLoading();
        aVar = this.aAQ.aAD;
        if (aVar != null) {
            aVar2 = this.aAQ.aAD;
            aVar2.onCancel();
        }
    }
}
