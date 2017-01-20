package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView ayc;
    protected TextView ayd;
    protected TextView aye;
    protected TextView ayf;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(r.j.net_refresh_view_layout, (ViewGroup) null));
        this.ayc = (TbImageView) this.axV.findViewById(r.h.net_refresh_image);
        this.ayd = (TextView) this.axV.findViewById(r.h.net_refresh_desc);
        this.aye = (TextView) this.axV.findViewById(r.h.net_refresh_title);
        this.ayf = (TextView) this.axV.findViewById(r.h.net_refresh_button);
        this.ayf.setOnClickListener(onClickListener);
        this.axV.setOnClickListener(null);
    }

    public void fY(String str) {
        if (str == null) {
            this.ayd.setVisibility(8);
            return;
        }
        this.ayd.setVisibility(0);
        this.ayd.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aye.setText(str);
        }
    }

    public void fZ(String str) {
        if (str != null) {
            this.ayf.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ed() {
        super.Ed();
        tg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ee() {
        super.Ee();
        this.ayc.setImageResource(0);
    }

    public void eX(int i) {
        ViewGroup.LayoutParams layoutParams = this.ayc.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ayc.setLayoutParams(marginLayoutParams);
        }
    }

    public void Ej() {
        this.ayf.setVisibility(0);
        this.aye.setVisibility(0);
        ap.c(this.ayd, r.e.cp_cont_d, 1);
    }

    public void Ek() {
        this.ayf.setVisibility(8);
        this.aye.setVisibility(8);
        ap.c(this.ayd, r.e.cp_cont_b, 1);
    }

    public void tg() {
        if (Ec()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            ap.c(this.ayc, r.g.net_refresh_emotion);
            ap.b(this.ayd, r.e.cp_cont_d, 1, skinType);
            ap.b(this.aye, r.e.cp_cont_b, 1, skinType);
            ap.b(this.ayf, r.e.cp_cont_g, 1, skinType);
            ap.d(this.ayf, r.g.btn_appdownload, skinType);
            ap.k(this.axV, r.e.cp_bg_line_d);
        }
    }

    public View Ei() {
        return this.axV;
    }
}
