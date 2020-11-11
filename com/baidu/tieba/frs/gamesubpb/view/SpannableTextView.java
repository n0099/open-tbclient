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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes22.dex */
public class SpannableTextView extends TextView {
    private long goC;
    private int iZW;
    private int iZX;
    private int iZY;
    private int iZZ;
    private a.InterfaceC0730a iZc;
    private int jaa;
    private int jab;
    private boolean jac;

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
        this.goC = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.jab = (l.getEquipmentWidth(getContext()) - (getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) - 20;
        onChangeSkinType();
    }

    public void f(d dVar) {
        setText(g(dVar));
        setMovementMethod(a.cDn());
    }

    public void setClickListener(a.InterfaceC0730a interfaceC0730a) {
        this.iZc = interfaceC0730a;
    }

    private SpannableString g(d dVar) {
        String str;
        int i;
        int length = "  楼主".length();
        int length2 = ": ".length();
        String str2 = dVar.userName;
        int length3 = str2 != null ? str2.length() : 0;
        String str3 = dVar.iZC ? dVar.userName + "  楼主: " : dVar.userName + ": ";
        String str4 = dVar.content;
        int length4 = str4 != null ? str4.length() : 0;
        if ((KE(new StringBuilder().append(str3).append(str4).toString()) % this.jab) + KE(new StringBuilder().append("|").append(dVar.iZu).toString()) >= this.jab) {
            str = "\n" + dVar.iZu;
        } else {
            str = " " + dVar.iZu;
        }
        int length5 = str != null ? str.length() : 0;
        boolean equals = String.valueOf(this.goC).equals(dVar.userId);
        String str5 = "|  删除";
        if (equals) {
            if (KE("|  删除") + (KE(new StringBuilder().append(str3).append(str4).append(str).toString()) % this.jab) >= this.jab) {
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
        if (dVar.iZC) {
            i = i2 + length;
            spannableString.setSpan(new ForegroundColorSpan(this.iZX), i2, i, 17);
        } else {
            i = i2;
        }
        int i3 = i + length2 + length4;
        int i4 = i3 + length5;
        spannableString.setSpan(new ForegroundColorSpan(this.iZY), i3, i4, 17);
        if (equals) {
            int i5 = i4 + length6;
            spannableString.setSpan(new b(dVar), i4, i5, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.jaa), i5, i5 + length7, 17);
        }
        return spannableString;
    }

    private int KE(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class c extends ClickableSpan {
        private d jae;

        public c(d dVar) {
            this.jae = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.iZW);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.iZc != null) {
                SpannableTextView.this.iZc.a(this.jae);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class b extends ClickableSpan {
        private d jae;

        public b(d dVar) {
            this.jae = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.iZZ);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.iZc != null) {
                SpannableTextView.this.iZc.b(this.jae);
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.jac) {
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.jac = false;
        return super.onTouchEvent(motionEvent);
    }

    public void onChangeSkinType() {
        this.iZW = ap.getColor(R.color.cp_link_tip_c);
        this.iZX = ap.getColor(R.color.cp_link_tip_a);
        this.iZY = ap.getColor(R.color.cp_cont_d);
        this.iZZ = ap.getColor(R.color.cp_link_tip_c);
        this.jaa = ap.getColor(R.color.cp_bg_line_d);
    }

    /* loaded from: classes22.dex */
    private static class a extends LinkMovementMethod {
        private static a jad;

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
                        ((SpannableTextView) textView).jac = true;
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
                super.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }

        public static a cDn() {
            if (jad == null) {
                jad = new a();
            }
            return jad;
        }
    }
}
