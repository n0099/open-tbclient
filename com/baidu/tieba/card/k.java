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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k {
    public static void kj(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.sP(str)) {
            readThreadHistory.sN(str);
        }
    }

    public static boolean kk(String str) {
        com.baidu.tieba.tbadkCore.util.e readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.sO(str)) ? false : true;
    }

    public static String akx() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String yJ() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (kk(str)) {
                aj.r(textView, i2);
            } else {
                aj.r(textView, i);
            }
        }
    }

    public static SpannableStringBuilder a(Context context, CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = context.getString(i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(i2)), 0, string.length(), 17);
        com.baidu.adp.widget.b bVar = new com.baidu.adp.widget.b(context, aj.fO(i3), 1);
        bVar.setOffset(3);
        spannableStringBuilder.setSpan(bVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder c(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, d.C0108d.cp_link_tip_a, d.f.pic_dot_title);
    }

    /* loaded from: classes.dex */
    public static class a {
        public int ayo;
        public int cUp;
        public String cUq;
        public int cUr;
        public int cUs;

        public a(int i, int i2, int i3) {
            this.cUp = -1;
            this.cUq = "";
            this.ayo = d.C0108d.cp_link_tip_c;
            this.cUr = d.f.pic_dot_title;
            this.cUs = 0;
            this.cUp = i;
            this.ayo = i2;
            this.cUr = i3;
        }

        public a(int i) {
            this.cUp = -1;
            this.cUq = "";
            this.ayo = d.C0108d.cp_link_tip_c;
            this.cUr = d.f.pic_dot_title;
            this.cUs = 0;
            this.cUp = i;
        }

        public a(String str) {
            this.cUp = -1;
            this.cUq = "";
            this.ayo = d.C0108d.cp_link_tip_c;
            this.cUr = d.f.pic_dot_title;
            this.cUs = 0;
            this.cUq = str;
        }

        public a(String str, int i) {
            this.cUp = -1;
            this.cUq = "";
            this.ayo = d.C0108d.cp_link_tip_c;
            this.cUr = d.f.pic_dot_title;
            this.cUs = 0;
            this.cUq = str;
            this.cUr = i;
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
                if (aVar.cUp > 0) {
                    aVar.cUq = context.getString(aVar.cUp);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.cUq)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.cUq);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(aVar.ayo)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap fO = aj.fO(aVar.cUr);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(fO);
                    if (fO != null) {
                        bitmapDrawable.setBounds(0, 0, fO.getWidth(), fO.getHeight());
                    }
                    com.baidu.tbadk.core.view.m mVar = new com.baidu.tbadk.core.view.m(bitmapDrawable);
                    if (aVar.cUs != 0) {
                        mVar.setOffset(aVar.cUs);
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

    public static void a(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yR() == null || bdVar.yR().size() == 0)) || bdVar.zj() == 1) {
            bdVar.c(false, true, false);
            if (bdVar.zt() == null || StringUtils.isNull(bdVar.zt().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.zt());
            return;
        }
        textView.setVisibility(0);
        bdVar.aNq = 0;
        bdVar.c(false, true, false);
        SpannableStringBuilder zt = bdVar.zt();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(zt));
        textView.setText(zt);
        a(textView, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
    }

    public static void b(bd bdVar, TextView textView) {
        if ((StringUtils.isNull(bdVar.getTitle()) && (bdVar.yR() == null || bdVar.yR().size() == 0)) || bdVar.zj() == 1) {
            bdVar.h(false, true);
            if (bdVar.zt() == null || StringUtils.isNull(bdVar.zt().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bdVar.zt());
            return;
        }
        textView.setVisibility(0);
        bdVar.aNq = 0;
        bdVar.h(false, true);
        SpannableStringBuilder zt = bdVar.zt();
        textView.setOnTouchListener(new com.baidu.tieba.view.m(zt));
        textView.setText(zt);
        a(textView, bdVar.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
    }

    public static void a(Context context, bd bdVar, TextView textView) {
        String string;
        if (context != null && bdVar != null) {
            if (StringUtils.isNull(bdVar.yZ())) {
                string = "吧";
            } else {
                string = context.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(bdVar.yZ(), 7, true));
            }
            textView.setVisibility(0);
            textView.setText(string);
            aj.r(textView, d.C0108d.cp_cont_f);
            return;
        }
        textView.setVisibility(8);
    }

    public static SpannableStringBuilder aF(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_c)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0108d.cp_cont_f)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
