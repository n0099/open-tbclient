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
/* loaded from: classes2.dex */
public class NEGFeedBackView extends ImageView {
    private int aSg;
    private int aSh;
    private long boC;
    c boD;
    private View.OnClickListener boE;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ah ahVar);

        void a(ah ahVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, ah ahVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.boC = 0L;
        this.boE = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.Ro();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.boC > 500) {
                    NEGFeedBackView.this.Rn();
                }
                NEGFeedBackView.this.boC = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.boD = new c(tbPageContext, this);
        setOnClickListener(this.boE);
        al.c(this, e.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.boD.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.aSg = i;
        setPadding(i, 0, this.aSh, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rn() {
        this.boD.Rn();
    }

    public void Ro() {
        this.boD.Ro();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.boD.onDetachedFromWindow();
    }

    public void setData(ah ahVar) {
        this.boD.setData(ahVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.boD.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        al.c(this, e.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.boD.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.boD.setDefaultReasonArray(strArr);
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
