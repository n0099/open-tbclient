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
    protected TbImageView aGH;
    protected TextView aGI;
    protected TextView aGJ;
    protected TextView aGK;

    public TextView EP() {
        return this.aGJ;
    }

    public TextView EQ() {
        return this.aGK;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aGH = (TbImageView) this.aGz.findViewById(d.h.net_refresh_image);
        this.aGI = (TextView) this.aGz.findViewById(d.h.net_refresh_desc);
        this.aGJ = (TextView) this.aGz.findViewById(d.h.net_refresh_title);
        this.aGK = (TextView) this.aGz.findViewById(d.h.net_refresh_button);
        this.aGK.setOnClickListener(onClickListener);
        this.aGz.setOnClickListener(null);
    }

    public void gv(String str) {
        if (str == null) {
            this.aGI.setVisibility(8);
            return;
        }
        this.aGI.setVisibility(0);
        this.aGI.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aGJ.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aGK.setText(str);
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
        this.aGH.setImageResource(0);
    }

    public void eZ(int i) {
        ViewGroup.LayoutParams layoutParams = this.aGH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aGH.setLayoutParams(marginLayoutParams);
        }
    }

    public void ER() {
        this.aGK.setVisibility(0);
        this.aGJ.setVisibility(0);
        aj.c(this.aGI, d.e.cp_cont_d, 1);
    }

    public void ES() {
        this.aGK.setVisibility(8);
        this.aGJ.setVisibility(8);
        aj.c(this.aGI, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (EI()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aGH, d.g.net_refresh_emotion);
            aj.b(this.aGI, d.e.cp_cont_d, 1, skinType);
            aj.b(this.aGJ, d.e.cp_cont_b, 1, skinType);
            aj.b(this.aGK, d.e.cp_cont_g, 1, skinType);
            aj.d(this.aGK, d.g.btn_appdownload, skinType);
            aj.k(this.aGz, d.e.cp_bg_line_d);
        }
    }

    public View EO() {
        return this.aGz;
    }
}
