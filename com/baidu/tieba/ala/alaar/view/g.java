package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes11.dex */
public class g {
    private TextView fjs;
    private TbImageView gvJ;
    public ImageView gvK;
    private ObjectAnimator gvL;
    public ImageView gwv;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.gvJ = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.gvJ.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gvJ.setIsRound(true);
        this.gvJ.setAutoChangeStyle(false);
        this.gvJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvJ.setDrawBorder(false);
        this.gvK = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gwv = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.fjs = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gvJ.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.FB(iVar.zx())) {
                this.gvK.setVisibility(4);
                bQu();
            } else if (!TextUtils.isEmpty(iVar.zx()) && com.baidu.tieba.ala.alaar.sticker.a.e.cE(iVar.zx())) {
                this.gvK.setVisibility(0);
                bQt();
            } else {
                this.gvK.setVisibility(0);
                this.gvK.setRotation(0.0f);
                this.gvK.setImageResource(a.e.sticker_unload);
                bQu();
            }
            this.fjs.setText(iVar.getName());
            c(iVar);
        }
    }

    public void c(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gvJ.startLoad(iVar.zw(), 10, false);
        }
    }

    public void bQG() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gwv.setVisibility(4);
    }

    public void bQH() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gwv.setVisibility(0);
    }

    public void bQt() {
        if (this.gvL == null) {
            this.gvL = ObjectAnimator.ofFloat(this.gvK, "rotation", 0.0f, 359.0f);
            this.gvL.setRepeatCount(-1);
            this.gvL.setDuration(1000L);
        }
        if (!this.gvL.isRunning()) {
            this.gvK.setImageResource(a.e.sticker_loading);
            this.gvL.start();
        }
    }

    public void bQu() {
        if (this.gvL != null && this.gvL.isRunning()) {
            this.gvL.cancel();
        }
    }
}
