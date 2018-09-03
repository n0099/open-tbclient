package com.baidu.tieba.channel.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.channel.config.a;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.List;
import org.json.JSONObject;
import tbclient.ChannelVideoInfo;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    private int bfS;
    private int cEO;
    private long cEP;
    private int cEQ;
    private int cER;
    private int cES;
    private String cET;
    private int cEU;
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

    public int ajS() {
        return this.bfS;
    }

    public void je(int i) {
        this.bfS = i;
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

    public void jf(int i) {
        this.cEO = i;
    }

    public void bk(long j) {
        this.cEP = j;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void jg(int i) {
        this.cEQ = i;
    }

    public void jh(int i) {
        this.cER = i;
    }

    public boolean vJ() {
        return this.cES == 1;
    }

    public void ji(int i) {
        this.cES = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int ajT() {
        return this.cEU;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.mType == null ? a.C0139a.cEB : this.mType;
    }

    public static ChannelHomeVideoList<h> aK(List<ChannelVideoInfo> list) {
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
        hVar.je(channelVideoInfo.play_count.intValue());
        hVar.setVideoUrl(channelVideoInfo.video_url);
        hVar.setVideoDuration(channelVideoInfo.video_duration.intValue());
        hVar.setVideoWidth(channelVideoInfo.video_width.intValue());
        hVar.setVideoHeight(channelVideoInfo.video_height.intValue());
        hVar.jf(channelVideoInfo.video_length.intValue());
        hVar.bk(channelVideoInfo.video_type.longValue());
        hVar.setThumbnailUrl(channelVideoInfo.thumbnail_url);
        hVar.jg(channelVideoInfo.thumbnail_width.intValue());
        hVar.jh(channelVideoInfo.thumbnail_height.intValue());
        hVar.ji(channelVideoInfo.is_top.intValue());
        hVar.setCreateTime(channelVideoInfo.create_time.intValue());
        return hVar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.threadId = jSONObject.optLong("thread_id");
        this.forumId = jSONObject.optInt("forum_id");
        this.forumName = jSONObject.optString("forum_name");
        this.createTime = jSONObject.optLong("create_time");
        this.title = jSONObject.optString("title");
        this.cET = jSONObject.optString("play_time");
        this.bfS = jSONObject.optInt("play_count");
        this.videoUrl = jSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
        this.videoDuration = jSONObject.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
        this.videoWidth = jSONObject.optInt("video_width");
        this.videoHeight = jSONObject.optInt("video_height");
        this.cEO = jSONObject.optInt("video_length");
        this.cEP = jSONObject.optInt("video_type");
        this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        this.cEQ = jSONObject.optInt("thumbnail_width");
        this.cER = jSONObject.optInt("thumbnail_height");
        this.cEU = jSONObject.optInt("already_add");
    }
}
