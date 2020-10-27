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
    private TextView ePF;
    private TbImageView fZA;
    public ImageView fZB;
    private ObjectAnimator fZC;
    public ImageView gan;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.fZA = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.fZA.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fZA.setIsRound(true);
        this.fZA.setAutoChangeStyle(false);
        this.fZA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZA.setDrawBorder(false);
        this.fZB = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.gan = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.ePF = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(com.baidu.live.ar.g gVar) {
        if (gVar != null) {
            this.fZA.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(gVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.FM(gVar.Cc())) {
                this.fZB.setVisibility(4);
                bLF();
            } else if (!TextUtils.isEmpty(gVar.Cc()) && com.baidu.tieba.ala.alaar.sticker.a.e.cG(gVar.Cc())) {
                this.fZB.setVisibility(0);
                bLE();
            } else {
                this.fZB.setVisibility(0);
                this.fZB.setRotation(0.0f);
                this.fZB.setImageResource(a.f.sticker_unload);
                bLF();
            }
            this.ePF.setText(gVar.getName());
            c(gVar);
        }
    }

    public void c(com.baidu.live.ar.g gVar) {
        if (gVar != null) {
            this.fZA.startLoad(gVar.Cb(), 10, false);
        }
    }

    public void bLQ() {
        this.ePF.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.gan.setVisibility(4);
    }

    public void bLR() {
        this.ePF.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.gan.setVisibility(0);
    }

    public void bLE() {
        if (this.fZC == null) {
            this.fZC = ObjectAnimator.ofFloat(this.fZB, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fZC.setRepeatCount(-1);
            this.fZC.setDuration(1000L);
        }
        if (!this.fZC.isRunning()) {
            this.fZB.setImageResource(a.f.sticker_loading);
            this.fZC.start();
        }
    }

    public void bLF() {
        if (this.fZC != null && this.fZC.isRunning()) {
            this.fZC.cancel();
        }
    }
}
