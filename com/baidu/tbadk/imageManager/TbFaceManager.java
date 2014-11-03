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
    private static TbFaceManager UP = null;
    private Context mContext = null;
    private b UQ = null;

    /* loaded from: classes.dex */
    public class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    public static TbFaceManager sh() {
        if (UP == null) {
            UP = new TbFaceManager();
        }
        return UP;
    }

    private TbFaceManager() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.UQ = bVar;
    }

    public com.baidu.adp.widget.a.a dn(String str) {
        return h(dd(str), str);
    }

    private com.baidu.adp.widget.a.a h(int i, String str) {
        Bitmap a;
        com.baidu.adp.widget.a.a dt = e.si().dt(str);
        if (dt == null && (a = com.baidu.adp.lib.util.c.eS().a(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(a, false, str);
            e.si().c(str, aVar);
            return aVar;
        }
        return dt;
    }

    public int dd(String str) {
        return this.UQ.dd(str);
    }

    public c dp(String str) {
        com.baidu.adp.widget.a.a dn;
        c p = this.UQ.p(this.mContext, str);
        if (p == null && (dn = dn(str)) != null) {
            return new c(dn.getWidth(), dn.getHeight());
        }
        return p;
    }

    public int rz() {
        return this.UQ.rz();
    }

    public String df(String str) {
        return this.UQ.df(str);
    }

    public SpannableString q(Context context, String str) {
        com.baidu.adp.widget.a.a h;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int de = this.UQ.de(group);
            if (de > 0 && (h = h(de, String.valueOf(de))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable hn = h.hn();
                hn.setBounds(0, 0, h.getWidth(), h.getHeight());
                spannableString.setSpan(new ImageSpan(hn, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan dq;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int de = this.UQ.de(group);
            if (de > 0) {
                com.baidu.adp.widget.a.a h = h(de, String.valueOf(de));
                if (h != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable hn = h.hn();
                    hn.setBounds(0, 0, h.getWidth(), h.getHeight());
                    spannableString.setSpan(new ImageSpan(hn, 0), start, length + start, 33);
                }
            } else if (aVar != null && (dq = aVar.dq(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(dq, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
