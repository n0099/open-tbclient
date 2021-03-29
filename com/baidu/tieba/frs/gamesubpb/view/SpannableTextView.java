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
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.p0.w1.a;
import d.b.i0.p0.w1.d.d;
/* loaded from: classes4.dex */
public class SpannableTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f16431e;

    /* renamed from: f  reason: collision with root package name */
    public int f16432f;

    /* renamed from: g  reason: collision with root package name */
    public int f16433g;

    /* renamed from: h  reason: collision with root package name */
    public int f16434h;
    public int i;
    public long j;
    public int k;
    public boolean l;
    public a.InterfaceC1444a m;

    /* loaded from: classes4.dex */
    public static class a extends LinkMovementMethod {

        /* renamed from: a  reason: collision with root package name */
        public static a f16435a;

        public static a a() {
            if (f16435a == null) {
                f16435a = new a();
            }
            return f16435a;
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
        public d f16436e;

        public b(d dVar) {
            this.f16436e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.m != null) {
                SpannableTextView.this.m.b(this.f16436e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.f16434h);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public d f16438e;

        public c(d dVar) {
            this.f16438e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.m != null) {
                SpannableTextView.this.m.c(this.f16438e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.f16431e);
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
        String str3 = dVar.f58692h;
        int length = str3 != null ? str3.length() : 0;
        if (dVar.k) {
            str = dVar.f58692h + "  楼主: ";
        } else {
            str = dVar.f58692h + ": ";
        }
        String str4 = dVar.i;
        int length2 = str4 != null ? str4.length() : 0;
        int f2 = f(str + str4);
        StringBuilder sb = new StringBuilder();
        String str5 = FieldBuilder.SE;
        sb.append(FieldBuilder.SE);
        sb.append(dVar.j);
        int f3 = f(sb.toString());
        int i = this.k;
        if ((f2 % i) + f3 >= i) {
            str2 = "\n" + dVar.j;
        } else {
            str2 = " " + dVar.j;
        }
        int length3 = str2 != null ? str2.length() : 0;
        boolean equals = String.valueOf(this.j).equals(dVar.f58691g);
        String str6 = "|  删除";
        if (equals) {
            int f4 = f(str + str4 + str2);
            int f5 = f("|  删除");
            int i2 = this.k;
            str6 = (f4 % i2) + f5 >= i2 ? "\n删除" : "  删除";
        }
        int length4 = str6.length();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str4);
        sb2.append(str2);
        if (!equals) {
            str6 = "";
        }
        sb2.append(str6);
        if (!equals) {
            str5 = "";
        }
        sb2.append(str5);
        SpannableString spannableString = new SpannableString(sb2.toString());
        int i3 = length + 0;
        spannableString.setSpan(new c(dVar), 0, i3, 17);
        if (dVar.k) {
            int i4 = i3 + 4;
            spannableString.setSpan(new ForegroundColorSpan(this.f16432f), i3, i4, 17);
            i3 = i4;
        }
        int i5 = i3 + 2 + length2;
        int i6 = length3 + i5;
        spannableString.setSpan(new ForegroundColorSpan(this.f16433g), i5, i6, 17);
        if (equals) {
            int i7 = length4 + i6;
            spannableString.setSpan(new b(dVar), i6, i7, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.i), i7, i7 + 1, 17);
        }
        return spannableString;
    }

    public final void h() {
        this.j = d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.k = (l.k(getContext()) - (getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) - 20;
        i();
    }

    public void i() {
        this.f16431e = SkinManager.getColor(R.color.CAM_X0304);
        this.f16432f = SkinManager.getColor(R.color.CAM_X0302);
        this.f16433g = SkinManager.getColor(R.color.CAM_X0109);
        this.f16434h = SkinManager.getColor(R.color.CAM_X0304);
        this.i = SkinManager.getColor(R.color.CAM_X0201);
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

    public void setClickListener(a.InterfaceC1444a interfaceC1444a) {
        this.m = interfaceC1444a;
    }

    public SpannableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public SpannableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }
}
