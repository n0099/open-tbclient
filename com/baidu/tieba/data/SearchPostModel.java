package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SearchPostModel implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<p> datas;
    private int totalCount = 0;
    private int currentPage = 0;
    private int totalPage = 0;
    private boolean hasPre = false;
    private boolean hasMore = false;

    public SearchPostModel() {
        this.datas = null;
        this.datas = new ArrayList<>();
    }

    public ArrayList<p> getData() {
        return this.datas;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public boolean hasPre() {
        return this.hasPre;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

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
                JSONObject optJSONObject = jSONObject.optJSONObject("page");
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                this.datas.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    p pVar = new p();
                    pVar.parserJson(optJSONObject2);
                    this.datas.add(pVar);
                }
                this.totalCount = optJSONObject.optInt("total_count");
                this.totalPage = optJSONObject.optInt("total_page");
                this.hasMore = optJSONObject.optInt("has_more") != 0;
                this.hasPre = optJSONObject.optInt("has_prev") != 0;
                this.currentPage = optJSONObject.optInt("current_page");
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
