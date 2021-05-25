package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.m0.a0.a;
import d.a.m0.a0.c;
import d.a.m0.b1.d;
import d.a.m0.r.f0.e;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class TbFaceManager {

    /* renamed from: c  reason: collision with root package name */
    public static TbFaceManager f12844c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f12845d = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";

    /* renamed from: a  reason: collision with root package name */
    public Context f12846a = null;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a0.a f12847b = null;

    /* loaded from: classes3.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        public static final long serialVersionUID = -3736301305777944719L;

        /* renamed from: c  reason: collision with root package name */
        public String f12848c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes3.dex */
    public interface a {
        ImageSpan a(String str);
    }

    public static TbFaceManager e() {
        if (f12844c == null) {
            f12844c = new TbFaceManager();
        }
        return f12844c;
    }

    public d.a.c.j.d.a a(String str) {
        return d(b(str), str);
    }

    public int b(String str) {
        return this.f12847b.d(str);
    }

    public a.C1099a c(String str) {
        d.a.c.j.d.a a2;
        a.C1099a c2 = this.f12847b.c(this.f12846a, str);
        return (c2 != null || (a2 = a(str)) == null) ? c2 : new a.C1099a(a2.r(), a2.m());
    }

    public final d.a.c.j.d.a d(int i2, String str) {
        Bitmap resBitmap;
        d.a.c.j.d.a m = c.k().m(str);
        if (m != null || (resBitmap = BitmapHelper.getResBitmap(this.f12846a, i2)) == null) {
            return m;
        }
        d.a.c.j.d.a aVar = new d.a.c.j.d.a(resBitmap, false, str);
        c.k().d(str, aVar);
        return aVar;
    }

    public String f(String str) {
        return this.f12847b.b(str);
    }

    public int g(String str) {
        return this.f12847b.e(str);
    }

    public int h() {
        return this.f12847b.a();
    }

    public void i(Context context, d.a.m0.a0.a aVar) {
        if (context != null && aVar != null) {
            this.f12846a = context;
            this.f12847b = aVar;
            return;
        }
        throw new InvalidParameterException("TbFaceManager initial error");
    }

    public SpannableString j(Context context, String str) {
        d.a.c.j.d.a d2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(f12845d).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int e2 = this.f12847b.e(group);
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

    public SpannableString k(Context context, String str, int i2, int i3) {
        d.a.c.j.d.a d2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(f12845d).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int e2 = this.f12847b.e(group);
            if (e2 > 0 && (d2 = d(e2, String.valueOf(e2))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable j = d2.j();
                j.setBounds(0, 0, i2 > 0 ? i2 : d2.r(), i3 > 0 ? i3 : d2.m());
                spannableString.setSpan(new d(j), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString l(Context context, String str, a aVar) {
        ImageSpan a2;
        double d2;
        int r;
        ImageSpan a3;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(f12845d).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int e2 = this.f12847b.e(group);
            if (e2 > 0) {
                d.a.c.j.d.a d3 = d(e2, String.valueOf(e2));
                if (d3 != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = d3.j();
                    if (d.a.m0.b.d.G()) {
                        d2 = 0.4d;
                        r = d3.r();
                    } else {
                        d2 = 0.5d;
                        r = d3.r();
                    }
                    int i2 = (int) (r * d2);
                    j.setBounds(0, 0, i2, i2);
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
