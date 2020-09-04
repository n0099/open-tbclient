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
    private static TbFaceManager eOy = null;
    public static String eOA = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a eOz = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan Ck(String str);
    }

    public static TbFaceManager bsW() {
        if (eOy == null) {
            eOy = new TbFaceManager();
        }
        return eOy;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.eOz = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Ci(String str) {
        return ar(BO(str), str);
    }

    private com.baidu.adp.widget.ImageView.a ar(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Cm = c.bsX().Cm(str);
        if (Cm == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bsX().c(str, aVar);
            return aVar;
        }
        return Cm;
    }

    public int BO(String str) {
        return this.eOz.BO(str);
    }

    public a.C0554a Cj(String str) {
        com.baidu.adp.widget.ImageView.a Ci;
        a.C0554a ao = this.eOz.ao(this.mContext, str);
        if (ao == null && (Ci = Ci(str)) != null) {
            return new a.C0554a(Ci.getWidth(), Ci.getHeight());
        }
        return ao;
    }

    public int BP(String str) {
        return this.eOz.BP(str);
    }

    public int brL() {
        return this.eOz.brL();
    }

    public String BQ(String str) {
        return this.eOz.BQ(str);
    }

    public SpannableString ap(Context context, String str) {
        com.baidu.adp.widget.ImageView.a ar;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eOA).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int BP = this.eOz.BP(group);
            if (BP > 0 && (ar = ar(BP, String.valueOf(BP))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = ar.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a ar;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eOA).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int BP = this.eOz.BP(group);
            if (BP > 0 && (ar = ar(BP, String.valueOf(BP))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = ar.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : ar.getWidth(), i2 > 0 ? i2 : ar.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan Ck;
        ImageSpan Ck2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eOA).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int BP = this.eOz.BP(group);
            if (BP > 0) {
                com.baidu.adp.widget.ImageView.a ar = ar(BP, String.valueOf(BP));
                if (ar != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = ar.getAsBitmapDrawable();
                    int width = (int) (0.5d * ar.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Ck2 = aVar.Ck(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Ck2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (Ck = aVar.Ck(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Ck, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
