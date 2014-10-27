package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private String akr;
    private String aks;
    private int errorCode = 0;
    private String errorMsg = "";
    private String ako = "";
    private int akp = 0;
    private int has_more = 0;
    private boolean akq = false;
    private ArrayList<q> akt = new ArrayList<>();

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akp = jSONObject.optInt("is_new_url", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.errorCode = optJSONObject.optInt("errno", 0);
                    this.errorMsg = optJSONObject.optString("errmsg", "");
                    this.ako = optJSONObject.optString("usermsg", "");
                }
                this.akr = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.TOTAL);
                this.has_more = jSONObject.optInt("has_more");
                JSONArray optJSONArray = jSONObject.optJSONArray("feed_thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        q qVar = new q();
                        qVar.parserJson(optJSONArray.optJSONObject(i));
                        this.akt.add(qVar);
                    }
                    this.akq = optJSONArray.length() == 0;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            this.has_more = pVar.getHasMore();
            this.akr = pVar.yW();
            this.aks = pVar.yX();
            this.akq = pVar.yV() == null || pVar.yV().size() == 0;
            if (z) {
                this.akt.addAll(pVar.yV());
            } else {
                this.akt = pVar.yV();
            }
        }
    }

    public int yU() {
        return this.akp;
    }

    public ArrayList<q> yV() {
        return this.akt;
    }

    public int getHasMore() {
        return this.has_more;
    }

    public boolean hasMore() {
        return this.has_more > 0;
    }

    public String yW() {
        return this.akr;
    }

    public String yX() {
        return this.aks;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String yY() {
        return this.ako;
    }
}
