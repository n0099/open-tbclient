package com.baidu.tieba.addresslist.im.searchfriend.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecommendFriend.LikeUserInfo;
import tbclient.RecommendFriend.RecommendFriendResIdl;
/* loaded from: classes.dex */
public class a {
    private c aBs = new c();
    private List<b> likeUserList = new ArrayList();

    public c Gf() {
        return this.aBs;
    }

    public void a(c cVar) {
        this.aBs = cVar;
    }

    public void a(b bVar) {
        this.likeUserList.add(bVar);
    }

    public List<b> Gg() {
        return this.likeUserList;
    }

    public void a(RecommendFriendResIdl recommendFriendResIdl) {
        if (recommendFriendResIdl != null && recommendFriendResIdl.data != null) {
            if (recommendFriendResIdl.data.new_user != null) {
                this.aBs.a(recommendFriendResIdl.data.new_user);
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

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.aBs == null) {
                this.aBs = new c();
            }
            this.aBs.e(jSONObject.optJSONObject("recommend_new_user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("recommend_like_user");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.likeUserList == null) {
                    this.likeUserList = new ArrayList();
                }
                this.likeUserList.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    b bVar = new b();
                    bVar.e(optJSONArray.optJSONObject(i));
                    this.likeUserList.add(bVar);
                }
            }
        }
    }

    public JSONObject Gh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recommend_new_user", this.aBs.Gj());
            if (this.likeUserList != null && this.likeUserList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b bVar : this.likeUserList) {
                    jSONArray.put(bVar.Gj());
                }
                jSONObject.put("recommend_like_user", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
