package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public int car;
    public String cas;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> cam = new ArrayList<>();
    private ArrayList<a> can = new ArrayList<>();
    private d dRV = new d();
    private int cap = 0;
    private int caq = 0;

    public ArrayList<a> ahD() {
        return this.cam;
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
                            this.cam.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.can.add(aVar2);
                        }
                    }
                    this.dRV.parserJson(jSONObject.optJSONObject("page"));
                    if (this.dRV != null) {
                        this.pageNum = this.dRV.ahy();
                        this.car = this.dRV.ahw();
                        this.hasMore = this.dRV.ahA() == 1;
                    }
                    this.cap = jSONObject.optInt("tafriendnum", 0);
                    this.caq = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.cas = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
