package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.lego.card.view.h;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.core.util.e.a, h, com.baidu.tieba.video.b {
    public static final BdUniqueId feO = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public int ekX;
    public String extra;
    public long feP;
    public List<String> feQ;
    public List<String> feR;
    public b feS;
    public c feT;
    public long feV;
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
    public boolean feU = true;
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
        public a ffd;
        public List<d> ffe;
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

    public AgreeData aaH() {
        return this.agreeData;
    }

    public long aak() {
        return this.agreeNum;
    }

    public long aal() {
        return this.feP;
    }

    public boolean beW() {
        return this.hasAgree;
    }

    public int aan() {
        return this.agreeType;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.feV;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.feV = j;
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
        if (this.feT != null) {
            return this.feT.videoUrl;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String TV;
        public long feW;
        public long feX;
        public String feY;
        public String feZ;
        public String ffa;
        public long ffb;
        public long ffc;

        public boolean isValid() {
            return (StringUtils.isNull(this.feZ) || StringUtils.isNull(this.TV)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.feW);
            sb.append(",   ad_end_time = " + this.feX);
            sb.append(",   pic_url = " + this.feY);
            sb.append(",   card_title = " + this.feZ);
            sb.append(",   button_title = " + this.ffa);
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
                this.feP = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.feP < 0) {
                    this.feP = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.feQ = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.feQ.add(jSONArray.optString(i));
                    }
                }
                this.feR = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.feR.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.feS = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.feS.userId = jSONObject2.optString("user_id");
                    this.feS.userName = jSONObject2.optString("user_name");
                    this.feS.userNickname = jSONObject2.optString("user_nickname");
                    this.feS.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.feS.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.feS.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.feT = new c();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.feT.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.feT.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.feT.videoMd5 = jSONObject3.optString("video_md5");
                    this.feT.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.feT.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.feT.videoWidth = jSONObject3.optString("video_width");
                    this.feT.videoHeight = jSONObject3.optString("video_height");
                    this.feT.videoSize = jSONObject3.optLong("video_size");
                    this.feT.videoType = jSONObject3.optString("video_type");
                    this.feT.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.feT.videoFormat = jSONObject3.optString("video_format");
                    this.feT.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.feT.originVideoUrl = jSONObject3.optString("origin_video_url");
                    this.feT.mcnLeadPage = jSONObject3.optString("mcn_lead_page");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.feT.ffe = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.feT.ffe.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject3.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.feW = optJSONObject.optLong("ad_start_time");
                        aVar.feX = optJSONObject.optLong("ad_end_time");
                        aVar.feY = optJSONObject.optString("pic_url");
                        aVar.TV = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.feZ = optJSONObject.optString("card_title");
                        aVar.ffa = optJSONObject.optString("button_title");
                        aVar.ffb = optJSONObject.optLong("effect_time");
                        aVar.ffc = optJSONObject.optLong("expire_time");
                        this.feT.ffd = aVar;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return feO;
    }
}
