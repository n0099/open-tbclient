package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(TbImageView tbImageView) {
        this.aLc = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aLc.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            this.aLc.aKJ = this.aLc.aKI;
        }
        if (this.aLc.aKH != null) {
            if (aVar != null) {
                this.aLc.aKV = aVar.getWidth();
                this.aLc.aKW = aVar.getHeight();
            }
            this.aLc.aKH.v(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Hd != null) {
                this.aLc.aKS.Hf = aVar.Hd.Hf;
                this.aLc.aKS.isSuccess = aVar.Hd.Hh;
                this.aLc.aKS.Hg = aVar.Hd.Hg;
            }
        } else {
            this.aLc.aKS.Hf = "net";
            this.aLc.aKS.isSuccess = false;
            this.aLc.aKS.Hg = System.currentTimeMillis() - this.aLc.aKU;
        }
        this.aLc.vW();
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
        this.aLc.stopLoading();
        if (this.aLc.aKH != null) {
            this.aLc.aKH.onCancel();
        }
    }
}
