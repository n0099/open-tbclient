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
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aDK = null;
    public static String aDM = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aDL = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan ga(String str);
    }

    public static TbFaceManager Ea() {
        if (aDK == null) {
            aDK = new TbFaceManager();
        }
        return aDK;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aDL = aVar;
    }

    public com.baidu.adp.widget.a.a fY(String str) {
        return n(fx(str), str);
    }

    private com.baidu.adp.widget.a.a n(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a ge = c.Eb().ge(str);
        if (ge == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Eb().c(str, aVar);
            return aVar;
        }
        return ge;
    }

    public int fx(String str) {
        return this.aDL.fx(str);
    }

    public a.C0047a fZ(String str) {
        com.baidu.adp.widget.a.a fY;
        a.C0047a X = this.aDL.X(this.mContext, str);
        if (X == null && (fY = fY(str)) != null) {
            return new a.C0047a(fY.getWidth(), fY.getHeight());
        }
        return X;
    }

    public int fy(String str) {
        return this.aDL.fy(str);
    }

    public int CT() {
        return this.aDL.CT();
    }

    public String fz(String str) {
        return this.aDL.fz(str);
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
        Matcher matcher = Pattern.compile(aDM).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fy = this.aDL.fy(group);
            if (fy > 0 && (n = n(fy, String.valueOf(fy))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable kR = n.kR();
                kR.setBounds(0, 0, i > 0 ? i : n.getWidth(), i2 > 0 ? i2 : n.getHeight());
                spannableString.setSpan(new i(kR), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan ga;
        ImageSpan ga2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aDM).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fy = this.aDL.fy(group);
            if (fy > 0) {
                com.baidu.adp.widget.a.a n = n(fy, String.valueOf(fy));
                if (n != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable kR = n.kR();
                    int width = (int) (0.5d * n.getWidth());
                    kR.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(kR, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ga2 = aVar.ga(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ga2, start2, length2 + start2, 33);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5 && (ga = aVar.ga(group2)) != null) {
                int start3 = matcher2.start();
                spannableString.setSpan(ga, start3, group2.length() + start3, 33);
            }
        }
        return spannableString;
    }
}
