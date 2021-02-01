package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public UserData mUserData = new UserData();
    public AlaInfoData gGI = new AlaInfoData();

    public void d(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mUserData.parserJson(jSONObject);
        this.gGI.parserJson(jSONObject2);
    }
}
