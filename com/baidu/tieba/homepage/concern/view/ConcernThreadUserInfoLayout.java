package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
/* loaded from: classes16.dex */
public class ConcernThreadUserInfoLayout extends ThreadUserInfoLayout {
    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    public boolean setData(bv bvVar) {
        if (super.setData(bvVar)) {
            this.aht.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    protected void i(bv bvVar) {
        if (bvVar == null || StringUtils.isNull(bvVar.aTO())) {
            this.ahy.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahy.getLayoutParams();
        if (layoutParams != null && layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            this.ahy.setLayoutParams(layoutParams);
        }
        this.ahy.setText(bvVar.aTO());
        this.ahy.setVisibility(0);
    }
}
