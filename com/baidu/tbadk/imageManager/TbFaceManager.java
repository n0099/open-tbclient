package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.a.b.a.a.i;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager alb = null;
    private Context mContext = null;
    private b alc = null;

    /* loaded from: classes.dex */
    public class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    public static TbFaceManager zx() {
        if (alb == null) {
            alb = new TbFaceManager();
        }
        return alb;
    }

    private TbFaceManager() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.alc = bVar;
    }

    public com.baidu.adp.widget.a.a ep(String str) {
        return o(ed(str), str);
    }

    private com.baidu.adp.widget.a.a o(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a eu = e.zy().eu(str);
        if (eu == null && (b = com.baidu.adp.lib.util.e.it().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            e.zy().c(str, aVar);
            return aVar;
        }
        return eu;
    }

    public int ed(String str) {
        return this.alc.ed(str);
    }

    public c eq(String str) {
        com.baidu.adp.widget.a.a ep;
        c D = this.alc.D(this.mContext, str);
        if (D == null && (ep = ep(str)) != null) {
            return new c(ep.getWidth(), ep.getHeight());
        }
        return D;
    }

    public int yF() {
        return this.alc.yF();
    }

    public String ef(String str) {
        return this.alc.ef(str);
    }

    public SpannableString E(Context context, String str) {
        com.baidu.adp.widget.a.a o;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?~]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ee = this.alc.ee(group);
            if (ee > 0 && (o = o(ee, String.valueOf(ee))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable mB = o.mB();
                mB.setBounds(0, 0, o.getWidth(), o.getHeight());
                spannableString.setSpan(new ImageSpan(mB, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan er;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?~]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ee = this.alc.ee(group);
            if (ee > 0) {
                com.baidu.adp.widget.a.a o = o(ee, String.valueOf(ee));
                if (o != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable mB = o.mB();
                    int width = (int) (0.5d * o.getWidth());
                    mB.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(mB, 0), start, length + start, 33);
                }
            } else if (aVar != null && (er = aVar.er(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(er, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
