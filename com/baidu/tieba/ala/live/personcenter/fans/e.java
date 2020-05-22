package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int dDD;
    public String dDE;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> dDy = new ArrayList<>();
    private ArrayList<a> dDz = new ArrayList<>();
    private d fEQ = new d();
    private int dDB = 0;
    private int dDC = 0;

    public ArrayList<a> aPw() {
        return this.dDy;
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
                            this.dDy.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.dDz.add(aVar2);
                        }
                    }
                    this.fEQ.parserJson(jSONObject.optJSONObject("page"));
                    if (this.fEQ != null) {
                        this.pageNum = this.fEQ.aPr();
                        this.dDD = this.fEQ.aPp();
                        this.hasMore = this.fEQ.aPt() == 1;
                    }
                    this.dDB = jSONObject.optInt("tafriendnum", 0);
                    this.dDC = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.dDE = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
