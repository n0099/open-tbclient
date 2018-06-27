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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.gamesubpb.a;
/* loaded from: classes3.dex */
public class SpannableTextView extends TextView {
    private long bvG;
    private a.InterfaceC0157a dxv;
    private int dyp;
    private int dyq;
    private int dyr;
    private int dys;
    private int dyt;
    private int dyu;
    private boolean dyv;

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
        this.bvG = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.dyu = (l.ah(getContext()) - (getResources().getDimensionPixelSize(d.e.ds34) * 2)) - 20;
        onChangeSkinType();
    }

    public void f(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        setText(g(dVar));
        setMovementMethod(a.axX());
    }

    public void setClickListener(a.InterfaceC0157a interfaceC0157a) {
        this.dxv = interfaceC0157a;
    }

    private SpannableString g(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
        String str;
        int i;
        int length = "  楼主".length();
        int length2 = ": ".length();
        String str2 = dVar.userName;
        int length3 = str2 != null ? str2.length() : 0;
        String str3 = dVar.dxV ? dVar.userName + "  楼主: " : dVar.userName + ": ";
        String str4 = dVar.content;
        int length4 = str4 != null ? str4.length() : 0;
        if ((mK(new StringBuilder().append(str3).append(str4).toString()) % this.dyu) + mK(new StringBuilder().append("|").append(dVar.dxN).toString()) >= this.dyu) {
            str = "\n" + dVar.dxN;
        } else {
            str = " " + dVar.dxN;
        }
        int length5 = str != null ? str.length() : 0;
        boolean equals = String.valueOf(this.bvG).equals(dVar.userId);
        String str5 = "|  删除";
        if (equals) {
            if (mK("|  删除") + (mK(new StringBuilder().append(str3).append(str4).append(str).toString()) % this.dyu) >= this.dyu) {
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
        if (dVar.dxV) {
            i = i2 + length;
            spannableString.setSpan(new ForegroundColorSpan(this.dyq), i2, i, 17);
        } else {
            i = i2;
        }
        int i3 = i + length2 + length4;
        int i4 = i3 + length5;
        spannableString.setSpan(new ForegroundColorSpan(this.dyr), i3, i4, 17);
        if (equals) {
            int i5 = i4 + length6;
            spannableString.setSpan(new b(dVar), i4, i5, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.dyt), i5, i5 + length7, 17);
        }
        return spannableString;
    }

    private int mK(String str) {
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
        private com.baidu.tieba.frs.gamesubpb.model.d dyx;

        public c(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dyx = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.dyp);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.dxv != null) {
                SpannableTextView.this.dxv.a(this.dyx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends ClickableSpan {
        private com.baidu.tieba.frs.gamesubpb.model.d dyx;

        public b(com.baidu.tieba.frs.gamesubpb.model.d dVar) {
            this.dyx = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.dys);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.dxv != null) {
                SpannableTextView.this.dxv.b(this.dyx);
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.dyv) {
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dyv = false;
        return super.onTouchEvent(motionEvent);
    }

    public void onChangeSkinType() {
        this.dyp = am.getColor(d.C0142d.cp_link_tip_c);
        this.dyq = am.getColor(d.C0142d.cp_link_tip_a);
        this.dyr = am.getColor(d.C0142d.cp_cont_d);
        this.dys = am.getColor(d.C0142d.cp_link_tip_c);
        this.dyt = am.getColor(d.C0142d.cp_bg_line_d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends LinkMovementMethod {
        private static a dyw;

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
                        ((SpannableTextView) textView).dyv = true;
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
                super.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }

        public static a axX() {
            if (dyw == null) {
                dyw = new a();
            }
            return dyw;
        }
    }
}
