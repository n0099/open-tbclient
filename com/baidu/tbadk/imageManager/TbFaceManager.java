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
    private static TbFaceManager amc = null;
    private Context mContext = null;
    private b amd = null;

    /* loaded from: classes.dex */
    public class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    public static TbFaceManager Al() {
        if (amc == null) {
            amc = new TbFaceManager();
        }
        return amc;
    }

    private TbFaceManager() {
    }

    public void a(Context context, b bVar) {
        if (context == null || bVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.amd = bVar;
    }

    public com.baidu.adp.widget.a.a eG(String str) {
        return p(eu(str), str);
    }

    private com.baidu.adp.widget.a.a p(int i, String str) {
        Bitmap b;
        com.baidu.adp.widget.a.a eL = e.Am().eL(str);
        if (eL == null && (b = com.baidu.adp.lib.util.e.iK().b(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str);
            e.Am().c(str, aVar);
            return aVar;
        }
        return eL;
    }

    public int eu(String str) {
        return this.amd.eu(str);
    }

    public c eH(String str) {
        com.baidu.adp.widget.a.a eG;
        c E = this.amd.E(this.mContext, str);
        if (E == null && (eG = eG(str)) != null) {
            return new c(eG.getWidth(), eG.getHeight());
        }
        return E;
    }

    public int zt() {
        return this.amd.zt();
    }

    public String ew(String str) {
        return this.amd.ew(str);
    }

    public SpannableString F(Context context, String str) {
        com.baidu.adp.widget.a.a p;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?~]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ev = this.amd.ev(group);
            if (ev > 0 && (p = p(ev, String.valueOf(ev))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable mU = p.mU();
                mU.setBounds(0, 0, p.getWidth(), p.getHeight());
                spannableString.setSpan(new ImageSpan(mU, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan eI;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile("#[\\(][\\w?~]+[\\)]").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ev = this.amd.ev(group);
            if (ev > 0) {
                com.baidu.adp.widget.a.a p = p(ev, String.valueOf(ev));
                if (p != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable mU = p.mU();
                    int width = (int) (0.5d * p.getWidth());
                    mU.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(mU, 0), start, length + start, 33);
                }
            } else if (aVar != null && (eI = aVar.eI(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(eI, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
