package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {
    public static void lA(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.uK(str)) {
            readThreadHistory.uI(str);
        }
    }

    public static boolean lB(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.uJ(str)) ? false : true;
    }

    public static String akD() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String wa() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (lB(str)) {
                al.h(textView, i2);
            } else {
                al.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Th;
        public int cEM;
        public String cEN;
        public int cEO;
        public int cEP;

        public a(int i, int i2, int i3) {
            this.cEM = -1;
            this.cEN = "";
            this.Th = e.d.cp_link_tip_c;
            this.cEO = e.f.pic_dot_title;
            this.cEP = 0;
            this.cEM = i;
            this.Th = i2;
            this.cEO = i3;
        }

        public a(int i) {
            this.cEM = -1;
            this.cEN = "";
            this.Th = e.d.cp_link_tip_c;
            this.cEO = e.f.pic_dot_title;
            this.cEP = 0;
            this.cEM = i;
        }

        public a(String str) {
            this.cEM = -1;
            this.cEN = "";
            this.Th = e.d.cp_link_tip_c;
            this.cEO = e.f.pic_dot_title;
            this.cEP = 0;
            this.cEN = str;
        }

        public a(String str, int i) {
            this.cEM = -1;
            this.cEN = "";
            this.Th = e.d.cp_link_tip_c;
            this.cEO = e.f.pic_dot_title;
            this.cEP = 0;
            this.cEN = str;
            this.cEO = i;
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
                if (aVar.cEM > 0) {
                    aVar.cEN = context.getString(aVar.cEM);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cEN)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cEN);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Th)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap dc = al.dc(aVar.cEO);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(dc);
                    if (dc != null) {
                        bitmapDrawable.setBounds(0, 0, dc.getWidth(), dc.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cEP != 0) {
                        mVar.setOffset(aVar.cEP);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(mVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.wk() == null || bbVar.wk().size() == 0)) || bbVar.wC() == 1) {
            bbVar.b(false, true, false);
            if (bbVar.wM() == null || StringUtils.isNull(bbVar.wM().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.wM());
            return;
        }
        textView.setVisibility(0);
        bbVar.akp = 0;
        bbVar.b(false, true, false);
        SpannableStringBuilder wM = bbVar.wM();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(wM));
        textView.setText(wM);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static void b(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.wk() == null || bbVar.wk().size() == 0)) || bbVar.wC() == 1) {
            bbVar.g(false, true);
            if (bbVar.wM() == null || StringUtils.isNull(bbVar.wM().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.wM());
            return;
        }
        textView.setVisibility(0);
        bbVar.akp = 0;
        bbVar.g(false, true);
        SpannableStringBuilder wM = bbVar.wM();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(wM));
        textView.setText(wM);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static SpannableStringBuilder aU(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
