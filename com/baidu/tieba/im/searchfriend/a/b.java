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
    String En;
    int Ep;
    String Et;
    c bmQ = new c();
    ArrayList<String> Es = new ArrayList<>();
    ArrayList<String> Eu = new ArrayList<>();

    public String SP() {
        return this.Et;
    }

    public int nc() {
        return this.Ep;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.Et = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.bmQ != null) {
                this.bmQ.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Ep = likeUserInfo.forum_info.size();
                int i = this.Ep;
                if (this.Ep > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Ep > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.En = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.Es.add(postInfo.common_post_pic);
                    this.Eu.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String nd() {
        return this.En;
    }

    public c SM() {
        return this.bmQ;
    }

    public ArrayList<String> ng() {
        return this.Es;
    }

    public ArrayList<String> nh() {
        return this.Eu;
    }

    public JSONObject SQ() {
        JSONObject jSONObject = new JSONObject();
        if (this.bmQ != null) {
            jSONObject.put("recommend_new_user", this.bmQ.SQ());
        }
        jSONObject.put("common_forum", this.En);
        jSONObject.put("common_forum_count", this.Ep);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Et);
        if (this.Es != null && this.Es.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.Es.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.Eu != null && this.Eu.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.Eu.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bmQ == null) {
                this.bmQ = new c();
            }
            this.bmQ.f(jSONObject.optJSONObject("recommend_new_user"));
            this.En = jSONObject.optString("common_forum");
            this.Ep = jSONObject.optInt("common_forum_count");
            this.Et = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Es == null) {
                    this.Es = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Es.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Eu == null) {
                    this.Eu = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Eu.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
