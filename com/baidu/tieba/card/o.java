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
    public static void mW(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.wl(str)) {
            readThreadHistory.wj(str);
        }
    }

    public static boolean mX(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.wk(str)) ? false : true;
    }

    public static String aqG() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String zH() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (mX(str)) {
                al.h(textView, i2);
            } else {
                al.h(textView, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int TH;
        public int cYv;
        public String cYw;
        public int cYx;
        public int cYy;

        public a(int i, int i2, int i3) {
            this.cYv = -1;
            this.cYw = "";
            this.TH = e.d.cp_link_tip_c;
            this.cYx = e.f.pic_dot_title;
            this.cYy = 0;
            this.cYv = i;
            this.TH = i2;
            this.cYx = i3;
        }

        public a(int i) {
            this.cYv = -1;
            this.cYw = "";
            this.TH = e.d.cp_link_tip_c;
            this.cYx = e.f.pic_dot_title;
            this.cYy = 0;
            this.cYv = i;
        }

        public a(String str) {
            this.cYv = -1;
            this.cYw = "";
            this.TH = e.d.cp_link_tip_c;
            this.cYx = e.f.pic_dot_title;
            this.cYy = 0;
            this.cYw = str;
        }

        public a(String str, int i) {
            this.cYv = -1;
            this.cYw = "";
            this.TH = e.d.cp_link_tip_c;
            this.cYx = e.f.pic_dot_title;
            this.cYy = 0;
            this.cYw = str;
            this.cYx = i;
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
                if (aVar.cYv > 0) {
                    aVar.cYw = context.getString(aVar.cYv);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cYw)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cYw);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(aVar.TH)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap dO = al.dO(aVar.cYx);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(dO);
                    if (dO != null) {
                        bitmapDrawable.setBounds(0, 0, dO.getWidth(), dO.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cYy != 0) {
                        mVar.setOffset(aVar.cYy);
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
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.zR() == null || bbVar.zR().size() == 0)) || bbVar.Aj() == 1) {
            bbVar.b(false, true, false);
            if (bbVar.At() == null || StringUtils.isNull(bbVar.At().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.At());
            return;
        }
        textView.setVisibility(0);
        bbVar.aub = 0;
        bbVar.b(false, true, false);
        SpannableStringBuilder At = bbVar.At();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(At));
        textView.setText(At);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static void b(bb bbVar, TextView textView) {
        if ((StringUtils.isNull(bbVar.getTitle()) && (bbVar.zR() == null || bbVar.zR().size() == 0)) || bbVar.Aj() == 1) {
            bbVar.g(false, true);
            if (bbVar.At() == null || StringUtils.isNull(bbVar.At().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bbVar.At());
            return;
        }
        textView.setVisibility(0);
        bbVar.aub = 0;
        bbVar.g(false, true);
        SpannableStringBuilder At = bbVar.At();
        textView.setOnTouchListener(new com.baidu.tieba.view.k(At));
        textView.setText(At);
        a(textView, bbVar.getId(), e.d.cp_cont_b, e.d.cp_cont_d);
    }

    public static SpannableStringBuilder bn(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(al.getColor(e.d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
