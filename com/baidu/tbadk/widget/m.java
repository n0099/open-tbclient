package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.performanceLog.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView arV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbImageView tbImageView) {
        this.arV = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        n nVar;
        long j;
        n nVar2;
        this.arV.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        nVar = this.arV.arH;
        if (nVar != null) {
            if (aVar != null) {
                this.arV.arS = aVar.getWidth();
                this.arV.arT = aVar.getHeight();
            }
            nVar2 = this.arV.arH;
            nVar2.onComplete(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Gu != null) {
                this.arV.arQ.Gw = aVar.Gu.Gw;
                this.arV.arQ.isSuccess = aVar.Gu.Gy;
                this.arV.arQ.Gx = aVar.Gu.Gx;
            }
        } else {
            this.arV.arQ.Gw = "net";
            this.arV.arQ.isSuccess = false;
            z zVar = this.arV.arQ;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.arV.arR;
            zVar.Gx = currentTimeMillis - j;
        }
        this.arV.tK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onCancelled(String str) {
        n nVar;
        n nVar2;
        super.onCancelled(str);
        this.arV.stopLoading();
        nVar = this.arV.arH;
        if (nVar != null) {
            nVar2 = this.arV.arH;
            nVar2.onCancel();
        }
    }
}
