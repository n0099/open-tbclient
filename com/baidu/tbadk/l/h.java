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
    protected TextView bjt;
    protected TBSpecificationBtn fJh;
    private LinearLayout fJi;
    protected ImageView fJo;
    private int fJp;
    private int fkh;
    private int fki;
    protected TextView subTextView;
    private static final int fkj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int fkk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int fkl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int fkm = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int amb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    public TextView getTitleView() {
        return this.bjt;
    }

    public View bGt() {
        return this.fJh;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fJo = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bjt = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fJi = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fJh = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fJh.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fJh.setTextSize(R.dimen.T_X05);
        this.fJh.setConfig(aVar);
        this.fJp = R.drawable.new_pic_emotion_08;
        this.fkh = R.color.CAM_X0107;
        this.fki = R.color.CAM_X0109;
        this.fJh.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        sQ(0);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
        } else {
            this.subTextView.setVisibility(0);
            this.subTextView.setText(str);
        }
        bxx();
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bjt.setText(str);
        }
    }

    public void Eh(String str) {
        if (str != null) {
            this.bjt.setText(str);
            this.bjt.setVisibility(0);
            bxx();
        }
    }

    public void sO(int i) {
        this.fJp = i;
    }

    public void sP(int i) {
        this.fJp = i;
        ao.setImageResource(this.fJo, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fJh.setText(str);
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
        this.fJo.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fJo.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fJo.setLayoutParams(marginLayoutParams);
        }
    }

    public void sQ(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.fJo.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fJo.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fJh.setVisibility(0);
        this.bjt.setVisibility(0);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        bxx();
    }

    public void hideRefreshButton() {
        this.fJh.setVisibility(8);
        this.bjt.setVisibility(8);
        ao.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        bxx();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setImageResource(this.fJo, this.fJp);
        ao.setViewTextColor(this.subTextView, this.fki, 1, skinType);
        ao.setViewTextColor(this.bjt, this.fkh, 1, skinType);
        if (this.fJh != null) {
            this.fJh.bxO();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    private void bxx() {
        if (this.fJh.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fJi.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = fkk;
                this.fJi.setLayoutParams(marginLayoutParams);
            }
            this.subTextView.setVisibility(8);
            this.fkh = R.color.CAM_X0107;
        } else if (this.subTextView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fJi.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = fkk;
                this.fJi.setLayoutParams(marginLayoutParams2);
            }
            this.fkh = R.color.CAM_X0107;
        } else if (this.bjt.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fJi.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = fkm;
                this.fJi.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.bjt.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = amb;
                this.bjt.setLayoutParams(marginLayoutParams4);
            }
            this.fkh = R.color.CAM_X0107;
            this.fki = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fJo.getLayoutParams();
            layoutParams5.width = fkj;
            layoutParams5.height = fkj;
            this.fJo.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fJi.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = fkl;
                this.fJi.setLayoutParams(marginLayoutParams5);
            }
            this.fki = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public void setBackGroundColor(int i) {
        ao.setBackgroundColor(this.attachedView, i);
    }
}
