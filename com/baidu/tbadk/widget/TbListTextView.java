package com.baidu.tbadk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"WrongCall"})
/* loaded from: classes3.dex */
public class TbListTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f14102e;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f14103a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Object> f14104b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Object> f14105c;

        public a(boolean z, List<Object> list, List<Object> list2) {
            this.f14103a = z;
            this.f14104b = list;
            this.f14105c = list2;
        }

        public static a a(List<Object> list, List<Object> list2) {
            return new a(true, list, list2);
        }

        public static a b() {
            return new a(false, null, null);
        }
    }

    public TbListTextView(Context context) {
        super(context);
        this.f14102e = true;
    }

    public final a a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        ArrayList arrayList = new ArrayList(spans.length);
        ArrayList arrayList2 = new ArrayList(spans.length);
        for (Object obj : spans) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            if (e(spannableStringBuilder, spanStart - 1)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList.add(obj);
            }
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            if (e(spannableStringBuilder, spanEnd)) {
                spannableStringBuilder.insert(spanEnd, " ");
                arrayList2.add(obj);
            }
            try {
                g(spannableStringBuilder, i, i2);
                return a.a(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return a.b();
    }

    public final void b(int i, int i2) {
        g(getText().toString(), i, i2);
    }

    public final void c(int i, int i2) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            d(new SpannableStringBuilder(text), i, i2);
        } else {
            b(i, i2);
        }
    }

    public final void d(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        a a2 = a(spannableStringBuilder, i, i2);
        if (a2.f14103a) {
            f(i, i2, spannableStringBuilder, a2);
        } else {
            b(i, i2);
        }
    }

    public final boolean e(CharSequence charSequence, int i) {
        return charSequence == null || i < 0 || i >= charSequence.length() || charSequence.charAt(i) != ' ';
    }

    public final void f(int i, int i2, SpannableStringBuilder spannableStringBuilder, a aVar) {
        boolean z;
        for (Object obj : aVar.f14105c) {
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                g(spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException unused) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        loop1: while (true) {
            z = true;
            for (Object obj2 : aVar.f14104b) {
                int spanStart = spannableStringBuilder.getSpanStart(obj2);
                int i3 = spanStart - 1;
                spannableStringBuilder.delete(i3, spanStart);
                try {
                    g(spannableStringBuilder, i, i2);
                    z = false;
                } catch (IndexOutOfBoundsException unused2) {
                    spannableStringBuilder.insert(i3, " ");
                }
            }
            break loop1;
        }
        if (z) {
            setText(spannableStringBuilder);
            super.onMeasure(i, i2);
        }
    }

    public final void g(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException unused) {
            c(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f14102e) {
            return super.onTouchEvent(motionEvent);
        }
        setLongClickable(false);
        super.onTouchEvent(motionEvent);
        return motionEvent.getAction() == 0 && hasSelection();
    }

    public void setCheckSelection(boolean z) {
        this.f14102e = z;
    }

    public TbListTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14102e = true;
    }

    public TbListTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14102e = true;
    }
}
