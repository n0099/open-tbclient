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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends ImageView {
    private long bME;
    d bMF;
    private View.OnClickListener bMG;
    private int bsP;
    private int bsQ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(ah ahVar);

        void a(ah ahVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, ah ahVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.bME = 0L;
        this.bMG = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Sr();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.bME > 500) {
                    c.this.Sq();
                }
                c.this.bME = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.bMF = new d(tbPageContext, this);
        setOnClickListener(this.bMG);
        aj.c(this, d.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.bMF.setUniqueId(bdUniqueId);
    }

    public void Sp() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.bsP = i;
        setPadding(i, 0, this.bsQ, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sq() {
        this.bMF.Sq();
    }

    public void Sr() {
        this.bMF.Sr();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bMF.onDetachedFromWindow();
    }

    public void setData(ah ahVar) {
        this.bMF.setData(ahVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bMF.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.bMF.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bMF.setDefaultReasonArray(strArr);
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
