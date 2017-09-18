package com.baidu.tbadk.k;

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
    protected TbImageView aGE;
    protected TextView aGF;
    protected TextView aGG;
    protected TextView aGH;

    public TextView EP() {
        return this.aGG;
    }

    public TextView EQ() {
        return this.aGH;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aGE = (TbImageView) this.aGw.findViewById(d.h.net_refresh_image);
        this.aGF = (TextView) this.aGw.findViewById(d.h.net_refresh_desc);
        this.aGG = (TextView) this.aGw.findViewById(d.h.net_refresh_title);
        this.aGH = (TextView) this.aGw.findViewById(d.h.net_refresh_button);
        this.aGH.setOnClickListener(onClickListener);
        this.aGw.setOnClickListener(null);
    }

    public void gv(String str) {
        if (str == null) {
            this.aGF.setVisibility(8);
            return;
        }
        this.aGF.setVisibility(0);
        this.aGF.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aGG.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aGH.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EJ() {
        super.EJ();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void EK() {
        super.EK();
        this.aGE.setImageResource(0);
    }

    public void eZ(int i) {
        ViewGroup.LayoutParams layoutParams = this.aGE.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aGE.setLayoutParams(marginLayoutParams);
        }
    }

    public void ER() {
        this.aGH.setVisibility(0);
        this.aGG.setVisibility(0);
        aj.c(this.aGF, d.e.cp_cont_d, 1);
    }

    public void ES() {
        this.aGH.setVisibility(8);
        this.aGG.setVisibility(8);
        aj.c(this.aGF, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EI()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aGE, d.g.net_refresh_emotion);
            aj.b(this.aGF, d.e.cp_cont_d, 1, skinType);
            aj.b(this.aGG, d.e.cp_cont_b, 1, skinType);
            aj.b(this.aGH, d.e.cp_cont_g, 1, skinType);
            aj.d(this.aGH, d.g.btn_appdownload, skinType);
            aj.k(this.aGw, d.e.cp_bg_line_d);
        }
    }

    public View EO() {
        return this.aGw;
    }
}
