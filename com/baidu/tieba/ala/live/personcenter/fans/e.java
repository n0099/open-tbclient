package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int dpE;
    public String dpF;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> dpz = new ArrayList<>();
    private ArrayList<a> dpA = new ArrayList<>();
    private d fqW = new d();
    private int dpC = 0;
    private int dpD = 0;

    public ArrayList<a> aJB() {
        return this.dpz;
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
                            this.dpz.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.dpA.add(aVar2);
                        }
                    }
                    this.fqW.parserJson(jSONObject.optJSONObject("page"));
                    if (this.fqW != null) {
                        this.pageNum = this.fqW.aJw();
                        this.dpE = this.fqW.aJu();
                        this.hasMore = this.fqW.aJy() == 1;
                    }
                    this.dpC = jSONObject.optInt("tafriendnum", 0);
                    this.dpD = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.dpF = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
