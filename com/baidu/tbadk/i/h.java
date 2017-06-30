package com.baidu.tbadk.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView aEP;
    protected TextView aEQ;
    protected TextView aER;
    protected TextView aES;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(w.j.net_refresh_view_layout, (ViewGroup) null));
        this.aEP = (TbImageView) this.aEH.findViewById(w.h.net_refresh_image);
        this.aEQ = (TextView) this.aEH.findViewById(w.h.net_refresh_desc);
        this.aER = (TextView) this.aEH.findViewById(w.h.net_refresh_title);
        this.aES = (TextView) this.aEH.findViewById(w.h.net_refresh_button);
        this.aES.setOnClickListener(onClickListener);
        this.aEH.setOnClickListener(null);
    }

    public void gk(String str) {
        if (str == null) {
            this.aEQ.setVisibility(8);
            return;
        }
        this.aEQ.setVisibility(0);
        this.aEQ.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aER.setText(str);
        }
    }

    public void gl(String str) {
        if (str != null) {
            this.aES.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void Ep() {
        super.Ep();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void Eq() {
        super.Eq();
        this.aEP.setImageResource(0);
    }

    public void eU(int i) {
        ViewGroup.LayoutParams layoutParams = this.aEP.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aEP.setLayoutParams(marginLayoutParams);
        }
    }

    public void Ev() {
        this.aES.setVisibility(0);
        this.aER.setVisibility(0);
        as.c(this.aEQ, w.e.cp_cont_d, 1);
    }

    public void Ew() {
        this.aES.setVisibility(8);
        this.aER.setVisibility(8);
        as.c(this.aEQ, w.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (Eo()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            as.c(this.aEP, w.g.net_refresh_emotion);
            as.b(this.aEQ, w.e.cp_cont_d, 1, skinType);
            as.b(this.aER, w.e.cp_cont_b, 1, skinType);
            as.b(this.aES, w.e.cp_cont_g, 1, skinType);
            as.d(this.aES, w.g.btn_appdownload, skinType);
            as.k(this.aEH, w.e.cp_bg_line_d);
        }
    }

    public View Eu() {
        return this.aEH;
    }
}
