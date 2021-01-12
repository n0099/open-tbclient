package com.baidu.tbadk.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h extends a {
    protected TextView beC;
    protected TBSpecificationBtn fEA;
    private LinearLayout fEB;
    protected ImageView fEH;
    private int fEI;
    private int ffw;
    private int ffx;
    protected TextView subTextView;
    private static final int ffy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int ffz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int ffA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int ffB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int alj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    public TextView getTitleView() {
        return this.beC;
    }

    public View bCB() {
        return this.fEA;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fEH = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.beC = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fEB = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fEA = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fEA.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fEA.setTextSize(R.dimen.T_X05);
        this.fEA.setConfig(aVar);
        this.fEI = R.drawable.new_pic_emotion_08;
        this.ffw = R.color.CAM_X0107;
        this.ffx = R.color.CAM_X0109;
        this.fEA.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        rk(0);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
        } else {
            this.subTextView.setVisibility(0);
            this.subTextView.setText(str);
        }
        btE();
    }

    public void setTitle(String str) {
        if (str != null) {
            this.beC.setText(str);
        }
    }

    public void CV(String str) {
        if (str != null) {
            this.beC.setText(str);
            this.beC.setVisibility(0);
            btE();
        }
    }

    public void ri(int i) {
        this.fEI = i;
    }

    public void rj(int i) {
        this.fEI = i;
        ao.setImageResource(this.fEH, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fEA.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.l.a
    public void onViewDettached() {
        super.onViewDettached();
        this.fEH.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fEH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fEH.setLayoutParams(marginLayoutParams);
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
            i2 = (int) (equipmentHeight * 0.16d);
        }
        ViewGroup.LayoutParams layoutParams = this.fEH.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fEH.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fEA.setVisibility(0);
        this.beC.setVisibility(0);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        btE();
    }

    public void hideRefreshButton() {
        this.fEA.setVisibility(8);
        this.beC.setVisibility(8);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        btE();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setImageResource(this.fEH, this.fEI);
        ao.setViewTextColor(this.subTextView, this.ffx, 1, skinType);
        ao.setViewTextColor(this.beC, this.ffw, 1, skinType);
        if (this.fEA != null) {
            this.fEA.btV();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    private void btE() {
        if (this.fEA.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fEB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = ffz;
                this.fEB.setLayoutParams(marginLayoutParams);
            }
            this.subTextView.setVisibility(8);
            this.ffw = R.color.CAM_X0107;
        } else if (this.subTextView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fEB.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = ffz;
                this.fEB.setLayoutParams(marginLayoutParams2);
            }
            this.ffw = R.color.CAM_X0107;
        } else if (this.beC.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fEB.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = ffB;
                this.fEB.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.beC.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = alj;
                this.beC.setLayoutParams(marginLayoutParams4);
            }
            this.ffw = R.color.CAM_X0107;
            this.ffx = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fEH.getLayoutParams();
            layoutParams5.width = ffy;
            layoutParams5.height = ffy;
            this.fEH.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fEB.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = ffA;
                this.fEB.setLayoutParams(marginLayoutParams5);
            }
            this.ffx = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public void setBackGroundColor(int i) {
        ao.setBackgroundColor(this.attachedView, i);
    }
}
