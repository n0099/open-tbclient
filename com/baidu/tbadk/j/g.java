package com.baidu.tbadk.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aHW;
    protected TextView aHX;
    protected TextView aHY;
    protected TextView aHZ;
    private LinearLayout aIa;

    public TextView getTitleView() {
        return this.aHY;
    }

    public TextView Fr() {
        return this.aHZ;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.i.net_refresh_view_layout, (ViewGroup) null));
        this.aHW = (TbImageView) this.aHO.findViewById(d.g.net_refresh_image);
        this.aHX = (TextView) this.aHO.findViewById(d.g.net_refresh_desc);
        this.aHY = (TextView) this.aHO.findViewById(d.g.net_refresh_title);
        this.aIa = (LinearLayout) this.aHO.findViewById(d.g.net_refresh_info_layout);
        this.aHZ = (TextView) this.aHO.findViewById(d.g.net_refresh_button);
        this.aHZ.setOnClickListener(onClickListener);
        this.aHO.setOnClickListener(null);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.aHX.setVisibility(8);
            return;
        }
        this.aHX.setVisibility(0);
        this.aHX.setText(str);
    }

    public void fa(int i) {
        ((LinearLayout.LayoutParams) this.aIa.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aHY.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aHZ.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fl() {
        super.Fl();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fm() {
        super.Fm();
        this.aHW.setImageResource(0);
    }

    public void fb(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHW.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHW.setLayoutParams(marginLayoutParams);
        }
    }

    public void Fs() {
        this.aHZ.setVisibility(0);
        this.aHY.setVisibility(0);
        ak.c(this.aHX, d.C0126d.cp_cont_d, 1);
    }

    public void Ft() {
        this.aHZ.setVisibility(8);
        this.aHY.setVisibility(8);
        ak.c(this.aHX, d.C0126d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ak.c(this.aHW, d.f.net_refresh_emotion);
        ak.b(this.aHX, d.C0126d.cp_cont_d, 1, skinType);
        ak.b(this.aHY, d.C0126d.cp_cont_b, 1, skinType);
        ak.b(this.aHZ, d.C0126d.cp_cont_g, 1, skinType);
        ak.d(this.aHZ, d.f.btn_appdownload, skinType);
        ak.j(this.aHO, d.C0126d.cp_bg_line_d);
    }

    public View Fq() {
        return this.aHO;
    }
}
