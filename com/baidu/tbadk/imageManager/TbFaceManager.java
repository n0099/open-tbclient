package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.f;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager ayP = null;
    public static String ayR = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a ayQ = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fX(String str);
    }

    public static TbFaceManager Eo() {
        if (ayP == null) {
            ayP = new TbFaceManager();
        }
        return ayP;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.ayQ = aVar;
    }

    public com.baidu.adp.widget.a.a fV(String str) {
        return l(fu(str), str);
    }

    private com.baidu.adp.widget.a.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a ga = c.Ep().ga(str);
        if (ga == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Ep().c(str, aVar);
            return aVar;
        }
        return ga;
    }

    public int fu(String str) {
        return this.ayQ.fu(str);
    }

    public a.C0044a fW(String str) {
        com.baidu.adp.widget.a.a fV;
        a.C0044a y = this.ayQ.y(this.mContext, str);
        if (y == null && (fV = fV(str)) != null) {
            return new a.C0044a(fV.getWidth(), fV.getHeight());
        }
        return y;
    }

    public int fv(String str) {
        return this.ayQ.fv(str);
    }

    public int Dg() {
        return this.ayQ.Dg();
    }

    public String fw(String str) {
        return this.ayQ.fw(str);
    }

    public SpannableString z(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a l;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(ayR).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fv = this.ayQ.fv(group);
            if (fv > 0 && (l = l(fv, String.valueOf(fv))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable jX = l.jX();
                jX.setBounds(0, 0, i > 0 ? i : l.getWidth(), i2 > 0 ? i2 : l.getHeight());
                spannableString.setSpan(new f(jX), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fX;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(ayR).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fv = this.ayQ.fv(group);
            if (fv > 0) {
                com.baidu.adp.widget.a.a l = l(fv, String.valueOf(fv));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable jX = l.jX();
                    int width = (int) (0.5d * l.getWidth());
                    jX.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(jX, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fX = aVar.fX(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fX, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
