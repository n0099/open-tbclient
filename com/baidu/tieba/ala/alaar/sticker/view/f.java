package com.baidu.tieba.ala.alaar.sticker.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
/* loaded from: classes4.dex */
public class f extends i {
    private TbImageView fpl;
    public ImageView fpm;
    private ObjectAnimator fpn;
    public ImageView fpo;

    public f(View view) {
        this.mRootView = view;
        this.fpl = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.fpl.setDefaultBgResource(a.f.icon_live_gift_default);
        this.fpl.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.fpl.setAutoChangeStyle(false);
        this.fpm = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.fpr = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.fpo = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.fpo.setVisibility(0);
            this.fpl.setVisibility(8);
            this.fpm.setVisibility(8);
            this.fpr.setVisibility(8);
            return;
        }
        this.fpo.setVisibility(8);
        this.fpl.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.fpm.setVisibility(4);
            bwd();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bvx().isRunning(fuFaceItem.file)) {
            this.fpm.setVisibility(0);
            startLoadingAnim();
        } else {
            this.fpm.setVisibility(0);
            this.fpm.setRotation(0.0f);
            this.fpm.setImageResource(a.f.sticker_unload);
            bwd();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.fpl.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void startLoadingAnim() {
        if (this.fpn == null) {
            this.fpn = ObjectAnimator.ofFloat(this.fpm, "rotation", 0.0f, 359.0f);
            this.fpn.setRepeatCount(-1);
            this.fpn.setDuration(1000L);
        }
        if (!this.fpn.isRunning()) {
            this.fpm.setImageResource(a.f.sticker_loading);
            this.fpn.start();
        }
    }

    public void bwd() {
        if (this.fpn != null && this.fpn.isRunning()) {
            this.fpn.cancel();
        }
    }
}
