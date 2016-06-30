package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager auy = null;
    public static String auA = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a auz = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fP(String str);
    }

    public static TbFaceManager CP() {
        if (auy == null) {
            auy = new TbFaceManager();
        }
        return auy;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.auz = aVar;
    }

    public com.baidu.adp.widget.a.a fN(String str) {
        return m(fo(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fS = c.CQ().fS(str);
        if (fS == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.CQ().c(str, aVar);
            return aVar;
        }
        return fS;
    }

    public int fo(String str) {
        return this.auz.fo(str);
    }

    public a.C0043a fO(String str) {
        com.baidu.adp.widget.a.a fN;
        a.C0043a y = this.auz.y(this.mContext, str);
        if (y == null && (fN = fN(str)) != null) {
            return new a.C0043a(fN.getWidth(), fN.getHeight());
        }
        return y;
    }

    public int fp(String str) {
        return this.auz.fp(str);
    }

    public int BD() {
        return this.auz.BD();
    }

    public String fq(String str) {
        return this.auz.fq(str);
    }

    public SpannableString z(Context context, String str) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(auA).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fp = this.auz.fp(group);
            if (fp > 0 && (m = m(fp, String.valueOf(fp))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable jd = m.jd();
                jd.setBounds(0, 0, m.getWidth(), m.getHeight());
                spannableString.setSpan(new ImageSpan(jd, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fP;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(auA).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fp = this.auz.fp(group);
            if (fp > 0) {
                com.baidu.adp.widget.a.a m = m(fp, String.valueOf(fp));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable jd = m.jd();
                    int width = (int) (0.5d * m.getWidth());
                    jd.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(jd, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fP = aVar.fP(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fP, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
