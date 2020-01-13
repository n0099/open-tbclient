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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private long agy;
    c dPZ;
    private View.OnClickListener dQa;
    private Context mContext;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;

    /* loaded from: classes6.dex */
    public interface a {
        void a(al alVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, String str, al alVar);

        void b(al alVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.agy = 0L;
        this.dQa = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.aTV();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.agy > 500) {
                    NEGFeedBackView.this.R(view);
                }
                NEGFeedBackView.this.agy = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        i(tbPageContext);
    }

    private void i(TbPageContext tbPageContext) {
        this.dPZ = new c(tbPageContext, this);
        setOnClickListener(this.dQa);
        SvgManager.aEp().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.dPZ.setUniqueId(bdUniqueId);
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
    public void R(View view) {
        this.dPZ.R(view);
    }

    public void aTV() {
        this.dPZ.aTV();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dPZ.onDetachedFromWindow();
    }

    public void setData(al alVar) {
        this.dPZ.setData(alVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dPZ.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        SvgManager.aEp().a(this, R.drawable.ic_icon_pure_card_delete_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void setEventCallback(a aVar) {
        this.dPZ.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.dPZ.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.dPZ.setHeadText(str);
    }

    public void ab(boolean z) {
        this.dPZ.ab(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dPZ.setDefaultReasonArray(strArr);
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

    public void a(ViewGroup viewGroup, int i, int i2, int i3) {
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.rightMargin = i2;
            layoutParams.bottomMargin = i3;
            layoutParams.gravity = 85;
            viewGroup.addView(this, layoutParams);
        }
    }
}
