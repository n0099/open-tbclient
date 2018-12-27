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
    private static TbFaceManager bci = null;
    public static String bck = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a bcj = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan ie(String str);
    }

    public static TbFaceManager Nu() {
        if (bci == null) {
            bci = new TbFaceManager();
        }
        return bci;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.bcj = aVar;
    }

    public com.baidu.adp.widget.ImageView.a ib(String str) {
        return l(hE(str), str);
    }

    private com.baidu.adp.widget.ImageView.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a ii = c.Nv().ii(str);
        if (ii == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.Nv().c(str, aVar);
            return aVar;
        }
        return ii;
    }

    public int hE(String str) {
        return this.bcj.hE(str);
    }

    public a.C0171a ic(String str) {
        com.baidu.adp.widget.ImageView.a ib;
        a.C0171a al = this.bcj.al(this.mContext, str);
        if (al == null && (ib = ib(str)) != null) {
            return new a.C0171a(ib.getWidth(), ib.getHeight());
        }
        return al;
    }

    public int hF(String str) {
        return this.bcj.hF(str);
    }

    public int Ml() {
        return this.bcj.Ml();
    }

    public String hG(String str) {
        return this.bcj.hG(str);
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
        Matcher matcher = Pattern.compile(bck).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hF = this.bcj.hF(group);
            if (hF > 0 && (l = l(hF, String.valueOf(hF))) != null) {
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
        ImageSpan ie;
        ImageSpan ie2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(bck).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hF = this.bcj.hF(group);
            if (hF > 0) {
                com.baidu.adp.widget.ImageView.a l = l(hF, String.valueOf(hF));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable or = l.or();
                    int width = (int) (0.5d * l.getWidth());
                    or.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(or, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ie2 = aVar.ie(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ie2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (ie = aVar.ie(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(ie, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
