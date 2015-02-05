package com.baidu.tieba.im.searchfriend.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecommendFriend.LikeUserInfo;
import tbclient.RecommendFriend.PostInfo;
/* loaded from: classes.dex */
public class b {
    String Eo;
    int Eq;
    String Eu;
    c bom = new c();
    ArrayList<String> Et = new ArrayList<>();
    ArrayList<String> Ev = new ArrayList<>();

    public String Tg() {
        return this.Eu;
    }

    public int mX() {
        return this.Eq;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.Eu = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.bom != null) {
                this.bom.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Eq = likeUserInfo.forum_info.size();
                int i = this.Eq;
                if (this.Eq > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Eq > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Eo = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.Et.add(postInfo.common_post_pic);
                    this.Ev.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String mY() {
        return this.Eo;
    }

    public c Td() {
        return this.bom;
    }

    public ArrayList<String> nb() {
        return this.Et;
    }

    public ArrayList<String> nc() {
        return this.Ev;
    }

    public JSONObject Th() {
        JSONObject jSONObject = new JSONObject();
        if (this.bom != null) {
            jSONObject.put("recommend_new_user", this.bom.Th());
        }
        jSONObject.put("common_forum", this.Eo);
        jSONObject.put("common_forum_count", this.Eq);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Eu);
        if (this.Et != null && this.Et.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.Et.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.Ev != null && this.Ev.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.Ev.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bom == null) {
                this.bom = new c();
            }
            this.bom.f(jSONObject.optJSONObject("recommend_new_user"));
            this.Eo = jSONObject.optString("common_forum");
            this.Eq = jSONObject.optInt("common_forum_count");
            this.Eu = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Et == null) {
                    this.Et = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Et.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Ev == null) {
                    this.Ev = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Ev.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
