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
    private static TbFaceManager buo = null;
    public static String buq = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a bup = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan gC(String str);
    }

    public static TbFaceManager LQ() {
        if (buo == null) {
            buo = new TbFaceManager();
        }
        return buo;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.bup = aVar;
    }

    public com.baidu.adp.widget.a.a gA(String str) {
        return l(gb(str), str);
    }

    private com.baidu.adp.widget.a.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a gG = c.LR().gG(str);
        if (gG == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.LR().c(str, aVar);
            return aVar;
        }
        return gG;
    }

    public int gb(String str) {
        return this.bup.gb(str);
    }

    public a.C0085a gB(String str) {
        com.baidu.adp.widget.a.a gA;
        a.C0085a T = this.bup.T(this.mContext, str);
        if (T == null && (gA = gA(str)) != null) {
            return new a.C0085a(gA.getWidth(), gA.getHeight());
        }
        return T;
    }

    public int gc(String str) {
        return this.bup.gc(str);
    }

    public int KJ() {
        return this.bup.KJ();
    }

    public String gd(String str) {
        return this.bup.gd(str);
    }

    public SpannableString U(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a l;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(buq).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gc = this.bup.gc(group);
            if (gc > 0 && (l = l(gc, String.valueOf(gc))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable sl = l.sl();
                sl.setBounds(0, 0, i > 0 ? i : l.getWidth(), i2 > 0 ? i2 : l.getHeight());
                spannableString.setSpan(new f(sl), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan gC;
        ImageSpan gC2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(buq).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gc = this.bup.gc(group);
            if (gc > 0) {
                com.baidu.adp.widget.a.a l = l(gc, String.valueOf(gc));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable sl = l.sl();
                    int width = (int) (0.5d * l.getWidth());
                    sl.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(sl, 0), start, length + start, 33);
                }
            } else if (aVar != null && (gC2 = aVar.gC(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(gC2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (gC = aVar.gC(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(gC, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
