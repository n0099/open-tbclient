package com.baidu.tieba.ala.alaar.sticker.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
/* loaded from: classes7.dex */
public class f extends i {
    private TbImageView fAM;
    public ImageView fAN;
    private ObjectAnimator fAO;
    public ImageView fAP;

    public f(View view) {
        this.mRootView = view;
        this.fAM = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.fAM.setDefaultBgResource(a.f.icon_live_gift_default);
        this.fAM.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.fAM.setAutoChangeStyle(false);
        this.fAN = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.fAS = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.fAP = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.fAP.setVisibility(0);
            this.fAM.setVisibility(8);
            this.fAN.setVisibility(8);
            this.fAS.setVisibility(8);
            return;
        }
        this.fAP.setVisibility(8);
        this.fAM.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.fAN.setVisibility(4);
            bFd();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bEt().isRunning(fuFaceItem.file)) {
            this.fAN.setVisibility(0);
            bFc();
        } else {
            this.fAN.setVisibility(0);
            this.fAN.setRotation(0.0f);
            this.fAN.setImageResource(a.f.sticker_unload);
            bFd();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.fAM.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bFc() {
        if (this.fAO == null) {
            this.fAO = ObjectAnimator.ofFloat(this.fAN, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fAO.setRepeatCount(-1);
            this.fAO.setDuration(1000L);
        }
        if (!this.fAO.isRunning()) {
            this.fAN.setImageResource(a.f.sticker_loading);
            this.fAO.start();
        }
    }

    public void bFd() {
        if (this.fAO != null && this.fAO.isRunning()) {
            this.fAO.cancel();
        }
    }
}
