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
    protected TbImageView awi;
    protected TextView awj;
    protected TextView awk;
    protected TextView awl;

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(u.h.net_refresh_view_layout, (ViewGroup) null));
        this.awi = (TbImageView) this.awb.findViewById(u.g.net_refresh_image);
        this.awj = (TextView) this.awb.findViewById(u.g.net_refresh_desc);
        this.awk = (TextView) this.awb.findViewById(u.g.net_refresh_title);
        this.awl = (TextView) this.awb.findViewById(u.g.net_refresh_button);
        this.awl.setOnClickListener(onClickListener);
        this.awb.setOnClickListener(null);
    }

    public void fV(String str) {
        if (str == null) {
            this.awj.setVisibility(8);
            return;
        }
        this.awj.setVisibility(0);
        this.awj.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.awk.setText(str);
        }
    }

    public void fW(String str) {
        if (str != null) {
            this.awl.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Db() {
        super.Db();
        sd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.g.a
    public void Dc() {
        super.Dc();
        this.awi.setImageResource(0);
    }

    public void eF(int i) {
        ViewGroup.LayoutParams layoutParams = this.awi.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.awi.setLayoutParams(marginLayoutParams);
        }
    }

    public void Dh() {
        this.awl.setVisibility(0);
        this.awk.setVisibility(0);
        av.c(this.awj, u.d.cp_cont_d, 1);
    }

    public void Di() {
        this.awl.setVisibility(8);
        this.awk.setVisibility(8);
        av.c(this.awj, u.d.cp_cont_b, 1);
    }

    public void sd() {
        if (Da()) {
            int skinType = TbadkCoreApplication.m10getInst().getSkinType();
            av.c(this.awi, u.f.net_refresh_emotion);
            av.b(this.awj, u.d.cp_cont_d, 1, skinType);
            av.b(this.awk, u.d.cp_cont_b, 1, skinType);
            av.b(this.awl, u.d.cp_cont_g, 1, skinType);
            av.d(this.awl, u.f.btn_appdownload, skinType);
            av.l(this.awb, u.d.cp_bg_line_d);
        }
    }

    public View Dg() {
        return this.awb;
    }
}
