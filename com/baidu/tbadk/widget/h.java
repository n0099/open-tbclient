package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.s;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aCy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TbImageView tbImageView) {
        this.aCy = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.aCy.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.aCy.aCl;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aCy.aCw = aVar.getWidth();
                this.aCy.aCx = aVar.getHeight();
            }
            aVar3 = this.aCy.aCl;
            aVar3.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Gn != null) {
                this.aCy.aCu.Gp = aVar.Gn.Gp;
                this.aCy.aCu.isSuccess = aVar.Gn.Gr;
                this.aCy.aCu.Gq = aVar.Gn.Gq;
            }
        } else {
            this.aCy.aCu.Gp = "net";
            this.aCy.aCu.isSuccess = false;
            s sVar = this.aCy.aCu;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aCy.aCv;
            sVar.Gq = currentTimeMillis - j;
        }
        this.aCy.vz();
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
        this.aCy.stopLoading();
        aVar = this.aCy.aCl;
        if (aVar != null) {
            aVar2 = this.aCy.aCl;
            aVar2.onCancel();
        }
    }
}
