package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
/* loaded from: classes2.dex */
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

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout, com.baidu.tbadk.core.view.b
    public boolean setData(bd bdVar) {
        if (super.setData(bdVar)) {
            this.axV.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    protected void m(bd bdVar) {
        if (bdVar == null || StringUtils.isNull(bdVar.vJ())) {
            this.axY.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.axY.getLayoutParams();
        if (layoutParams != null && layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            this.axY.setLayoutParams(layoutParams);
        }
        this.axY.setText(bdVar.vJ());
        this.axY.setVisibility(0);
    }
}
