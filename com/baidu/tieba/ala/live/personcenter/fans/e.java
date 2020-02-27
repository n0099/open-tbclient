package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int cQf;
    public String cQg;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> cQa = new ArrayList<>();
    private ArrayList<a> cQb = new ArrayList<>();
    private d eLP = new d();
    private int cQd = 0;
    private int cQe = 0;

    public ArrayList<a> aBl() {
        return this.cQa;
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
                            this.cQa.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.cQb.add(aVar2);
                        }
                    }
                    this.eLP.parserJson(jSONObject.optJSONObject("page"));
                    if (this.eLP != null) {
                        this.pageNum = this.eLP.aBg();
                        this.cQf = this.eLP.aBe();
                        this.hasMore = this.eLP.aBi() == 1;
                    }
                    this.cQd = jSONObject.optInt("tafriendnum", 0);
                    this.cQe = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.cQg = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
