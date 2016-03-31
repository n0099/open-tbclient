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
    private static TbFaceManager axH = null;
    public static String axJ = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a axI = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends i implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan fM(String str);
    }

    public static TbFaceManager EN() {
        if (axH == null) {
            axH = new TbFaceManager();
        }
        return axH;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.axI = aVar;
    }

    public com.baidu.adp.widget.a.a fK(String str) {
        return m(fl(str), str);
    }

    private com.baidu.adp.widget.a.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a fP = c.EO().fP(str);
        if (fP == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.EO().c(str, aVar);
            return aVar;
        }
        return fP;
    }

    public int fl(String str) {
        return this.axI.fl(str);
    }

    public a.C0052a fL(String str) {
        com.baidu.adp.widget.a.a fK;
        a.C0052a w = this.axI.w(this.mContext, str);
        if (w == null && (fK = fK(str)) != null) {
            return new a.C0052a(fK.getWidth(), fK.getHeight());
        }
        return w;
    }

    public int fm(String str) {
        return this.axI.fm(str);
    }

    public int Dz() {
        return this.axI.Dz();
    }

    public String fn(String str) {
        return this.axI.fn(str);
    }

    public SpannableString x(Context context, String str) {
        com.baidu.adp.widget.a.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axJ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fm = this.axI.fm(group);
            if (fm > 0 && (m = m(fm, String.valueOf(fm))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable mM = m.mM();
                mM.setBounds(0, 0, m.getWidth(), m.getHeight());
                spannableString.setSpan(new ImageSpan(mM, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan fM;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(axJ).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fm = this.axI.fm(group);
            if (fm > 0) {
                com.baidu.adp.widget.a.a m = m(fm, String.valueOf(fm));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable mM = m.mM();
                    int width = (int) (0.5d * m.getWidth());
                    mM.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(mM, 0), start, length + start, 33);
                }
            } else if (aVar != null && (fM = aVar.fM(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(fM, start2, length2 + start2, 33);
            }
        }
        return spannableString;
    }
}
