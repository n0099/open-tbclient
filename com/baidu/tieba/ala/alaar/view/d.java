package com.baidu.tieba.ala.alaar.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes3.dex */
public class d {
    private TextView ecN;
    private TbImageView fke;
    public ImageView flk;
    private TextView flm;
    public ImageView fln;
    private FrameLayout flz;
    public View mRootView;

    public d(View view) {
        this.mRootView = view;
        this.fke = (TbImageView) this.mRootView.findViewById(a.g.face_img);
        this.fke.setDefaultBgResource(a.f.filter_beauty_item_bg);
        this.fke.setIsRound(true);
        this.fke.setAutoChangeStyle(false);
        this.fke.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fke.setDrawBorder(false);
        this.flk = (ImageView) this.mRootView.findViewById(a.g.face_bg);
        this.ecN = (TextView) this.mRootView.findViewById(a.g.face_text);
        this.flm = (TextView) this.mRootView.findViewById(a.g.line);
        this.flz = (FrameLayout) this.mRootView.findViewById(a.g.fl_head);
        this.fln = (ImageView) this.mRootView.findViewById(a.g.face_redot);
        this.fln.setVisibility(8);
    }

    public void a(com.baidu.live.ar.e eVar) {
        if (eVar != null) {
            this.ecN.setText(eVar.getName());
            Bt(eVar.vq());
            if (com.baidu.live.c.vf().getInt("beauty_subitem_redot", 0) == 1) {
                setRedotVisible(com.baidu.live.c.vf().getBoolean(eVar.getType(), true));
            }
        }
    }

    public void Bt(String str) {
        this.fke.startLoad(str, 10, false);
    }

    public void bte() {
        this.ecN.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_cont_i));
        this.flk.setVisibility(4);
    }

    public void btf() {
        this.ecN.setTextColor(this.mRootView.getResources().getColor(a.d.sdk_cp_other_b));
        this.flk.setVisibility(0);
    }

    public void setRedotVisible(boolean z) {
        if (z) {
            this.fln.setVisibility(0);
        } else {
            this.fln.setVisibility(8);
        }
    }
}
