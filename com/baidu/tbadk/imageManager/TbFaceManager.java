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

    public com.baidu.adp.widget.ImageView.d a(String str) {
        return a(b(str), str);
    }

    private com.baidu.adp.widget.ImageView.d a(int i, String str) {
        Bitmap a2;
        com.baidu.adp.widget.ImageView.d c = d.a().c(str);
        if (c == null && (a2 = com.baidu.adp.lib.g.a.a().a(this.b, i)) != null) {
            com.baidu.adp.widget.ImageView.d dVar = new com.baidu.adp.widget.ImageView.d(a2, false, str);
            d.a().b(str, dVar);
            return dVar;
        }
        return c;
    }

    public int b(String str) {
        return this.c.a(str);
    }

    public b c(String str) {
        com.baidu.adp.widget.ImageView.d a2;
        b a3 = this.c.a(this.b, str);
        if (a3 == null && (a2 = a(str)) != null) {
            return new b(a2.c(), a2.d());
        }
        return a3;
    }

    public String d(String str) {
        return this.c.c(str);
    }

    public SpannableString a(Context context, String str) {
        com.baidu.adp.widget.ImageView.d a2;
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
                BitmapDrawable i = a2.i();
                i.setBounds(0, 0, a2.c(), a2.d());
                spannableString.setSpan(new ImageSpan(i, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }
}
