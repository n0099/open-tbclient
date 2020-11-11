package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
/* loaded from: classes22.dex */
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
    public boolean setData(bw bwVar) {
        if (super.setData(bwVar)) {
            this.ajw.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    protected void j(bw bwVar) {
        if (bwVar == null || StringUtils.isNull(bwVar.bka())) {
            this.ajB.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ajB.getLayoutParams();
        if (layoutParams != null && layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            this.ajB.setLayoutParams(layoutParams);
        }
        this.ajB.setText(bwVar.bka());
        this.ajB.setVisibility(0);
    }
}
