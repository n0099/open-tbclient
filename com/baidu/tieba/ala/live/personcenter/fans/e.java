package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public int ewu;
    public String ewv;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> ewp = new ArrayList<>();
    private ArrayList<a> ewq = new ArrayList<>();
    private d gKW = new d();
    private int ews = 0;
    private int ewt = 0;

    public ArrayList<a> biT() {
        return this.ewp;
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
                            this.ewp.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.ewq.add(aVar2);
                        }
                    }
                    this.gKW.parserJson(jSONObject.optJSONObject("page"));
                    if (this.gKW != null) {
                        this.pageNum = this.gKW.biO();
                        this.ewu = this.gKW.biM();
                        this.hasMore = this.gKW.biQ() == 1;
                    }
                    this.ews = jSONObject.optInt("tafriendnum", 0);
                    this.ewt = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.ewv = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
