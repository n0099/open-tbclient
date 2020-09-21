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
    private TextView euZ;
    private TbImageView fDY;
    public ImageView fDZ;
    private ObjectAnimator fEa;
    public ImageView fFe;
    public View mRootView;

    public e(View view) {
        this.mRootView = view;
        this.fDY = (TbImageView) this.mRootView.findViewById(a.g.filter_img);
        this.fDY.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fDY.setIsRound(true);
        this.fDY.setAutoChangeStyle(false);
        this.fDY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fDY.setDrawBorder(false);
        this.fDZ = (ImageView) this.mRootView.findViewById(a.g.filter_unload);
        this.fFe = (ImageView) this.mRootView.findViewById(a.g.filter_bg);
        this.euZ = (TextView) this.mRootView.findViewById(a.g.filter_text);
    }

    public void b(f fVar) {
        if (fVar != null) {
            this.fDY.setVisibility(0);
            if (this.mRootView.getContext().getString(a.i.beauty_yuantu).equals(fVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.ED(fVar.Be())) {
                this.fDZ.setVisibility(4);
                bGt();
            } else if (!TextUtils.isEmpty(fVar.Be()) && com.baidu.tieba.ala.alaar.sticker.a.e.cG(fVar.Be())) {
                this.fDZ.setVisibility(0);
                bGs();
            } else {
                this.fDZ.setVisibility(0);
                this.fDZ.setRotation(0.0f);
                this.fDZ.setImageResource(a.f.sticker_unload);
                bGt();
            }
            this.euZ.setText(fVar.getName());
            c(fVar);
        }
    }

    public void c(f fVar) {
        if (fVar != null) {
            this.fDY.startLoad(fVar.Bd(), 10, false);
        }
    }

    public void bGE() {
        this.euZ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.fFe.setVisibility(4);
    }

    public void bGF() {
        this.euZ.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.fFe.setVisibility(0);
    }

    public void bGs() {
        if (this.fEa == null) {
            this.fEa = ObjectAnimator.ofFloat(this.fDZ, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.fEa.setRepeatCount(-1);
            this.fEa.setDuration(1000L);
        }
        if (!this.fEa.isRunning()) {
            this.fDZ.setImageResource(a.f.sticker_loading);
            this.fEa.start();
        }
    }

    public void bGt() {
        if (this.fEa != null && this.fEa.isRunning()) {
            this.fEa.cancel();
        }
    }
}
