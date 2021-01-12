package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public int eMI;
    public String eMJ;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> bCA = new ArrayList<>();
    private ArrayList<a> eME = new ArrayList<>();
    private d hgM = new d();
    private int eMG = 0;
    private int eMH = 0;

    public ArrayList<a> bmp() {
        return this.bCA;
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
                            this.bCA.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.eME.add(aVar2);
                        }
                    }
                    this.hgM.parserJson(jSONObject.optJSONObject("page"));
                    if (this.hgM != null) {
                        this.pageNum = this.hgM.bmk();
                        this.eMI = this.hgM.bmi();
                        this.hasMore = this.hgM.bmm() == 1;
                    }
                    this.eMG = jSONObject.optInt("tafriendnum", 0);
                    this.eMH = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.eMJ = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
