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
    private static TbFaceManager atG = null;
    public static String atI = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a atH = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan eY(String str);
    }

    public static TbFaceManager Cd() {
        if (atG == null) {
            atG = new TbFaceManager();
        }
        return atG;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.atH = aVar;
    }

    public com.baidu.adp.widget.a.a eW(String str) {
        return t(ez(str), str);
    }

    private com.baidu.adp.widget.a.a t(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a fb = c.Ce().fb(str);
        if (fb == null && (b = com.baidu.adp.lib.util.d.iw().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            c.Ce().c(str, aVar);
            return aVar;
        }
        return fb;
    }

    public int ez(String str) {
        return this.atH.ez(str);
    }

    public a.C0049a eX(String str) {
        com.baidu.adp.widget.a.a eW;
        a.C0049a G = this.atH.G(this.mContext, str);
        if (G == null && (eW = eW(str)) != null) {
            return new a.C0049a(eW.getWidth(), eW.getHeight());
        }
        return G;
    }

    public int eA(String str) {
        return this.atH.eA(str);
    }

    public int AQ() {
        return this.atH.AQ();
    }

    public String eB(String str) {
        return this.atH.eB(str);
    }

    public SpannableString H(Context context, String str) {
        com.baidu.adp.widget.a.a t;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(atI).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eA = this.atH.eA(group);
            if (eA > 0 && (t = t(eA, String.valueOf(eA))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable ne = t.ne();
                ne.setBounds(0, 0, t.getWidth(), t.getHeight());
                spannableString.setSpan(new ImageSpan(ne, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan eY;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(atI).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int eA = this.atH.eA(group);
            if (eA > 0) {
                com.baidu.adp.widget.a.a t = t(eA, String.valueOf(eA));
                if (t != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable ne = t.ne();
                    int width = (int) (0.5d * t.getWidth());
                    ne.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(ne, 0), start, length + start, 33);
                }
            } else if (aVar != null && (eY = aVar.eY(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(eY, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
