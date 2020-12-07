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
    private static TbFaceManager fyL = null;
    public static String fyN = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a fyM = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan Eg(String str);
    }

    public static TbFaceManager bDU() {
        if (fyL == null) {
            fyL = new TbFaceManager();
        }
        return fyL;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.fyM = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Ee(String str) {
        return aH(DK(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aH(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Ei = c.bDV().Ei(str);
        if (Ei == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bDV().c(str, aVar);
            return aVar;
        }
        return Ei;
    }

    public int DK(String str) {
        return this.fyM.DK(str);
    }

    public a.C0605a Ef(String str) {
        com.baidu.adp.widget.ImageView.a Ee;
        a.C0605a av = this.fyM.av(this.mContext, str);
        if (av == null && (Ee = Ee(str)) != null) {
            return new a.C0605a(Ee.getWidth(), Ee.getHeight());
        }
        return av;
    }

    public int DL(String str) {
        return this.fyM.DL(str);
    }

    public int bCF() {
        return this.fyM.bCF();
    }

    public String DM(String str) {
        return this.fyM.DM(str);
    }

    public SpannableString aw(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aH;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fyN).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DL = this.fyM.DL(group);
            if (DL > 0 && (aH = aH(DL, String.valueOf(DL))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aH.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aH;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fyN).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DL = this.fyM.DL(group);
            if (DL > 0 && (aH = aH(DL, String.valueOf(DL))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aH.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aH.getWidth(), i2 > 0 ? i2 : aH.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan Eg;
        ImageSpan Eg2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fyN).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int DL = this.fyM.DL(group);
            if (DL > 0) {
                com.baidu.adp.widget.ImageView.a aH = aH(DL, String.valueOf(DL));
                if (aH != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aH.getAsBitmapDrawable();
                    int width = (int) (0.5d * aH.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Eg2 = aVar.Eg(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Eg2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (Eg = aVar.Eg(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Eg, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
