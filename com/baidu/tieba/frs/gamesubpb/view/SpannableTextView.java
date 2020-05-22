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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes9.dex */
public class SpannableTextView extends TextView {
    private long fhb;
    private a.InterfaceC0616a hCF;
    private int hDA;
    private int hDB;
    private int hDC;
    private int hDD;
    private int hDE;
    private boolean hDF;
    private int hDz;

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
        this.fhb = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), -1L);
        this.hDE = (l.getEquipmentWidth(getContext()) - (getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) - 20;
        onChangeSkinType();
    }

    public void f(d dVar) {
        setText(g(dVar));
        setMovementMethod(a.bZv());
    }

    public void setClickListener(a.InterfaceC0616a interfaceC0616a) {
        this.hCF = interfaceC0616a;
    }

    private SpannableString g(d dVar) {
        String str;
        int i;
        int length = "  楼主".length();
        int length2 = ": ".length();
        String str2 = dVar.userName;
        int length3 = str2 != null ? str2.length() : 0;
        String str3 = dVar.hDf ? dVar.userName + "  楼主: " : dVar.userName + ": ";
        String str4 = dVar.content;
        int length4 = str4 != null ? str4.length() : 0;
        if ((EO(new StringBuilder().append(str3).append(str4).toString()) % this.hDE) + EO(new StringBuilder().append("|").append(dVar.hCX).toString()) >= this.hDE) {
            str = "\n" + dVar.hCX;
        } else {
            str = " " + dVar.hCX;
        }
        int length5 = str != null ? str.length() : 0;
        boolean equals = String.valueOf(this.fhb).equals(dVar.userId);
        String str5 = "|  删除";
        if (equals) {
            if (EO("|  删除") + (EO(new StringBuilder().append(str3).append(str4).append(str).toString()) % this.hDE) >= this.hDE) {
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
        if (dVar.hDf) {
            i = i2 + length;
            spannableString.setSpan(new ForegroundColorSpan(this.hDA), i2, i, 17);
        } else {
            i = i2;
        }
        int i3 = i + length2 + length4;
        int i4 = i3 + length5;
        spannableString.setSpan(new ForegroundColorSpan(this.hDB), i3, i4, 17);
        if (equals) {
            int i5 = i4 + length6;
            spannableString.setSpan(new b(dVar), i4, i5, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.hDD), i5, i5 + length7, 17);
        }
        return spannableString;
    }

    private int EO(String str) {
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
        private d hDH;

        public c(d dVar) {
            this.hDH = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.hDz);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.hCF != null) {
                SpannableTextView.this.hCF.a(this.hDH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends ClickableSpan {
        private d hDH;

        public b(d dVar) {
            this.hDH = dVar;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SpannableTextView.this.hDC);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SpannableTextView.this.hCF != null) {
                SpannableTextView.this.hCF.b(this.hDH);
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.hDF) {
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.hDF = false;
        return super.onTouchEvent(motionEvent);
    }

    public void onChangeSkinType() {
        this.hDz = am.getColor(R.color.cp_link_tip_c);
        this.hDA = am.getColor(R.color.cp_link_tip_a);
        this.hDB = am.getColor(R.color.cp_cont_d);
        this.hDC = am.getColor(R.color.cp_link_tip_c);
        this.hDD = am.getColor(R.color.cp_bg_line_d);
    }

    /* loaded from: classes9.dex */
    private static class a extends LinkMovementMethod {
        private static a hDG;

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
                        ((SpannableTextView) textView).hDF = true;
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
                super.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
            return Touch.onTouchEvent(textView, spannable, motionEvent);
        }

        public static a bZv() {
            if (hDG == null) {
                hDG = new a();
            }
            return hDG;
        }
    }
}
