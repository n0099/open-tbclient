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
    private static TbFaceManager bwo = null;
    public static String bwq = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a bwp = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan gL(String str);
    }

    public static TbFaceManager Mw() {
        if (bwo == null) {
            bwo = new TbFaceManager();
        }
        return bwo;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.bwp = aVar;
    }

    public com.baidu.adp.widget.a.a gJ(String str) {
        return l(gk(str), str);
    }

    private com.baidu.adp.widget.a.a l(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.a.a gP = c.Mx().gP(str);
        if (gP == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(resBitmap, false, str);
            c.Mx().c(str, aVar);
            return aVar;
        }
        return gP;
    }

    public int gk(String str) {
        return this.bwp.gk(str);
    }

    public a.C0109a gK(String str) {
        com.baidu.adp.widget.a.a gJ;
        a.C0109a V = this.bwp.V(this.mContext, str);
        if (V == null && (gJ = gJ(str)) != null) {
            return new a.C0109a(gJ.getWidth(), gJ.getHeight());
        }
        return V;
    }

    public int gl(String str) {
        return this.bwp.gl(str);
    }

    public int Lp() {
        return this.bwp.Lp();
    }

    public String gm(String str) {
        return this.bwp.gm(str);
    }

    public SpannableString W(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.a.a l;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(bwq).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gl = this.bwp.gl(group);
            if (gl > 0 && (l = l(gl, String.valueOf(gl))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable sj = l.sj();
                sj.setBounds(0, 0, i > 0 ? i : l.getWidth(), i2 > 0 ? i2 : l.getHeight());
                spannableString.setSpan(new f(sj), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan gL;
        ImageSpan gL2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(bwq).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gl = this.bwp.gl(group);
            if (gl > 0) {
                com.baidu.adp.widget.a.a l = l(gl, String.valueOf(gl));
                if (l != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable sj = l.sj();
                    int width = (int) (0.5d * l.getWidth());
                    sj.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(sj, 0), start, length + start, 33);
                }
            } else if (aVar != null && (gL2 = aVar.gL(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(gL2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (gL = aVar.gL(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(gL, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
