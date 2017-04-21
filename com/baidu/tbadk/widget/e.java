package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TbImageView tbImageView) {
        this.aKS = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aKS.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            this.aKS.aKA = this.aKS.aKz;
        }
        if (this.aKS.aKy != null) {
            if (aVar != null) {
                this.aKS.aKM = aVar.getWidth();
                this.aKS.aKN = aVar.getHeight();
            }
            this.aKS.aKy.v(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Hd != null) {
                this.aKS.aKJ.Hf = aVar.Hd.Hf;
                this.aKS.aKJ.isSuccess = aVar.Hd.Hh;
                this.aKS.aKJ.Hg = aVar.Hd.Hg;
            }
        } else {
            this.aKS.aKJ.Hf = "net";
            this.aKS.aKJ.isSuccess = false;
            this.aKS.aKJ.Hg = System.currentTimeMillis() - this.aKS.aKL;
        }
        this.aKS.wJ();
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
        this.aKS.stopLoading();
        if (this.aKS.aKy != null) {
            this.aKS.aKy.onCancel();
        }
    }
}
