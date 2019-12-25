package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public int cLS;
    public String cLT;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> cLN = new ArrayList<>();
    private ArrayList<a> cLO = new ArrayList<>();
    private d eGL = new d();
    private int cLQ = 0;
    private int cLR = 0;

    public ArrayList<a> ayB() {
        return this.cLN;
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
                            this.cLN.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.cLO.add(aVar2);
                        }
                    }
                    this.eGL.parserJson(jSONObject.optJSONObject("page"));
                    if (this.eGL != null) {
                        this.pageNum = this.eGL.ayw();
                        this.cLS = this.eGL.ayu();
                        this.hasMore = this.eGL.ayy() == 1;
                    }
                    this.cLQ = jSONObject.optInt("tafriendnum", 0);
                    this.cLR = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.cLT = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
