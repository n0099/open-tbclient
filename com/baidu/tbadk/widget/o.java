package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView abf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbImageView tbImageView) {
        this.abf = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        p pVar;
        long j;
        p pVar2;
        this.abf.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        pVar = this.abf.aaS;
        if (pVar != null) {
            this.abf.abd = aVar;
            pVar2 = this.abf.aaS;
            pVar2.q(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.tj != null) {
                this.abf.abb.tl = aVar.tj.tl;
                this.abf.abb.isSuccess = aVar.tj.tn;
                this.abf.abb.tm = aVar.tj.tm;
            }
        } else {
            this.abf.abb.tl = "net";
            this.abf.abb.isSuccess = false;
            com.baidu.tbadk.performanceLog.o oVar = this.abf.abb;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.abf.abc;
            oVar.tm = currentTimeMillis - j;
        }
        this.abf.nt();
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
        this.abf.stopLoading();
        pVar = this.abf.aaS;
        if (pVar != null) {
            pVar2 = this.abf.aaS;
            pVar2.onCancel();
        }
    }
}
