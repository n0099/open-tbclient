package com.baidu.tbadk.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aHq;
    protected TextView aHr;
    protected TextView aHs;
    protected TextView aHt;

    public TextView tk() {
        return this.aHs;
    }

    public TextView EV() {
        return this.aHt;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.aHq = (TbImageView) this.aHi.findViewById(d.g.net_refresh_image);
        this.aHr = (TextView) this.aHi.findViewById(d.g.net_refresh_desc);
        this.aHs = (TextView) this.aHi.findViewById(d.g.net_refresh_title);
        this.aHt = (TextView) this.aHi.findViewById(d.g.net_refresh_button);
        this.aHt.setOnClickListener(onClickListener);
        this.aHi.setOnClickListener(null);
    }

    public void gB(String str) {
        if (str == null) {
            this.aHr.setVisibility(8);
            return;
        }
        this.aHr.setVisibility(0);
        this.aHr.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aHs.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aHt.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EP() {
        super.EP();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EQ() {
        super.EQ();
        this.aHq.setImageResource(0);
    }

    public void fi(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHq.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHq.setLayoutParams(marginLayoutParams);
        }
    }

    public void EW() {
        this.aHt.setVisibility(0);
        this.aHs.setVisibility(0);
        aj.c(this.aHr, d.C0096d.cp_cont_d, 1);
    }

    public void EX() {
        this.aHt.setVisibility(8);
        this.aHs.setVisibility(8);
        aj.c(this.aHr, d.C0096d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EO()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aHq, d.f.net_refresh_emotion);
            aj.b(this.aHr, d.C0096d.cp_cont_d, 1, skinType);
            aj.b(this.aHs, d.C0096d.cp_cont_b, 1, skinType);
            aj.b(this.aHt, d.C0096d.cp_cont_g, 1, skinType);
            aj.d(this.aHt, d.f.btn_appdownload, skinType);
            aj.k(this.aHi, d.C0096d.cp_bg_line_d);
        }
    }

    public View EU() {
        return this.aHi;
    }
}
