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
    private TextView eNe;
    private TbImageView eYW;
    public ImageView eYX;
    private ObjectAnimator eYY;
    public ImageView eZU;
    public View mRootView;

    public c(View view) {
        this.mRootView = view;
        this.eYW = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.eYW.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.eYW.setIsRound(true);
        this.eYW.setAutoChangeStyle(false);
        this.eYW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eYW.setDrawBorder(false);
        this.eYX = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.eZU = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.eNe = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(d dVar) {
        if (dVar != null) {
            this.eYW.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName()) || e.AH(dVar.uX())) {
                this.eYX.setVisibility(4);
                bqa();
            } else if (!TextUtils.isEmpty(dVar.uX()) && e.cz(dVar.uX())) {
                this.eYX.setVisibility(0);
                startLoadingAnim();
            } else {
                this.eYX.setVisibility(0);
                this.eYX.setRotation(0.0f);
                this.eYX.setImageResource(a.f.sticker_unload);
                bqa();
            }
            this.eNe.setText(dVar.getName());
            c(dVar);
        }
    }

    public void c(d dVar) {
        if (dVar != null) {
            this.eYW.startLoad(dVar.uY(), 10, false);
        }
    }

    public void bqf() {
        this.eNe.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.eZU.setVisibility(4);
    }

    public void bqg() {
        this.eNe.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.eZU.setVisibility(0);
    }

    public void startLoadingAnim() {
        if (this.eYY == null) {
            this.eYY = ObjectAnimator.ofFloat(this.eYX, "rotation", 0.0f, 359.0f);
            this.eYY.setRepeatCount(-1);
            this.eYY.setDuration(1000L);
        }
        if (!this.eYY.isRunning()) {
            this.eYX.setImageResource(a.f.sticker_loading);
            this.eYY.start();
        }
    }

    public void bqa() {
        if (this.eYY != null && this.eYY.isRunning()) {
            this.eYY.cancel();
        }
    }
}
