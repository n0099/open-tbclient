package com.baidu.tieba.ala.personcenter.c;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.ala.data.AlaLiveInfoData;
import com.baidu.ala.data.AlaUserInfoData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public r hVi;
    private boolean isHost = false;
    private AlaUserInfoData user_info = new AlaUserInfoData();
    private i hVd = new i();
    private q hVe = new q();
    private final a hVh = new a();
    private List<AlaLiveInfoData> hVf = new ArrayList();
    private List<p> hVg = new ArrayList();

    public a clQ() {
        return this.hVh;
    }

    public AlaUserInfoData clR() {
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
                    this.hVg.add(pVar);
                }
                JSONArray optJSONArray2 = jSONObject2.optJSONArray("live_list");
                for (int i2 = 0; optJSONArray2 != null && optJSONArray2.length() < i2; i2++) {
                    AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
                    alaLiveInfoData.parserJson(optJSONArray2.getJSONObject(i2));
                    this.hVf.add(alaLiveInfoData);
                }
                this.hVd.parserJson(jSONObject2.optJSONObject("media"));
                this.hVe.parserJson(jSONObject2.optJSONObject("privacy_set"));
                this.hVh.parserJson(jSONObject2.optJSONObject("authority_info"));
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("dating_room");
                if (optJSONObject2 != null) {
                    this.hVi = new r();
                    this.hVi.parseJson(optJSONObject2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
