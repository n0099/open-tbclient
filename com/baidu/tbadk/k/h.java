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
    protected TextView aZl;
    protected TbImageView eSe;
    protected TBSpecificationBtn eSf;
    private LinearLayout eSg;
    private int eSl;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.aZl;
    }

    public View buf() {
        return this.eSf;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.eSe = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aZl = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.eSg = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.eSf = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.eSf.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.eSf.setTextSize(R.dimen.tbds42);
        this.eSf.setConfig(aVar);
        this.eSl = R.drawable.new_pic_emotion_08;
        this.eSf.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        qM(0);
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
            this.aZl.setText(str);
        }
    }

    public void CK(String str) {
        if (str != null) {
            this.aZl.setText(str);
            this.aZl.setVisibility(0);
        }
    }

    public void qK(int i) {
        this.eSl = i;
    }

    public void qL(int i) {
        this.eSl = i;
        ap.setImageResource(this.eSe, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.eSf.setText(str);
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
        this.eSe.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.eSe.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.eSe.setLayoutParams(marginLayoutParams);
        }
    }

    public void qM(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.eSe.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.eSe.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.eSf.setVisibility(0);
        this.aZl.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.eSf.setVisibility(8);
        this.aZl.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.eSe, this.eSl);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.aZl, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.eSf != null) {
            this.eSf.blA();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
