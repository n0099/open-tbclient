package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends BaseCardInfo implements com.baidu.tbadk.core.util.g.a, com.baidu.tieba.lego.card.view.i {
    public static final BdUniqueId job = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public bx eRo;
    public String extra;
    public String firstPostId;
    public String forumId;
    public boolean hasAgree;
    public int iAs;
    public long joc;
    public List<String> jod;
    public List<String> joe;
    public b jof;
    public c jog;
    public long lastReplyTime;
    public BaijiahaoData mBaijiahao;
    public String nid;
    public String objSource;
    public long playCount;
    public long postNum;
    public long shareNum;
    public String source;
    public String threadId;
    public String title;
    public String weight;
    public List<p> postList = new ArrayList();
    public boolean joh = true;
    public boolean waitConfirm = false;
    public boolean isTitleExpanded = false;
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    public static class b {
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public a jop;
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
        public a joq;
        public List<d> jor;
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

    public AgreeData bpJ() {
        return this.agreeData;
    }

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
        if (this.jog != null) {
            return this.jog.videoUrl;
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
        public String aaY;
        public long joi;
        public long joj;
        public String jok;
        public String jol;
        public String jom;
        public long jon;
        public long joo;

        public boolean isValid() {
            return (StringUtils.isNull(this.jol) || StringUtils.isNull(this.aaY)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.joi);
            sb.append(",   ad_end_time = " + this.joj);
            sb.append(",   pic_url = " + this.jok);
            sb.append(",   card_title = " + this.jol);
            sb.append(",   button_title = " + this.jom);
            return sb.toString();
        }
    }

    public void parseJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.forumId = jSONObject.optString("forum_id");
                this.threadId = jSONObject.optString("thread_id");
                this.nid = jSONObject.optString(IntentConfig.NID);
                this.firstPostId = jSONObject.optString("first_post_id");
                this.createTime = jSONObject.optString("create_time");
                this.playCount = jSONObject.optLong("play_count");
                this.title = jSONObject.optString("title");
                this.postNum = jSONObject.optLong("post_num");
                this.shareNum = jSONObject.optLong("share_num");
                this.agreeNum = jSONObject.optLong("agree_num");
                this.joc = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.joc < 0) {
                    this.joc = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.agreeNum = this.agreeNum;
                this.agreeData.disAgreeNum = this.joc;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.jod = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.jod.add(jSONArray.optString(i));
                    }
                }
                this.joe = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.joe.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.jof = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.jof.userId = jSONObject2.optString("user_id");
                    this.jof.userName = jSONObject2.optString("user_name");
                    this.jof.userNickname = jSONObject2.optString("user_nickname");
                    this.jof.portrait = jSONObject2.optString("portrait");
                    this.jof.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.jof.isGod = jSONObject2.optInt("is_god") == 1;
                    String optString4 = jSONObject2.optString("baijiahao_info");
                    if (!TextUtils.isEmpty(optString4)) {
                        JSONObject jSONObject3 = new JSONObject(optString4);
                        this.jof.jop = new b.a();
                        this.jof.jop.name = jSONObject3.optString("name");
                        this.jof.jop.brief = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                        this.jof.jop.avatar = jSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                        this.jof.jop.avatar_h = jSONObject3.optString("avatar_h");
                        this.jof.jop.auth_id = Integer.valueOf(jSONObject3.optInt("auth_id"));
                        this.jof.jop.auth_desc = jSONObject3.optString("auth_desc");
                    }
                }
                String optString5 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString5)) {
                    this.jog = new c();
                    JSONObject jSONObject4 = new JSONObject(optString5);
                    this.jog.thumbnailWidth = jSONObject4.optString("thumbnail_width");
                    this.jog.thumbnailHeight = jSONObject4.optString("thumbnail_height");
                    this.jog.videoMd5 = jSONObject4.optString("video_md5");
                    this.jog.videoUrl = jSONObject4.optString("video_url");
                    this.jog.videoDuration = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.jog.videoWidth = jSONObject4.optString("video_width");
                    this.jog.videoHeight = jSONObject4.optString("video_height");
                    this.jog.videoSize = jSONObject4.optLong("video_size");
                    this.jog.videoType = jSONObject4.optString(LogConfig.LOG_VIDEO_TYPE);
                    this.jog.thumbnailUrl = jSONObject4.optString("thumbnail_url");
                    this.jog.videoFormat = jSONObject4.optString("video_format");
                    this.jog.thumbnailPicid = jSONObject4.optString("thumbnail_picid");
                    this.jog.originVideoUrl = jSONObject4.optString("origin_video_url");
                    this.jog.mcnLeadPage = jSONObject4.optString("mcn_lead_page");
                    String optString6 = jSONObject4.optString("video_desc");
                    if (!TextUtils.isEmpty(optString6)) {
                        this.jog.jor = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString6);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString("video_url");
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.jog.jor.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.joi = optJSONObject.optLong(SharedPrefConfig.AD_START_TIME);
                        aVar.joj = optJSONObject.optLong(SharedPrefConfig.AD_END_TIME);
                        aVar.jok = optJSONObject.optString("pic_url");
                        aVar.aaY = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.jol = optJSONObject.optString("card_title");
                        aVar.jom = optJSONObject.optString("button_title");
                        aVar.jon = optJSONObject.optLong("effect_time");
                        aVar.joo = optJSONObject.optLong("expire_time");
                        this.jog.joq = aVar;
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject2 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("forum_info");
                if (optJSONObject3 != null) {
                    this.eRo = new bx();
                    this.eRo.parserJson(optJSONObject3);
                }
                this.lastReplyTime = jSONObject.optLong("last_time_int");
                JSONArray optJSONArray = jSONObject.optJSONArray("post_list");
                if (optJSONArray != null) {
                    this.postList = new ArrayList();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        p pVar = new p();
                        pVar.parseJson(optJSONArray.getJSONObject(i4));
                        this.postList.add(pVar);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean cFC() {
        if (this.jog == null) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(this.jog.videoWidth);
            return parseInt > 0 && ((float) Integer.parseInt(this.jog.videoHeight)) / ((float) parseInt) > 1.0f;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return job;
    }

    public static cb f(g gVar) {
        if (gVar == null) {
            return null;
        }
        cb cbVar = new cb();
        cbVar.setId(gVar.threadId);
        cbVar.tid = gVar.threadId;
        cbVar.setTitle(gVar.title);
        cbVar.Al(gVar.title);
        try {
            cbVar.nk((int) gVar.postNum);
        } catch (Exception e) {
            BdLog.e(e);
        }
        cbVar.dP(gVar.shareNum);
        cbVar.setBaijiahaoData(gVar.mBaijiahao);
        if (cbVar.bpJ() != null && gVar.agreeData != null) {
            cbVar.bpJ().threadId = gVar.threadId;
            cbVar.bpJ().agreeType = gVar.agreeType;
            cbVar.bpJ().hasAgree = gVar.hasAgree;
            cbVar.bpJ().agreeNum = gVar.agreeNum;
            cbVar.bpJ().baijiahaoData = gVar.mBaijiahao;
        }
        cbVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        cbVar.setThreadType(40);
        return cbVar;
    }
}
