package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.ar.d;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.a.e;
/* loaded from: classes3.dex */
public class c {
    public ImageView eMA;
    private ObjectAnimator eMB;
    private TbImageView eMz;
    public ImageView eNx;
    private TextView eyE;
    public View mRootView;

    public c(View view) {
        this.mRootView = view;
        this.eMz = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.eMz.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.eMz.setIsRound(true);
        this.eMz.setAutoChangeStyle(false);
        this.eMz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eMz.setDrawBorder(false);
        this.eMA = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.eNx = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.eyE = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(d dVar) {
        if (dVar != null) {
            this.eMz.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName()) || e.zb(dVar.tQ())) {
                this.eMA.setVisibility(4);
                bkG();
            } else if (!TextUtils.isEmpty(dVar.tQ()) && e.cy(dVar.tQ())) {
                this.eMA.setVisibility(0);
                startLoadingAnim();
            } else {
                this.eMA.setVisibility(0);
                this.eMA.setRotation(0.0f);
                this.eMA.setImageResource(a.f.sticker_unload);
                bkG();
            }
            this.eyE.setText(dVar.getName());
            c(dVar);
        }
    }

    public void c(d dVar) {
        if (dVar != null) {
            this.eMz.startLoad(dVar.tR(), 10, false);
        }
    }

    public void bkL() {
        this.eyE.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.eNx.setVisibility(4);
    }

    public void bkM() {
        this.eyE.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.eNx.setVisibility(0);
    }

    public void startLoadingAnim() {
        if (this.eMB == null) {
            this.eMB = ObjectAnimator.ofFloat(this.eMA, "rotation", 0.0f, 359.0f);
            this.eMB.setRepeatCount(-1);
            this.eMB.setDuration(1000L);
        }
        if (!this.eMB.isRunning()) {
            this.eMA.setImageResource(a.f.sticker_loading);
            this.eMB.start();
        }
    }

    public void bkG() {
        if (this.eMB != null && this.eMB.isRunning()) {
            this.eMB.cancel();
        }
    }
}
