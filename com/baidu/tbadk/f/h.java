package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView azK;
    protected TextView azL;
    protected TextView azM;
    protected TextView azN;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(r.h.net_refresh_view_layout, (ViewGroup) null));
        this.azK = (TbImageView) this.azD.findViewById(r.g.net_refresh_image);
        this.azL = (TextView) this.azD.findViewById(r.g.net_refresh_desc);
        this.azM = (TextView) this.azD.findViewById(r.g.net_refresh_title);
        this.azN = (TextView) this.azD.findViewById(r.g.net_refresh_button);
        this.azN.setOnClickListener(onClickListener);
        this.azD.setOnClickListener(null);
    }

    public void gf(String str) {
        if (str == null) {
            this.azL.setVisibility(8);
            return;
        }
        this.azL.setVisibility(0);
        this.azL.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.azM.setText(str);
        }
    }

    public void gg(String str) {
        if (str != null) {
            this.azN.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void EA() {
        super.EA();
        tB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void EB() {
        super.EB();
        this.azK.setImageResource(0);
    }

    public void eV(int i) {
        ViewGroup.LayoutParams layoutParams = this.azK.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.azK.setLayoutParams(marginLayoutParams);
        }
    }

    public void EG() {
        this.azN.setVisibility(0);
        this.azM.setVisibility(0);
        at.c(this.azL, r.d.cp_cont_d, 1);
    }

    public void EH() {
        this.azN.setVisibility(8);
        this.azM.setVisibility(8);
        at.c(this.azL, r.d.cp_cont_b, 1);
    }

    public void tB() {
        if (Ez()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            at.c(this.azK, r.f.net_refresh_emotion);
            at.b(this.azL, r.d.cp_cont_d, 1, skinType);
            at.b(this.azM, r.d.cp_cont_b, 1, skinType);
            at.b(this.azN, r.d.cp_cont_g, 1, skinType);
            at.d(this.azN, r.f.btn_appdownload, skinType);
            at.l(this.azD, r.d.cp_bg_line_d);
        }
    }

    public View EF() {
        return this.azD;
    }
}
