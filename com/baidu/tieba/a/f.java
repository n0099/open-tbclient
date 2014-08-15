package com.baidu.tieba.a;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tieba.recommend.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private static final String d = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/threadrecommend";
    private int a = -1;
    private ae b = null;
    private boolean c;

    public f(boolean z) {
        this.c = z;
    }

    public String a(String str, String str2) {
        this.b = new ae();
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
        String h = this.b.h();
        if (h != null) {
            try {
                this.a = new JSONObject(h).optInt("error_code");
            } catch (JSONException e) {
            }
        }
        return h;
    }

    public void a() {
        if (this.b != null) {
            this.b.f();
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
