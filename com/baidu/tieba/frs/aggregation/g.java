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
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.core.util.e.a, com.baidu.tieba.lego.card.view.i, com.baidu.tieba.video.b {
    public static final BdUniqueId fzL = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public int eFr;
    public String extra;
    public String firstPostId;
    public String forumId;
    public long fzM;
    public List<String> fzN;
    public List<String> fzO;
    public b fzP;
    public c fzQ;
    public long fzS;
    public boolean hasAgree;
    public long playCount;
    public long postNum;
    public long shareNum;
    public String source;
    public String threadId;
    public String title;
    public String weight;
    public boolean fzR = true;
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
        public a fAa;
        public List<d> fAb;
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

    public AgreeData agn() {
        return this.agreeData;
    }

    public long afQ() {
        return this.agreeNum;
    }

    public long afR() {
        return this.fzM;
    }

    public boolean boq() {
        return this.hasAgree;
    }

    public int afT() {
        return this.agreeType;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.fzS;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.fzS = j;
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

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.fzQ != null) {
            return this.fzQ.videoUrl;
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String Sa;
        public long fzT;
        public long fzU;
        public String fzV;
        public String fzW;
        public String fzX;
        public long fzY;
        public long fzZ;

        public boolean isValid() {
            return (StringUtils.isNull(this.fzW) || StringUtils.isNull(this.Sa)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.fzT);
            sb.append(",   ad_end_time = " + this.fzU);
            sb.append(",   pic_url = " + this.fzV);
            sb.append(",   card_title = " + this.fzW);
            sb.append(",   button_title = " + this.fzX);
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
                this.fzM = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.fzM < 0) {
                    this.fzM = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.fzN = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.fzN.add(jSONArray.optString(i));
                    }
                }
                this.fzO = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.fzO.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.fzP = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.fzP.userId = jSONObject2.optString("user_id");
                    this.fzP.userName = jSONObject2.optString("user_name");
                    this.fzP.userNickname = jSONObject2.optString("user_nickname");
                    this.fzP.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.fzP.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.fzP.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.fzQ = new c();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.fzQ.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.fzQ.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.fzQ.videoMd5 = jSONObject3.optString("video_md5");
                    this.fzQ.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.fzQ.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.fzQ.videoWidth = jSONObject3.optString("video_width");
                    this.fzQ.videoHeight = jSONObject3.optString("video_height");
                    this.fzQ.videoSize = jSONObject3.optLong("video_size");
                    this.fzQ.videoType = jSONObject3.optString("video_type");
                    this.fzQ.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.fzQ.videoFormat = jSONObject3.optString("video_format");
                    this.fzQ.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.fzQ.originVideoUrl = jSONObject3.optString("origin_video_url");
                    this.fzQ.mcnLeadPage = jSONObject3.optString("mcn_lead_page");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.fzQ.fAb = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.fzQ.fAb.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject3.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.fzT = optJSONObject.optLong("ad_start_time");
                        aVar.fzU = optJSONObject.optLong("ad_end_time");
                        aVar.fzV = optJSONObject.optString("pic_url");
                        aVar.Sa = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.fzW = optJSONObject.optString("card_title");
                        aVar.fzX = optJSONObject.optString("button_title");
                        aVar.fzY = optJSONObject.optLong("effect_time");
                        aVar.fzZ = optJSONObject.optLong("expire_time");
                        this.fzQ.fAa = aVar;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fzL;
    }
}
