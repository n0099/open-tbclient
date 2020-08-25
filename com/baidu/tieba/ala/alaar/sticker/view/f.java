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
    private TbImageView fAI;
    public ImageView fAJ;
    private ObjectAnimator fAK;
    public ImageView fAL;

    public f(View view) {
        this.mRootView = view;
        this.fAI = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.fAI.setDefaultBgResource(a.f.icon_live_gift_default);
        this.fAI.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.fAI.setAutoChangeStyle(false);
        this.fAJ = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.fAO = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.fAL = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.fAL.setVisibility(0);
            this.fAI.setVisibility(8);
            this.fAJ.setVisibility(8);
            this.fAO.setVisibility(8);
            return;
        }
        this.fAL.setVisibility(8);
        this.fAI.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.fAJ.setVisibility(4);
            bFc();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bEs().isRunning(fuFaceItem.file)) {
            this.fAJ.setVisibility(0);
            bFb();
        } else {
            this.fAJ.setVisibility(0);
            this.fAJ.setRotation(0.0f);
            this.fAJ.setImageResource(a.f.sticker_unload);
            bFc();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.fAI.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bFb() {
        if (this.fAK == null) {
            this.fAK = ObjectAnimator.ofFloat(this.fAJ, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fAK.setRepeatCount(-1);
            this.fAK.setDuration(1000L);
        }
        if (!this.fAK.isRunning()) {
            this.fAJ.setImageResource(a.f.sticker_loading);
            this.fAK.start();
        }
    }

    public void bFc() {
        if (this.fAK != null && this.fAK.isRunning()) {
            this.fAK.cancel();
        }
    }
}
