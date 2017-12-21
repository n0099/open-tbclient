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
    private static TbFaceManager aGc = null;
    public static String aGe = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aGd = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan gl(String str);
    }

    public static TbFaceManager Ez() {
        if (aGc == null) {
            aGc = new TbFaceManager();
        }
        return aGc;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aGd = aVar;
    }

    public com.baidu.adp.widget.a.a gj(String str) {
        return m(fL(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a gr = c.EA().gr(str);
        if (gr == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.EA().c(str, aVar);
            return aVar;
        }
        return gr;
    }

    public int fL(String str) {
        return this.aGd.fL(str);
    }

    public a.C0071a gk(String str) {
        com.baidu.adp.widget.a.a gj;
        a.C0071a S = this.aGd.S(this.mContext, str);
        if (S == null && (gj = gj(str)) != null) {
            return new a.C0071a(gj.getWidth(), gj.getHeight());
        }
        return S;
    }

    public int fM(String str) {
        return this.aGd.fM(str);
    }

    public int Dr() {
        return this.aGd.Dr();
    }

    public String fN(String str) {
        return this.aGd.fN(str);
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
        Matcher matcher = Pattern.compile(aGe).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fM = this.aGd.fM(group);
            if (fM > 0 && (m = m(fM, String.valueOf(fM))) != null) {
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
        ImageSpan gl;
        ImageSpan gl2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aGe).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fM = this.aGd.fM(group);
            if (fM > 0) {
                com.baidu.adp.widget.a.a m = m(fM, String.valueOf(fM));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kM = m.kM();
                    int width = (int) (0.5d * m.getWidth());
                    kM.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kM, 0), start, length + start, 33);
                }
            } else if (aVar != null && (gl2 = aVar.gl(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(gl2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (gl = aVar.gl(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(gl, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
