package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
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
        int g = l.g(this.mContext, R.dimen.ds24);
        setPadding(g, 0, g, 0);
        setButtonDrawable((Drawable) null);
    }

    public void akL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.k(this, R.drawable.btn_home_neg_feedback_reason_selector);
            am.f(this, R.drawable.text_home_neg_feedback_reason_selector, 4);
            this.mSkinType = skinType;
        }
    }
}
