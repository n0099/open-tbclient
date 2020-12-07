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
    private TbImageView gnh;
    public ImageView gni;
    private ObjectAnimator gnj;
    public ImageView gnk;

    public f(View view) {
        this.mRootView = view;
        this.gnh = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gnh.setDefaultBgResource(a.e.icon_live_gift_default);
        this.gnh.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.gnh.setAutoChangeStyle(false);
        this.gni = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gnn = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gnk = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gnk.setVisibility(0);
            this.gnh.setVisibility(8);
            this.gni.setVisibility(8);
            this.gnn.setVisibility(8);
            return;
        }
        this.gnk.setVisibility(8);
        this.gnh.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gni.setVisibility(4);
            bRi();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bQw().isRunning(fuFaceItem.file)) {
            this.gni.setVisibility(0);
            bRh();
        } else {
            this.gni.setVisibility(0);
            this.gni.setRotation(0.0f);
            this.gni.setImageResource(a.e.sticker_unload);
            bRi();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.gnh.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bRh() {
        if (this.gnj == null) {
            this.gnj = ObjectAnimator.ofFloat(this.gni, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.gnj.setRepeatCount(-1);
            this.gnj.setDuration(1000L);
        }
        if (!this.gnj.isRunning()) {
            this.gni.setImageResource(a.e.sticker_loading);
            this.gnj.start();
        }
    }

    public void bRi() {
        if (this.gnj != null && this.gnj.isRunning()) {
            this.gnj.cancel();
        }
    }
}
