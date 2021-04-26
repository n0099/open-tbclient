package com.baidu.tbadk.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class MaskView extends View {

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public MaskView(Context context) {
        super(context);
        a();
    }

    public static void b(TextView textView, boolean z) {
        Drawable[] compoundDrawables;
        if (textView == null || !z) {
            return;
        }
        textView.setTextColor(textView.getTextColors().withAlpha(84));
        textView.setClickable(false);
        textView.setEnabled(false);
        textView.setOnClickListener(new b());
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setAlpha(84);
            }
        }
    }

    public final void a() {
        setOnClickListener(new a());
        setVisibility(8);
        c();
    }

    public void c() {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        setAlpha(0.67f);
    }

    public MaskView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MaskView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
