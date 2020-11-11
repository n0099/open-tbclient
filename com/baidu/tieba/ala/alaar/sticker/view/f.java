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
    private TbImageView gfs;
    public ImageView gft;
    private ObjectAnimator gfu;
    public ImageView gfv;

    public f(View view) {
        this.mRootView = view;
        this.gfs = (TbImageView) this.mRootView.findViewById(a.f.sticker_img);
        this.gfs.setDefaultBgResource(a.e.icon_live_gift_default);
        this.gfs.setDefaultErrorResource(a.e.icon_live_gift_default);
        this.gfs.setAutoChangeStyle(false);
        this.gft = (ImageView) this.mRootView.findViewById(a.f.sticker_unload);
        this.gfy = (MaskStrokeView) this.mRootView.findViewById(a.f.sticker_bg);
        this.gfv = (ImageView) this.mRootView.findViewById(a.f.sticker_cancel);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.view.i
    public void d(FuFaceItem fuFaceItem) {
        if (fuFaceItem.isCancelItem) {
            this.gfv.setVisibility(0);
            this.gfs.setVisibility(8);
            this.gft.setVisibility(8);
            this.gfy.setVisibility(8);
            return;
        }
        this.gfv.setVisibility(8);
        this.gfs.setVisibility(0);
        if (fuFaceItem.isResLoaded()) {
            this.gft.setVisibility(4);
            bOe();
        } else if (!TextUtils.isEmpty(fuFaceItem.file) && com.baidu.tieba.ala.alaar.sticker.download.b.bNs().isRunning(fuFaceItem.file)) {
            this.gft.setVisibility(0);
            bOd();
        } else {
            this.gft.setVisibility(0);
            this.gft.setRotation(0.0f);
            this.gft.setImageResource(a.e.sticker_unload);
            bOe();
        }
        e(fuFaceItem);
    }

    public void e(FuFaceItem fuFaceItem) {
        if (fuFaceItem != null) {
            this.gfs.startLoad(fuFaceItem.bgurl, 10, false);
        }
    }

    public void bOd() {
        if (this.gfu == null) {
            this.gfu = ObjectAnimator.ofFloat(this.gft, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.gfu.setRepeatCount(-1);
            this.gfu.setDuration(1000L);
        }
        if (!this.gfu.isRunning()) {
            this.gft.setImageResource(a.e.sticker_loading);
            this.gfu.start();
        }
    }

    public void bOe() {
        if (this.gfu != null && this.gfu.isRunning()) {
            this.gfu.cancel();
        }
    }
}
