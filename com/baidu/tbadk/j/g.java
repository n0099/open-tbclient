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
    protected TbImageView bvg;
    protected TextView bvh;
    protected TextView bvi;
    protected TextView bvj;
    private LinearLayout bvk;

    public TextView getTitleView() {
        return this.bvi;
    }

    public TextView Mu() {
        return this.bvj;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.bvg = (TbImageView) this.buY.findViewById(d.g.net_refresh_image);
        this.bvh = (TextView) this.buY.findViewById(d.g.net_refresh_desc);
        this.bvi = (TextView) this.buY.findViewById(d.g.net_refresh_title);
        this.bvk = (LinearLayout) this.buY.findViewById(d.g.net_refresh_info_layout);
        this.bvj = (TextView) this.buY.findViewById(d.g.net_refresh_button);
        this.bvj.setOnClickListener(onClickListener);
        this.buY.setOnClickListener(null);
    }

    public void gE(String str) {
        if (str == null) {
            this.bvh.setVisibility(8);
            return;
        }
        this.bvh.setVisibility(0);
        this.bvh.setText(str);
    }

    public void ig(int i) {
        ((LinearLayout.LayoutParams) this.bvk.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bvi.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bvj.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mo() {
        super.Mo();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mp() {
        super.Mp();
        this.bvg.setImageResource(0);
    }

    public void ih(int i) {
        ViewGroup.LayoutParams layoutParams = this.bvg.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bvg.setLayoutParams(marginLayoutParams);
        }
    }

    public void Mv() {
        this.bvj.setVisibility(0);
        this.bvi.setVisibility(0);
        aj.e(this.bvh, d.C0108d.cp_cont_d, 1);
    }

    public void Mw() {
        this.bvj.setVisibility(8);
        this.bvi.setVisibility(8);
        aj.e(this.bvh, d.C0108d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.c(this.bvg, d.f.net_refresh_emotion);
        aj.b(this.bvh, d.C0108d.cp_cont_d, 1, skinType);
        aj.b(this.bvi, d.C0108d.cp_cont_b, 1, skinType);
        aj.b(this.bvj, d.C0108d.cp_cont_g, 1, skinType);
        aj.f(this.bvj, d.f.btn_appdownload, skinType);
        aj.t(this.buY, d.C0108d.cp_bg_line_d);
    }

    public View Mt() {
        return this.buY;
    }
}
