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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class h extends a {
    protected TextView bhK;
    private int faD;
    private int faE;
    protected TBSpecificationBtn fzB;
    private LinearLayout fzC;
    protected ImageView fzI;
    private int fzJ;
    protected TextView subTextView;
    private static final int faF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int faG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int faH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int faI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int alz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    public TextView getTitleView() {
        return this.bhK;
    }

    public View bDZ() {
        return this.fzB;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fzI = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bhK = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fzC = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fzB = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fzB.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fzB.setTextSize(R.dimen.T_X05);
        this.fzB.setConfig(aVar);
        this.fzJ = R.drawable.new_pic_emotion_08;
        this.faD = R.color.CAM_X0107;
        this.faE = R.color.CAM_X0109;
        this.fzB.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        sE(0);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
        } else {
            this.subTextView.setVisibility(0);
            this.subTextView.setText(str);
        }
        bvc();
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bhK.setText(str);
        }
    }

    public void Ek(String str) {
        if (str != null) {
            this.bhK.setText(str);
            this.bhK.setVisibility(0);
            bvc();
        }
    }

    public void sC(int i) {
        this.fzJ = i;
    }

    public void sD(int i) {
        this.fzJ = i;
        ap.setImageResource(this.fzI, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fzB.setText(str);
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
        this.fzI.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fzI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fzI.setLayoutParams(marginLayoutParams);
        }
    }

    public void sE(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.fzI.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fzI.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fzB.setVisibility(0);
        this.bhK.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        bvc();
    }

    public void hideRefreshButton() {
        this.fzB.setVisibility(8);
        this.bhK.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        bvc();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fzI, this.fzJ);
        ap.setViewTextColor(this.subTextView, this.faE, 1, skinType);
        ap.setViewTextColor(this.bhK, this.faD, 1, skinType);
        if (this.fzB != null) {
            this.fzB.bvt();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    private void bvc() {
        if (this.fzB.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fzC.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = faG;
                this.fzC.setLayoutParams(marginLayoutParams);
            }
            this.subTextView.setVisibility(8);
            this.faD = R.color.CAM_X0107;
        } else if (this.subTextView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fzC.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = faG;
                this.fzC.setLayoutParams(marginLayoutParams2);
            }
            this.faD = R.color.CAM_X0107;
        } else if (this.bhK.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fzC.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = faI;
                this.fzC.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.bhK.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = alz;
                this.bhK.setLayoutParams(marginLayoutParams4);
            }
            this.faD = R.color.CAM_X0107;
            this.faE = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fzI.getLayoutParams();
            layoutParams5.width = faF;
            layoutParams5.height = faF;
            this.fzI.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fzC.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = faH;
                this.fzC.setLayoutParams(marginLayoutParams5);
            }
            this.faE = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public void setBackGroundColor(int i) {
        ap.setBackgroundColor(this.attachedView, i);
    }
}
