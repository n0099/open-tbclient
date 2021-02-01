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
    private TbImageView gvJ;
    public ImageView gvK;
    private ObjectAnimator gvL;
    public ImageView gvM;

    public f(View view) {
        this.mRootView = view;
        this.gvJ = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gvJ.setDefaultBgResource(a.e.icon_live_gift_default);
        this.gvJ.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.gvJ.setAutoChangeStyle(false);
        this.gvK = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gvP = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gvM = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gvM.setVisibility(0);
            this.gvJ.setVisibility(8);
            this.gvK.setVisibility(8);
            this.gvP.setVisibility(8);
            return;
        }
        this.gvM.setVisibility(8);
        this.gvJ.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gvK.setVisibility(4);
            bQu();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bPJ().isRunning(fuFaceItem.file)) {
            this.gvK.setVisibility(0);
            bQt();
        } else {
            this.gvK.setVisibility(0);
            this.gvK.setRotation(0.0f);
            this.gvK.setImageResource(a.e.sticker_unload);
            bQu();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.gvJ.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bQt() {
        if (this.gvL == null) {
            this.gvL = ObjectAnimator.ofFloat(this.gvK, "rotation", 0.0f, 359.0f);
            this.gvL.setRepeatCount(-1);
            this.gvL.setDuration(1000L);
        }
        if (!this.gvL.isRunning()) {
            this.gvK.setImageResource(a.e.sticker_loading);
            this.gvL.start();
        }
    }

    public void bQu() {
        if (this.gvL != null && this.gvL.isRunning()) {
            this.gvL.cancel();
        }
    }
}
