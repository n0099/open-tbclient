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
    public static final BdUniqueId dQS = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public long dQT;
    public List<String> dQU;
    public List<String> dQV;
    public a dQW;
    public b dQX;
    public long dQZ;
    public int dbl;
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
    public boolean dQY = true;
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
        public List<c> dRa;
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

    public long Bf() {
        return this.agreeNum;
    }

    public long Bg() {
        return this.dQT;
    }

    public boolean aEn() {
        return this.hasAgree;
    }

    public int Bh() {
        return this.hasAgree ? 1 : 0;
    }

    public void cW(int i) {
        this.hasAgree = i == 1;
    }

    public int Bi() {
        return this.agreeType;
    }

    public void C(long j) {
        this.agreeNum = j;
    }

    public void D(long j) {
        this.dQT = j;
    }

    public void cY(int i) {
        this.agreeType = i;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.dQZ;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.dQZ = j;
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
        if (this.dQX != null) {
            return this.dQX.videoUrl;
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
                this.dQT = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.dQT < 0) {
                    this.dQT = 0L;
                }
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.dQU = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.dQU.add(jSONArray.optString(i));
                    }
                }
                this.dQV = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.dQV.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.dQW = new a();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.dQW.userId = jSONObject2.optString("user_id");
                    this.dQW.userName = jSONObject2.optString("user_name");
                    this.dQW.userNickname = jSONObject2.optString("user_nickname");
                    this.dQW.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.dQW.hasFocus = jSONObject2.optInt("focus") == 1;
                    this.dQW.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.dQX = new b();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.dQX.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.dQX.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.dQX.videoMd5 = jSONObject3.optString("video_md5");
                    this.dQX.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.dQX.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.dQX.videoWidth = jSONObject3.optString("video_width");
                    this.dQX.videoHeight = jSONObject3.optString("video_height");
                    this.dQX.videoSize = jSONObject3.optLong("video_size");
                    this.dQX.videoType = jSONObject3.optString("video_type");
                    this.dQX.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.dQX.videoFormat = jSONObject3.optString("video_format");
                    this.dQX.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.dQX.originVideoUrl = jSONObject3.optString("origin_video_url");
                    this.dQX.mcnLeadPage = jSONObject3.optString("mcn_lead_page");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.dQX.dRa = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            c cVar = new c();
                            cVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            cVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            cVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            cVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.dQX.dRa.add(cVar);
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
        return dQS;
    }
}
