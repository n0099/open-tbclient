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
    private TbImageView eYW;
    public ImageView eYX;
    private ObjectAnimator eYY;
    public ImageView eYZ;

    public f(View view) {
        this.mRootView = view;
        this.eYW = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.eYW.setDefaultBgResource(a.f.icon_live_gift_default);
        this.eYW.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.eYW.setAutoChangeStyle(false);
        this.eYX = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.eZc = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.eYZ = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void c(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.eYZ.setVisibility(0);
            this.eYW.setVisibility(8);
            this.eYX.setVisibility(8);
            this.eZc.setVisibility(8);
            return;
        }
        this.eYZ.setVisibility(8);
        this.eYW.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.eYX.setVisibility(4);
            bqa();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bpC().isRunning(fuFaceItem.file)) {
            this.eYX.setVisibility(0);
            startLoadingAnim();
        } else {
            this.eYX.setVisibility(0);
            this.eYX.setRotation(0.0f);
            this.eYX.setImageResource(a.f.sticker_unload);
            bqa();
        }
        d(fuFaceItem);
    }

    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.eYW.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void startLoadingAnim() {
        if (this.eYY == null) {
            this.eYY = ObjectAnimator.ofFloat(this.eYX, "rotation", 0.0f, 359.0f);
            this.eYY.setRepeatCount(-1);
            this.eYY.setDuration(1000L);
        }
        if (!this.eYY.isRunning()) {
            this.eYX.setImageResource(a.f.sticker_loading);
            this.eYY.start();
        }
    }

    public void bqa() {
        if (this.eYY != null && this.eYY.isRunning()) {
            this.eYY.cancel();
        }
    }
}
