package com.baidu.tieba.a;

import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.recommend.v;
import com.baidu.tieba.util.at;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private static final String d = com.baidu.tieba.data.h.a + "c/f/forum/threadrecommend";
    private int a = -1;
    private at b = null;
    private boolean c;

    public j(boolean z) {
        this.c = z;
    }

    public String a(String str, String str2) {
        this.b = new at();
        this.b.a(d);
        this.b.c(false);
        if (this.c) {
            this.b.a("type", "banner");
        }
        if (!TextUtils.isEmpty(str)) {
            this.b.a("date", str);
        }
        if (str2 != null) {
            this.b.a(v.a, str2);
        }
        String l = this.b.l();
        if (l != null) {
            try {
                this.a = new JSONObject(l).optInt(SocialConstants.PARAM_ERROR_CODE);
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
        return this.a;
    }
}
