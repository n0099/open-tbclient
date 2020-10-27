package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h extends a {
    protected TextView bdT;
    protected TbImageView fmL;
    protected TBSpecificationBtn fmM;
    private LinearLayout fmN;
    private int fmS;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.bdT;
    }

    public View byI() {
        return this.fmM;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fmL = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bdT = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fmN = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fmM = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fmM.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fmM.setTextSize(R.dimen.tbds42);
        this.fmM.setConfig(aVar);
        this.fmS = R.drawable.new_pic_emotion_08;
        this.fmM.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        rv(0);
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
            this.bdT.setText(str);
        }
    }

    public void DP(String str) {
        if (str != null) {
            this.bdT.setText(str);
            this.bdT.setVisibility(0);
        }
    }

    public void rt(int i) {
        this.fmS = i;
    }

    public void ru(int i) {
        this.fmS = i;
        ap.setImageResource(this.fmL, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fmM.setText(str);
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
        this.fmL.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fmL.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fmL.setLayoutParams(marginLayoutParams);
        }
    }

    public void rv(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.fmL.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fmL.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fmM.setVisibility(0);
        this.bdT.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.fmM.setVisibility(8);
        this.bdT.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fmL, this.fmS);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.bdT, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.fmM != null) {
            this.fmM.bqd();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
