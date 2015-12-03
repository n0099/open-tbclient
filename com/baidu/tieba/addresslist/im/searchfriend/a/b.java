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
    String VM;
    int VO;
    String VS;
    c aJX = new c();
    ArrayList<String> VR = new ArrayList<>();
    ArrayList<String> VT = new ArrayList<>();

    public String HF() {
        return this.VS;
    }

    public int sl() {
        return this.VO;
    }

    public void a(LikeUserInfo likeUserInfo) {
        if (likeUserInfo != null) {
            this.VS = likeUserInfo.message;
            if (likeUserInfo.user_info != null && this.aJX != null) {
                this.aJX.a(likeUserInfo.user_info);
            }
            if (likeUserInfo.forum_info != null) {
                StringBuffer stringBuffer = new StringBuffer();
                this.VO = likeUserInfo.forum_info.size();
                int i = this.VO;
                if (this.VO > 2) {
                    i = 2;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    if (likeUserInfo.forum_info.get(i2) != null) {
                        stringBuffer.append(likeUserInfo.forum_info.get(i2).common_forum);
                        if (i - 1 > i2) {
                            stringBuffer.append("、");
                        } else if (this.VO > i) {
                            stringBuffer.append("...");
                        }
                    }
                }
                this.VM = stringBuffer.toString();
            }
            if (likeUserInfo.post_info != null) {
                for (PostInfo postInfo : likeUserInfo.post_info) {
                    this.VR.add(postInfo.common_post_pic);
                    this.VT.add(postInfo.large_post_pic);
                }
            }
        }
    }

    public String sm() {
        return this.VM;
    }

    public c HC() {
        return this.aJX;
    }

    public ArrayList<String> sp() {
        return this.VR;
    }

    public ArrayList<String> sq() {
        return this.VT;
    }

    public HashMap<String, ImageUrlData> getAssistUrls() {
        HashMap<String, ImageUrlData> hashMap = new HashMap<>();
        if (this.VR != null && this.VT != null) {
            int min = Math.min(this.VR.size(), this.VT.size());
            for (int i = 0; i < min; i++) {
                String str = this.VT.get(i);
                if (!TextUtils.isEmpty(str)) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.imageUrl = this.VR.get(i);
                    imageUrlData.urlType = 10;
                    hashMap.put(str, imageUrlData);
                }
            }
        }
        return hashMap;
    }

    public JSONObject HG() {
        JSONObject jSONObject = new JSONObject();
        if (this.aJX != null) {
            jSONObject.put("recommend_new_user", this.aJX.HG());
        }
        jSONObject.put("common_forum", this.VM);
        jSONObject.put("common_forum_count", this.VO);
        jSONObject.put(AddFriendActivityConfig.DEFAULT_MESSAGE, this.VS);
        if (this.VR != null && this.VR.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = this.VR.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put("common_pic_urls", jSONArray);
        }
        if (this.VT != null && this.VT.size() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<String> it2 = this.VT.iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next());
            }
            jSONObject.put("large_post_pic", jSONArray2);
        }
        return jSONObject;
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.aJX == null) {
                this.aJX = new c();
            }
            this.aJX.h(jSONObject.optJSONObject("recommend_new_user"));
            this.VM = jSONObject.optString("common_forum");
            this.VO = jSONObject.optInt("common_forum_count");
            this.VS = jSONObject.optString(AddFriendActivityConfig.DEFAULT_MESSAGE);
            JSONArray optJSONArray = jSONObject.optJSONArray("common_pic_urls");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (this.VR == null) {
                    this.VR = new ArrayList<>();
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (!TextUtils.isEmpty(optJSONArray.optString(i))) {
                        this.VR.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("large_post_pic");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                if (this.VT == null) {
                    this.VT = new ArrayList<>();
                }
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    if (!TextUtils.isEmpty(optJSONArray2.optString(i2))) {
                        this.VT.add(optJSONArray2.optString(i2));
                    }
                }
            }
        }
    }
}
