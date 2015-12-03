package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.imageManager.a;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager auF = null;
    public static String auH = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a auG = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fC(String str);
    }

    public static TbFaceManager CW() {
        if (auF == null) {
            auF = new TbFaceManager();
        }
        return auF;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.auG = aVar;
    }

    public com.baidu.adp.widget.a.a fA(String str) {
        return u(fa(str), str);
    }

    private com.baidu.adp.widget.a.a u(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a fF = c.CX().fF(str);
        if (fF == null && (b = com.baidu.adp.lib.util.d.ix().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            c.CX().c(str, aVar);
            return aVar;
        }
        return fF;
    }

    public int fa(String str) {
        return this.auG.fa(str);
    }

    public a.C0051a fB(String str) {
        com.baidu.adp.widget.a.a fA;
        a.C0051a F = this.auG.F(this.mContext, str);
        if (F == null && (fA = fA(str)) != null) {
            return new a.C0051a(fA.getWidth(), fA.getHeight());
        }
        return F;
    }

    public int fb(String str) {
        return this.auG.fb(str);
    }

    public int BL() {
        return this.auG.BL();
    }

    public String fc(String str) {
        return this.auG.fc(str);
    }

    public SpannableString G(Context context, String str) {
        com.baidu.adp.widget.a.a u;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(auH).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fb = this.auG.fb(group);
            if (fb > 0 && (u = u(fb, String.valueOf(fb))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable ni = u.ni();
                ni.setBounds(0, 0, u.getWidth(), u.getHeight());
                spannableString.setSpan(new ImageSpan(ni, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fC;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(auH).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fb = this.auG.fb(group);
            if (fb > 0) {
                com.baidu.adp.widget.a.a u = u(fb, String.valueOf(fb));
                if (u != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable ni = u.ni();
                    int width = (int) (0.5d * u.getWidth());
                    ni.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(ni, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fC = aVar.fC(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fC, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
