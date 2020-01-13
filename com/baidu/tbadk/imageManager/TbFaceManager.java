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
    private static TbFaceManager dwf = null;
    public static String dwh = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a dwg = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan ve(String str);
    }

    public static TbFaceManager aNr() {
        if (dwf == null) {
            dwf = new TbFaceManager();
        }
        return dwf;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.dwg = aVar;
    }

    public com.baidu.adp.widget.ImageView.a vc(String str) {
        return S(uK(str), str);
    }

    private com.baidu.adp.widget.ImageView.a S(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a vg = c.aNs().vg(str);
        if (vg == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.aNs().c(str, aVar);
            return aVar;
        }
        return vg;
    }

    public int uK(String str) {
        return this.dwg.uK(str);
    }

    public a.C0381a vd(String str) {
        com.baidu.adp.widget.ImageView.a vc;
        a.C0381a aA = this.dwg.aA(this.mContext, str);
        if (aA == null && (vc = vc(str)) != null) {
            return new a.C0381a(vc.getWidth(), vc.getHeight());
        }
        return aA;
    }

    public int uL(String str) {
        return this.dwg.uL(str);
    }

    public int aMi() {
        return this.dwg.aMi();
    }

    public String uM(String str) {
        return this.dwg.uM(str);
    }

    public SpannableString aB(Context context, String str) {
        com.baidu.adp.widget.ImageView.a S;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dwh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int uL = this.dwg.uL(group);
            if (uL > 0 && (S = S(uL, String.valueOf(uL))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = S.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new f(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a S;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dwh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int uL = this.dwg.uL(group);
            if (uL > 0 && (S = S(uL, String.valueOf(uL))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = S.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : S.getWidth(), i2 > 0 ? i2 : S.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan ve;
        ImageSpan ve2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(dwh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int uL = this.dwg.uL(group);
            if (uL > 0) {
                com.baidu.adp.widget.ImageView.a S = S(uL, String.valueOf(uL));
                if (S != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = S.getAsBitmapDrawable();
                    int width = (int) (0.5d * S.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ve2 = aVar.ve(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ve2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (ve = aVar.ve(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(ve, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
