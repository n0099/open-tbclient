package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.ar.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes4.dex */
public class e {
    private TextView eHj;
    private TbImageView fQh;
    public ImageView fQi;
    private ObjectAnimator fQj;
    public ImageView fRn;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.fQh = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.fQh.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fQh.setIsRound(true);
        this.fQh.setAutoChangeStyle(false);
        this.fQh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fQh.setDrawBorder(false);
        this.fQi = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.fRn = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.eHj = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.fQh.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Fo(fVar.Cb())) {
                this.fQi.setVisibility(4);
                bJf();
            } else if (!TextUtils.isEmpty(fVar.Cb()) && com.baidu.tieba.ala.alaar.sticker.a.e.cG(fVar.Cb())) {
                this.fQi.setVisibility(0);
                bJe();
            } else {
                this.fQi.setVisibility(0);
                this.fQi.setRotation(0.0f);
                this.fQi.setImageResource(a.f.sticker_unload);
                bJf();
            }
            this.eHj.setText(fVar.getName());
            c(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.fQh.startLoad(fVar.Ca(), 10, false);
        }
    }

    public void bJq() {
        this.eHj.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fRn.setVisibility(4);
    }

    public void bJr() {
        this.eHj.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fRn.setVisibility(0);
    }

    public void bJe() {
        if (this.fQj == null) {
            this.fQj = ObjectAnimator.ofFloat(this.fQi, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fQj.setRepeatCount(-1);
            this.fQj.setDuration(1000L);
        }
        if (!this.fQj.isRunning()) {
            this.fQi.setImageResource(a.f.sticker_loading);
            this.fQj.start();
        }
    }

    public void bJf() {
        if (this.fQj != null && this.fQj.isRunning()) {
            this.fQj.cancel();
        }
    }
}
