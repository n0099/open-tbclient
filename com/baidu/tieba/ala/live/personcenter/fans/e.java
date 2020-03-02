package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int cQg;
    public String cQh;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> cQb = new ArrayList<>();
    private ArrayList<a> cQc = new ArrayList<>();
    private d eLQ = new d();
    private int cQe = 0;
    private int cQf = 0;

    public ArrayList<a> aBn() {
        return this.cQb;
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
                            this.cQb.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.cQc.add(aVar2);
                        }
                    }
                    this.eLQ.parserJson(jSONObject.optJSONObject("page"));
                    if (this.eLQ != null) {
                        this.pageNum = this.eLQ.aBi();
                        this.cQg = this.eLQ.aBg();
                        this.hasMore = this.eLQ.aBk() == 1;
                    }
                    this.cQe = jSONObject.optInt("tafriendnum", 0);
                    this.cQf = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.cQh = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
