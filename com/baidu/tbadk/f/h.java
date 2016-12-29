package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView azh;
    protected TextView azi;
    protected TextView azj;
    protected TextView azk;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(r.h.net_refresh_view_layout, (ViewGroup) null));
        this.azh = (TbImageView) this.aza.findViewById(r.g.net_refresh_image);
        this.azi = (TextView) this.aza.findViewById(r.g.net_refresh_desc);
        this.azj = (TextView) this.aza.findViewById(r.g.net_refresh_title);
        this.azk = (TextView) this.aza.findViewById(r.g.net_refresh_button);
        this.azk.setOnClickListener(onClickListener);
        this.aza.setOnClickListener(null);
    }

    public void gb(String str) {
        if (str == null) {
            this.azi.setVisibility(8);
            return;
        }
        this.azi.setVisibility(0);
        this.azi.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.azj.setText(str);
        }
    }

    public void gc(String str) {
        if (str != null) {
            this.azk.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ei() {
        super.Ei();
        tm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ej() {
        super.Ej();
        this.azh.setImageResource(0);
    }

    public void eW(int i) {
        ViewGroup.LayoutParams layoutParams = this.azh.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.azh.setLayoutParams(marginLayoutParams);
        }
    }

    public void Eo() {
        this.azk.setVisibility(0);
        this.azj.setVisibility(0);
        ar.c(this.azi, r.d.cp_cont_d, 1);
    }

    public void Ep() {
        this.azk.setVisibility(8);
        this.azj.setVisibility(8);
        ar.c(this.azi, r.d.cp_cont_b, 1);
    }

    public void tm() {
        if (Eh()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            ar.c(this.azh, r.f.net_refresh_emotion);
            ar.b(this.azi, r.d.cp_cont_d, 1, skinType);
            ar.b(this.azj, r.d.cp_cont_b, 1, skinType);
            ar.b(this.azk, r.d.cp_cont_g, 1, skinType);
            ar.d(this.azk, r.f.btn_appdownload, skinType);
            ar.l(this.aza, r.d.cp_bg_line_d);
        }
    }

    public View En() {
        return this.aza;
    }
}
