package com.baidu.tieba.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class n {
    public static void IA(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.SN(str)) {
            readThreadHistory.SL(str);
        }
    }

    public static boolean IB(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.SM(str)) ? false : true;
    }

    public static String cnK() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String blo() {
        return "personalize_page";
    }

    public static String cnL() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (IB(str) && TbSingleton.getInstance().isInFrs) {
                ap.setViewTextColor(textView, i2);
            } else {
                ap.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bx bxVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !au.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bxVar != null && bxVar.blx() == 0) {
            if (z || bxVar.blQ() == 1 || StringUtils.isNull(bxVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> bmy = bxVar.bmy();
                if (!com.baidu.tbadk.core.util.y.isEmpty(bmy)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bmy.size(); i++) {
                        if (bmy.get(i) != null && !StringUtils.isNull(bmy.get(i).getText())) {
                            sb.append(bmy.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < bmy.size(); i3++) {
                        if (bmy.get(i3) != null && !StringUtils.isNull(bmy.get(i3).getText())) {
                            int length = bmy.get(i3).getText().length();
                            a(spannableString, bmy.get(i3), i2, length);
                            i2 += length;
                        }
                    }
                    spannableStringBuilder.insert(0, (CharSequence) spannableString);
                }
            }
        }
    }

    private static void a(SpannableString spannableString, com.baidu.tbadk.widget.richText.b bVar, int i, int i2) {
        if (spannableString != null && bVar != null && i + i2 <= spannableString.length()) {
            spannableString.setSpan(new com.baidu.tbadk.widget.richText.c(bVar), i, i + i2, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(bVar.textSize), i, i + i2, 33);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public int abL;
        public int hYA;
        public String hYB;
        public int hYC;
        public int hYD;

        public a(int i, int i2, int i3) {
            this.hYA = -1;
            this.hYB = "";
            this.abL = R.color.CAM_X0304;
            this.hYC = R.drawable.pic_dot_title;
            this.hYD = 0;
            this.hYA = i;
            this.abL = i2;
            this.hYC = i3;
        }

        public a(int i) {
            this.hYA = -1;
            this.hYB = "";
            this.abL = R.color.CAM_X0304;
            this.hYC = R.drawable.pic_dot_title;
            this.hYD = 0;
            this.hYA = i;
        }

        public a(String str) {
            this.hYA = -1;
            this.hYB = "";
            this.abL = R.color.CAM_X0304;
            this.hYC = R.drawable.pic_dot_title;
            this.hYD = 0;
            this.hYB = str;
        }

        public a(String str, int i) {
            this.hYA = -1;
            this.hYB = "";
            this.abL = R.color.CAM_X0304;
            this.hYC = R.drawable.pic_dot_title;
            this.hYD = 0;
            this.hYB = str;
            this.hYC = i;
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
                if (aVar.hYA > 0) {
                    aVar.hYB = context.getString(aVar.hYA);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.hYB)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.hYB);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(aVar.abL)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ap.getBitmap(aVar.hYC);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.hYD != 0) {
                        iVar.setOffset(aVar.hYD);
                    }
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " ");
                    spannableStringBuilder.setSpan(iVar, length2, spannableStringBuilder.length(), 17);
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

    public static void a(bx bxVar, TextView textView) {
        if ((StringUtils.isNull(bxVar.getTitle()) && (bxVar.blA() == null || bxVar.blA().size() == 0)) || bxVar.blQ() == 1) {
            bxVar.z(false, true);
            if (bxVar.bmm() == null || StringUtils.isNull(bxVar.bmm().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bxVar.bmm());
            return;
        }
        textView.setVisibility(0);
        bxVar.eCJ = 0;
        bxVar.z(false, true);
        SpannableStringBuilder bmm = bxVar.bmm();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(bmm));
        textView.setText(bmm);
        a(textView, bxVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public static SpannableStringBuilder eD(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
