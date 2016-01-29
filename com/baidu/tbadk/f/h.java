package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends a {
    private TbImageView axV;
    private TextView axW;
    private TextView axX;
    private TextView axY;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(t.h.net_refresh_view_layout, (ViewGroup) null));
        this.axV = (TbImageView) this.axO.findViewById(t.g.net_refresh_image);
        this.axW = (TextView) this.axO.findViewById(t.g.net_refresh_desc);
        this.axX = (TextView) this.axO.findViewById(t.g.net_refresh_title);
        this.axY = (TextView) this.axO.findViewById(t.g.net_refresh_button);
        this.axY.setOnClickListener(onClickListener);
        this.axO.setOnClickListener(null);
        uv();
    }

    public void fN(String str) {
        this.axW.setText(str);
    }

    public void eP(int i) {
        ViewGroup.LayoutParams layoutParams = this.axV.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.axV.setLayoutParams(marginLayoutParams);
        }
    }

    public void Eu() {
        this.axY.setVisibility(0);
        this.axX.setVisibility(0);
        ar.b(this.axW, t.d.cp_cont_d, 1);
    }

    public void Ev() {
        this.axY.setVisibility(8);
        this.axX.setVisibility(8);
        ar.b(this.axW, t.d.cp_cont_b, 1);
    }

    public void uv() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        ar.c(this.axV, t.f.net_refresh_emotion);
        ar.a(this.axW, t.d.cp_cont_d, 1, skinType);
        ar.a(this.axX, t.d.cp_cont_b, 1, skinType);
        ar.a(this.axY, t.d.cp_cont_g, 1, skinType);
        ar.c(this.axY, t.f.btn_appdownload, skinType);
        ar.l(this.axO, t.d.cp_bg_line_d);
    }
}
