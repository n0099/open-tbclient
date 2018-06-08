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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    public static void lb(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.ub(str)) {
            readThreadHistory.tZ(str);
        }
    }

    public static boolean lc(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.ua(str)) ? false : true;
    }

    public static String aiY() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String vb() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (lc(str)) {
                al.h(textView, i2);
            } else {
                al.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int QF;
        public int cyA;
        public String cyB;
        public int cyC;
        public int cyD;

        public a(int i, int i2, int i3) {
            this.cyA = -1;
            this.cyB = "";
            this.QF = d.C0141d.cp_link_tip_c;
            this.cyC = d.f.pic_dot_title;
            this.cyD = 0;
            this.cyA = i;
            this.QF = i2;
            this.cyC = i3;
        }

        public a(int i) {
            this.cyA = -1;
            this.cyB = "";
            this.QF = d.C0141d.cp_link_tip_c;
            this.cyC = d.f.pic_dot_title;
            this.cyD = 0;
            this.cyA = i;
        }

        public a(String str) {
            this.cyA = -1;
            this.cyB = "";
            this.QF = d.C0141d.cp_link_tip_c;
            this.cyC = d.f.pic_dot_title;
            this.cyD = 0;
            this.cyB = str;
        }

        public a(String str, int i) {
            this.cyA = -1;
            this.cyB = "";
            this.QF = d.C0141d.cp_link_tip_c;
            this.cyC = d.f.pic_dot_title;
            this.cyD = 0;
            this.cyB = str;
            this.cyC = i;
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
                if (aVar.cyA > 0) {
                    aVar.cyB = context.getString(aVar.cyA);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cyB)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cyB);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.QF)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cQ = al.cQ(aVar.cyC);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                    if (cQ != null) {
                        bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.cyD != 0) {
                        iVar.setOffset(aVar.cyD);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(iVar, length2, spannableStringBuilder.length(), 17);
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
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.vk() == null || bdVar.vk().size() == 0)) || bdVar.vB() == 1) {
            bdVar.b(false, true, false);
            if (bdVar.vK() == null || StringUtils.isNull(bdVar.vK().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.vK());
            return;
        }
        textView.setVisibility(0);
        bdVar.aia = 0;
        bdVar.b(false, true, false);
        SpannableStringBuilder vK = bdVar.vK();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vK));
        textView.setText(vK);
        a(textView, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
    }

    public static void b(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.vk() == null || bdVar.vk().size() == 0)) || bdVar.vB() == 1) {
            bdVar.e(false, true);
            if (bdVar.vK() == null || StringUtils.isNull(bdVar.vK().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.vK());
            return;
        }
        textView.setVisibility(0);
        bdVar.aia = 0;
        bdVar.e(false, true);
        SpannableStringBuilder vK = bdVar.vK();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(vK));
        textView.setText(vK);
        a(textView, bdVar.getId(), d.C0141d.cp_cont_b, d.C0141d.cp_cont_d);
    }

    public static SpannableStringBuilder aO(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0141d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
