package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.ar.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes3.dex */
public class e {
    private TextView ecN;
    private TbImageView fke;
    public ImageView fkf;
    private ObjectAnimator fkg;
    public ImageView flk;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.fke = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.fke.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fke.setIsRound(true);
        this.fke.setAutoChangeStyle(false);
        this.fke.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fke.setDrawBorder(false);
        this.fkf = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.flk = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.ecN = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.fke.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Ba(fVar.vr())) {
                this.fkf.setVisibility(4);
                bsT();
            } else if (!TextUtils.isEmpty(fVar.vr()) && com.baidu.tieba.ala.alaar.sticker.a.e.cA(fVar.vr())) {
                this.fkf.setVisibility(0);
                startLoadingAnim();
            } else {
                this.fkf.setVisibility(0);
                this.fkf.setRotation(0.0f);
                this.fkf.setImageResource(a.f.sticker_unload);
                bsT();
            }
            this.ecN.setText(fVar.getName());
            c(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.fke.startLoad(fVar.vq(), 10, false);
        }
    }

    public void bte() {
        this.ecN.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.flk.setVisibility(4);
    }

    public void btf() {
        this.ecN.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.flk.setVisibility(0);
    }

    public void startLoadingAnim() {
        if (this.fkg == null) {
            this.fkg = ObjectAnimator.ofFloat(this.fkf, "rotation", 0.0f, 359.0f);
            this.fkg.setRepeatCount(-1);
            this.fkg.setDuration(1000L);
        }
        if (!this.fkg.isRunning()) {
            this.fkf.setImageResource(a.f.sticker_loading);
            this.fkg.start();
        }
    }

    public void bsT() {
        if (this.fkg != null && this.fkg.isRunning()) {
            this.fkg.cancel();
        }
    }
}
