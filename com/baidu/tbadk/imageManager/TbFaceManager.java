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
    private static TbFaceManager atO = null;
    public static String atQ = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a atP = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fl(String str);
    }

    public static TbFaceManager Cb() {
        if (atO == null) {
            atO = new TbFaceManager();
        }
        return atO;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.atP = aVar;
    }

    public com.baidu.adp.widget.a.a fj(String str) {
        return u(eM(str), str);
    }

    private com.baidu.adp.widget.a.a u(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a fo = c.Cc().fo(str);
        if (fo == null && (b = com.baidu.adp.lib.util.d.iu().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            c.Cc().c(str, aVar);
            return aVar;
        }
        return fo;
    }

    public int eM(String str) {
        return this.atP.eM(str);
    }

    public a.C0049a fk(String str) {
        com.baidu.adp.widget.a.a fj;
        a.C0049a F = this.atP.F(this.mContext, str);
        if (F == null && (fj = fj(str)) != null) {
            return new a.C0049a(fj.getWidth(), fj.getHeight());
        }
        return F;
    }

    public int eN(String str) {
        return this.atP.eN(str);
    }

    public int AN() {
        return this.atP.AN();
    }

    public String eO(String str) {
        return this.atP.eO(str);
    }

    public SpannableString G(Context context, String str) {
        com.baidu.adp.widget.a.a u;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(atQ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eN = this.atP.eN(group);
            if (eN > 0 && (u = u(eN, String.valueOf(eN))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable nc = u.nc();
                nc.setBounds(0, 0, u.getWidth(), u.getHeight());
                spannableString.setSpan(new ImageSpan(nc, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fl;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(atQ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eN = this.atP.eN(group);
            if (eN > 0) {
                com.baidu.adp.widget.a.a u = u(eN, String.valueOf(eN));
                if (u != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nc = u.nc();
                    int width = (int) (0.5d * u.getWidth());
                    nc.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nc, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fl = aVar.fl(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fl, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
