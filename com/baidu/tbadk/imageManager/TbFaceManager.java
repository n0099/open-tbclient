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
    private static TbFaceManager cwV = null;
    public static String cwX = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a cwW = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan qO(String str);
    }

    public static TbFaceManager atJ() {
        if (cwV == null) {
            cwV = new TbFaceManager();
        }
        return cwV;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.cwW = aVar;
    }

    public com.baidu.adp.widget.ImageView.a qM(String str) {
        return G(qq(str), str);
    }

    private com.baidu.adp.widget.ImageView.a G(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a qS = c.atK().qS(str);
        if (qS == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.atK().c(str, aVar);
            return aVar;
        }
        return qS;
    }

    public int qq(String str) {
        return this.cwW.qq(str);
    }

    public a.C0264a qN(String str) {
        com.baidu.adp.widget.ImageView.a qM;
        a.C0264a aj = this.cwW.aj(this.mContext, str);
        if (aj == null && (qM = qM(str)) != null) {
            return new a.C0264a(qM.getWidth(), qM.getHeight());
        }
        return aj;
    }

    public int qr(String str) {
        return this.cwW.qr(str);
    }

    public int asA() {
        return this.cwW.asA();
    }

    public String qs(String str) {
        return this.cwW.qs(str);
    }

    public SpannableString ak(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a G;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cwX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int qr = this.cwW.qr(group);
            if (qr > 0 && (G = G(qr, String.valueOf(qr))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable nM = G.nM();
                nM.setBounds(0, 0, i > 0 ? i : G.getWidth(), i2 > 0 ? i2 : G.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(nM), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan qO;
        ImageSpan qO2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cwX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int qr = this.cwW.qr(group);
            if (qr > 0) {
                com.baidu.adp.widget.ImageView.a G = G(qr, String.valueOf(qr));
                if (G != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nM = G.nM();
                    int width = (int) (0.5d * G.getWidth());
                    nM.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nM, 0), start, length + start, 33);
                }
            } else if (aVar != null && (qO2 = aVar.qO(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(qO2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (qO = aVar.qO(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(qO, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
