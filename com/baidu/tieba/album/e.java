package com.baidu.tieba.album;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.tbadk.TbConfig;
import java.util.Locale;
/* loaded from: classes.dex */
public class e {
    private final String a = TbConfig.getTempDirName();
    private f b;
    private g c;
    private final Context d;

    public e(Context context) {
        this.d = context;
    }

    public boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        a();
        this.b = new f(this, oVar);
        this.b.setPriority(3);
        this.b.execute(new Object[0]);
        return true;
    }

    public boolean a(String str, al alVar) {
        if (alVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        b();
        this.c = new g(this, str, alVar);
        this.c.setPriority(3);
        this.c.execute(new Object[0]);
        return true;
    }

    public void a() {
        if (this.b != null) {
            this.b.cancel();
            this.b = null;
        }
    }

    public void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }

    public String a(String str) {
        String b = b(str);
        if (b == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(b.toLowerCase(Locale.getDefault()));
    }

    private String b(String str) {
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
