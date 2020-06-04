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
    protected TextView aND;
    protected TbImageView epA;
    protected TBSpecificationBtn epB;
    private LinearLayout epC;
    private int epH;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.aND;
    }

    public View bey() {
        return this.epB;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.epA = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aND = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.epC = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.epB = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.epB.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.epB.setTextSize(R.dimen.tbds42);
        this.epB.setConfig(bVar);
        this.epH = R.drawable.new_pic_emotion_08;
        this.epB.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        nx(0);
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
            this.aND.setText(str);
        }
    }

    public void yx(String str) {
        if (str != null) {
            this.aND.setText(str);
            this.aND.setVisibility(0);
        }
    }

    public void nv(int i) {
        this.epH = i;
    }

    public void nw(int i) {
        this.epH = i;
        am.setImageResource(this.epA, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.epB.setText(str);
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
        this.epA.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.epA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.epA.setLayoutParams(marginLayoutParams);
        }
    }

    public void nx(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.epA.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.epA.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.epB.setVisibility(0);
        this.aND.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.epB.setVisibility(8);
        this.aND.setVisibility(8);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.epA, this.epH);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.aND, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.epB != null) {
            this.epB.aWr();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
