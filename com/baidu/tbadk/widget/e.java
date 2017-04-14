package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aKQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbImageView tbImageView) {
        this.aKQ = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aKQ.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            this.aKQ.aKy = this.aKQ.aKx;
        }
        if (this.aKQ.aKw != null) {
            if (aVar != null) {
                this.aKQ.aKK = aVar.getWidth();
                this.aKQ.aKL = aVar.getHeight();
            }
            this.aKQ.aKw.v(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Hb != null) {
                this.aKQ.aKH.Hd = aVar.Hb.Hd;
                this.aKQ.aKH.isSuccess = aVar.Hb.Hf;
                this.aKQ.aKH.He = aVar.Hb.He;
            }
        } else {
            this.aKQ.aKH.Hd = "net";
            this.aKQ.aKH.isSuccess = false;
            this.aKQ.aKH.He = System.currentTimeMillis() - this.aKQ.aKJ;
        }
        this.aKQ.wJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onCancelled(String str) {
        super.onCancelled(str);
        this.aKQ.stopLoading();
        if (this.aKQ.aKw != null) {
            this.aKQ.aKw.onCancel();
        }
    }
}
