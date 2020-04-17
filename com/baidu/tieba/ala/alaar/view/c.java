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
    private TbImageView eMu;
    public ImageView eMv;
    private ObjectAnimator eMw;
    public ImageView eNs;
    private TextView eyz;
    public View mRootView;

    public c(View view) {
        this.mRootView = view;
        this.eMu = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.eMu.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.eMu.setIsRound(true);
        this.eMu.setAutoChangeStyle(false);
        this.eMu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eMu.setDrawBorder(false);
        this.eMv = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.eNs = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.eyz = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(d dVar) {
        if (dVar != null) {
            this.eMu.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName()) || e.yY(dVar.tR())) {
                this.eMv.setVisibility(4);
                bkI();
            } else if (!TextUtils.isEmpty(dVar.tR()) && e.cy(dVar.tR())) {
                this.eMv.setVisibility(0);
                startLoadingAnim();
            } else {
                this.eMv.setVisibility(0);
                this.eMv.setRotation(0.0f);
                this.eMv.setImageResource(a.f.sticker_unload);
                bkI();
            }
            this.eyz.setText(dVar.getName());
            c(dVar);
        }
    }

    public void c(d dVar) {
        if (dVar != null) {
            this.eMu.startLoad(dVar.tS(), 10, false);
        }
    }

    public void bkN() {
        this.eyz.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.eNs.setVisibility(4);
    }

    public void bkO() {
        this.eyz.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.eNs.setVisibility(0);
    }

    public void startLoadingAnim() {
        if (this.eMw == null) {
            this.eMw = ObjectAnimator.ofFloat(this.eMv, "rotation", 0.0f, 359.0f);
            this.eMw.setRepeatCount(-1);
            this.eMw.setDuration(1000L);
        }
        if (!this.eMw.isRunning()) {
            this.eMv.setImageResource(a.f.sticker_loading);
            this.eMw.start();
        }
    }

    public void bkI() {
        if (this.eMw != null && this.eMw.isRunning()) {
            this.eMw.cancel();
        }
    }
}
