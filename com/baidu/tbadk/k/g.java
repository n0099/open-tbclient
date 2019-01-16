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
    protected TbImageView beb;
    protected TextView bec;
    protected TextView bed;
    protected TextView bee;
    private LinearLayout bef;

    public TextView getTitleView() {
        return this.bed;
    }

    public TextView Oc() {
        return this.bee;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(e.h.net_refresh_view_layout, (ViewGroup) null));
        this.beb = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.bec = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.bed = (TextView) this.attachedView.findViewById(e.g.net_refresh_title);
        this.bef = (LinearLayout) this.attachedView.findViewById(e.g.net_refresh_info_layout);
        this.bee = (TextView) this.attachedView.findViewById(e.g.net_refresh_button);
        this.bee.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void iC(String str) {
        if (str == null) {
            this.bec.setVisibility(8);
            return;
        }
        this.bec.setVisibility(0);
        this.bec.setText(str);
    }

    public void gd(int i) {
        ((LinearLayout.LayoutParams) this.bef.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bed.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bee.setText(str);
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
        this.beb.setImageResource(0);
    }

    public void ge(int i) {
        ViewGroup.LayoutParams layoutParams = this.beb.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.beb.setLayoutParams(marginLayoutParams);
        }
    }

    public void Od() {
        this.bee.setVisibility(0);
        this.bed.setVisibility(0);
        al.c(this.bec, e.d.cp_cont_d, 1);
    }

    public void Oe() {
        this.bee.setVisibility(8);
        this.bed.setVisibility(8);
        al.c(this.bec, e.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.beb, e.f.net_refresh_emotion);
        al.b(this.bec, e.d.cp_cont_d, 1, skinType);
        al.b(this.bed, e.d.cp_cont_b, 1, skinType);
        al.b(this.bee, e.d.cp_cont_g, 1, skinType);
        al.d(this.bee, e.f.btn_appdownload, skinType);
        al.j(this.attachedView, e.d.cp_bg_line_d);
    }

    public View Ob() {
        return this.attachedView;
    }
}
