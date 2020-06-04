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
    private TbImageView eZh;
    public ImageView eZi;
    private ObjectAnimator eZj;
    public ImageView eZk;

    public f(View view) {
        this.mRootView = view;
        this.eZh = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.eZh.setDefaultBgResource(a.f.icon_live_gift_default);
        this.eZh.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.eZh.setAutoChangeStyle(false);
        this.eZi = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.eZn = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.eZk = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void c(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.eZk.setVisibility(0);
            this.eZh.setVisibility(8);
            this.eZi.setVisibility(8);
            this.eZn.setVisibility(8);
            return;
        }
        this.eZk.setVisibility(8);
        this.eZh.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.eZi.setVisibility(4);
            bqc();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bpE().isRunning(fuFaceItem.file)) {
            this.eZi.setVisibility(0);
            startLoadingAnim();
        } else {
            this.eZi.setVisibility(0);
            this.eZi.setRotation(0.0f);
            this.eZi.setImageResource(a.f.sticker_unload);
            bqc();
        }
        d(fuFaceItem);
    }

    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.eZh.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void startLoadingAnim() {
        if (this.eZj == null) {
            this.eZj = ObjectAnimator.ofFloat(this.eZi, "rotation", 0.0f, 359.0f);
            this.eZj.setRepeatCount(-1);
            this.eZj.setDuration(1000L);
        }
        if (!this.eZj.isRunning()) {
            this.eZi.setImageResource(a.f.sticker_loading);
            this.eZj.start();
        }
    }

    public void bqc() {
        if (this.eZj != null && this.eZj.isRunning()) {
            this.eZj.cancel();
        }
    }
}
