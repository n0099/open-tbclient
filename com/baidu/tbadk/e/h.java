package com.baidu.tbadk.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h extends a {
    private TbImageView awi;
    private TextView awj;
    private TextView awk;
    private TextView awl;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(i.g.net_refresh_view_layout, (ViewGroup) null));
        this.awi = (TbImageView) this.awc.findViewById(i.f.net_refresh_image);
        this.awj = (TextView) this.awc.findViewById(i.f.net_refresh_desc);
        this.awk = (TextView) this.awc.findViewById(i.f.net_refresh_title);
        this.awl = (TextView) this.awc.findViewById(i.f.net_refresh_button);
        this.awl.setOnClickListener(onClickListener);
        this.awc.setOnClickListener(null);
        tf();
    }

    public void fq(String str) {
        this.awj.setText(str);
    }

    public void eo(int i) {
        ViewGroup.LayoutParams layoutParams = this.awi.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.awi.setLayoutParams(marginLayoutParams);
        }
    }

    public void CK() {
        this.awl.setVisibility(0);
        this.awk.setVisibility(0);
        al.b(this.awj, i.c.cp_cont_d, 1);
    }

    public void CL() {
        this.awl.setVisibility(8);
        this.awk.setVisibility(8);
        al.b(this.awj, i.c.cp_cont_b, 1);
    }

    public void tf() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        al.c(this.awi, i.e.net_refresh_emotion);
        al.a(this.awj, i.c.cp_cont_d, 1, skinType);
        al.a(this.awk, i.c.cp_cont_b, 1, skinType);
        al.a(this.awl, i.c.cp_cont_g, 1, skinType);
        al.c(this.awl, i.e.btn_appdownload, skinType);
        al.i(this.awc, i.c.cp_bg_line_d);
    }
}
