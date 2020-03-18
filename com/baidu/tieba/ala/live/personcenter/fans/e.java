package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int cQu;
    public String cQv;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> cQp = new ArrayList<>();
    private ArrayList<a> cQq = new ArrayList<>();
    private d eMz = new d();
    private int cQs = 0;
    private int cQt = 0;

    public ArrayList<a> aBq() {
        return this.cQp;
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
                            this.cQp.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.cQq.add(aVar2);
                        }
                    }
                    this.eMz.parserJson(jSONObject.optJSONObject("page"));
                    if (this.eMz != null) {
                        this.pageNum = this.eMz.aBl();
                        this.cQu = this.eMz.aBj();
                        this.hasMore = this.eMz.aBn() == 1;
                    }
                    this.cQs = jSONObject.optInt("tafriendnum", 0);
                    this.cQt = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.cQv = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
