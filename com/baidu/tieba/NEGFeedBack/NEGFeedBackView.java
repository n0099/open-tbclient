package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private long aXU;
    private int agV;
    private int agW;
    c fOW;
    private View.OnClickListener fOX;
    private Context mContext;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;

    /* loaded from: classes21.dex */
    public interface a {
        void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, ar arVar);

        void onNEGFeedbackWindowShow(ar arVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aXU = 0L;
        this.agV = R.drawable.ic_icon_pure_card_delete_svg;
        this.agW = R.color.cp_cont_g;
        this.fOX = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.bIw();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aXU > 500) {
                    NEGFeedBackView.this.O(view);
                }
                NEGFeedBackView.this.aXU = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        l(tbPageContext);
    }

    private void l(TbPageContext tbPageContext) {
        this.fOW = new c(tbPageContext, this);
        setOnClickListener(this.fOX);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.fOW.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.mPaddingLeft = i;
        setPadding(i, this.mPaddingTop, this.mPaddingRight, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.mPaddingLeft, i, this.mPaddingRight, 0);
    }

    public void setRightPadding(int i) {
        this.mPaddingRight = i;
        setPadding(this.mPaddingLeft, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(View view) {
        this.fOW.O(view);
    }

    public void bIw() {
        this.fOW.bIw();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fOW.onDetachedFromWindow();
    }

    public void setData(ar arVar) {
        this.fOW.setData(arVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fOW.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        SvgManager.brn().a(this, this.agV, this.agW, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setEventCallback(a aVar) {
        this.fOW.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.fOW.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.fOW.setHeadText(str);
    }

    public void aJ(boolean z) {
        this.fOW.aJ(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fOW.setDefaultReasonArray(strArr);
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        setPadding(0, i2, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void b(ViewGroup viewGroup, int i, int i2) {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds24);
        setPadding(i2, 0, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = dimens;
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void setSvgResId(int i, int i2) {
        this.agV = i;
        this.agW = i2;
        SvgManager.brn().a(this, this.agV, this.agW, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
