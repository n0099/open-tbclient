package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.ReplyList;
import tbclient.User;
import tbclient.Zan;
/* loaded from: classes.dex */
public class FeedData implements Serializable {
    public static final String TYPE_ZAN = "zan";
    private static final long serialVersionUID = 6674573822882830667L;
    private int isFloor;
    private String mPraiseItemType;
    private String quote_pid;
    private int mPraiseNum = 0;
    private int mPraiseLiked = 0;
    private List<y> mPraiseList = null;
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

    public String getPraiseItemType() {
        return this.mPraiseItemType;
    }

    public void setPraiseItemType(String str) {
        this.mPraiseItemType = str;
    }

    public int getPraiseNum() {
        return this.mPraiseNum;
    }

    public int getPraiseLiked() {
        return this.mPraiseLiked;
    }

    public List<y> getPraiseList() {
        return this.mPraiseList;
    }

    public void setPraiseNum(int i) {
        this.mPraiseNum = i;
    }

    public void setPraiseLiked(int i) {
        this.mPraiseLiked = i;
    }

    public void setPraiseList(List<y> list) {
        this.mPraiseList = list;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public long getTime() {
        return this.time;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setFname(String str) {
        this.fname = str;
    }

    public String getFname() {
        return this.fname;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setQuote_content(String str) {
        this.quote_content = str;
    }

    public String getQuote_content() {
        return this.quote_content;
    }

    public void setThread_id(String str) {
        this.thread_id = str;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public void setPost_id(String str) {
        this.post_id = str;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public void setReplyer(MetaData metaData) {
        this.replyer = metaData;
    }

    public MetaData getReplyer() {
        return this.replyer;
    }

    public void setQuote_user(MetaData metaData) {
        this.quote_user = metaData;
    }

    public MetaData getQuote_user() {
        return this.quote_user;
    }

    public void setIsFloor(int i) {
        this.isFloor = i;
    }

    public boolean getIsFloor() {
        return this.isFloor == 1;
    }

    public void setQuote_pid(String str) {
        this.quote_pid = str;
    }

    public String getQuote_pid() {
        return this.quote_pid;
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
                this.type = jSONObject.optInt("type", 0);
                this.title = jSONObject.optString("title");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.fname = jSONObject.optString("fname");
                this.content = jSONObject.optString("content");
                this.quote_content = jSONObject.optString("quote_content");
                this.thread_id = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID);
                this.post_id = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.POST_ID);
                this.isFloor = jSONObject.optInt("is_floor");
                this.quote_pid = jSONObject.optString("quote_pid");
                this.mPraiseItemType = jSONObject.optString("item_type");
                if (!com.baidu.adp.lib.util.i.c(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(TYPE_ZAN);
                    this.mPraiseNum = optJSONObject.optInt("num");
                    this.mPraiseLiked = optJSONObject.optInt("is_liked");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("liker_list");
                    if (optJSONArray != null) {
                        this.mPraiseList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            y yVar = new y();
                            yVar.a(optJSONArray.optJSONObject(i));
                            this.mPraiseList.add(yVar);
                        }
                    }
                }
                this.replyer.parserJson(jSONObject.optJSONObject("replyer"));
                this.quote_user.parserJson(jSONObject.optJSONObject("quote_user"));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void parserProtoBuf(ReplyList replyList) {
        Zan zan;
        if (replyList != null) {
            try {
                this.type = replyList.type.intValue();
                this.title = replyList.title;
                this.time = replyList.time.intValue() * 1000;
                this.fname = replyList.fname;
                this.content = replyList.content;
                this.quote_content = replyList.quote_content;
                this.thread_id = String.valueOf(replyList.thread_id);
                this.post_id = String.valueOf(replyList.post_id);
                this.isFloor = replyList.is_floor.intValue();
                this.quote_pid = String.valueOf(replyList.quote_pid);
                this.mPraiseItemType = replyList.item_type;
                if (!com.baidu.adp.lib.util.i.c(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN) && (zan = replyList.zan) != null) {
                    this.mPraiseNum = zan.num.intValue();
                    this.mPraiseLiked = zan.is_liked.intValue();
                    List<User> list = zan.liker_list;
                    if (list != null) {
                        this.mPraiseList = new ArrayList();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= list.size()) {
                                break;
                            }
                            y yVar = new y();
                            yVar.a(list.get(i2));
                            this.mPraiseList.add(yVar);
                            i = i2 + 1;
                        }
                    }
                }
                this.replyer.parserProtobuf(replyList.replyer);
                this.quote_user.parserProtobuf(replyList.quote_user);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
