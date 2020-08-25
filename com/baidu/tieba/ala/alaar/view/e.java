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
    private TextView esQ;
    private TbImageView fAI;
    public ImageView fAJ;
    private ObjectAnimator fAK;
    public ImageView fBO;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.fAI = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.fAI.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fAI.setIsRound(true);
        this.fAI.setAutoChangeStyle(false);
        this.fAI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAI.setDrawBorder(false);
        this.fAJ = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.fBO = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.esQ = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.fAI.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Ef(fVar.AP())) {
                this.fAJ.setVisibility(4);
                bFc();
            } else if (!TextUtils.isEmpty(fVar.AP()) && com.baidu.tieba.ala.alaar.sticker.a.e.cD(fVar.AP())) {
                this.fAJ.setVisibility(0);
                bFb();
            } else {
                this.fAJ.setVisibility(0);
                this.fAJ.setRotation(0.0f);
                this.fAJ.setImageResource(a.f.sticker_unload);
                bFc();
            }
            this.esQ.setText(fVar.getName());
            c(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.fAI.startLoad(fVar.AO(), 10, false);
        }
    }

    public void bFn() {
        this.esQ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fBO.setVisibility(4);
    }

    public void bFo() {
        this.esQ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fBO.setVisibility(0);
    }

    public void bFb() {
        if (this.fAK == null) {
            this.fAK = ObjectAnimator.ofFloat(this.fAJ, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fAK.setRepeatCount(-1);
            this.fAK.setDuration(1000L);
        }
        if (!this.fAK.isRunning()) {
            this.fAJ.setImageResource(a.f.sticker_loading);
            this.fAK.start();
        }
    }

    public void bFc() {
        if (this.fAK != null && this.fAK.isRunning()) {
            this.fAK.cancel();
        }
    }
}
