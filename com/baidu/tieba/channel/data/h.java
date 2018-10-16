package com.baidu.tieba.channel.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.channel.config.a;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.List;
import org.json.JSONObject;
import tbclient.ChannelVideoInfo;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    private int bnr;
    private int cSY;
    private long cSZ;
    private int cTa;
    private int cTb;
    private int cTc;
    private String cTd;
    private int cTe;
    private long createTime;
    private int forumId;
    private String forumName;
    private BdUniqueId mType;
    private long threadId;
    private String thumbnailUrl;
    private String title;
    private int videoDuration;
    private int videoHeight;
    private String videoUrl;
    private int videoWidth;

    public long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public void setForumId(int i) {
        this.forumId = i;
    }

    public String getForumName() {
        return this.forumName;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int apf() {
        return this.bnr;
    }

    public void kb(int i) {
        this.bnr = i;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public void kc(int i) {
        this.cSY = i;
    }

    public void bv(long j) {
        this.cSZ = j;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void kd(int i) {
        this.cTa = i;
    }

    public void ke(int i) {
        this.cTb = i;
    }

    public boolean yW() {
        return this.cTc == 1;
    }

    public void kf(int i) {
        this.cTc = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int apg() {
        return this.cTe;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType == null ? a.C0173a.cSL : this.mType;
    }

    public static ChannelHomeVideoList<h> bb(List<ChannelVideoInfo> list) {
        if (list == null) {
            return null;
        }
        ChannelHomeVideoList<h> channelHomeVideoList = new ChannelHomeVideoList<>();
        for (ChannelVideoInfo channelVideoInfo : list) {
            h a = a(channelVideoInfo);
            if (a != null) {
                channelHomeVideoList.add(a);
            }
        }
        return channelHomeVideoList;
    }

    private static h a(ChannelVideoInfo channelVideoInfo) {
        if (channelVideoInfo == null) {
            return null;
        }
        h hVar = new h();
        hVar.setThreadId(channelVideoInfo.thread_id.longValue());
        hVar.setForumId(channelVideoInfo.forum_id.intValue());
        hVar.setForumName(channelVideoInfo.forum_name);
        hVar.setTitle(channelVideoInfo.title);
        hVar.kb(channelVideoInfo.play_count.intValue());
        hVar.setVideoUrl(channelVideoInfo.video_url);
        hVar.setVideoDuration(channelVideoInfo.video_duration.intValue());
        hVar.setVideoWidth(channelVideoInfo.video_width.intValue());
        hVar.setVideoHeight(channelVideoInfo.video_height.intValue());
        hVar.kc(channelVideoInfo.video_length.intValue());
        hVar.bv(channelVideoInfo.video_type.longValue());
        hVar.setThumbnailUrl(channelVideoInfo.thumbnail_url);
        hVar.kd(channelVideoInfo.thumbnail_width.intValue());
        hVar.ke(channelVideoInfo.thumbnail_height.intValue());
        hVar.kf(channelVideoInfo.is_top.intValue());
        hVar.setCreateTime(channelVideoInfo.create_time.intValue());
        return hVar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.threadId = jSONObject.optLong("thread_id");
        this.forumId = jSONObject.optInt("forum_id");
        this.forumName = jSONObject.optString("forum_name");
        this.createTime = jSONObject.optLong("create_time");
        this.title = jSONObject.optString("title");
        this.cTd = jSONObject.optString("play_time");
        this.bnr = jSONObject.optInt("play_count");
        this.videoUrl = jSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
        this.videoDuration = jSONObject.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
        this.videoWidth = jSONObject.optInt("video_width");
        this.videoHeight = jSONObject.optInt("video_height");
        this.cSY = jSONObject.optInt("video_length");
        this.cSZ = jSONObject.optInt("video_type");
        this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        this.cTa = jSONObject.optInt("thumbnail_width");
        this.cTb = jSONObject.optInt("thumbnail_height");
        this.cTe = jSONObject.optInt("already_add");
    }
}
