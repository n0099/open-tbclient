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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void tz(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.CN(str)) {
            readThreadHistory.CL(str);
        }
    }

    public static boolean tA(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.CM(str)) ? false : true;
    }

    public static String aQv() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String YB() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (tA(str)) {
                al.j(textView, i2);
            } else {
                al.j(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Wm;
        public int ehU;
        public String ehV;
        public int ehW;
        public int ehX;

        public a(int i, int i2, int i3) {
            this.ehU = -1;
            this.ehV = "";
            this.Wm = d.C0277d.cp_link_tip_c;
            this.ehW = d.f.pic_dot_title;
            this.ehX = 0;
            this.ehU = i;
            this.Wm = i2;
            this.ehW = i3;
        }

        public a(int i) {
            this.ehU = -1;
            this.ehV = "";
            this.Wm = d.C0277d.cp_link_tip_c;
            this.ehW = d.f.pic_dot_title;
            this.ehX = 0;
            this.ehU = i;
        }

        public a(String str) {
            this.ehU = -1;
            this.ehV = "";
            this.Wm = d.C0277d.cp_link_tip_c;
            this.ehW = d.f.pic_dot_title;
            this.ehX = 0;
            this.ehV = str;
        }

        public a(String str, int i) {
            this.ehU = -1;
            this.ehV = "";
            this.Wm = d.C0277d.cp_link_tip_c;
            this.ehW = d.f.pic_dot_title;
            this.ehX = 0;
            this.ehV = str;
            this.ehW = i;
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
                if (aVar.ehU > 0) {
                    aVar.ehV = context.getString(aVar.ehU);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.ehV)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.ehV);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Wm)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap hp = al.hp(aVar.ehW);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(hp);
                    if (hp != null) {
                        bitmapDrawable.setBounds(0, 0, hp.getWidth(), hp.getHeight());
                    }
                    com.baidu.tbadk.core.view.k kVar = new com.baidu.tbadk.core.view.k(bitmapDrawable);
                    if (aVar.ehX != 0) {
                        kVar.setOffset(aVar.ehX);
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
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.YM() == null || bgVar.YM().size() == 0)) || bgVar.Zd() == 1) {
            bgVar.b(false, true, false);
            if (bgVar.Zu() == null || StringUtils.isNull(bgVar.Zu().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bgVar.Zu());
            return;
        }
        textView.setVisibility(0);
        bgVar.bBy = 0;
        bgVar.b(false, true, false);
        SpannableStringBuilder Zu = bgVar.Zu();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Zu));
        textView.setText(Zu);
        a(textView, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
    }

    public static void b(bg bgVar, TextView textView) {
        if ((StringUtils.isNull(bgVar.getTitle()) && (bgVar.YM() == null || bgVar.YM().size() == 0)) || bgVar.Zd() == 1) {
            bgVar.k(false, true);
            if (bgVar.Zu() == null || StringUtils.isNull(bgVar.Zu().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bgVar.Zu());
            return;
        }
        textView.setVisibility(0);
        bgVar.bBy = 0;
        bgVar.k(false, true);
        SpannableStringBuilder Zu = bgVar.Zu();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(Zu));
        textView.setText(Zu);
        a(textView, bgVar.getId(), d.C0277d.cp_cont_b, d.C0277d.cp_cont_d);
    }

    public static SpannableStringBuilder ct(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(d.C0277d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
