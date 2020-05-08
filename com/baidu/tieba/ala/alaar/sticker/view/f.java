package com.baidu.tieba.ala.alaar.sticker.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
/* loaded from: classes3.dex */
public class f extends i {
    public ImageView eMA;
    private ObjectAnimator eMB;
    public ImageView eMC;
    private TbImageView eMz;

    public f(View view) {
        this.mRootView = view;
        this.eMz = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.eMz.setDefaultBgResource(a.f.icon_live_gift_default);
        this.eMz.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.eMz.setAutoChangeStyle(false);
        this.eMA = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.eMF = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.eMC = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void c(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.eMC.setVisibility(0);
            this.eMz.setVisibility(8);
            this.eMA.setVisibility(8);
            this.eMF.setVisibility(8);
            return;
        }
        this.eMC.setVisibility(8);
        this.eMz.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.eMA.setVisibility(4);
            bkG();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bki().isRunning(fuFaceItem.file)) {
            this.eMA.setVisibility(0);
            startLoadingAnim();
        } else {
            this.eMA.setVisibility(0);
            this.eMA.setRotation(0.0f);
            this.eMA.setImageResource(a.f.sticker_unload);
            bkG();
        }
        d(fuFaceItem);
    }

    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.eMz.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void startLoadingAnim() {
        if (this.eMB == null) {
            this.eMB = ObjectAnimator.ofFloat(this.eMA, "rotation", 0.0f, 359.0f);
            this.eMB.setRepeatCount(-1);
            this.eMB.setDuration(1000L);
        }
        if (!this.eMB.isRunning()) {
            this.eMA.setImageResource(a.f.sticker_loading);
            this.eMB.start();
        }
    }

    public void bkG() {
        if (this.eMB != null && this.eMB.isRunning()) {
            this.eMB.cancel();
        }
    }
}
