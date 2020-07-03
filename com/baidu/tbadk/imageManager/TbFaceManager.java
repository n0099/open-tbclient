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
    private static TbFaceManager exB = null;
    public static String exD = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a exC = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan yM(String str);
    }

    public static TbFaceManager bgy() {
        if (exB == null) {
            exB = new TbFaceManager();
        }
        return exB;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.exC = aVar;
    }

    public com.baidu.adp.widget.ImageView.a yK(String str) {
        return as(yr(str), str);
    }

    private com.baidu.adp.widget.ImageView.a as(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a yO = c.bgz().yO(str);
        if (yO == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bgz().c(str, aVar);
            return aVar;
        }
        return yO;
    }

    public int yr(String str) {
        return this.exC.yr(str);
    }

    public a.C0496a yL(String str) {
        com.baidu.adp.widget.ImageView.a yK;
        a.C0496a aj = this.exC.aj(this.mContext, str);
        if (aj == null && (yK = yK(str)) != null) {
            return new a.C0496a(yK.getWidth(), yK.getHeight());
        }
        return aj;
    }

    public int ys(String str) {
        return this.exC.ys(str);
    }

    public int bfo() {
        return this.exC.bfo();
    }

    public String yt(String str) {
        return this.exC.yt(str);
    }

    public SpannableString ak(Context context, String str) {
        com.baidu.adp.widget.ImageView.a as;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(exD).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ys = this.exC.ys(group);
            if (ys > 0 && (as = as(ys, String.valueOf(ys))) != null) {
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
        Matcher matcher = Pattern.compile(exD).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ys = this.exC.ys(group);
            if (ys > 0 && (as = as(ys, String.valueOf(ys))) != null) {
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
        ImageSpan yM;
        ImageSpan yM2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(exD).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int ys = this.exC.ys(group);
            if (ys > 0) {
                com.baidu.adp.widget.ImageView.a as = as(ys, String.valueOf(ys));
                if (as != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = as.getAsBitmapDrawable();
                    int width = (int) (0.5d * as.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (yM2 = aVar.yM(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(yM2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (yM = aVar.yM(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(yM, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
