package com.baidu.tieba.data;

import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PageData {
    private int total_page = 0;
    private int total_num = 0;
    private int current_page = 0;
    private int page_size = 0;
    private int has_more = 0;
    private int has_prev = 0;

    public int getTotal_page() {
        return this.total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public int getTotal_num() {
        return this.total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public int getCurrent_page() {
        return this.current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getPage_size() {
        return this.page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public void setHave_more(int has_more) {
        this.has_more = has_more;
    }

    public int getHave_more() {
        return this.has_more;
    }

    public void setHave_pre(int has_prev) {
        this.has_prev = has_prev;
    }

    public int getHave_pre() {
        return this.has_prev;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("PageData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.total_page = json.optInt("total_page", 0);
                this.total_num = json.optInt("total_num", 0);
                this.current_page = json.optInt("current_page", 0);
                this.page_size = json.optInt("page_size", 0);
                this.has_more = json.optInt("has_more", 0);
                this.has_prev = json.optInt("has_prev", 0);
            } catch (Exception ex) {
                TiebaLog.e("PageData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("PageData", "logPrint", "total_page = " + String.valueOf(this.total_page));
        TiebaLog.v("PageData", "logPrint", "total_num = " + String.valueOf(this.total_num));
        TiebaLog.v("PageData", "logPrint", "current_page = " + String.valueOf(this.current_page));
        TiebaLog.v("PageData", "logPrint", "page_size = " + String.valueOf(this.page_size));
        TiebaLog.v("PageData", "logPrint", "has_more = " + String.valueOf(this.has_more));
        TiebaLog.v("PageData", "logPrint", "has_prev = " + String.valueOf(this.has_prev));
    }
}
