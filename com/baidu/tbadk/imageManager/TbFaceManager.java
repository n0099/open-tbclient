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
    private static TbFaceManager axa = null;
    public static String axc = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a axb = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fE(String str);
    }

    public static TbFaceManager Ec() {
        if (axa == null) {
            axa = new TbFaceManager();
        }
        return axa;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.axb = aVar;
    }

    public com.baidu.adp.widget.a.a fC(String str) {
        return u(fd(str), str);
    }

    private com.baidu.adp.widget.a.a u(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fH = c.Ed().fH(str);
        if (fH == null && (resBitmap = com.baidu.adp.lib.util.d.iH().getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Ed().c(str, aVar);
            return aVar;
        }
        return fH;
    }

    public int fd(String str) {
        return this.axb.fd(str);
    }

    public a.C0052a fD(String str) {
        com.baidu.adp.widget.a.a fC;
        a.C0052a F = this.axb.F(this.mContext, str);
        if (F == null && (fC = fC(str)) != null) {
            return new a.C0052a(fC.getWidth(), fC.getHeight());
        }
        return F;
    }

    public int fe(String str) {
        return this.axb.fe(str);
    }

    public int CR() {
        return this.axb.CR();
    }

    public String ff(String str) {
        return this.axb.ff(str);
    }

    public SpannableString G(Context context, String str) {
        com.baidu.adp.widget.a.a u;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axc).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fe = this.axb.fe(group);
            if (fe > 0 && (u = u(fe, String.valueOf(fe))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable mU = u.mU();
                mU.setBounds(0, 0, u.getWidth(), u.getHeight());
                spannableString.setSpan(new ImageSpan(mU, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fE;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axc).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fe = this.axb.fe(group);
            if (fe > 0) {
                com.baidu.adp.widget.a.a u = u(fe, String.valueOf(fe));
                if (u != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable mU = u.mU();
                    int width = (int) (0.5d * u.getWidth());
                    mU.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(mU, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fE = aVar.fE(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fE, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
