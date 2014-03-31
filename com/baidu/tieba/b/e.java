package com.baidu.tieba.b;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.recommend.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    private static final String d = String.valueOf(n.a) + "c/f/forum/threadrecommend";
    private int a = -1;
    private ak b = null;
    private boolean c;

    public e(boolean z) {
        this.c = z;
    }

    public final String a(String str, String str2) {
        this.b = new ak();
        this.b.a(d);
        this.b.a().a().b = false;
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        if (str2 != null) {
            this.b.a(y.a, str2);
        }
        String i = this.b.i();
        if (i != null) {
            try {
                this.a = new JSONObject(i).optInt("error_code");
            } catch (JSONException e) {
            }
        }
        return i;
    }

    public final void a() {
        if (this.b != null) {
            this.b.g();
        }
    }

    public final boolean b() {
        if (this.b != null) {
            return this.b.a().b().b();
        }
        return false;
    }

    public final int c() {
        return this.a;
    }
}
