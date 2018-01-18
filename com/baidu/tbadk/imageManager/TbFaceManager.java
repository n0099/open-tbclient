package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.baidu.tbadk.widget.f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager bue = null;
    public static String buh = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a bug = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan gu(String str);
    }

    public static TbFaceManager LO() {
        if (bue == null) {
            bue = new TbFaceManager();
        }
        return bue;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.bug = aVar;
    }

    public com.baidu.adp.widget.a.a gr(String str) {
        return l(fT(str), str);
    }

    private com.baidu.adp.widget.a.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a gy = c.LP().gy(str);
        if (gy == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.LP().c(str, aVar);
            return aVar;
        }
        return gy;
    }

    public int fT(String str) {
        return this.bug.fT(str);
    }

    public a.C0084a gt(String str) {
        com.baidu.adp.widget.a.a gr;
        a.C0084a U = this.bug.U(this.mContext, str);
        if (U == null && (gr = gr(str)) != null) {
            return new a.C0084a(gr.getWidth(), gr.getHeight());
        }
        return U;
    }

    public int fU(String str) {
        return this.bug.fU(str);
    }

    public int KH() {
        return this.bug.KH();
    }

    public String fV(String str) {
        return this.bug.fV(str);
    }

    public SpannableString V(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a l;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(buh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fU = this.bug.fU(group);
            if (fU > 0 && (l = l(fU, String.valueOf(fU))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable sk = l.sk();
                sk.setBounds(0, 0, i > 0 ? i : l.getWidth(), i2 > 0 ? i2 : l.getHeight());
                spannableString.setSpan(new f(sk), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan gu;
        ImageSpan gu2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(buh).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int fU = this.bug.fU(group);
            if (fU > 0) {
                com.baidu.adp.widget.a.a l = l(fU, String.valueOf(fU));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable sk = l.sk();
                    int width = (int) (0.5d * l.getWidth());
                    sk.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(sk, 0), start, length + start, 33);
                }
            } else if (aVar != null && (gu2 = aVar.gu(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(gu2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (gu = aVar.gu(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(gu, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
