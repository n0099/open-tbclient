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
    String Er;
    int Et;
    String Ex;
    c bon = new c();
    ArrayList<String> Ew = new ArrayList<>();
    ArrayList<String> Ey = new ArrayList<>();

    public String Tl() {
        return this.Ex;
    }

    public int ne() {
        return this.Et;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.Ex = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.bon != null) {
                this.bon.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Et = likeUserInfo.forum_info.size();
                int i = this.Et;
                if (this.Et > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Et > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Er = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.Ew.add(postInfo.common_post_pic);
                    this.Ey.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String nf() {
        return this.Er;
    }

    public c Ti() {
        return this.bon;
    }

    public ArrayList<String> ni() {
        return this.Ew;
    }

    public ArrayList<String> nj() {
        return this.Ey;
    }

    public JSONObject Tm() {
        JSONObject jSONObject = new JSONObject();
        if (this.bon != null) {
            jSONObject.put("recommend_new_user", this.bon.Tm());
        }
        jSONObject.put("common_forum", this.Er);
        jSONObject.put("common_forum_count", this.Et);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Ex);
        if (this.Ew != null && this.Ew.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.Ew.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.Ey != null && this.Ey.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.Ey.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.bon == null) {
                this.bon = new c();
            }
            this.bon.f(jSONObject.optJSONObject("recommend_new_user"));
            this.Er = jSONObject.optString("common_forum");
            this.Et = jSONObject.optInt("common_forum_count");
            this.Ex = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Ew == null) {
                    this.Ew = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Ew.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Ey == null) {
                    this.Ey = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Ey.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
