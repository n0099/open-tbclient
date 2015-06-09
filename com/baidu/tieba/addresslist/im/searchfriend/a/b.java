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
    String QE;
    String Qx;
    int Qz;
    c aBt = new c();
    ArrayList<String> QD = new ArrayList<>();
    ArrayList<String> QF = new ArrayList<>();

    public String Gj() {
        return this.QE;
    }

    public int qT() {
        return this.Qz;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.QE = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.aBt != null) {
                this.aBt.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Qz = likeUserInfo.forum_info.size();
                int i = this.Qz;
                if (this.Qz > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Qz > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Qx = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.QD.add(postInfo.common_post_pic);
                    this.QF.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String qU() {
        return this.Qx;
    }

    public c Gg() {
        return this.aBt;
    }

    public ArrayList<String> qX() {
        return this.QD;
    }

    public ArrayList<String> qY() {
        return this.QF;
    }

    public HashMap<String, ImageUrlData> getAssistUrls() {
        HashMap<String, ImageUrlData> hashMap = new HashMap<>();
        if (this.QD != null && this.QF != null) {
            int min = Math.min(this.QD.size(), this.QF.size());
            for (int i = 0; i < min; i++) {
                String str = this.QF.get(i);
                if (!TextUtils.isEmpty(str)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = this.QD.get(i);
                    imageUrlData.urlType = 10;
                    hashMap.put(str, imageUrlData);
                }
            }
        }
        return hashMap;
    }

    public JSONObject Gk() {
        JSONObject jSONObject = new JSONObject();
        if (this.aBt != null) {
            jSONObject.put("recommend_new_user", this.aBt.Gk());
        }
        jSONObject.put("common_forum", this.Qx);
        jSONObject.put("common_forum_count", this.Qz);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.QE);
        if (this.QD != null && this.QD.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.QD.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.QF != null && this.QF.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.QF.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.aBt == null) {
                this.aBt = new c();
            }
            this.aBt.e(jSONObject.optJSONObject("recommend_new_user"));
            this.Qx = jSONObject.optString("common_forum");
            this.Qz = jSONObject.optInt("common_forum_count");
            this.QE = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.QD == null) {
                    this.QD = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.QD.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.QF == null) {
                    this.QF = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.QF.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
