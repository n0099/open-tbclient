package com.baidu.tieba.data;

import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FeedData {
    private int isFloor;
    private String quote_pid;
    private int type = 0;
    private long time = 0;
    private String title = null;
    private String fname = null;
    private String content = null;
    private String quote_content = null;
    private String thread_id = null;
    private String post_id = null;
    private MetaData replyer = new MetaData();
    private MetaData quote_user = new MetaData();

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return this.time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return this.fname;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setQuote_content(String quote_content) {
        this.quote_content = quote_content;
    }

    public String getQuote_content() {
        return this.quote_content;
    }

    public void setThread_id(String thread_id) {
        this.thread_id = thread_id;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setReplyer(MetaData replyer) {
        this.replyer = replyer;
    }

    public MetaData getReplyer() {
        return this.replyer;
    }

    public void setQuote_user(MetaData quote_user) {
        this.quote_user = quote_user;
    }

    public MetaData getQuote_user() {
        return this.quote_user;
    }

    public void setIsFloor(int floor) {
        this.isFloor = floor;
    }

    public boolean getIsFloor() {
        return this.isFloor == 1;
    }

    public void setQuote_pid(String id) {
        this.quote_pid = id;
    }

    public String getQuote_pid() {
        return this.quote_pid;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("FeedData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.type = json.optInt(MentionActivity.TYPE, 0);
                this.title = json.optString("title");
                this.time = json.optLong("time", 0L) * 1000;
                this.fname = json.optString("fname");
                this.content = json.optString("content");
                this.quote_content = json.optString("quote_content");
                this.thread_id = json.optString("thread_id");
                this.post_id = json.optString("post_id");
                this.isFloor = json.optInt("is_floor");
                this.quote_pid = json.optString("quote_pid");
                this.replyer.parserJson(json.optJSONObject("replyer"));
                this.quote_user.parserJson(json.optJSONObject("quote_user"));
            } catch (Exception ex) {
                TiebaLog.e("FeedData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }
}
