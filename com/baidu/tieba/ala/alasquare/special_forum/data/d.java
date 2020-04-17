package com.baidu.tieba.ala.alasquare.special_forum.data;

import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public UserData mUserData = new UserData();
    public AlaInfoData eVw = new AlaInfoData();

    public void c(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mUserData.parserJson(jSONObject);
        this.eVw.parserJson(jSONObject2);
    }
}
