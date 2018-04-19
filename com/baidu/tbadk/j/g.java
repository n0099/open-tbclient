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
    protected TbImageView aHV;
    protected TextView aHW;
    protected TextView aHX;
    protected TextView aHY;
    private LinearLayout aHZ;

    public TextView getTitleView() {
        return this.aHX;
    }

    public TextView Ft() {
        return this.aHY;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.i.net_refresh_view_layout, (ViewGroup) null));
        this.aHV = (TbImageView) this.aHN.findViewById(d.g.net_refresh_image);
        this.aHW = (TextView) this.aHN.findViewById(d.g.net_refresh_desc);
        this.aHX = (TextView) this.aHN.findViewById(d.g.net_refresh_title);
        this.aHZ = (LinearLayout) this.aHN.findViewById(d.g.net_refresh_info_layout);
        this.aHY = (TextView) this.aHN.findViewById(d.g.net_refresh_button);
        this.aHY.setOnClickListener(onClickListener);
        this.aHN.setOnClickListener(null);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.aHW.setVisibility(8);
            return;
        }
        this.aHW.setVisibility(0);
        this.aHW.setText(str);
    }

    public void eZ(int i) {
        ((LinearLayout.LayoutParams) this.aHZ.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aHX.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aHY.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fn() {
        super.Fn();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void Fo() {
        super.Fo();
        this.aHV.setImageResource(0);
    }

    public void fa(int i) {
        ViewGroup.LayoutParams layoutParams = this.aHV.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aHV.setLayoutParams(marginLayoutParams);
        }
    }

    public void Fu() {
        this.aHY.setVisibility(0);
        this.aHX.setVisibility(0);
        ak.c(this.aHW, d.C0126d.cp_cont_d, 1);
    }

    public void Fv() {
        this.aHY.setVisibility(8);
        this.aHX.setVisibility(8);
        ak.c(this.aHW, d.C0126d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ak.c(this.aHV, d.f.net_refresh_emotion);
        ak.b(this.aHW, d.C0126d.cp_cont_d, 1, skinType);
        ak.b(this.aHX, d.C0126d.cp_cont_b, 1, skinType);
        ak.b(this.aHY, d.C0126d.cp_cont_g, 1, skinType);
        ak.d(this.aHY, d.f.btn_appdownload, skinType);
        ak.j(this.aHN, d.C0126d.cp_bg_line_d);
    }

    public View Fs() {
        return this.aHN;
    }
}
