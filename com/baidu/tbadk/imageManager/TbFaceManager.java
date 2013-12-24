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
    private a c = null;

    /* loaded from: classes.dex */
    public class RichUnit implements Serializable {
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

    public void a(Context context, a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.b = context;
        this.c = aVar;
    }

    public com.baidu.adp.widget.ImageView.e a(String str) {
        return a(b(str), str);
    }

    private com.baidu.adp.widget.ImageView.e a(int i, String str) {
        Bitmap a2;
        com.baidu.adp.widget.ImageView.e c = d.a().c(str);
        if (c == null && (a2 = com.baidu.adp.lib.h.a.a().a(this.b, i)) != null) {
            com.baidu.adp.widget.ImageView.e eVar = new com.baidu.adp.widget.ImageView.e(a2, false, str);
            d.a().b(str, eVar);
            return eVar;
        }
        return c;
    }

    public int b(String str) {
        return this.c.a(str);
    }

    public b c(String str) {
        com.baidu.adp.widget.ImageView.e a2;
        b a3 = this.c.a(this.b, str);
        if (a3 == null && (a2 = a(str)) != null) {
            return new b(a2.a(), a2.b());
        }
        return a3;
    }

    public int b() {
        return this.c.a();
    }

    public String d(String str) {
        return this.c.c(str);
    }

    public int a(int i) {
        return this.c.a(i);
    }

    public com.baidu.adp.widget.ImageView.e b(int i) {
        int a2 = a(i);
        return a(a2, String.valueOf(a2));
    }

    public String c(int i) {
        return this.c.b(i);
    }

    public SpannableString a(Context context, String str) {
        com.baidu.adp.widget.ImageView.e a2;
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
                BitmapDrawable g = a2.g();
                g.setBounds(0, 0, a2.a(), a2.b());
                spannableString.setSpan(new ImageSpan(g, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }
}
