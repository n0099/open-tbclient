package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public int eOU;
    public String eOV;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> bGk = new ArrayList<>();
    private ArrayList<a> eOQ = new ArrayList<>();
    private d hlq = new d();
    private int eOS = 0;
    private int eOT = 0;

    public ArrayList<a> bmI() {
        return this.bGk;
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
                            this.bGk.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.eOQ.add(aVar2);
                        }
                    }
                    this.hlq.parserJson(jSONObject.optJSONObject("page"));
                    if (this.hlq != null) {
                        this.pageNum = this.hlq.bmD();
                        this.eOU = this.hlq.bmB();
                        this.hasMore = this.hlq.bmF() == 1;
                    }
                    this.eOS = jSONObject.optInt("tafriendnum", 0);
                    this.eOT = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.eOV = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
