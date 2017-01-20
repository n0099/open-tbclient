package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.f;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager axi = null;
    public static String axk = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a axj = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fQ(String str);
    }

    public static TbFaceManager DR() {
        if (axi == null) {
            axi = new TbFaceManager();
        }
        return axi;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.axj = aVar;
    }

    public com.baidu.adp.widget.a.a fO(String str) {
        return l(fn(str), str);
    }

    private com.baidu.adp.widget.a.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fT = c.DS().fT(str);
        if (fT == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.DS().c(str, aVar);
            return aVar;
        }
        return fT;
    }

    public int fn(String str) {
        return this.axj.fn(str);
    }

    public a.C0044a fP(String str) {
        com.baidu.adp.widget.a.a fO;
        a.C0044a y = this.axj.y(this.mContext, str);
        if (y == null && (fO = fO(str)) != null) {
            return new a.C0044a(fO.getWidth(), fO.getHeight());
        }
        return y;
    }

    public int fo(String str) {
        return this.axj.fo(str);
    }

    public int CK() {
        return this.axj.CK();
    }

    public String fp(String str) {
        return this.axj.fp(str);
    }

    public SpannableString z(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a l;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axk).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fo = this.axj.fo(group);
            if (fo > 0 && (l = l(fo, String.valueOf(fo))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable jV = l.jV();
                jV.setBounds(0, 0, i > 0 ? i : l.getWidth(), i2 > 0 ? i2 : l.getHeight());
                spannableString.setSpan(new f(jV), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fQ;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axk).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fo = this.axj.fo(group);
            if (fo > 0) {
                com.baidu.adp.widget.a.a l = l(fo, String.valueOf(fo));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable jV = l.jV();
                    int width = (int) (0.5d * l.getWidth());
                    jV.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(jV, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fQ = aVar.fQ(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fQ, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
