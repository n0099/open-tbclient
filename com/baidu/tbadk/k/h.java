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
    protected TbImageView dAW;
    protected TextView dAX;
    protected TBSpecificationBtn dAY;
    private LinearLayout dAZ;
    private int dBe;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.dAX;
    }

    public View aPS() {
        return this.dAY;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.dAW = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dAX = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dAZ = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dAY = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dAY.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dAY.setTextSize(R.dimen.tbds42);
        this.dAY.setConfig(bVar);
        this.dBe = R.drawable.new_pic_emotion_08;
        this.dAY.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        mG(0);
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
            this.dAX.setText(str);
        }
    }

    public void vy(String str) {
        if (str != null) {
            this.dAX.setText(str);
            this.dAX.setVisibility(0);
        }
    }

    public void mE(int i) {
        this.dBe = i;
    }

    public void mF(int i) {
        this.dAW.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dAY.setText(str);
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
        this.dAW.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.dAW.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.dAW.setLayoutParams(marginLayoutParams);
        }
    }

    public void mG(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.dAW.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.dAW.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.dAY.setVisibility(0);
        this.dAX.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.dAY.setVisibility(8);
        this.dAX.setVisibility(8);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dAW, this.dBe);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dAX, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dAY != null) {
            this.dAY.aHL();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
