package com.baidu.tieba.channel.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.channel.config.a;
import java.util.List;
import org.json.JSONObject;
import tbclient.ChannelVideoInfo;
/* loaded from: classes6.dex */
public class h implements m {
    private int cWj;
    private long createTime;
    private int eSl;
    private long eSm;
    private int eSn;
    private int eSo;
    private int eSp;
    private String eSq;
    private int eSr;
    private int forumId;
    private String forumName;
    private long threadId;
    private String thumbnailUrl;
    private String title;
    private int videoDuration;
    private int videoHeight;
    private String videoUrl;
    private int videoWidth;
    private BdUniqueId xl;

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

    public int bbp() {
        return this.cWj;
    }

    public void oW(int i) {
        this.cWj = i;
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

    public void oX(int i) {
        this.eSl = i;
    }

    public void cv(long j) {
        this.eSm = j;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void oY(int i) {
        this.eSn = i;
    }

    public void oZ(int i) {
        this.eSo = i;
    }

    public boolean ajl() {
        return this.eSp == 1;
    }

    public void pa(int i) {
        this.eSp = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int bbq() {
        return this.eSr;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.xl = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.xl == null ? a.C0396a.eRY : this.xl;
    }

    public static ChannelHomeVideoList<h> bM(List<ChannelVideoInfo> list) {
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
        hVar.oW(channelVideoInfo.play_count.intValue());
        hVar.setVideoUrl(channelVideoInfo.video_url);
        hVar.setVideoDuration(channelVideoInfo.video_duration.intValue());
        hVar.setVideoWidth(channelVideoInfo.video_width.intValue());
        hVar.setVideoHeight(channelVideoInfo.video_height.intValue());
        hVar.oX(channelVideoInfo.video_length.intValue());
        hVar.cv(channelVideoInfo.video_type.longValue());
        hVar.setThumbnailUrl(channelVideoInfo.thumbnail_url);
        hVar.oY(channelVideoInfo.thumbnail_width.intValue());
        hVar.oZ(channelVideoInfo.thumbnail_height.intValue());
        hVar.pa(channelVideoInfo.is_top.intValue());
        hVar.setCreateTime(channelVideoInfo.create_time.intValue());
        return hVar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.threadId = jSONObject.optLong("thread_id");
        this.forumId = jSONObject.optInt("forum_id");
        this.forumName = jSONObject.optString("forum_name");
        this.createTime = jSONObject.optLong("create_time");
        this.title = jSONObject.optString("title");
        this.eSq = jSONObject.optString("play_time");
        this.cWj = jSONObject.optInt("play_count");
        this.videoUrl = jSONObject.optString("video_url");
        this.videoDuration = jSONObject.optInt("video_duration");
        this.videoWidth = jSONObject.optInt("video_width");
        this.videoHeight = jSONObject.optInt("video_height");
        this.eSl = jSONObject.optInt("video_length");
        this.eSm = jSONObject.optInt(LogConfig.LOG_VIDEO_TYPE);
        this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        this.eSn = jSONObject.optInt("thumbnail_width");
        this.eSo = jSONObject.optInt("thumbnail_height");
        this.eSr = jSONObject.optInt("already_add");
    }
}
