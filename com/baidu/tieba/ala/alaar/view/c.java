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
    private TextView eNp;
    private TbImageView eZh;
    public ImageView eZi;
    private ObjectAnimator eZj;
    public ImageView faf;
    public View mRootView;

    public c(View view) {
        this.mRootView = view;
        this.eZh = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.eZh.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.eZh.setIsRound(true);
        this.eZh.setAutoChangeStyle(false);
        this.eZh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eZh.setDrawBorder(false);
        this.eZi = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.faf = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.eNp = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(d dVar) {
        if (dVar != null) {
            this.eZh.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName()) || e.AH(dVar.uX())) {
                this.eZi.setVisibility(4);
                bqc();
            } else if (!TextUtils.isEmpty(dVar.uX()) && e.cz(dVar.uX())) {
                this.eZi.setVisibility(0);
                startLoadingAnim();
            } else {
                this.eZi.setVisibility(0);
                this.eZi.setRotation(0.0f);
                this.eZi.setImageResource(a.f.sticker_unload);
                bqc();
            }
            this.eNp.setText(dVar.getName());
            c(dVar);
        }
    }

    public void c(d dVar) {
        if (dVar != null) {
            this.eZh.startLoad(dVar.uY(), 10, false);
        }
    }

    public void bqh() {
        this.eNp.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.faf.setVisibility(4);
    }

    public void bqi() {
        this.eNp.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.faf.setVisibility(0);
    }

    public void startLoadingAnim() {
        if (this.eZj == null) {
            this.eZj = ObjectAnimator.ofFloat(this.eZi, "rotation", 0.0f, 359.0f);
            this.eZj.setRepeatCount(-1);
            this.eZj.setDuration(1000L);
        }
        if (!this.eZj.isRunning()) {
            this.eZi.setImageResource(a.f.sticker_loading);
            this.eZj.start();
        }
    }

    public void bqc() {
        if (this.eZj != null && this.eZj.isRunning()) {
            this.eZj.cancel();
        }
    }
}
