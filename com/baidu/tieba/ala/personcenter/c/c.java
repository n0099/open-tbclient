package com.baidu.tieba.ala.personcenter.c;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private boolean isHost = false;
    private AlaUserInfoData user_info = new AlaUserInfoData();
    private h fZx = new h();
    private p fZy = new p();
    private final a fZB = new a();
    private List<AlaLiveInfoData> fZz = new ArrayList();
    private List<o> fZA = new ArrayList();

    public a bBV() {
        return this.fZB;
    }

    public AlaUserInfoData bBW() {
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
                    o oVar = new o();
                    oVar.parseJson(optJSONArray.getJSONObject(i));
                    this.fZA.add(oVar);
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
                for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                    AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                    alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.fZz.add(alaLiveInfoData);
                }
                this.fZx.parserJson(jSONObject2.optJSONObject("media"));
                this.fZy.parserJson(jSONObject2.optJSONObject("privacy_set"));
                this.fZB.parserJson(jSONObject2.optJSONObject("authority_info"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
