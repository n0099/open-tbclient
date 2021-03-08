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
    protected TextView bjm;
    protected TBSpecificationBtn fIl;
    private LinearLayout fIm;
    protected ImageView fIs;
    private int fIt;
    private int fjo;
    private int fjp;
    protected TextView subTextView;
    private static final int fjq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
    private static final int fjr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
    private static final int fjs = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int fjt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
    private static final int ams = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);

    public TextView getTitleView() {
        return this.bjm;
    }

    public View bCW() {
        return this.fIl;
    }

    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        this.fIs = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bjm = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.fIm = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fIl = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fIl.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fIl.setTextSize(R.dimen.T_X05);
        this.fIl.setConfig(aVar);
        this.fIt = R.drawable.new_pic_emotion_08;
        this.fjo = R.color.CAM_X0107;
        this.fjp = R.color.CAM_X0109;
        this.fIl.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        rq(0);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
        } else {
            this.subTextView.setVisibility(0);
            this.subTextView.setText(str);
        }
        bub();
    }

    public void setTitle(String str) {
        if (str != null) {
            this.bjm.setText(str);
        }
    }

    public void Dr(String str) {
        if (str != null) {
            this.bjm.setText(str);
            this.bjm.setVisibility(0);
            bub();
        }
    }

    public void ro(int i) {
        this.fIt = i;
    }

    public void rp(int i) {
        this.fIt = i;
        ap.setImageResource(this.fIs, i);
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fIl.setText(str);
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
        this.fIs.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.fIs.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.fIs.setLayoutParams(marginLayoutParams);
        }
    }

    public void rq(int i) {
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
        ViewGroup.LayoutParams layoutParams = this.fIs.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i2 + i;
            this.fIs.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.fIl.setVisibility(0);
        this.bjm.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        bub();
    }

    public void hideRefreshButton() {
        this.fIl.setVisibility(8);
        this.bjm.setVisibility(8);
        ap.setViewTextColor(this.subTextView, R.color.CAM_X0109, 1);
        bub();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fIs, this.fIt);
        ap.setViewTextColor(this.subTextView, this.fjp, 1, skinType);
        ap.setViewTextColor(this.bjm, this.fjo, 1, skinType);
        if (this.fIl != null) {
            this.fIl.bus();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    private void bub() {
        if (this.fIl.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = this.fIm.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = fjr;
                this.fIm.setLayoutParams(marginLayoutParams);
            }
            this.subTextView.setVisibility(8);
            this.fjo = R.color.CAM_X0107;
        } else if (this.subTextView.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams2 = this.fIm.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = fjr;
                this.fIm.setLayoutParams(marginLayoutParams2);
            }
            this.fjo = R.color.CAM_X0107;
        } else if (this.bjm.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = this.fIm.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.topMargin = fjt;
                this.fIm.setLayoutParams(marginLayoutParams3);
            }
            ViewGroup.LayoutParams layoutParams4 = this.bjm.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                marginLayoutParams4.topMargin = ams;
                this.bjm.setLayoutParams(marginLayoutParams4);
            }
            this.fjo = R.color.CAM_X0107;
            this.fjp = R.color.CAM_X0109;
        } else {
            ViewGroup.LayoutParams layoutParams5 = this.fIs.getLayoutParams();
            layoutParams5.width = fjq;
            layoutParams5.height = fjq;
            this.fIs.setLayoutParams(layoutParams5);
            ViewGroup.LayoutParams layoutParams6 = this.fIm.getLayoutParams();
            if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                marginLayoutParams5.topMargin = fjs;
                this.fIm.setLayoutParams(marginLayoutParams5);
            }
            this.fjp = R.color.CAM_X0109;
        }
        onChangeSkinType();
    }

    public void setBackGroundColor(int i) {
        ap.setBackgroundColor(this.attachedView, i);
    }
}
