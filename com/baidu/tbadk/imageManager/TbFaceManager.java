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
    private static TbFaceManager axX = null;
    public static String axZ = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a axY = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fU(String str);
    }

    public static TbFaceManager Ej() {
        if (axX == null) {
            axX = new TbFaceManager();
        }
        return axX;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.axY = aVar;
    }

    public com.baidu.adp.widget.a.a fS(String str) {
        return m(fr(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fX = c.Ek().fX(str);
        if (fX == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Ek().c(str, aVar);
            return aVar;
        }
        return fX;
    }

    public int fr(String str) {
        return this.axY.fr(str);
    }

    public a.C0044a fT(String str) {
        com.baidu.adp.widget.a.a fS;
        a.C0044a y = this.axY.y(this.mContext, str);
        if (y == null && (fS = fS(str)) != null) {
            return new a.C0044a(fS.getWidth(), fS.getHeight());
        }
        return y;
    }

    public int fs(String str) {
        return this.axY.fs(str);
    }

    public int CY() {
        return this.axY.CY();
    }

    public String ft(String str) {
        return this.axY.ft(str);
    }

    public SpannableString z(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axZ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fs = this.axY.fs(group);
            if (fs > 0 && (m = m(fs, String.valueOf(fs))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable jX = m.jX();
                jX.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new f(jX), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fU;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axZ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fs = this.axY.fs(group);
            if (fs > 0) {
                com.baidu.adp.widget.a.a m = m(fs, String.valueOf(fs));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable jX = m.jX();
                    int width = (int) (0.5d * m.getWidth());
                    jX.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(jX, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fU = aVar.fU(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fU, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
