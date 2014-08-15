package com.baidu.tieba.im.searchfriend.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import protobuf.RecommendFriend.LikeUserInfo;
import protobuf.RecommendFriend.RecommendFriendResIdl;
/* loaded from: classes.dex */
public class a {
    private c a = new c();
    private List<b> b = new ArrayList();

    public c a() {
        return this.a;
    }

    public void a(c cVar) {
        this.a = cVar;
    }

    public void a(b bVar) {
        this.b.add(bVar);
    }

    public List<b> b() {
        return this.b;
    }

    public void a(RecommendFriendResIdl recommendFriendResIdl) {
        if (recommendFriendResIdl != null && recommendFriendResIdl.data != null) {
            if (recommendFriendResIdl.data.new_user != null) {
                this.a.a(recommendFriendResIdl.data.new_user);
            }
            if (recommendFriendResIdl.data.like_user != null && recommendFriendResIdl.data.like_user.size() > 0) {
                for (LikeUserInfo likeUserInfo : recommendFriendResIdl.data.like_user) {
                    b bVar = new b();
                    bVar.a(likeUserInfo);
                    this.b.add(bVar);
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.a == null) {
                this.a = new c();
            }
            this.a.a(jSONObject.optJSONObject("recommend_new_user"));
            JSONArray optJSONArray = jSONObject.optJSONArray("recommend_like_user");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                this.b.clear();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    b bVar = new b();
                    bVar.a(optJSONArray.optJSONObject(i));
                    this.b.add(bVar);
                }
            }
        }
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recommend_new_user", this.a.k());
            if (this.b != null && this.b.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b bVar : this.b) {
                    jSONArray.put(bVar.e());
                }
                jSONObject.put("recommend_like_user", jSONArray);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }
}
