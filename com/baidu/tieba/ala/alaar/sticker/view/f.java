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
    private TbImageView fQh;
    public ImageView fQi;
    private ObjectAnimator fQj;
    public ImageView fQk;

    public f(View view) {
        this.mRootView = view;
        this.fQh = (TbImageView) this.mRootView.findViewById(a.g.sticker_img);
        this.fQh.setDefaultBgResource(a.f.icon_live_gift_default);
        this.fQh.setDefaultErrorResource(a.f.icon_live_gift_default);
        this.fQh.setAutoChangeStyle(false);
        this.fQi = (ImageView) this.mRootView.findViewById(a.g.sticker_unload);
        this.fQn = (MaskStrokeView) this.mRootView.findViewById(a.g.sticker_bg);
        this.fQk = (ImageView) this.mRootView.findViewById(a.g.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.fQk.setVisibility(0);
            this.fQh.setVisibility(8);
            this.fQi.setVisibility(8);
            this.fQn.setVisibility(8);
            return;
        }
        this.fQk.setVisibility(8);
        this.fQh.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.fQi.setVisibility(4);
            bJf();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bIv().isRunning(fuFaceItem.file)) {
            this.fQi.setVisibility(0);
            bJe();
        } else {
            this.fQi.setVisibility(0);
            this.fQi.setRotation(0.0f);
            this.fQi.setImageResource(a.f.sticker_unload);
            bJf();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.fQh.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bJe() {
        if (this.fQj == null) {
            this.fQj = ObjectAnimator.ofFloat(this.fQi, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fQj.setRepeatCount(-1);
            this.fQj.setDuration(1000L);
        }
        if (!this.fQj.isRunning()) {
            this.fQi.setImageResource(a.f.sticker_loading);
            this.fQj.start();
        }
    }

    public void bJf() {
        if (this.fQj != null && this.fQj.isRunning()) {
            this.fQj.cancel();
        }
    }
}
