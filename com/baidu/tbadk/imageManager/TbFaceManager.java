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
    private static TbFaceManager eRp = null;
    public static String eRr = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a eRq = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan CG(String str);
    }

    public static TbFaceManager bua() {
        if (eRp == null) {
            eRp = new TbFaceManager();
        }
        return eRp;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.eRq = aVar;
    }

    public com.baidu.adp.widget.ImageView.a CE(String str) {
        return as(Ck(str), str);
    }

    private com.baidu.adp.widget.ImageView.a as(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a CI = c.bub().CI(str);
        if (CI == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bub().c(str, aVar);
            return aVar;
        }
        return CI;
    }

    public int Ck(String str) {
        return this.eRq.Ck(str);
    }

    public a.C0550a CF(String str) {
        com.baidu.adp.widget.ImageView.a CE;
        a.C0550a ar = this.eRq.ar(this.mContext, str);
        if (ar == null && (CE = CE(str)) != null) {
            return new a.C0550a(CE.getWidth(), CE.getHeight());
        }
        return ar;
    }

    public int Cl(String str) {
        return this.eRq.Cl(str);
    }

    public int bsN() {
        return this.eRq.bsN();
    }

    public String Cm(String str) {
        return this.eRq.Cm(str);
    }

    public SpannableString as(Context context, String str) {
        com.baidu.adp.widget.ImageView.a as;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eRr).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Cl = this.eRq.Cl(group);
            if (Cl > 0 && (as = as(Cl, String.valueOf(Cl))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = as.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a as;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eRr).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Cl = this.eRq.Cl(group);
            if (Cl > 0 && (as = as(Cl, String.valueOf(Cl))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = as.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : as.getWidth(), i2 > 0 ? i2 : as.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan CG;
        ImageSpan CG2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eRr).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Cl = this.eRq.Cl(group);
            if (Cl > 0) {
                com.baidu.adp.widget.ImageView.a as = as(Cl, String.valueOf(Cl));
                if (as != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = as.getAsBitmapDrawable();
                    int width = (int) (0.5d * as.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (CG2 = aVar.CG(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(CG2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (CG = aVar.CG(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(CG, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
