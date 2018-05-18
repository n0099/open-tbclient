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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    public static void ky(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.th(str)) {
            readThreadHistory.tf(str);
        }
    }

    public static boolean kz(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.tg(str)) ? false : true;
    }

    public static String afp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rF() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (kz(str)) {
                ak.h(textView, i2);
            } else {
                ak.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Km;
        public int cpX;
        public String cpY;
        public int cpZ;
        public int cqa;

        public a(int i, int i2, int i3) {
            this.cpX = -1;
            this.cpY = "";
            this.Km = d.C0126d.cp_link_tip_c;
            this.cpZ = d.f.pic_dot_title;
            this.cqa = 0;
            this.cpX = i;
            this.Km = i2;
            this.cpZ = i3;
        }

        public a(int i) {
            this.cpX = -1;
            this.cpY = "";
            this.Km = d.C0126d.cp_link_tip_c;
            this.cpZ = d.f.pic_dot_title;
            this.cqa = 0;
            this.cpX = i;
        }

        public a(String str) {
            this.cpX = -1;
            this.cpY = "";
            this.Km = d.C0126d.cp_link_tip_c;
            this.cpZ = d.f.pic_dot_title;
            this.cqa = 0;
            this.cpY = str;
        }

        public a(String str, int i) {
            this.cpX = -1;
            this.cpY = "";
            this.Km = d.C0126d.cp_link_tip_c;
            this.cpZ = d.f.pic_dot_title;
            this.cqa = 0;
            this.cpY = str;
            this.cpZ = i;
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
                if (aVar.cpX > 0) {
                    aVar.cpY = context.getString(aVar.cpX);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cpY)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cpY);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(aVar.Km)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cO = ak.cO(aVar.cpZ);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                    if (cO != null) {
                        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                    }
                    com.baidu.tbadk.core.view.h hVar = new com.baidu.tbadk.core.view.h(bitmapDrawable);
                    if (aVar.cqa != 0) {
                        hVar.setOffset(aVar.cqa);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(hVar, length2, spannableStringBuilder.length(), 17);
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
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rN() == null || bdVar.rN().size() == 0)) || bdVar.se() == 1) {
            bdVar.b(false, true, false);
            if (bdVar.sn() == null || StringUtils.isNull(bdVar.sn().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.sn());
            return;
        }
        textView.setVisibility(0);
        bdVar.ZV = 0;
        bdVar.b(false, true, false);
        SpannableStringBuilder sn = bdVar.sn();
        textView.setOnTouchListener(new com.baidu.tieba.view.j(sn));
        textView.setText(sn);
        a(textView, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
    }

    public static void b(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rN() == null || bdVar.rN().size() == 0)) || bdVar.se() == 1) {
            bdVar.e(false, true);
            if (bdVar.sn() == null || StringUtils.isNull(bdVar.sn().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.sn());
            return;
        }
        textView.setVisibility(0);
        bdVar.ZV = 0;
        bdVar.e(false, true);
        SpannableStringBuilder sn = bdVar.sn();
        textView.setOnTouchListener(new com.baidu.tieba.view.j(sn));
        textView.setText(sn);
        a(textView, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
    }

    public static SpannableStringBuilder aH(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
