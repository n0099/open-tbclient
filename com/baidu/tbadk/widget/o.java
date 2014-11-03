package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView abk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbImageView tbImageView) {
        this.abk = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        p pVar;
        long j;
        p pVar2;
        this.abk.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        pVar = this.abk.aaW;
        if (pVar != null) {
            if (aVar != null) {
                this.abk.abh = aVar.getWidth();
                this.abk.abi = aVar.getHeight();
            }
            pVar2 = this.abk.aaW;
            pVar2.q(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.tj != null) {
                this.abk.abf.tl = aVar.tj.tl;
                this.abk.abf.isSuccess = aVar.tj.tn;
                this.abk.abf.tm = aVar.tj.tm;
            }
        } else {
            this.abk.abf.tl = "net";
            this.abk.abf.isSuccess = false;
            com.baidu.tbadk.performanceLog.o oVar = this.abk.abf;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.abk.abg;
            oVar.tm = currentTimeMillis - j;
        }
        this.abk.nt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void aa(String str) {
        p pVar;
        p pVar2;
        super.aa(str);
        this.abk.stopLoading();
        pVar = this.abk.aaW;
        if (pVar != null) {
            pVar2 = this.abk.aaW;
            pVar2.onCancel();
        }
    }
}
