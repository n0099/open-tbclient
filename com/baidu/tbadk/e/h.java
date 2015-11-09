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
    private TbImageView atw;
    private TextView atx;
    private TextView aty;
    private TextView atz;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(i.g.net_refresh_view_layout, (ViewGroup) null));
        this.atw = (TbImageView) this.atp.findViewById(i.f.net_refresh_image);
        this.atx = (TextView) this.atp.findViewById(i.f.net_refresh_desc);
        this.aty = (TextView) this.atp.findViewById(i.f.net_refresh_title);
        this.atz = (TextView) this.atp.findViewById(i.f.net_refresh_button);
        this.atz.setOnClickListener(onClickListener);
        this.atp.setOnClickListener(null);
        tc();
    }

    public void fx(String str) {
        this.atx.setText(str);
    }

    public void en(int i) {
        ViewGroup.LayoutParams layoutParams = this.atw.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.atw.setLayoutParams(marginLayoutParams);
        }
    }

    public void Cm() {
        this.atz.setVisibility(0);
        this.aty.setVisibility(0);
        an.b(this.atx, i.c.cp_cont_d, 1);
    }

    public void Cn() {
        this.atz.setVisibility(8);
        this.aty.setVisibility(8);
        an.b(this.atx, i.c.cp_cont_b, 1);
    }

    public void tc() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        an.c(this.atw, i.e.net_refresh_emotion);
        an.a(this.atx, i.c.cp_cont_d, 1, skinType);
        an.a(this.aty, i.c.cp_cont_b, 1, skinType);
        an.a(this.atz, i.c.cp_cont_g, 1, skinType);
        an.c(this.atz, i.e.btn_appdownload, skinType);
        an.j(this.atp, i.c.cp_bg_line_d);
    }
}
