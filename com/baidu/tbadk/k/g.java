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
    protected TbImageView aHm;
    protected TextView aHn;
    protected TextView aHo;
    protected TextView aHp;

    public TextView ER() {
        return this.aHo;
    }

    public TextView ES() {
        return this.aHp;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aHm = (TbImageView) this.aHf.findViewById(d.h.net_refresh_image);
        this.aHn = (TextView) this.aHf.findViewById(d.h.net_refresh_desc);
        this.aHo = (TextView) this.aHf.findViewById(d.h.net_refresh_title);
        this.aHp = (TextView) this.aHf.findViewById(d.h.net_refresh_button);
        this.aHp.setOnClickListener(onClickListener);
        this.aHf.setOnClickListener(null);
    }

    public void gv(String str) {
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

    public void gw(String str) {
        if (str != null) {
            this.aHp.setText(str);
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
        this.aHm.setImageResource(0);
    }

    public void eZ(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHm.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHm.setLayoutParams(marginLayoutParams);
        }
    }

    public void ET() {
        this.aHp.setVisibility(0);
        this.aHo.setVisibility(0);
        ai.c(this.aHn, d.e.cp_cont_d, 1);
    }

    public void EU() {
        this.aHp.setVisibility(8);
        this.aHo.setVisibility(8);
        ai.c(this.aHn, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EK()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ai.c(this.aHm, d.g.net_refresh_emotion);
            ai.b(this.aHn, d.e.cp_cont_d, 1, skinType);
            ai.b(this.aHo, d.e.cp_cont_b, 1, skinType);
            ai.b(this.aHp, d.e.cp_cont_g, 1, skinType);
            ai.d(this.aHp, d.g.btn_appdownload, skinType);
            ai.k(this.aHf, d.e.cp_bg_line_d);
        }
    }

    public View EQ() {
        return this.aHf;
    }
}
