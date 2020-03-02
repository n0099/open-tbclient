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
    private static TbFaceManager dAm = null;
    public static String dAo = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a dAn = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan vv(String str);
    }

    public static TbFaceManager aPP() {
        if (dAm == null) {
            dAm = new TbFaceManager();
        }
        return dAm;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.dAn = aVar;
    }

    public com.baidu.adp.widget.ImageView.a vt(String str) {
        return U(vb(str), str);
    }

    private com.baidu.adp.widget.ImageView.a U(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a vx = c.aPQ().vx(str);
        if (vx == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.aPQ().c(str, aVar);
            return aVar;
        }
        return vx;
    }

    public int vb(String str) {
        return this.dAn.vb(str);
    }

    public a.C0391a vu(String str) {
        com.baidu.adp.widget.ImageView.a vt;
        a.C0391a aA = this.dAn.aA(this.mContext, str);
        if (aA == null && (vt = vt(str)) != null) {
            return new a.C0391a(vt.getWidth(), vt.getHeight());
        }
        return aA;
    }

    public int vc(String str) {
        return this.dAn.vc(str);
    }

    public int aOG() {
        return this.dAn.aOG();
    }

    public String vd(String str) {
        return this.dAn.vd(str);
    }

    public SpannableString aB(Context context, String str) {
        com.baidu.adp.widget.ImageView.a U;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dAo).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int vc = this.dAn.vc(group);
            if (vc > 0 && (U = U(vc, String.valueOf(vc))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = U.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new f(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a U;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dAo).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int vc = this.dAn.vc(group);
            if (vc > 0 && (U = U(vc, String.valueOf(vc))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = U.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : U.getWidth(), i2 > 0 ? i2 : U.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan vv;
        ImageSpan vv2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dAo).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int vc = this.dAn.vc(group);
            if (vc > 0) {
                com.baidu.adp.widget.ImageView.a U = U(vc, String.valueOf(vc));
                if (U != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = U.getAsBitmapDrawable();
                    int width = (int) (0.5d * U.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (vv2 = aVar.vv(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(vv2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (vv = aVar.vv(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(vv, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
