package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e {
    public int dZI;
    public String dZJ;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> dZD = new ArrayList<>();
    private ArrayList<a> dZE = new ArrayList<>();
    private d ghG = new d();
    private int dZG = 0;
    private int dZH = 0;

    public ArrayList<a> bdx() {
        return this.dZD;
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
                            this.dZD.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.dZE.add(aVar2);
                        }
                    }
                    this.ghG.parserJson(jSONObject.optJSONObject("page"));
                    if (this.ghG != null) {
                        this.pageNum = this.ghG.bds();
                        this.dZI = this.ghG.bdq();
                        this.hasMore = this.ghG.bdu() == 1;
                    }
                    this.dZG = jSONObject.optInt("tafriendnum", 0);
                    this.dZH = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.dZJ = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
