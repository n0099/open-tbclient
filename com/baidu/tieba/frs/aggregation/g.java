package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.core.util.e.a, com.baidu.tieba.lego.card.view.h, com.baidu.tieba.video.b {
    public static final BdUniqueId dGV = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public long dGW;
    public List<String> dGX;
    public List<String> dGY;
    public a dGZ;
    public b dHa;
    public long dHc;
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
    public String weight;
    public boolean dHb = true;
    public boolean waitConfirm = false;

    /* loaded from: classes.dex */
    public static class a {
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;
    }

    /* loaded from: classes.dex */
    public static class b {
        public List<c> dHd;
        public String mcnLeadPage;
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

    /* loaded from: classes.dex */
    public static class c {
        public String videoHeight;
        public String videoId;
        public String videoUrl;
        public String videoWidth;
    }

    public long zO() {
        return this.agreeNum;
    }

    public long zP() {
        return this.dGW;
    }

    public boolean aBr() {
        return this.hasAgree;
    }

    public int zQ() {
        return this.hasAgree ? 1 : 0;
    }

    public void cI(int i) {
        this.hasAgree = i == 1;
    }

    public int zR() {
        return this.agreeType;
    }

    public void x(long j) {
        this.agreeNum = j;
    }

    public void y(long j) {
        this.dGW = j;
    }

    public void cK(int i) {
        this.agreeType = i;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.dHc;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.dHc = j;
    }

    @Override // com.baidu.tieba.video.b
    public String getThreadId() {
        return this.threadId;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        this.waitConfirm = z;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.dHa != null) {
            return this.dHa.videoUrl;
        }
        return null;
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
                this.shareNum = jSONObject.optLong("share_num");
                this.agreeNum = jSONObject.optLong("agree_num");
                this.dGW = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.dGW < 0) {
                    this.dGW = 0L;
                }
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.dGX = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.dGX.add(jSONArray.optString(i));
                    }
                }
                this.dGY = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.dGY.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.dGZ = new a();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.dGZ.userId = jSONObject2.optString("user_id");
                    this.dGZ.userName = jSONObject2.optString("user_name");
                    this.dGZ.userNickname = jSONObject2.optString("user_nickname");
                    this.dGZ.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.dGZ.hasFocus = jSONObject2.optInt("focus") == 1;
                    this.dGZ.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.dHa = new b();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.dHa.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.dHa.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.dHa.videoMd5 = jSONObject3.optString("video_md5");
                    this.dHa.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.dHa.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.dHa.videoWidth = jSONObject3.optString("video_width");
                    this.dHa.videoHeight = jSONObject3.optString("video_height");
                    this.dHa.videoSize = jSONObject3.optLong("video_size");
                    this.dHa.videoType = jSONObject3.optString("video_type");
                    this.dHa.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.dHa.videoFormat = jSONObject3.optString("video_format");
                    this.dHa.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.dHa.originVideoUrl = jSONObject3.optString("origin_video_url");
                    this.dHa.mcnLeadPage = jSONObject3.optString("mcn_lead_page");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.dHa.dHd = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            c cVar = new c();
                            cVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            cVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            cVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            cVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.dHa.dHd.add(cVar);
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
        return dGV;
    }
}
