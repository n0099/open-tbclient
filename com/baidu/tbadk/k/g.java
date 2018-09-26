package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class g extends a {
    protected TbImageView aUE;
    protected TextView aUF;
    protected TextView aUG;
    protected TextView aUH;
    private LinearLayout aUI;

    public TextView getTitleView() {
        return this.aUG;
    }

    public TextView Kz() {
        return this.aUH;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(e.h.net_refresh_view_layout, (ViewGroup) null));
        this.aUE = (TbImageView) this.aUw.findViewById(e.g.net_refresh_image);
        this.aUF = (TextView) this.aUw.findViewById(e.g.net_refresh_desc);
        this.aUG = (TextView) this.aUw.findViewById(e.g.net_refresh_title);
        this.aUI = (LinearLayout) this.aUw.findViewById(e.g.net_refresh_info_layout);
        this.aUH = (TextView) this.aUw.findViewById(e.g.net_refresh_button);
        this.aUH.setOnClickListener(onClickListener);
        this.aUw.setOnClickListener(null);
    }

    public void hG(String str) {
        if (str == null) {
            this.aUF.setVisibility(8);
            return;
        }
        this.aUF.setVisibility(0);
        this.aUF.setText(str);
    }

    public void fr(int i) {
        ((LinearLayout.LayoutParams) this.aUI.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aUG.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aUH.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Kt() {
        super.Kt();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void Ku() {
        super.Ku();
        this.aUE.setImageResource(0);
    }

    public void fs(int i) {
        ViewGroup.LayoutParams layoutParams = this.aUE.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aUE.setLayoutParams(marginLayoutParams);
        }
    }

    public void KA() {
        this.aUH.setVisibility(0);
        this.aUG.setVisibility(0);
        al.c(this.aUF, e.d.cp_cont_d, 1);
    }

    public void KB() {
        this.aUH.setVisibility(8);
        this.aUG.setVisibility(8);
        al.c(this.aUF, e.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.aUE, e.f.net_refresh_emotion);
        al.b(this.aUF, e.d.cp_cont_d, 1, skinType);
        al.b(this.aUG, e.d.cp_cont_b, 1, skinType);
        al.b(this.aUH, e.d.cp_cont_g, 1, skinType);
        al.d(this.aUH, e.f.btn_appdownload, skinType);
        al.j(this.aUw, e.d.cp_bg_line_d);
    }

    public View Ky() {
        return this.aUw;
    }
}
