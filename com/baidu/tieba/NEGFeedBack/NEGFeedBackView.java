package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NEGFeedBackView extends ImageView {
    private int aFA;
    private int aFz;
    private long aYE;
    c aYF;
    private View.OnClickListener aYG;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(ai aiVar);

        void a(ai aiVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, ai aiVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.aYE = 0L;
        this.aYG = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NEGFeedBackView.this.Lx();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aYE > 500) {
                    NEGFeedBackView.this.Lw();
                }
                NEGFeedBackView.this.aYE = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.aYF = new c(tbPageContext, this);
        setOnClickListener(this.aYG);
        ak.c(this, d.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aYF.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.aFz = i;
        setPadding(i, 0, this.aFA, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw() {
        this.aYF.Lw();
    }

    public void Lx() {
        this.aYF.Lx();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aYF.onDetachedFromWindow();
    }

    public void setData(ai aiVar) {
        this.aYF.setData(aiVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aYF.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        ak.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.aYF.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aYF.setDefaultReasonArray(strArr);
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        setPadding(0, i2, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(11);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }
}
