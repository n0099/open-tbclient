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
    private static TbFaceManager atI = null;
    public static String atK = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a atJ = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fJ(String str);
    }

    public static TbFaceManager CH() {
        if (atI == null) {
            atI = new TbFaceManager();
        }
        return atI;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.atJ = aVar;
    }

    public com.baidu.adp.widget.a.a fH(String str) {
        return m(fi(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fM = c.CI().fM(str);
        if (fM == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.CI().c(str, aVar);
            return aVar;
        }
        return fM;
    }

    public int fi(String str) {
        return this.atJ.fi(str);
    }

    public a.C0043a fI(String str) {
        com.baidu.adp.widget.a.a fH;
        a.C0043a x = this.atJ.x(this.mContext, str);
        if (x == null && (fH = fH(str)) != null) {
            return new a.C0043a(fH.getWidth(), fH.getHeight());
        }
        return x;
    }

    public int fj(String str) {
        return this.atJ.fj(str);
    }

    public int Bu() {
        return this.atJ.Bu();
    }

    public String fk(String str) {
        return this.atJ.fk(str);
    }

    public SpannableString y(Context context, String str) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(atK).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fj = this.atJ.fj(group);
            if (fj > 0 && (m = m(fj, String.valueOf(fj))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable ja = m.ja();
                ja.setBounds(0, 0, m.getWidth(), m.getHeight());
                spannableString.setSpan(new ImageSpan(ja, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fJ;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(atK).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fj = this.atJ.fj(group);
            if (fj > 0) {
                com.baidu.adp.widget.a.a m = m(fj, String.valueOf(fj));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable ja = m.ja();
                    int width = (int) (0.5d * m.getWidth());
                    ja.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(ja, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fJ = aVar.fJ(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fJ, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
