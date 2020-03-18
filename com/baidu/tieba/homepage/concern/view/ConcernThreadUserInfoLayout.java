package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
/* loaded from: classes9.dex */
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

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout, com.baidu.tbadk.core.view.c
    public boolean setData(bj bjVar) {
        if (super.setData(bjVar)) {
            this.No.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    protected void i(bj bjVar) {
        if (bjVar == null || StringUtils.isNull(bjVar.aAk())) {
            this.Nr.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Nr.getLayoutParams();
        if (layoutParams != null && layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            this.Nr.setLayoutParams(layoutParams);
        }
        this.Nr.setText(bjVar.aAk());
        this.Nr.setVisibility(0);
    }
}
