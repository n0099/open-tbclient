package com.baidu.tieba.ala.alaar.sticker.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
/* loaded from: classes3.dex */
public class f extends i {
    private TbImageView fke;
    public ImageView fkf;
    private ObjectAnimator fkg;
    public ImageView fkh;

    public f(View view) {
        this.mRootView = view;
        this.fke = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.fke.setDefaultBgResource(a.f.icon_live_gift_default);
        this.fke.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.fke.setAutoChangeStyle(false);
        this.fkf = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.fkk = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.fkh = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.fkh.setVisibility(0);
            this.fke.setVisibility(8);
            this.fkf.setVisibility(8);
            this.fkk.setVisibility(8);
            return;
        }
        this.fkh.setVisibility(8);
        this.fke.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.fkf.setVisibility(4);
            bsU();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bso().isRunning(fuFaceItem.file)) {
            this.fkf.setVisibility(0);
            startLoadingAnim();
        } else {
            this.fkf.setVisibility(0);
            this.fkf.setRotation(0.0f);
            this.fkf.setImageResource(a.f.sticker_unload);
            bsU();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.fke.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void startLoadingAnim() {
        if (this.fkg == null) {
            this.fkg = ObjectAnimator.ofFloat(this.fkf, "rotation", 0.0f, 359.0f);
            this.fkg.setRepeatCount(-1);
            this.fkg.setDuration(1000L);
        }
        if (!this.fkg.isRunning()) {
            this.fkf.setImageResource(a.f.sticker_loading);
            this.fkg.start();
        }
    }

    public void bsU() {
        if (this.fkg != null && this.fkg.isRunning()) {
            this.fkg.cancel();
        }
    }
}
