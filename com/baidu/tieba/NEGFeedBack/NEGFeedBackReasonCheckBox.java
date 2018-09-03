package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
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
        int f = l.f(this.mContext, f.e.ds24);
        setPadding(f, 0, f, 0);
        setButtonDrawable((Drawable) null);
    }

    public void AD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.i(this, f.C0146f.btn_home_neg_feedback_reason_selector);
            am.c(this, f.C0146f.text_home_neg_feedback_reason_selector, 4);
            this.mSkinType = skinType;
        }
    }
}
