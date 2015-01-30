package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView ajz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbImageView tbImageView) {
        this.ajz = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        p pVar;
        long j;
        p pVar2;
        this.ajz.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        pVar = this.ajz.ajl;
        if (pVar != null) {
            if (aVar != null) {
                this.ajz.ajw = aVar.getWidth();
                this.ajz.ajx = aVar.getHeight();
            }
            pVar2 = this.ajz.ajl;
            pVar2.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.vA != null) {
                this.ajz.aju.vC = aVar.vA.vC;
                this.ajz.aju.isSuccess = aVar.vA.vE;
                this.ajz.aju.vD = aVar.vA.vD;
            }
        } else {
            this.ajz.aju.vC = "net";
            this.ajz.aju.isSuccess = false;
            v vVar = this.ajz.aju;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.ajz.ajv;
            vVar.vD = currentTimeMillis - j;
        }
        this.ajz.qF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        p pVar;
        p pVar2;
        super.onCancelled(str);
        this.ajz.stopLoading();
        pVar = this.ajz.ajl;
        if (pVar != null) {
            pVar2 = this.ajz.ajl;
            pVar2.onCancel();
        }
    }
}
