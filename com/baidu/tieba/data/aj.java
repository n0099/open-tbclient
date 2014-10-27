package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aj {
    private ArrayList<UserData> alW = new ArrayList<>();
    private ArrayList<UserData> alX = new ArrayList<>();
    private com.baidu.tbadk.core.data.m alY = new com.baidu.tbadk.core.data.m();
    private int friendNum = 0;
    private int alZ = 0;

    public void a(com.baidu.tbadk.core.data.m mVar) {
        this.alY = mVar;
    }

    public com.baidu.tbadk.core.data.m zM() {
        return this.alY;
    }

    public ArrayList<UserData> zY() {
        return this.alW;
    }

    public ArrayList<UserData> zZ() {
        return this.alX;
    }

    public int getFriendNum() {
        return this.friendNum;
    }

    public int Aa() {
        return this.alZ;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        UserData userData = new UserData();
                        userData.parserJson(optJSONArray.getJSONObject(i));
                        this.alW.add(userData);
                    }
                }
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        UserData userData2 = new UserData();
                        userData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.alX.add(userData2);
                    }
                }
                this.alY.parserJson(jSONObject.optJSONObject("page"));
                this.friendNum = jSONObject.optInt("tafriendnum", 0);
                this.alZ = jSONObject.optInt("commonfriendnum", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
