package com.baidu.tbadk.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TbListTextView extends TextView {
    private boolean aGV;

    public TbListTextView(Context context) {
        super(context);
        this.aGV = true;
    }

    public void setCheckSelection(boolean z) {
        this.aGV = z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.aGV) {
            return super.onTouchEvent(motionEvent);
        }
        setLongClickable(false);
        super.onTouchEvent(motionEvent);
        return motionEvent.getAction() == 0 && hasSelection();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException e) {
            G(i, i2);
        }
    }

    private void G(int i, int i2) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            a(new SpannableStringBuilder(text), i, i2);
        } else {
            H(i, i2);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        a b = b(spannableStringBuilder, i, i2);
        if (b.aGW) {
            a(i, i2, spannableStringBuilder, b);
        } else {
            H(i, i2);
        }
    }

    private a b(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
        ArrayList arrayList = new ArrayList(spans.length);
        ArrayList arrayList2 = new ArrayList(spans.length);
        for (Object obj : spans) {
            int spanStart = spannableStringBuilder.getSpanStart(obj);
            if (b(spannableStringBuilder, spanStart - 1)) {
                spannableStringBuilder.insert(spanStart, " ");
                arrayList.add(obj);
            }
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            if (b(spannableStringBuilder, spanEnd)) {
                spannableStringBuilder.insert(spanEnd, " ");
                arrayList2.add(obj);
            }
            try {
                d(spannableStringBuilder, i, i2);
                return a.a(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e) {
                BdLog.e(e.getMessage());
            }
        }
        return a.HM();
    }

    private boolean b(CharSequence charSequence, int i) {
        return i < 0 || charSequence.charAt(i) != ' ';
    }

    private void d(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    private void a(int i, int i2, SpannableStringBuilder spannableStringBuilder, a aVar) {
        for (Object obj : aVar.aGY) {
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                d(spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException e) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        boolean z = true;
        for (Object obj2 : aVar.aGX) {
            int spanStart = spannableStringBuilder.getSpanStart(obj2);
            spannableStringBuilder.delete(spanStart - 1, spanStart);
            try {
                d(spannableStringBuilder, i, i2);
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

    private void H(int i, int i2) {
        d(getText().toString(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public final boolean aGW;
        public final List<Object> aGX;
        public final List<Object> aGY;

        public static a a(List<Object> list, List<Object> list2) {
            return new a(true, list, list2);
        }

        public static a HM() {
            return new a(false, null, null);
        }

        private a(boolean z, List<Object> list, List<Object> list2) {
            this.aGW = z;
            this.aGX = list;
            this.aGY = list2;
        }
    }
}
