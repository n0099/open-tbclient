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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m {
    public static void Ic(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        if (!StringUtils.isNull(str) && !"0".equalsIgnoreCase(str) && (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) != null && !readThreadHistory.SE(str)) {
            readThreadHistory.SC(str);
        }
    }

    public static boolean Id(String str) {
        com.baidu.tieba.tbadkCore.util.d readThreadHistory;
        return (StringUtils.isNull(str) || "0".equalsIgnoreCase(str) || (readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory()) == null || !readThreadHistory.SD(str)) ? false : true;
    }

    public static String cra() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String bnj() {
        return "personalize_page";
    }

    public static String crb() {
        return "frs_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (Id(str) && TbSingleton.getInstance().isInFrs) {
                ao.setViewTextColor(textView, i2);
            } else {
                ao.setViewTextColor(textView, i);
            }
        }
    }

    public static void a(bz bzVar, SpannableStringBuilder spannableStringBuilder, boolean z) {
        if (spannableStringBuilder != null && !at.isEmptyStringAfterTrim(spannableStringBuilder.toString()) && bzVar != null && bzVar.bns() == 0) {
            if (z || bzVar.bnL() == 1 || StringUtils.isNull(bzVar.getTitle())) {
                ArrayList<com.baidu.tbadk.widget.richText.b> bot = bzVar.bot();
                if (!com.baidu.tbadk.core.util.x.isEmpty(bot)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bot.size(); i++) {
                        if (bot.get(i) != null && !StringUtils.isNull(bot.get(i).getText())) {
                            sb.append(bot.get(i).getText());
                        }
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    int i2 = 0;
                    for (int i3 = 0; i3 < bot.size(); i3++) {
                        if (bot.get(i3) != null && !StringUtils.isNull(bot.get(i3).getText())) {
                            int length = bot.get(i3).getText().length();
                            a(spannableString, bot.get(i3), i2, length);
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
        public int adw;
        public int irn;
        public String iro;
        public int irp;
        public int irq;

        public a(int i, int i2, int i3) {
            this.irn = -1;
            this.iro = "";
            this.adw = R.color.CAM_X0304;
            this.irp = R.drawable.pic_dot_title;
            this.irq = 0;
            this.irn = i;
            this.adw = i2;
            this.irp = i3;
        }

        public a(int i) {
            this.irn = -1;
            this.iro = "";
            this.adw = R.color.CAM_X0304;
            this.irp = R.drawable.pic_dot_title;
            this.irq = 0;
            this.irn = i;
        }

        public a(String str) {
            this.irn = -1;
            this.iro = "";
            this.adw = R.color.CAM_X0304;
            this.irp = R.drawable.pic_dot_title;
            this.irq = 0;
            this.iro = str;
        }

        public a(String str, int i) {
            this.irn = -1;
            this.iro = "";
            this.adw = R.color.CAM_X0304;
            this.irp = R.drawable.pic_dot_title;
            this.irq = 0;
            this.iro = str;
            this.irp = i;
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
                if (aVar.irn > 0) {
                    aVar.iro = context.getString(aVar.irn);
                }
                if (!com.baidu.adp.lib.util.k.isEmpty(aVar.iro)) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) aVar.iro);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(aVar.adw)), length, spannableStringBuilder.length(), 17);
                    if (i == arrayList.size() - 1 && !z2) {
                        break;
                    }
                    Bitmap bitmap = ao.getBitmap(aVar.irp);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    if (bitmap != null) {
                        bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    }
                    com.baidu.tbadk.core.view.i iVar = new com.baidu.tbadk.core.view.i(bitmapDrawable);
                    if (aVar.irq != 0) {
                        iVar.setOffset(aVar.irq);
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

    public static void a(bz bzVar, TextView textView) {
        if ((StringUtils.isNull(bzVar.getTitle()) && (bzVar.bnv() == null || bzVar.bnv().size() == 0)) || bzVar.bnL() == 1) {
            bzVar.z(false, true);
            if (bzVar.bog() == null || StringUtils.isNull(bzVar.bog().toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(bzVar.bog());
            return;
        }
        textView.setVisibility(0);
        bzVar.eOU = 0;
        bzVar.z(false, true);
        SpannableStringBuilder bog = bzVar.bog();
        textView.setOnTouchListener(new com.baidu.tieba.view.i(bog));
        textView.setText(bog);
        a(textView, bzVar.getId(), R.color.CAM_X0105, R.color.CAM_X0109);
    }

    public static SpannableStringBuilder eI(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + " " + str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0304)), 0, str.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0106)), str.length(), str.length() + 1, 33);
        return spannableStringBuilder;
    }
}
