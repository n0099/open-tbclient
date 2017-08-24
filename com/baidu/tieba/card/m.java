package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void jh(String str) {
        com.baidu.tieba.tbadkCore.util.f readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.st(str)) {
            readThreadHistory.sr(str);
        }
    }

    public static boolean ji(String str) {
        com.baidu.tieba.tbadkCore.util.f readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.ss(str)) ? false : true;
    }

    public static String WL() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rx() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (ji(str)) {
                ai.i(textView, i2);
            } else {
                ai.i(textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, ai.cS(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.e.cp_link_tip_a, d.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bIf;
        public String bIg;
        public int bIh;
        public int bIi;
        public int bIj;

        public a(int i, int i2, int i3) {
            this.bIf = -1;
            this.bIg = "";
            this.bIh = d.e.cp_link_tip_c;
            this.bIi = d.g.pic_dot_title;
            this.bIj = 0;
            this.bIf = i;
            this.bIh = i2;
            this.bIi = i3;
        }

        public a(int i) {
            this.bIf = -1;
            this.bIg = "";
            this.bIh = d.e.cp_link_tip_c;
            this.bIi = d.g.pic_dot_title;
            this.bIj = 0;
            this.bIf = i;
        }

        public a(String str) {
            this.bIf = -1;
            this.bIg = "";
            this.bIh = d.e.cp_link_tip_c;
            this.bIi = d.g.pic_dot_title;
            this.bIj = 0;
            this.bIg = str;
        }

        public a(String str, int i) {
            this.bIf = -1;
            this.bIg = "";
            this.bIh = d.e.cp_link_tip_c;
            this.bIi = d.g.pic_dot_title;
            this.bIj = 0;
            this.bIg = str;
            this.bIi = i;
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
                if (aVar.bIf > 0) {
                    aVar.bIg = context.getString(aVar.bIf);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bIg)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bIg);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(aVar.bIh)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cS = ai.cS(aVar.bIi);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cS);
                    if (cS != null) {
                        bitmapDrawable.setBounds(0, 0, cS.getWidth(), cS.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.bIj != 0) {
                        mVar.setOffset(aVar.bIj);
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

    public static void a(bl blVar, TextView textView) {
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rE() == null || blVar.rE().size() == 0)) || blVar.rV() == 1) {
            blVar.b(false, true, false);
            if (blVar.sg() == null || StringUtils.isNull(blVar.sg().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(blVar.sg());
            return;
        }
        textView.setVisibility(0);
        blVar.Zr = 0;
        blVar.b(false, true, false);
        SpannableStringBuilder sg = blVar.sg();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(sg));
        textView.setText(sg);
        a(textView, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void b(bl blVar, TextView textView) {
        if ((StringUtils.isNull(blVar.getTitle()) && (blVar.rE() == null || blVar.rE().size() == 0)) || blVar.rV() == 1) {
            blVar.e(false, true);
            if (blVar.sg() == null || StringUtils.isNull(blVar.sg().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(blVar.sg());
            return;
        }
        textView.setVisibility(0);
        blVar.Zr = 0;
        blVar.e(false, true);
        SpannableStringBuilder sg = blVar.sg();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(sg));
        textView.setText(sg);
        a(textView, blVar.getId(), d.e.cp_cont_b, d.e.cp_cont_d);
    }

    public static void a(Context context, bl blVar, TextView textView) {
        String string;
        if (context != null && blVar != null) {
            if (StringUtils.isNull(blVar.rL())) {
                string = "吧";
            } else {
                string = context.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(blVar.rL(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            ai.i(textView, d.e.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aG(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
