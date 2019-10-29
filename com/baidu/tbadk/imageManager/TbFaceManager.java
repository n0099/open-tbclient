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
    private static TbFaceManager cJf = null;
    public static String cJh = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a cJg = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan pW(String str);
    }

    public static TbFaceManager avt() {
        if (cJf == null) {
            cJf = new TbFaceManager();
        }
        return cJf;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.cJg = aVar;
    }

    public com.baidu.adp.widget.ImageView.a pU(String str) {
        return J(pz(str), str);
    }

    private com.baidu.adp.widget.ImageView.a J(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a pY = c.avu().pY(str);
        if (pY == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.avu().c(str, aVar);
            return aVar;
        }
        return pY;
    }

    public int pz(String str) {
        return this.cJg.pz(str);
    }

    public a.C0296a pV(String str) {
        com.baidu.adp.widget.ImageView.a pU;
        a.C0296a ag = this.cJg.ag(this.mContext, str);
        if (ag == null && (pU = pU(str)) != null) {
            return new a.C0296a(pU.getWidth(), pU.getHeight());
        }
        return ag;
    }

    public int pA(String str) {
        return this.cJg.pA(str);
    }

    public int aum() {
        return this.cJg.aum();
    }

    public String pB(String str) {
        return this.cJg.pB(str);
    }

    public SpannableString ah(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a J;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cJh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int pA = this.cJg.pA(group);
            if (pA > 0 && (J = J(pA, String.valueOf(pA))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = J.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : J.getWidth(), i2 > 0 ? i2 : J.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan pW;
        ImageSpan pW2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cJh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int pA = this.cJg.pA(group);
            if (pA > 0) {
                com.baidu.adp.widget.ImageView.a J = J(pA, String.valueOf(pA));
                if (J != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = J.getAsBitmapDrawable();
                    int width = (int) (0.5d * J.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (pW2 = aVar.pW(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(pW2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (pW = aVar.pW(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(pW, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
