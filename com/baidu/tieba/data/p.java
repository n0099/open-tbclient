package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class p {
    private String akA;
    private String akB;
    private int errorCode = 0;
    private String errorMsg = "";
    private String akx = "";
    private int aky = 0;
    private int has_more = 0;
    private boolean akz = false;
    private ArrayList<q> akC = new ArrayList<>();

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
                this.aky = jSONObject.optInt("is_new_url", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("error");
                if (optJSONObject != null) {
                    this.errorCode = optJSONObject.optInt("errno", 0);
                    this.errorMsg = optJSONObject.optString("errmsg", "");
                    this.akx = optJSONObject.optString("usermsg", "");
                }
                this.akA = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.TOTAL);
                this.has_more = jSONObject.optInt("has_more");
                JSONArray optJSONArray = jSONObject.optJSONArray("feed_thread_list");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        q qVar = new q();
                        qVar.parserJson(optJSONArray.optJSONObject(i));
                        this.akC.add(qVar);
                    }
                    this.akz = optJSONArray.length() == 0;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(p pVar, boolean z) {
        if (pVar != null) {
            this.has_more = pVar.getHasMore();
            this.akA = pVar.yY();
            this.akB = pVar.yZ();
            this.akz = pVar.yX() == null || pVar.yX().size() == 0;
            if (z) {
                this.akC.addAll(pVar.yX());
            } else {
                this.akC = pVar.yX();
            }
        }
    }

    public int yW() {
        return this.aky;
    }

    public ArrayList<q> yX() {
        return this.akC;
    }

    public int getHasMore() {
        return this.has_more;
    }

    public boolean hasMore() {
        return this.has_more > 0;
    }

    public String yY() {
        return this.akA;
    }

    public String yZ() {
        return this.akB;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String za() {
        return this.akx;
    }
}
