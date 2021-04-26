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
import d.a.c.e.p.l;
import d.a.j0.q0.w1.a;
import d.a.j0.q0.w1.d.d;
/* loaded from: classes4.dex */
public class SpannableTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f16304e;

    /* renamed from: f  reason: collision with root package name */
    public int f16305f;

    /* renamed from: g  reason: collision with root package name */
    public int f16306g;

    /* renamed from: h  reason: collision with root package name */
    public int f16307h;

    /* renamed from: i  reason: collision with root package name */
    public int f16308i;
    public long j;
    public int k;
    public boolean l;
    public a.InterfaceC1469a m;

    /* loaded from: classes4.dex */
    public static class a extends LinkMovementMethod {

        /* renamed from: a  reason: collision with root package name */
        public static a f16309a;

        public static a a() {
            if (f16309a == null) {
                f16309a = new a();
            }
            return f16309a;
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
        public d f16310e;

        public b(d dVar) {
            this.f16310e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.m != null) {
                SpannableTextView.this.m.a(this.f16310e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.f16307h);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public d f16312e;

        public c(d dVar) {
            this.f16312e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.m != null) {
                SpannableTextView.this.m.b(this.f16312e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.f16304e);
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
        String str3 = dVar.f58893h;
        int length = str3 != null ? str3.length() : 0;
        if (dVar.k) {
            str = dVar.f58893h + "  楼主: ";
        } else {
            str = dVar.f58893h + ": ";
        }
        String str4 = dVar.f58894i;
        int length2 = str4 != null ? str4.length() : 0;
        int f2 = f(str + str4);
        StringBuilder sb = new StringBuilder();
        String str5 = FieldBuilder.SE;
        sb.append(FieldBuilder.SE);
        sb.append(dVar.j);
        int f3 = f(sb.toString());
        int i2 = this.k;
        if ((f2 % i2) + f3 >= i2) {
            str2 = "\n" + dVar.j;
        } else {
            str2 = " " + dVar.j;
        }
        int length3 = str2 != null ? str2.length() : 0;
        boolean equals = String.valueOf(this.j).equals(dVar.f58892g);
        String str6 = "|  删除";
        if (equals) {
            int f4 = f(str + str4 + str2);
            int f5 = f("|  删除");
            int i3 = this.k;
            str6 = (f4 % i3) + f5 >= i3 ? "\n删除" : "  删除";
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
        int i4 = length + 0;
        spannableString.setSpan(new c(dVar), 0, i4, 17);
        if (dVar.k) {
            int i5 = i4 + 4;
            spannableString.setSpan(new ForegroundColorSpan(this.f16305f), i4, i5, 17);
            i4 = i5;
        }
        int i6 = i4 + 2 + length2;
        int i7 = length3 + i6;
        spannableString.setSpan(new ForegroundColorSpan(this.f16306g), i6, i7, 17);
        if (equals) {
            int i8 = length4 + i7;
            spannableString.setSpan(new b(dVar), i7, i8, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.f16308i), i8, i8 + 1, 17);
        }
        return spannableString;
    }

    public final void h() {
        this.j = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.k = (l.k(getContext()) - (getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) - 20;
        i();
    }

    public void i() {
        this.f16304e = SkinManager.getColor(R.color.CAM_X0304);
        this.f16305f = SkinManager.getColor(R.color.CAM_X0302);
        this.f16306g = SkinManager.getColor(R.color.CAM_X0109);
        this.f16307h = SkinManager.getColor(R.color.CAM_X0304);
        this.f16308i = SkinManager.getColor(R.color.CAM_X0201);
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

    public void setClickListener(a.InterfaceC1469a interfaceC1469a) {
        this.m = interfaceC1469a;
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
