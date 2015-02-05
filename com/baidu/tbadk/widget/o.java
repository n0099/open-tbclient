package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView ajw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbImageView tbImageView) {
        this.ajw = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        p pVar;
        long j;
        p pVar2;
        this.ajw.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        pVar = this.ajw.aji;
        if (pVar != null) {
            if (aVar != null) {
                this.ajw.ajt = aVar.getWidth();
                this.ajw.aju = aVar.getHeight();
            }
            pVar2 = this.ajw.aji;
            pVar2.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.vx != null) {
                this.ajw.ajr.vz = aVar.vx.vz;
                this.ajw.ajr.isSuccess = aVar.vx.vB;
                this.ajw.ajr.vA = aVar.vx.vA;
            }
        } else {
            this.ajw.ajr.vz = "net";
            this.ajw.ajr.isSuccess = false;
            v vVar = this.ajw.ajr;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.ajw.ajs;
            vVar.vA = currentTimeMillis - j;
        }
        this.ajw.qz();
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
        this.ajw.stopLoading();
        pVar = this.ajw.aji;
        if (pVar != null) {
            pVar2 = this.ajw.aji;
            pVar2.onCancel();
        }
    }
}
