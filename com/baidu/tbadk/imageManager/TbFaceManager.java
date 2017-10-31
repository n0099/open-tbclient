package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.e;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aFm = null;
    public static String aFo = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aFn = null;

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

    public static TbFaceManager Ef() {
        if (aFm == null) {
            aFm = new TbFaceManager();
        }
        return aFm;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aFn = aVar;
    }

    public com.baidu.adp.widget.a.a gg(String str) {
        return m(fF(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a go = c.Eg().go(str);
        if (go == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Eg().c(str, aVar);
            return aVar;
        }
        return go;
    }

    public int fF(String str) {
        return this.aFn.fF(str);
    }

    public a.C0058a gh(String str) {
        com.baidu.adp.widget.a.a gg;
        a.C0058a S = this.aFn.S(this.mContext, str);
        if (S == null && (gg = gg(str)) != null) {
            return new a.C0058a(gg.getWidth(), gg.getHeight());
        }
        return S;
    }

    public int fG(String str) {
        return this.aFn.fG(str);
    }

    public int CU() {
        return this.aFn.CU();
    }

    public String fH(String str) {
        return this.aFn.fH(str);
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
        Matcher matcher = Pattern.compile(aFo).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fG = this.aFn.fG(group);
            if (fG > 0 && (m = m(fG, String.valueOf(fG))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kM = m.kM();
                kM.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new e(kM), start, start + length, 33);
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
        Matcher matcher = Pattern.compile(aFo).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fG = this.aFn.fG(group);
            if (fG > 0) {
                com.baidu.adp.widget.a.a m = m(fG, String.valueOf(fG));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kM = m.kM();
                    int width = (int) (0.5d * m.getWidth());
                    kM.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kM, 0), start, length + start, 33);
                }
            } else if (aVar != null && (gi2 = aVar.gi(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(gi2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
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
        return spannableString;
    }
}
