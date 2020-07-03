package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int dJZ;
    public String dKa;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> dJU = new ArrayList<>();
    private ArrayList<a> dJV = new ArrayList<>();
    private d fQk = new d();
    private int dJX = 0;
    private int dJY = 0;

    public ArrayList<a> aRi() {
        return this.dJU;
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
                            this.dJU.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.dJV.add(aVar2);
                        }
                    }
                    this.fQk.parserJson(jSONObject.optJSONObject("page"));
                    if (this.fQk != null) {
                        this.pageNum = this.fQk.aRd();
                        this.dJZ = this.fQk.aRb();
                        this.hasMore = this.fQk.aRf() == 1;
                    }
                    this.dJX = jSONObject.optInt("tafriendnum", 0);
                    this.dJY = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.dKa = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
