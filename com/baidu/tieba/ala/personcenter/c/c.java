package com.baidu.tieba.ala.personcenter.c;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private boolean isHost = false;
    private AlaUserInfoData user_info = new AlaUserInfoData();
    private h gTw = new h();
    private p gTx = new p();
    private final a gTA = new a();
    private List<AlaLiveInfoData> gTy = new ArrayList();
    private List<o> gTz = new ArrayList();

    public a bYC() {
        return this.gTA;
    }

    public AlaUserInfoData bYD() {
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
                    this.gTz.add(oVar);
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
                for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                    AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                    alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.gTy.add(alaLiveInfoData);
                }
                this.gTw.parserJson(jSONObject2.optJSONObject("media"));
                this.gTx.parserJson(jSONObject2.optJSONObject("privacy_set"));
                this.gTA.parserJson(jSONObject2.optJSONObject("authority_info"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
