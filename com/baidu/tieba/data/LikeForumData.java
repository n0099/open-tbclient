package com.baidu.tieba.data;

import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.TiebaLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LikeForumData {
    private String id = null;
    private String name = null;
    private int member_num = 0;
    private int is_like = 0;
    private int user_level = 0;
    private int favo_type = 0;
    private String desc = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMember_num(int member_num) {
        this.member_num = member_num;
    }

    public int getMember_num() {
        return this.member_num;
    }

    public void setIs_like(int is_like) {
        this.is_like = is_like;
    }

    public int isIs_like() {
        return this.is_like;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }

    public int getUser_level() {
        return this.user_level;
    }

    public void setFavo_type(int favo_type) {
        this.favo_type = favo_type;
    }

    public int getFavo_type() {
        return this.favo_type;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("LikeForumData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.id = json.optString("id");
                this.name = json.optString(PersonInfoActivity.TAG_NAME);
                this.member_num = json.optInt("member_count", 0);
                this.is_like = json.optInt("is_like", 0);
                this.user_level = json.optInt("level_id", 1);
                this.favo_type = json.optInt("favo_type", 0);
                this.desc = json.optString("desc");
            } catch (Exception ex) {
                TiebaLog.e("LikeForumData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("LikeForumData", "logPrint", "id = " + this.id);
        TiebaLog.v("LikeForumData", "logPrint", "name = " + this.name);
        TiebaLog.v("LikeForumData", "logPrint", "desc = " + this.desc);
        TiebaLog.v("LikeForumData", "logPrint", "member_num = " + String.valueOf(this.member_num));
        TiebaLog.v("LikeForumData", "logPrint", "is_like = " + String.valueOf(this.is_like));
        TiebaLog.v("LikeForumData", "logPrint", "user_level = " + String.valueOf(this.user_level));
        TiebaLog.v("LikeForumData", "logPrint", "favo_type = " + String.valueOf(this.favo_type));
    }
}
