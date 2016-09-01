package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aGF = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aGF.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aGF;
            i2 = this.aGF.aGm;
            tbImageView.aGn = i2;
        }
        aVar2 = this.aGF.aGl;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aGF.aGz = aVar.getWidth();
                this.aGF.aGA = aVar.getHeight();
            }
            aVar3 = this.aGF.aGl;
            aVar3.u(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Ax != null) {
                this.aGF.aGw.Az = aVar.Ax.Az;
                this.aGF.aGw.isSuccess = aVar.Ax.AB;
                this.aGF.aGw.AA = aVar.Ax.AA;
            }
        } else {
            this.aGF.aGw.Az = "net";
            this.aGF.aGw.isSuccess = false;
            u uVar = this.aGF.aGw;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aGF.aGy;
            uVar.AA = currentTimeMillis - j;
        }
        this.aGF.vU();
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
        this.aGF.stopLoading();
        aVar = this.aGF.aGl;
        if (aVar != null) {
            aVar2 = this.aGF.aGl;
            aVar2.onCancel();
        }
    }
}
