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
    private static TbFaceManager fdx = null;
    public static String fdz = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a fdy = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan Ds(String str);
    }

    public static TbFaceManager bwK() {
        if (fdx == null) {
            fdx = new TbFaceManager();
        }
        return fdx;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.fdy = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Dq(String str) {
        return aD(CW(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aD(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Du = c.bwL().Du(str);
        if (Du == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bwL().c(str, aVar);
            return aVar;
        }
        return Du;
    }

    public int CW(String str) {
        return this.fdy.CW(str);
    }

    public a.C0567a Dr(String str) {
        com.baidu.adp.widget.ImageView.a Dq;
        a.C0567a au = this.fdy.au(this.mContext, str);
        if (au == null && (Dq = Dq(str)) != null) {
            return new a.C0567a(Dq.getWidth(), Dq.getHeight());
        }
        return au;
    }

    public int CX(String str) {
        return this.fdy.CX(str);
    }

    public int bvx() {
        return this.fdy.bvx();
    }

    public String CY(String str) {
        return this.fdy.CY(str);
    }

    public SpannableString av(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aD;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fdz).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CX = this.fdy.CX(group);
            if (CX > 0 && (aD = aD(CX, String.valueOf(CX))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aD.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aD;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fdz).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CX = this.fdy.CX(group);
            if (CX > 0 && (aD = aD(CX, String.valueOf(CX))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aD.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aD.getWidth(), i2 > 0 ? i2 : aD.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan Ds;
        ImageSpan Ds2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(fdz).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int CX = this.fdy.CX(group);
            if (CX > 0) {
                com.baidu.adp.widget.ImageView.a aD = aD(CX, String.valueOf(CX));
                if (aD != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aD.getAsBitmapDrawable();
                    int width = (int) (0.5d * aD.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Ds2 = aVar.Ds(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Ds2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (Ds = aVar.Ds(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Ds, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
