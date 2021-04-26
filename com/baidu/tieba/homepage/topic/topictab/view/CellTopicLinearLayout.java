package com.baidu.tieba.homepage.topic.topictab.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class CellTopicLinearLayout extends LinearLayout {
    public CellTopicLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
    }

    public void setTopicOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public CellTopicLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CellTopicLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
