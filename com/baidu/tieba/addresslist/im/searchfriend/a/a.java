package com.baidu.tieba.addresslist.im.searchfriend.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecommendFriend.LikeUserInfo;
import tbclient.RecommendFriend.RecommendFriendResIdl;
/* loaded from: classes.dex */
public class a {
    private c aBt = new c();
    private List<b> likeUserList = new ArrayList();

    public c Gg() {
        return this.aBt;
    }

    public void a(c cVar) {
        this.aBt = cVar;
    }

    public void a(b bVar) {
        this.likeUserList.add(bVar);
    }

    public List<b> Gh() {
        return this.likeUserList;
    }

    public void a(RecommendFriendResIdl recommendFriendResIdl) {
        if (recommendFriendResIdl != null && recommendFriendResIdl.data != null) {
            if (recommendFriendResIdl.data.new_user != null) {
                this.aBt.a(recommendFriendResIdl.data.new_user);
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
            if (this.aBt == null) {
                this.aBt = new c();
            }
            this.aBt.e(jSONObject.optJSONObject("recommend_new_user"));
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

    public JSONObject Gi() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recommend_new_user", this.aBt.Gk());
            if (this.likeUserList != null && this.likeUserList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b bVar : this.likeUserList) {
                    jSONArray.put(bVar.Gk());
                }
                jSONObject.put("recommend_like_user", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
