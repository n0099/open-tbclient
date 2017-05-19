package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.h;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aCT = null;
    public static String aCV = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aCU = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fI(String str);
    }

    public static TbFaceManager DM() {
        if (aCT == null) {
            aCT = new TbFaceManager();
        }
        return aCT;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aCU = aVar;
    }

    public com.baidu.adp.widget.a.a fG(String str) {
        return n(ff(str), str);
    }

    private com.baidu.adp.widget.a.a n(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fL = c.DN().fL(str);
        if (fL == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.DN().c(str, aVar);
            return aVar;
        }
        return fL;
    }

    public int ff(String str) {
        return this.aCU.ff(str);
    }

    public a.C0045a fH(String str) {
        com.baidu.adp.widget.a.a fG;
        a.C0045a W = this.aCU.W(this.mContext, str);
        if (W == null && (fG = fG(str)) != null) {
            return new a.C0045a(fG.getWidth(), fG.getHeight());
        }
        return W;
    }

    public int fg(String str) {
        return this.aCU.fg(str);
    }

    public int CE() {
        return this.aCU.CE();
    }

    public String fh(String str) {
        return this.aCU.fh(str);
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
        Matcher matcher = Pattern.compile(aCV).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fg = this.aCU.fg(group);
            if (fg > 0 && (n = n(fg, String.valueOf(fg))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kT = n.kT();
                kT.setBounds(0, 0, i > 0 ? i : n.getWidth(), i2 > 0 ? i2 : n.getHeight());
                spannableString.setSpan(new h(kT), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fI;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aCV).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fg = this.aCU.fg(group);
            if (fg > 0) {
                com.baidu.adp.widget.a.a n = n(fg, String.valueOf(fg));
                if (n != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kT = n.kT();
                    int width = (int) (0.5d * n.getWidth());
                    kT.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kT, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fI = aVar.fI(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fI, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
