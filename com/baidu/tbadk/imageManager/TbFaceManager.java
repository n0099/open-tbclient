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
    private static TbFaceManager aQf = null;
    public static String aQh = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aQg = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan he(String str);
    }

    public static TbFaceManager IU() {
        if (aQf == null) {
            aQf = new TbFaceManager();
        }
        return aQf;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aQg = aVar;
    }

    public com.baidu.adp.widget.ImageView.a hc(String str) {
        return k(gE(str), str);
    }

    private com.baidu.adp.widget.ImageView.a k(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a hi = c.IV().hi(str);
        if (hi == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.IV().c(str, aVar);
            return aVar;
        }
        return hi;
    }

    public int gE(String str) {
        return this.aQg.gE(str);
    }

    public a.C0116a hd(String str) {
        com.baidu.adp.widget.ImageView.a hc;
        a.C0116a T = this.aQg.T(this.mContext, str);
        if (T == null && (hc = hc(str)) != null) {
            return new a.C0116a(hc.getWidth(), hc.getHeight());
        }
        return T;
    }

    public int gF(String str) {
        return this.aQg.gF(str);
    }

    public int HL() {
        return this.aQg.HL();
    }

    public String gG(String str) {
        return this.aQg.gG(str);
    }

    public SpannableString U(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a k;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aQh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gF = this.aQg.gF(group);
            if (gF > 0 && (k = k(gF, String.valueOf(gF))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable nb = k.nb();
                nb.setBounds(0, 0, i > 0 ? i : k.getWidth(), i2 > 0 ? i2 : k.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(nb), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan he;
        ImageSpan he2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aQh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gF = this.aQg.gF(group);
            if (gF > 0) {
                com.baidu.adp.widget.ImageView.a k = k(gF, String.valueOf(gF));
                if (k != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nb = k.nb();
                    int width = (int) (0.5d * k.getWidth());
                    nb.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nb, 0), start, length + start, 33);
                }
            } else if (aVar != null && (he2 = aVar.he(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(he2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (he = aVar.he(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(he, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
