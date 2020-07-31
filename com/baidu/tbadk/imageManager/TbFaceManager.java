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
    private static TbFaceManager eDT = null;
    public static String eDV = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a eDU = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan zT(String str);
    }

    public static TbFaceManager bkj() {
        if (eDT == null) {
            eDT = new TbFaceManager();
        }
        return eDT;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.eDU = aVar;
    }

    public com.baidu.adp.widget.ImageView.a zR(String str) {
        return at(zx(str), str);
    }

    private com.baidu.adp.widget.ImageView.a at(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a zV = c.bkk().zV(str);
        if (zV == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bkk().c(str, aVar);
            return aVar;
        }
        return zV;
    }

    public int zx(String str) {
        return this.eDU.zx(str);
    }

    public a.C0508a zS(String str) {
        com.baidu.adp.widget.ImageView.a zR;
        a.C0508a ak = this.eDU.ak(this.mContext, str);
        if (ak == null && (zR = zR(str)) != null) {
            return new a.C0508a(zR.getWidth(), zR.getHeight());
        }
        return ak;
    }

    public int zy(String str) {
        return this.eDU.zy(str);
    }

    public int biY() {
        return this.eDU.biY();
    }

    public String zz(String str) {
        return this.eDU.zz(str);
    }

    public SpannableString al(Context context, String str) {
        com.baidu.adp.widget.ImageView.a at;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eDV).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int zy = this.eDU.zy(group);
            if (zy > 0 && (at = at(zy, String.valueOf(zy))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = at.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a at;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eDV).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int zy = this.eDU.zy(group);
            if (zy > 0 && (at = at(zy, String.valueOf(zy))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = at.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : at.getWidth(), i2 > 0 ? i2 : at.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan zT;
        ImageSpan zT2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eDV).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int zy = this.eDU.zy(group);
            if (zy > 0) {
                com.baidu.adp.widget.ImageView.a at = at(zy, String.valueOf(zy));
                if (at != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = at.getAsBitmapDrawable();
                    int width = (int) (0.5d * at.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (zT2 = aVar.zT(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(zT2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (zT = aVar.zT(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(zT, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
