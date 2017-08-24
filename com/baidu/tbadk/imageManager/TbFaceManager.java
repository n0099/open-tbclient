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
    private static TbFaceManager aGh = null;
    public static String aGj = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aGi = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan go(String str);
    }

    public static TbFaceManager Ew() {
        if (aGh == null) {
            aGh = new TbFaceManager();
        }
        return aGh;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aGi = aVar;
    }

    public com.baidu.adp.widget.a.a gm(String str) {
        return n(fL(str), str);
    }

    private com.baidu.adp.widget.a.a n(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a gt = c.Ex().gt(str);
        if (gt == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Ex().c(str, aVar);
            return aVar;
        }
        return gt;
    }

    public int fL(String str) {
        return this.aGi.fL(str);
    }

    public a.C0057a gn(String str) {
        com.baidu.adp.widget.a.a gm;
        a.C0057a X = this.aGi.X(this.mContext, str);
        if (X == null && (gm = gm(str)) != null) {
            return new a.C0057a(gm.getWidth(), gm.getHeight());
        }
        return X;
    }

    public int fM(String str) {
        return this.aGi.fM(str);
    }

    public int Dn() {
        return this.aGi.Dn();
    }

    public String fN(String str) {
        return this.aGi.fN(str);
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
        Matcher matcher = Pattern.compile(aGj).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fM = this.aGi.fM(group);
            if (fM > 0 && (n = n(fM, String.valueOf(fM))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kY = n.kY();
                kY.setBounds(0, 0, i > 0 ? i : n.getWidth(), i2 > 0 ? i2 : n.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(kY), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan go;
        ImageSpan go2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aGj).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fM = this.aGi.fM(group);
            if (fM > 0) {
                com.baidu.adp.widget.a.a n = n(fM, String.valueOf(fM));
                if (n != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kY = n.kY();
                    int width = (int) (0.5d * n.getWidth());
                    kY.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kY, 0), start, length + start, 33);
                }
            } else if (aVar != null && (go2 = aVar.go(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(go2, start2, length2 + start2, 33);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5 && (go = aVar.go(group2)) != null) {
                int start3 = matcher2.start();
                spannableString.setSpan(go, start3, group2.length() + start3, 33);
            }
        }
        return spannableString;
    }
}
