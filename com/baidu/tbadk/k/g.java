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
    protected TbImageView bdr;
    protected TextView bds;
    protected TextView bdt;
    protected TextView bdu;
    private LinearLayout bdv;

    public TextView getTitleView() {
        return this.bdt;
    }

    public TextView NL() {
        return this.bdu;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(e.h.net_refresh_view_layout, (ViewGroup) null));
        this.bdr = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.bds = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.bdt = (TextView) this.attachedView.findViewById(e.g.net_refresh_title);
        this.bdv = (LinearLayout) this.attachedView.findViewById(e.g.net_refresh_info_layout);
        this.bdu = (TextView) this.attachedView.findViewById(e.g.net_refresh_button);
        this.bdu.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void io(String str) {
        if (str == null) {
            this.bds.setVisibility(8);
            return;
        }
        this.bds.setVisibility(0);
        this.bds.setText(str);
    }

    public void gd(int i) {
        ((LinearLayout.LayoutParams) this.bdv.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bdt.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bdu.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        super.onViewDettached();
        this.bdr.setImageResource(0);
    }

    public void ge(int i) {
        ViewGroup.LayoutParams layoutParams = this.bdr.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bdr.setLayoutParams(marginLayoutParams);
        }
    }

    public void NM() {
        this.bdu.setVisibility(0);
        this.bdt.setVisibility(0);
        al.c(this.bds, e.d.cp_cont_d, 1);
    }

    public void NN() {
        this.bdu.setVisibility(8);
        this.bdt.setVisibility(8);
        al.c(this.bds, e.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.bdr, e.f.net_refresh_emotion);
        al.b(this.bds, e.d.cp_cont_d, 1, skinType);
        al.b(this.bdt, e.d.cp_cont_b, 1, skinType);
        al.b(this.bdu, e.d.cp_cont_g, 1, skinType);
        al.d(this.bdu, e.f.btn_appdownload, skinType);
        al.j(this.attachedView, e.d.cp_bg_line_d);
    }

    public View NK() {
        return this.attachedView;
    }
}
