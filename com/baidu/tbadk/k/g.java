package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aRp;
    protected TextView aRq;
    protected TextView aRr;
    protected TextView aRs;
    private LinearLayout aRt;

    public TextView getTitleView() {
        return this.aRr;
    }

    public TextView Jj() {
        return this.aRs;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.aRp = (TbImageView) this.aRh.findViewById(d.g.net_refresh_image);
        this.aRq = (TextView) this.aRh.findViewById(d.g.net_refresh_desc);
        this.aRr = (TextView) this.aRh.findViewById(d.g.net_refresh_title);
        this.aRt = (LinearLayout) this.aRh.findViewById(d.g.net_refresh_info_layout);
        this.aRs = (TextView) this.aRh.findViewById(d.g.net_refresh_button);
        this.aRs.setOnClickListener(onClickListener);
        this.aRh.setOnClickListener(null);
    }

    public void hk(String str) {
        if (str == null) {
            this.aRq.setVisibility(8);
            return;
        }
        this.aRq.setVisibility(0);
        this.aRq.setText(str);
    }

    public void fg(int i) {
        ((LinearLayout.LayoutParams) this.aRt.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aRr.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aRs.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Jd() {
        super.Jd();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Je() {
        super.Je();
        this.aRp.setImageResource(0);
    }

    public void fh(int i) {
        ViewGroup.LayoutParams layoutParams = this.aRp.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aRp.setLayoutParams(marginLayoutParams);
        }
    }

    public void Jk() {
        this.aRs.setVisibility(0);
        this.aRr.setVisibility(0);
        am.c(this.aRq, d.C0140d.cp_cont_d, 1);
    }

    public void Jl() {
        this.aRs.setVisibility(8);
        this.aRr.setVisibility(8);
        am.c(this.aRq, d.C0140d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.aRp, d.f.net_refresh_emotion);
        am.b(this.aRq, d.C0140d.cp_cont_d, 1, skinType);
        am.b(this.aRr, d.C0140d.cp_cont_b, 1, skinType);
        am.b(this.aRs, d.C0140d.cp_cont_g, 1, skinType);
        am.d(this.aRs, d.f.btn_appdownload, skinType);
        am.j(this.aRh, d.C0140d.cp_bg_line_d);
    }

    public View Ji() {
        return this.aRh;
    }
}
