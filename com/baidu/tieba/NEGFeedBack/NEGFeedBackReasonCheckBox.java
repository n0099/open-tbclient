package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes20.dex */
public class NEGFeedBackReasonCheckBox extends CheckBox {
    private GradientDrawable fOp;
    private GradientDrawable fOq;
    private StateListDrawable fOr;
    private Context mContext;
    private int mSkinType;

    public NEGFeedBackReasonCheckBox(Context context) {
        super(context);
        this.mContext = null;
        this.mSkinType = 3;
        this.mContext = context;
        init();
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mSkinType = 3;
        this.mContext = context;
        init();
    }

    public NEGFeedBackReasonCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mSkinType = 3;
        this.mContext = context;
        init();
    }

    private void init() {
        int dimens = l.getDimens(this.mContext, R.dimen.ds24);
        setPadding(dimens, 0, dimens, 0);
        setButtonDrawable((Drawable) null);
    }

    public void brT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            f(R.string.J_X07, l.getDimens(this.mContext, R.dimen.L_X01), R.color.CAM_X0902, R.color.CAM_X0304);
            ap.e(this, R.color.CAM_X0105, R.color.CAM_X0304);
            this.mSkinType = skinType;
        }
    }

    private void f(int i, int i2, int i3, int i4) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i).split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0]);
        this.fOp = new GradientDrawable();
        this.fOp.setShape(0);
        this.fOp.setCornerRadius(parseInt);
        this.fOp.setStroke(i2, ap.getColor(i3));
        this.fOq = new GradientDrawable();
        this.fOq.setShape(0);
        this.fOq.setCornerRadius(parseInt);
        this.fOq.setStroke(i2, com.baidu.tieba.tbadkCore.c.m(ap.getColor(i4), 0.5f));
        this.fOr = new StateListDrawable();
        this.fOr.addState(new int[]{-16842912}, this.fOp);
        this.fOr.addState(new int[]{16842912}, this.fOq);
        setBackgroundDrawable(this.fOr);
    }
}
