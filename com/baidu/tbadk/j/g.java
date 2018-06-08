package com.baidu.tbadk.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aQt;
    protected TextView aQu;
    protected TextView aQv;
    protected TextView aQw;
    private LinearLayout aQx;

    public TextView getTitleView() {
        return this.aQv;
    }

    public TextView IW() {
        return this.aQw;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(d.i.net_refresh_view_layout, (ViewGroup) null));
        this.aQt = (TbImageView) this.aQl.findViewById(d.g.net_refresh_image);
        this.aQu = (TextView) this.aQl.findViewById(d.g.net_refresh_desc);
        this.aQv = (TextView) this.aQl.findViewById(d.g.net_refresh_title);
        this.aQx = (LinearLayout) this.aQl.findViewById(d.g.net_refresh_info_layout);
        this.aQw = (TextView) this.aQl.findViewById(d.g.net_refresh_button);
        this.aQw.setOnClickListener(onClickListener);
        this.aQl.setOnClickListener(null);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.aQu.setVisibility(8);
            return;
        }
        this.aQu.setVisibility(0);
        this.aQu.setText(str);
    }

    public void fe(int i) {
        ((LinearLayout.LayoutParams) this.aQx.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aQv.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aQw.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void IQ() {
        super.IQ();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.j.a
    public void IR() {
        super.IR();
        this.aQt.setImageResource(0);
    }

    public void ff(int i) {
        ViewGroup.LayoutParams layoutParams = this.aQt.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aQt.setLayoutParams(marginLayoutParams);
        }
    }

    public void IX() {
        this.aQw.setVisibility(0);
        this.aQv.setVisibility(0);
        al.c(this.aQu, d.C0141d.cp_cont_d, 1);
    }

    public void IY() {
        this.aQw.setVisibility(8);
        this.aQv.setVisibility(8);
        al.c(this.aQu, d.C0141d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.aQt, d.f.net_refresh_emotion);
        al.b(this.aQu, d.C0141d.cp_cont_d, 1, skinType);
        al.b(this.aQv, d.C0141d.cp_cont_b, 1, skinType);
        al.b(this.aQw, d.C0141d.cp_cont_g, 1, skinType);
        al.d(this.aQw, d.f.btn_appdownload, skinType);
        al.j(this.aQl, d.C0141d.cp_bg_line_d);
    }

    public View IV() {
        return this.aQl;
    }
}
