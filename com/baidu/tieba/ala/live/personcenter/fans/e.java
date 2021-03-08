package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public int eQv;
    public String eQw;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> bHK = new ArrayList<>();
    private ArrayList<a> eQr = new ArrayList<>();
    private d hmZ = new d();
    private int eQt = 0;
    private int eQu = 0;

    public ArrayList<a> bmK() {
        return this.bHK;
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
                            this.bHK.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.eQr.add(aVar2);
                        }
                    }
                    this.hmZ.parserJson(jSONObject.optJSONObject("page"));
                    if (this.hmZ != null) {
                        this.pageNum = this.hmZ.bmF();
                        this.eQv = this.hmZ.bmD();
                        this.hasMore = this.hmZ.bmH() == 1;
                    }
                    this.eQt = jSONObject.optInt("tafriendnum", 0);
                    this.eQu = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.eQw = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
