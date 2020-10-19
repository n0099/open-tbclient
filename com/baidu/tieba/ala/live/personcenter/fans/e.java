package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public int enW;
    public String enX;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> enR = new ArrayList<>();
    private ArrayList<a> enS = new ArrayList<>();
    private d gzi = new d();
    private int enU = 0;
    private int enV = 0;

    public ArrayList<a> bha() {
        return this.enR;
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
                            this.enR.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.enS.add(aVar2);
                        }
                    }
                    this.gzi.parserJson(jSONObject.optJSONObject("page"));
                    if (this.gzi != null) {
                        this.pageNum = this.gzi.bgV();
                        this.enW = this.gzi.bgT();
                        this.hasMore = this.gzi.bgX() == 1;
                    }
                    this.enU = jSONObject.optInt("tafriendnum", 0);
                    this.enV = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.enX = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
