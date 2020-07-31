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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private long aKF;
    private int aeY;
    private int aeZ;
    c fai;
    private View.OnClickListener faj;
    private Context mContext;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;

    /* loaded from: classes15.dex */
    public interface a {
        void a(aq aqVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, String str, aq aqVar);

        void b(aq aqVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aKF = 0L;
        this.aeY = R.drawable.ic_icon_pure_card_delete_svg;
        this.aeZ = R.color.cp_cont_g;
        this.faj = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.brl();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aKF > 500) {
                    NEGFeedBackView.this.O(view);
                }
                NEGFeedBackView.this.aKF = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        l(tbPageContext);
    }

    private void l(TbPageContext tbPageContext) {
        this.fai = new c(tbPageContext, this);
        setOnClickListener(this.faj);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.fai.setUniqueId(bdUniqueId);
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
        this.fai.O(view);
    }

    public void brl() {
        this.fai.brl();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fai.onDetachedFromWindow();
    }

    public void setData(aq aqVar) {
        this.fai.setData(aqVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fai.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        SvgManager.baR().a(this, this.aeY, this.aeZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setEventCallback(a aVar) {
        this.fai.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.fai.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.fai.setHeadText(str);
    }

    public void aI(boolean z) {
        this.fai.aI(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fai.setDefaultReasonArray(strArr);
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
        this.aeY = i;
        this.aeZ = i2;
        SvgManager.baR().a(this, this.aeY, this.aeZ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
