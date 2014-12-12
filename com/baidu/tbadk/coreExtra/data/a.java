package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private ArrayList<String> DY;
    private UserData mUser;

    public a() {
        this.mUser = null;
        this.DY = null;
        this.mUser = new UserData();
        this.DY = new ArrayList<>(3);
    }

    public UserData getUser() {
        return this.mUser;
    }

    public ArrayList<String> mQ() {
        return this.DY;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.mUser.parserJson(jSONObject.optJSONObject("user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.DY.add(optJSONArray.optString(i, null));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
