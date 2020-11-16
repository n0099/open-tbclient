package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h extends a {
    protected TextView bdB;
    private int eTi;
    private int eTj;
    protected TBSpecificationBtn frN;
    private LinearLayout frO;
    protected ImageView frU;
    private int frV;
    protected TextView subTextView;
    private static final int eTk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int eTl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int eTm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int eTn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int aky = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    public TextView getTitleView() {
        return this.bdB;
    }

    public View bAx() {
        return this.frN;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.frU = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bdB = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.frO = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.frN = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.frN.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.frN.setTextSize(R.dimen.T_X05);
        this.frN.setConfig(aVar);
        this.frV = R.drawable.new_pic_emotion_08;
        this.eTi = R.color.CAM_X0107;
        this.eTj = R.color.CAM_X0109;
        this.frN.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        sd(0);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
        } else {
            this.subTextView.setVisibility(0);
            this.subTextView.setText(str);
        }
        brD();
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bdB.setText(str);
        }
    }

    public void DC(String str) {
        if (str != null) {
            this.bdB.setText(str);
            this.bdB.setVisibility(0);
            brD();
        }
    }

    public void sb(int i) {
        this.frV = i;
    }

    public void sc(int i) {
        this.frV = i;
        ap.setImageResource(this.frU, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.frN.setText(str);
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
        this.frU.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.frU.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.frU.setLayoutParams(marginLayoutParams);
        }
    }

    public void sd(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.frU.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.frU.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.frN.setVisibility(0);
        this.bdB.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        brD();
    }

    public void hideRefreshButton() {
        this.frN.setVisibility(8);
        this.bdB.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        brD();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.frU, this.frV);
        ap.setViewTextColor(this.subTextView, this.eTj, 1, skinType);
        ap.setViewTextColor(this.bdB, this.eTi, 1, skinType);
        if (this.frN != null) {
            this.frN.brT();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    private void brD() {
        if (this.frN.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.frO.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = eTl;
                this.frO.setLayoutParams(marginLayoutParams);
            }
            this.subTextView.setVisibility(8);
            this.eTi = R.color.CAM_X0107;
        } else if (this.subTextView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.frO.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = eTl;
                this.frO.setLayoutParams(marginLayoutParams2);
            }
            this.eTi = R.color.CAM_X0107;
        } else if (this.bdB.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.frO.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = eTn;
                this.frO.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.bdB.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = aky;
                this.bdB.setLayoutParams(marginLayoutParams4);
            }
            this.eTi = R.color.CAM_X0107;
            this.eTj = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.frU.getLayoutParams();
            layoutParams5.width = eTk;
            layoutParams5.height = eTk;
            this.frU.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.frO.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = eTm;
                this.frO.setLayoutParams(marginLayoutParams5);
            }
            this.eTj = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public void setBackGroundColor(int i) {
        ap.setBackgroundColor(this.attachedView, i);
    }
}
