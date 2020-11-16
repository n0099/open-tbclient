package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.imageManager.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager fqV = null;
    public static String fqX = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a fqW = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan Dy(String str);
    }

    public static TbFaceManager bAs() {
        if (fqV == null) {
            fqV = new TbFaceManager();
        }
        return fqV;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.fqW = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Dw(String str) {
        return aH(Dc(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aH(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a DA = c.bAt().DA(str);
        if (DA == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bAt().c(str, aVar);
            return aVar;
        }
        return DA;
    }

    public int Dc(String str) {
        return this.fqW.Dc(str);
    }

    public a.C0592a Dx(String str) {
        com.baidu.adp.widget.ImageView.a Dw;
        a.C0592a as = this.fqW.as(this.mContext, str);
        if (as == null && (Dw = Dw(str)) != null) {
            return new a.C0592a(Dw.getWidth(), Dw.getHeight());
        }
        return as;
    }

    public int Dd(String str) {
        return this.fqW.Dd(str);
    }

    public int bzf() {
        return this.fqW.bzf();
    }

    public String De(String str) {
        return this.fqW.De(str);
    }

    public SpannableString at(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aH;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fqX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Dd = this.fqW.Dd(group);
            if (Dd > 0 && (aH = aH(Dd, String.valueOf(Dd))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aH.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aH;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fqX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Dd = this.fqW.Dd(group);
            if (Dd > 0 && (aH = aH(Dd, String.valueOf(Dd))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aH.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aH.getWidth(), i2 > 0 ? i2 : aH.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan Dy;
        ImageSpan Dy2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fqX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Dd = this.fqW.Dd(group);
            if (Dd > 0) {
                com.baidu.adp.widget.ImageView.a aH = aH(Dd, String.valueOf(Dd));
                if (aH != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aH.getAsBitmapDrawable();
                    int width = (int) (0.5d * aH.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Dy2 = aVar.Dy(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Dy2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (Dy = aVar.Dy(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Dy, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
