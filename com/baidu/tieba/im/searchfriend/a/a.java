package com.baidu.tieba.im.searchfriend.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecommendFriend.LikeUserInfo;
import tbclient.RecommendFriend.RecommendFriendResIdl;
/* loaded from: classes.dex */
public class a {
    private c bon = new c();
    private List<b> likeUserList = new ArrayList();

    public c Ti() {
        return this.bon;
    }

    public void a(c cVar) {
        this.bon = cVar;
    }

    public void a(b bVar) {
        this.likeUserList.add(bVar);
    }

    public List<b> Tj() {
        return this.likeUserList;
    }

    public void a(RecommendFriendResIdl recommendFriendResIdl) {
        if (recommendFriendResIdl != null && recommendFriendResIdl.data != null) {
            if (recommendFriendResIdl.data.new_user != null) {
                this.bon.a(recommendFriendResIdl.data.new_user);
            }
            if (recommendFriendResIdl.data.like_user != null && recommendFriendResIdl.data.like_user.size() > 0) {
                for (LikeUserInfo likeUserInfo : recommendFriendResIdl.data.like_user) {
                    b bVar = new b();
                    bVar.a(likeUserInfo);
                    this.likeUserList.add(bVar);
                }
            }
        }
    }

    public void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bon == null) {
                this.bon = new c();
            }
            this.bon.f(jSONObject.optJSONObject("recommend_new_user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("recommend_like_user");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.likeUserList == null) {
                    this.likeUserList = new ArrayList();
                }
                this.likeUserList.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    b bVar = new b();
                    bVar.f(optJSONArray.optJSONObject(i));
                    this.likeUserList.add(bVar);
                }
            }
        }
    }

    public JSONObject Tk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recommend_new_user", this.bon.Tm());
            if (this.likeUserList != null && this.likeUserList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b bVar : this.likeUserList) {
                    jSONArray.put(bVar.Tm());
                }
                jSONObject.put("recommend_like_user", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
