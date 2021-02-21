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
    public r hZR;
    private boolean isHost = false;
    private AlaUserInfoData user_info = new AlaUserInfoData();
    private i hZM = new i();
    private q hZN = new q();
    private final a hZQ = new a();
    private List<AlaLiveInfoData> hZO = new ArrayList();
    private List<p> hZP = new ArrayList();

    public a cmV() {
        return this.hZQ;
    }

    public AlaUserInfoData cmW() {
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
                    this.hZP.add(pVar);
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
                for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                    AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                    alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.hZO.add(alaLiveInfoData);
                }
                this.hZM.parserJson(jSONObject2.optJSONObject("media"));
                this.hZN.parserJson(jSONObject2.optJSONObject("privacy_set"));
                this.hZQ.parserJson(jSONObject2.optJSONObject("authority_info"));
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
                if (optJSONObject2 != null) {
                    this.hZR = new r();
                    this.hZR.parseJson(optJSONObject2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
