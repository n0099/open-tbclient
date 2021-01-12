package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private int VT;
    private int VU;
    private long aWs;
    private int adE;
    private int amA;
    private int amB;
    c gbp;
    private View.OnClickListener gbq;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar);

        void onNEGFeedbackWindowShow(at atVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aWs = 0L;
        this.amA = R.drawable.icon_pure_card_more22;
        this.amB = R.color.CAM_X0111;
        this.gbq = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.bJR();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aWs > 500) {
                    NEGFeedBackView.this.O(view);
                }
                NEGFeedBackView.this.aWs = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        l(tbPageContext);
    }

    private void l(TbPageContext tbPageContext) {
        this.gbp = new c(tbPageContext, this);
        setOnClickListener(this.gbq);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.gbp.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.VU = i;
        setPadding(i, this.adE, this.VT, 0);
    }

    public void setTopPadding(int i) {
        this.adE = i;
        setPadding(this.VU, i, this.VT, 0);
    }

    public void setRightPadding(int i) {
        this.VT = i;
        setPadding(this.VU, this.adE, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(View view) {
        this.gbp.O(view);
    }

    public void bJR() {
        this.gbp.bJR();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gbp.onDetachedFromWindow();
    }

    public void setData(at atVar) {
        this.gbp.setData(atVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gbp.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        setImageDrawable(WebPManager.a(this.amA, ao.getColor(this.amB), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setEventCallback(a aVar) {
        this.gbp.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.gbp.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.gbp.setHeadText(str);
    }

    public void aI(boolean z) {
        this.gbp.aI(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gbp.setDefaultReasonArray(strArr);
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
        this.amA = i;
        this.amB = i2;
        setImageDrawable(WebPManager.a(this.amA, ao.getColor(this.amB), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
