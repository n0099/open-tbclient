package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class g {
    private TextView fgZ;
    private TbImageView gsZ;
    public ImageView gtL;
    public ImageView gta;
    private ObjectAnimator gtb;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.gsZ = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.gsZ.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gsZ.setIsRound(true);
        this.gsZ.setAutoChangeStyle(false);
        this.gsZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gsZ.setDrawBorder(false);
        this.gta = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gtL = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.fgZ = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gsZ.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Fd(iVar.yQ())) {
                this.gta.setVisibility(4);
                bPQ();
            } else if (!TextUtils.isEmpty(iVar.yQ()) && com.baidu.tieba.ala.alaar.sticker.a.e.cE(iVar.yQ())) {
                this.gta.setVisibility(0);
                bPP();
            } else {
                this.gta.setVisibility(0);
                this.gta.setRotation(0.0f);
                this.gta.setImageResource(a.e.sticker_unload);
                bPQ();
            }
            this.fgZ.setText(iVar.getName());
            c(iVar);
        }
    }

    public void c(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gsZ.startLoad(iVar.yP(), 10, false);
        }
    }

    public void bQc() {
        this.fgZ.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gtL.setVisibility(4);
    }

    public void bQd() {
        this.fgZ.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gtL.setVisibility(0);
    }

    public void bPP() {
        if (this.gtb == null) {
            this.gtb = ObjectAnimator.ofFloat(this.gta, "rotation", 0.0f, 359.0f);
            this.gtb.setRepeatCount(-1);
            this.gtb.setDuration(1000L);
        }
        if (!this.gtb.isRunning()) {
            this.gta.setImageResource(a.e.sticker_loading);
            this.gtb.start();
        }
    }

    public void bPQ() {
        if (this.gtb != null && this.gtb.isRunning()) {
            this.gtb.cancel();
        }
    }
}
