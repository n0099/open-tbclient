package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h extends a {
    private TbImageView avA;
    private TextView avB;
    private TextView avC;
    private TextView avD;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(n.g.net_refresh_view_layout, (ViewGroup) null));
        this.avA = (TbImageView) this.avt.findViewById(n.f.net_refresh_image);
        this.avB = (TextView) this.avt.findViewById(n.f.net_refresh_desc);
        this.avC = (TextView) this.avt.findViewById(n.f.net_refresh_title);
        this.avD = (TextView) this.avt.findViewById(n.f.net_refresh_button);
        this.avD.setOnClickListener(onClickListener);
        this.avt.setOnClickListener(null);
        tH();
    }

    public void fL(String str) {
        this.avB.setText(str);
    }

    public void eB(int i) {
        ViewGroup.LayoutParams layoutParams = this.avA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.avA.setLayoutParams(marginLayoutParams);
        }
    }

    public void Dn() {
        this.avD.setVisibility(0);
        this.avC.setVisibility(0);
        as.b(this.avB, n.c.cp_cont_d, 1);
    }

    public void Do() {
        this.avD.setVisibility(8);
        this.avC.setVisibility(8);
        as.b(this.avB, n.c.cp_cont_b, 1);
    }

    public void tH() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        as.c(this.avA, n.e.net_refresh_emotion);
        as.a(this.avB, n.c.cp_cont_d, 1, skinType);
        as.a(this.avC, n.c.cp_cont_b, 1, skinType);
        as.a(this.avD, n.c.cp_cont_g, 1, skinType);
        as.c(this.avD, n.e.btn_appdownload, skinType);
        as.j(this.avt, n.c.cp_bg_line_d);
    }
}
