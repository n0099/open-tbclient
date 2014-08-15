package com.baidu.tieba.im.searchfriend.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import protobuf.RecommendFriend.LikeUserInfo;
import protobuf.RecommendFriend.PostInfo;
/* loaded from: classes.dex */
public class b {
    String a;
    int b;
    c c = new c();
    List<String> d = new ArrayList();

    public int a() {
        return this.b;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            if (likeUserInfo.user_info != null && this.c != null) {
                this.c.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.b = likeUserInfo.forum_info.size();
                int i = this.b;
                if (this.b > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.b > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.a = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.d.add(postInfo.common_post_pic);
                }
            }
        }
    }

    public String b() {
        return this.a;
    }

    public c c() {
        return this.c;
    }

    public List<String> d() {
        return this.d;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        if (this.c != null) {
            jSONObject.put("recommend_new_user", this.c.k());
        }
        jSONObject.put("common_forum", this.a);
        jSONObject.put("common_forum_count", this.b);
        if (this.d != null && this.d.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.d) {
                jSONArray.put(str);
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.c == null) {
                this.c = new c();
            }
            this.c.a(jSONObject.optJSONObject("recommend_new_user"));
            this.a = jSONObject.optString("common_forum");
            this.b = jSONObject.optInt("common_forum_count");
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.d == null) {
                    this.d = new ArrayList();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.d.add(optJSONArray.optString(i));
                    }
                }
            }
        }
    }
}
