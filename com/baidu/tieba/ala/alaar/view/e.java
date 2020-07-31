package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.ar.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class e {
    private TextView eiX;
    private TbImageView fpl;
    public ImageView fpm;
    private ObjectAnimator fpn;
    public ImageView fqs;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.fpl = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.fpl.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fpl.setIsRound(true);
        this.fpl.setAutoChangeStyle(false);
        this.fpl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fpl.setDrawBorder(false);
        this.fpm = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.fqs = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.eiX = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.fpl.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.BL(fVar.vr())) {
                this.fpm.setVisibility(4);
                bwd();
            } else if (!TextUtils.isEmpty(fVar.vr()) && com.baidu.tieba.ala.alaar.sticker.a.e.cy(fVar.vr())) {
                this.fpm.setVisibility(0);
                startLoadingAnim();
            } else {
                this.fpm.setVisibility(0);
                this.fpm.setRotation(0.0f);
                this.fpm.setImageResource(a.f.sticker_unload);
                bwd();
            }
            this.eiX.setText(fVar.getName());
            c(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.fpl.startLoad(fVar.vq(), 10, false);
        }
    }

    public void bwo() {
        this.eiX.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fqs.setVisibility(4);
    }

    public void bwp() {
        this.eiX.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fqs.setVisibility(0);
    }

    public void startLoadingAnim() {
        if (this.fpn == null) {
            this.fpn = ObjectAnimator.ofFloat(this.fpm, "rotation", 0.0f, 359.0f);
            this.fpn.setRepeatCount(-1);
            this.fpn.setDuration(1000L);
        }
        if (!this.fpn.isRunning()) {
            this.fpm.setImageResource(a.f.sticker_loading);
            this.fpn.start();
        }
    }

    public void bwd() {
        if (this.fpn != null && this.fpn.isRunning()) {
            this.fpn.cancel();
        }
    }
}
