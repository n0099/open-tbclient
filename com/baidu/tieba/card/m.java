package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void ju(String str) {
        com.baidu.tieba.tbadkCore.util.f readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.sq(str)) {
            readThreadHistory.so(str);
        }
    }

    public static boolean jv(String str) {
        com.baidu.tieba.tbadkCore.util.f readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.sp(str)) ? false : true;
    }

    public static String Ya() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rs() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (jv(str)) {
                aj.i(textView, i2);
            } else {
                aj.i(textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, aj.cT(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.e.cp_link_tip_a, d.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bLQ;
        public String bLR;
        public int bLS;
        public int bLT;
        public int bLU;

        public a(int i, int i2, int i3) {
            this.bLQ = -1;
            this.bLR = "";
            this.bLS = d.e.cp_link_tip_c;
            this.bLT = d.g.pic_dot_title;
            this.bLU = 0;
            this.bLQ = i;
            this.bLS = i2;
            this.bLT = i3;
        }

        public a(int i) {
            this.bLQ = -1;
            this.bLR = "";
            this.bLS = d.e.cp_link_tip_c;
            this.bLT = d.g.pic_dot_title;
            this.bLU = 0;
            this.bLQ = i;
        }

        public a(String str) {
            this.bLQ = -1;
            this.bLR = "";
            this.bLS = d.e.cp_link_tip_c;
            this.bLT = d.g.pic_dot_title;
            this.bLU = 0;
            this.bLR = str;
        }

        public a(String str, int i) {
            this.bLQ = -1;
            this.bLR = "";
            this.bLS = d.e.cp_link_tip_c;
            this.bLT = d.g.pic_dot_title;
            this.bLU = 0;
            this.bLR = str;
            this.bLT = i;
        }
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z) {
        return a(context, str, arrayList, z, true);
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z, boolean z2) {
        if (str == null || context == null || arrayList == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i != arrayList.size(); i++) {
            a aVar = arrayList.get(i);
            if (aVar != null) {
                if (aVar.bLQ > 0) {
                    aVar.bLR = context.getString(aVar.bLQ);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bLR)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bLR);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(aVar.bLS)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cT = aj.cT(aVar.bLT);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cT);
                    if (cT != null) {
                        bitmapDrawable.setBounds(0, 0, cT.getWidth(), cT.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.bLU != 0) {
                        mVar.setOffset(aVar.bLU);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(mVar, length2, spannableStringBuilder.length(), 17);
                } else {
                    continue;
                }
            }
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }

    public static void a(bj bjVar, TextView textView) {
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.rz() == null || bjVar.rz().size() == 0)) || bjVar.rQ() == 1) {
            bjVar.b(false, true, false);
            if (bjVar.sb() == null || StringUtils.isNull(bjVar.sb().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bjVar.sb());
            return;
        }
        textView.setVisibility(0);
        bjVar.Yv = 0;
        bjVar.b(false, true, false);
        SpannableStringBuilder sb = bjVar.sb();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(sb));
        textView.setText(sb);
        a(textView, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void b(bj bjVar, TextView textView) {
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.rz() == null || bjVar.rz().size() == 0)) || bjVar.rQ() == 1) {
            bjVar.e(false, true);
            if (bjVar.sb() == null || StringUtils.isNull(bjVar.sb().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bjVar.sb());
            return;
        }
        textView.setVisibility(0);
        bjVar.Yv = 0;
        bjVar.e(false, true);
        SpannableStringBuilder sb = bjVar.sb();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(sb));
        textView.setText(sb);
        a(textView, bjVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void a(Context context, bj bjVar, TextView textView) {
        String string;
        if (context != null && bjVar != null) {
            if (StringUtils.isNull(bjVar.rG())) {
                string = "吧";
            } else {
                string = context.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bjVar.rG(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            aj.i(textView, d.e.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aK(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
