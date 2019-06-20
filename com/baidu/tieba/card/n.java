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
    public static void uR(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.El(str)) {
            readThreadHistory.Ej(str);
        }
    }

    public static boolean uS(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.Ek(str)) ? false : true;
    }

    public static String aXH() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String adi() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (uS(str)) {
                al.j(textView, i2);
            } else {
                al.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Ua;
        public int exI;
        public String exJ;
        public int exK;
        public int exL;

        public a(int i, int i2, int i3) {
            this.exI = -1;
            this.exJ = "";
            this.Ua = R.color.cp_link_tip_c;
            this.exK = R.drawable.pic_dot_title;
            this.exL = 0;
            this.exI = i;
            this.Ua = i2;
            this.exK = i3;
        }

        public a(int i) {
            this.exI = -1;
            this.exJ = "";
            this.Ua = R.color.cp_link_tip_c;
            this.exK = R.drawable.pic_dot_title;
            this.exL = 0;
            this.exI = i;
        }

        public a(String str) {
            this.exI = -1;
            this.exJ = "";
            this.Ua = R.color.cp_link_tip_c;
            this.exK = R.drawable.pic_dot_title;
            this.exL = 0;
            this.exJ = str;
        }

        public a(String str, int i) {
            this.exI = -1;
            this.exJ = "";
            this.Ua = R.color.cp_link_tip_c;
            this.exK = R.drawable.pic_dot_title;
            this.exL = 0;
            this.exJ = str;
            this.exK = i;
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
                if (aVar.exI > 0) {
                    aVar.exJ = context.getString(aVar.exI);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.exJ)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.exJ);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Ua)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap id = al.id(aVar.exK);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(id);
                    if (id != null) {
                        bitmapDrawable.setBounds(0, 0, id.getWidth(), id.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.exL != 0) {
                        kVar.setOffset(aVar.exL);
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
        bgVar.bIP = 0;
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
