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
    private static TbFaceManager asC = null;
    public static String asE = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a asD = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fn(String str);
    }

    public static TbFaceManager BU() {
        if (asC == null) {
            asC = new TbFaceManager();
        }
        return asC;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.asD = aVar;
    }

    public com.baidu.adp.widget.a.a fl(String str) {
        return t(eM(str), str);
    }

    private com.baidu.adp.widget.a.a t(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a fq = c.BV().fq(str);
        if (fq == null && (b = com.baidu.adp.lib.util.d.iv().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            c.BV().c(str, aVar);
            return aVar;
        }
        return fq;
    }

    public int eM(String str) {
        return this.asD.eM(str);
    }

    public a.C0049a fm(String str) {
        com.baidu.adp.widget.a.a fl;
        a.C0049a F = this.asD.F(this.mContext, str);
        if (F == null && (fl = fl(str)) != null) {
            return new a.C0049a(fl.getWidth(), fl.getHeight());
        }
        return F;
    }

    public int eN(String str) {
        return this.asD.eN(str);
    }

    public int AN() {
        return this.asD.AN();
    }

    public String eO(String str) {
        return this.asD.eO(str);
    }

    public SpannableString G(Context context, String str) {
        com.baidu.adp.widget.a.a t;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(asE).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eN = this.asD.eN(group);
            if (eN > 0 && (t = t(eN, String.valueOf(eN))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable nd = t.nd();
                nd.setBounds(0, 0, t.getWidth(), t.getHeight());
                spannableString.setSpan(new ImageSpan(nd, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fn;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(asE).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eN = this.asD.eN(group);
            if (eN > 0) {
                com.baidu.adp.widget.a.a t = t(eN, String.valueOf(eN));
                if (t != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nd = t.nd();
                    int width = (int) (0.5d * t.getWidth());
                    nd.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nd, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fn = aVar.fn(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fn, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
