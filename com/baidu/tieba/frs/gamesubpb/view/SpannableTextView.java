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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.a;
/* loaded from: classes3.dex */
public class SpannableTextView extends TextView {
    private long cbN;
    private a.InterfaceC0156a dPB;
    private int dQA;
    private boolean dQB;
    private int dQv;
    private int dQw;
    private int dQx;
    private int dQy;
    private int dQz;

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
        this.cbN = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.dQA = (l.ao(getContext()) - (getResources().getDimensionPixelSize(d.e.ds34) * 2)) - 20;
        onChangeSkinType();
    }

    public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        setText(g(dVar));
        setMovementMethod(a.ayx());
    }

    public void setClickListener(a.InterfaceC0156a interfaceC0156a) {
        this.dPB = interfaceC0156a;
    }

    private SpannableString g(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        String str;
        int i;
        int length = "  楼主".length();
        int length2 = ": ".length();
        String str2 = dVar.userName;
        int length3 = str2 != null ? str2.length() : 0;
        String str3 = dVar.dQb ? dVar.userName + "  楼主: " : dVar.userName + ": ";
        String str4 = dVar.content;
        int length4 = str4 != null ? str4.length() : 0;
        if ((lW(new StringBuilder().append(str3).append(str4).toString()) % this.dQA) + lW(new StringBuilder().append("|").append(dVar.dPT).toString()) >= this.dQA) {
            str = "\n" + dVar.dPT;
        } else {
            str = " " + dVar.dPT;
        }
        int length5 = str != null ? str.length() : 0;
        boolean equals = String.valueOf(this.cbN).equals(dVar.userId);
        String str5 = "|  删除";
        if (equals) {
            if (lW("|  删除") + (lW(new StringBuilder().append(str3).append(str4).append(str).toString()) % this.dQA) >= this.dQA) {
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
        if (dVar.dQb) {
            i = i2 + length;
            spannableString.setSpan(new ForegroundColorSpan(this.dQw), i2, i, 17);
        } else {
            i = i2;
        }
        int i3 = i + length2 + length4;
        int i4 = i3 + length5;
        spannableString.setSpan(new ForegroundColorSpan(this.dQx), i3, i4, 17);
        if (equals) {
            int i5 = i4 + length6;
            spannableString.setSpan(new b(dVar), i4, i5, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.dQz), i5, i5 + length7, 17);
        }
        return spannableString;
    }

    private int lW(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        Rect rect = new Rect();
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends ClickableSpan {
        private com.baidu.tieba.frs.gamesubpb.model.d dQD;

        public c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dQD = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.dQv);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.dPB != null) {
                SpannableTextView.this.dPB.a(this.dQD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends ClickableSpan {
        private com.baidu.tieba.frs.gamesubpb.model.d dQD;

        public b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dQD = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.dQy);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.dPB != null) {
                SpannableTextView.this.dPB.b(this.dQD);
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.dQB) {
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dQB = false;
        return super.onTouchEvent(motionEvent);
    }

    public void onChangeSkinType() {
        this.dQv = aj.getColor(d.C0141d.cp_link_tip_c);
        this.dQw = aj.getColor(d.C0141d.cp_link_tip_a);
        this.dQx = aj.getColor(d.C0141d.cp_cont_d);
        this.dQy = aj.getColor(d.C0141d.cp_link_tip_c);
        this.dQz = aj.getColor(d.C0141d.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends LinkMovementMethod {
        private static a dQC;

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
                        ((SpannableTextView) textView).dQB = true;
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
                super.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }

        public static a ayx() {
            if (dQC == null) {
                dQC = new a();
            }
            return dQC;
        }
    }
}
