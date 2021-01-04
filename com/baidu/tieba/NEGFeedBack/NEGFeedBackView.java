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
    private int VV;
    private int VW;
    private int adG;
    private int anr;
    private int ans;
    private long bbg;
    c gfY;
    private View.OnClickListener gfZ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, at atVar);

        void onNEGFeedbackWindowShow(at atVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.bbg = 0L;
        this.anr = R.drawable.icon_pure_card_more22;
        this.ans = R.color.CAM_X0111;
        this.gfZ = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.bNI();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.bbg > 500) {
                    NEGFeedBackView.this.O(view);
                }
                NEGFeedBackView.this.bbg = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        l(tbPageContext);
    }

    private void l(TbPageContext tbPageContext) {
        this.gfY = new c(tbPageContext, this);
        setOnClickListener(this.gfZ);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.gfY.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.VW = i;
        setPadding(i, this.adG, this.VV, 0);
    }

    public void setTopPadding(int i) {
        this.adG = i;
        setPadding(this.VW, i, this.VV, 0);
    }

    public void setRightPadding(int i) {
        this.VV = i;
        setPadding(this.VW, this.adG, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(View view) {
        this.gfY.O(view);
    }

    public void bNI() {
        this.gfY.bNI();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gfY.onDetachedFromWindow();
    }

    public void setData(at atVar) {
        this.gfY.setData(atVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gfY.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        setImageDrawable(WebPManager.a(this.anr, ao.getColor(this.ans), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setEventCallback(a aVar) {
        this.gfY.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.gfY.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.gfY.setHeadText(str);
    }

    public void aI(boolean z) {
        this.gfY.aI(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gfY.setDefaultReasonArray(strArr);
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
        this.anr = i;
        this.ans = i2;
        setImageDrawable(WebPManager.a(this.anr, ao.getColor(this.ans), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
