package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager a = null;
    private Context b = null;
    private b c = null;

    /* loaded from: classes.dex */
    public class RichUnit implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    public static TbFaceManager a() {
        if (a == null) {
            a = new TbFaceManager();
        }
        return a;
    }

    private TbFaceManager() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.b = context;
        this.c = bVar;
    }

    public com.baidu.adp.widget.a.a a(String str) {
        return a(b(str), str);
    }

    private com.baidu.adp.widget.a.a a(int i, String str) {
        Bitmap a2;
        com.baidu.adp.widget.a.a c = e.a().c(str);
        if (c == null && (a2 = com.baidu.adp.lib.util.b.a().a(this.b, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(a2, false, str);
            e.a().b(str, aVar);
            return aVar;
        }
        return c;
    }

    public int b(String str) {
        return this.c.a(str);
    }

    public c c(String str) {
        com.baidu.adp.widget.a.a a2;
        c a3 = this.c.a(this.b, str);
        if (a3 == null && (a2 = a(str)) != null) {
            return new c(a2.c(), a2.d());
        }
        return a3;
    }

    public int b() {
        return this.c.a();
    }

    public String d(String str) {
        return this.c.c(str);
    }

    public SpannableString a(Context context, String str) {
        com.baidu.adp.widget.a.a a2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int b = this.c.b(group);
            if (b > 0 && (a2 = a(b, String.valueOf(b))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable j = a2.j();
                j.setBounds(0, 0, a2.c(), a2.d());
                spannableString.setSpan(new ImageSpan(j, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan a2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int b = this.c.b(group);
            if (b > 0) {
                com.baidu.adp.widget.a.a a3 = a(b, String.valueOf(b));
                if (a3 != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = a3.j();
                    j.setBounds(0, 0, a3.c(), a3.d());
                    spannableString.setSpan(new ImageSpan(j, 0), start, length + start, 33);
                }
            } else if (aVar != null && (a2 = aVar.a(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(a2, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
