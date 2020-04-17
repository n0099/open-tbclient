package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public int dpA;
    public String dpB;
    public boolean hasMore;
    public int pageNum;
    public int type;
    private ArrayList<a> dpv = new ArrayList<>();
    private ArrayList<a> dpw = new ArrayList<>();
    private d fqR = new d();
    private int dpy = 0;
    private int dpz = 0;

    public ArrayList<a> aJD() {
        return this.dpv;
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
                            this.dpv.add(aVar);
                        }
                    }
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            a aVar2 = new a();
                            aVar2.parserJson(optJSONArray2.getJSONObject(i2));
                            aVar2.mAttentionType = 1;
                            this.dpw.add(aVar2);
                        }
                    }
                    this.fqR.parserJson(jSONObject.optJSONObject("page"));
                    if (this.fqR != null) {
                        this.pageNum = this.fqR.aJy();
                        this.dpA = this.fqR.aJw();
                        this.hasMore = this.fqR.aJA() == 1;
                    }
                    this.dpy = jSONObject.optInt("tafriendnum", 0);
                    this.dpz = jSONObject.optInt("commonfriendnum", 0);
                }
                this.type = jSONObject.optInt("type", 0);
                this.dpB = jSONObject.optString("block_text");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
