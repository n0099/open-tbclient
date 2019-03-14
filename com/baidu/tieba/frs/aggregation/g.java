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
    public static final BdUniqueId feN = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public int ekT;
    public String extra;
    public long feO;
    public List<String> feP;
    public List<String> feQ;
    public b feR;
    public c feS;
    public long feU;
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
    public boolean feT = true;
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
        public a ffc;
        public List<d> ffd;
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
        return this.feO;
    }

    public boolean beW() {
        return this.hasAgree;
    }

    public int aan() {
        return this.agreeType;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.feU;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.feU = j;
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
        if (this.feS != null) {
            return this.feS.videoUrl;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String TW;
        public long feV;
        public long feW;
        public String feX;
        public String feY;
        public String feZ;
        public long ffa;
        public long ffb;

        public boolean isValid() {
            return (StringUtils.isNull(this.feY) || StringUtils.isNull(this.TW)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.feV);
            sb.append(",   ad_end_time = " + this.feW);
            sb.append(",   pic_url = " + this.feX);
            sb.append(",   card_title = " + this.feY);
            sb.append(",   button_title = " + this.feZ);
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
                this.feO = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.feO < 0) {
                    this.feO = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.feP = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.feP.add(jSONArray.optString(i));
                    }
                }
                this.feQ = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.feQ.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.feR = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.feR.userId = jSONObject2.optString("user_id");
                    this.feR.userName = jSONObject2.optString("user_name");
                    this.feR.userNickname = jSONObject2.optString("user_nickname");
                    this.feR.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.feR.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.feR.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.feS = new c();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.feS.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.feS.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.feS.videoMd5 = jSONObject3.optString("video_md5");
                    this.feS.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.feS.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.feS.videoWidth = jSONObject3.optString("video_width");
                    this.feS.videoHeight = jSONObject3.optString("video_height");
                    this.feS.videoSize = jSONObject3.optLong("video_size");
                    this.feS.videoType = jSONObject3.optString("video_type");
                    this.feS.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.feS.videoFormat = jSONObject3.optString("video_format");
                    this.feS.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.feS.originVideoUrl = jSONObject3.optString("origin_video_url");
                    this.feS.mcnLeadPage = jSONObject3.optString("mcn_lead_page");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.feS.ffd = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.feS.ffd.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject3.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.feV = optJSONObject.optLong("ad_start_time");
                        aVar.feW = optJSONObject.optLong("ad_end_time");
                        aVar.feX = optJSONObject.optString("pic_url");
                        aVar.TW = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.feY = optJSONObject.optString("card_title");
                        aVar.feZ = optJSONObject.optString("button_title");
                        aVar.ffa = optJSONObject.optLong("effect_time");
                        aVar.ffb = optJSONObject.optLong("expire_time");
                        this.feS.ffc = aVar;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return feN;
    }
}
