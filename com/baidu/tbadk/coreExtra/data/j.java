package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private ArrayList<String> bGD;
    private AntiData ceN = new AntiData();
    private UserData mUser;

    public j() {
        this.mUser = null;
        this.bGD = null;
        this.mUser = new UserData();
        this.bGD = new ArrayList<>(3);
    }

    public ArrayList<String> ali() {
        return this.bGD;
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
                    this.bGD.add(optJSONArray.optString(i, null));
                }
            }
            this.ceN.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
