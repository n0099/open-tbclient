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
    private static TbFaceManager avq = null;
    public static String avs = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a avr = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fg(String str);
    }

    public static TbFaceManager Cr() {
        if (avq == null) {
            avq = new TbFaceManager();
        }
        return avq;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.avr = aVar;
    }

    public com.baidu.adp.widget.a.a fe(String str) {
        return t(eH(str), str);
    }

    private com.baidu.adp.widget.a.a t(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a fj = c.Cs().fj(str);
        if (fj == null && (b = com.baidu.adp.lib.util.d.it().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            c.Cs().c(str, aVar);
            return aVar;
        }
        return fj;
    }

    public int eH(String str) {
        return this.avr.eH(str);
    }

    public a.C0049a ff(String str) {
        com.baidu.adp.widget.a.a fe;
        a.C0049a G = this.avr.G(this.mContext, str);
        if (G == null && (fe = fe(str)) != null) {
            return new a.C0049a(fe.getWidth(), fe.getHeight());
        }
        return G;
    }

    public int eI(String str) {
        return this.avr.eI(str);
    }

    public int Bd() {
        return this.avr.Bd();
    }

    public String eJ(String str) {
        return this.avr.eJ(str);
    }

    public SpannableString H(Context context, String str) {
        com.baidu.adp.widget.a.a t;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(avs).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eI = this.avr.eI(group);
            if (eI > 0 && (t = t(eI, String.valueOf(eI))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable nb = t.nb();
                nb.setBounds(0, 0, t.getWidth(), t.getHeight());
                spannableString.setSpan(new ImageSpan(nb, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fg;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(avs).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eI = this.avr.eI(group);
            if (eI > 0) {
                com.baidu.adp.widget.a.a t = t(eI, String.valueOf(eI));
                if (t != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nb = t.nb();
                    int width = (int) (0.5d * t.getWidth());
                    nb.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nb, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fg = aVar.fg(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fg, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
