package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aGe = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aGe.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aGe;
            i2 = this.aGe.aFL;
            tbImageView.aFM = i2;
        }
        aVar2 = this.aGe.aFK;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aGe.aFY = aVar.getWidth();
                this.aGe.aFZ = aVar.getHeight();
            }
            aVar3 = this.aGe.aFK;
            aVar3.v(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Ax != null) {
                this.aGe.aFV.Az = aVar.Ax.Az;
                this.aGe.aFV.isSuccess = aVar.Ax.AB;
                this.aGe.aFV.AA = aVar.Ax.AA;
            }
        } else {
            this.aGe.aFV.Az = "net";
            this.aGe.aFV.isSuccess = false;
            u uVar = this.aGe.aFV;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aGe.aFX;
            uVar.AA = currentTimeMillis - j;
        }
        this.aGe.wi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ai(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.ai(str);
        this.aGe.stopLoading();
        aVar = this.aGe.aFK;
        if (aVar != null) {
            aVar2 = this.aGe.aFK;
            aVar2.onCancel();
        }
    }
}
