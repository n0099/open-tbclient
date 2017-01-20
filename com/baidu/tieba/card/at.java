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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class at {
    public static void ie(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.qQ(str)) {
            readThreadHistory.qO(str);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m13if(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.qP(str)) ? false : true;
    }

    public static String Rr() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String Mt() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (m13if(str)) {
                com.baidu.tbadk.core.util.ap.i((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.ap.i((View) textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.ap.cP(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, r.e.cp_link_tip_a, r.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bmt;
        public String bmu;
        public int bmv;
        public int bmw;
        public int bmx;

        public a(int i, int i2, int i3) {
            this.bmt = -1;
            this.bmu = "";
            this.bmv = r.e.cp_link_tip_a;
            this.bmw = r.g.pic_dot_title;
            this.bmx = 0;
            this.bmt = i;
            this.bmv = i2;
            this.bmw = i3;
        }

        public a(int i) {
            this.bmt = -1;
            this.bmu = "";
            this.bmv = r.e.cp_link_tip_a;
            this.bmw = r.g.pic_dot_title;
            this.bmx = 0;
            this.bmt = i;
        }

        public a(String str) {
            this.bmt = -1;
            this.bmu = "";
            this.bmv = r.e.cp_link_tip_a;
            this.bmw = r.g.pic_dot_title;
            this.bmx = 0;
            this.bmu = str;
        }

        public a(String str, int i) {
            this.bmt = -1;
            this.bmu = "";
            this.bmv = r.e.cp_link_tip_a;
            this.bmw = r.g.pic_dot_title;
            this.bmx = 0;
            this.bmu = str;
            this.bmw = i;
        }

        public void gJ(int i) {
            this.bmx = i;
        }
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z) {
        return a(context, str, arrayList, z, true);
    }

    public static SpannableStringBuilder a(Context context, String str, ArrayList<a> arrayList, boolean z, boolean z2) {
        if (com.baidu.adp.lib.util.j.isEmpty(str) || context == null || arrayList == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i != arrayList.size(); i++) {
            a aVar = arrayList.get(i);
            if (aVar != null) {
                if (aVar.bmt > 0) {
                    aVar.bmu = context.getString(aVar.bmt);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bmu)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bmu);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.ap.getColor(aVar.bmv)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cP = com.baidu.tbadk.core.util.ap.cP(aVar.bmw);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cP);
                    if (cP != null) {
                        bitmapDrawable.setBounds(0, 0, cP.getWidth(), cP.getHeight());
                    }
                    com.baidu.tbadk.core.view.ak akVar = new com.baidu.tbadk.core.view.ak(bitmapDrawable);
                    if (aVar.bmx != 0) {
                        akVar.setOffset(aVar.bmx);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(akVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(com.baidu.tbadk.core.data.bh bhVar, TextView textView) {
        if ((StringUtils.isNull(bhVar.getTitle()) && (bhVar.rv() == null || bhVar.rv().size() == 0)) || bhVar.rL() == 1) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        bhVar.SJ = 0;
        bhVar.sd();
        SpannableStringBuilder rV = bhVar.rV();
        textView.setOnTouchListener(new com.baidu.tieba.view.x(rV));
        textView.setText(rV);
        a(textView, bhVar.getId(), r.e.cp_cont_b, r.e.cp_cont_d);
    }
}
