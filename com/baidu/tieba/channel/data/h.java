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
    private int cXa;
    private long createTime;
    private int eTc;
    private long eTd;
    private int eTe;
    private int eTf;
    private int eTg;
    private String eTh;
    private int eTi;
    private int forumId;
    private String forumName;
    private long threadId;
    private String thumbnailUrl;
    private String title;
    private int videoDuration;
    private int videoHeight;
    private String videoUrl;
    private int videoWidth;
    private BdUniqueId xL;

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

    public int bbr() {
        return this.cXa;
    }

    public void oX(int i) {
        this.cXa = i;
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

    public void oY(int i) {
        this.eTc = i;
    }

    public void cw(long j) {
        this.eTd = j;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void oZ(int i) {
        this.eTe = i;
    }

    public void pa(int i) {
        this.eTf = i;
    }

    public boolean ajn() {
        return this.eTg == 1;
    }

    public void pb(int i) {
        this.eTg = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int bbs() {
        return this.eTi;
    }

    public void n(BdUniqueId bdUniqueId) {
        this.xL = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.xL == null ? a.C0396a.eSP : this.xL;
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
        hVar.oX(channelVideoInfo.play_count.intValue());
        hVar.setVideoUrl(channelVideoInfo.video_url);
        hVar.setVideoDuration(channelVideoInfo.video_duration.intValue());
        hVar.setVideoWidth(channelVideoInfo.video_width.intValue());
        hVar.setVideoHeight(channelVideoInfo.video_height.intValue());
        hVar.oY(channelVideoInfo.video_length.intValue());
        hVar.cw(channelVideoInfo.video_type.longValue());
        hVar.setThumbnailUrl(channelVideoInfo.thumbnail_url);
        hVar.oZ(channelVideoInfo.thumbnail_width.intValue());
        hVar.pa(channelVideoInfo.thumbnail_height.intValue());
        hVar.pb(channelVideoInfo.is_top.intValue());
        hVar.setCreateTime(channelVideoInfo.create_time.intValue());
        return hVar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.threadId = jSONObject.optLong("thread_id");
        this.forumId = jSONObject.optInt("forum_id");
        this.forumName = jSONObject.optString("forum_name");
        this.createTime = jSONObject.optLong("create_time");
        this.title = jSONObject.optString("title");
        this.eTh = jSONObject.optString("play_time");
        this.cXa = jSONObject.optInt("play_count");
        this.videoUrl = jSONObject.optString("video_url");
        this.videoDuration = jSONObject.optInt("video_duration");
        this.videoWidth = jSONObject.optInt("video_width");
        this.videoHeight = jSONObject.optInt("video_height");
        this.eTc = jSONObject.optInt("video_length");
        this.eTd = jSONObject.optInt(LogConfig.LOG_VIDEO_TYPE);
        this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        this.eTe = jSONObject.optInt("thumbnail_width");
        this.eTf = jSONObject.optInt("thumbnail_height");
        this.eTi = jSONObject.optInt("already_add");
    }
}
