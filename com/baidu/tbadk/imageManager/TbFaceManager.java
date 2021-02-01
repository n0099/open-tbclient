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
    private static TbFaceManager fFV = null;
    public static String fFX = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a fFW = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan Di(String str);
    }

    public static TbFaceManager bCO() {
        if (fFV == null) {
            fFV = new TbFaceManager();
        }
        return fFV;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.fFW = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Dg(String str) {
        return aO(CM(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aO(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Dk = c.bCP().Dk(str);
        if (Dk == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bCP().b(str, aVar);
            return aVar;
        }
        return Dk;
    }

    public int CM(String str) {
        return this.fFW.CM(str);
    }

    public a.C0576a Dh(String str) {
        com.baidu.adp.widget.ImageView.a Dg;
        a.C0576a aC = this.fFW.aC(this.mContext, str);
        if (aC == null && (Dg = Dg(str)) != null) {
            return new a.C0576a(Dg.getWidth(), Dg.getHeight());
        }
        return aC;
    }

    public int CN(String str) {
        return this.fFW.CN(str);
    }

    public int bBz() {
        return this.fFW.bBz();
    }

    public String CO(String str) {
        return this.fFW.CO(str);
    }

    public SpannableString aD(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aO;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fFX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CN = this.fFW.CN(group);
            if (CN > 0 && (aO = aO(CN, String.valueOf(CN))) != null) {
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
        Matcher matcher = Pattern.compile(fFX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CN = this.fFW.CN(group);
            if (CN > 0 && (aO = aO(CN, String.valueOf(CN))) != null) {
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
        ImageSpan Di;
        ImageSpan Di2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fFX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CN = this.fFW.CN(group);
            if (CN > 0) {
                com.baidu.adp.widget.ImageView.a aO = aO(CN, String.valueOf(CN));
                if (aO != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aO.getAsBitmapDrawable();
                    int width = (int) (0.5d * aO.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Di2 = aVar.Di(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Di2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (Di = aVar.Di(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Di, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
