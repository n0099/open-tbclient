package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.imageManager.a;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager awj = null;
    public static String awl = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a awk = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fG(String str);
    }

    public static TbFaceManager CL() {
        if (awj == null) {
            awj = new TbFaceManager();
        }
        return awj;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.awk = aVar;
    }

    public com.baidu.adp.widget.a.a fE(String str) {
        return u(fe(str), str);
    }

    private com.baidu.adp.widget.a.a u(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a fJ = c.CM().fJ(str);
        if (fJ == null && (b = com.baidu.adp.lib.util.d.ix().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            c.CM().c(str, aVar);
            return aVar;
        }
        return fJ;
    }

    public int fe(String str) {
        return this.awk.fe(str);
    }

    public a.C0051a fF(String str) {
        com.baidu.adp.widget.a.a fE;
        a.C0051a F = this.awk.F(this.mContext, str);
        if (F == null && (fE = fE(str)) != null) {
            return new a.C0051a(fE.getWidth(), fE.getHeight());
        }
        return F;
    }

    public int ff(String str) {
        return this.awk.ff(str);
    }

    public int BA() {
        return this.awk.BA();
    }

    public String fg(String str) {
        return this.awk.fg(str);
    }

    public SpannableString G(Context context, String str) {
        com.baidu.adp.widget.a.a u;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(awl).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ff = this.awk.ff(group);
            if (ff > 0 && (u = u(ff, String.valueOf(ff))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable mG = u.mG();
                mG.setBounds(0, 0, u.getWidth(), u.getHeight());
                spannableString.setSpan(new ImageSpan(mG, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fG;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(awl).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ff = this.awk.ff(group);
            if (ff > 0) {
                com.baidu.adp.widget.a.a u = u(ff, String.valueOf(ff));
                if (u != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable mG = u.mG();
                    int width = (int) (0.5d * u.getWidth());
                    mG.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(mG, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fG = aVar.fG(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fG, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
