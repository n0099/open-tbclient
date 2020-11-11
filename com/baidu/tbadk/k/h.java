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
    protected TextView bfp;
    protected TbImageView fsE;
    protected TBSpecificationBtn fsF;
    private LinearLayout fsG;
    private int fsL;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.bfp;
    }

    public View bBh() {
        return this.fsF;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fsE = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bfp = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fsG = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fsF = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fsF.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fsF.setTextSize(R.dimen.tbds42);
        this.fsF.setConfig(aVar);
        this.fsL = R.drawable.new_pic_emotion_08;
        this.fsF.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        rF(0);
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
            this.bfp.setText(str);
        }
    }

    public void Ed(String str) {
        if (str != null) {
            this.bfp.setText(str);
            this.bfp.setVisibility(0);
        }
    }

    public void rD(int i) {
        this.fsL = i;
    }

    public void rE(int i) {
        this.fsL = i;
        ap.setImageResource(this.fsE, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fsF.setText(str);
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
        this.fsE.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fsE.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fsE.setLayoutParams(marginLayoutParams);
        }
    }

    public void rF(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.fsE.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fsE.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fsF.setVisibility(0);
        this.bfp.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.fsF.setVisibility(8);
        this.bfp.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fsE, this.fsL);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.bfp, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.fsF != null) {
            this.fsF.bsD();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
