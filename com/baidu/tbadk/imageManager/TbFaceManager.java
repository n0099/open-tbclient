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
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager frP = null;
    public static String frR = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a frQ = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan DZ(String str);
    }

    public static TbFaceManager bBc() {
        if (frP == null) {
            frP = new TbFaceManager();
        }
        return frP;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.frQ = aVar;
    }

    public com.baidu.adp.widget.ImageView.a DX(String str) {
        return aJ(DD(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aJ(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Eb = c.bBd().Eb(str);
        if (Eb == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bBd().c(str, aVar);
            return aVar;
        }
        return Eb;
    }

    public int DD(String str) {
        return this.frQ.DD(str);
    }

    public a.C0593a DY(String str) {
        com.baidu.adp.widget.ImageView.a DX;
        a.C0593a av = this.frQ.av(this.mContext, str);
        if (av == null && (DX = DX(str)) != null) {
            return new a.C0593a(DX.getWidth(), DX.getHeight());
        }
        return av;
    }

    public int DE(String str) {
        return this.frQ.DE(str);
    }

    public int bzP() {
        return this.frQ.bzP();
    }

    public String DF(String str) {
        return this.frQ.DF(str);
    }

    public SpannableString aw(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aJ;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(frR).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DE = this.frQ.DE(group);
            if (DE > 0 && (aJ = aJ(DE, String.valueOf(DE))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aJ.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aJ;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(frR).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DE = this.frQ.DE(group);
            if (DE > 0 && (aJ = aJ(DE, String.valueOf(DE))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aJ.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aJ.getWidth(), i2 > 0 ? i2 : aJ.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan DZ;
        ImageSpan DZ2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(frR).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DE = this.frQ.DE(group);
            if (DE > 0) {
                com.baidu.adp.widget.ImageView.a aJ = aJ(DE, String.valueOf(DE));
                if (aJ != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aJ.getAsBitmapDrawable();
                    int width = (int) (0.5d * aJ.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (DZ2 = aVar.DZ(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(DZ2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (DZ = aVar.DZ(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(DZ, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
