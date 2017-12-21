package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    public static void jO(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.tp(str)) {
            readThreadHistory.tn(str);
        }
    }

    public static boolean jP(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.to(str)) ? false : true;
    }

    public static String abJ() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rl() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (jP(str)) {
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
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, aj.cR(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.C0095d.cp_link_tip_a, d.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Jr;
        public int caM;
        public String caN;
        public int caO;
        public int caP;

        public a(int i, int i2, int i3) {
            this.caM = -1;
            this.caN = "";
            this.Jr = d.C0095d.cp_link_tip_c;
            this.caO = d.f.pic_dot_title;
            this.caP = 0;
            this.caM = i;
            this.Jr = i2;
            this.caO = i3;
        }

        public a(int i) {
            this.caM = -1;
            this.caN = "";
            this.Jr = d.C0095d.cp_link_tip_c;
            this.caO = d.f.pic_dot_title;
            this.caP = 0;
            this.caM = i;
        }

        public a(String str) {
            this.caM = -1;
            this.caN = "";
            this.Jr = d.C0095d.cp_link_tip_c;
            this.caO = d.f.pic_dot_title;
            this.caP = 0;
            this.caN = str;
        }

        public a(String str, int i) {
            this.caM = -1;
            this.caN = "";
            this.Jr = d.C0095d.cp_link_tip_c;
            this.caO = d.f.pic_dot_title;
            this.caP = 0;
            this.caN = str;
            this.caO = i;
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
                if (aVar.caM > 0) {
                    aVar.caN = context.getString(aVar.caM);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.caN)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.caN);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(aVar.Jr)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cR = aj.cR(aVar.caO);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                    if (cR != null) {
                        bitmapDrawable.setBounds(0, 0, cR.getWidth(), cR.getHeight());
                    }
                    com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                    if (aVar.caP != 0) {
                        jVar.setOffset(aVar.caP);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(jVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rt() == null || bdVar.rt().size() == 0)) || bdVar.rL() == 1) {
            bdVar.b(false, true, false);
            if (bdVar.rV() == null || StringUtils.isNull(bdVar.rV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.rV());
            return;
        }
        textView.setVisibility(0);
        bdVar.YS = 0;
        bdVar.b(false, true, false);
        SpannableStringBuilder rV = bdVar.rV();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(rV));
        textView.setText(rV);
        a(textView, bdVar.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
    }

    public static void b(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rt() == null || bdVar.rt().size() == 0)) || bdVar.rL() == 1) {
            bdVar.e(false, true);
            if (bdVar.rV() == null || StringUtils.isNull(bdVar.rV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.rV());
            return;
        }
        textView.setVisibility(0);
        bdVar.YS = 0;
        bdVar.e(false, true);
        SpannableStringBuilder rV = bdVar.rV();
        textView.setOnTouchListener(new com.baidu.tieba.view.l(rV));
        textView.setText(rV);
        a(textView, bdVar.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
    }

    public static void a(Context context, bd bdVar, TextView textView) {
        String string;
        if (context != null && bdVar != null) {
            if (StringUtils.isNull(bdVar.rB())) {
                string = "吧";
            } else {
                string = context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(bdVar.rB(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            aj.i(textView, d.C0095d.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aH(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0095d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0095d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
