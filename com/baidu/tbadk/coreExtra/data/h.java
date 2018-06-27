package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private AntiData aBW = new AntiData();
    private ArrayList<String> agT;
    private UserData mUser;

    public h() {
        this.mUser = null;
        this.agT = null;
        this.mUser = new UserData();
        this.agT = new ArrayList<>(3);
    }

    public UserData getUser() {
        return this.mUser;
    }

    public ArrayList<String> Cl() {
        return this.agT;
    }

    public AntiData Cm() {
        return this.aBW;
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
                    this.agT.add(optJSONArray.optString(i, null));
                }
            }
            this.aBW.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
