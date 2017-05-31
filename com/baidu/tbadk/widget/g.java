package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aKR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbImageView tbImageView) {
        this.aKR = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aKR.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            this.aKR.aKw = this.aKR.aKv;
        } else {
            this.aKR.sb = aVar.ef();
        }
        if (this.aKR.aKu != null) {
            if (aVar != null) {
                this.aKR.aKJ = aVar.getWidth();
                this.aKR.aKK = aVar.getHeight();
            }
            this.aKR.aKu.s(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Hd != null) {
                this.aKR.aKG.Hf = aVar.Hd.Hf;
                this.aKR.aKG.isSuccess = aVar.Hd.Hh;
                this.aKR.aKG.Hg = aVar.Hd.Hg;
            }
        } else {
            this.aKR.aKG.Hf = "net";
            this.aKR.aKG.isSuccess = false;
            this.aKR.aKG.Hg = System.currentTimeMillis() - this.aKR.aKI;
        }
        this.aKR.vT();
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
        this.aKR.stopLoading();
        if (this.aKR.aKu != null) {
            this.aKR.aKu.onCancel();
        }
    }
}
