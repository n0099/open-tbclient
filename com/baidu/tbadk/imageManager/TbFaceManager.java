package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager akT = null;
    private Context mContext = null;
    private b akU = null;

    /* loaded from: classes.dex */
    public class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    public static TbFaceManager zr() {
        if (akT == null) {
            akT = new TbFaceManager();
        }
        return akT;
    }

    private TbFaceManager() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.akU = bVar;
    }

    public com.baidu.adp.widget.a.a em(String str) {
        return o(ea(str), str);
    }

    private com.baidu.adp.widget.a.a o(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a er = e.zs().er(str);
        if (er == null && (b = com.baidu.adp.lib.util.e.it().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            e.zs().c(str, aVar);
            return aVar;
        }
        return er;
    }

    public int ea(String str) {
        return this.akU.ea(str);
    }

    public c en(String str) {
        com.baidu.adp.widget.a.a em;
        c D = this.akU.D(this.mContext, str);
        if (D == null && (em = em(str)) != null) {
            return new c(em.getWidth(), em.getHeight());
        }
        return D;
    }

    public int yz() {
        return this.akU.yz();
    }

    public String ec(String str) {
        return this.akU.ec(str);
    }

    public SpannableString E(Context context, String str) {
        com.baidu.adp.widget.a.a o;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?~]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eb = this.akU.eb(group);
            if (eb > 0 && (o = o(eb, String.valueOf(eb))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable mB = o.mB();
                mB.setBounds(0, 0, o.getWidth(), o.getHeight());
                spannableString.setSpan(new ImageSpan(mB, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan eo;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?~]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eb = this.akU.eb(group);
            if (eb > 0) {
                com.baidu.adp.widget.a.a o = o(eb, String.valueOf(eb));
                if (o != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable mB = o.mB();
                    int width = (int) (0.5d * o.getWidth());
                    mB.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(mB, 0), start, length + start, 33);
                }
            } else if (aVar != null && (eo = aVar.eo(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(eo, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
