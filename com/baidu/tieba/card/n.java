package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void uz(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Ed(str)) {
            readThreadHistory.Eb(str);
        }
    }

    public static boolean uA(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Ec(str)) ? false : true;
    }

    public static String ban() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String ait() {
        return "personalize_page";
    }

    public static String bao() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (uA(str)) {
                am.setViewTextColor(textView, i2);
            } else {
                am.setViewTextColor(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int DK;
        public int eNc;
        public String eNd;
        public int eNe;
        public int eNf;

        public a(int i, int i2, int i3) {
            this.eNc = -1;
            this.eNd = "";
            this.DK = R.color.cp_link_tip_c;
            this.eNe = R.drawable.pic_dot_title;
            this.eNf = 0;
            this.eNc = i;
            this.DK = i2;
            this.eNe = i3;
        }

        public a(int i) {
            this.eNc = -1;
            this.eNd = "";
            this.DK = R.color.cp_link_tip_c;
            this.eNe = R.drawable.pic_dot_title;
            this.eNf = 0;
            this.eNc = i;
        }

        public a(String str) {
            this.eNc = -1;
            this.eNd = "";
            this.DK = R.color.cp_link_tip_c;
            this.eNe = R.drawable.pic_dot_title;
            this.eNf = 0;
            this.eNd = str;
        }

        public a(String str, int i) {
            this.eNc = -1;
            this.eNd = "";
            this.DK = R.color.cp_link_tip_c;
            this.eNe = R.drawable.pic_dot_title;
            this.eNf = 0;
            this.eNd = str;
            this.eNe = i;
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
                if (aVar.eNc > 0) {
                    aVar.eNd = context.getString(aVar.eNc);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.eNd)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.eNd);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.DK)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.eNe);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.eNf != 0) {
                        kVar.setOffset(aVar.eNf);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) HanziToPinyin.Token.SEPARATOR);
                    spannableStringBuilder.setSpan(kVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bh bhVar, TextView textView) {
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.aiE() == null || bhVar.aiE().size() == 0)) || bhVar.aiV() == 1) {
            bhVar.q(false, true);
            if (bhVar.ajm() == null || StringUtils.isNull(bhVar.ajm().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.ajm());
            return;
        }
        textView.setVisibility(0);
        bhVar.cca = 0;
        bhVar.q(false, true);
        SpannableStringBuilder ajm = bhVar.ajm();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(ajm));
        textView.setText(ajm);
        a(textView, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder cw(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + HanziToPinyin.Token.SEPARATOR + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
