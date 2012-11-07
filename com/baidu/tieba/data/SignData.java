package com.baidu.tieba.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SignData {
    private int is_signed = 0;
    private int user_sign_rank = 0;
    private int count_sign_num = 0;
    private int count_total_sign_num = 0;
    private int forum_rank = 0;
    private int sign_bonus_point = 3;
    private int sign_count = 0;

    public void setForumRank(int forum_rank) {
        this.forum_rank = forum_rank;
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

    public void setIsSigned(int isSign) {
        this.is_signed = isSign;
    }

    public void setUserSignRank(int userSignRank) {
        this.user_sign_rank = userSignRank;
    }

    public int getCountSignNum() {
        return this.count_sign_num;
    }

    public int getCountTotalSignNum() {
        return this.count_total_sign_num;
    }

    public int getBonusPoint() {
        return this.sign_bonus_point;
    }

    public void setSignCount(int signCount) {
        this.sign_count = signCount;
    }

    public int getSignCount() {
        return this.sign_count;
    }

    public void parserJson(String src) {
        try {
            JSONObject json = new JSONObject(src);
            parserJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void parserJson(JSONObject json) {
        try {
            JSONObject mJson = json.optJSONObject("user_info");
            if (mJson != null) {
                this.is_signed = mJson.getInt("is_sign_in");
                this.user_sign_rank = mJson.getInt("user_sign_rank");
                this.count_sign_num = mJson.getInt("cont_sign_num");
                this.count_total_sign_num = mJson.getInt("cout_total_sing_num");
                this.sign_bonus_point = mJson.getInt("sign_bonus_point");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
