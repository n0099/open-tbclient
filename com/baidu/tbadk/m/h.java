package com.baidu.tbadk.m;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EmotionButton;
/* loaded from: classes.dex */
public class h extends a {
    protected TbImageView cIY;
    protected TextView cIZ;
    private LinearLayout cJa;
    protected EmotionButton cJf;
    private int cJg;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.cIZ;
    }

    public EmotionButton avv() {
        return this.cJf;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.cIY = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cIZ = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cJa = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cJf = (EmotionButton) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cJg = R.drawable.new_pic_emotion_09;
        this.cJf.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        kb(0);
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
            this.cIZ.setText(str);
        }
    }

    public void pZ(String str) {
        if (str != null) {
            this.cIZ.setText(str);
            this.cIZ.setVisibility(0);
        }
    }

    public void jZ(int i) {
        this.cJg = i;
    }

    public void ka(int i) {
        this.cIY.setImageResource(i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cJf.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        super.onViewDettached();
        this.cIY.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.cIY.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.cIY.setLayoutParams(marginLayoutParams);
        }
    }

    public void kb(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.cIY.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.cIY.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.cJf.setVisibility(0);
        this.cIZ.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.cJf.setVisibility(8);
        this.cIZ.setVisibility(8);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.cIY, this.cJg);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.cIZ, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
