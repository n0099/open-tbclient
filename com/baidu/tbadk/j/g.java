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
    protected TbImageView bxI;
    protected TextView bxJ;
    protected TextView bxK;
    protected TextView bxL;
    private LinearLayout bxM;

    public TextView getTitleView() {
        return this.bxK;
    }

    public TextView MQ() {
        return this.bxL;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.bxI = (TbImageView) this.bxA.findViewById(d.g.net_refresh_image);
        this.bxJ = (TextView) this.bxA.findViewById(d.g.net_refresh_desc);
        this.bxK = (TextView) this.bxA.findViewById(d.g.net_refresh_title);
        this.bxM = (LinearLayout) this.bxA.findViewById(d.g.net_refresh_info_layout);
        this.bxL = (TextView) this.bxA.findViewById(d.g.net_refresh_button);
        this.bxL.setOnClickListener(onClickListener);
        this.bxA.setOnClickListener(null);
    }

    public void gW(String str) {
        if (str == null) {
            this.bxJ.setVisibility(8);
            return;
        }
        this.bxJ.setVisibility(0);
        this.bxJ.setText(str);
    }

    public void ia(int i) {
        ((LinearLayout.LayoutParams) this.bxM.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bxK.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bxL.setText(str);
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
        this.bxI.setImageResource(0);
    }

    public void ib(int i) {
        ViewGroup.LayoutParams layoutParams = this.bxI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bxI.setLayoutParams(marginLayoutParams);
        }
    }

    public void MR() {
        this.bxL.setVisibility(0);
        this.bxK.setVisibility(0);
        aj.e(this.bxJ, d.C0140d.cp_cont_d, 1);
    }

    public void MS() {
        this.bxL.setVisibility(8);
        this.bxK.setVisibility(8);
        aj.e(this.bxJ, d.C0140d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.c(this.bxI, d.f.net_refresh_emotion);
        aj.b(this.bxJ, d.C0140d.cp_cont_d, 1, skinType);
        aj.b(this.bxK, d.C0140d.cp_cont_b, 1, skinType);
        aj.b(this.bxL, d.C0140d.cp_cont_g, 1, skinType);
        aj.f(this.bxL, d.f.btn_appdownload, skinType);
        aj.t(this.bxA, d.C0140d.cp_bg_line_d);
    }

    public View MP() {
        return this.bxA;
    }
}
