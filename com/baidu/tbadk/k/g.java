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
    protected TbImageView aZQ;
    protected TextView aZR;
    protected TextView aZS;
    protected TextView aZT;
    private LinearLayout aZU;

    public TextView getTitleView() {
        return this.aZS;
    }

    public TextView MG() {
        return this.aZT;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(e.h.net_refresh_view_layout, (ViewGroup) null));
        this.aZQ = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.aZR = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.aZS = (TextView) this.attachedView.findViewById(e.g.net_refresh_title);
        this.aZU = (LinearLayout) this.attachedView.findViewById(e.g.net_refresh_info_layout);
        this.aZT = (TextView) this.attachedView.findViewById(e.g.net_refresh_button);
        this.aZT.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void hV(String str) {
        if (str == null) {
            this.aZR.setVisibility(8);
            return;
        }
        this.aZR.setVisibility(0);
        this.aZR.setText(str);
    }

    public void fO(int i) {
        ((LinearLayout.LayoutParams) this.aZU.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aZS.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.aZT.setText(str);
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
        this.aZQ.setImageResource(0);
    }

    public void fP(int i) {
        ViewGroup.LayoutParams layoutParams = this.aZQ.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.aZQ.setLayoutParams(marginLayoutParams);
        }
    }

    public void MH() {
        this.aZT.setVisibility(0);
        this.aZS.setVisibility(0);
        al.c(this.aZR, e.d.cp_cont_d, 1);
    }

    public void MI() {
        this.aZT.setVisibility(8);
        this.aZS.setVisibility(8);
        al.c(this.aZR, e.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.aZQ, e.f.net_refresh_emotion);
        al.b(this.aZR, e.d.cp_cont_d, 1, skinType);
        al.b(this.aZS, e.d.cp_cont_b, 1, skinType);
        al.b(this.aZT, e.d.cp_cont_g, 1, skinType);
        al.d(this.aZT, e.f.btn_appdownload, skinType);
        al.j(this.attachedView, e.d.cp_bg_line_d);
    }

    public View MF() {
        return this.attachedView;
    }
}
