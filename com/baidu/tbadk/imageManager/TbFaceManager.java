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
    private static TbFaceManager fIq = null;
    public static String fIs = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a fIr = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan Ec(String str);
    }

    public static TbFaceManager bGp() {
        if (fIq == null) {
            fIq = new TbFaceManager();
        }
        return fIq;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.fIr = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Ea(String str) {
        return aJ(DG(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aJ(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Ee = c.bGq().Ee(str);
        if (Ee == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bGq().b(str, aVar);
            return aVar;
        }
        return Ee;
    }

    public int DG(String str) {
        return this.fIr.DG(str);
    }

    public a.C0596a Eb(String str) {
        com.baidu.adp.widget.ImageView.a Ea;
        a.C0596a aD = this.fIr.aD(this.mContext, str);
        if (aD == null && (Ea = Ea(str)) != null) {
            return new a.C0596a(Ea.getWidth(), Ea.getHeight());
        }
        return aD;
    }

    public int DH(String str) {
        return this.fIr.DH(str);
    }

    public int bFb() {
        return this.fIr.bFb();
    }

    public String DI(String str) {
        return this.fIr.DI(str);
    }

    public SpannableString aE(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aJ;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fIs).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DH = this.fIr.DH(group);
            if (DH > 0 && (aJ = aJ(DH, String.valueOf(DH))) != null) {
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
        Matcher matcher = Pattern.compile(fIs).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DH = this.fIr.DH(group);
            if (DH > 0 && (aJ = aJ(DH, String.valueOf(DH))) != null) {
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
        ImageSpan Ec;
        ImageSpan Ec2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fIs).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DH = this.fIr.DH(group);
            if (DH > 0) {
                com.baidu.adp.widget.ImageView.a aJ = aJ(DH, String.valueOf(DH));
                if (aJ != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aJ.getAsBitmapDrawable();
                    int width = (int) (0.5d * aJ.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Ec2 = aVar.Ec(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Ec2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (Ec = aVar.Ec(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Ec, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
