package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class l extends TextView {
    public l(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        setLongClickable(false);
        super.onTouchEvent(motionEvent);
        return motionEvent.getAction() == 0 && hasSelection();
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException e) {
            CharSequence text = getText();
            if (!(text instanceof Spanned)) {
                com.baidu.adp.lib.util.f.e(getClass().getName(), "fixOnMeasure", "The text isn't a Spanned");
                a(i, i2);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            m a = a(spannableStringBuilder, i, i2);
            if (a.a) {
                a(i, i2, spannableStringBuilder, a);
            } else {
                a(i, i2);
            }
        }
    }

    private m a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        ArrayList arrayList = new ArrayList(spans.length);
        ArrayList arrayList2 = new ArrayList(spans.length);
        for (Object obj : spans) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            if (a(spannableStringBuilder, spanStart - 1)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList.add(obj);
            }
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            if (a(spannableStringBuilder, spanEnd)) {
                spannableStringBuilder.insert(spanEnd, " ");
                arrayList2.add(obj);
            }
            try {
                a((CharSequence) spannableStringBuilder, i, i2);
                return m.a(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "addSpacesAroundSpansUntilFixed", e.getMessage());
            }
        }
        com.baidu.adp.lib.util.f.e(getClass().getName(), "addSpacesAroundSpansUntilFixed", "Could not fix the Spanned by adding spaces around spans");
        return m.a();
    }

    private static boolean a(CharSequence charSequence, int i) {
        return i < 0 || charSequence.charAt(i) != ' ';
    }

    private void a(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    private void a(int i, int i2, SpannableStringBuilder spannableStringBuilder, m mVar) {
        for (Object obj : mVar.c) {
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                a((CharSequence) spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException e) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        boolean z = true;
        for (Object obj2 : mVar.b) {
            int spanStart = spannableStringBuilder.getSpanStart(obj2);
            spannableStringBuilder.delete(spanStart - 1, spanStart);
            try {
                a((CharSequence) spannableStringBuilder, i, i2);
                z = false;
            } catch (IndexOutOfBoundsException e2) {
                spannableStringBuilder.insert(spanStart - 1, " ");
                z = true;
            }
        }
        if (z) {
            setText(spannableStringBuilder);
            super.onMeasure(i, i2);
        }
    }

    private void a(int i, int i2) {
        com.baidu.adp.lib.util.f.e(getClass().getName(), "fallbackToString", "Fallback to unspanned text");
        a(getText().toString(), i, i2);
    }
}
