package com.baidu.tieba.channel.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.channel.config.a;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.List;
import org.json.JSONObject;
import tbclient.ChannelVideoInfo;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    private int bfF;
    private int cCm;
    private long cCn;
    private int cCo;
    private int cCp;
    private int cCq;
    private String cCr;
    private int cCs;
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

    public int ajr() {
        return this.bfF;
    }

    public void iT(int i) {
        this.bfF = i;
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

    public void iU(int i) {
        this.cCm = i;
    }

    public void bg(long j) {
        this.cCn = j;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void iV(int i) {
        this.cCo = i;
    }

    public void iW(int i) {
        this.cCp = i;
    }

    public boolean vV() {
        return this.cCq == 1;
    }

    public void iX(int i) {
        this.cCq = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int ajs() {
        return this.cCs;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType == null ? a.C0141a.cBZ : this.mType;
    }

    public static ChannelHomeVideoList<h> aL(List<ChannelVideoInfo> list) {
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
        hVar.iT(channelVideoInfo.play_count.intValue());
        hVar.setVideoUrl(channelVideoInfo.video_url);
        hVar.setVideoDuration(channelVideoInfo.video_duration.intValue());
        hVar.setVideoWidth(channelVideoInfo.video_width.intValue());
        hVar.setVideoHeight(channelVideoInfo.video_height.intValue());
        hVar.iU(channelVideoInfo.video_length.intValue());
        hVar.bg(channelVideoInfo.video_type.longValue());
        hVar.setThumbnailUrl(channelVideoInfo.thumbnail_url);
        hVar.iV(channelVideoInfo.thumbnail_width.intValue());
        hVar.iW(channelVideoInfo.thumbnail_height.intValue());
        hVar.iX(channelVideoInfo.is_top.intValue());
        hVar.setCreateTime(channelVideoInfo.create_time.intValue());
        return hVar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.threadId = jSONObject.optLong("thread_id");
        this.forumId = jSONObject.optInt("forum_id");
        this.forumName = jSONObject.optString("forum_name");
        this.createTime = jSONObject.optLong("create_time");
        this.title = jSONObject.optString("title");
        this.cCr = jSONObject.optString("play_time");
        this.bfF = jSONObject.optInt("play_count");
        this.videoUrl = jSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
        this.videoDuration = jSONObject.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
        this.videoWidth = jSONObject.optInt("video_width");
        this.videoHeight = jSONObject.optInt("video_height");
        this.cCm = jSONObject.optInt("video_length");
        this.cCn = jSONObject.optInt("video_type");
        this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        this.cCo = jSONObject.optInt("thumbnail_width");
        this.cCp = jSONObject.optInt("thumbnail_height");
        this.cCs = jSONObject.optInt("already_add");
    }
}
