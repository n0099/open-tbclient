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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class NEGFeedBackView extends ImageView {
    private int aNW;
    private int aNX;
    private long bgP;
    c bgQ;
    private View.OnClickListener bgR;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ai aiVar);

        void a(ai aiVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, ai aiVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.bgP = 0L;
        this.bgR = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.OU();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.bgP > 500) {
                    NEGFeedBackView.this.OT();
                }
                NEGFeedBackView.this.bgP = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        f(tbPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        this.bgQ = new c(tbPageContext, this);
        setOnClickListener(this.bgR);
        al.c(this, d.f.icon_home_feedback_selector);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.bgQ.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.aNW = i;
        setPadding(i, 0, this.aNX, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OT() {
        this.bgQ.OT();
    }

    public void OU() {
        this.bgQ.OU();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bgQ.onDetachedFromWindow();
    }

    public void setData(ai aiVar) {
        this.bgQ.setData(aiVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bgQ.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        al.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.bgQ.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bgQ.setDefaultReasonArray(strArr);
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
