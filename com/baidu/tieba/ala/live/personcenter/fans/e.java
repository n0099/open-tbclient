package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public int ebS;
    public String ebT;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> ebN = new ArrayList<>();
    private ArrayList<a> ebO = new ArrayList<>();
    private d gkP = new d();
    private int ebQ = 0;
    private int ebR = 0;

    public ArrayList<a> ber() {
        return this.ebN;
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
                            this.ebN.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.ebO.add(aVar2);
                        }
                    }
                    this.gkP.parserJson(jSONObject.optJSONObject("page"));
                    if (this.gkP != null) {
                        this.pageNum = this.gkP.bem();
                        this.ebS = this.gkP.bek();
                        this.hasMore = this.gkP.beo() == 1;
                    }
                    this.ebQ = jSONObject.optInt("tafriendnum", 0);
                    this.ebR = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.ebT = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
