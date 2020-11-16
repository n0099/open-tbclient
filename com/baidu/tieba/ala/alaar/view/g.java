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
    private TextView eUF;
    private TbImageView geZ;
    public ImageView gfL;
    public ImageView gfa;
    private ObjectAnimator gfb;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.geZ = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.geZ.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.geZ.setIsRound(true);
        this.geZ.setAutoChangeStyle(false);
        this.geZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.geZ.setDrawBorder(false);
        this.gfa = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gfL = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.eUF = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.geZ.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(hVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.FB(hVar.BL())) {
                this.gfa.setVisibility(4);
                bNx();
            } else if (!TextUtils.isEmpty(hVar.BL()) && com.baidu.tieba.ala.alaar.sticker.a.e.cI(hVar.BL())) {
                this.gfa.setVisibility(0);
                bNw();
            } else {
                this.gfa.setVisibility(0);
                this.gfa.setRotation(0.0f);
                this.gfa.setImageResource(a.e.sticker_unload);
                bNx();
            }
            this.eUF.setText(hVar.getName());
            c(hVar);
        }
    }

    public void c(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.geZ.startLoad(hVar.BK(), 10, false);
        }
    }

    public void bNJ() {
        this.eUF.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gfL.setVisibility(4);
    }

    public void bNK() {
        this.eUF.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gfL.setVisibility(0);
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
