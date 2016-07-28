package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager avn = null;
    public static String avp = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a avo = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fN(String str);
    }

    public static TbFaceManager CO() {
        if (avn == null) {
            avn = new TbFaceManager();
        }
        return avn;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.avo = aVar;
    }

    public com.baidu.adp.widget.a.a fL(String str) {
        return m(fm(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fQ = c.CP().fQ(str);
        if (fQ == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.CP().c(str, aVar);
            return aVar;
        }
        return fQ;
    }

    public int fm(String str) {
        return this.avo.fm(str);
    }

    public a.C0044a fM(String str) {
        com.baidu.adp.widget.a.a fL;
        a.C0044a y = this.avo.y(this.mContext, str);
        if (y == null && (fL = fL(str)) != null) {
            return new a.C0044a(fL.getWidth(), fL.getHeight());
        }
        return y;
    }

    public int fn(String str) {
        return this.avo.fn(str);
    }

    public int BD() {
        return this.avo.BD();
    }

    public String fo(String str) {
        return this.avo.fo(str);
    }

    public SpannableString z(Context context, String str) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(avp).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fn = this.avo.fn(group);
            if (fn > 0 && (m = m(fn, String.valueOf(fn))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable jc = m.jc();
                jc.setBounds(0, 0, m.getWidth(), m.getHeight());
                spannableString.setSpan(new ImageSpan(jc, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fN;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(avp).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fn = this.avo.fn(group);
            if (fn > 0) {
                com.baidu.adp.widget.a.a m = m(fn, String.valueOf(fn));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable jc = m.jc();
                    int width = (int) (0.5d * m.getWidth());
                    jc.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(jc, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fN = aVar.fN(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fN, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
