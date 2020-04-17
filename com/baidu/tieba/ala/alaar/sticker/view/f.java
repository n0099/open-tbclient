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
    private TbImageView eMu;
    public ImageView eMv;
    private ObjectAnimator eMw;
    public ImageView eMx;

    public f(View view) {
        this.mRootView = view;
        this.eMu = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.eMu.setDefaultBgResource(a.f.icon_live_gift_default);
        this.eMu.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.eMu.setAutoChangeStyle(false);
        this.eMv = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.eMA = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.eMx = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void c(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.eMx.setVisibility(0);
            this.eMu.setVisibility(8);
            this.eMv.setVisibility(8);
            this.eMA.setVisibility(8);
            return;
        }
        this.eMx.setVisibility(8);
        this.eMu.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.eMv.setVisibility(4);
            bkI();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bkk().isRunning(fuFaceItem.file)) {
            this.eMv.setVisibility(0);
            startLoadingAnim();
        } else {
            this.eMv.setVisibility(0);
            this.eMv.setRotation(0.0f);
            this.eMv.setImageResource(a.f.sticker_unload);
            bkI();
        }
        d(fuFaceItem);
    }

    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.eMu.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void startLoadingAnim() {
        if (this.eMw == null) {
            this.eMw = ObjectAnimator.ofFloat(this.eMv, "rotation", 0.0f, 359.0f);
            this.eMw.setRepeatCount(-1);
            this.eMw.setDuration(1000L);
        }
        if (!this.eMw.isRunning()) {
            this.eMv.setImageResource(a.f.sticker_loading);
            this.eMw.start();
        }
    }

    public void bkI() {
        if (this.eMw != null && this.eMw.isRunning()) {
            this.eMw.cancel();
        }
    }
}
