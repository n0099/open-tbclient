package com.baidu.tieba.addresslist.im.searchfriend.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.RecommendFriend.LikeUserInfo;
import tbclient.RecommendFriend.PostInfo;
/* loaded from: classes.dex */
public class b {
    String Qa;
    int Qc;
    String Qg;
    c azz = new c();
    ArrayList<String> Qf = new ArrayList<>();
    ArrayList<String> Qh = new ArrayList<>();

    public String Fj() {
        return this.Qg;
    }

    public int qn() {
        return this.Qc;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.Qg = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.azz != null) {
                this.azz.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Qc = likeUserInfo.forum_info.size();
                int i = this.Qc;
                if (this.Qc > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Qc > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Qa = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.Qf.add(postInfo.common_post_pic);
                    this.Qh.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String qo() {
        return this.Qa;
    }

    public c Fg() {
        return this.azz;
    }

    public ArrayList<String> qr() {
        return this.Qf;
    }

    public ArrayList<String> qs() {
        return this.Qh;
    }

    public HashMap<String, ImageUrlData> getAssistUrls() {
        HashMap<String, ImageUrlData> hashMap = new HashMap<>();
        if (this.Qf != null && this.Qh != null) {
            int min = Math.min(this.Qf.size(), this.Qh.size());
            for (int i = 0; i < min; i++) {
                String str = this.Qh.get(i);
                if (!TextUtils.isEmpty(str)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = this.Qf.get(i);
                    imageUrlData.urlType = 10;
                    hashMap.put(str, imageUrlData);
                }
            }
        }
        return hashMap;
    }

    public JSONObject Fk() {
        JSONObject jSONObject = new JSONObject();
        if (this.azz != null) {
            jSONObject.put("recommend_new_user", this.azz.Fk());
        }
        jSONObject.put("common_forum", this.Qa);
        jSONObject.put("common_forum_count", this.Qc);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Qg);
        if (this.Qf != null && this.Qf.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.Qf.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.Qh != null && this.Qh.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.Qh.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.azz == null) {
                this.azz = new c();
            }
            this.azz.e(jSONObject.optJSONObject("recommend_new_user"));
            this.Qa = jSONObject.optString("common_forum");
            this.Qc = jSONObject.optInt("common_forum_count");
            this.Qg = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Qf == null) {
                    this.Qf = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Qf.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Qh == null) {
                    this.Qh = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Qh.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
