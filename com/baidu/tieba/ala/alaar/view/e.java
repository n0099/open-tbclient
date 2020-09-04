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
/* loaded from: classes7.dex */
public class e {
    private TextView esU;
    private TbImageView fAM;
    public ImageView fAN;
    private ObjectAnimator fAO;
    public ImageView fBS;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.fAM = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.fAM.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fAM.setIsRound(true);
        this.fAM.setAutoChangeStyle(false);
        this.fAM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAM.setDrawBorder(false);
        this.fAN = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.fBS = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.esU = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.fAM.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Eg(fVar.AP())) {
                this.fAN.setVisibility(4);
                bFd();
            } else if (!TextUtils.isEmpty(fVar.AP()) && com.baidu.tieba.ala.alaar.sticker.a.e.cE(fVar.AP())) {
                this.fAN.setVisibility(0);
                bFc();
            } else {
                this.fAN.setVisibility(0);
                this.fAN.setRotation(0.0f);
                this.fAN.setImageResource(a.f.sticker_unload);
                bFd();
            }
            this.esU.setText(fVar.getName());
            c(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.fAM.startLoad(fVar.AO(), 10, false);
        }
    }

    public void bFo() {
        this.esU.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fBS.setVisibility(4);
    }

    public void bFp() {
        this.esU.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fBS.setVisibility(0);
    }

    public void bFc() {
        if (this.fAO == null) {
            this.fAO = ObjectAnimator.ofFloat(this.fAN, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fAO.setRepeatCount(-1);
            this.fAO.setDuration(1000L);
        }
        if (!this.fAO.isRunning()) {
            this.fAN.setImageResource(a.f.sticker_loading);
            this.fAO.start();
        }
    }

    public void bFd() {
        if (this.fAO != null && this.fAO.isRunning()) {
            this.fAO.cancel();
        }
    }
}
