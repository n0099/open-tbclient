package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private ArrayList<String> WO;
    private UserData mUser;

    public f() {
        this.mUser = null;
        this.WO = null;
        this.mUser = new UserData();
        this.WO = new ArrayList<>(3);
    }

    public UserData getUser() {
        return this.mUser;
    }

    public ArrayList<String> ys() {
        return this.WO;
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
                    this.WO.add(optJSONArray.optString(i, null));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
