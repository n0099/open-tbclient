package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private AntiData aET = new AntiData();
    private ArrayList<String> aiN;
    private UserData mUser;

    public i() {
        this.mUser = null;
        this.aiN = null;
        this.mUser = new UserData();
        this.aiN = new ArrayList<>(3);
    }

    public ArrayList<String> Do() {
        return this.aiN;
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
                    this.aiN.add(optJSONArray.optString(i, null));
                }
            }
            this.aET.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
