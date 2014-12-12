package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aiW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbImageView tbImageView) {
        this.aiW = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        p pVar;
        long j;
        p pVar2;
        this.aiW.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        pVar = this.aiW.aiI;
        if (pVar != null) {
            if (aVar != null) {
                this.aiW.aiT = aVar.getWidth();
                this.aiW.aiU = aVar.getHeight();
            }
            pVar2 = this.aiW.aiI;
            pVar2.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.vu != null) {
                this.aiW.aiR.vw = aVar.vu.vw;
                this.aiW.aiR.isSuccess = aVar.vu.vy;
                this.aiW.aiR.vx = aVar.vu.vx;
            }
        } else {
            this.aiW.aiR.vw = "net";
            this.aiW.aiR.isSuccess = false;
            v vVar = this.aiW.aiR;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.aiW.aiS;
            vVar.vx = currentTimeMillis - j;
        }
        this.aiW.qu();
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
        this.aiW.stopLoading();
        pVar = this.aiW.aiI;
        if (pVar != null) {
            pVar2 = this.aiW.aiI;
            pVar2.onCancel();
        }
    }
}
