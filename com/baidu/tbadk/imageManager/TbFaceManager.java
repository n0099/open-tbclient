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
    private static TbFaceManager aaT = null;
    private Context mContext = null;
    private b aaU = null;

    /* loaded from: classes.dex */
    public class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    public static TbFaceManager vK() {
        if (aaT == null) {
            aaT = new TbFaceManager();
        }
        return aaT;
    }

    private TbFaceManager() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aaU = bVar;
    }

    public com.baidu.adp.widget.a.a ei(String str) {
        return q(dZ(str), str);
    }

    private com.baidu.adp.widget.a.a q(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a en = e.vL().en(str);
        if (en == null && (b = com.baidu.adp.lib.util.c.eS().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            e.vL().c(str, aVar);
            return aVar;
        }
        return en;
    }

    public int dZ(String str) {
        return this.aaU.dZ(str);
    }

    public c ej(String str) {
        com.baidu.adp.widget.a.a ei;
        c E = this.aaU.E(this.mContext, str);
        if (E == null && (ei = ei(str)) != null) {
            return new c(ei.getWidth(), ei.getHeight());
        }
        return E;
    }

    public int va() {
        return this.aaU.va();
    }

    public String eb(String str) {
        return this.aaU.eb(str);
    }

    public SpannableString F(Context context, String str) {
        com.baidu.adp.widget.a.a q;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ea = this.aaU.ea(group);
            if (ea > 0 && (q = q(ea, String.valueOf(ea))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable jk = q.jk();
                jk.setBounds(0, 0, q.getWidth(), q.getHeight());
                spannableString.setSpan(new ImageSpan(jk, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan ek;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ea = this.aaU.ea(group);
            if (ea > 0) {
                com.baidu.adp.widget.a.a q = q(ea, String.valueOf(ea));
                if (q != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable jk = q.jk();
                    jk.setBounds(0, 0, q.getWidth(), q.getHeight());
                    spannableString.setSpan(new ImageSpan(jk, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ek = aVar.ek(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ek, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
