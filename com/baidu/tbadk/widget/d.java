package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aGU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aGU = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aGU.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aGU;
            i2 = this.aGU.aGB;
            tbImageView.aGC = i2;
        }
        aVar2 = this.aGU.aGA;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aGU.aGO = aVar.getWidth();
                this.aGU.aGP = aVar.getHeight();
            }
            aVar3 = this.aGU.aGA;
            aVar3.v(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Ax != null) {
                this.aGU.aGL.Az = aVar.Ax.Az;
                this.aGU.aGL.isSuccess = aVar.Ax.AB;
                this.aGU.aGL.AA = aVar.Ax.AA;
            }
        } else {
            this.aGU.aGL.Az = "net";
            this.aGU.aGL.isSuccess = false;
            u uVar = this.aGU.aGL;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aGU.aGN;
            uVar.AA = currentTimeMillis - j;
        }
        this.aGU.wm();
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
        this.aGU.stopLoading();
        aVar = this.aGU.aGA;
        if (aVar != null) {
            aVar2 = this.aGU.aGA;
            aVar2.onCancel();
        }
    }
}
