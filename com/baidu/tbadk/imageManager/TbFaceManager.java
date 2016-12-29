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
    private static TbFaceManager aym = null;
    public static String ayo = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a ayn = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fT(String str);
    }

    public static TbFaceManager DW() {
        if (aym == null) {
            aym = new TbFaceManager();
        }
        return aym;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.ayn = aVar;
    }

    public com.baidu.adp.widget.a.a fR(String str) {
        return l(fq(str), str);
    }

    private com.baidu.adp.widget.a.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fW = c.DX().fW(str);
        if (fW == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.DX().c(str, aVar);
            return aVar;
        }
        return fW;
    }

    public int fq(String str) {
        return this.ayn.fq(str);
    }

    public a.C0044a fS(String str) {
        com.baidu.adp.widget.a.a fR;
        a.C0044a y = this.ayn.y(this.mContext, str);
        if (y == null && (fR = fR(str)) != null) {
            return new a.C0044a(fR.getWidth(), fR.getHeight());
        }
        return y;
    }

    public int fr(String str) {
        return this.ayn.fr(str);
    }

    public int CP() {
        return this.ayn.CP();
    }

    public String fs(String str) {
        return this.ayn.fs(str);
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
        Matcher matcher = Pattern.compile(ayo).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fr = this.ayn.fr(group);
            if (fr > 0 && (l = l(fr, String.valueOf(fr))) != null) {
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
        ImageSpan fT;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(ayo).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fr = this.ayn.fr(group);
            if (fr > 0) {
                com.baidu.adp.widget.a.a l = l(fr, String.valueOf(fr));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable jX = l.jX();
                    int width = (int) (0.5d * l.getWidth());
                    jX.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(jX, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fT = aVar.fT(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fT, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
