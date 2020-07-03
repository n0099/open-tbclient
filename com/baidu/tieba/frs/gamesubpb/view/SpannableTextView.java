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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes9.dex */
public class SpannableTextView extends TextView {
    private long fsA;
    private a.InterfaceC0624a hQA;
    private boolean hRA;
    private int hRu;
    private int hRv;
    private int hRw;
    private int hRx;
    private int hRy;
    private int hRz;

    public SpannableTextView(Context context) {
        super(context);
        init();
    }

    public SpannableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SpannableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fsA = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.hRz = (l.getEquipmentWidth(getContext()) - (getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) - 20;
        onChangeSkinType();
    }

    public void f(d dVar) {
        setText(g(dVar));
        setMovementMethod(a.ccQ());
    }

    public void setClickListener(a.InterfaceC0624a interfaceC0624a) {
        this.hQA = interfaceC0624a;
    }

    private SpannableString g(d dVar) {
        String str;
        int i;
        int length = "  楼主".length();
        int length2 = ": ".length();
        String str2 = dVar.userName;
        int length3 = str2 != null ? str2.length() : 0;
        String str3 = dVar.hRa ? dVar.userName + "  楼主: " : dVar.userName + ": ";
        String str4 = dVar.content;
        int length4 = str4 != null ? str4.length() : 0;
        if ((Fp(new StringBuilder().append(str3).append(str4).toString()) % this.hRz) + Fp(new StringBuilder().append("|").append(dVar.hQS).toString()) >= this.hRz) {
            str = "\n" + dVar.hQS;
        } else {
            str = " " + dVar.hQS;
        }
        int length5 = str != null ? str.length() : 0;
        boolean equals = String.valueOf(this.fsA).equals(dVar.userId);
        String str5 = "|  删除";
        if (equals) {
            if (Fp("|  删除") + (Fp(new StringBuilder().append(str3).append(str4).append(str).toString()) % this.hRz) >= this.hRz) {
                str5 = "\n删除";
            } else {
                str5 = "  删除";
            }
        }
        int length6 = str5.length();
        int length7 = "|".length();
        StringBuilder append = new StringBuilder().append(str3).append(str4).append(str);
        if (!equals) {
            str5 = "";
        }
        SpannableString spannableString = new SpannableString(append.append(str5).append(equals ? "|" : "").toString());
        int i2 = 0 + length3;
        spannableString.setSpan(new c(dVar), 0, i2, 17);
        if (dVar.hRa) {
            i = i2 + length;
            spannableString.setSpan(new ForegroundColorSpan(this.hRv), i2, i, 17);
        } else {
            i = i2;
        }
        int i3 = i + length2 + length4;
        int i4 = i3 + length5;
        spannableString.setSpan(new ForegroundColorSpan(this.hRw), i3, i4, 17);
        if (equals) {
            int i5 = i4 + length6;
            spannableString.setSpan(new b(dVar), i4, i5, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.hRy), i5, i5 + length7, 17);
        }
        return spannableString;
    }

    private int Fp(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class c extends ClickableSpan {
        private d hRC;

        public c(d dVar) {
            this.hRC = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.hRu);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.hQA != null) {
                SpannableTextView.this.hQA.a(this.hRC);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends ClickableSpan {
        private d hRC;

        public b(d dVar) {
            this.hRC = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.hRx);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.hQA != null) {
                SpannableTextView.this.hQA.b(this.hRC);
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.hRA) {
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.hRA = false;
        return super.onTouchEvent(motionEvent);
    }

    public void onChangeSkinType() {
        this.hRu = an.getColor(R.color.cp_link_tip_c);
        this.hRv = an.getColor(R.color.cp_link_tip_a);
        this.hRw = an.getColor(R.color.cp_cont_d);
        this.hRx = an.getColor(R.color.cp_link_tip_c);
        this.hRy = an.getColor(R.color.cp_bg_line_d);
    }

    /* loaded from: classes9.dex */
    private static class a extends LinkMovementMethod {
        private static a hRB;

        private a() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
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
                        ((SpannableTextView) textView).hRA = true;
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
                super.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }

        public static a ccQ() {
            if (hRB == null) {
                hRB = new a();
            }
            return hRB;
        }
    }
}
