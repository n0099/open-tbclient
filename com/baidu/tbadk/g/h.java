package com.baidu.tbadk.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView azp;
    protected TextView azq;
    protected TextView azr;
    protected TextView azs;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(t.h.net_refresh_view_layout, (ViewGroup) null));
        this.azp = (TbImageView) this.azi.findViewById(t.g.net_refresh_image);
        this.azq = (TextView) this.azi.findViewById(t.g.net_refresh_desc);
        this.azr = (TextView) this.azi.findViewById(t.g.net_refresh_title);
        this.azs = (TextView) this.azi.findViewById(t.g.net_refresh_button);
        this.azs.setOnClickListener(onClickListener);
        this.azi.setOnClickListener(null);
    }

    public void fY(String str) {
        if (str == null) {
            this.azq.setVisibility(8);
            return;
        }
        this.azq.setVisibility(0);
        this.azq.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.azr.setText(str);
        }
    }

    public void fZ(String str) {
        if (str != null) {
            this.azs.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Ev() {
        super.Ev();
        ti();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Ew() {
        super.Ew();
        this.azp.setImageResource(0);
    }

    public void eT(int i) {
        ViewGroup.LayoutParams layoutParams = this.azp.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.azp.setLayoutParams(marginLayoutParams);
        }
    }

    public void EB() {
        this.azs.setVisibility(0);
        this.azr.setVisibility(0);
        av.c(this.azq, t.d.cp_cont_d, 1);
    }

    public void EC() {
        this.azs.setVisibility(8);
        this.azr.setVisibility(8);
        av.c(this.azq, t.d.cp_cont_b, 1);
    }

    public void ti() {
        if (Eu()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            av.c(this.azp, t.f.net_refresh_emotion);
            av.b(this.azq, t.d.cp_cont_d, 1, skinType);
            av.b(this.azr, t.d.cp_cont_b, 1, skinType);
            av.b(this.azs, t.d.cp_cont_g, 1, skinType);
            av.d(this.azs, t.f.btn_appdownload, skinType);
            av.l(this.azi, t.d.cp_bg_line_d);
        }
    }

    public View EA() {
        return this.azi;
    }
}
