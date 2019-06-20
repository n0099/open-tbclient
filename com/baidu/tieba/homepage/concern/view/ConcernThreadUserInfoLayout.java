package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
/* loaded from: classes4.dex */
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

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout, com.baidu.tbadk.core.view.d
    public boolean setData(bg bgVar) {
        if (super.setData(bgVar)) {
            this.Xs.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    protected void g(bg bgVar) {
        if (bgVar == null || StringUtils.isNull(bgVar.abw())) {
            this.Xv.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Xv.getLayoutParams();
        if (layoutParams != null && layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            this.Xv.setLayoutParams(layoutParams);
        }
        this.Xv.setText(bgVar.abw());
        this.Xv.setVisibility(0);
    }
}
