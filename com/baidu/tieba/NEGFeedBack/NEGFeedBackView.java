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
    private int baY;
    private int baZ;
    private long bwR;
    c bwS;
    private View.OnClickListener bwT;
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
        this.bwR = 0L;
        this.bwT = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.UB();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.bwR > 500) {
                    NEGFeedBackView.this.UA();
                }
                NEGFeedBackView.this.bwR = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.bwS = new c(tbPageContext, this);
        setOnClickListener(this.bwT);
        al.c(this, e.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.bwS.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.baY = i;
        setPadding(i, 0, this.baZ, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        this.bwS.UA();
    }

    public void UB() {
        this.bwS.UB();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bwS.onDetachedFromWindow();
    }

    public void setData(ah ahVar) {
        this.bwS.setData(ahVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bwS.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        al.c(this, e.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.bwS.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bwS.setDefaultReasonArray(strArr);
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
