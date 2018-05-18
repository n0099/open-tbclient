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
    private int aFB;
    private long aYF;
    c aYG;
    private View.OnClickListener aYH;
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
        this.aYF = 0L;
        this.aYH = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NEGFeedBackView.this.Lv();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aYF > 500) {
                    NEGFeedBackView.this.Lu();
                }
                NEGFeedBackView.this.aYF = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.aYG = new c(tbPageContext, this);
        setOnClickListener(this.aYH);
        ak.c(this, d.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aYG.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.aFA = i;
        setPadding(i, 0, this.aFB, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lu() {
        this.aYG.Lu();
    }

    public void Lv() {
        this.aYG.Lv();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aYG.onDetachedFromWindow();
    }

    public void setData(ai aiVar) {
        this.aYG.setData(aiVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aYG.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        ak.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.aYG.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aYG.setDefaultReasonArray(strArr);
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
