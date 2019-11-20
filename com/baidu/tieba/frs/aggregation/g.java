package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.core.util.g.a, com.baidu.tieba.lego.card.view.i, com.baidu.tieba.video.b {
    public static final BdUniqueId fAM = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public int eOW;
    public String extra;
    public long fAN;
    public List<String> fAO;
    public List<String> fAP;
    public b fAQ;
    public c fAR;
    public long fAT;
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
    public boolean fAS = true;
    public boolean waitConfirm = false;
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    public static class b {
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;
    }

    /* loaded from: classes.dex */
    public static class c {
        public a fBb;
        public List<d> fBc;
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
    public static class d {
        public String videoHeight;
        public String videoId;
        public String videoUrl;
        public String videoWidth;
    }

    public AgreeData akt() {
        return this.agreeData;
    }

    public long ajW() {
        return this.agreeNum;
    }

    public long ajX() {
        return this.fAN;
    }

    public boolean bmr() {
        return this.hasAgree;
    }

    public int ajZ() {
        return this.agreeType;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.fAT;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.fAT = j;
    }

    @Override // com.baidu.tieba.video.b
    public String getThreadId() {
        return this.threadId;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @Override // com.baidu.tieba.lego.card.view.i
    public void setWaitConfirm(boolean z) {
        this.waitConfirm = z;
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.fAR != null) {
            return this.fAR.videoUrl;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String AU;
        public long fAU;
        public long fAV;
        public String fAW;
        public String fAX;
        public String fAY;
        public long fAZ;
        public long fBa;

        public boolean isValid() {
            return (StringUtils.isNull(this.fAX) || StringUtils.isNull(this.AU)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.fAU);
            sb.append(",   ad_end_time = " + this.fAV);
            sb.append(",   pic_url = " + this.fAW);
            sb.append(",   card_title = " + this.fAX);
            sb.append(",   button_title = " + this.fAY);
            return sb.toString();
        }
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
                this.fAN = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.fAN < 0) {
                    this.fAN = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString(TableDefine.SessionColumns.COLUMN_WEIGHT);
                this.fAO = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.fAO.add(jSONArray.optString(i));
                    }
                }
                this.fAP = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.fAP.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.fAQ = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.fAQ.userId = jSONObject2.optString("user_id");
                    this.fAQ.userName = jSONObject2.optString("user_name");
                    this.fAQ.userNickname = jSONObject2.optString("user_nickname");
                    this.fAQ.portrait = jSONObject2.optString("portrait");
                    this.fAQ.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.fAQ.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.fAR = new c();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.fAR.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.fAR.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.fAR.videoMd5 = jSONObject3.optString("video_md5");
                    this.fAR.videoUrl = jSONObject3.optString("video_url");
                    this.fAR.videoDuration = jSONObject3.optInt("video_duration");
                    this.fAR.videoWidth = jSONObject3.optString("video_width");
                    this.fAR.videoHeight = jSONObject3.optString("video_height");
                    this.fAR.videoSize = jSONObject3.optLong("video_size");
                    this.fAR.videoType = jSONObject3.optString(LogConfig.LOG_VIDEO_TYPE);
                    this.fAR.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.fAR.videoFormat = jSONObject3.optString("video_format");
                    this.fAR.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.fAR.originVideoUrl = jSONObject3.optString("origin_video_url");
                    this.fAR.mcnLeadPage = jSONObject3.optString("mcn_lead_page");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.fAR.fBc = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString("video_url");
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.fAR.fBc.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject3.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.fAU = optJSONObject.optLong(SharedPrefConfig.AD_START_TIME);
                        aVar.fAV = optJSONObject.optLong(SharedPrefConfig.AD_END_TIME);
                        aVar.fAW = optJSONObject.optString("pic_url");
                        aVar.AU = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.fAX = optJSONObject.optString("card_title");
                        aVar.fAY = optJSONObject.optString("button_title");
                        aVar.fAZ = optJSONObject.optLong("effect_time");
                        aVar.fBa = optJSONObject.optLong("expire_time");
                        this.fAR.fBb = aVar;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fAM;
    }
}
