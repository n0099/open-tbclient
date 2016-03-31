package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aFT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aFT = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aFT.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aFT;
            i2 = this.aFT.aFE;
            tbImageView.aFF = i2;
        }
        aVar2 = this.aFT.aFD;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aFT.aFR = aVar.getWidth();
                this.aFT.aFS = aVar.getHeight();
            }
            aVar3 = this.aFT.aFD;
            aVar3.s(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Hp != null) {
                this.aFT.aFO.Hr = aVar.Hp.Hr;
                this.aFT.aFO.isSuccess = aVar.Hp.Ht;
                this.aFT.aFO.Hs = aVar.Hp.Hs;
            }
        } else {
            this.aFT.aFO.Hr = "net";
            this.aFT.aFO.isSuccess = false;
            u uVar = this.aFT.aFO;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aFT.aFQ;
            uVar.Hs = currentTimeMillis - j;
        }
        this.aFT.xi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void ao(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.ao(str);
        this.aFT.stopLoading();
        aVar = this.aFT.aFD;
        if (aVar != null) {
            aVar2 = this.aFT.aFD;
            aVar2.onCancel();
        }
    }
}
