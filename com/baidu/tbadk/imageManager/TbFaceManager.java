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
    private static TbFaceManager aCC = null;
    public static String aCE = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aCD = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fF(String str);
    }

    public static TbFaceManager Ek() {
        if (aCC == null) {
            aCC = new TbFaceManager();
        }
        return aCC;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aCD = aVar;
    }

    public com.baidu.adp.widget.a.a fD(String str) {
        return m(fc(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fI = c.El().fI(str);
        if (fI == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.El().c(str, aVar);
            return aVar;
        }
        return fI;
    }

    public int fc(String str) {
        return this.aCD.fc(str);
    }

    public a.C0043a fE(String str) {
        com.baidu.adp.widget.a.a fD;
        a.C0043a S = this.aCD.S(this.mContext, str);
        if (S == null && (fD = fD(str)) != null) {
            return new a.C0043a(fD.getWidth(), fD.getHeight());
        }
        return S;
    }

    public int fd(String str) {
        return this.aCD.fd(str);
    }

    public int Dc() {
        return this.aCD.Dc();
    }

    public String fe(String str) {
        return this.aCD.fe(str);
    }

    public SpannableString T(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aCE).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fd = this.aCD.fd(group);
            if (fd > 0 && (m = m(fd, String.valueOf(fd))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kP = m.kP();
                kP.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new g(kP), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fF;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aCE).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fd = this.aCD.fd(group);
            if (fd > 0) {
                com.baidu.adp.widget.a.a m = m(fd, String.valueOf(fd));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kP = m.kP();
                    int width = (int) (0.5d * m.getWidth());
                    kP.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kP, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fF = aVar.fF(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fF, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
