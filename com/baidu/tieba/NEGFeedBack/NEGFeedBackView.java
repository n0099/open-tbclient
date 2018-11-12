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
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class NEGFeedBackView extends ImageView {
    private int aXx;
    private int aXy;
    private long btq;
    c btr;
    private View.OnClickListener bts;
    private Context mContext;

    /* loaded from: classes6.dex */
    public interface a {
        void a(ah ahVar);

        void a(ah ahVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, ah ahVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.btq = 0L;
        this.bts = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.Tt();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.btq > 500) {
                    NEGFeedBackView.this.Ts();
                }
                NEGFeedBackView.this.btq = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.btr = new c(tbPageContext, this);
        setOnClickListener(this.bts);
        al.c(this, e.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.btr.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.aXx = i;
        setPadding(i, 0, this.aXy, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ts() {
        this.btr.Ts();
    }

    public void Tt() {
        this.btr.Tt();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.btr.onDetachedFromWindow();
    }

    public void setData(ah ahVar) {
        this.btr.setData(ahVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.btr.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        al.c(this, e.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.btr.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.btr.setDefaultReasonArray(strArr);
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
