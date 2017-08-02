package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aEP = null;
    public static String aER = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aEQ = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan ge(String str);
    }

    public static TbFaceManager Eo() {
        if (aEP == null) {
            aEP = new TbFaceManager();
        }
        return aEP;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aEQ = aVar;
    }

    public com.baidu.adp.widget.a.a gc(String str) {
        return n(fB(str), str);
    }

    private com.baidu.adp.widget.a.a n(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a gk = c.Ep().gk(str);
        if (gk == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Ep().c(str, aVar);
            return aVar;
        }
        return gk;
    }

    public int fB(String str) {
        return this.aEQ.fB(str);
    }

    public a.C0057a gd(String str) {
        com.baidu.adp.widget.a.a gc;
        a.C0057a X = this.aEQ.X(this.mContext, str);
        if (X == null && (gc = gc(str)) != null) {
            return new a.C0057a(gc.getWidth(), gc.getHeight());
        }
        return X;
    }

    public int fC(String str) {
        return this.aEQ.fC(str);
    }

    public int Df() {
        return this.aEQ.Df();
    }

    public String fD(String str) {
        return this.aEQ.fD(str);
    }

    public SpannableString Y(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a n;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aER).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fC = this.aEQ.fC(group);
            if (fC > 0 && (n = n(fC, String.valueOf(fC))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kP = n.kP();
                kP.setBounds(0, 0, i > 0 ? i : n.getWidth(), i2 > 0 ? i2 : n.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(kP), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan ge;
        ImageSpan ge2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aER).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fC = this.aEQ.fC(group);
            if (fC > 0) {
                com.baidu.adp.widget.a.a n = n(fC, String.valueOf(fC));
                if (n != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kP = n.kP();
                    int width = (int) (0.5d * n.getWidth());
                    kP.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kP, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ge2 = aVar.ge(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ge2, start2, length2 + start2, 33);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5 && (ge = aVar.ge(group2)) != null) {
                int start3 = matcher2.start();
                spannableString.setSpan(ge, start3, group2.length() + start3, 33);
            }
        }
        return spannableString;
    }
}
