package com.baidu.tieba.a;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.recommend.v;
import com.baidu.tieba.util.am;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    private static final String d = com.baidu.tieba.data.h.f1248a + "c/f/forum/threadrecommend";

    /* renamed from: a  reason: collision with root package name */
    private int f1026a = -1;
    private am b = null;
    private boolean c;

    public l(boolean z) {
        this.c = z;
    }

    public String a(String str, String str2) {
        this.b = new am();
        this.b.a(d);
        this.b.c(false);
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        if (str2 != null) {
            this.b.a(v.f2426a, str2);
        }
        String l = this.b.l();
        if (l != null) {
            try {
                this.f1026a = new JSONObject(l).optInt(SocialConstants.PARAM_ERROR_CODE);
            } catch (JSONException e) {
            }
        }
        return l;
    }

    public void a() {
        if (this.b != null) {
            this.b.j();
        }
    }

    public boolean b() {
        if (this.b != null) {
            return this.b.c();
        }
        return false;
    }

    public int c() {
        return this.f1026a;
    }
}
