package com.baidu.tieba.album;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.tbadk.TbConfig;
import java.util.Locale;
/* loaded from: classes.dex */
public class e {
    private final String ahF = TbConfig.getTempDirName();
    private f ahG;
    private g ahH;
    private final Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        xS();
        this.ahG = new f(this, oVar);
        this.ahG.setPriority(3);
        this.ahG.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, al alVar) {
        if (alVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        xT();
        this.ahH = new g(this, str, alVar);
        this.ahH.setPriority(3);
        this.ahH.execute(new Object[0]);
        return true;
    }

    public void xS() {
        if (this.ahG != null) {
            this.ahG.cancel();
            this.ahG = null;
        }
    }

    public void xT() {
        if (this.ahH != null) {
            this.ahH.cancel();
            this.ahH = null;
        }
    }

    public String en(String str) {
        String fileExtensionFromUrl = getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase(Locale.getDefault()));
    }

    private String getFileExtensionFromUrl(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf2 = str.lastIndexOf(35);
            if (lastIndexOf2 > 0) {
                str = str.substring(0, lastIndexOf2);
            }
            int lastIndexOf3 = str.lastIndexOf(63);
            if (lastIndexOf3 > 0) {
                str = str.substring(0, lastIndexOf3);
            }
            int lastIndexOf4 = str.lastIndexOf(47);
            if (lastIndexOf4 >= 0) {
                str = str.substring(lastIndexOf4 + 1);
            }
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return "";
    }
}
