package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.platform.comapi.map.MapBundleKey;
/* loaded from: classes4.dex */
public class g {
    private TextView eVu;
    private TbImageView gfs;
    public ImageView gft;
    private ObjectAnimator gfu;
    public ImageView gge;
    public View mRootView;

    public g(View view) {
        this.mRootView = view;
        this.gfs = (TbImageView) this.mRootView.findViewById(a.f.filter_img);
        this.gfs.setDefaultBgResource(a.e.filter_beauty_item_bg);
        this.gfs.setIsRound(true);
        this.gfs.setAutoChangeStyle(false);
        this.gfs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfs.setDrawBorder(false);
        this.gft = (ImageView) this.mRootView.findViewById(a.f.filter_unload);
        this.gge = (ImageView) this.mRootView.findViewById(a.f.filter_bg);
        this.eVu = (TextView) this.mRootView.findViewById(a.f.filter_text);
    }

    public void b(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.gfs.setVisibility(0);
            if (this.mRootView.getContext().getString(a.h.beauty_yuantu).equals(hVar.getName()) || com.baidu.tieba.ala.alaar.sticker.a.e.Ga(hVar.Cu())) {
                this.gft.setVisibility(4);
                bOe();
            } else if (!TextUtils.isEmpty(hVar.Cu()) && com.baidu.tieba.ala.alaar.sticker.a.e.cG(hVar.Cu())) {
                this.gft.setVisibility(0);
                bOd();
            } else {
                this.gft.setVisibility(0);
                this.gft.setRotation(0.0f);
                this.gft.setImageResource(a.e.sticker_unload);
                bOe();
            }
            this.eVu.setText(hVar.getName());
            c(hVar);
        }
    }

    public void c(com.baidu.live.ar.h hVar) {
        if (hVar != null) {
            this.gfs.startLoad(hVar.Ct(), 10, false);
        }
    }

    public void bOq() {
        this.eVu.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_cont_i));
        this.gge.setVisibility(4);
    }

    public void bOr() {
        this.eVu.setTextColor(this.mRootView.getResources().getColor(a.c.sdk_cp_other_b));
        this.gge.setVisibility(0);
    }

    public void bOd() {
        if (this.gfu == null) {
            this.gfu = ObjectAnimator.ofFloat(this.gft, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
            this.gfu.setRepeatCount(-1);
            this.gfu.setDuration(1000L);
        }
        if (!this.gfu.isRunning()) {
            this.gft.setImageResource(a.e.sticker_loading);
            this.gfu.start();
        }
    }

    public void bOe() {
        if (this.gfu != null && this.gfu.isRunning()) {
            this.gfu.cancel();
        }
    }
}
