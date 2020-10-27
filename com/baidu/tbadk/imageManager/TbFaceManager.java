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
    private static TbFaceManager flV = null;
    public static String flX = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a flW = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan DL(String str);
    }

    public static TbFaceManager byD() {
        if (flV == null) {
            flV = new TbFaceManager();
        }
        return flV;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.flW = aVar;
    }

    public com.baidu.adp.widget.ImageView.a DJ(String str) {
        return aF(Dp(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aF(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a DN = c.byE().DN(str);
        if (DN == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.byE().c(str, aVar);
            return aVar;
        }
        return DN;
    }

    public int Dp(String str) {
        return this.flW.Dp(str);
    }

    public a.C0581a DK(String str) {
        com.baidu.adp.widget.ImageView.a DJ;
        a.C0581a av = this.flW.av(this.mContext, str);
        if (av == null && (DJ = DJ(str)) != null) {
            return new a.C0581a(DJ.getWidth(), DJ.getHeight());
        }
        return av;
    }

    public int Dq(String str) {
        return this.flW.Dq(str);
    }

    public int bxq() {
        return this.flW.bxq();
    }

    public String Dr(String str) {
        return this.flW.Dr(str);
    }

    public SpannableString aw(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aF;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(flX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Dq = this.flW.Dq(group);
            if (Dq > 0 && (aF = aF(Dq, String.valueOf(Dq))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aF.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aF;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(flX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Dq = this.flW.Dq(group);
            if (Dq > 0 && (aF = aF(Dq, String.valueOf(Dq))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aF.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aF.getWidth(), i2 > 0 ? i2 : aF.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan DL;
        ImageSpan DL2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(flX).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int Dq = this.flW.Dq(group);
            if (Dq > 0) {
                com.baidu.adp.widget.ImageView.a aF = aF(Dq, String.valueOf(Dq));
                if (aF != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aF.getAsBitmapDrawable();
                    int width = (int) (0.5d * aF.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (DL2 = aVar.DL(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(DL2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (DL = aVar.DL(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(DL, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
