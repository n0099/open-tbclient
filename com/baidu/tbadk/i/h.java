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
    protected TbImageView aDB;
    protected TextView aDC;
    protected TextView aDD;
    protected TextView aDE;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(w.j.net_refresh_view_layout, (ViewGroup) null));
        this.aDB = (TbImageView) this.aDt.findViewById(w.h.net_refresh_image);
        this.aDC = (TextView) this.aDt.findViewById(w.h.net_refresh_desc);
        this.aDD = (TextView) this.aDt.findViewById(w.h.net_refresh_title);
        this.aDE = (TextView) this.aDt.findViewById(w.h.net_refresh_button);
        this.aDE.setOnClickListener(onClickListener);
        this.aDt.setOnClickListener(null);
    }

    public void fP(String str) {
        if (str == null) {
            this.aDC.setVisibility(8);
            return;
        }
        this.aDC.setVisibility(0);
        this.aDC.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aDD.setText(str);
        }
    }

    public void fQ(String str) {
        if (str != null) {
            this.aDE.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DS() {
        super.DS();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.i.a
    public void DT() {
        super.DT();
        this.aDB.setImageResource(0);
    }

    public void eS(int i) {
        ViewGroup.LayoutParams layoutParams = this.aDB.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aDB.setLayoutParams(marginLayoutParams);
        }
    }

    public void DY() {
        this.aDE.setVisibility(0);
        this.aDD.setVisibility(0);
        aq.c(this.aDC, w.e.cp_cont_d, 1);
    }

    public void DZ() {
        this.aDE.setVisibility(8);
        this.aDD.setVisibility(8);
        aq.c(this.aDC, w.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (DR()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            aq.c(this.aDB, w.g.net_refresh_emotion);
            aq.b(this.aDC, w.e.cp_cont_d, 1, skinType);
            aq.b(this.aDD, w.e.cp_cont_b, 1, skinType);
            aq.b(this.aDE, w.e.cp_cont_g, 1, skinType);
            aq.d(this.aDE, w.g.btn_appdownload, skinType);
            aq.k(this.aDt, w.e.cp_bg_line_d);
        }
    }

    public View DX() {
        return this.aDt;
    }
}
