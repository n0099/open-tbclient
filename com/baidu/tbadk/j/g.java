package com.baidu.tbadk.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    protected TextView bvA;
    protected TextView bvB;
    private LinearLayout bvC;
    protected TbImageView bvy;
    protected TextView bvz;

    public TextView getTitleView() {
        return this.bvA;
    }

    public TextView Mk() {
        return this.bvB;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.bvy = (TbImageView) this.bvq.findViewById(d.g.net_refresh_image);
        this.bvz = (TextView) this.bvq.findViewById(d.g.net_refresh_desc);
        this.bvA = (TextView) this.bvq.findViewById(d.g.net_refresh_title);
        this.bvC = (LinearLayout) this.bvq.findViewById(d.g.net_refresh_info_layout);
        this.bvB = (TextView) this.bvq.findViewById(d.g.net_refresh_button);
        this.bvB.setOnClickListener(onClickListener);
        this.bvq.setOnClickListener(null);
    }

    public void gM(String str) {
        if (str == null) {
            this.bvz.setVisibility(8);
            return;
        }
        this.bvz.setVisibility(0);
        this.bvz.setText(str);
    }

    public void ic(int i) {
        ((LinearLayout.LayoutParams) this.bvC.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bvA.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bvB.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Me() {
        super.Me();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mf() {
        super.Mf();
        this.bvy.setImageResource(0);
    }

    public void id(int i) {
        ViewGroup.LayoutParams layoutParams = this.bvy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bvy.setLayoutParams(marginLayoutParams);
        }
    }

    public void Ml() {
        this.bvB.setVisibility(0);
        this.bvA.setVisibility(0);
        aj.e(this.bvz, d.C0108d.cp_cont_d, 1);
    }

    public void Mm() {
        this.bvB.setVisibility(8);
        this.bvA.setVisibility(8);
        aj.e(this.bvz, d.C0108d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.c(this.bvy, d.f.net_refresh_emotion);
        aj.b(this.bvz, d.C0108d.cp_cont_d, 1, skinType);
        aj.b(this.bvA, d.C0108d.cp_cont_b, 1, skinType);
        aj.b(this.bvB, d.C0108d.cp_cont_g, 1, skinType);
        aj.f(this.bvB, d.f.btn_appdownload, skinType);
        aj.t(this.bvq, d.C0108d.cp_bg_line_d);
    }

    public View Mj() {
        return this.bvq;
    }
}
