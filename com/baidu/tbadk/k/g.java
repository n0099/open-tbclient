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
    protected TbImageView aFX;
    protected TextView aFY;
    protected TextView aFZ;
    protected TextView aGa;

    public TextView EJ() {
        return this.aFZ;
    }

    public TextView EK() {
        return this.aGa;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aFX = (TbImageView) this.aFP.findViewById(d.h.net_refresh_image);
        this.aFY = (TextView) this.aFP.findViewById(d.h.net_refresh_desc);
        this.aFZ = (TextView) this.aFP.findViewById(d.h.net_refresh_title);
        this.aGa = (TextView) this.aFP.findViewById(d.h.net_refresh_button);
        this.aGa.setOnClickListener(onClickListener);
        this.aFP.setOnClickListener(null);
    }

    public void gq(String str) {
        if (str == null) {
            this.aFY.setVisibility(8);
            return;
        }
        this.aFY.setVisibility(0);
        this.aFY.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aFZ.setText(str);
        }
    }

    public void gr(String str) {
        if (str != null) {
            this.aGa.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void ED() {
        super.ED();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EE() {
        super.EE();
        this.aFX.setImageResource(0);
    }

    public void eX(int i) {
        ViewGroup.LayoutParams layoutParams = this.aFX.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aFX.setLayoutParams(marginLayoutParams);
        }
    }

    public void EL() {
        this.aGa.setVisibility(0);
        this.aFZ.setVisibility(0);
        ai.c(this.aFY, d.e.cp_cont_d, 1);
    }

    public void EM() {
        this.aGa.setVisibility(8);
        this.aFZ.setVisibility(8);
        ai.c(this.aFY, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EC()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            ai.c(this.aFX, d.g.net_refresh_emotion);
            ai.b(this.aFY, d.e.cp_cont_d, 1, skinType);
            ai.b(this.aFZ, d.e.cp_cont_b, 1, skinType);
            ai.b(this.aGa, d.e.cp_cont_g, 1, skinType);
            ai.d(this.aGa, d.g.btn_appdownload, skinType);
            ai.k(this.aFP, d.e.cp_bg_line_d);
        }
    }

    public View EI() {
        return this.aFP;
    }
}
