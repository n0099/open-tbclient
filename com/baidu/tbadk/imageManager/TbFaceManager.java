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
    private static TbFaceManager eoM = null;
    public static String eoO = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a eoN = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan yt(String str);
    }

    public static TbFaceManager bes() {
        if (eoM == null) {
            eoM = new TbFaceManager();
        }
        return eoM;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.eoN = aVar;
    }

    public com.baidu.adp.widget.ImageView.a yr(String str) {
        return aq(xY(str), str);
    }

    private com.baidu.adp.widget.ImageView.a aq(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a yv = c.bet().yv(str);
        if (yv == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bet().c(str, aVar);
            return aVar;
        }
        return yv;
    }

    public int xY(String str) {
        return this.eoN.xY(str);
    }

    public a.C0490a ys(String str) {
        com.baidu.adp.widget.ImageView.a yr;
        a.C0490a aj = this.eoN.aj(this.mContext, str);
        if (aj == null && (yr = yr(str)) != null) {
            return new a.C0490a(yr.getWidth(), yr.getHeight());
        }
        return aj;
    }

    public int xZ(String str) {
        return this.eoN.xZ(str);
    }

    public int bdj() {
        return this.eoN.bdj();
    }

    public String ya(String str) {
        return this.eoN.ya(str);
    }

    public SpannableString ak(Context context, String str) {
        com.baidu.adp.widget.ImageView.a aq;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eoO).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int xZ = this.eoN.xZ(group);
            if (xZ > 0 && (aq = aq(xZ, String.valueOf(xZ))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aq.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new e(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a aq;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eoO).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int xZ = this.eoN.xZ(group);
            if (xZ > 0 && (aq = aq(xZ, String.valueOf(xZ))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = aq.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : aq.getWidth(), i2 > 0 ? i2 : aq.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan yt;
        ImageSpan yt2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eoO).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int xZ = this.eoN.xZ(group);
            if (xZ > 0) {
                com.baidu.adp.widget.ImageView.a aq = aq(xZ, String.valueOf(xZ));
                if (aq != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = aq.getAsBitmapDrawable();
                    int width = (int) (0.5d * aq.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (yt2 = aVar.yt(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(yt2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (yt = aVar.yt(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(yt, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
