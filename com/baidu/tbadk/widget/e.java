package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aBc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbImageView tbImageView) {
        this.aBc = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.aBc.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.aBc.aAP;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aBc.aBa = aVar.getWidth();
                this.aBc.aBb = aVar.getHeight();
            }
            aVar3 = this.aBc.aAP;
            aVar3.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Go != null) {
                this.aBc.aAY.Gq = aVar.Go.Gq;
                this.aBc.aAY.isSuccess = aVar.Go.Gs;
                this.aBc.aAY.Gr = aVar.Go.Gr;
            }
        } else {
            this.aBc.aAY.Gq = "net";
            this.aBc.aAY.isSuccess = false;
            s sVar = this.aBc.aAY;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aBc.aAZ;
            sVar.Gr = currentTimeMillis - j;
        }
        this.aBc.vo();
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
        this.aBc.stopLoading();
        aVar = this.aBc.aAP;
        if (aVar != null) {
            aVar2 = this.aBc.aAP;
            aVar2.onCancel();
        }
    }
}
