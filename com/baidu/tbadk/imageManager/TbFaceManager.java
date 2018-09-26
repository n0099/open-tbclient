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
    private static TbFaceManager aTu = null;
    public static String aTw = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aTv = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan hw(String str);
    }

    public static TbFaceManager Kf() {
        if (aTu == null) {
            aTu = new TbFaceManager();
        }
        return aTu;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aTv = aVar;
    }

    public com.baidu.adp.widget.ImageView.a hu(String str) {
        return m(gW(str), str);
    }

    private com.baidu.adp.widget.ImageView.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a hA = c.Kg().hA(str);
        if (hA == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.Kg().c(str, aVar);
            return aVar;
        }
        return hA;
    }

    public int gW(String str) {
        return this.aTv.gW(str);
    }

    public a.C0113a hv(String str) {
        com.baidu.adp.widget.ImageView.a hu;
        a.C0113a ak = this.aTv.ak(this.mContext, str);
        if (ak == null && (hu = hu(str)) != null) {
            return new a.C0113a(hu.getWidth(), hu.getHeight());
        }
        return ak;
    }

    public int gX(String str) {
        return this.aTv.gX(str);
    }

    public int IW() {
        return this.aTv.IW();
    }

    public String gY(String str) {
        return this.aTv.gY(str);
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
        Matcher matcher = Pattern.compile(aTw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gX = this.aTv.gX(group);
            if (gX > 0 && (m = m(gX, String.valueOf(gX))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable oj = m.oj();
                oj.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(oj), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan hw;
        ImageSpan hw2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aTw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gX = this.aTv.gX(group);
            if (gX > 0) {
                com.baidu.adp.widget.ImageView.a m = m(gX, String.valueOf(gX));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable oj = m.oj();
                    int width = (int) (0.5d * m.getWidth());
                    oj.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(oj, 0), start, length + start, 33);
                }
            } else if (aVar != null && (hw2 = aVar.hw(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(hw2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (hw = aVar.hw(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(hw, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
