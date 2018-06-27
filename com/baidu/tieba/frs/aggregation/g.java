package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.view.h {
    public static final BdUniqueId doB = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public boolean autoPlay;
    public String createTime;
    public List<String> doC;
    public List<String> doD;
    public a doE;
    public b doF;
    public String extra;
    public String firstPostId;
    public String forumId;
    public boolean hasAgree;
    public long playCount;
    public long postNum;
    public long shareNum;
    public String source;
    public String threadId;
    public String title;
    public boolean waitConfirm = false;
    public String weight;

    /* loaded from: classes3.dex */
    public static class a {
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public List<c> doG;
        public String originVideoUrl;
        public String thumbnailHeight;
        public String thumbnailPicid;
        public String thumbnailUrl;
        public String thumbnailWidth;
        public int videoDuration;
        public String videoFormat;
        public String videoHeight;
        public String videoMd5;
        public long videoSize;
        public String videoType;
        public String videoUrl;
        public String videoWidth;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public String videoHeight;
        public String videoId;
        public String videoUrl;
        public String videoWidth;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        this.waitConfirm = z;
    }

    public void parseJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.forumId = jSONObject.optString("forum_id");
                this.threadId = jSONObject.optString("thread_id");
                this.firstPostId = jSONObject.optString("first_post_id");
                this.createTime = jSONObject.optString("create_time");
                this.playCount = jSONObject.optLong("play_count");
                this.title = jSONObject.optString("title");
                this.postNum = jSONObject.optLong("post_num");
                this.agreeNum = jSONObject.optLong("agree_num");
                this.shareNum = jSONObject.optLong("share_num");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.doC = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.doC.add(jSONArray.optString(i));
                    }
                }
                this.doD = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.doD.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.doE = new a();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.doE.userId = jSONObject2.optString("user_id");
                    this.doE.userName = jSONObject2.optString("user_name");
                    this.doE.userNickname = jSONObject2.optString("user_nickname");
                    this.doE.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.doE.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.doE.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.doF = new b();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.doF.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.doF.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.doF.videoMd5 = jSONObject3.optString("video_md5");
                    this.doF.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.doF.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.doF.videoWidth = jSONObject3.optString("video_width");
                    this.doF.videoHeight = jSONObject3.optString("video_height");
                    this.doF.videoSize = jSONObject3.optLong("video_size");
                    this.doF.videoType = jSONObject3.optString("video_type");
                    this.doF.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.doF.videoFormat = jSONObject3.optString("video_format");
                    this.doF.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.doF.originVideoUrl = jSONObject3.optString("origin_video_url");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.doF.doG = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            c cVar = new c();
                            cVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            cVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            cVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            cVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.doF.doG.add(cVar);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doB;
    }
}
