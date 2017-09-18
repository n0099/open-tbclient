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
    private static TbFaceManager aFw = null;
    public static String aFy = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aFx = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan gi(String str);
    }

    public static TbFaceManager Eu() {
        if (aFw == null) {
            aFw = new TbFaceManager();
        }
        return aFw;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aFx = aVar;
    }

    public com.baidu.adp.widget.a.a gg(String str) {
        return m(fG(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a go = c.Ev().go(str);
        if (go == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Ev().c(str, aVar);
            return aVar;
        }
        return go;
    }

    public int fG(String str) {
        return this.aFx.fG(str);
    }

    public a.C0059a gh(String str) {
        com.baidu.adp.widget.a.a gg;
        a.C0059a X = this.aFx.X(this.mContext, str);
        if (X == null && (gg = gg(str)) != null) {
            return new a.C0059a(gg.getWidth(), gg.getHeight());
        }
        return X;
    }

    public int fH(String str) {
        return this.aFx.fH(str);
    }

    public int Di() {
        return this.aFx.Di();
    }

    public String fI(String str) {
        return this.aFx.fI(str);
    }

    public SpannableString Y(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aFy).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fH = this.aFx.fH(group);
            if (fH > 0 && (m = m(fH, String.valueOf(fH))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kQ = m.kQ();
                kQ.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(kQ), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan gi;
        ImageSpan gi2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aFy).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fH = this.aFx.fH(group);
            if (fH > 0) {
                com.baidu.adp.widget.a.a m = m(fH, String.valueOf(fH));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kQ = m.kQ();
                    int width = (int) (0.5d * m.getWidth());
                    kQ.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kQ, 0), start, length + start, 33);
                }
            } else if (aVar != null && (gi2 = aVar.gi(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(gi2, start2, length2 + start2, 33);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5 && (gi = aVar.gi(group2)) != null) {
                int start3 = matcher2.start();
                spannableString.setSpan(gi, start3, group2.length() + start3, 33);
            }
        }
        return spannableString;
    }
}
