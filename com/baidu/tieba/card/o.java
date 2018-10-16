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
    public static void md(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.vm(str)) {
            readThreadHistory.vk(str);
        }
    }

    public static boolean me(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.vl(str)) ? false : true;
    }

    public static String aof() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String yj() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (me(str)) {
                al.h(textView, i2);
            } else {
                al.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int Tv;
        public int cNg;
        public String cNh;
        public int cNi;
        public int cNj;

        public a(int i, int i2, int i3) {
            this.cNg = -1;
            this.cNh = "";
            this.Tv = e.d.cp_link_tip_c;
            this.cNi = e.f.pic_dot_title;
            this.cNj = 0;
            this.cNg = i;
            this.Tv = i2;
            this.cNi = i3;
        }

        public a(int i) {
            this.cNg = -1;
            this.cNh = "";
            this.Tv = e.d.cp_link_tip_c;
            this.cNi = e.f.pic_dot_title;
            this.cNj = 0;
            this.cNg = i;
        }

        public a(String str) {
            this.cNg = -1;
            this.cNh = "";
            this.Tv = e.d.cp_link_tip_c;
            this.cNi = e.f.pic_dot_title;
            this.cNj = 0;
            this.cNh = str;
        }

        public a(String str, int i) {
            this.cNg = -1;
            this.cNh = "";
            this.Tv = e.d.cp_link_tip_c;
            this.cNi = e.f.pic_dot_title;
            this.cNj = 0;
            this.cNh = str;
            this.cNi = i;
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
                if (aVar.cNg > 0) {
                    aVar.cNh = context.getString(aVar.cNg);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cNh)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cNh);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.Tv)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap dm = al.dm(aVar.cNi);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(dm);
                    if (dm != null) {
                        bitmapDrawable.setBounds(0, 0, dm.getWidth(), dm.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cNj != 0) {
                        mVar.setOffset(aVar.cNj);
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
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.yt() == null || bbVar.yt().size() == 0)) || bbVar.yL() == 1) {
            bbVar.b(false, true, false);
            if (bbVar.yV() == null || StringUtils.isNull(bbVar.yV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.yV());
            return;
        }
        textView.setVisibility(0);
        bbVar.apk = 0;
        bbVar.b(false, true, false);
        SpannableStringBuilder yV = bbVar.yV();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(yV));
        textView.setText(yV);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static void b(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.yt() == null || bbVar.yt().size() == 0)) || bbVar.yL() == 1) {
            bbVar.g(false, true);
            if (bbVar.yV() == null || StringUtils.isNull(bbVar.yV().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.yV());
            return;
        }
        textView.setVisibility(0);
        bbVar.apk = 0;
        bbVar.g(false, true);
        SpannableStringBuilder yV = bbVar.yV();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(yV));
        textView.setText(yV);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static SpannableStringBuilder bh(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
