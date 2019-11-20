package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public int bZA;
    public String bZB;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> bZv = new ArrayList<>();
    private ArrayList<a> bZw = new ArrayList<>();
    private d dRe = new d();
    private int bZy = 0;
    private int bZz = 0;

    public ArrayList<a> ahB() {
        return this.bZv;
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
                            this.bZv.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.bZw.add(aVar2);
                        }
                    }
                    this.dRe.parserJson(jSONObject.optJSONObject("page"));
                    if (this.dRe != null) {
                        this.pageNum = this.dRe.ahw();
                        this.bZA = this.dRe.ahu();
                        this.hasMore = this.dRe.ahy() == 1;
                    }
                    this.bZy = jSONObject.optInt("tafriendnum", 0);
                    this.bZz = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.bZB = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
