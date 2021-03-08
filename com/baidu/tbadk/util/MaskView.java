package com.baidu.tbadk.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class MaskView extends View {
    public MaskView(Context context) {
        super(context);
        init();
    }

    public MaskView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MaskView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.util.MaskView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        setVisibility(8);
        bzq();
    }

    public void bzq() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        setAlpha(0.67f);
    }

    public static void b(TextView textView, boolean z) {
        Drawable[] compoundDrawables;
        if (textView != null && z) {
            textView.setTextColor(textView.getTextColors().withAlpha(84));
            textView.setClickable(false);
            textView.setEnabled(false);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.util.MaskView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            for (Drawable drawable : textView.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setAlpha(84);
                }
            }
        }
    }
}
