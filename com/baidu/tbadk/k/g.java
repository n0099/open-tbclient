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
    protected TbImageView bdo;
    protected TextView bdp;
    protected TextView bdq;
    protected TextView bdr;
    private LinearLayout bds;

    public TextView getTitleView() {
        return this.bdq;
    }

    public TextView NK() {
        return this.bdr;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(e.h.net_refresh_view_layout, (ViewGroup) null));
        this.bdo = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.bdp = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.bdq = (TextView) this.attachedView.findViewById(e.g.net_refresh_title);
        this.bds = (LinearLayout) this.attachedView.findViewById(e.g.net_refresh_info_layout);
        this.bdr = (TextView) this.attachedView.findViewById(e.g.net_refresh_button);
        this.bdr.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void in(String str) {
        if (str == null) {
            this.bdp.setVisibility(8);
            return;
        }
        this.bdp.setVisibility(0);
        this.bdp.setText(str);
    }

    public void gc(int i) {
        ((LinearLayout.LayoutParams) this.bds.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bdq.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bdr.setText(str);
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
        this.bdo.setImageResource(0);
    }

    public void gd(int i) {
        ViewGroup.LayoutParams layoutParams = this.bdo.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bdo.setLayoutParams(marginLayoutParams);
        }
    }

    public void NL() {
        this.bdr.setVisibility(0);
        this.bdq.setVisibility(0);
        al.c(this.bdp, e.d.cp_cont_d, 1);
    }

    public void NM() {
        this.bdr.setVisibility(8);
        this.bdq.setVisibility(8);
        al.c(this.bdp, e.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.bdo, e.f.net_refresh_emotion);
        al.b(this.bdp, e.d.cp_cont_d, 1, skinType);
        al.b(this.bdq, e.d.cp_cont_b, 1, skinType);
        al.b(this.bdr, e.d.cp_cont_g, 1, skinType);
        al.d(this.bdr, e.f.btn_appdownload, skinType);
        al.j(this.attachedView, e.d.cp_bg_line_d);
    }

    public View NJ() {
        return this.attachedView;
    }
}
