package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aCi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aCi = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aCi.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aCi;
            i2 = this.aCi.aBP;
            tbImageView.aBQ = i2;
        }
        aVar2 = this.aCi.aBO;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aCi.aCc = aVar.getWidth();
                this.aCi.aCd = aVar.getHeight();
            }
            aVar3 = this.aCi.aBO;
            aVar3.t(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.xH != null) {
                this.aCi.aBZ.xJ = aVar.xH.xJ;
                this.aCi.aBZ.isSuccess = aVar.xH.xL;
                this.aCi.aBZ.xK = aVar.xH.xK;
            }
        } else {
            this.aCi.aBZ.xJ = "net";
            this.aCi.aBZ.isSuccess = false;
            u uVar = this.aCi.aBZ;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aCi.aCb;
            uVar.xK = currentTimeMillis - j;
        }
        this.aCi.uS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void af(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.af(str);
        this.aCi.stopLoading();
        aVar = this.aCi.aBO;
        if (aVar != null) {
            aVar2 = this.aCi.aBO;
            aVar2.onCancel();
        }
    }
}
