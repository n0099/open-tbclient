package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes4.dex */
public class g {
    private TextView fcb;
    public ImageView gnV;
    private TbImageView gnj;
    public ImageView gnk;
    private ObjectAnimator gnl;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.gnj = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.gnj.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gnj.setIsRound(true);
        this.gnj.setAutoChangeStyle(false);
        this.gnj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnj.setDrawBorder(false);
        this.gnk = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gnV = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.fcb = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.gnj.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(hVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Gq(hVar.Dv())) {
                this.gnk.setVisibility(4);
                bRj();
            } else if (!TextUtils.isEmpty(hVar.Dv()) && com.baidu.tieba.ala.alaar.sticker.a.e.cL(hVar.Dv())) {
                this.gnk.setVisibility(0);
                bRi();
            } else {
                this.gnk.setVisibility(0);
                this.gnk.setRotation(0.0f);
                this.gnk.setImageResource(a.e.sticker_unload);
                bRj();
            }
            this.fcb.setText(hVar.getName());
            c(hVar);
        }
    }

    public void c(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.gnj.startLoad(hVar.Du(), 10, false);
        }
    }

    public void bRv() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gnV.setVisibility(4);
    }

    public void bRw() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gnV.setVisibility(0);
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
