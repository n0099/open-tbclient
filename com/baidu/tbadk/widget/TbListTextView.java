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
/* loaded from: classes.dex */
public class TbListTextView extends TextView {
    private boolean cvB;

    public TbListTextView(Context context) {
        super(context);
        this.cvB = true;
    }

    public TbListTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvB = true;
    }

    public TbListTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvB = true;
    }

    public void setCheckSelection(boolean z) {
        this.cvB = z;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.cvB) {
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
            aj(i, i2);
        }
    }

    private void aj(int i, int i2) {
        CharSequence text = getText();
        if (text instanceof Spanned) {
            a(new SpannableStringBuilder(text), i, i2);
        } else {
            ak(i, i2);
        }
    }

    private void a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        a b = b(spannableStringBuilder, i, i2);
        if (b.cvC) {
            a(i, i2, spannableStringBuilder, b);
        } else {
            ak(i, i2);
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
                a((CharSequence) spannableStringBuilder, i, i2);
                return a.d(arrayList, arrayList2);
            } catch (IndexOutOfBoundsException e) {
                BdLog.e(e.getMessage());
            }
        }
        return a.arc();
    }

    private boolean b(CharSequence charSequence, int i) {
        return charSequence == null || i < 0 || i >= charSequence.length() || charSequence.charAt(i) != ' ';
    }

    private void a(CharSequence charSequence, int i, int i2) {
        setText(charSequence);
        super.onMeasure(i, i2);
    }

    private void a(int i, int i2, SpannableStringBuilder spannableStringBuilder, a aVar) {
        for (Object obj : aVar.cvE) {
            int spanEnd = spannableStringBuilder.getSpanEnd(obj);
            spannableStringBuilder.delete(spanEnd, spanEnd + 1);
            try {
                a((CharSequence) spannableStringBuilder, i, i2);
            } catch (IndexOutOfBoundsException e) {
                spannableStringBuilder.insert(spanEnd, " ");
            }
        }
        boolean z = true;
        for (Object obj2 : aVar.cvD) {
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

    private void ak(int i, int i2) {
        a(getText().toString(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public final boolean cvC;
        public final List<Object> cvD;
        public final List<Object> cvE;

        public static a d(List<Object> list, List<Object> list2) {
            return new a(true, list, list2);
        }

        public static a arc() {
            return new a(false, null, null);
        }

        private a(boolean z, List<Object> list, List<Object> list2) {
            this.cvC = z;
            this.cvD = list;
            this.cvE = list2;
        }
    }
}
