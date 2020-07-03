package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h extends a {
    protected TextView aQj;
    protected TbImageView eys;
    protected TBSpecificationBtn eyt;
    private LinearLayout eyu;
    private int eyz;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.aQj;
    }

    public View bgD() {
        return this.eyt;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.eys = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aQj = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.eyu = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.eyt = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.eyt.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.eyt.setTextSize(R.dimen.tbds42);
        this.eyt.setConfig(bVar);
        this.eyz = R.drawable.new_pic_emotion_08;
        this.eyt.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        nS(0);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aQj.setText(str);
        }
    }

    public void yQ(String str) {
        if (str != null) {
            this.aQj.setText(str);
            this.aQj.setVisibility(0);
        }
    }

    public void nQ(int i) {
        this.eyz = i;
    }

    public void nR(int i) {
        this.eyz = i;
        an.setImageResource(this.eys, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.eyt.setText(str);
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
        this.eys.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.eys.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eys.setLayoutParams(marginLayoutParams);
        }
    }

    public void nS(int i) {
        int i2;
        if (i < 0) {
            i = 0;
        }
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
        if (equipmentHeight <= 0) {
            i2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200);
        } else {
            i2 = (int) (equipmentHeight * 0.11d);
        }
        ViewGroup.LayoutParams layoutParams = this.eys.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.eys.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.eyt.setVisibility(0);
        this.aQj.setVisibility(0);
        an.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.eyt.setVisibility(8);
        this.aQj.setVisibility(8);
        an.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        an.setImageResource(this.eys, this.eyz);
        an.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        an.setViewTextColor(this.aQj, R.color.cp_cont_j, 1, skinType);
        an.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.eyt != null) {
            this.eyt.aYj();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
