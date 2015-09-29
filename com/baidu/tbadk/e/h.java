package com.baidu.tbadk.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends a {
    private TbImageView auH;
    private TextView auI;
    private TextView auJ;
    private TextView auK;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(i.g.net_refresh_view_layout, (ViewGroup) null));
        this.auH = (TbImageView) this.auA.findViewById(i.f.net_refresh_image);
        this.auI = (TextView) this.auA.findViewById(i.f.net_refresh_desc);
        this.auJ = (TextView) this.auA.findViewById(i.f.net_refresh_title);
        this.auK = (TextView) this.auA.findViewById(i.f.net_refresh_button);
        this.auK.setOnClickListener(onClickListener);
        this.auA.setOnClickListener(null);
        tc();
    }

    public void fv(String str) {
        this.auI.setText(str);
    }

    public void ep(int i) {
        ViewGroup.LayoutParams layoutParams = this.auH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.auH.setLayoutParams(marginLayoutParams);
        }
    }

    public void Cw() {
        this.auK.setVisibility(0);
        this.auJ.setVisibility(0);
        am.b(this.auI, i.c.cp_cont_d, 1);
    }

    public void Cx() {
        this.auK.setVisibility(8);
        this.auJ.setVisibility(8);
        am.b(this.auI, i.c.cp_cont_b, 1);
    }

    public void tc() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        am.c(this.auH, i.e.net_refresh_emotion);
        am.a(this.auI, i.c.cp_cont_d, 1, skinType);
        am.a(this.auJ, i.c.cp_cont_b, 1, skinType);
        am.a(this.auK, i.c.cp_cont_g, 1, skinType);
        am.c(this.auK, i.e.btn_appdownload, skinType);
        am.j(this.auA, i.c.cp_bg_line_d);
    }
}
