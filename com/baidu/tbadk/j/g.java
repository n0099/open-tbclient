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
    protected TextView bxA;
    protected TextView bxB;
    private LinearLayout bxC;
    protected TbImageView bxy;
    protected TextView bxz;

    public TextView getTitleView() {
        return this.bxA;
    }

    public TextView MQ() {
        return this.bxB;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.bxy = (TbImageView) this.bxq.findViewById(d.g.net_refresh_image);
        this.bxz = (TextView) this.bxq.findViewById(d.g.net_refresh_desc);
        this.bxA = (TextView) this.bxq.findViewById(d.g.net_refresh_title);
        this.bxC = (LinearLayout) this.bxq.findViewById(d.g.net_refresh_info_layout);
        this.bxB = (TextView) this.bxq.findViewById(d.g.net_refresh_button);
        this.bxB.setOnClickListener(onClickListener);
        this.bxq.setOnClickListener(null);
    }

    public void gW(String str) {
        if (str == null) {
            this.bxz.setVisibility(8);
            return;
        }
        this.bxz.setVisibility(0);
        this.bxz.setText(str);
    }

    public void ia(int i) {
        ((LinearLayout.LayoutParams) this.bxC.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bxA.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bxB.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        super.MK();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void ML() {
        super.ML();
        this.bxy.setImageResource(0);
    }

    public void ib(int i) {
        ViewGroup.LayoutParams layoutParams = this.bxy.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bxy.setLayoutParams(marginLayoutParams);
        }
    }

    public void MR() {
        this.bxB.setVisibility(0);
        this.bxA.setVisibility(0);
        aj.e(this.bxz, d.C0141d.cp_cont_d, 1);
    }

    public void MS() {
        this.bxB.setVisibility(8);
        this.bxA.setVisibility(8);
        aj.e(this.bxz, d.C0141d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.c(this.bxy, d.f.net_refresh_emotion);
        aj.b(this.bxz, d.C0141d.cp_cont_d, 1, skinType);
        aj.b(this.bxA, d.C0141d.cp_cont_b, 1, skinType);
        aj.b(this.bxB, d.C0141d.cp_cont_g, 1, skinType);
        aj.f(this.bxB, d.f.btn_appdownload, skinType);
        aj.t(this.bxq, d.C0141d.cp_bg_line_d);
    }

    public View MP() {
        return this.bxq;
    }
}
