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
    private TbImageView ayC;
    private TextView ayD;
    private TextView ayE;
    private TextView ayF;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(t.h.net_refresh_view_layout, (ViewGroup) null));
        this.ayC = (TbImageView) this.ayv.findViewById(t.g.net_refresh_image);
        this.ayD = (TextView) this.ayv.findViewById(t.g.net_refresh_desc);
        this.ayE = (TextView) this.ayv.findViewById(t.g.net_refresh_title);
        this.ayF = (TextView) this.ayv.findViewById(t.g.net_refresh_button);
        this.ayF.setOnClickListener(onClickListener);
        this.ayv.setOnClickListener(null);
        uA();
    }

    public void fU(String str) {
        if (str == null) {
            this.ayD.setVisibility(8);
            return;
        }
        this.ayD.setVisibility(0);
        this.ayD.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.ayE.setText(str);
        }
    }

    public void fV(String str) {
        if (str != null) {
            this.ayF.setText(str);
        }
    }

    public void eV(int i) {
        ViewGroup.LayoutParams layoutParams = this.ayC.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ayC.setLayoutParams(marginLayoutParams);
        }
    }

    public void Fh() {
        this.ayF.setVisibility(0);
        this.ayE.setVisibility(0);
        at.b(this.ayD, t.d.cp_cont_d, 1);
    }

    public void Fi() {
        this.ayF.setVisibility(8);
        this.ayE.setVisibility(8);
        at.b(this.ayD, t.d.cp_cont_b, 1);
    }

    public void uA() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        at.c(this.ayC, t.f.net_refresh_emotion);
        at.a(this.ayD, t.d.cp_cont_d, 1, skinType);
        at.a(this.ayE, t.d.cp_cont_b, 1, skinType);
        at.a(this.ayF, t.d.cp_cont_g, 1, skinType);
        at.c(this.ayF, t.f.btn_appdownload, skinType);
        at.l(this.ayv, t.d.cp_bg_line_d);
    }

    public View Fg() {
        return this.ayv;
    }
}
