package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager aXT = null;
    public static String aXV = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aXU = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan hK(String str);
    }

    public static TbFaceManager Md() {
        if (aXT == null) {
            aXT = new TbFaceManager();
        }
        return aXT;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aXU = aVar;
    }

    public com.baidu.adp.widget.ImageView.a hI(String str) {
        return m(hk(str), str);
    }

    private com.baidu.adp.widget.ImageView.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a hO = c.Me().hO(str);
        if (hO == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.Me().c(str, aVar);
            return aVar;
        }
        return hO;
    }

    public int hk(String str) {
        return this.aXU.hk(str);
    }

    public a.C0137a hJ(String str) {
        com.baidu.adp.widget.ImageView.a hI;
        a.C0137a ak = this.aXU.ak(this.mContext, str);
        if (ak == null && (hI = hI(str)) != null) {
            return new a.C0137a(hI.getWidth(), hI.getHeight());
        }
        return ak;
    }

    public int hl(String str) {
        return this.aXU.hl(str);
    }

    public int KU() {
        return this.aXU.KU();
    }

    public String hm(String str) {
        return this.aXU.hm(str);
    }

    public SpannableString al(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aXV).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hl = this.aXU.hl(group);
            if (hl > 0 && (m = m(hl, String.valueOf(hl))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable ou = m.ou();
                ou.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(ou), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan hK;
        ImageSpan hK2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aXV).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int hl = this.aXU.hl(group);
            if (hl > 0) {
                com.baidu.adp.widget.ImageView.a m = m(hl, String.valueOf(hl));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable ou = m.ou();
                    int width = (int) (0.5d * m.getWidth());
                    ou.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(ou, 0), start, length + start, 33);
                }
            } else if (aVar != null && (hK2 = aVar.hK(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(hK2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (hK = aVar.hK(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(hK, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
