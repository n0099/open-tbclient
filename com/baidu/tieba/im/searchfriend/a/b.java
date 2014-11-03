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
    String Ac;
    int Af;
    String Ai;
    c biq = new c();
    ArrayList<String> Ah = new ArrayList<>();
    ArrayList<String> Aj = new ArrayList<>();

    public String RD() {
        return this.Ai;
    }

    public int kj() {
        return this.Af;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.Ai = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.biq != null) {
                this.biq.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Af = likeUserInfo.forum_info.size();
                int i = this.Af;
                if (this.Af > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Af > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Ac = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.Ah.add(postInfo.common_post_pic);
                    this.Aj.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String kk() {
        return this.Ac;
    }

    public c RA() {
        return this.biq;
    }

    public ArrayList<String> kn() {
        return this.Ah;
    }

    public ArrayList<String> ko() {
        return this.Aj;
    }

    public JSONObject RE() {
        JSONObject jSONObject = new JSONObject();
        if (this.biq != null) {
            jSONObject.put("recommend_new_user", this.biq.RE());
        }
        jSONObject.put("common_forum", this.Ac);
        jSONObject.put("common_forum_count", this.Af);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Ai);
        if (this.Ah != null && this.Ah.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.Ah.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.Aj != null && this.Aj.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.Aj.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.biq == null) {
                this.biq = new c();
            }
            this.biq.b(jSONObject.optJSONObject("recommend_new_user"));
            this.Ac = jSONObject.optString("common_forum");
            this.Af = jSONObject.optInt("common_forum_count");
            this.Ai = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Ah == null) {
                    this.Ah = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Ah.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Aj == null) {
                    this.Aj = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Aj.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
