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
    private static TbFaceManager abr = null;
    private Context mContext = null;
    private b abt = null;

    /* loaded from: classes.dex */
    public class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    public static TbFaceManager vX() {
        if (abr == null) {
            abr = new TbFaceManager();
        }
        return abr;
    }

    private TbFaceManager() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.abt = bVar;
    }

    public com.baidu.adp.widget.a.a ef(String str) {
        return q(dW(str), str);
    }

    private com.baidu.adp.widget.a.a q(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a ek = e.vY().ek(str);
        if (ek == null && (b = com.baidu.adp.lib.util.c.eR().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            e.vY().c(str, aVar);
            return aVar;
        }
        return ek;
    }

    public int dW(String str) {
        return this.abt.dW(str);
    }

    public c eg(String str) {
        com.baidu.adp.widget.a.a ef;
        c D = this.abt.D(this.mContext, str);
        if (D == null && (ef = ef(str)) != null) {
            return new c(ef.getWidth(), ef.getHeight());
        }
        return D;
    }

    public int vl() {
        return this.abt.vl();
    }

    public String dY(String str) {
        return this.abt.dY(str);
    }

    public SpannableString E(Context context, String str) {
        com.baidu.adp.widget.a.a q;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int dX = this.abt.dX(group);
            if (dX > 0 && (q = q(dX, String.valueOf(dX))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable je = q.je();
                je.setBounds(0, 0, q.getWidth(), q.getHeight());
                spannableString.setSpan(new ImageSpan(je, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan eh;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?~]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int dX = this.abt.dX(group);
            if (dX > 0) {
                com.baidu.adp.widget.a.a q = q(dX, String.valueOf(dX));
                if (q != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable je = q.je();
                    int width = (int) (0.5d * q.getWidth());
                    je.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(je, 0), start, length + start, 33);
                }
            } else if (aVar != null && (eh = aVar.eh(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(eh, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
