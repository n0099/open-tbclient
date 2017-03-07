package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aKA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbImageView tbImageView) {
        this.aKA = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        int i2;
        this.aKA.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            TbImageView tbImageView = this.aKA;
            i2 = this.aKA.aKh;
            tbImageView.aKi = i2;
        }
        aVar2 = this.aKA.aKg;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aKA.aKu = aVar.getWidth();
                this.aKA.aKv = aVar.getHeight();
            }
            aVar3 = this.aKA.aKg;
            aVar3.v(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.HA != null) {
                this.aKA.aKr.HC = aVar.HA.HC;
                this.aKA.aKr.isSuccess = aVar.HA.HE;
                this.aKA.aKr.HD = aVar.HA.HD;
            }
        } else {
            this.aKA.aKr.HC = "net";
            this.aKA.aKr.isSuccess = false;
            u uVar = this.aKA.aKr;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aKA.aKt;
            uVar.HD = currentTimeMillis - j;
        }
        this.aKA.wn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onCancelled(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.onCancelled(str);
        this.aKA.stopLoading();
        aVar = this.aKA.aKg;
        if (aVar != null) {
            aVar2 = this.aKA.aKg;
            aVar2.onCancel();
        }
    }
}
