package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public int dQl;
    public String dQm;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> dQg = new ArrayList<>();
    private ArrayList<a> dQh = new ArrayList<>();
    private d fVD = new d();
    private int dQj = 0;
    private int dQk = 0;

    public ArrayList<a> aVe() {
        return this.dQg;
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
                            this.dQg.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.dQh.add(aVar2);
                        }
                    }
                    this.fVD.parserJson(jSONObject.optJSONObject("page"));
                    if (this.fVD != null) {
                        this.pageNum = this.fVD.aUZ();
                        this.dQl = this.fVD.aUX();
                        this.hasMore = this.fVD.aVb() == 1;
                    }
                    this.dQj = jSONObject.optInt("tafriendnum", 0);
                    this.dQk = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.dQm = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
