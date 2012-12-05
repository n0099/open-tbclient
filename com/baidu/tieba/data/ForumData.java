package com.baidu.tieba.data;

import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.TiebaLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ForumData {
    private int favo_type;
    private String level_name;
    private String id = null;
    private String name = null;
    private String first_class = null;
    private String second_class = null;
    private int is_exists = 0;
    private int is_forbidden = 1;
    private int thread_num = 0;
    private int post_num = 0;
    private int member_num = 0;
    private int is_like = 0;
    private int user_level = 0;
    private int album_open_photo_frs = 0;
    private SignData mSignData = new SignData();
    private ArrayList<String> managers = new ArrayList<>();
    private ArrayList<GoodData> good_classify = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public int getFrsImageOpen() {
        return this.album_open_photo_frs;
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

    public void setFirst_class(String first_class) {
        this.first_class = first_class;
    }

    public String getFirst_class() {
        return this.first_class;
    }

    public void setSecond_class(String second_class) {
        this.second_class = second_class;
    }

    public String getSecond_class() {
        return this.second_class;
    }

    public void setIs_exists(int is_exists) {
        this.is_exists = is_exists;
    }

    public int isIs_exists() {
        return this.is_exists;
    }

    public void setIs_forbidden(int is_forbidden) {
        this.is_forbidden = is_forbidden;
    }

    public int isIs_forbidden() {
        return this.is_forbidden;
    }

    public void setThread_num(int thread_num) {
        this.thread_num = thread_num;
    }

    public int getThread_num() {
        return this.thread_num;
    }

    public void setPost_num(int post_num) {
        this.post_num = post_num;
    }

    public int getPost_num() {
        return this.post_num;
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

    public SignData getSignData() {
        return this.mSignData;
    }

    public void setManagers(ArrayList<String> managers) {
        this.managers = managers;
    }

    public ArrayList<String> getManagers() {
        return this.managers;
    }

    public void setGood_classify(ArrayList<GoodData> data) {
        this.good_classify = data;
    }

    public ArrayList<GoodData> getGood_classify() {
        return this.good_classify;
    }

    public String getLevelName() {
        return this.level_name;
    }

    public void parserJson(String data) {
        try {
            JSONObject json = new JSONObject(data);
            parserJson(json);
        } catch (Exception ex) {
            TiebaLog.e("ForumData", "parserJson", "error = " + ex.getMessage());
        }
    }

    public void parserJson(JSONObject json) {
        if (json != null) {
            try {
                this.id = json.optString("id");
                this.name = json.optString(PersonInfoActivity.TAG_NAME);
                this.first_class = json.optString("first_class");
                this.second_class = json.optString("second_class");
                this.is_exists = json.optInt("is_exists", 0);
                this.is_forbidden = json.optInt("is_forbidden", 1);
                this.thread_num = json.optInt("thread_num", 0);
                this.post_num = json.optInt("post_num", 0);
                this.member_num = json.optInt("member_num", 0);
                this.is_like = json.optInt("is_like", 0);
                this.user_level = json.optInt("level_id", 0);
                this.level_name = json.optString("level_name", null);
                this.album_open_photo_frs = json.optInt("album_open_photo_frs", 0);
                setFavo_type(json.optInt("favo_type", 0));
                JSONArray jlist = json.optJSONArray("managers");
                if (jlist != null) {
                    for (int i = 0; i < jlist.length(); i++) {
                        JSONObject name = (JSONObject) jlist.opt(i);
                        this.managers.add(name.optString(PersonInfoActivity.TAG_NAME));
                    }
                }
                JSONArray jlist2 = json.optJSONArray("good_classify");
                if (jlist2 != null) {
                    for (int i2 = 0; i2 < jlist2.length(); i2++) {
                        GoodData tmp = new GoodData();
                        tmp.parserJson(jlist2.optJSONObject(i2));
                        this.good_classify.add(tmp);
                    }
                }
                JSONObject sign_in_info = json.optJSONObject("sign_in_info");
                if (sign_in_info != null) {
                    JSONObject user_info = sign_in_info.optJSONObject("user_info");
                    if (user_info != null) {
                        int user_sign_in = user_info.optInt("is_sign_in");
                        this.mSignData.setIsSigned(user_sign_in);
                        int user_sign_rank = user_info.optInt("user_sign_rank");
                        this.mSignData.setUserSignRank(user_sign_rank);
                    }
                    JSONObject forum_info = sign_in_info.optJSONObject("forum_info");
                    if (forum_info != null) {
                        int signOn = forum_info.optInt("is_on");
                        if (signOn == 0) {
                            this.mSignData.setForumRank(-2);
                            return;
                        }
                        JSONObject rank_info = forum_info.optJSONObject("current_rank_info");
                        if (rank_info != null) {
                            int forum_rank = rank_info.optInt("sign_rank");
                            this.mSignData.setForumRank(forum_rank);
                            int sign_count = rank_info.optInt("sign_count");
                            this.mSignData.setSignCount(sign_count);
                        }
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("ForumData", "parserJson", "error = " + ex.getMessage());
            }
        }
    }

    public void logPrint() {
        TiebaLog.v("ForumData", "logPrint", "id = " + this.id);
        TiebaLog.v("ForumData", "logPrint", "name = " + this.name);
        TiebaLog.v("ForumData", "logPrint", "first_class = " + this.first_class);
        TiebaLog.v("ForumData", "logPrint", "second_class = " + this.second_class);
        TiebaLog.v("ForumData", "logPrint", "is_exists = " + String.valueOf(this.is_exists));
        TiebaLog.v("ForumData", "logPrint", "is_forbidden = " + String.valueOf(this.is_forbidden));
        TiebaLog.v("ForumData", "logPrint", "thread_num = " + String.valueOf(this.thread_num));
        TiebaLog.v("ForumData", "logPrint", "post_num = " + String.valueOf(this.post_num));
        TiebaLog.v("ForumData", "logPrint", "member_num = " + String.valueOf(this.member_num));
        TiebaLog.v("ForumData", "logPrint", "is_like = " + String.valueOf(this.is_like));
        TiebaLog.v("ForumData", "logPrint", "user_level = " + String.valueOf(this.user_level));
        for (int i = 0; i < this.managers.size(); i++) {
            TiebaLog.v("ForumData", "logPrint", "managers" + String.valueOf(i) + " = " + this.managers.get(i));
            this.managers.get(i);
        }
    }

    public void setFavo_type(int favo_type) {
        this.favo_type = favo_type;
    }

    public int getFavo_type() {
        return this.favo_type;
    }
}
