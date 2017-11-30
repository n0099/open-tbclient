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
    protected TbImageView aHm;
    protected TextView aHn;
    protected TextView aHo;
    protected TextView aHp;

    public TextView tn() {
        return this.aHo;
    }

    public TextView EU() {
        return this.aHp;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.h.net_refresh_view_layout, (ViewGroup) null));
        this.aHm = (TbImageView) this.aHe.findViewById(d.g.net_refresh_image);
        this.aHn = (TextView) this.aHe.findViewById(d.g.net_refresh_desc);
        this.aHo = (TextView) this.aHe.findViewById(d.g.net_refresh_title);
        this.aHp = (TextView) this.aHe.findViewById(d.g.net_refresh_button);
        this.aHp.setOnClickListener(onClickListener);
        this.aHe.setOnClickListener(null);
    }

    public void gC(String str) {
        if (str == null) {
            this.aHn.setVisibility(8);
            return;
        }
        this.aHn.setVisibility(0);
        this.aHn.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aHo.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aHp.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EO() {
        super.EO();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void EP() {
        super.EP();
        this.aHm.setImageResource(0);
    }

    public void fi(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHm.setLayoutParams(marginLayoutParams);
        }
    }

    public void EV() {
        this.aHp.setVisibility(0);
        this.aHo.setVisibility(0);
        aj.c(this.aHn, d.C0082d.cp_cont_d, 1);
    }

    public void EW() {
        this.aHp.setVisibility(8);
        this.aHo.setVisibility(8);
        aj.c(this.aHn, d.C0082d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EN()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aHm, d.f.net_refresh_emotion);
            aj.b(this.aHn, d.C0082d.cp_cont_d, 1, skinType);
            aj.b(this.aHo, d.C0082d.cp_cont_b, 1, skinType);
            aj.b(this.aHp, d.C0082d.cp_cont_g, 1, skinType);
            aj.d(this.aHp, d.f.btn_appdownload, skinType);
            aj.k(this.aHe, d.C0082d.cp_bg_line_d);
        }
    }

    public View ET() {
        return this.aHe;
    }
}
