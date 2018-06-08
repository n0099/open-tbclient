package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.sina.weibo.sdk.constant.WBConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tieba.lego.card.view.h {
    public static final BdUniqueId dlP = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public boolean autoPlay;
    public String createTime;
    public List<String> dlQ;
    public List<String> dlR;
    public a dlS;
    public b dlT;
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
    public boolean waitConfirm = false;
    public String weight;

    /* loaded from: classes3.dex */
    public static class a {
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public List<c> dlU;
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

    /* loaded from: classes3.dex */
    public static class c {
        public String videoHeight;
        public String videoId;
        public String videoUrl;
        public String videoWidth;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @Override // com.baidu.tieba.lego.card.view.h
    public void setWaitConfirm(boolean z) {
        this.waitConfirm = z;
    }

    public void parseJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.forumId = jSONObject.optString("forum_id");
                this.threadId = jSONObject.optString("thread_id");
                this.firstPostId = jSONObject.optString("first_post_id");
                this.createTime = jSONObject.optString(WBConstants.GAME_PARAMS_GAME_CREATE_TIME);
                this.playCount = jSONObject.optLong("play_count");
                this.title = jSONObject.optString("title");
                this.postNum = jSONObject.optLong("post_num");
                this.agreeNum = jSONObject.optLong("agree_num");
                this.shareNum = jSONObject.optLong("share_num");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.dlQ = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.dlQ.add(jSONArray.optString(i));
                    }
                }
                this.dlR = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.dlR.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.dlS = new a();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.dlS.userId = jSONObject2.optString("user_id");
                    this.dlS.userName = jSONObject2.optString("user_name");
                    this.dlS.userNickname = jSONObject2.optString("user_nickname");
                    this.dlS.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.dlS.hasFocus = jSONObject2.optInt(AddFriendActivityConfig.TYPE_FOCUS) == 1;
                    this.dlS.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.dlT = new b();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.dlT.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.dlT.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.dlT.videoMd5 = jSONObject3.optString("video_md5");
                    this.dlT.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.dlT.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.dlT.videoWidth = jSONObject3.optString("video_width");
                    this.dlT.videoHeight = jSONObject3.optString("video_height");
                    this.dlT.videoSize = jSONObject3.optLong("video_size");
                    this.dlT.videoType = jSONObject3.optString("video_type");
                    this.dlT.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.dlT.videoFormat = jSONObject3.optString("video_format");
                    this.dlT.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.dlT.originVideoUrl = jSONObject3.optString("origin_video_url");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.dlT.dlU = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            c cVar = new c();
                            cVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            cVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            cVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            cVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.dlT.dlU.add(cVar);
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
        return dlP;
    }
}
