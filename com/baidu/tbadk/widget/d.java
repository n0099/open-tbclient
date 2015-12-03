package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aCa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aCa = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.aCa.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.aCa.aBM;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aCa.aBY = aVar.getWidth();
                this.aCa.aBZ = aVar.getHeight();
            }
            aVar3 = this.aCa.aBM;
            aVar3.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.GG != null) {
                this.aCa.aBV.GI = aVar.GG.GI;
                this.aCa.aBV.isSuccess = aVar.GG.GK;
                this.aCa.aBV.GJ = aVar.GG.GJ;
            }
        } else {
            this.aCa.aBV.GI = "net";
            this.aCa.aBV.isSuccess = false;
            s sVar = this.aCa.aBV;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aCa.aBX;
            sVar.GJ = currentTimeMillis - j;
        }
        this.aCa.vY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void an(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.an(str);
        this.aCa.stopLoading();
        aVar = this.aCa.aBM;
        if (aVar != null) {
            aVar2 = this.aCa.aBM;
            aVar2.onCancel();
        }
    }
}
