package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class au {
    public static void hb(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory()) != null && !readThreadHistory.oe(str)) {
            readThreadHistory.oc(str);
        }
    }

    public static boolean hc(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory()) == null || !readThreadHistory.od(str)) ? false : true;
    }

    public static String Ka() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String Kb() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hc(str)) {
                com.baidu.tbadk.core.util.at.j((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.at.j((View) textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.at.cA(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, t.d.cp_link_tip_a, t.f.pic_dot_title);
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, ArrayList<Integer> arrayList, int i, int i2, int i3) {
        int length;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String str = "";
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                String str2 = String.valueOf(str) + context.getString(arrayList.get(i4).intValue()) + " ";
                arrayList2.add(context.getString(arrayList.get(i4).intValue()));
                i4++;
                str = str2;
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(str) + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(i2)), 0, str.length(), 17);
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            if (arrayList2.get(i6) != null) {
                Bitmap cA = com.baidu.tbadk.core.util.at.cA(i3);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
                if (cA != null) {
                    bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
                }
                com.baidu.tbadk.core.view.ah ahVar = new com.baidu.tbadk.core.view.ah(bitmapDrawable);
                if (i6 == 0) {
                    length = ((String) arrayList2.get(i6)).length();
                } else {
                    length = ((String) arrayList2.get(i6)).length() + 1 + i5;
                }
                spannableStringBuilder.setSpan(ahVar, length, length + 1, 33);
                i5 = length;
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, ArrayList<Integer> arrayList, int i) {
        return a(context, charSequence, arrayList, i, t.d.cp_link_tip_a, t.f.pic_dot_title);
    }

    public static SpannableStringBuilder b(Context context, CharSequence charSequence, ArrayList<Integer> arrayList, int i) {
        return a(context, charSequence, arrayList, i, t.d.cp_other_b, t.f.pic_dot_title_red);
    }
}
