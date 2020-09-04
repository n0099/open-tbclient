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
    protected TextView aWR;
    protected TbImageView ePn;
    protected TBSpecificationBtn ePo;
    private LinearLayout ePp;
    private int ePu;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.aWR;
    }

    public View btb() {
        return this.ePo;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.ePn = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aWR = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.ePp = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.ePo = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ePo.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.ePo.setTextSize(R.dimen.tbds42);
        this.ePo.setConfig(aVar);
        this.ePu = R.drawable.new_pic_emotion_08;
        this.ePo.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        qv(0);
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
            this.aWR.setText(str);
        }
    }

    public void Co(String str) {
        if (str != null) {
            this.aWR.setText(str);
            this.aWR.setVisibility(0);
        }
    }

    public void qt(int i) {
        this.ePu = i;
    }

    public void qu(int i) {
        this.ePu = i;
        ap.setImageResource(this.ePn, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.ePo.setText(str);
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
        this.ePn.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.ePn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.ePn.setLayoutParams(marginLayoutParams);
        }
    }

    public void qv(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.ePn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.ePn.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.ePo.setVisibility(0);
        this.aWR.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.ePo.setVisibility(8);
        this.aWR.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.ePn, this.ePu);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.aWR, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.ePo != null) {
            this.ePo.bkF();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
