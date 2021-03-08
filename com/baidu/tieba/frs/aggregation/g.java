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
    public static final BdUniqueId jpK = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public bx eSP;
    public String extra;
    public String firstPostId;
    public String forumId;
    public boolean hasAgree;
    public int iCb;
    public long jpL;
    public List<String> jpM;
    public List<String> jpN;
    public b jpO;
    public c jpP;
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
    public boolean jpQ = true;
    public boolean waitConfirm = false;
    public boolean isTitleExpanded = false;
    private AgreeData agreeData = new AgreeData();

    /* loaded from: classes.dex */
    public static class b {
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public a jpY;
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
        public a jpZ;
        public List<d> jqa;
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

    public AgreeData bpL() {
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
        if (this.jpP != null) {
            return this.jpP.videoUrl;
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
        public String acv;
        public long jpR;
        public long jpS;
        public String jpT;
        public String jpU;
        public String jpV;
        public long jpW;
        public long jpX;

        public boolean isValid() {
            return (StringUtils.isNull(this.jpU) || StringUtils.isNull(this.acv)) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("startTime = " + this.jpR);
            sb.append(",   ad_end_time = " + this.jpS);
            sb.append(",   pic_url = " + this.jpT);
            sb.append(",   card_title = " + this.jpU);
            sb.append(",   button_title = " + this.jpV);
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
                this.jpL = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.jpL < 0) {
                    this.jpL = 0L;
                }
                this.agreeData.threadId = this.threadId;
                this.agreeData.agreeType = this.agreeType;
                this.agreeData.hasAgree = this.hasAgree;
                this.agreeData.agreeNum = this.agreeNum;
                this.agreeData.disAgreeNum = this.jpL;
                this.agreeData.diffAgreeNum = jSONObject.optLong("diff_agree_num", 0L);
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.jpM = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.jpM.add(jSONArray.optString(i));
                    }
                }
                this.jpN = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.jpN.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.jpO = new b();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.jpO.userId = jSONObject2.optString("user_id");
                    this.jpO.userName = jSONObject2.optString("user_name");
                    this.jpO.userNickname = jSONObject2.optString("user_nickname");
                    this.jpO.portrait = jSONObject2.optString("portrait");
                    this.jpO.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.jpO.isGod = jSONObject2.optInt("is_god") == 1;
                    String optString4 = jSONObject2.optString("baijiahao_info");
                    if (!TextUtils.isEmpty(optString4)) {
                        JSONObject jSONObject3 = new JSONObject(optString4);
                        this.jpO.jpY = new b.a();
                        this.jpO.jpY.name = jSONObject3.optString("name");
                        this.jpO.jpY.brief = jSONObject3.optString(DBTableDefine.GroupInfoColumns.COLUMN_BRIEF);
                        this.jpO.jpY.avatar = jSONObject3.optString(TableDefine.PaSubscribeColumns.COLUMN_AVATAR);
                        this.jpO.jpY.avatar_h = jSONObject3.optString("avatar_h");
                        this.jpO.jpY.auth_id = Integer.valueOf(jSONObject3.optInt("auth_id"));
                        this.jpO.jpY.auth_desc = jSONObject3.optString("auth_desc");
                    }
                }
                String optString5 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString5)) {
                    this.jpP = new c();
                    JSONObject jSONObject4 = new JSONObject(optString5);
                    this.jpP.thumbnailWidth = jSONObject4.optString("thumbnail_width");
                    this.jpP.thumbnailHeight = jSONObject4.optString("thumbnail_height");
                    this.jpP.videoMd5 = jSONObject4.optString("video_md5");
                    this.jpP.videoUrl = jSONObject4.optString("video_url");
                    this.jpP.videoDuration = jSONObject4.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.jpP.videoWidth = jSONObject4.optString("video_width");
                    this.jpP.videoHeight = jSONObject4.optString("video_height");
                    this.jpP.videoSize = jSONObject4.optLong("video_size");
                    this.jpP.videoType = jSONObject4.optString(LogConfig.LOG_VIDEO_TYPE);
                    this.jpP.thumbnailUrl = jSONObject4.optString("thumbnail_url");
                    this.jpP.videoFormat = jSONObject4.optString("video_format");
                    this.jpP.thumbnailPicid = jSONObject4.optString("thumbnail_picid");
                    this.jpP.originVideoUrl = jSONObject4.optString("origin_video_url");
                    this.jpP.mcnLeadPage = jSONObject4.optString("mcn_lead_page");
                    String optString6 = jSONObject4.optString("video_desc");
                    if (!TextUtils.isEmpty(optString6)) {
                        this.jpP.jqa = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString6);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            d dVar = new d();
                            dVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            dVar.videoUrl = jSONArray3.optJSONObject(i3).optString("video_url");
                            dVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            dVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.jpP.jqa.add(dVar);
                        }
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("mcn_ad_card");
                    if (optJSONObject != null) {
                        a aVar = new a();
                        aVar.jpR = optJSONObject.optLong(SharedPrefConfig.AD_START_TIME);
                        aVar.jpS = optJSONObject.optLong(SharedPrefConfig.AD_END_TIME);
                        aVar.jpT = optJSONObject.optString("pic_url");
                        aVar.acv = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        aVar.jpU = optJSONObject.optString("card_title");
                        aVar.jpV = optJSONObject.optString("button_title");
                        aVar.jpW = optJSONObject.optLong("effect_time");
                        aVar.jpX = optJSONObject.optLong("expire_time");
                        this.jpP.jpZ = aVar;
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PAGE_BAIJIAHAO_NAME);
                if (optJSONObject2 != null) {
                    this.mBaijiahao = new BaijiahaoData();
                    this.mBaijiahao.parseJson(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("forum_info");
                if (optJSONObject3 != null) {
                    this.eSP = new bx();
                    this.eSP.parserJson(optJSONObject3);
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

    public boolean cFI() {
        if (this.jpP == null) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(this.jpP.videoWidth);
            return parseInt > 0 && ((float) Integer.parseInt(this.jpP.videoHeight)) / ((float) parseInt) > 1.0f;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jpK;
    }

    public static cb f(g gVar) {
        if (gVar == null) {
            return null;
        }
        cb cbVar = new cb();
        cbVar.setId(gVar.threadId);
        cbVar.tid = gVar.threadId;
        cbVar.setTitle(gVar.title);
        cbVar.As(gVar.title);
        try {
            cbVar.nl((int) gVar.postNum);
        } catch (Exception e) {
            BdLog.e(e);
        }
        cbVar.dP(gVar.shareNum);
        cbVar.setBaijiahaoData(gVar.mBaijiahao);
        if (cbVar.bpL() != null && gVar.agreeData != null) {
            cbVar.bpL().threadId = gVar.threadId;
            cbVar.bpL().agreeType = gVar.agreeType;
            cbVar.bpL().hasAgree = gVar.hasAgree;
            cbVar.bpL().agreeNum = gVar.agreeNum;
            cbVar.bpL().baijiahaoData = gVar.mBaijiahao;
        }
        cbVar.setFid(com.baidu.adp.lib.f.b.toLong(gVar.forumId, 0L));
        cbVar.setThreadType(40);
        return cbVar;
    }
}
