package com.baidu.tieba.homepage.topic.topictab.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes16.dex */
public class CellTopicLinearLayout extends LinearLayout {
    public CellTopicLinearLayout(Context context) {
        super(context);
    }

    public CellTopicLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CellTopicLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
    }

    public void setTopicOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }
}
