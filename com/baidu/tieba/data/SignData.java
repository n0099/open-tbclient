package com.baidu.tieba.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SignData implements Serializable {
    private static final long serialVersionUID = -7905612002845096083L;
    private String forumId;
    private String forumName;
    private int is_signed = 0;
    private int user_sign_rank = 0;
    private int count_sign_num = 0;
    private int count_total_sign_num = 0;
    private int forum_rank = 0;
    private int sign_bonus_point = 3;
    private int sign_count = 0;

    public void setForumRank(int i) {
        this.forum_rank = i;
    }

    public int getForumRank() {
        return this.forum_rank;
    }

    public int getSigned() {
        return this.is_signed;
    }

    public int getUserSignRank() {
        return this.user_sign_rank;
    }

    public void setIsSigned(int i) {
        this.is_signed = i;
    }

    public void setUserSignRank(int i) {
        this.user_sign_rank = i;
    }

    public int getCountSignNum() {
        return this.count_sign_num;
    }

    public void setCountSignNum(int i) {
        this.count_sign_num = i;
    }

    public int getCountTotalSignNum() {
        return this.count_total_sign_num;
    }

    public int getBonusPoint() {
        return this.sign_bonus_point;
    }

    public void setBonusPoint(int i) {
        this.sign_bonus_point = i;
    }

    public void setSignCount(int i) {
        this.sign_count = i;
    }

    public int getSignCount() {
        return this.sign_count;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("user_info");
            if (optJSONObject != null) {
                this.is_signed = optJSONObject.getInt("is_sign_in");
                this.user_sign_rank = optJSONObject.getInt("user_sign_rank");
                this.count_sign_num = optJSONObject.getInt("cont_sign_num");
                this.count_total_sign_num = optJSONObject.getInt("cout_total_sing_num");
                this.sign_bonus_point = optJSONObject.getInt("sign_bonus_point");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
