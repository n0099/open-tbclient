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
    private TbImageView gvX;
    public ImageView gvY;
    private ObjectAnimator gvZ;
    public ImageView gwJ;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.gvX = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.gvX.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gvX.setIsRound(true);
        this.gvX.setAutoChangeStyle(false);
        this.gvX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvX.setDrawBorder(false);
        this.gvY = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gwJ = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.fjs = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gvX.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(iVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.FC(iVar.zx())) {
                this.gvY.setVisibility(4);
                bQB();
            } else if (!TextUtils.isEmpty(iVar.zx()) && com.baidu.tieba.ala.alaar.sticker.a.e.cE(iVar.zx())) {
                this.gvY.setVisibility(0);
                bQA();
            } else {
                this.gvY.setVisibility(0);
                this.gvY.setRotation(0.0f);
                this.gvY.setImageResource(a.e.sticker_unload);
                bQB();
            }
            this.fjs.setText(iVar.getName());
            c(iVar);
        }
    }

    public void c(com.baidu.live.ar.i iVar) {
        if (iVar != null) {
            this.gvX.startLoad(iVar.zw(), 10, false);
        }
    }

    public void bQN() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gwJ.setVisibility(4);
    }

    public void bQO() {
        this.fjs.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gwJ.setVisibility(0);
    }

    public void bQA() {
        if (this.gvZ == null) {
            this.gvZ = ObjectAnimator.ofFloat(this.gvY, "rotation", 0.0f, 359.0f);
            this.gvZ.setRepeatCount(-1);
            this.gvZ.setDuration(1000L);
        }
        if (!this.gvZ.isRunning()) {
            this.gvY.setImageResource(a.e.sticker_loading);
            this.gvZ.start();
        }
    }

    public void bQB() {
        if (this.gvZ != null && this.gvZ.isRunning()) {
            this.gvZ.cancel();
        }
    }
}
