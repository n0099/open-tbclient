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
    public static void kv(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.te(str)) {
            readThreadHistory.tc(str);
        }
    }

    public static boolean kw(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.td(str)) ? false : true;
    }

    public static String afp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String rG() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (kw(str)) {
                ak.h(textView, i2);
            } else {
                ak.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Kq;
        public int coQ;
        public String coR;
        public int coS;
        public int coT;

        public a(int i, int i2, int i3) {
            this.coQ = -1;
            this.coR = "";
            this.Kq = d.C0126d.cp_link_tip_c;
            this.coS = d.f.pic_dot_title;
            this.coT = 0;
            this.coQ = i;
            this.Kq = i2;
            this.coS = i3;
        }

        public a(int i) {
            this.coQ = -1;
            this.coR = "";
            this.Kq = d.C0126d.cp_link_tip_c;
            this.coS = d.f.pic_dot_title;
            this.coT = 0;
            this.coQ = i;
        }

        public a(String str) {
            this.coQ = -1;
            this.coR = "";
            this.Kq = d.C0126d.cp_link_tip_c;
            this.coS = d.f.pic_dot_title;
            this.coT = 0;
            this.coR = str;
        }

        public a(String str, int i) {
            this.coQ = -1;
            this.coR = "";
            this.Kq = d.C0126d.cp_link_tip_c;
            this.coS = d.f.pic_dot_title;
            this.coT = 0;
            this.coR = str;
            this.coS = i;
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
                if (aVar.coQ > 0) {
                    aVar.coR = context.getString(aVar.coQ);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.coR)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.coR);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(aVar.Kq)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cN = ak.cN(aVar.coS);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                    if (cN != null) {
                        bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                    }
                    com.baidu.tbadk.core.view.h hVar = new com.baidu.tbadk.core.view.h(bitmapDrawable);
                    if (aVar.coT != 0) {
                        hVar.setOffset(aVar.coT);
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
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rO() == null || bdVar.rO().size() == 0)) || bdVar.sf() == 1) {
            bdVar.b(false, true, false);
            if (bdVar.so() == null || StringUtils.isNull(bdVar.so().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.so());
            return;
        }
        textView.setVisibility(0);
        bdVar.ZV = 0;
        bdVar.b(false, true, false);
        SpannableStringBuilder so = bdVar.so();
        textView.setOnTouchListener(new com.baidu.tieba.view.j(so));
        textView.setText(so);
        a(textView, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
    }

    public static void b(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.rO() == null || bdVar.rO().size() == 0)) || bdVar.sf() == 1) {
            bdVar.e(false, true);
            if (bdVar.so() == null || StringUtils.isNull(bdVar.so().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.so());
            return;
        }
        textView.setVisibility(0);
        bdVar.ZV = 0;
        bdVar.e(false, true);
        SpannableStringBuilder so = bdVar.so();
        textView.setOnTouchListener(new com.baidu.tieba.view.j(so));
        textView.setText(so);
        a(textView, bdVar.getId(), d.C0126d.cp_cont_b, d.C0126d.cp_cont_d);
    }

    public static SpannableStringBuilder aH(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ak.getColor(d.C0126d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
