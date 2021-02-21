package com.baidu.tieba.ala.alaar.sticker.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
/* loaded from: classes11.dex */
public class f extends i {
    private TbImageView gvX;
    public ImageView gvY;
    private ObjectAnimator gvZ;
    public ImageView gwa;

    public f(View view) {
        this.mRootView = view;
        this.gvX = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gvX.setDefaultBgResource(a.e.icon_live_gift_default);
        this.gvX.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.gvX.setAutoChangeStyle(false);
        this.gvY = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gwd = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gwa = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gwa.setVisibility(0);
            this.gvX.setVisibility(8);
            this.gvY.setVisibility(8);
            this.gwd.setVisibility(8);
            return;
        }
        this.gwa.setVisibility(8);
        this.gvX.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gvY.setVisibility(4);
            bQB();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bPQ().isRunning(fuFaceItem.file)) {
            this.gvY.setVisibility(0);
            bQA();
        } else {
            this.gvY.setVisibility(0);
            this.gvY.setRotation(0.0f);
            this.gvY.setImageResource(a.e.sticker_unload);
            bQB();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.gvX.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bQA() {
        if (this.gvZ == null) {
            this.gvZ = ObjectAnimator.ofFloat(this.gvY, "rotation", 0.0f, 359.0f);
            this.gvZ.setRepeatCount(-1);
            this.gvZ.setDuration(1000L);
        }
        if (!this.gvZ.isRunning()) {
            this.gvY.setImageResource(a.e.sticker_loading);
            this.gvZ.start();
        }
    }

    public void bQB() {
        if (this.gvZ != null && this.gvZ.isRunning()) {
            this.gvZ.cancel();
        }
    }
}
