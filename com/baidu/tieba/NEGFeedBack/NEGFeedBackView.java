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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private long aJj;
    private int afh;
    private int afi;
    c eTN;
    private View.OnClickListener eTO;
    private Context mContext;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ap apVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, String str, ap apVar);

        void b(ap apVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aJj = 0L;
        this.afh = R.drawable.ic_icon_pure_card_delete_svg;
        this.afi = R.color.cp_cont_g;
        this.eTO = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.bnq();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aJj > 500) {
                    NEGFeedBackView.this.L(view);
                }
                NEGFeedBackView.this.aJj = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        m(tbPageContext);
    }

    private void m(TbPageContext tbPageContext) {
        this.eTN = new c(tbPageContext, this);
        setOnClickListener(this.eTO);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.eTN.setUniqueId(bdUniqueId);
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
    public void L(View view) {
        this.eTN.L(view);
    }

    public void bnq() {
        this.eTN.bnq();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eTN.onDetachedFromWindow();
    }

    public void setData(ap apVar) {
        this.eTN.setData(apVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.eTN.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        SvgManager.aWQ().a(this, this.afh, this.afi, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setEventCallback(a aVar) {
        this.eTN.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.eTN.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.eTN.setHeadText(str);
    }

    public void aG(boolean z) {
        this.eTN.aG(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eTN.setDefaultReasonArray(strArr);
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
        this.afh = i;
        this.afi = i2;
        SvgManager.aWQ().a(this, this.afh, this.afi, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
