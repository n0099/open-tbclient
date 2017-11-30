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
    private static TbFaceManager aFV = null;
    public static String aFX = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aFW = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan gm(String str);
    }

    public static TbFaceManager Ey() {
        if (aFV == null) {
            aFV = new TbFaceManager();
        }
        return aFV;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aFW = aVar;
    }

    public com.baidu.adp.widget.a.a gk(String str) {
        return m(fM(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a gt = c.Ez().gt(str);
        if (gt == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Ez().c(str, aVar);
            return aVar;
        }
        return gt;
    }

    public int fM(String str) {
        return this.aFW.fM(str);
    }

    public a.C0058a gl(String str) {
        com.baidu.adp.widget.a.a gk;
        a.C0058a T = this.aFW.T(this.mContext, str);
        if (T == null && (gk = gk(str)) != null) {
            return new a.C0058a(gk.getWidth(), gk.getHeight());
        }
        return T;
    }

    public int fN(String str) {
        return this.aFW.fN(str);
    }

    public int Dq() {
        return this.aFW.Dq();
    }

    public String fO(String str) {
        return this.aFW.fO(str);
    }

    public SpannableString U(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aFX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fN = this.aFW.fN(group);
            if (fN > 0 && (m = m(fN, String.valueOf(fN))) != null) {
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
        ImageSpan gm;
        ImageSpan gm2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aFX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fN = this.aFW.fN(group);
            if (fN > 0) {
                com.baidu.adp.widget.a.a m = m(fN, String.valueOf(fN));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kM = m.kM();
                    int width = (int) (0.5d * m.getWidth());
                    kM.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kM, 0), start, length + start, 33);
                }
            } else if (aVar != null && (gm2 = aVar.gm(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(gm2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (gm = aVar.gm(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(gm, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
