package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
    private List<x> mPraiseList = null;
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

    public int getPraiseNum() {
        return this.mPraiseNum;
    }

    public int getPraiseLiked() {
        return this.mPraiseLiked;
    }

    public List<x> getPraiseList() {
        return this.mPraiseList;
    }

    public int getType() {
        return this.type;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public String getFname() {
        return this.fname;
    }

    public String getContent() {
        return this.content;
    }

    public String getQuote_content() {
        return this.quote_content;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public MetaData getReplyer() {
        return this.replyer;
    }

    public MetaData getQuote_user() {
        return this.quote_user;
    }

    public boolean getIsFloor() {
        return this.isFloor == 1;
    }

    public String getQuote_pid() {
        return this.quote_pid;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.type = jSONObject.optInt("type", 0);
                this.title = jSONObject.optString("title");
                this.time = jSONObject.optLong("time", 0L) * 1000;
                this.fname = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.content = jSONObject.optString("content");
                this.quote_content = jSONObject.optString("quote_content");
                this.thread_id = jSONObject.optString("thread_id");
                this.post_id = jSONObject.optString("post_id");
                this.isFloor = jSONObject.optInt("is_floor");
                this.quote_pid = jSONObject.optString("quote_pid");
                this.mPraiseItemType = jSONObject.optString("item_type");
                if (!com.baidu.adp.lib.util.l.aA(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(TYPE_ZAN);
                    this.mPraiseNum = optJSONObject.optInt("num");
                    this.mPraiseLiked = optJSONObject.optInt("is_liked");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("liker_list");
                    if (optJSONArray != null) {
                        this.mPraiseList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            x xVar = new x();
                            xVar.parserJson(optJSONArray.optJSONObject(i));
                            this.mPraiseList.add(xVar);
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
                if (!com.baidu.adp.lib.util.l.aA(this.mPraiseItemType) && this.mPraiseItemType.equals(TYPE_ZAN) && (zan = replyList.zan) != null) {
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
                            x xVar = new x();
                            xVar.a(list.get(i2));
                            this.mPraiseList.add(xVar);
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
