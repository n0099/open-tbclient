package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {
    private ArrayList<UserData> a = new ArrayList<>();
    private ArrayList<UserData> b = new ArrayList<>();
    private com.baidu.tbadk.core.data.k c = new com.baidu.tbadk.core.data.k();
    private int d = 0;
    private int e = 0;

    public void a(com.baidu.tbadk.core.data.k kVar) {
        this.c = kVar;
    }

    public com.baidu.tbadk.core.data.k a() {
        return this.c;
    }

    public ArrayList<UserData> b() {
        return this.a;
    }

    public ArrayList<UserData> c() {
        return this.b;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        this.a.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.b.add(userData2);
                    }
                }
                this.c.a(jSONObject.optJSONObject("page"));
                this.d = jSONObject.optInt("tafriendnum", 0);
                this.e = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
