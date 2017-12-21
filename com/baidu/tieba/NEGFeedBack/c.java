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
    private int aEN;
    private int aEO;
    private long aYI;
    d aYJ;
    private View.OnClickListener aYK;
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
        this.aYI = 0L;
        this.aYK = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Le();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.aYI > 500) {
                    c.this.Ld();
                }
                c.this.aYI = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.aYJ = new d(tbPageContext, this);
        setOnClickListener(this.aYK);
        aj.c(this, d.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aYJ.setUniqueId(bdUniqueId);
    }

    public void Lc() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.aEN = i;
        setPadding(i, 0, this.aEO, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        this.aYJ.Ld();
    }

    public void Le() {
        this.aYJ.Le();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aYJ.onDetachedFromWindow();
    }

    public void setData(ah ahVar) {
        this.aYJ.setData(ahVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aYJ.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.aYJ.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aYJ.setDefaultReasonArray(strArr);
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
