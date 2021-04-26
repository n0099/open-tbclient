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
    public boolean f13801e;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f13802a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Object> f13803b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Object> f13804c;

        public a(boolean z, List<Object> list, List<Object> list2) {
            this.f13802a = z;
            this.f13803b = list;
            this.f13804c = list2;
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
        this.f13801e = true;
    }

    public final a a(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
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
                g(spannableStringBuilder, i2, i3);
                return a.a(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return a.b();
    }

    public final void b(int i2, int i3) {
        g(getText().toString(), i2, i3);
    }

    public final void c(int i2, int i3) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            d(new SpannableStringBuilder(text), i2, i3);
        } else {
            b(i2, i3);
        }
    }

    public final void d(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        a a2 = a(spannableStringBuilder, i2, i3);
        if (a2.f13802a) {
            f(i2, i3, spannableStringBuilder, a2);
        } else {
            b(i2, i3);
        }
    }

    public final boolean e(CharSequence charSequence, int i2) {
        return charSequence == null || i2 < 0 || i2 >= charSequence.length() || charSequence.charAt(i2) != ' ';
    }

    public final void f(int i2, int i3, SpannableStringBuilder spannableStringBuilder, a aVar) {
        boolean z;
        for (Object obj : aVar.f13804c) {
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                g(spannableStringBuilder, i2, i3);
            } catch (IndexOutOfBoundsException unused) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        loop1: while (true) {
            z = true;
            for (Object obj2 : aVar.f13803b) {
                int spanStart = spannableStringBuilder.getSpanStart(obj2);
                int i4 = spanStart - 1;
                spannableStringBuilder.delete(i4, spanStart);
                try {
                    g(spannableStringBuilder, i2, i3);
                    z = false;
                } catch (IndexOutOfBoundsException unused2) {
                    spannableStringBuilder.insert(i4, " ");
                }
            }
            break loop1;
        }
        if (z) {
            setText(spannableStringBuilder);
            super.onMeasure(i2, i3);
        }
    }

    public final void g(CharSequence charSequence, int i2, int i3) {
        setText(charSequence);
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        try {
            super.onMeasure(i2, i3);
        } catch (IndexOutOfBoundsException unused) {
            c(i2, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f13801e) {
            return super.onTouchEvent(motionEvent);
        }
        setLongClickable(false);
        super.onTouchEvent(motionEvent);
        return motionEvent.getAction() == 0 && hasSelection();
    }

    public void setCheckSelection(boolean z) {
        this.f13801e = z;
    }

    public TbListTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13801e = true;
    }

    public TbListTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13801e = true;
    }
}
