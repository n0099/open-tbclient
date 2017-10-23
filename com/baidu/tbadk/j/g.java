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
    protected TbImageView aFS;
    protected TextView aFT;
    protected TextView aFU;
    protected TextView aFV;

    public TextView Eo() {
        return this.aFU;
    }

    public TextView Ep() {
        return this.aFV;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.j.net_refresh_view_layout, (ViewGroup) null));
        this.aFS = (TbImageView) this.aFK.findViewById(d.h.net_refresh_image);
        this.aFT = (TextView) this.aFK.findViewById(d.h.net_refresh_desc);
        this.aFU = (TextView) this.aFK.findViewById(d.h.net_refresh_title);
        this.aFV = (TextView) this.aFK.findViewById(d.h.net_refresh_button);
        this.aFV.setOnClickListener(onClickListener);
        this.aFK.setOnClickListener(null);
    }

    public void gq(String str) {
        if (str == null) {
            this.aFT.setVisibility(8);
            return;
        }
        this.aFT.setVisibility(0);
        this.aFT.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aFU.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aFV.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ei() {
        super.Ei();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Ej() {
        super.Ej();
        this.aFS.setImageResource(0);
    }

    public void fj(int i) {
        ViewGroup.LayoutParams layoutParams = this.aFS.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aFS.setLayoutParams(marginLayoutParams);
        }
    }

    public void Eq() {
        this.aFV.setVisibility(0);
        this.aFU.setVisibility(0);
        aj.c(this.aFT, d.e.cp_cont_d, 1);
    }

    public void Er() {
        this.aFV.setVisibility(8);
        this.aFU.setVisibility(8);
        aj.c(this.aFT, d.e.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        if (Eh()) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            aj.c(this.aFS, d.g.net_refresh_emotion);
            aj.b(this.aFT, d.e.cp_cont_d, 1, skinType);
            aj.b(this.aFU, d.e.cp_cont_b, 1, skinType);
            aj.b(this.aFV, d.e.cp_cont_g, 1, skinType);
            aj.d(this.aFV, d.g.btn_appdownload, skinType);
            aj.k(this.aFK, d.e.cp_bg_line_d);
        }
    }

    public View En() {
        return this.aFK;
    }
}
