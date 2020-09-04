package com.baidu.tieba.frs.videomiddlepage.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.view.expandable.SpannableClickTextView;
/* loaded from: classes16.dex */
public class a {
    private static final int ixn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds33);

    public static void a(Context context, TextView textView, String str, final String str2, final String str3) {
        int dimens;
        if (context != null && textView != null && !StringUtils.isNull(str)) {
            int color = ap.getColor(R.color.cp_cont_j);
            String str4 = str + "  ";
            TextPaint paint = textView.getPaint();
            int dimens2 = l.getScreenDimensions(context)[0] - (l.getDimens(context, R.dimen.tbds48) * 2);
            int dimens3 = l.getDimens(context, R.dimen.tbds116);
            int textWidth = l.getTextWidth(paint, " 广告");
            int textWidth2 = l.getTextWidth(paint, "...  ");
            int textWidth3 = l.getTextWidth(paint, str4);
            int dimens4 = textWidth3 + dimens3 + textWidth + l.getDimens(context, R.dimen.tbds30);
            if (dimens4 >= dimens2 * 2) {
                str4 = a(paint, str4, ((((dimens2 * 2) - dimens3) - textWidth) - textWidth2) - dimens) + "...  ";
            } else if (dimens4 >= dimens2 && textWidth3 < dimens2 && dimens4 >= dimens2) {
                str4 = str4.trim() + "\n";
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
            SpannableString spannableString = new SpannableString(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            spannableString.setSpan(new C0692a(context, R.drawable.icon_video_middle_ad_link), 0, 1, 17);
            spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.frs.videomiddlepage.b.a.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    if (!StringUtils.isNull(str2)) {
                        aq aqVar = new aq("c13313");
                        aqVar.dD("tid", str3);
                        TiebaStatic.log(aqVar);
                        com.baidu.tbadk.browser.a.startWebActivity(TbadkCoreApplication.getInst().getApplicationContext(), false, str2);
                    }
                }
            }, 0, 1, 17);
            spannableString.setSpan(new BackgroundColorSpan(0), 0, 1, 17);
            SpannableString spannableString2 = new SpannableString(" 广告");
            spannableString2.setSpan(new b(ixn, color), 0, " 广告".length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString).append((CharSequence) spannableString2);
            textView.setHighlightColor(0);
            textView.setText(spannableStringBuilder);
            if (textView instanceof SpannableClickTextView) {
                ((SpannableClickTextView) textView).setCustomMovementMethod();
            } else {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            aq aqVar = new aq("c13312");
            aqVar.dD("tid", str3);
            TiebaStatic.log(aqVar);
        }
    }

    public static String a(Paint paint, String str, int i) {
        String str2 = str;
        for (int length = str.length() - 1; l.getTextWidth(paint, str2) > i && length > 0; length--) {
            str2 = str.substring(0, length);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class b extends ReplacementSpan {
        private int ixp;
        private int ixq;

        public b(int i, int i2) {
            this.ixp = i;
            this.ixq = i2;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return (int) b(paint).measureText(charSequence.subSequence(i, i2).toString());
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            CharSequence subSequence = charSequence.subSequence(i, i2);
            TextPaint b = b(paint);
            Paint.FontMetricsInt fontMetricsInt = b.getFontMetricsInt();
            canvas.drawText(subSequence.toString(), f, i4 - (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - ((i5 + i3) / 2)), b);
        }

        private TextPaint b(Paint paint) {
            TextPaint textPaint = new TextPaint(paint);
            textPaint.setTextSize(this.ixp);
            textPaint.setColor(this.ixq);
            return textPaint;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.videomiddlepage.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0692a extends ImageSpan {
        public C0692a(Context context, int i) {
            super(context, i);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = getDrawable().getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
                int i4 = bounds.bottom - bounds.top;
                int i5 = (i4 / 2) - (i3 / 4);
                int i6 = (i3 / 4) + (i4 / 2);
                fontMetricsInt.ascent = -i6;
                fontMetricsInt.top = -i6;
                fontMetricsInt.bottom = i5;
                fontMetricsInt.descent = i5;
            }
            return bounds.right;
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            canvas.translate(f, (((i5 - i3) - drawable.getBounds().bottom) / 2) + i3);
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}
