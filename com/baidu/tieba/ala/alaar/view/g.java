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
    public ImageView gnT;
    private TbImageView gnh;
    public ImageView gni;
    private ObjectAnimator gnj;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.gnh = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.gnh.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gnh.setIsRound(true);
        this.gnh.setAutoChangeStyle(false);
        this.gnh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnh.setDrawBorder(false);
        this.gni = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gnT = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.fcb = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.gnh.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(hVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Gq(hVar.Dv())) {
                this.gni.setVisibility(4);
                bRi();
            } else if (!TextUtils.isEmpty(hVar.Dv()) && com.baidu.tieba.ala.alaar.sticker.a.e.cL(hVar.Dv())) {
                this.gni.setVisibility(0);
                bRh();
            } else {
                this.gni.setVisibility(0);
                this.gni.setRotation(0.0f);
                this.gni.setImageResource(a.e.sticker_unload);
                bRi();
            }
            this.fcb.setText(hVar.getName());
            c(hVar);
        }
    }

    public void c(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.gnh.startLoad(hVar.Du(), 10, false);
        }
    }

    public void bRu() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gnT.setVisibility(4);
    }

    public void bRv() {
        this.fcb.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gnT.setVisibility(0);
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
