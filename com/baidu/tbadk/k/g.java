package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aHn;
    protected TextView aHo;
    protected TextView aHp;
    protected TextView aHq;

    public TextView ER() {
        return this.aHp;
    }

    public TextView ES() {
        return this.aHq;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aHn = (TbImageView) this.aHg.findViewById(d.h.net_refresh_image);
        this.aHo = (TextView) this.aHg.findViewById(d.h.net_refresh_desc);
        this.aHp = (TextView) this.aHg.findViewById(d.h.net_refresh_title);
        this.aHq = (TextView) this.aHg.findViewById(d.h.net_refresh_button);
        this.aHq.setOnClickListener(onClickListener);
        this.aHg.setOnClickListener(null);
    }

    public void gv(String str) {
        if (str == null) {
            this.aHo.setVisibility(8);
            return;
        }
        this.aHo.setVisibility(0);
        this.aHo.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aHp.setText(str);
        }
    }

    public void gw(String str) {
        if (str != null) {
            this.aHq.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EL() {
        super.EL();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EM() {
        super.EM();
        this.aHn.setImageResource(0);
    }

    public void eZ(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHn.setLayoutParams(marginLayoutParams);
        }
    }

    public void ET() {
        this.aHq.setVisibility(0);
        this.aHp.setVisibility(0);
        ai.c(this.aHo, d.e.cp_cont_d, 1);
    }

    public void EU() {
        this.aHq.setVisibility(8);
        this.aHp.setVisibility(8);
        ai.c(this.aHo, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EK()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ai.c(this.aHn, d.g.net_refresh_emotion);
            ai.b(this.aHo, d.e.cp_cont_d, 1, skinType);
            ai.b(this.aHp, d.e.cp_cont_b, 1, skinType);
            ai.b(this.aHq, d.e.cp_cont_g, 1, skinType);
            ai.d(this.aHq, d.g.btn_appdownload, skinType);
            ai.k(this.aHg, d.e.cp_bg_line_d);
        }
    }

    public View EQ() {
        return this.aHg;
    }
}
