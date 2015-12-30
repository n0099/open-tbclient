package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aDI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aDI = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.aDI.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.aDI.aDu;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aDI.aDG = aVar.getWidth();
                this.aDI.aDH = aVar.getHeight();
            }
            aVar3 = this.aDI.aDu;
            aVar3.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.GX != null) {
                this.aDI.aDD.GZ = aVar.GX.GZ;
                this.aDI.aDD.isSuccess = aVar.GX.Hb;
                this.aDI.aDD.Ha = aVar.GX.Ha;
            }
        } else {
            this.aDI.aDD.GZ = "net";
            this.aDI.aDD.isSuccess = false;
            s sVar = this.aDI.aDD;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aDI.aDF;
            sVar.Ha = currentTimeMillis - j;
        }
        this.aDI.vI();
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
        this.aDI.stopLoading();
        aVar = this.aDI.aDu;
        if (aVar != null) {
            aVar2 = this.aDI.aDu;
            aVar2.onCancel();
        }
    }
}
