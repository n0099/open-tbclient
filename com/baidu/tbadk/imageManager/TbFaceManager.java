package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.g;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aCU = null;
    public static String aCW = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aCV = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fL(String str);
    }

    public static TbFaceManager EI() {
        if (aCU == null) {
            aCU = new TbFaceManager();
        }
        return aCU;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aCV = aVar;
    }

    public com.baidu.adp.widget.a.a fJ(String str) {
        return m(fi(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fO = c.EJ().fO(str);
        if (fO == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.EJ().c(str, aVar);
            return aVar;
        }
        return fO;
    }

    public int fi(String str) {
        return this.aCV.fi(str);
    }

    public a.C0041a fK(String str) {
        com.baidu.adp.widget.a.a fJ;
        a.C0041a W = this.aCV.W(this.mContext, str);
        if (W == null && (fJ = fJ(str)) != null) {
            return new a.C0041a(fJ.getWidth(), fJ.getHeight());
        }
        return W;
    }

    public int fj(String str) {
        return this.aCV.fj(str);
    }

    public int DA() {
        return this.aCV.DA();
    }

    public String fk(String str) {
        return this.aCV.fk(str);
    }

    public SpannableString X(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aCW).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fj = this.aCV.fj(group);
            if (fj > 0 && (m = m(fj, String.valueOf(fj))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kU = m.kU();
                kU.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new g(kU), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fL;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aCW).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fj = this.aCV.fj(group);
            if (fj > 0) {
                com.baidu.adp.widget.a.a m = m(fj, String.valueOf(fj));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kU = m.kU();
                    int width = (int) (0.5d * m.getWidth());
                    kU.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kU, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fL = aVar.fL(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fL, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
