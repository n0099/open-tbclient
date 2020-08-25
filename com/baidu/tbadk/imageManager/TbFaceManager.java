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
/* loaded from: classes2.dex */
public class TbFaceManager {
    private static TbFaceManager eOu = null;
    public static String eOw = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a eOv = null;

    /* loaded from: classes2.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes2.dex */
    public interface a {
        ImageSpan Cj(String str);
    }

    public static TbFaceManager bsV() {
        if (eOu == null) {
            eOu = new TbFaceManager();
        }
        return eOu;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.eOv = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Ch(String str) {
        return ar(BN(str), str);
    }

    private com.baidu.adp.widget.ImageView.a ar(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a Cl = c.bsW().Cl(str);
        if (Cl == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.bsW().c(str, aVar);
            return aVar;
        }
        return Cl;
    }

    public int BN(String str) {
        return this.eOv.BN(str);
    }

    public a.C0554a Ci(String str) {
        com.baidu.adp.widget.ImageView.a Ch;
        a.C0554a ao = this.eOv.ao(this.mContext, str);
        if (ao == null && (Ch = Ch(str)) != null) {
            return new a.C0554a(Ch.getWidth(), Ch.getHeight());
        }
        return ao;
    }

    public int BO(String str) {
        return this.eOv.BO(str);
    }

    public int brK() {
        return this.eOv.brK();
    }

    public String BP(String str) {
        return this.eOv.BP(str);
    }

    public SpannableString ap(Context context, String str) {
        com.baidu.adp.widget.ImageView.a ar;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eOw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int BO = this.eOv.BO(group);
            if (BO > 0 && (ar = ar(BO, String.valueOf(BO))) != null) {
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
        Matcher matcher = Pattern.compile(eOw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int BO = this.eOv.BO(group);
            if (BO > 0 && (ar = ar(BO, String.valueOf(BO))) != null) {
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
        ImageSpan Cj;
        ImageSpan Cj2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(eOw).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int BO = this.eOv.BO(group);
            if (BO > 0) {
                com.baidu.adp.widget.ImageView.a ar = ar(BO, String.valueOf(BO));
                if (ar != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable asBitmapDrawable = ar.getAsBitmapDrawable();
                    int width = (int) (0.5d * ar.getWidth());
                    asBitmapDrawable.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
                }
            } else if (aVar != null && (Cj2 = aVar.Cj(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(Cj2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (Cj = aVar.Cj(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(Cj, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
