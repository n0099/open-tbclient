package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public int eCm;
    public String eCn;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> bzc = new ArrayList<>();
    private ArrayList<a> eCi = new ArrayList<>();
    private d gQI = new d();
    private int eCk = 0;
    private int eCl = 0;

    public ArrayList<a> blt() {
        return this.bzc;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optJSONObject("page") != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("common_user_list");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            a aVar = new a();
                            aVar.parserJson(optJSONArray.getJSONObject(i));
                            this.bzc.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.eCi.add(aVar2);
                        }
                    }
                    this.gQI.parserJson(jSONObject.optJSONObject("page"));
                    if (this.gQI != null) {
                        this.pageNum = this.gQI.blo();
                        this.eCm = this.gQI.blm();
                        this.hasMore = this.gQI.blq() == 1;
                    }
                    this.eCk = jSONObject.optInt("tafriendnum", 0);
                    this.eCl = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.eCn = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
