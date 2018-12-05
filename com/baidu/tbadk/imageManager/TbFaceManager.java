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
    private static TbFaceManager bcf = null;
    public static String bch = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a bcg = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan ic(String str);
    }

    public static TbFaceManager Nt() {
        if (bcf == null) {
            bcf = new TbFaceManager();
        }
        return bcf;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.bcg = aVar;
    }

    public com.baidu.adp.widget.ImageView.a ia(String str) {
        return l(hD(str), str);
    }

    private com.baidu.adp.widget.ImageView.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a ih = c.Nu().ih(str);
        if (ih == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.Nu().c(str, aVar);
            return aVar;
        }
        return ih;
    }

    public int hD(String str) {
        return this.bcg.hD(str);
    }

    public a.C0171a ib(String str) {
        com.baidu.adp.widget.ImageView.a ia;
        a.C0171a al = this.bcg.al(this.mContext, str);
        if (al == null && (ia = ia(str)) != null) {
            return new a.C0171a(ia.getWidth(), ia.getHeight());
        }
        return al;
    }

    public int hE(String str) {
        return this.bcg.hE(str);
    }

    public int Mk() {
        return this.bcg.Mk();
    }

    public String hF(String str) {
        return this.bcg.hF(str);
    }

    public SpannableString am(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a l;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(bch).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hE = this.bcg.hE(group);
            if (hE > 0 && (l = l(hE, String.valueOf(hE))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable or = l.or();
                or.setBounds(0, 0, i > 0 ? i : l.getWidth(), i2 > 0 ? i2 : l.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(or), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan ic;
        ImageSpan ic2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(bch).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hE = this.bcg.hE(group);
            if (hE > 0) {
                com.baidu.adp.widget.ImageView.a l = l(hE, String.valueOf(hE));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable or = l.or();
                    int width = (int) (0.5d * l.getWidth());
                    or.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(or, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ic2 = aVar.ic(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ic2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (ic = aVar.ic(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(ic, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
