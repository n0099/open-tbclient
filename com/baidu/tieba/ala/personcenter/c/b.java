package com.baidu.tieba.ala.personcenter.c;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private boolean isHost = false;
    private AlaUserInfoData user_info = new AlaUserInfoData();
    private g ewS = new g();
    private l ewT = new l();
    private List<AlaLiveInfoData> ewU = new ArrayList();
    private List<k> ewV = new ArrayList();

    public AlaUserInfoData aXC() {
        return this.user_info;
    }

    public void setIsHost(boolean z) {
        this.isHost = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                JSONObject optJSONObject = jSONObject2.optJSONObject("user_info");
                if (optJSONObject != null) {
                    this.user_info = (AlaUserInfoData) OrmObject.objectWithJson(optJSONObject, AlaUserInfoData.class);
                }
                JSONArray optJSONArray = jSONObject2.optJSONArray("watch_list");
                for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                    k kVar = new k();
                    kVar.parseJson(optJSONArray.getJSONObject(i));
                    this.ewV.add(kVar);
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
                for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                    AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                    alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.ewU.add(alaLiveInfoData);
                }
                this.ewS.parserJson(jSONObject2.optJSONObject("media"));
                this.ewT.parserJson(jSONObject2.optJSONObject("privacy_set"));
            } catch (Exception e) {
            }
        }
    }
}
