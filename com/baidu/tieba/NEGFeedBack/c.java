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
    private long bOG;
    d bOH;
    private View.OnClickListener bOI;
    private int buY;
    private int buZ;
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
        this.bOG = 0L;
        this.bOI = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.SZ();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.bOG > 500) {
                    c.this.SY();
                }
                c.this.bOG = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.bOH = new d(tbPageContext, this);
        setOnClickListener(this.bOI);
        aj.c(this, d.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.bOH.setUniqueId(bdUniqueId);
    }

    public void SX() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.buY = i;
        setPadding(i, 0, this.buZ, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SY() {
        this.bOH.SY();
    }

    public void SZ() {
        this.bOH.SZ();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bOH.onDetachedFromWindow();
    }

    public void setData(ah ahVar) {
        this.bOH.setData(ahVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bOH.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.bOH.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bOH.setDefaultReasonArray(strArr);
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
