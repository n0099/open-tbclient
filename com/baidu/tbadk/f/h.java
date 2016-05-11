package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends a {
    private TbImageView auD;
    private TextView auE;
    private TextView auF;
    private TextView auG;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(t.h.net_refresh_view_layout, (ViewGroup) null));
        this.auD = (TbImageView) this.auw.findViewById(t.g.net_refresh_image);
        this.auE = (TextView) this.auw.findViewById(t.g.net_refresh_desc);
        this.auF = (TextView) this.auw.findViewById(t.g.net_refresh_title);
        this.auG = (TextView) this.auw.findViewById(t.g.net_refresh_button);
        this.auG.setOnClickListener(onClickListener);
        this.auw.setOnClickListener(null);
        sf();
    }

    public void fR(String str) {
        if (str == null) {
            this.auE.setVisibility(8);
            return;
        }
        this.auE.setVisibility(0);
        this.auE.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.auF.setText(str);
        }
    }

    public void fS(String str) {
        if (str != null) {
            this.auG.setText(str);
        }
    }

    public void eB(int i) {
        ViewGroup.LayoutParams layoutParams = this.auD.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.auD.setLayoutParams(marginLayoutParams);
        }
    }

    public void CZ() {
        this.auG.setVisibility(0);
        this.auF.setVisibility(0);
        at.c(this.auE, t.d.cp_cont_d, 1);
    }

    public void Da() {
        this.auG.setVisibility(8);
        this.auF.setVisibility(8);
        at.c(this.auE, t.d.cp_cont_b, 1);
    }

    public void sf() {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        at.c(this.auD, t.f.net_refresh_emotion);
        at.b(this.auE, t.d.cp_cont_d, 1, skinType);
        at.b(this.auF, t.d.cp_cont_b, 1, skinType);
        at.b(this.auG, t.d.cp_cont_g, 1, skinType);
        at.d(this.auG, t.f.btn_appdownload, skinType);
        at.l(this.auw, t.d.cp_bg_line_d);
    }

    public View CY() {
        return this.auw;
    }
}
