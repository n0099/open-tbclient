package com.baidu.tieba.a;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.recommend.w;
import com.baidu.tieba.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private static final String d = com.baidu.tieba.data.h.f1201a + "c/f/forum/threadrecommend";

    /* renamed from: a  reason: collision with root package name */
    private int f1016a = -1;
    private ap b = null;
    private boolean c;

    public l(boolean z) {
        this.c = z;
    }

    public String a(String str, String str2) {
        this.b = new ap();
        this.b.a(d);
        this.b.c(false);
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        if (str2 != null) {
            this.b.a(w.f2310a, str2);
        }
        String j = this.b.j();
        if (j != null) {
            try {
                this.f1016a = new JSONObject(j).optInt(SocialConstants.PARAM_ERROR_CODE);
            } catch (JSONException e) {
            }
        }
        return j;
    }

    public void a() {
        if (this.b != null) {
            this.b.h();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.c();
        }
        return false;
    }

    public int c() {
        return this.f1016a;
    }
}
