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
    protected TBSpecificationBtn fGM;
    private LinearLayout fGN;
    protected ImageView fGT;
    private int fGU;
    private int fhM;
    private int fhN;
    protected TextView subTextView;
    private static final int fhO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int fhP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int fhQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int fhR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int akZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    public TextView getTitleView() {
        return this.bhK;
    }

    public View bCT() {
        return this.fGM;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fGT = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bhK = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fGN = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fGM = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fGM.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fGM.setTextSize(R.dimen.T_X05);
        this.fGM.setConfig(aVar);
        this.fGU = R.drawable.new_pic_emotion_08;
        this.fhM = R.color.CAM_X0107;
        this.fhN = R.color.CAM_X0109;
        this.fGM.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        rp(0);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
        } else {
            this.subTextView.setVisibility(0);
            this.subTextView.setText(str);
        }
        btY();
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bhK.setText(str);
        }
    }

    public void Dk(String str) {
        if (str != null) {
            this.bhK.setText(str);
            this.bhK.setVisibility(0);
            btY();
        }
    }

    public void rn(int i) {
        this.fGU = i;
    }

    public void ro(int i) {
        this.fGU = i;
        ap.setImageResource(this.fGT, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fGM.setText(str);
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
        this.fGT.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fGT.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fGT.setLayoutParams(marginLayoutParams);
        }
    }

    public void rp(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.fGT.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fGT.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fGM.setVisibility(0);
        this.bhK.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        btY();
    }

    public void hideRefreshButton() {
        this.fGM.setVisibility(8);
        this.bhK.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        btY();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fGT, this.fGU);
        ap.setViewTextColor(this.subTextView, this.fhN, 1, skinType);
        ap.setViewTextColor(this.bhK, this.fhM, 1, skinType);
        if (this.fGM != null) {
            this.fGM.bup();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    private void btY() {
        if (this.fGM.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fGN.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = fhP;
                this.fGN.setLayoutParams(marginLayoutParams);
            }
            this.subTextView.setVisibility(8);
            this.fhM = R.color.CAM_X0107;
        } else if (this.subTextView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fGN.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = fhP;
                this.fGN.setLayoutParams(marginLayoutParams2);
            }
            this.fhM = R.color.CAM_X0107;
        } else if (this.bhK.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fGN.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = fhR;
                this.fGN.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.bhK.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = akZ;
                this.bhK.setLayoutParams(marginLayoutParams4);
            }
            this.fhM = R.color.CAM_X0107;
            this.fhN = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fGT.getLayoutParams();
            layoutParams5.width = fhO;
            layoutParams5.height = fhO;
            this.fGT.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fGN.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = fhQ;
                this.fGN.setLayoutParams(marginLayoutParams5);
            }
            this.fhN = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public void setBackGroundColor(int i) {
        ap.setBackgroundColor(this.attachedView, i);
    }
}
