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
    String Qc;
    int Qe;
    String Qi;
    c azH = new c();
    ArrayList<String> Qh = new ArrayList<>();
    ArrayList<String> Qj = new ArrayList<>();

    public String Fp() {
        return this.Qi;
    }

    public int qn() {
        return this.Qe;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.Qi = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.azH != null) {
                this.azH.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.Qe = likeUserInfo.forum_info.size();
                int i = this.Qe;
                if (this.Qe > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.Qe > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.Qc = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.Qh.add(postInfo.common_post_pic);
                    this.Qj.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String qo() {
        return this.Qc;
    }

    public c Fm() {
        return this.azH;
    }

    public ArrayList<String> qr() {
        return this.Qh;
    }

    public ArrayList<String> qs() {
        return this.Qj;
    }

    public HashMap<String, ImageUrlData> getAssistUrls() {
        HashMap<String, ImageUrlData> hashMap = new HashMap<>();
        if (this.Qh != null && this.Qj != null) {
            int min = Math.min(this.Qh.size(), this.Qj.size());
            for (int i = 0; i < min; i++) {
                String str = this.Qj.get(i);
                if (!TextUtils.isEmpty(str)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = this.Qh.get(i);
                    imageUrlData.urlType = 10;
                    hashMap.put(str, imageUrlData);
                }
            }
        }
        return hashMap;
    }

    public JSONObject Fq() {
        JSONObject jSONObject = new JSONObject();
        if (this.azH != null) {
            jSONObject.put("recommend_new_user", this.azH.Fq());
        }
        jSONObject.put("common_forum", this.Qc);
        jSONObject.put("common_forum_count", this.Qe);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.Qi);
        if (this.Qh != null && this.Qh.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.Qh.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.Qj != null && this.Qj.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.Qj.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.azH == null) {
                this.azH = new c();
            }
            this.azH.e(jSONObject.optJSONObject("recommend_new_user"));
            this.Qc = jSONObject.optString("common_forum");
            this.Qe = jSONObject.optInt("common_forum_count");
            this.Qi = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.Qh == null) {
                    this.Qh = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.Qh.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.Qj == null) {
                    this.Qj = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.Qj.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
