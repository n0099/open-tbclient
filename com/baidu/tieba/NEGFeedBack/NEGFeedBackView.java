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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private long aGL;
    private int aeA;
    private int aeB;
    c eJq;
    private View.OnClickListener eJr;
    private Context mContext;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ak akVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, String str, ak akVar);

        void b(ak akVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aGL = 0L;
        this.aeA = R.drawable.ic_icon_pure_card_delete_svg;
        this.aeB = R.color.cp_cont_g;
        this.eJr = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.bkO();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aGL > 500) {
                    NEGFeedBackView.this.S(view);
                }
                NEGFeedBackView.this.aGL = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        j(tbPageContext);
    }

    private void j(TbPageContext tbPageContext) {
        this.eJq = new c(tbPageContext, this);
        setOnClickListener(this.eJr);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.eJq.setUniqueId(bdUniqueId);
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
    public void S(View view) {
        this.eJq.S(view);
    }

    public void bkO() {
        this.eJq.bkO();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eJq.onDetachedFromWindow();
    }

    public void setData(ak akVar) {
        this.eJq.setData(akVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.eJq.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        SvgManager.aUV().a(this, this.aeA, this.aeB, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setEventCallback(a aVar) {
        this.eJq.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.eJq.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.eJq.setHeadText(str);
    }

    public void aF(boolean z) {
        this.eJq.aF(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eJq.setDefaultReasonArray(strArr);
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
        this.aeA = i;
        this.aeB = i2;
        SvgManager.aUV().a(this, this.aeA, this.aeB, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
