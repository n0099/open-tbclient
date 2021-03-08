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
    private static TbFaceManager fHu = null;
    public static String fHw = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a fHv = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan Dn(String str);
    }

    public static TbFaceManager bCR() {
        if (fHu == null) {
            fHu = new TbFaceManager();
        }
        return fHu;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.fHv = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Dl(String str) {
        return aO(CR(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aO(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Dp = c.bCS().Dp(str);
        if (Dp == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bCS().b(str, aVar);
            return aVar;
        }
        return Dp;
    }

    public int CR(String str) {
        return this.fHv.CR(str);
    }

    public a.C0582a Dm(String str) {
        com.baidu.adp.widget.ImageView.a Dl;
        a.C0582a aC = this.fHv.aC(this.mContext, str);
        if (aC == null && (Dl = Dl(str)) != null) {
            return new a.C0582a(Dl.getWidth(), Dl.getHeight());
        }
        return aC;
    }

    public int CS(String str) {
        return this.fHv.CS(str);
    }

    public int bBC() {
        return this.fHv.bBC();
    }

    public String CT(String str) {
        return this.fHv.CT(str);
    }

    public SpannableString aD(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aO;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fHw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CS = this.fHv.CS(group);
            if (CS > 0 && (aO = aO(CS, String.valueOf(CS))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aO.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aO;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fHw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CS = this.fHv.CS(group);
            if (CS > 0 && (aO = aO(CS, String.valueOf(CS))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aO.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aO.getWidth(), i2 > 0 ? i2 : aO.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan Dn;
        ImageSpan Dn2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fHw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CS = this.fHv.CS(group);
            if (CS > 0) {
                com.baidu.adp.widget.ImageView.a aO = aO(CS, String.valueOf(CS));
                if (aO != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aO.getAsBitmapDrawable();
                    int width = (int) (0.5d * aO.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Dn2 = aVar.Dn(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Dn2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (Dn = aVar.Dn(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Dn, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
