package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.imageManager.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager eav = null;
    public static String eax = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a eaw = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan wK(String str);
    }

    public static TbFaceManager aYl() {
        if (eav == null) {
            eav = new TbFaceManager();
        }
        return eav;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.eaw = aVar;
    }

    public com.baidu.adp.widget.ImageView.a wI(String str) {
        return al(wp(str), str);
    }

    private com.baidu.adp.widget.ImageView.a al(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a wM = c.aYm().wM(str);
        if (wM == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.aYm().c(str, aVar);
            return aVar;
        }
        return wM;
    }

    public int wp(String str) {
        return this.eaw.wp(str);
    }

    public a.C0422a wJ(String str) {
        com.baidu.adp.widget.ImageView.a wI;
        a.C0422a au = this.eaw.au(this.mContext, str);
        if (au == null && (wI = wI(str)) != null) {
            return new a.C0422a(wI.getWidth(), wI.getHeight());
        }
        return au;
    }

    public int wq(String str) {
        return this.eaw.wq(str);
    }

    public int aXc() {
        return this.eaw.aXc();
    }

    public String wr(String str) {
        return this.eaw.wr(str);
    }

    public SpannableString av(Context context, String str) {
        com.baidu.adp.widget.ImageView.a al;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eax).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int wq = this.eaw.wq(group);
            if (wq > 0 && (al = al(wq, String.valueOf(wq))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = al.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, 55, 55);
                spannableString.setSpan(new f(asBitmapDrawable, 0), start, length + start, 33);
            }
        }
        return spannableString;
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a al;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eax).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int wq = this.eaw.wq(group);
            if (wq > 0 && (al = al(wq, String.valueOf(wq))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable asBitmapDrawable = al.getAsBitmapDrawable();
                asBitmapDrawable.setBounds(0, 0, i > 0 ? i : al.getWidth(), i2 > 0 ? i2 : al.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.d(asBitmapDrawable), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan wK;
        ImageSpan wK2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eax).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int wq = this.eaw.wq(group);
            if (wq > 0) {
                com.baidu.adp.widget.ImageView.a al = al(wq, String.valueOf(wq));
                if (al != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = al.getAsBitmapDrawable();
                    int width = (int) (0.5d * al.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (wK2 = aVar.wK(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(wK2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (wK = aVar.wK(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(wK, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
