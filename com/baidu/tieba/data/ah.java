package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ah {
    private ArrayList<UserData> a = new ArrayList<>();
    private com.baidu.tbadk.core.data.l b = new com.baidu.tbadk.core.data.l();

    public void a(com.baidu.tbadk.core.data.l lVar) {
        this.b = lVar;
    }

    public com.baidu.tbadk.core.data.l a() {
        return this.b;
    }

    public ArrayList<UserData> b() {
        return this.a;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        this.a.add(userData);
                    }
                }
                this.b.a(jSONObject.optJSONObject("page"));
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
