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
    private TbImageView gnj;
    public ImageView gnk;
    private ObjectAnimator gnl;
    public ImageView gnm;

    public f(View view) {
        this.mRootView = view;
        this.gnj = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gnj.setDefaultBgResource(a.e.icon_live_gift_default);
        this.gnj.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.gnj.setAutoChangeStyle(false);
        this.gnk = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gnp = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gnm = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gnm.setVisibility(0);
            this.gnj.setVisibility(8);
            this.gnk.setVisibility(8);
            this.gnp.setVisibility(8);
            return;
        }
        this.gnm.setVisibility(8);
        this.gnj.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gnk.setVisibility(4);
            bRj();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bQx().isRunning(fuFaceItem.file)) {
            this.gnk.setVisibility(0);
            bRi();
        } else {
            this.gnk.setVisibility(0);
            this.gnk.setRotation(0.0f);
            this.gnk.setImageResource(a.e.sticker_unload);
            bRj();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.gnj.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bRi() {
        if (this.gnl == null) {
            this.gnl = ObjectAnimator.ofFloat(this.gnk, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.gnl.setRepeatCount(-1);
            this.gnl.setDuration(1000L);
        }
        if (!this.gnl.isRunning()) {
            this.gnk.setImageResource(a.e.sticker_loading);
            this.gnl.start();
        }
    }

    public void bRj() {
        if (this.gnl != null && this.gnl.isRunning()) {
            this.gnl.cancel();
        }
    }
}
