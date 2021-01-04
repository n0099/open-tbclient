package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public int eRt;
    public String eRu;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> bHm = new ArrayList<>();
    private ArrayList<a> eRp = new ArrayList<>();
    private d hlt = new d();
    private int eRr = 0;
    private int eRs = 0;

    public ArrayList<a> bqi() {
        return this.bHm;
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
                            this.bHm.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.eRp.add(aVar2);
                        }
                    }
                    this.hlt.parserJson(jSONObject.optJSONObject("page"));
                    if (this.hlt != null) {
                        this.pageNum = this.hlt.bqd();
                        this.eRt = this.hlt.bqb();
                        this.hasMore = this.hlt.bqf() == 1;
                    }
                    this.eRr = jSONObject.optInt("tafriendnum", 0);
                    this.eRs = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.eRu = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
