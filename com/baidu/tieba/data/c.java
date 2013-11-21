package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f1192a = 0;
    private int b = 0;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1192a = jSONObject.optInt("group_count", 0);
                this.b = jSONObject.optInt("hide_recommend_group", 0);
            } catch (Exception e) {
                bg.b("FrsStarData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public int a() {
        return this.f1192a;
    }

    public int b() {
        return this.b;
    }
}
