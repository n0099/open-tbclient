package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public int cMc;
    public String cMd;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> cLX = new ArrayList<>();
    private ArrayList<a> cLY = new ArrayList<>();
    private d eHV = new d();
    private int cMa = 0;
    private int cMb = 0;

    public ArrayList<a> ayU() {
        return this.cLX;
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
                            this.cLX.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.cLY.add(aVar2);
                        }
                    }
                    this.eHV.parserJson(jSONObject.optJSONObject("page"));
                    if (this.eHV != null) {
                        this.pageNum = this.eHV.ayP();
                        this.cMc = this.eHV.ayN();
                        this.hasMore = this.eHV.ayR() == 1;
                    }
                    this.cMa = jSONObject.optInt("tafriendnum", 0);
                    this.cMb = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.cMd = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
