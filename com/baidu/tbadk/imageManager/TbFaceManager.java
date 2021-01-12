package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.imageManager.a;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager fDJ = null;
    public static String fDL = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a fDK = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan CR(String str);
    }

    public static TbFaceManager bCw() {
        if (fDJ == null) {
            fDJ = new TbFaceManager();
        }
        return fDJ;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.fDK = aVar;
    }

    public com.baidu.adp.widget.ImageView.a CP(String str) {
        return aK(Cv(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aK(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a CT = c.bCx().CT(str);
        if (CT == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bCx().b(str, aVar);
            return aVar;
        }
        return CT;
    }

    public int Cv(String str) {
        return this.fDK.Cv(str);
    }

    public a.C0579a CQ(String str) {
        com.baidu.adp.widget.ImageView.a CP;
        a.C0579a aD = this.fDK.aD(this.mContext, str);
        if (aD == null && (CP = CP(str)) != null) {
            return new a.C0579a(CP.getWidth(), CP.getHeight());
        }
        return aD;
    }

    public int Cw(String str) {
        return this.fDK.Cw(str);
    }

    public int bBh() {
        return this.fDK.bBh();
    }

    public String Cx(String str) {
        return this.fDK.Cx(str);
    }

    public SpannableString aE(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aK;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fDL).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Cw = this.fDK.Cw(group);
            if (Cw > 0 && (aK = aK(Cw, String.valueOf(Cw))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aK.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aK;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fDL).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Cw = this.fDK.Cw(group);
            if (Cw > 0 && (aK = aK(Cw, String.valueOf(Cw))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aK.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aK.getWidth(), i2 > 0 ? i2 : aK.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan CR;
        ImageSpan CR2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fDL).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Cw = this.fDK.Cw(group);
            if (Cw > 0) {
                com.baidu.adp.widget.ImageView.a aK = aK(Cw, String.valueOf(Cw));
                if (aK != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aK.getAsBitmapDrawable();
                    int width = (int) (0.5d * aK.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (CR2 = aVar.CR(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(CR2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (CR = aVar.CR(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(CR, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
