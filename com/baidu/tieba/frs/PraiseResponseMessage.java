package com.baidu.tieba.frs;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PraiseResponseMessage extends JsonHttpResponsedMessage {
    private int a;
    private String b;

    public final String i() {
        return this.b;
    }

    public PraiseResponseMessage(int i) {
        super(i);
        this.a = 0;
        this.b = "";
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        int d = d();
        int e = e();
        if (d == 200 && e >= 0 && jSONObject != null) {
            this.a = jSONObject.optInt("error_code");
            this.b = jSONObject.optString("error_msg");
        }
    }
}
