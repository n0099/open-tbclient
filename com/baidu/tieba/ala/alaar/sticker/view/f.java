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
    private TbImageView geZ;
    public ImageView gfa;
    private ObjectAnimator gfb;
    public ImageView gfc;

    public f(View view) {
        this.mRootView = view;
        this.geZ = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.geZ.setDefaultBgResource(a.e.icon_live_gift_default);
        this.geZ.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.geZ.setAutoChangeStyle(false);
        this.gfa = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gff = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gfc = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gfc.setVisibility(0);
            this.geZ.setVisibility(8);
            this.gfa.setVisibility(8);
            this.gff.setVisibility(8);
            return;
        }
        this.gfc.setVisibility(8);
        this.geZ.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gfa.setVisibility(4);
            bNx();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bML().isRunning(fuFaceItem.file)) {
            this.gfa.setVisibility(0);
            bNw();
        } else {
            this.gfa.setVisibility(0);
            this.gfa.setRotation(0.0f);
            this.gfa.setImageResource(a.e.sticker_unload);
            bNx();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.geZ.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bNw() {
        if (this.gfb == null) {
            this.gfb = ObjectAnimator.ofFloat(this.gfa, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.gfb.setRepeatCount(-1);
            this.gfb.setDuration(1000L);
        }
        if (!this.gfb.isRunning()) {
            this.gfa.setImageResource(a.e.sticker_loading);
            this.gfb.start();
        }
    }

    public void bNx() {
        if (this.gfb != null && this.gfb.isRunning()) {
            this.gfb.cancel();
        }
    }
}
