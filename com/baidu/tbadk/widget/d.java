package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aGo = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aGo.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aGo;
            i2 = this.aGo.aFV;
            tbImageView.aFW = i2;
        }
        aVar2 = this.aGo.aFU;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aGo.aGi = aVar.getWidth();
                this.aGo.aGj = aVar.getHeight();
            }
            aVar3 = this.aGo.aFU;
            aVar3.v(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Ax != null) {
                this.aGo.aGf.Az = aVar.Ax.Az;
                this.aGo.aGf.isSuccess = aVar.Ax.AB;
                this.aGo.aGf.AA = aVar.Ax.AA;
            }
        } else {
            this.aGo.aGf.Az = "net";
            this.aGo.aGf.isSuccess = false;
            u uVar = this.aGo.aGf;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aGo.aGh;
            uVar.AA = currentTimeMillis - j;
        }
        this.aGo.vW();
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
        this.aGo.stopLoading();
        aVar = this.aGo.aFU;
        if (aVar != null) {
            aVar2 = this.aGo.aFU;
            aVar2.onCancel();
        }
    }
}
