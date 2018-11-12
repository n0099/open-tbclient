package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aYH = null;
    public static String aYJ = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aYI = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan hL(String str);
    }

    public static TbFaceManager Mp() {
        if (aYH == null) {
            aYH = new TbFaceManager();
        }
        return aYH;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aYI = aVar;
    }

    public com.baidu.adp.widget.ImageView.a hJ(String str) {
        return l(hl(str), str);
    }

    private com.baidu.adp.widget.ImageView.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a hP = c.Mq().hP(str);
        if (hP == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.Mq().c(str, aVar);
            return aVar;
        }
        return hP;
    }

    public int hl(String str) {
        return this.aYI.hl(str);
    }

    public a.C0161a hK(String str) {
        com.baidu.adp.widget.ImageView.a hJ;
        a.C0161a ai = this.aYI.ai(this.mContext, str);
        if (ai == null && (hJ = hJ(str)) != null) {
            return new a.C0161a(hJ.getWidth(), hJ.getHeight());
        }
        return ai;
    }

    public int hm(String str) {
        return this.aYI.hm(str);
    }

    public int Lg() {
        return this.aYI.Lg();
    }

    public String hn(String str) {
        return this.aYI.hn(str);
    }

    public SpannableString aj(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a l;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aYJ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hm = this.aYI.hm(group);
            if (hm > 0 && (l = l(hm, String.valueOf(hm))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable os = l.os();
                os.setBounds(0, 0, i > 0 ? i : l.getWidth(), i2 > 0 ? i2 : l.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(os), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan hL;
        ImageSpan hL2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aYJ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hm = this.aYI.hm(group);
            if (hm > 0) {
                com.baidu.adp.widget.ImageView.a l = l(hm, String.valueOf(hm));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable os = l.os();
                    int width = (int) (0.5d * l.getWidth());
                    os.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(os, 0), start, length + start, 33);
                }
            } else if (aVar != null && (hL2 = aVar.hL(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(hL2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (hL = aVar.hL(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(hL, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
