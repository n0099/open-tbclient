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

    public static String bal() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String air() {
        return "personalize_page";
    }

    public static String bam() {
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
        public int Dj;
        public int eMl;
        public String eMm;
        public int eMn;
        public int eMo;

        public a(int i, int i2, int i3) {
            this.eMl = -1;
            this.eMm = "";
            this.Dj = R.color.cp_link_tip_c;
            this.eMn = R.drawable.pic_dot_title;
            this.eMo = 0;
            this.eMl = i;
            this.Dj = i2;
            this.eMn = i3;
        }

        public a(int i) {
            this.eMl = -1;
            this.eMm = "";
            this.Dj = R.color.cp_link_tip_c;
            this.eMn = R.drawable.pic_dot_title;
            this.eMo = 0;
            this.eMl = i;
        }

        public a(String str) {
            this.eMl = -1;
            this.eMm = "";
            this.Dj = R.color.cp_link_tip_c;
            this.eMn = R.drawable.pic_dot_title;
            this.eMo = 0;
            this.eMm = str;
        }

        public a(String str, int i) {
            this.eMl = -1;
            this.eMm = "";
            this.Dj = R.color.cp_link_tip_c;
            this.eMn = R.drawable.pic_dot_title;
            this.eMo = 0;
            this.eMm = str;
            this.eMn = i;
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
                if (aVar.eMl > 0) {
                    aVar.eMm = context.getString(aVar.eMl);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.eMm)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.eMm);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(aVar.Dj)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = am.getBitmap(aVar.eMn);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.eMo != 0) {
                        kVar.setOffset(aVar.eMo);
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
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.aiC() == null || bhVar.aiC().size() == 0)) || bhVar.aiT() == 1) {
            bhVar.q(false, true);
            if (bhVar.ajk() == null || StringUtils.isNull(bhVar.ajk().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bhVar.ajk());
            return;
        }
        textView.setVisibility(0);
        bhVar.cbj = 0;
        bhVar.q(false, true);
        SpannableStringBuilder ajk = bhVar.ajk();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(ajk));
        textView.setText(ajk);
        a(textView, bhVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder cw(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + HanziToPinyin.Token.SEPARATOR + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(am.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
