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
    private TextView fkR;
    private TbImageView gxG;
    public ImageView gxH;
    private ObjectAnimator gxI;
    public ImageView gys;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.gxG = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.gxG.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gxG.setIsRound(true);
        this.gxG.setAutoChangeStyle(false);
        this.gxG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gxG.setDrawBorder(false);
        this.gxH = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gys = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.fkR = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gxG.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.FL(iVar.zA())) {
                this.gxH.setVisibility(4);
                bQH();
            } else if (!TextUtils.isEmpty(iVar.zA()) && com.baidu.tieba.ala.alaar.sticker.a.e.cI(iVar.zA())) {
                this.gxH.setVisibility(0);
                bQG();
            } else {
                this.gxH.setVisibility(0);
                this.gxH.setRotation(0.0f);
                this.gxH.setImageResource(a.e.sticker_unload);
                bQH();
            }
            this.fkR.setText(iVar.getName());
            c(iVar);
        }
    }

    public void c(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gxG.startLoad(iVar.zz(), 10, false);
        }
    }

    public void bQT() {
        this.fkR.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gys.setVisibility(4);
    }

    public void bQU() {
        this.fkR.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gys.setVisibility(0);
    }

    public void bQG() {
        if (this.gxI == null) {
            this.gxI = ObjectAnimator.ofFloat(this.gxH, "rotation", 0.0f, 359.0f);
            this.gxI.setRepeatCount(-1);
            this.gxI.setDuration(1000L);
        }
        if (!this.gxI.isRunning()) {
            this.gxH.setImageResource(a.e.sticker_loading);
            this.gxI.start();
        }
    }

    public void bQH() {
        if (this.gxI != null && this.gxI.isRunning()) {
            this.gxI.cancel();
        }
    }
}
