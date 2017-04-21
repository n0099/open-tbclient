package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.lib.util.BdLog;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements SubsamplingScaleImageView.OnImageEventListener {
    final /* synthetic */ u awe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.awe = uVar;
    }

    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
    public void onImageLoadError(Exception exc) {
    }

    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
    public void onImageLoaded() {
    }

    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
    public void onPreviewLoadError(Exception exc) {
    }

    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
    public void onReady() {
        this.awe.mProgressBar.setVisibility(8);
        this.awe.avN.HK();
        this.awe.avN.setVisibility(4);
    }

    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
    public void onTileLoadError(Exception exc) {
        BdLog.e(exc);
    }
}
