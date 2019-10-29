package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
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
    public boolean setData(bh bhVar) {
        if (super.setData(bhVar)) {
            this.HG.setVisibility(8);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    protected void h(bh bhVar) {
        if (bhVar == null || StringUtils.isNull(bhVar.agJ())) {
            this.HJ.setVisibility(8);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.HJ.getLayoutParams();
        if (layoutParams != null && layoutParams.bottomMargin != 0) {
            layoutParams.bottomMargin = 0;
            this.HJ.setLayoutParams(layoutParams);
        }
        this.HJ.setText(bhVar.agJ());
        this.HJ.setVisibility(0);
    }
}
