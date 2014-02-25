package com.baidu.tieba.b;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.recommend.w;
import com.baidu.tieba.util.ba;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private static final String d = String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/threadrecommend";
    private int a = -1;
    private ba b = null;
    private boolean c;

    public j(boolean z) {
        this.c = z;
    }

    public String a(String str, String str2) {
        this.b = new ba();
        this.b.a(d);
        this.b.c(false);
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        if (str2 != null) {
            this.b.a(w.a, str2);
        }
        String m = this.b.m();
        if (m != null) {
            try {
                this.a = new JSONObject(m).optInt(SocialConstants.PARAM_ERROR_CODE);
            } catch (JSONException e) {
            }
        }
        return m;
    }

    public void a() {
        if (this.b != null) {
            this.b.k();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.d();
        }
        return false;
    }

    public int c() {
        return this.a;
    }
}
