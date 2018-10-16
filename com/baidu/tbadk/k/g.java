package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aZd;
    protected TextView aZe;
    protected TextView aZf;
    protected TextView aZg;
    private LinearLayout aZh;

    public TextView getTitleView() {
        return this.aZf;
    }

    public TextView Mx() {
        return this.aZg;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(e.h.net_refresh_view_layout, (ViewGroup) null));
        this.aZd = (TbImageView) this.aYV.findViewById(e.g.net_refresh_image);
        this.aZe = (TextView) this.aYV.findViewById(e.g.net_refresh_desc);
        this.aZf = (TextView) this.aYV.findViewById(e.g.net_refresh_title);
        this.aZh = (LinearLayout) this.aYV.findViewById(e.g.net_refresh_info_layout);
        this.aZg = (TextView) this.aYV.findViewById(e.g.net_refresh_button);
        this.aZg.setOnClickListener(onClickListener);
        this.aYV.setOnClickListener(null);
    }

    public void hU(String str) {
        if (str == null) {
            this.aZe.setVisibility(8);
            return;
        }
        this.aZe.setVisibility(0);
        this.aZe.setText(str);
    }

    public void fA(int i) {
        ((LinearLayout.LayoutParams) this.aZh.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aZf.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aZg.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Mr() {
        super.Mr();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ms() {
        super.Ms();
        this.aZd.setImageResource(0);
    }

    public void fB(int i) {
        ViewGroup.LayoutParams layoutParams = this.aZd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aZd.setLayoutParams(marginLayoutParams);
        }
    }

    public void My() {
        this.aZg.setVisibility(0);
        this.aZf.setVisibility(0);
        al.c(this.aZe, e.d.cp_cont_d, 1);
    }

    public void Mz() {
        this.aZg.setVisibility(8);
        this.aZf.setVisibility(8);
        al.c(this.aZe, e.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.aZd, e.f.net_refresh_emotion);
        al.b(this.aZe, e.d.cp_cont_d, 1, skinType);
        al.b(this.aZf, e.d.cp_cont_b, 1, skinType);
        al.b(this.aZg, e.d.cp_cont_g, 1, skinType);
        al.d(this.aZg, e.f.btn_appdownload, skinType);
        al.j(this.aYV, e.d.cp_bg_line_d);
    }

    public View Mw() {
        return this.aYV;
    }
}
