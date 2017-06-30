package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class at {
    public static void iI(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) != null && !readThreadHistory.rv(str)) {
            readThreadHistory.rt(str);
        }
    }

    public static boolean iJ(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory()) == null || !readThreadHistory.ru(str)) ? false : true;
    }

    public static String VG() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String ri() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (iJ(str)) {
                com.baidu.tbadk.core.util.as.i(textView, i2);
            } else {
                com.baidu.tbadk.core.util.as.i(textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(context, com.baidu.tbadk.core.util.as.cO(i3), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, w.e.cp_link_tip_a, w.g.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int bCe;
        public String bCf;
        public int bCg;
        public int bCh;
        public int bCi;

        public a(int i, int i2, int i3) {
            this.bCe = -1;
            this.bCf = "";
            this.bCg = w.e.cp_link_tip_c;
            this.bCh = w.g.pic_dot_title;
            this.bCi = 0;
            this.bCe = i;
            this.bCg = i2;
            this.bCh = i3;
        }

        public a(int i) {
            this.bCe = -1;
            this.bCf = "";
            this.bCg = w.e.cp_link_tip_c;
            this.bCh = w.g.pic_dot_title;
            this.bCi = 0;
            this.bCe = i;
        }

        public a(String str) {
            this.bCe = -1;
            this.bCf = "";
            this.bCg = w.e.cp_link_tip_c;
            this.bCh = w.g.pic_dot_title;
            this.bCi = 0;
            this.bCf = str;
        }

        public a(String str, int i) {
            this.bCe = -1;
            this.bCf = "";
            this.bCg = w.e.cp_link_tip_c;
            this.bCh = w.g.pic_dot_title;
            this.bCi = 0;
            this.bCf = str;
            this.bCh = i;
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
                if (aVar.bCe > 0) {
                    aVar.bCf = context.getString(aVar.bCe);
                }
                if (!com.baidu.adp.lib.util.j.isEmpty(aVar.bCf)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.bCf);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.as.getColor(aVar.bCg)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap cO = com.baidu.tbadk.core.util.as.cO(aVar.bCh);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                    if (cO != null) {
                        bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                    }
                    com.baidu.tbadk.core.view.as asVar = new com.baidu.tbadk.core.view.as(bitmapDrawable);
                    if (aVar.bCi != 0) {
                        asVar.setOffset(aVar.bCi);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(asVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(com.baidu.tbadk.core.data.bm bmVar, TextView textView) {
        if ((StringUtils.isNull(bmVar.getTitle()) && (bmVar.rp() == null || bmVar.rp().size() == 0)) || bmVar.rG() == 1) {
            bmVar.e(false, true);
            if (bmVar.rR() == null || StringUtils.isNull(bmVar.rR().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bmVar.rR());
            return;
        }
        textView.setVisibility(0);
        bmVar.XB = 0;
        if (bmVar.rt()) {
            bmVar.e(false, true);
        } else {
            bmVar.rZ();
        }
        SpannableStringBuilder rR = bmVar.rR();
        textView.setOnTouchListener(new com.baidu.tieba.view.aa(rR));
        textView.setText(rR);
        a(textView, bmVar.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
    }

    public static void a(Context context, com.baidu.tbadk.core.data.bm bmVar, TextView textView) {
        String string;
        if (context != null && bmVar != null) {
            if (StringUtils.isNull(bmVar.rw())) {
                string = "吧";
            } else {
                string = context.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bmVar.rw(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            com.baidu.tbadk.core.util.as.i(textView, w.e.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }
}
