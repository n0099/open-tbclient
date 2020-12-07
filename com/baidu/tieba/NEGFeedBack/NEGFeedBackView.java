package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private int VT;
    private int VU;
    private long aZz;
    private int amN;
    private int amO;
    c fWq;
    private View.OnClickListener fWr;
    private Context mContext;
    private int mPaddingTop;

    /* loaded from: classes21.dex */
    public interface a {
        void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar);

        void onNEGFeedbackWindowShow(at atVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aZz = 0L;
        this.amN = R.drawable.icon_pure_card_more22;
        this.amO = R.color.CAM_X0111;
        this.fWr = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.bLp();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aZz > 500) {
                    NEGFeedBackView.this.O(view);
                }
                NEGFeedBackView.this.aZz = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        l(tbPageContext);
    }

    private void l(TbPageContext tbPageContext) {
        this.fWq = new c(tbPageContext, this);
        setOnClickListener(this.fWr);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.fWq.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.VU = i;
        setPadding(i, this.mPaddingTop, this.VT, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.VU, i, this.VT, 0);
    }

    public void setRightPadding(int i) {
        this.VT = i;
        setPadding(this.VU, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(View view) {
        this.fWq.O(view);
    }

    public void bLp() {
        this.fWq.bLp();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fWq.onDetachedFromWindow();
    }

    public void setData(at atVar) {
        this.fWq.setData(atVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fWq.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        setImageDrawable(WebPManager.a(this.amN, ap.getColor(this.amO), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setEventCallback(a aVar) {
        this.fWq.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.fWq.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.fWq.setHeadText(str);
    }

    public void aJ(boolean z) {
        this.fWq.aJ(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWq.setDefaultReasonArray(strArr);
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        setPadding(0, i2, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void b(ViewGroup viewGroup, int i, int i2) {
        int dimens = l.getDimens(this.mContext, R.dimen.tbds24);
        setPadding(i2, 0, i2, 0);
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            layoutParams.rightMargin = dimens;
            viewGroup.addView(this, layoutParams);
        } else if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, i);
            layoutParams2.gravity = 53;
            viewGroup.addView(this, layoutParams2);
        }
    }

    public void setWebPResId(int i, int i2) {
        this.amN = i;
        this.amO = i2;
        setImageDrawable(WebPManager.a(this.amN, ap.getColor(this.amO), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
