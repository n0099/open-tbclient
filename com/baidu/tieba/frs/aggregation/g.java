package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.core.util.g.a, com.baidu.tieba.lego.card.view.i, com.baidu.tieba.video.b {
    public static final BdUniqueId gsr = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public String extra;
    public int fJU;
    public String firstPostId;
    public String forumId;
    public long gss;
    public List<String> gst;
    public List<String> gsu;
    public b gsv;
    public c gsw;
    public long gsy;
    public boolean hasAgree;
    public BaijiahaoData mBaijiahao;
    public long playCount;
    public long postNum;
    public long shareNum;
    public String source;
    public String threadId;
    public String title;
    public String weight;
    public boolean gsx = true;
    public boolean waitConfirm = false;
    public boolean isTitleExpanded = false;
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    public static class b {
        public a gsG;
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;

        /* loaded from: classes.dex */
        public static class a {
            public String auth_desc;
            public Integer auth_id;
            public String avatar;
            public String avatar_h;
            public String brief;
            public String name;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public a gsH;
        public List<d> gsI;
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

    public AgreeData aBM() {
        return this.agreeData;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.gsy;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.gsy = j;
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
        if (this.gsw != null) {
            return this.gsw.videoUrl;
        }
        return null;
    }

    public int getVideoType() {
        if (this.mBaijiahao == null) {
            return 1;
        }
        if (this.mBaijiahao.oriUgcType == 2) {
            return 3;
        }
        return this.mBaijiahao.oriUgcType == 4 ? 2 : 1;
    }

    /* loaded from: classes.dex */
    public static class a {
        public String DD;
        public long gsA;
        public String gsB;
        public String gsC;
        public String gsD;
        public long gsE;
        public long gsF;
        public long gsz;

        public boolean isValid() {
            return (StringUtils.isNull(this.gsC) || StringUtils.isNull(this.DD)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.gsz);
            sb.append(",   ad_end_time = " + this.gsA);
            sb.append(",   pic_url = " + this.gsB);
            sb.append(",   card_title = " + this.gsC);
            sb.append(",   button_title = " + this.gsD);
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
                this.gss = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.gss < 0) {
                    this.gss = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.agreeNum = this.agreeNum;
                this.agreeData.disAgreeNum = this.gss;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString(TableDefine.SessionColumns.COLUMN_WEIGHT);
                this.gst = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.gst.add(jSONArray.optString(i));
                    }
                }
                this.gsu = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.gsu.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.gsv = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.gsv.userId = jSONObject2.optString("user_id");
                    this.gsv.userName = jSONObject2.optString("user_name");
                    this.gsv.userNickname = jSONObject2.optString("user_nickname");
                    this.gsv.portrait = jSONObject2.optString("portrait");
                    this.gsv.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.gsv.isGod = jSONObject2.optInt("is_god") == 1;
                    String optString4 = jSONObject2.optString("baijiahao_info");
                    if (!TextUtils.isEmpty(optString4)) {
                        JSONObject jSONObject3 = new JSONObject(optString4);
                        this.gsv.gsG = new b.a();
                        this.gsv.gsG.name = jSONObject3.optString("name");
                        this.gsv.gsG.brief = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                        this.gsv.gsG.avatar = jSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                        this.gsv.gsG.avatar_h = jSONObject3.optString("avatar_h");
                        this.gsv.gsG.auth_id = Integer.valueOf(jSONObject3.optInt("auth_id"));
                        this.gsv.gsG.auth_desc = jSONObject3.optString("auth_desc");
                    }
                }
                String optString5 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString5)) {
                    this.gsw = new c();
                    JSONObject jSONObject4 = new JSONObject(optString5);
                    this.gsw.thumbnailWidth = jSONObject4.optString("thumbnail_width");
                    this.gsw.thumbnailHeight = jSONObject4.optString("thumbnail_height");
                    this.gsw.videoMd5 = jSONObject4.optString("video_md5");
                    this.gsw.videoUrl = jSONObject4.optString("video_url");
                    this.gsw.videoDuration = jSONObject4.optInt("video_duration");
                    this.gsw.videoWidth = jSONObject4.optString("video_width");
                    this.gsw.videoHeight = jSONObject4.optString("video_height");
                    this.gsw.videoSize = jSONObject4.optLong("video_size");
                    this.gsw.videoType = jSONObject4.optString(LogConfig.LOG_VIDEO_TYPE);
                    this.gsw.thumbnailUrl = jSONObject4.optString("thumbnail_url");
                    this.gsw.videoFormat = jSONObject4.optString("video_format");
                    this.gsw.thumbnailPicid = jSONObject4.optString("thumbnail_picid");
                    this.gsw.originVideoUrl = jSONObject4.optString("origin_video_url");
                    this.gsw.mcnLeadPage = jSONObject4.optString("mcn_lead_page");
                    String optString6 = jSONObject4.optString("video_desc");
                    if (!TextUtils.isEmpty(optString6)) {
                        this.gsw.gsI = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString6);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString("video_url");
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.gsw.gsI.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.gsz = optJSONObject.optLong(SharedPrefConfig.AD_START_TIME);
                        aVar.gsA = optJSONObject.optLong(SharedPrefConfig.AD_END_TIME);
                        aVar.gsB = optJSONObject.optString("pic_url");
                        aVar.DD = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.gsC = optJSONObject.optString("card_title");
                        aVar.gsD = optJSONObject.optString("button_title");
                        aVar.gsE = optJSONObject.optLong("effect_time");
                        aVar.gsF = optJSONObject.optLong("expire_time");
                        this.gsw.gsH = aVar;
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("baijiahao");
                if (optJSONObject2 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gsr;
    }
}
