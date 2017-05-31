package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.i;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aCG = null;
    public static String aCI = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aCH = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fG(String str);
    }

    public static TbFaceManager DG() {
        if (aCG == null) {
            aCG = new TbFaceManager();
        }
        return aCG;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aCH = aVar;
    }

    public com.baidu.adp.widget.a.a fE(String str) {
        return n(fd(str), str);
    }

    private com.baidu.adp.widget.a.a n(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fK = c.DH().fK(str);
        if (fK == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.DH().c(str, aVar);
            return aVar;
        }
        return fK;
    }

    public int fd(String str) {
        return this.aCH.fd(str);
    }

    public a.C0045a fF(String str) {
        com.baidu.adp.widget.a.a fE;
        a.C0045a W = this.aCH.W(this.mContext, str);
        if (W == null && (fE = fE(str)) != null) {
            return new a.C0045a(fE.getWidth(), fE.getHeight());
        }
        return W;
    }

    public int fe(String str) {
        return this.aCH.fe(str);
    }

    public int Cy() {
        return this.aCH.Cy();
    }

    public String ff(String str) {
        return this.aCH.ff(str);
    }

    public SpannableString X(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a n;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aCI).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fe = this.aCH.fe(group);
            if (fe > 0 && (n = n(fe, String.valueOf(fe))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kT = n.kT();
                kT.setBounds(0, 0, i > 0 ? i : n.getWidth(), i2 > 0 ? i2 : n.getHeight());
                spannableString.setSpan(new i(kT), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fG;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aCI).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fe = this.aCH.fe(group);
            if (fe > 0) {
                com.baidu.adp.widget.a.a n = n(fe, String.valueOf(fe));
                if (n != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kT = n.kT();
                    int width = (int) (0.5d * n.getWidth());
                    kT.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kT, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fG = aVar.fG(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fG, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
