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
    protected TextView bcF;
    protected TbImageView fem;
    protected TBSpecificationBtn fen;
    private LinearLayout feo;
    private int fet;
    protected TextView subTextView;

    public TextView getTitleView() {
        return this.bcF;
    }

    public View bwP() {
        return this.fen;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fem = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bcF = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.feo = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fen = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fen.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fen.setTextSize(R.dimen.tbds42);
        this.fen.setConfig(aVar);
        this.fet = R.drawable.new_pic_emotion_08;
        this.fen.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        rk(0);
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
            this.bcF.setText(str);
        }
    }

    public void Dw(String str) {
        if (str != null) {
            this.bcF.setText(str);
            this.bcF.setVisibility(0);
        }
    }

    public void ri(int i) {
        this.fet = i;
    }

    public void rj(int i) {
        this.fet = i;
        ap.setImageResource(this.fem, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fen.setText(str);
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
        this.fem.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fem.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fem.setLayoutParams(marginLayoutParams);
        }
    }

    public void rk(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.fem.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fem.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fen.setVisibility(0);
        this.bcF.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.fen.setVisibility(8);
        this.bcF.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fem, this.fet);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.bcF, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.fen != null) {
            this.fen.bok();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
