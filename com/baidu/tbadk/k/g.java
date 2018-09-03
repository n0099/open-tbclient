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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aRm;
    protected TextView aRn;
    protected TextView aRo;
    protected TextView aRp;
    private LinearLayout aRq;

    public TextView getTitleView() {
        return this.aRo;
    }

    public TextView Jj() {
        return this.aRp;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(f.h.net_refresh_view_layout, (ViewGroup) null));
        this.aRm = (TbImageView) this.aRe.findViewById(f.g.net_refresh_image);
        this.aRn = (TextView) this.aRe.findViewById(f.g.net_refresh_desc);
        this.aRo = (TextView) this.aRe.findViewById(f.g.net_refresh_title);
        this.aRq = (LinearLayout) this.aRe.findViewById(f.g.net_refresh_info_layout);
        this.aRp = (TextView) this.aRe.findViewById(f.g.net_refresh_button);
        this.aRp.setOnClickListener(onClickListener);
        this.aRe.setOnClickListener(null);
    }

    public void hk(String str) {
        if (str == null) {
            this.aRn.setVisibility(8);
            return;
        }
        this.aRn.setVisibility(0);
        this.aRn.setText(str);
    }

    public void ff(int i) {
        ((LinearLayout.LayoutParams) this.aRq.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aRo.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aRp.setText(str);
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
        this.aRm.setImageResource(0);
    }

    public void fg(int i) {
        ViewGroup.LayoutParams layoutParams = this.aRm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aRm.setLayoutParams(marginLayoutParams);
        }
    }

    public void Jk() {
        this.aRp.setVisibility(0);
        this.aRo.setVisibility(0);
        am.c(this.aRn, f.d.cp_cont_d, 1);
    }

    public void Jl() {
        this.aRp.setVisibility(8);
        this.aRo.setVisibility(8);
        am.c(this.aRn, f.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.c(this.aRm, f.C0146f.net_refresh_emotion);
        am.b(this.aRn, f.d.cp_cont_d, 1, skinType);
        am.b(this.aRo, f.d.cp_cont_b, 1, skinType);
        am.b(this.aRp, f.d.cp_cont_g, 1, skinType);
        am.d(this.aRp, f.C0146f.btn_appdownload, skinType);
        am.j(this.aRe, f.d.cp_bg_line_d);
    }

    public View Ji() {
        return this.aRe;
    }
}
