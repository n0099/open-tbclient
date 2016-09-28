package com.baidu.tbadk.f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView ayS;
    protected TextView ayT;
    protected TextView ayU;
    protected TextView ayV;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(r.h.net_refresh_view_layout, (ViewGroup) null));
        this.ayS = (TbImageView) this.ayL.findViewById(r.g.net_refresh_image);
        this.ayT = (TextView) this.ayL.findViewById(r.g.net_refresh_desc);
        this.ayU = (TextView) this.ayL.findViewById(r.g.net_refresh_title);
        this.ayV = (TextView) this.ayL.findViewById(r.g.net_refresh_button);
        this.ayV.setOnClickListener(onClickListener);
        this.ayL.setOnClickListener(null);
    }

    public void gc(String str) {
        if (str == null) {
            this.ayT.setVisibility(8);
            return;
        }
        this.ayT.setVisibility(0);
        this.ayT.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.ayU.setText(str);
        }
    }

    public void gd(String str) {
        if (str != null) {
            this.ayV.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ev() {
        super.Ev();
        tx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.f.a
    public void Ew() {
        super.Ew();
        this.ayS.setImageResource(0);
    }

    public void eS(int i) {
        ViewGroup.LayoutParams layoutParams = this.ayS.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ayS.setLayoutParams(marginLayoutParams);
        }
    }

    public void EB() {
        this.ayV.setVisibility(0);
        this.ayU.setVisibility(0);
        av.c(this.ayT, r.d.cp_cont_d, 1);
    }

    public void EC() {
        this.ayV.setVisibility(8);
        this.ayU.setVisibility(8);
        av.c(this.ayT, r.d.cp_cont_b, 1);
    }

    public void tx() {
        if (Eu()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            av.c(this.ayS, r.f.net_refresh_emotion);
            av.b(this.ayT, r.d.cp_cont_d, 1, skinType);
            av.b(this.ayU, r.d.cp_cont_b, 1, skinType);
            av.b(this.ayV, r.d.cp_cont_g, 1, skinType);
            av.d(this.ayV, r.f.btn_appdownload, skinType);
            av.l(this.ayL, r.d.cp_bg_line_d);
        }
    }

    public View EA() {
        return this.ayL;
    }
}
