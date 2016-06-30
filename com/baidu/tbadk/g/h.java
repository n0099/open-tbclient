package com.baidu.tbadk.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView avt;
    protected TextView avu;
    protected TextView avv;
    protected TextView avw;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(u.h.net_refresh_view_layout, (ViewGroup) null));
        this.avt = (TbImageView) this.avm.findViewById(u.g.net_refresh_image);
        this.avu = (TextView) this.avm.findViewById(u.g.net_refresh_desc);
        this.avv = (TextView) this.avm.findViewById(u.g.net_refresh_title);
        this.avw = (TextView) this.avm.findViewById(u.g.net_refresh_button);
        this.avw.setOnClickListener(onClickListener);
        this.avm.setOnClickListener(null);
    }

    public void fX(String str) {
        if (str == null) {
            this.avu.setVisibility(8);
            return;
        }
        this.avu.setVisibility(0);
        this.avu.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.avv.setText(str);
        }
    }

    public void fY(String str) {
        if (str != null) {
            this.avw.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dc() {
        super.Dc();
        se();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dd() {
        super.Dd();
        this.avt.setImageResource(0);
    }

    public void eF(int i) {
        ViewGroup.LayoutParams layoutParams = this.avt.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.avt.setLayoutParams(marginLayoutParams);
        }
    }

    public void Di() {
        this.avw.setVisibility(0);
        this.avv.setVisibility(0);
        av.c(this.avu, u.d.cp_cont_d, 1);
    }

    public void Dj() {
        this.avw.setVisibility(8);
        this.avv.setVisibility(8);
        av.c(this.avu, u.d.cp_cont_b, 1);
    }

    public void se() {
        if (Db()) {
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            av.c(this.avt, u.f.net_refresh_emotion);
            av.b(this.avu, u.d.cp_cont_d, 1, skinType);
            av.b(this.avv, u.d.cp_cont_b, 1, skinType);
            av.b(this.avw, u.d.cp_cont_g, 1, skinType);
            av.d(this.avw, u.f.btn_appdownload, skinType);
            av.l(this.avm, u.d.cp_bg_line_d);
        }
    }

    public View Dh() {
        return this.avm;
    }
}
