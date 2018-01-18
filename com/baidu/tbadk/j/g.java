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
    protected TbImageView bvp;
    protected TextView bvq;
    protected TextView bvr;
    protected TextView bvs;
    private LinearLayout bvt;

    public TextView getTitleView() {
        return this.bvr;
    }

    public TextView Mi() {
        return this.bvs;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.bvp = (TbImageView) this.bvh.findViewById(d.g.net_refresh_image);
        this.bvq = (TextView) this.bvh.findViewById(d.g.net_refresh_desc);
        this.bvr = (TextView) this.bvh.findViewById(d.g.net_refresh_title);
        this.bvt = (LinearLayout) this.bvh.findViewById(d.g.net_refresh_info_layout);
        this.bvs = (TextView) this.bvh.findViewById(d.g.net_refresh_button);
        this.bvs.setOnClickListener(onClickListener);
        this.bvh.setOnClickListener(null);
    }

    public void gF(String str) {
        if (str == null) {
            this.bvq.setVisibility(8);
            return;
        }
        this.bvq.setVisibility(0);
        this.bvq.setText(str);
    }

    public void ic(int i) {
        ((LinearLayout.LayoutParams) this.bvt.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bvr.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bvs.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Mc() {
        super.Mc();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Md() {
        super.Md();
        this.bvp.setImageResource(0);
    }

    public void id(int i) {
        ViewGroup.LayoutParams layoutParams = this.bvp.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bvp.setLayoutParams(marginLayoutParams);
        }
    }

    public void Mj() {
        this.bvs.setVisibility(0);
        this.bvr.setVisibility(0);
        aj.e(this.bvq, d.C0107d.cp_cont_d, 1);
    }

    public void Mk() {
        this.bvs.setVisibility(8);
        this.bvr.setVisibility(8);
        aj.e(this.bvq, d.C0107d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.c(this.bvp, d.f.net_refresh_emotion);
        aj.b(this.bvq, d.C0107d.cp_cont_d, 1, skinType);
        aj.b(this.bvr, d.C0107d.cp_cont_b, 1, skinType);
        aj.b(this.bvs, d.C0107d.cp_cont_g, 1, skinType);
        aj.f(this.bvs, d.f.btn_appdownload, skinType);
        aj.t(this.bvh, d.C0107d.cp_bg_line_d);
    }

    public View Mh() {
        return this.bvh;
    }
}
