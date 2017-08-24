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
    protected TbImageView aHo;
    protected TextView aHp;
    protected TextView aHq;
    protected TextView aHr;

    public TextView ER() {
        return this.aHq;
    }

    public TextView ES() {
        return this.aHr;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aHo = (TbImageView) this.aHh.findViewById(d.h.net_refresh_image);
        this.aHp = (TextView) this.aHh.findViewById(d.h.net_refresh_desc);
        this.aHq = (TextView) this.aHh.findViewById(d.h.net_refresh_title);
        this.aHr = (TextView) this.aHh.findViewById(d.h.net_refresh_button);
        this.aHr.setOnClickListener(onClickListener);
        this.aHh.setOnClickListener(null);
    }

    public void gz(String str) {
        if (str == null) {
            this.aHp.setVisibility(8);
            return;
        }
        this.aHp.setVisibility(0);
        this.aHp.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aHq.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aHr.setText(str);
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
        this.aHo.setImageResource(0);
    }

    public void eZ(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHo.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHo.setLayoutParams(marginLayoutParams);
        }
    }

    public void ET() {
        this.aHr.setVisibility(0);
        this.aHq.setVisibility(0);
        ai.c(this.aHp, d.e.cp_cont_d, 1);
    }

    public void EU() {
        this.aHr.setVisibility(8);
        this.aHq.setVisibility(8);
        ai.c(this.aHp, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EK()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ai.c(this.aHo, d.g.net_refresh_emotion);
            ai.b(this.aHp, d.e.cp_cont_d, 1, skinType);
            ai.b(this.aHq, d.e.cp_cont_b, 1, skinType);
            ai.b(this.aHr, d.e.cp_cont_g, 1, skinType);
            ai.d(this.aHr, d.g.btn_appdownload, skinType);
            ai.k(this.aHh, d.e.cp_bg_line_d);
        }
    }

    public View EQ() {
        return this.aHh;
    }
}
