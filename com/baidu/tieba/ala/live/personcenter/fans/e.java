package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public int eHC;
    public String eHD;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> bCz = new ArrayList<>();
    private ArrayList<a> eHy = new ArrayList<>();
    private d gZE = new d();
    private int eHA = 0;
    private int eHB = 0;

    public ArrayList<a> bnI() {
        return this.bCz;
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
                            this.bCz.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.eHy.add(aVar2);
                        }
                    }
                    this.gZE.parserJson(jSONObject.optJSONObject("page"));
                    if (this.gZE != null) {
                        this.pageNum = this.gZE.bnD();
                        this.eHC = this.gZE.bnB();
                        this.hasMore = this.gZE.bnF() == 1;
                    }
                    this.eHA = jSONObject.optInt("tafriendnum", 0);
                    this.eHB = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.eHD = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
