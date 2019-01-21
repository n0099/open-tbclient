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
    protected TbImageView bec;
    protected TextView bed;
    protected TextView bee;
    protected TextView bef;
    private LinearLayout beh;

    public TextView getTitleView() {
        return this.bee;
    }

    public TextView Oc() {
        return this.bef;
    }

    public g(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(e.h.net_refresh_view_layout, (ViewGroup) null));
        this.bec = (TbImageView) this.attachedView.findViewById(e.g.net_refresh_image);
        this.bed = (TextView) this.attachedView.findViewById(e.g.net_refresh_desc);
        this.bee = (TextView) this.attachedView.findViewById(e.g.net_refresh_title);
        this.beh = (LinearLayout) this.attachedView.findViewById(e.g.net_refresh_info_layout);
        this.bef = (TextView) this.attachedView.findViewById(e.g.net_refresh_button);
        this.bef.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void iC(String str) {
        if (str == null) {
            this.bed.setVisibility(8);
            return;
        }
        this.bed.setVisibility(0);
        this.bed.setText(str);
    }

    public void gd(int i) {
        ((LinearLayout.LayoutParams) this.beh.getLayoutParams()).topMargin = i;
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bee.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.bef.setText(str);
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
        this.bec.setImageResource(0);
    }

    public void ge(int i) {
        ViewGroup.LayoutParams layoutParams = this.bec.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.bec.setLayoutParams(marginLayoutParams);
        }
    }

    public void Od() {
        this.bef.setVisibility(0);
        this.bee.setVisibility(0);
        al.c(this.bed, e.d.cp_cont_d, 1);
    }

    public void Oe() {
        this.bef.setVisibility(8);
        this.bee.setVisibility(8);
        al.c(this.bed, e.d.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.bec, e.f.net_refresh_emotion);
        al.b(this.bed, e.d.cp_cont_d, 1, skinType);
        al.b(this.bee, e.d.cp_cont_b, 1, skinType);
        al.b(this.bef, e.d.cp_cont_g, 1, skinType);
        al.d(this.bef, e.f.btn_appdownload, skinType);
        al.j(this.attachedView, e.d.cp_bg_line_d);
    }

    public View Ob() {
        return this.attachedView;
    }
}
