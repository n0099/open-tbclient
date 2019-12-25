package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.imageManager.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager dvX = null;
    public static String dvZ = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a dvY = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan uZ(String str);
    }

    public static TbFaceManager aMY() {
        if (dvX == null) {
            dvX = new TbFaceManager();
        }
        return dvX;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.dvY = aVar;
    }

    public com.baidu.adp.widget.ImageView.a uX(String str) {
        return Q(uF(str), str);
    }

    private com.baidu.adp.widget.ImageView.a Q(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a vb = c.aMZ().vb(str);
        if (vb == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.aMZ().c(str, aVar);
            return aVar;
        }
        return vb;
    }

    public int uF(String str) {
        return this.dvY.uF(str);
    }

    public a.C0379a uY(String str) {
        com.baidu.adp.widget.ImageView.a uX;
        a.C0379a az = this.dvY.az(this.mContext, str);
        if (az == null && (uX = uX(str)) != null) {
            return new a.C0379a(uX.getWidth(), uX.getHeight());
        }
        return az;
    }

    public int uG(String str) {
        return this.dvY.uG(str);
    }

    public int aLP() {
        return this.dvY.aLP();
    }

    public String uH(String str) {
        return this.dvY.uH(str);
    }

    public SpannableString aA(Context context, String str) {
        com.baidu.adp.widget.ImageView.a Q;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dvZ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int uG = this.dvY.uG(group);
            if (uG > 0 && (Q = Q(uG, String.valueOf(uG))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = Q.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new f(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a Q;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dvZ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int uG = this.dvY.uG(group);
            if (uG > 0 && (Q = Q(uG, String.valueOf(uG))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = Q.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : Q.getWidth(), i2 > 0 ? i2 : Q.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan uZ;
        ImageSpan uZ2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dvZ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int uG = this.dvY.uG(group);
            if (uG > 0) {
                com.baidu.adp.widget.ImageView.a Q = Q(uG, String.valueOf(uG));
                if (Q != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = Q.getAsBitmapDrawable();
                    int width = (int) (0.5d * Q.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (uZ2 = aVar.uZ(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(uZ2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (uZ = aVar.uZ(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(uZ, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
