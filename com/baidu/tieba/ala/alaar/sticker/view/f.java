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
    private TbImageView gxG;
    public ImageView gxH;
    private ObjectAnimator gxI;
    public ImageView gxJ;

    public f(View view) {
        this.mRootView = view;
        this.gxG = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gxG.setDefaultBgResource(a.e.icon_live_gift_default);
        this.gxG.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.gxG.setAutoChangeStyle(false);
        this.gxH = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gxM = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gxJ = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gxJ.setVisibility(0);
            this.gxG.setVisibility(8);
            this.gxH.setVisibility(8);
            this.gxM.setVisibility(8);
            return;
        }
        this.gxJ.setVisibility(8);
        this.gxG.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gxH.setVisibility(4);
            bQH();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bPW().isRunning(fuFaceItem.file)) {
            this.gxH.setVisibility(0);
            bQG();
        } else {
            this.gxH.setVisibility(0);
            this.gxH.setRotation(0.0f);
            this.gxH.setImageResource(a.e.sticker_unload);
            bQH();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.gxG.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bQG() {
        if (this.gxI == null) {
            this.gxI = ObjectAnimator.ofFloat(this.gxH, "rotation", 0.0f, 359.0f);
            this.gxI.setRepeatCount(-1);
            this.gxI.setDuration(1000L);
        }
        if (!this.gxI.isRunning()) {
            this.gxH.setImageResource(a.e.sticker_loading);
            this.gxI.start();
        }
    }

    public void bQH() {
        if (this.gxI != null && this.gxI.isRunning()) {
            this.gxI.cancel();
        }
    }
}
