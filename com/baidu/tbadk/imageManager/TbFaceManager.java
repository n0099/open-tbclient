package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager cuD = null;
    public static String cuF = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a cuE = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan qn(String str);
    }

    public static TbFaceManager aso() {
        if (cuD == null) {
            cuD = new TbFaceManager();
        }
        return cuD;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.cuE = aVar;
    }

    public com.baidu.adp.widget.ImageView.a ql(String str) {
        return G(pP(str), str);
    }

    private com.baidu.adp.widget.ImageView.a G(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a qr = c.asp().qr(str);
        if (qr == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.asp().c(str, aVar);
            return aVar;
        }
        return qr;
    }

    public int pP(String str) {
        return this.cuE.pP(str);
    }

    public a.C0253a qm(String str) {
        com.baidu.adp.widget.ImageView.a ql;
        a.C0253a ak = this.cuE.ak(this.mContext, str);
        if (ak == null && (ql = ql(str)) != null) {
            return new a.C0253a(ql.getWidth(), ql.getHeight());
        }
        return ak;
    }

    public int pQ(String str) {
        return this.cuE.pQ(str);
    }

    public int arg() {
        return this.cuE.arg();
    }

    public String pR(String str) {
        return this.cuE.pR(str);
    }

    public SpannableString al(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a G;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cuF).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int pQ = this.cuE.pQ(group);
            if (pQ > 0 && (G = G(pQ, String.valueOf(pQ))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable nu = G.nu();
                nu.setBounds(0, 0, i > 0 ? i : G.getWidth(), i2 > 0 ? i2 : G.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(nu), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan qn;
        ImageSpan qn2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cuF).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int pQ = this.cuE.pQ(group);
            if (pQ > 0) {
                com.baidu.adp.widget.ImageView.a G = G(pQ, String.valueOf(pQ));
                if (G != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nu = G.nu();
                    int width = (int) (0.5d * G.getWidth());
                    nu.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nu, 0), start, length + start, 33);
                }
            } else if (aVar != null && (qn2 = aVar.qn(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(qn2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (qn = aVar.qn(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(qn, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
