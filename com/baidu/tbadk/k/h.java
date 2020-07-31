package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h extends a {
    protected TextView aRC;
    protected TbImageView eEI;
    protected TBSpecificationBtn eEJ;
    private LinearLayout eEK;
    private int eEP;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.aRC;
    }

    public View bko() {
        return this.eEJ;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.eEI = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aRC = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.eEK = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.eEJ = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.eEJ.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.eEJ.setTextSize(R.dimen.tbds42);
        this.eEJ.setConfig(bVar);
        this.eEP = R.drawable.new_pic_emotion_08;
        this.eEJ.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        ok(0);
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
            this.aRC.setText(str);
        }
    }

    public void zX(String str) {
        if (str != null) {
            this.aRC.setText(str);
            this.aRC.setVisibility(0);
        }
    }

    public void oi(int i) {
        this.eEP = i;
    }

    public void oj(int i) {
        this.eEP = i;
        ao.setImageResource(this.eEI, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.eEJ.setText(str);
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
        this.eEI.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.eEI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eEI.setLayoutParams(marginLayoutParams);
        }
    }

    public void ok(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.eEI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.eEI.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.eEJ.setVisibility(0);
        this.aRC.setVisibility(0);
        ao.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.eEJ.setVisibility(8);
        this.aRC.setVisibility(8);
        ao.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setImageResource(this.eEI, this.eEP);
        ao.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ao.setViewTextColor(this.aRC, R.color.cp_cont_j, 1, skinType);
        ao.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.eEJ != null) {
            this.eEJ.bci();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
