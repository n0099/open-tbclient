package com.baidu.tieba.a;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.recommend.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private static final String d = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/threadrecommend";
    private int a = -1;
    private an b = null;
    private boolean c;

    public e(boolean z) {
        this.c = z;
    }

    public String a(String str, String str2) {
        this.b = new an();
        this.b.a(d);
        this.b.a().a().b = false;
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        if (str2 != null) {
            this.b.a(o.a, str2);
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

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.a().b().b();
        }
        return false;
    }

    public int c() {
        return this.a;
    }
}
