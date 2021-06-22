package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import d.a.n0.r.q.a2;
/* loaded from: classes4.dex */
public class ConcernThreadUserInfoLayout extends ThreadUserInfoLayout {
    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    public boolean j(a2 a2Var) {
        if (super.j(a2Var)) {
            this.f12554i.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    public void s(a2 a2Var) {
        if (a2Var != null && !StringUtils.isNull(a2Var.X0())) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams != null && layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                this.m.setLayoutParams(layoutParams);
            }
            this.m.setText(a2Var.X0());
            this.m.setVisibility(0);
            return;
        }
        this.m.setVisibility(8);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
