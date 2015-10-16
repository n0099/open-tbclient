package com.baidu.tbadk.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends a {
    private TbImageView auI;
    private TextView auJ;
    private TextView auK;
    private TextView auL;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(i.g.net_refresh_view_layout, (ViewGroup) null));
        this.auI = (TbImageView) this.auB.findViewById(i.f.net_refresh_image);
        this.auJ = (TextView) this.auB.findViewById(i.f.net_refresh_desc);
        this.auK = (TextView) this.auB.findViewById(i.f.net_refresh_title);
        this.auL = (TextView) this.auB.findViewById(i.f.net_refresh_button);
        this.auL.setOnClickListener(onClickListener);
        this.auB.setOnClickListener(null);
        tc();
    }

    public void fv(String str) {
        this.auJ.setText(str);
    }

    public void ep(int i) {
        ViewGroup.LayoutParams layoutParams = this.auI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.auI.setLayoutParams(marginLayoutParams);
        }
    }

    public void Cw() {
        this.auL.setVisibility(0);
        this.auK.setVisibility(0);
        an.b(this.auJ, i.c.cp_cont_d, 1);
    }

    public void Cx() {
        this.auL.setVisibility(8);
        this.auK.setVisibility(8);
        an.b(this.auJ, i.c.cp_cont_b, 1);
    }

    public void tc() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        an.c(this.auI, i.e.net_refresh_emotion);
        an.a(this.auJ, i.c.cp_cont_d, 1, skinType);
        an.a(this.auK, i.c.cp_cont_b, 1, skinType);
        an.a(this.auL, i.c.cp_cont_g, 1, skinType);
        an.c(this.auL, i.e.btn_appdownload, skinType);
        an.j(this.auB, i.c.cp_bg_line_d);
    }
}
