package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.card.data.b implements com.baidu.tbadk.core.util.e.a, com.baidu.tieba.lego.card.view.h, com.baidu.tieba.video.b {
    public static final BdUniqueId dFG = BdUniqueId.gen();
    public String abtest_tag;
    public long agreeNum;
    public int agreeType;
    public boolean autoPlay;
    public String createTime;
    public long dFH;
    public List<String> dFI;
    public List<String> dFJ;
    public a dFK;
    public b dFL;
    public long dFN;
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
    public String weight;
    public boolean dFM = true;
    public boolean waitConfirm = false;

    /* loaded from: classes.dex */
    public static class a {
        public boolean hasFocus;
        public boolean isBigV;
        public boolean isGod;
        public String portrait;
        public String userId;
        public String userName;
        public String userNickname;
    }

    /* loaded from: classes.dex */
    public static class b {
        public List<c> dFO;
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
    public static class c {
        public String videoHeight;
        public String videoId;
        public String videoUrl;
        public String videoWidth;
    }

    public long zH() {
        return this.agreeNum;
    }

    public long zI() {
        return this.dFH;
    }

    public boolean aBT() {
        return this.hasAgree;
    }

    public int zJ() {
        return this.hasAgree ? 1 : 0;
    }

    public void cu(int i) {
        this.hasAgree = i == 1;
    }

    public int zK() {
        return this.agreeType;
    }

    public void v(long j) {
        this.agreeNum = j;
    }

    public void w(long j) {
        this.dFH = j;
    }

    public void cw(int i) {
        this.agreeType = i;
    }

    @Override // com.baidu.tieba.video.b
    public long getVideoWatchDuration() {
        return this.dFN;
    }

    @Override // com.baidu.tieba.video.b
    public void setVideoWatchDuration(long j) {
        this.dFN = j;
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
        if (this.dFL != null) {
            return this.dFL.videoUrl;
        }
        return null;
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
                this.dFH = jSONObject.optLong("disagree_num");
                this.agreeType = jSONObject.optInt("agree_type");
                this.hasAgree = jSONObject.optInt("has_agree") == 1;
                if (this.agreeNum < 0) {
                    this.agreeNum = 0L;
                }
                if (this.dFH < 0) {
                    this.dFH = 0L;
                }
                this.source = jSONObject.optString("source");
                this.extra = jSONObject.optString("extra");
                this.abtest_tag = jSONObject.optString("abtest_tag");
                this.weight = jSONObject.optString("weight");
                this.dFI = new ArrayList();
                String optString = jSONObject.optString("forum_id_shared");
                if (!StringUtils.isNull(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.dFI.add(jSONArray.optString(i));
                    }
                }
                this.dFJ = new ArrayList();
                String optString2 = jSONObject.optString("forum_name_shared");
                if (!StringUtils.isNull(optString2)) {
                    JSONArray jSONArray2 = new JSONArray(optString2);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        this.dFJ.add(jSONArray2.optString(i2));
                    }
                }
                String optString3 = jSONObject.optString("author");
                if (!TextUtils.isEmpty(optString3)) {
                    this.dFK = new a();
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.dFK.userId = jSONObject2.optString("user_id");
                    this.dFK.userName = jSONObject2.optString("user_name");
                    this.dFK.userNickname = jSONObject2.optString("user_nickname");
                    this.dFK.portrait = jSONObject2.optString(IntentConfig.PORTRAIT);
                    this.dFK.hasFocus = jSONObject2.optInt("focus") == 1;
                    this.dFK.isGod = jSONObject2.optInt("is_god") == 1;
                }
                String optString4 = jSONObject.optString("video");
                if (!TextUtils.isEmpty(optString4)) {
                    this.dFL = new b();
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.dFL.thumbnailWidth = jSONObject3.optString("thumbnail_width");
                    this.dFL.thumbnailHeight = jSONObject3.optString("thumbnail_height");
                    this.dFL.videoMd5 = jSONObject3.optString("video_md5");
                    this.dFL.videoUrl = jSONObject3.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                    this.dFL.videoDuration = jSONObject3.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
                    this.dFL.videoWidth = jSONObject3.optString("video_width");
                    this.dFL.videoHeight = jSONObject3.optString("video_height");
                    this.dFL.videoSize = jSONObject3.optLong("video_size");
                    this.dFL.videoType = jSONObject3.optString("video_type");
                    this.dFL.thumbnailUrl = jSONObject3.optString("thumbnail_url");
                    this.dFL.videoFormat = jSONObject3.optString("video_format");
                    this.dFL.thumbnailPicid = jSONObject3.optString("thumbnail_picid");
                    this.dFL.originVideoUrl = jSONObject3.optString("origin_video_url");
                    String optString5 = jSONObject3.optString("video_desc");
                    if (!TextUtils.isEmpty(optString5)) {
                        this.dFL.dFO = new ArrayList();
                        JSONArray jSONArray3 = new JSONArray(optString5);
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            c cVar = new c();
                            cVar.videoId = jSONArray3.optJSONObject(i3).optString("video_id");
                            cVar.videoUrl = jSONArray3.optJSONObject(i3).optString(WebVideoActivityConfig.KEY_VIDEO_URL);
                            cVar.videoWidth = jSONArray3.optJSONObject(i3).optString("video_width");
                            cVar.videoHeight = jSONArray3.optJSONObject(i3).optString("video_height");
                            this.dFL.dFO.add(cVar);
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
        return dFG;
    }
}
