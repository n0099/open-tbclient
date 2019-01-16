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
    private static TbFaceManager bcS = null;
    public static String bcU = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a bcT = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan is(String str);
    }

    public static TbFaceManager NL() {
        if (bcS == null) {
            bcS = new TbFaceManager();
        }
        return bcS;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.bcT = aVar;
    }

    public com.baidu.adp.widget.ImageView.a iq(String str) {
        return n(hS(str), str);
    }

    private com.baidu.adp.widget.ImageView.a n(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a iw = c.NM().iw(str);
        if (iw == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.NM().c(str, aVar);
            return aVar;
        }
        return iw;
    }

    public int hS(String str) {
        return this.bcT.hS(str);
    }

    public a.C0171a ir(String str) {
        com.baidu.adp.widget.ImageView.a iq;
        a.C0171a aj = this.bcT.aj(this.mContext, str);
        if (aj == null && (iq = iq(str)) != null) {
            return new a.C0171a(iq.getWidth(), iq.getHeight());
        }
        return aj;
    }

    public int hT(String str) {
        return this.bcT.hT(str);
    }

    public int MC() {
        return this.bcT.MC();
    }

    public String hU(String str) {
        return this.bcT.hU(str);
    }

    public SpannableString ak(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a n;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(bcU).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hT = this.bcT.hT(group);
            if (hT > 0 && (n = n(hT, String.valueOf(hT))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable ov = n.ov();
                ov.setBounds(0, 0, i > 0 ? i : n.getWidth(), i2 > 0 ? i2 : n.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(ov), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan is;
        ImageSpan is2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(bcU).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hT = this.bcT.hT(group);
            if (hT > 0) {
                com.baidu.adp.widget.ImageView.a n = n(hT, String.valueOf(hT));
                if (n != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable ov = n.ov();
                    int width = (int) (0.5d * n.getWidth());
                    ov.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(ov, 0), start, length + start, 33);
                }
            } else if (aVar != null && (is2 = aVar.is(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(is2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (is = aVar.is(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(is, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
