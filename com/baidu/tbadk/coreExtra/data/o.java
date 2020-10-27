package com.baidu.tbadk.coreExtra.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class o {
    private AntiData eWX = new AntiData();
    private ArrayList<String> evH;
    private UserData mUser;

    public o() {
        this.mUser = null;
        this.evH = null;
        this.mUser = new UserData();
        this.evH = new ArrayList<>(3);
    }

    public ArrayList<String> bsh() {
        return this.evH;
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
                    this.evH.add(optJSONArray.optString(i, null));
                }
            }
            this.eWX.parserJson(jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
