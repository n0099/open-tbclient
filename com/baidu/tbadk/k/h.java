package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h extends a {
    private LinearLayout dBA;
    private int dBF;
    protected TbImageView dBx;
    protected TextView dBy;
    protected TBSpecificationBtn dBz;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.dBy;
    }

    public View aPZ() {
        return this.dBz;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.dBx = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dBy = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dBA = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dBz = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dBz.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dBz.setTextSize(R.dimen.tbds42);
        this.dBz.setConfig(bVar);
        this.dBF = R.drawable.new_pic_emotion_08;
        this.dBz.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        mI(0);
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
            this.dBy.setText(str);
        }
    }

    public void vz(String str) {
        if (str != null) {
            this.dBy.setText(str);
            this.dBy.setVisibility(0);
        }
    }

    public void mG(int i) {
        this.dBF = i;
    }

    public void mH(int i) {
        this.dBx.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dBz.setText(str);
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
        this.dBx.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.dBx.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.dBx.setLayoutParams(marginLayoutParams);
        }
    }

    public void mI(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.dBx.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.dBx.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.dBz.setVisibility(0);
        this.dBy.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.dBz.setVisibility(8);
        this.dBy.setVisibility(8);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dBx, this.dBF);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dBy, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dBz != null) {
            this.dBz.aHS();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
