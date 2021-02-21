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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class NEGFeedBackView extends AppCompatImageView {
    private long aZy;
    private int amq;
    private int amr;
    c gdJ;
    private View.OnClickListener gdK;
    private Context mContext;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;

    /* loaded from: classes.dex */
    public interface a {
        void onCheckedChanged(av avVar, CompoundButton compoundButton, boolean z);

        void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, av avVar);

        void onNEGFeedbackWindowShow(av avVar);
    }

    public NEGFeedBackView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.aZy = 0L;
        this.amq = R.drawable.icon_pure_card_more22;
        this.amr = R.color.CAM_X0111;
        this.gdK = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.NEGFeedBackView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NEGFeedBackView.this.bKq();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - NEGFeedBackView.this.aZy > 500) {
                    NEGFeedBackView.this.O(view);
                }
                NEGFeedBackView.this.aZy = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        l(tbPageContext);
    }

    private void l(TbPageContext tbPageContext) {
        this.gdJ = new c(tbPageContext, this);
        setOnClickListener(this.gdK);
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        onChangeSkinType();
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.gdJ.setUniqueId(bdUniqueId);
    }

    public void setDefaultLayout() {
        onChangeSkinType();
    }

    public void setLeftPadding(int i) {
        this.mPaddingLeft = i;
        setPadding(i, this.mPaddingTop, this.mPaddingRight, 0);
    }

    public void setTopPadding(int i) {
        this.mPaddingTop = i;
        setPadding(this.mPaddingLeft, i, this.mPaddingRight, 0);
    }

    public void setRightPadding(int i) {
        this.mPaddingRight = i;
        setPadding(this.mPaddingLeft, this.mPaddingTop, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(View view) {
        this.gdJ.O(view);
    }

    public void bKq() {
        this.gdJ.bKq();
    }

    public void setCWRotateAnimation() {
    }

    public void setACRotateAnimation() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gdJ.onDetachedFromWindow();
    }

    public void setData(av avVar) {
        this.gdJ.setData(avVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gdJ.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        setImageDrawable(WebPManager.a(this.amq, ap.getColor(this.amr), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void setEventCallback(a aVar) {
        this.gdJ.setEventCallback(aVar);
    }

    public void setAutoProcess(boolean z) {
        this.gdJ.setAutoProcess(z);
    }

    public void setHeadText(String str) {
        this.gdJ.setHeadText(str);
    }

    public void aI(boolean z) {
        this.gdJ.aI(z);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdJ.setDefaultReasonArray(strArr);
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
        this.amq = i;
        this.amr = i2;
        setImageDrawable(WebPManager.a(this.amq, ap.getColor(this.amr), WebPManager.ResourceStateType.NORMAL_PRESS));
    }
}
