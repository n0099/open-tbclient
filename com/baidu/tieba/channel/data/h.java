package com.baidu.tieba.channel.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.channel.config.a;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import java.util.List;
import org.json.JSONObject;
import tbclient.ChannelVideoInfo;
/* loaded from: classes6.dex */
public class h implements m {
    private int cDi;
    private long createTime;
    private int eob;
    private long eoc;
    private int eod;
    private int eoe;
    private int eog;
    private String eoh;
    private int eoi;
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

    public int aRw() {
        return this.cDi;
    }

    public void ow(int i) {
        this.cDi = i;
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

    public void ox(int i) {
        this.eob = i;
    }

    public void cd(long j) {
        this.eoc = j;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void oy(int i) {
        this.eod = i;
    }

    public void oz(int i) {
        this.eoe = i;
    }

    public boolean Zv() {
        return this.eog == 1;
    }

    public void oA(int i) {
        this.eog = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int aRx() {
        return this.eoi;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType == null ? a.C0276a.enO : this.mType;
    }

    public static ChannelHomeVideoList<h> bp(List<ChannelVideoInfo> list) {
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
        hVar.ow(channelVideoInfo.play_count.intValue());
        hVar.setVideoUrl(channelVideoInfo.video_url);
        hVar.setVideoDuration(channelVideoInfo.video_duration.intValue());
        hVar.setVideoWidth(channelVideoInfo.video_width.intValue());
        hVar.setVideoHeight(channelVideoInfo.video_height.intValue());
        hVar.ox(channelVideoInfo.video_length.intValue());
        hVar.cd(channelVideoInfo.video_type.longValue());
        hVar.setThumbnailUrl(channelVideoInfo.thumbnail_url);
        hVar.oy(channelVideoInfo.thumbnail_width.intValue());
        hVar.oz(channelVideoInfo.thumbnail_height.intValue());
        hVar.oA(channelVideoInfo.is_top.intValue());
        hVar.setCreateTime(channelVideoInfo.create_time.intValue());
        return hVar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.threadId = jSONObject.optLong("thread_id");
        this.forumId = jSONObject.optInt("forum_id");
        this.forumName = jSONObject.optString("forum_name");
        this.createTime = jSONObject.optLong("create_time");
        this.title = jSONObject.optString("title");
        this.eoh = jSONObject.optString("play_time");
        this.cDi = jSONObject.optInt("play_count");
        this.videoUrl = jSONObject.optString(WebVideoActivityConfig.KEY_VIDEO_URL);
        this.videoDuration = jSONObject.optInt(WebVideoActivityConfig.KEY_VIDEO_DURATION);
        this.videoWidth = jSONObject.optInt("video_width");
        this.videoHeight = jSONObject.optInt("video_height");
        this.eob = jSONObject.optInt("video_length");
        this.eoc = jSONObject.optInt("video_type");
        this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        this.eod = jSONObject.optInt("thumbnail_width");
        this.eoe = jSONObject.optInt("thumbnail_height");
        this.eoi = jSONObject.optInt("already_add");
    }
}
