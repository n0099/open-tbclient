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
    private static TbFaceManager eaA = null;
    public static String eaC = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a eaB = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan wN(String str);
    }

    public static TbFaceManager aYj() {
        if (eaA == null) {
            eaA = new TbFaceManager();
        }
        return eaA;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.eaB = aVar;
    }

    public com.baidu.adp.widget.ImageView.a wL(String str) {
        return al(ws(str), str);
    }

    private com.baidu.adp.widget.ImageView.a al(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a wP = c.aYk().wP(str);
        if (wP == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.aYk().c(str, aVar);
            return aVar;
        }
        return wP;
    }

    public int ws(String str) {
        return this.eaB.ws(str);
    }

    public a.C0443a wM(String str) {
        com.baidu.adp.widget.ImageView.a wL;
        a.C0443a ai = this.eaB.ai(this.mContext, str);
        if (ai == null && (wL = wL(str)) != null) {
            return new a.C0443a(wL.getWidth(), wL.getHeight());
        }
        return ai;
    }

    public int wt(String str) {
        return this.eaB.wt(str);
    }

    public int aXa() {
        return this.eaB.aXa();
    }

    public String wu(String str) {
        return this.eaB.wu(str);
    }

    public SpannableString aj(Context context, String str) {
        com.baidu.adp.widget.ImageView.a al;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eaC).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int wt = this.eaB.wt(group);
            if (wt > 0 && (al = al(wt, String.valueOf(wt))) != null) {
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
        Matcher matcher = Pattern.compile(eaC).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int wt = this.eaB.wt(group);
            if (wt > 0 && (al = al(wt, String.valueOf(wt))) != null) {
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
        ImageSpan wN;
        ImageSpan wN2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eaC).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int wt = this.eaB.wt(group);
            if (wt > 0) {
                com.baidu.adp.widget.ImageView.a al = al(wt, String.valueOf(wt));
                if (al != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = al.getAsBitmapDrawable();
                    int width = (int) (0.5d * al.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (wN2 = aVar.wN(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(wN2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (wN = aVar.wN(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(wN, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
