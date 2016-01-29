package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.u;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbImageView tbImageView) {
        this.aEy = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        TbImageView.a aVar2;
        long j;
        TbImageView.a aVar3;
        this.aEy.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        aVar2 = this.aEy.aEk;
        if (aVar2 != null) {
            if (aVar != null) {
                this.aEy.aEw = aVar.getWidth();
                this.aEy.aEx = aVar.getHeight();
            }
            aVar3 = this.aEy.aEk;
            aVar3.t(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Hj != null) {
                this.aEy.aEt.Hl = aVar.Hj.Hl;
                this.aEy.aEt.isSuccess = aVar.Hj.Hn;
                this.aEy.aEt.Hm = aVar.Hj.Hm;
            }
        } else {
            this.aEy.aEt.Hl = "net";
            this.aEy.aEt.isSuccess = false;
            u uVar = this.aEy.aEt;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aEy.aEv;
            uVar.Hm = currentTimeMillis - j;
        }
        this.aEy.wQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void am(String str) {
        TbImageView.a aVar;
        TbImageView.a aVar2;
        super.am(str);
        this.aEy.stopLoading();
        aVar = this.aEy.aEk;
        if (aVar != null) {
            aVar2 = this.aEy.aEk;
            aVar2.onCancel();
        }
    }
}
