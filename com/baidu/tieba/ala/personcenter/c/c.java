package com.baidu.tieba.ala.personcenter.c;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public r hZP;
    private boolean isHost = false;
    private AlaUserInfoData user_info = new AlaUserInfoData();
    private i hZK = new i();
    private q hZL = new q();
    private final a hZO = new a();
    private List<AlaLiveInfoData> hZM = new ArrayList();
    private List<p> hZN = new ArrayList();

    public a cpI() {
        return this.hZO;
    }

    public AlaUserInfoData cpJ() {
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
                    p pVar = new p();
                    pVar.parseJson(optJSONArray.getJSONObject(i));
                    this.hZN.add(pVar);
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
                for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                    AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                    alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.hZM.add(alaLiveInfoData);
                }
                this.hZK.parserJson(jSONObject2.optJSONObject("media"));
                this.hZL.parserJson(jSONObject2.optJSONObject("privacy_set"));
                this.hZO.parserJson(jSONObject2.optJSONObject("authority_info"));
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
                if (optJSONObject2 != null) {
                    this.hZP = new r();
                    this.hZP.parseJson(optJSONObject2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
