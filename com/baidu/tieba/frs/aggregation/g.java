package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.core.util.e.a, com.baidu.tieba.lego.card.view.h, com.baidu.tieba.video.b {
    public static final BdUniqueId feA = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public int ekF;
    public String extra;
    public long feB;
    public List<String> feC;
    public List<String> feD;
    public b feE;
    public c feF;
    public long feH;
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
    public boolean feG = true;
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
        public a feP;
        public List<d> feQ;
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

    public AgreeData aaE() {
        return this.agreeData;
    }

    public long aah() {
        return this.agreeNum;
    }

    public long aai() {
        return this.feB;
    }

    public boolean beU() {
        return this.hasAgree;
    }

    public int aak() {
        return this.agreeType;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.feH;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.feH = j;
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
        if (this.feF != null) {
            return this.feF.videoUrl;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String TW;
        public long feI;
        public long feJ;
        public String feK;
        public String feL;
        public String feM;
        public long feN;
        public long feO;

        public boolean isValid() {
            return (StringUtils.isNull(this.feL) || StringUtils.isNull(this.TW)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.feI);
            sb.append(",   ad_end_time = " + this.feJ);
            sb.append(",   pic_url = " + this.feK);
            sb.append(",   card_title = " + this.feL);
            sb.append(",   button_title = " + this.feM);
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
                this.feB = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.feB < 0) {
                    this.feB = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.feC = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.feC.add(jSONArray.optString(i));
                    }
                }
                this.feD = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.feD.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.feE = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.feE.userId = jSONObject2.optString("user_id");
                    this.feE.userName = jSONObject2.optString("user_name");
                    this.feE.userNickname = jSONObject2.optString("user_nickname");
                    this.feE.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.feE.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.feE.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.feF = new c();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.feF.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.feF.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.feF.videoMd5 = jSONObject3.optString("video_md5");
                    this.feF.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.feF.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.feF.videoWidth = jSONObject3.optString("video_width");
                    this.feF.videoHeight = jSONObject3.optString("video_height");
                    this.feF.videoSize = jSONObject3.optLong("video_size");
                    this.feF.videoType = jSONObject3.optString("video_type");
                    this.feF.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.feF.videoFormat = jSONObject3.optString("video_format");
                    this.feF.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.feF.originVideoUrl = jSONObject3.optString("origin_video_url");
                    this.feF.mcnLeadPage = jSONObject3.optString("mcn_lead_page");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.feF.feQ = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.feF.feQ.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject3.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.feI = optJSONObject.optLong("ad_start_time");
                        aVar.feJ = optJSONObject.optLong("ad_end_time");
                        aVar.feK = optJSONObject.optString("pic_url");
                        aVar.TW = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.feL = optJSONObject.optString("card_title");
                        aVar.feM = optJSONObject.optString("button_title");
                        aVar.feN = optJSONObject.optLong("effect_time");
                        aVar.feO = optJSONObject.optLong("expire_time");
                        this.feF.feP = aVar;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return feA;
    }
}
