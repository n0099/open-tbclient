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
    protected TbImageView aGf;
    protected TextView aGg;
    protected TextView aGh;
    protected TextView aGi;

    public TextView Eu() {
        return this.aGh;
    }

    public TextView Ev() {
        return this.aGi;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aGf = (TbImageView) this.aFX.findViewById(d.h.net_refresh_image);
        this.aGg = (TextView) this.aFX.findViewById(d.h.net_refresh_desc);
        this.aGh = (TextView) this.aFX.findViewById(d.h.net_refresh_title);
        this.aGi = (TextView) this.aFX.findViewById(d.h.net_refresh_button);
        this.aGi.setOnClickListener(onClickListener);
        this.aFX.setOnClickListener(null);
    }

    public void gr(String str) {
        if (str == null) {
            this.aGg.setVisibility(8);
            return;
        }
        this.aGg.setVisibility(0);
        this.aGg.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aGh.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aGi.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Eo() {
        super.Eo();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ep() {
        super.Ep();
        this.aGf.setImageResource(0);
    }

    public void fk(int i) {
        ViewGroup.LayoutParams layoutParams = this.aGf.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aGf.setLayoutParams(marginLayoutParams);
        }
    }

    public void Ew() {
        this.aGi.setVisibility(0);
        this.aGh.setVisibility(0);
        aj.c(this.aGg, d.e.cp_cont_d, 1);
    }

    public void Ex() {
        this.aGi.setVisibility(8);
        this.aGh.setVisibility(8);
        aj.c(this.aGg, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (En()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aGf, d.g.net_refresh_emotion);
            aj.b(this.aGg, d.e.cp_cont_d, 1, skinType);
            aj.b(this.aGh, d.e.cp_cont_b, 1, skinType);
            aj.b(this.aGi, d.e.cp_cont_g, 1, skinType);
            aj.d(this.aGi, d.g.btn_appdownload, skinType);
            aj.k(this.aFX, d.e.cp_bg_line_d);
        }
    }

    public View Et() {
        return this.aFX;
    }
}
