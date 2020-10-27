package com.baidu.tieba.ala.alaar.sticker.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
/* loaded from: classes4.dex */
public class f extends i {
    private TbImageView fZA;
    public ImageView fZB;
    private ObjectAnimator fZC;
    public ImageView fZD;

    public f(View view) {
        this.mRootView = view;
        this.fZA = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.fZA.setDefaultBgResource(a.f.icon_live_gift_default);
        this.fZA.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.fZA.setAutoChangeStyle(false);
        this.fZB = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.fZG = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.fZD = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.fZD.setVisibility(0);
            this.fZA.setVisibility(8);
            this.fZB.setVisibility(8);
            this.fZG.setVisibility(8);
            return;
        }
        this.fZD.setVisibility(8);
        this.fZA.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.fZB.setVisibility(4);
            bLF();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bKT().isRunning(fuFaceItem.file)) {
            this.fZB.setVisibility(0);
            bLE();
        } else {
            this.fZB.setVisibility(0);
            this.fZB.setRotation(0.0f);
            this.fZB.setImageResource(a.f.sticker_unload);
            bLF();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.fZA.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bLE() {
        if (this.fZC == null) {
            this.fZC = ObjectAnimator.ofFloat(this.fZB, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fZC.setRepeatCount(-1);
            this.fZC.setDuration(1000L);
        }
        if (!this.fZC.isRunning()) {
            this.fZB.setImageResource(a.f.sticker_loading);
            this.fZC.start();
        }
    }

    public void bLF() {
        if (this.fZC != null && this.fZC.isRunning()) {
            this.fZC.cancel();
        }
    }
}
