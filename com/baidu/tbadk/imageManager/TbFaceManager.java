package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TbFaceManager {
    private static TbFaceManager cms = null;
    public static String cmu = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a cmt = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan pe(String str);
    }

    public static TbFaceManager anp() {
        if (cms == null) {
            cms = new TbFaceManager();
        }
        return cms;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.cmt = aVar;
    }

    public com.baidu.adp.widget.ImageView.a pc(String str) {
        return D(oG(str), str);
    }

    private com.baidu.adp.widget.ImageView.a D(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a pi = c.anq().pi(str);
        if (pi == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.anq().c(str, aVar);
            return aVar;
        }
        return pi;
    }

    public int oG(String str) {
        return this.cmt.oG(str);
    }

    public a.C0204a pd(String str) {
        com.baidu.adp.widget.ImageView.a pc;
        a.C0204a aw = this.cmt.aw(this.mContext, str);
        if (aw == null && (pc = pc(str)) != null) {
            return new a.C0204a(pc.getWidth(), pc.getHeight());
        }
        return aw;
    }

    public int oH(String str) {
        return this.cmt.oH(str);
    }

    public int amh() {
        return this.cmt.amh();
    }

    public String oI(String str) {
        return this.cmt.oI(str);
    }

    public SpannableString ax(Context context, String str) {
        return b(context, str, 0, 0);
    }

    public SpannableString b(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a D;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cmu).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int oH = this.cmt.oH(group);
            if (oH > 0 && (D = D(oH, String.valueOf(oH))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable oA = D.oA();
                oA.setBounds(0, 0, i > 0 ? i : D.getWidth(), i2 > 0 ? i2 : D.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(oA), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan pe;
        ImageSpan pe2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(cmu).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int oH = this.cmt.oH(group);
            if (oH > 0) {
                com.baidu.adp.widget.ImageView.a D = D(oH, String.valueOf(oH));
                if (D != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable oA = D.oA();
                    int width = (int) (0.5d * D.getWidth());
                    oA.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(oA, 0), start, length + start, 33);
                }
            } else if (aVar != null && (pe2 = aVar.pe(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(pe2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split != null && split.length == 5 && (pe = aVar.pe(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(pe, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
