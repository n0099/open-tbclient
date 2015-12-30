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
    private TbImageView axe;
    private TextView axf;
    private TextView axg;
    private TextView axh;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(n.h.net_refresh_view_layout, (ViewGroup) null));
        this.axe = (TbImageView) this.awX.findViewById(n.g.net_refresh_image);
        this.axf = (TextView) this.awX.findViewById(n.g.net_refresh_desc);
        this.axg = (TextView) this.awX.findViewById(n.g.net_refresh_title);
        this.axh = (TextView) this.awX.findViewById(n.g.net_refresh_button);
        this.axh.setOnClickListener(onClickListener);
        this.awX.setOnClickListener(null);
        tr();
    }

    public void fP(String str) {
        this.axf.setText(str);
    }

    public void ev(int i) {
        ViewGroup.LayoutParams layoutParams = this.axe.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.axe.setLayoutParams(marginLayoutParams);
        }
    }

    public void Dc() {
        this.axh.setVisibility(0);
        this.axg.setVisibility(0);
        as.b(this.axf, n.d.cp_cont_d, 1);
    }

    public void Dd() {
        this.axh.setVisibility(8);
        this.axg.setVisibility(8);
        as.b(this.axf, n.d.cp_cont_b, 1);
    }

    public void tr() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        as.c(this.axe, n.f.net_refresh_emotion);
        as.a(this.axf, n.d.cp_cont_d, 1, skinType);
        as.a(this.axg, n.d.cp_cont_b, 1, skinType);
        as.a(this.axh, n.d.cp_cont_g, 1, skinType);
        as.c(this.axh, n.f.btn_appdownload, skinType);
        as.j(this.awX, n.d.cp_bg_line_d);
    }
}
