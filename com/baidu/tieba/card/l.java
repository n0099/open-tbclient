package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    public static void BB(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.KZ(str)) {
            readThreadHistory.KX(str);
        }
    }

    public static boolean BC(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.KY(str)) ? false : true;
    }

    public static String bEP() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String aKq() {
        return "personalize_page";
    }

    public static String bEQ() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (BC(str)) {
                am.setViewTextColor(textView, i2);
            } else {
                am.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bj bjVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !aq.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bjVar != null && bjVar.aKz() == 0) {
            if (z || bjVar.aKT() == 1 || StringUtils.isNull(bjVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> aLv = bjVar.aLv();
                if (!com.baidu.tbadk.core.util.v.isEmpty(aLv)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < aLv.size(); i++) {
                        if (aLv.get(i) != null && !StringUtils.isNull(aLv.get(i).getText())) {
                            sb.append(aLv.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < aLv.size(); i3++) {
                        if (aLv.get(i3) != null && !StringUtils.isNull(aLv.get(i3).getText())) {
                            int length = aLv.get(i3).getText().length();
                            a(spannableString, aLv.get(i3), i2, length);
                            i2 += length;
                        }
                    }
                    spannableStringBuilder.insert(0, (CharSequence) spannableString);
                }
            }
        }
    }

    private static void a(SpannableString spannableString, com.baidu.tbadk.widget.richText.b bVar, int i, int i2) {
        if (spannableString != null && bVar != null && i + i2 <= spannableString.length()) {
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(bVar), i, i + i2, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(bVar.textSize), i, i + i2, 33);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Zv;
        public int gpl;
        public String gpm;
        public int gpn;
        public int gpo;

        public a(int i, int i2, int i3) {
            this.gpl = -1;
            this.gpm = "";
            this.Zv = R.color.cp_link_tip_c;
            this.gpn = R.drawable.pic_dot_title;
            this.gpo = 0;
            this.gpl = i;
            this.Zv = i2;
            this.gpn = i3;
        }

        public a(int i) {
            this.gpl = -1;
            this.gpm = "";
            this.Zv = R.color.cp_link_tip_c;
            this.gpn = R.drawable.pic_dot_title;
            this.gpo = 0;
            this.gpl = i;
        }

        public a(String str) {
            this.gpl = -1;
            this.gpm = "";
            this.Zv = R.color.cp_link_tip_c;
            this.gpn = R.drawable.pic_dot_title;
            this.gpo = 0;
            this.gpm = str;
        }

        public a(String str, int i) {
            this.gpl = -1;
            this.gpm = "";
            this.Zv = R.color.cp_link_tip_c;
            this.gpn = R.drawable.pic_dot_title;
            this.gpo = 0;
            this.gpm = str;
            this.gpn = i;
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
                if (aVar.gpl > 0) {
                    aVar.gpm = context.getString(aVar.gpl);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.gpm)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.gpm);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Zv)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.gpn);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.j jVar = new com.baidu.tbadk.core.view.j(bitmapDrawable);
                    if (aVar.gpo != 0) {
                        jVar.setOffset(aVar.gpo);
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

    public static void a(bj bjVar, TextView textView) {
        if ((StringUtils.isNull(bjVar.getTitle()) && (bjVar.aKC() == null || bjVar.aKC().size() == 0)) || bjVar.aKT() == 1) {
            bjVar.s(false, true);
            if (bjVar.aLl() == null || StringUtils.isNull(bjVar.aLl().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bjVar.aLl());
            return;
        }
        textView.setVisibility(0);
        bjVar.drq = 0;
        bjVar.s(false, true);
        SpannableStringBuilder aLl = bjVar.aLl();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(aLl));
        textView.setText(aLl);
        a(textView, bjVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    /* renamed from: do  reason: not valid java name */
    public static SpannableStringBuilder m33do(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
