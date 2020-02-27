package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
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
    public static final BdUniqueId gus = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public String extra;
    public int fMr;
    public String firstPostId;
    public String forumId;
    public long gut;
    public List<String> guu;
    public List<String> guv;
    public b guw;
    public c gux;
    public long guz;
    public boolean hasAgree;
    public BaijiahaoData mBaijiahao;
    public long playCount;
    public long postNum;
    public long shareNum;
    public String source;
    public String threadId;
    public String title;
    public String weight;
    public boolean guy = true;
    public boolean waitConfirm = false;
    public boolean isTitleExpanded = false;
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    public static class b {
        public a guH;
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
        public a guI;
        public List<d> guJ;
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

    public AgreeData aDY() {
        return this.agreeData;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.guz;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.guz = j;
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
        if (this.gux != null) {
            return this.gux.videoUrl;
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
        public String DZ;
        public long guA;
        public long guB;
        public String guC;
        public String guD;
        public String guE;
        public long guF;
        public long guG;

        public boolean isValid() {
            return (StringUtils.isNull(this.guD) || StringUtils.isNull(this.DZ)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.guA);
            sb.append(",   ad_end_time = " + this.guB);
            sb.append(",   pic_url = " + this.guC);
            sb.append(",   card_title = " + this.guD);
            sb.append(",   button_title = " + this.guE);
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
                this.gut = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.gut < 0) {
                    this.gut = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.agreeNum = this.agreeNum;
                this.agreeData.disAgreeNum = this.gut;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString(TableDefine.SessionColumns.COLUMN_WEIGHT);
                this.guu = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.guu.add(jSONArray.optString(i));
                    }
                }
                this.guv = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.guv.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.guw = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.guw.userId = jSONObject2.optString("user_id");
                    this.guw.userName = jSONObject2.optString("user_name");
                    this.guw.userNickname = jSONObject2.optString("user_nickname");
                    this.guw.portrait = jSONObject2.optString("portrait");
                    this.guw.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.guw.isGod = jSONObject2.optInt("is_god") == 1;
                    String optString4 = jSONObject2.optString("baijiahao_info");
                    if (!TextUtils.isEmpty(optString4)) {
                        JSONObject jSONObject3 = new JSONObject(optString4);
                        this.guw.guH = new b.a();
                        this.guw.guH.name = jSONObject3.optString("name");
                        this.guw.guH.brief = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                        this.guw.guH.avatar = jSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                        this.guw.guH.avatar_h = jSONObject3.optString("avatar_h");
                        this.guw.guH.auth_id = Integer.valueOf(jSONObject3.optInt("auth_id"));
                        this.guw.guH.auth_desc = jSONObject3.optString("auth_desc");
                    }
                }
                String optString5 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString5)) {
                    this.gux = new c();
                    JSONObject jSONObject4 = new JSONObject(optString5);
                    this.gux.thumbnailWidth = jSONObject4.optString("thumbnail_width");
                    this.gux.thumbnailHeight = jSONObject4.optString("thumbnail_height");
                    this.gux.videoMd5 = jSONObject4.optString("video_md5");
                    this.gux.videoUrl = jSONObject4.optString("video_url");
                    this.gux.videoDuration = jSONObject4.optInt("video_duration");
                    this.gux.videoWidth = jSONObject4.optString("video_width");
                    this.gux.videoHeight = jSONObject4.optString("video_height");
                    this.gux.videoSize = jSONObject4.optLong("video_size");
                    this.gux.videoType = jSONObject4.optString(LogConfig.LOG_VIDEO_TYPE);
                    this.gux.thumbnailUrl = jSONObject4.optString("thumbnail_url");
                    this.gux.videoFormat = jSONObject4.optString("video_format");
                    this.gux.thumbnailPicid = jSONObject4.optString("thumbnail_picid");
                    this.gux.originVideoUrl = jSONObject4.optString("origin_video_url");
                    this.gux.mcnLeadPage = jSONObject4.optString("mcn_lead_page");
                    String optString6 = jSONObject4.optString("video_desc");
                    if (!TextUtils.isEmpty(optString6)) {
                        this.gux.guJ = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString6);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString("video_url");
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.gux.guJ.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.guA = optJSONObject.optLong(SharedPrefConfig.AD_START_TIME);
                        aVar.guB = optJSONObject.optLong(SharedPrefConfig.AD_END_TIME);
                        aVar.guC = optJSONObject.optString("pic_url");
                        aVar.DZ = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.guD = optJSONObject.optString("card_title");
                        aVar.guE = optJSONObject.optString("button_title");
                        aVar.guF = optJSONObject.optLong("effect_time");
                        aVar.guG = optJSONObject.optLong("expire_time");
                        this.gux.guI = aVar;
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
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
        return gus;
    }
}
