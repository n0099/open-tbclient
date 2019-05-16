package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void uS(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.Ej(str)) {
            readThreadHistory.Eh(str);
        }
    }

    public static boolean uT(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Ei(str)) ? false : true;
    }

    public static String aXE() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String adi() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (uT(str)) {
                al.j(textView, i2);
            } else {
                al.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Ub;
        public int exH;
        public String exI;
        public int exJ;
        public int exK;

        public a(int i, int i2, int i3) {
            this.exH = -1;
            this.exI = "";
            this.Ub = R.color.cp_link_tip_c;
            this.exJ = R.drawable.pic_dot_title;
            this.exK = 0;
            this.exH = i;
            this.Ub = i2;
            this.exJ = i3;
        }

        public a(int i) {
            this.exH = -1;
            this.exI = "";
            this.Ub = R.color.cp_link_tip_c;
            this.exJ = R.drawable.pic_dot_title;
            this.exK = 0;
            this.exH = i;
        }

        public a(String str) {
            this.exH = -1;
            this.exI = "";
            this.Ub = R.color.cp_link_tip_c;
            this.exJ = R.drawable.pic_dot_title;
            this.exK = 0;
            this.exI = str;
        }

        public a(String str, int i) {
            this.exH = -1;
            this.exI = "";
            this.Ub = R.color.cp_link_tip_c;
            this.exJ = R.drawable.pic_dot_title;
            this.exK = 0;
            this.exI = str;
            this.exJ = i;
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
                if (aVar.exH > 0) {
                    aVar.exI = context.getString(aVar.exH);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.exI)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.exI);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Ub)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap id = al.id(aVar.exJ);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(id);
                    if (id != null) {
                        bitmapDrawable.setBounds(0, 0, id.getWidth(), id.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.exK != 0) {
                        kVar.setOffset(aVar.exK);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
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

    public static void a(bg bgVar, TextView textView) {
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.adt() == null || bgVar.adt().size() == 0)) || bgVar.adK() == 1) {
            bgVar.k(false, true);
            if (bgVar.aeb() == null || StringUtils.isNull(bgVar.aeb().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bgVar.aeb());
            return;
        }
        textView.setVisibility(0);
        bgVar.bIO = 0;
        bgVar.k(false, true);
        SpannableStringBuilder aeb = bgVar.aeb();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(aeb));
        textView.setText(aeb);
        a(textView, bgVar.getId(), (int) R.color.cp_cont_b, (int) R.color.cp_cont_d);
    }

    public static SpannableStringBuilder cF(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(R.color.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
