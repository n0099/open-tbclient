package com.baidu.tbadk.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView aDM;
    protected TextView aDN;
    protected TextView aDO;
    protected TextView aDP;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(w.j.net_refresh_view_layout, (ViewGroup) null));
        this.aDM = (TbImageView) this.aDF.findViewById(w.h.net_refresh_image);
        this.aDN = (TextView) this.aDF.findViewById(w.h.net_refresh_desc);
        this.aDO = (TextView) this.aDF.findViewById(w.h.net_refresh_title);
        this.aDP = (TextView) this.aDF.findViewById(w.h.net_refresh_button);
        this.aDP.setOnClickListener(onClickListener);
        this.aDF.setOnClickListener(null);
    }

    public void fT(String str) {
        if (str == null) {
            this.aDN.setVisibility(8);
            return;
        }
        this.aDN.setVisibility(0);
        this.aDN.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aDO.setText(str);
        }
    }

    public void fU(String str) {
        if (str != null) {
            this.aDP.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void EU() {
        super.EU();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void EV() {
        super.EV();
        this.aDM.setImageResource(0);
    }

    public void eV(int i) {
        ViewGroup.LayoutParams layoutParams = this.aDM.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aDM.setLayoutParams(marginLayoutParams);
        }
    }

    public void Fa() {
        this.aDP.setVisibility(0);
        this.aDO.setVisibility(0);
        aq.c(this.aDN, w.e.cp_cont_d, 1);
    }

    public void Fb() {
        this.aDP.setVisibility(8);
        this.aDO.setVisibility(8);
        aq.c(this.aDN, w.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (ET()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            aq.c(this.aDM, w.g.net_refresh_emotion);
            aq.b(this.aDN, w.e.cp_cont_d, 1, skinType);
            aq.b(this.aDO, w.e.cp_cont_b, 1, skinType);
            aq.b(this.aDP, w.e.cp_cont_g, 1, skinType);
            aq.d(this.aDP, w.g.btn_appdownload, skinType);
            aq.k(this.aDF, w.e.cp_bg_line_d);
        }
    }

    public View EZ() {
        return this.aDF;
    }
}
