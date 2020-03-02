package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class NEGFeedBackReasonCheckBox extends CheckBox {
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

    public void aHN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setBackgroundResource(this, R.drawable.btn_home_neg_feedback_reason_selector);
            am.setViewTextColor(this, R.drawable.text_home_neg_feedback_reason_selector, 4);
            this.mSkinType = skinType;
        }
    }
}
