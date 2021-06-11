package com.baidu.tieba.frs.gamesubpb.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r0.w1.a;
import d.a.n0.r0.w1.d.d;
/* loaded from: classes4.dex */
public class SpannableTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f15584e;

    /* renamed from: f  reason: collision with root package name */
    public int f15585f;

    /* renamed from: g  reason: collision with root package name */
    public int f15586g;

    /* renamed from: h  reason: collision with root package name */
    public int f15587h;

    /* renamed from: i  reason: collision with root package name */
    public int f15588i;
    public long j;
    public int k;
    public boolean l;
    public a.InterfaceC1612a m;

    /* loaded from: classes4.dex */
    public static class a extends LinkMovementMethod {

        /* renamed from: a  reason: collision with root package name */
        public static a f15589a;

        public static a a() {
            if (f15589a == null) {
                f15589a = new a();
            }
            return f15589a;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1 && action != 0) {
                return Touch.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (action == 1) {
                    objArr[0].onClick(textView);
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                }
                if (textView instanceof SpannableTextView) {
                    ((SpannableTextView) textView).l = true;
                }
                return true;
            }
            Selection.removeSelection(spannable);
            super.onTouchEvent(textView, spannable, motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public d f15590e;

        public b(d dVar) {
            this.f15590e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.m != null) {
                SpannableTextView.this.m.a(this.f15590e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.f15587h);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public d f15592e;

        public c(d dVar) {
            this.f15592e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.m != null) {
                SpannableTextView.this.m.b(this.f15592e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.f15584e);
            textPaint.setUnderlineText(false);
        }
    }

    public SpannableTextView(Context context) {
        super(context);
        h();
    }

    public void e(d dVar) {
        setText(g(dVar));
        setMovementMethod(a.a());
    }

    public final int f(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    public final SpannableString g(d dVar) {
        String str;
        String str2;
        String str3 = dVar.f63467h;
        int length = str3 != null ? str3.length() : 0;
        if (dVar.k) {
            str = dVar.f63467h + "  楼主: ";
        } else {
            str = dVar.f63467h + ": ";
        }
        String str4 = dVar.f63468i;
        int length2 = str4 != null ? str4.length() : 0;
        int f2 = f(str + str4);
        int f3 = f("|" + dVar.j);
        int i2 = this.k;
        if ((f2 % i2) + f3 >= i2) {
            str2 = "\n" + dVar.j;
        } else {
            str2 = " " + dVar.j;
        }
        int length3 = str2 != null ? str2.length() : 0;
        boolean equals = String.valueOf(this.j).equals(dVar.f63466g);
        String str5 = "|  删除";
        if (equals) {
            int f4 = f(str + str4 + str2);
            int f5 = f("|  删除");
            int i3 = this.k;
            str5 = (f4 % i3) + f5 >= i3 ? "\n删除" : "  删除";
        }
        int length4 = str5.length();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str4);
        sb.append(str2);
        if (!equals) {
            str5 = "";
        }
        sb.append(str5);
        sb.append(equals ? "|" : "");
        SpannableString spannableString = new SpannableString(sb.toString());
        int i4 = length + 0;
        spannableString.setSpan(new c(dVar), 0, i4, 17);
        if (dVar.k) {
            int i5 = i4 + 4;
            spannableString.setSpan(new ForegroundColorSpan(this.f15585f), i4, i5, 17);
            i4 = i5;
        }
        int i6 = i4 + 2 + length2;
        int i7 = length3 + i6;
        spannableString.setSpan(new ForegroundColorSpan(this.f15586g), i6, i7, 17);
        if (equals) {
            int i8 = length4 + i7;
            spannableString.setSpan(new b(dVar), i7, i8, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.f15588i), i8, i8 + 1, 17);
        }
        return spannableString;
    }

    public final void h() {
        this.j = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.k = (l.k(getContext()) - (getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) - 20;
        i();
    }

    public void i() {
        this.f15584e = SkinManager.getColor(R.color.CAM_X0304);
        this.f15585f = SkinManager.getColor(R.color.CAM_X0302);
        this.f15586g = SkinManager.getColor(R.color.CAM_X0109);
        this.f15587h = SkinManager.getColor(R.color.CAM_X0304);
        this.f15588i = SkinManager.getColor(R.color.CAM_X0201);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.l = false;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.l) {
            return true;
        }
        return super.performClick();
    }

    public void setClickListener(a.InterfaceC1612a interfaceC1612a) {
        this.m = interfaceC1612a;
    }

    public SpannableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public SpannableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h();
    }
}
