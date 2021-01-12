package com.baidu.tieba.ala.alaar.sticker.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
/* loaded from: classes10.dex */
public class f extends i {
    private TbImageView gsZ;
    public ImageView gta;
    private ObjectAnimator gtb;
    public ImageView gtc;

    public f(View view) {
        this.mRootView = view;
        this.gsZ = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gsZ.setDefaultBgResource(a.e.icon_live_gift_default);
        this.gsZ.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.gsZ.setAutoChangeStyle(false);
        this.gta = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gtf = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gtc = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gtc.setVisibility(0);
            this.gsZ.setVisibility(8);
            this.gta.setVisibility(8);
            this.gtf.setVisibility(8);
            return;
        }
        this.gtc.setVisibility(8);
        this.gsZ.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gta.setVisibility(4);
            bPQ();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bPf().isRunning(fuFaceItem.file)) {
            this.gta.setVisibility(0);
            bPP();
        } else {
            this.gta.setVisibility(0);
            this.gta.setRotation(0.0f);
            this.gta.setImageResource(a.e.sticker_unload);
            bPQ();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.gsZ.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bPP() {
        if (this.gtb == null) {
            this.gtb = ObjectAnimator.ofFloat(this.gta, "rotation", 0.0f, 359.0f);
            this.gtb.setRepeatCount(-1);
            this.gtb.setDuration(1000L);
        }
        if (!this.gtb.isRunning()) {
            this.gta.setImageResource(a.e.sticker_loading);
            this.gtb.start();
        }
    }

    public void bPQ() {
        if (this.gtb != null && this.gtb.isRunning()) {
            this.gtb.cancel();
        }
    }
}
