package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int cQh;
    public String cQi;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> cQc = new ArrayList<>();
    private ArrayList<a> cQd = new ArrayList<>();
    private d eMd = new d();
    private int cQf = 0;
    private int cQg = 0;

    public ArrayList<a> aBn() {
        return this.cQc;
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
                            this.cQc.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.cQd.add(aVar2);
                        }
                    }
                    this.eMd.parserJson(jSONObject.optJSONObject("page"));
                    if (this.eMd != null) {
                        this.pageNum = this.eMd.aBi();
                        this.cQh = this.eMd.aBg();
                        this.hasMore = this.eMd.aBk() == 1;
                    }
                    this.cQf = jSONObject.optInt("tafriendnum", 0);
                    this.cQg = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.cQi = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
