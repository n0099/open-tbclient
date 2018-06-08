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
    private static TbFaceManager aPj = null;
    public static String aPl = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aPk = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan ha(String str);
    }

    public static TbFaceManager IC() {
        if (aPj == null) {
            aPj = new TbFaceManager();
        }
        return aPj;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aPk = aVar;
    }

    public com.baidu.adp.widget.ImageView.a gY(String str) {
        return k(gA(str), str);
    }

    private com.baidu.adp.widget.ImageView.a k(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a he = c.ID().he(str);
        if (he == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.ID().c(str, aVar);
            return aVar;
        }
        return he;
    }

    public int gA(String str) {
        return this.aPk.gA(str);
    }

    public a.C0115a gZ(String str) {
        com.baidu.adp.widget.ImageView.a gY;
        a.C0115a T = this.aPk.T(this.mContext, str);
        if (T == null && (gY = gY(str)) != null) {
            return new a.C0115a(gY.getWidth(), gY.getHeight());
        }
        return T;
    }

    public int gB(String str) {
        return this.aPk.gB(str);
    }

    public int Ht() {
        return this.aPk.Ht();
    }

    public String gC(String str) {
        return this.aPk.gC(str);
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
        Matcher matcher = Pattern.compile(aPl).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gB = this.aPk.gB(group);
            if (gB > 0 && (k = k(gB, String.valueOf(gB))) != null) {
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
        ImageSpan ha;
        ImageSpan ha2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aPl).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gB = this.aPk.gB(group);
            if (gB > 0) {
                com.baidu.adp.widget.ImageView.a k = k(gB, String.valueOf(gB));
                if (k != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nb = k.nb();
                    int width = (int) (0.5d * k.getWidth());
                    nb.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nb, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ha2 = aVar.ha(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ha2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (ha = aVar.ha(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(ha, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
