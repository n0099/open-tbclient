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
    private TbImageView fDY;
    public ImageView fDZ;
    private ObjectAnimator fEa;
    public ImageView fEb;

    public f(View view) {
        this.mRootView = view;
        this.fDY = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.fDY.setDefaultBgResource(a.f.icon_live_gift_default);
        this.fDY.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.fDY.setAutoChangeStyle(false);
        this.fDZ = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.fEe = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.fEb = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.fEb.setVisibility(0);
            this.fDY.setVisibility(8);
            this.fDZ.setVisibility(8);
            this.fEe.setVisibility(8);
            return;
        }
        this.fEb.setVisibility(8);
        this.fDY.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.fDZ.setVisibility(4);
            bGt();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bFJ().isRunning(fuFaceItem.file)) {
            this.fDZ.setVisibility(0);
            bGs();
        } else {
            this.fDZ.setVisibility(0);
            this.fDZ.setRotation(0.0f);
            this.fDZ.setImageResource(a.f.sticker_unload);
            bGt();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.fDY.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bGs() {
        if (this.fEa == null) {
            this.fEa = ObjectAnimator.ofFloat(this.fDZ, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fEa.setRepeatCount(-1);
            this.fEa.setDuration(1000L);
        }
        if (!this.fEa.isRunning()) {
            this.fDZ.setImageResource(a.f.sticker_loading);
            this.fEa.start();
        }
    }

    public void bGt() {
        if (this.fEa != null && this.fEa.isRunning()) {
            this.fEa.cancel();
        }
    }
}
