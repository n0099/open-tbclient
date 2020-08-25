package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public int dZE;
    public String dZF;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> dZz = new ArrayList<>();
    private ArrayList<a> dZA = new ArrayList<>();
    private d ghC = new d();
    private int dZC = 0;
    private int dZD = 0;

    public ArrayList<a> bdx() {
        return this.dZz;
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
                            this.dZz.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.dZA.add(aVar2);
                        }
                    }
                    this.ghC.parserJson(jSONObject.optJSONObject("page"));
                    if (this.ghC != null) {
                        this.pageNum = this.ghC.bds();
                        this.dZE = this.ghC.bdq();
                        this.hasMore = this.ghC.bdu() == 1;
                    }
                    this.dZC = jSONObject.optInt("tafriendnum", 0);
                    this.dZD = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.dZF = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
