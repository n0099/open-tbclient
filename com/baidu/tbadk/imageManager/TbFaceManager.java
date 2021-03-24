package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.b.h0.a0.a;
import d.b.h0.a0.c;
import d.b.h0.b1.d;
import d.b.h0.r.f0.e;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {

    /* renamed from: c  reason: collision with root package name */
    public static TbFaceManager f13933c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f13934d = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";

    /* renamed from: a  reason: collision with root package name */
    public Context f13935a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a0.a f13936b = null;

    /* loaded from: classes3.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        public static final long serialVersionUID = -3736301305777944719L;

        /* renamed from: c  reason: collision with root package name */
        public String f13937c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes3.dex */
    public interface a {
        ImageSpan a(String str);
    }

    public static TbFaceManager e() {
        if (f13933c == null) {
            f13933c = new TbFaceManager();
        }
        return f13933c;
    }

    public d.b.b.j.d.a a(String str) {
        return d(b(str), str);
    }

    public int b(String str) {
        return this.f13936b.c(str);
    }

    public a.C1042a c(String str) {
        d.b.b.j.d.a a2;
        a.C1042a a3 = this.f13936b.a(this.f13935a, str);
        return (a3 != null || (a2 = a(str)) == null) ? a3 : new a.C1042a(a2.r(), a2.m());
    }

    public final d.b.b.j.d.a d(int i, String str) {
        Bitmap resBitmap;
        d.b.b.j.d.a l = c.j().l(str);
        if (l != null || (resBitmap = BitmapHelper.getResBitmap(this.f13935a, i)) == null) {
            return l;
        }
        d.b.b.j.d.a aVar = new d.b.b.j.d.a(resBitmap, false, str);
        c.j().d(str, aVar);
        return aVar;
    }

    public String f(String str) {
        return this.f13936b.d(str);
    }

    public int g(String str) {
        return this.f13936b.e(str);
    }

    public int h() {
        return this.f13936b.b();
    }

    public void i(Context context, d.b.h0.a0.a aVar) {
        if (context != null && aVar != null) {
            this.f13935a = context;
            this.f13936b = aVar;
            return;
        }
        throw new InvalidParameterException("TbFaceManager initial error");
    }

    public SpannableString j(Context context, String str) {
        d.b.b.j.d.a d2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(f13934d).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int e2 = this.f13936b.e(group);
            if (e2 > 0 && (d2 = d(e2, String.valueOf(e2))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable j = d2.j();
                j.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(j, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString k(Context context, String str, int i, int i2) {
        d.b.b.j.d.a d2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(f13934d).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int e2 = this.f13936b.e(group);
            if (e2 > 0 && (d2 = d(e2, String.valueOf(e2))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable j = d2.j();
                j.setBounds(0, 0, i > 0 ? i : d2.r(), i2 > 0 ? i2 : d2.m());
                spannableString.setSpan(new d(j), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString l(Context context, String str, a aVar) {
        ImageSpan a2;
        ImageSpan a3;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(f13934d).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int e2 = this.f13936b.e(group);
            if (e2 > 0) {
                d.b.b.j.d.a d2 = d(e2, String.valueOf(e2));
                if (d2 != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = d2.j();
                    double r = d2.r();
                    Double.isNaN(r);
                    int i = (int) (r * 0.5d);
                    j.setBounds(0, 0, i, i);
                    spannableString.setSpan(new ImageSpan(j, 0), start, length + start, 33);
                }
            } else if (aVar != null && (a3 = aVar.a(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(a3, start2, length2 + start2, 33);
            }
        }
        if (aVar == null) {
            return spannableString;
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String[] split = group2.split(",");
            if (split != null && split.length == 5 && (a2 = aVar.a(group2)) != null) {
                int start3 = matcher2.start();
                spannableString.setSpan(a2, start3, group2.length() + start3, 33);
            }
        }
        return spannableString;
    }
}
