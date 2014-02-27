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
public final class TbFaceManager {
    private static TbFaceManager a = null;
    private Context b = null;
    private b c = null;

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

    public final void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.b = context;
        this.c = bVar;
    }

    public final com.baidu.adp.widget.ImageView.b a(String str) {
        return a(b(str), str);
    }

    private com.baidu.adp.widget.ImageView.b a(int i, String str) {
        com.baidu.adp.widget.ImageView.b c = e.a().c(str);
        if (c == null) {
            com.baidu.adp.lib.util.a.a();
            Bitmap a2 = com.baidu.adp.lib.util.a.a(this.b, i);
            if (a2 != null) {
                com.baidu.adp.widget.ImageView.b bVar = new com.baidu.adp.widget.ImageView.b(a2, false, str);
                e.a().c(str, bVar);
                return bVar;
            }
            return c;
        }
        return c;
    }

    public final int b(String str) {
        return this.c.a(str);
    }

    public final c c(String str) {
        b bVar = this.c;
        Context context = this.b;
        com.baidu.adp.widget.ImageView.b a2 = a(str);
        if (a2 != null) {
            return new c(a2.c(), a2.d());
        }
        return null;
    }

    public final String d(String str) {
        return this.c.c(str);
    }

    public final SpannableString e(String str) {
        com.baidu.adp.widget.ImageView.b a2;
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

    public final SpannableString a(String str, a aVar) {
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
                com.baidu.adp.widget.ImageView.b a3 = a(b, String.valueOf(b));
                if (a3 != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable i = a3.i();
                    i.setBounds(0, 0, a3.c(), a3.d());
                    spannableString.setSpan(new ImageSpan(i, 0), start, length + start, 33);
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
