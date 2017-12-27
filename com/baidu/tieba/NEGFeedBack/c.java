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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends ImageView {
    private long bMw;
    d bMx;
    private View.OnClickListener bMy;
    private int bsG;
    private int bsH;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(ai aiVar);

        void a(ai aiVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, ai aiVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.bMw = 0L;
        this.bMy = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.SD();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.bMw > 500) {
                    c.this.SC();
                }
                c.this.bMw = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.bMx = new d(tbPageContext, this);
        setOnClickListener(this.bMy);
        aj.c(this, d.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.bMx.setUniqueId(bdUniqueId);
    }

    public void SB() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.bsG = i;
        setPadding(i, 0, this.bsH, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SC() {
        this.bMx.SC();
    }

    public void SD() {
        this.bMx.SD();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bMx.onDetachedFromWindow();
    }

    public void setData(ai aiVar) {
        this.bMx.setData(aiVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bMx.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.bMx.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bMx.setDefaultReasonArray(strArr);
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
