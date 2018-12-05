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
    private int baV;
    private int baW;
    private long bwO;
    c bwP;
    private View.OnClickListener bwQ;
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
        this.bwO = 0L;
        this.bwQ = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.Uz();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.bwO > 500) {
                    NEGFeedBackView.this.Uy();
                }
                NEGFeedBackView.this.bwO = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.bwP = new c(tbPageContext, this);
        setOnClickListener(this.bwQ);
        al.c(this, e.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.bwP.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.baV = i;
        setPadding(i, 0, this.baW, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uy() {
        this.bwP.Uy();
    }

    public void Uz() {
        this.bwP.Uz();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bwP.onDetachedFromWindow();
    }

    public void setData(ah ahVar) {
        this.bwP.setData(ahVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bwP.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        al.c(this, e.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.bwP.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bwP.setDefaultReasonArray(strArr);
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
