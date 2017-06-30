package com.baidu.tbadk.widget;

import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ TbImageView aMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TbImageView tbImageView) {
        this.aMh = tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        this.aMh.stopLoading();
        BdLog.i("imagecallback. resourceFrom-" + i);
        if (aVar == null) {
            this.aMh.aLL = this.aMh.aLK;
        } else {
            this.aMh.sa = aVar.isGif();
        }
        if (this.aMh.aLJ != null) {
            if (aVar != null) {
                this.aMh.aLZ = aVar.getWidth();
                this.aMh.aMa = aVar.getHeight();
            }
            this.aMh.aLJ.t(str, aVar != null);
        }
        if (aVar != null) {
            if (aVar.Hc != null) {
                this.aMh.aLW.He = aVar.Hc.He;
                this.aMh.aLW.isSuccess = aVar.Hc.Hg;
                this.aMh.aLW.Hf = aVar.Hc.Hf;
            }
        } else {
            this.aMh.aLW.He = "net";
            this.aMh.aLW.isSuccess = false;
            this.aMh.aLW.Hf = System.currentTimeMillis() - this.aMh.aLY;
        }
        this.aMh.wk();
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
        this.aMh.stopLoading();
        if (this.aMh.aLJ != null) {
            this.aMh.aLJ.onCancel();
        }
    }
}
