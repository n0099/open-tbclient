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
    private static TbFaceManager aQc = null;
    public static String aQe = "#[\\(][\\w?~！]+[\\)]";
    private Context mContext = null;
    private com.baidu.tbadk.imageManager.a aQd = null;

    /* loaded from: classes.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        private static final long serialVersionUID = -3736301305777944719L;
        public String c;
        public String text;
        public Integer type;
    }

    /* loaded from: classes.dex */
    public interface a {
        ImageSpan ha(String str);
    }

    public static TbFaceManager IP() {
        if (aQc == null) {
            aQc = new TbFaceManager();
        }
        return aQc;
    }

    private TbFaceManager() {
    }

    public void a(Context context, com.baidu.tbadk.imageManager.a aVar) {
        if (context == null || aVar == null) {
            throw new InvalidParameterException("TbFaceManager initial error");
        }
        this.mContext = context;
        this.aQd = aVar;
    }

    public com.baidu.adp.widget.ImageView.a gY(String str) {
        return m(gA(str), str);
    }

    private com.baidu.adp.widget.ImageView.a m(int i, String str) {
        Bitmap resBitmap;
        com.baidu.adp.widget.ImageView.a he = c.IQ().he(str);
        if (he == null && (resBitmap = BitmapHelper.getResBitmap(this.mContext, i)) != null) {
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
            c.IQ().c(str, aVar);
            return aVar;
        }
        return he;
    }

    public int gA(String str) {
        return this.aQd.gA(str);
    }

    public a.C0113a gZ(String str) {
        com.baidu.adp.widget.ImageView.a gY;
        a.C0113a V = this.aQd.V(this.mContext, str);
        if (V == null && (gY = gY(str)) != null) {
            return new a.C0113a(gY.getWidth(), gY.getHeight());
        }
        return V;
    }

    public int gB(String str) {
        return this.aQd.gB(str);
    }

    public int HG() {
        return this.aQd.HG();
    }

    public String gC(String str) {
        return this.aQd.gC(str);
    }

    public SpannableString W(Context context, String str) {
        return a(context, str, 0, 0);
    }

    public SpannableString a(Context context, String str, int i, int i2) {
        com.baidu.adp.widget.ImageView.a m;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aQe).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gB = this.aQd.gB(group);
            if (gB > 0 && (m = m(gB, String.valueOf(gB))) != null) {
                int length = group.length();
                int start = matcher.start();
                BitmapDrawable nd = m.nd();
                nd.setBounds(0, 0, i > 0 ? i : m.getWidth(), i2 > 0 ? i2 : m.getHeight());
                spannableString.setSpan(new com.baidu.tbadk.widget.c(nd), start, start + length, 33);
            }
        }
        return spannableString;
    }

    public SpannableString a(Context context, String str, a aVar) {
        ImageSpan ha;
        ImageSpan ha2;
        if (str == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(aQe).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            int gB = this.aQd.gB(group);
            if (gB > 0) {
                com.baidu.adp.widget.ImageView.a m = m(gB, String.valueOf(gB));
                if (m != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable nd = m.nd();
                    int width = (int) (0.5d * m.getWidth());
                    nd.setBounds(0, 0, width, width);
                    spannableString.setSpan(new ImageSpan(nd, 0), start, length + start, 33);
                }
            } else if (aVar != null && (ha2 = aVar.ha(group)) != null) {
                int length2 = group.length();
                int start2 = matcher.start();
                spannableString.setSpan(ha2, start2, length2 + start2, 33);
            }
        }
        if (aVar != null) {
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (ha = aVar.ha(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(ha, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return spannableString;
    }
}
