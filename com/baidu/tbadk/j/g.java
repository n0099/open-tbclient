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
    protected TbImageView bxv;
    protected TextView bxw;
    protected TextView bxx;
    protected TextView bxy;
    private LinearLayout bxz;

    public TextView getTitleView() {
        return this.bxx;
    }

    public TextView MP() {
        return this.bxy;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.bxv = (TbImageView) this.bxn.findViewById(d.g.net_refresh_image);
        this.bxw = (TextView) this.bxn.findViewById(d.g.net_refresh_desc);
        this.bxx = (TextView) this.bxn.findViewById(d.g.net_refresh_title);
        this.bxz = (LinearLayout) this.bxn.findViewById(d.g.net_refresh_info_layout);
        this.bxy = (TextView) this.bxn.findViewById(d.g.net_refresh_button);
        this.bxy.setOnClickListener(onClickListener);
        this.bxn.setOnClickListener(null);
    }

    public void gW(String str) {
        if (str == null) {
            this.bxw.setVisibility(8);
            return;
        }
        this.bxw.setVisibility(0);
        this.bxw.setText(str);
    }

    public void ia(int i) {
        ((LinearLayout.LayoutParams) this.bxz.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bxx.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bxy.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MJ() {
        super.MJ();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void MK() {
        super.MK();
        this.bxv.setImageResource(0);
    }

    public void ib(int i) {
        ViewGroup.LayoutParams layoutParams = this.bxv.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bxv.setLayoutParams(marginLayoutParams);
        }
    }

    public void MQ() {
        this.bxy.setVisibility(0);
        this.bxx.setVisibility(0);
        aj.e(this.bxw, d.C0141d.cp_cont_d, 1);
    }

    public void MR() {
        this.bxy.setVisibility(8);
        this.bxx.setVisibility(8);
        aj.e(this.bxw, d.C0141d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.c(this.bxv, d.f.net_refresh_emotion);
        aj.b(this.bxw, d.C0141d.cp_cont_d, 1, skinType);
        aj.b(this.bxx, d.C0141d.cp_cont_b, 1, skinType);
        aj.b(this.bxy, d.C0141d.cp_cont_g, 1, skinType);
        aj.f(this.bxy, d.f.btn_appdownload, skinType);
        aj.t(this.bxn, d.C0141d.cp_bg_line_d);
    }

    public View MO() {
        return this.bxn;
    }
}
