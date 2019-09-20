package com.baidu.tieba.channel.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.channel.config.a;
import java.util.List;
import org.json.JSONObject;
import tbclient.ChannelVideoInfo;
/* loaded from: classes6.dex */
public class h implements m {
    private int cNI;
    private long createTime;
    private int eKA;
    private int eKB;
    private String eKC;
    private int eKD;
    private int eKx;
    private long eKy;
    private int eKz;
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

    public int bbn() {
        return this.cNI;
    }

    public void pV(int i) {
        this.cNI = i;
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

    public void pW(int i) {
        this.eKx = i;
    }

    public void cI(long j) {
        this.eKy = j;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.thumbnailUrl = str;
    }

    public void pX(int i) {
        this.eKz = i;
    }

    public void pY(int i) {
        this.eKA = i;
    }

    public boolean afj() {
        return this.eKB == 1;
    }

    public void pZ(int i) {
        this.eKB = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public int bbo() {
        return this.eKD;
    }

    public void setType(BdUniqueId bdUniqueId) {
        this.mType = bdUniqueId;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return this.mType == null ? a.C0307a.eKk : this.mType;
    }

    public static ChannelHomeVideoList<h> bz(List<ChannelVideoInfo> list) {
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
        hVar.pV(channelVideoInfo.play_count.intValue());
        hVar.setVideoUrl(channelVideoInfo.video_url);
        hVar.setVideoDuration(channelVideoInfo.video_duration.intValue());
        hVar.setVideoWidth(channelVideoInfo.video_width.intValue());
        hVar.setVideoHeight(channelVideoInfo.video_height.intValue());
        hVar.pW(channelVideoInfo.video_length.intValue());
        hVar.cI(channelVideoInfo.video_type.longValue());
        hVar.setThumbnailUrl(channelVideoInfo.thumbnail_url);
        hVar.pX(channelVideoInfo.thumbnail_width.intValue());
        hVar.pY(channelVideoInfo.thumbnail_height.intValue());
        hVar.pZ(channelVideoInfo.is_top.intValue());
        hVar.setCreateTime(channelVideoInfo.create_time.intValue());
        return hVar;
    }

    public void parserJson(JSONObject jSONObject) {
        this.threadId = jSONObject.optLong("thread_id");
        this.forumId = jSONObject.optInt("forum_id");
        this.forumName = jSONObject.optString("forum_name");
        this.createTime = jSONObject.optLong("create_time");
        this.title = jSONObject.optString("title");
        this.eKC = jSONObject.optString("play_time");
        this.cNI = jSONObject.optInt("play_count");
        this.videoUrl = jSONObject.optString("video_url");
        this.videoDuration = jSONObject.optInt("video_duration");
        this.videoWidth = jSONObject.optInt("video_width");
        this.videoHeight = jSONObject.optInt("video_height");
        this.eKx = jSONObject.optInt("video_length");
        this.eKy = jSONObject.optInt("video_type");
        this.thumbnailUrl = jSONObject.optString("thumbnail_url");
        this.eKz = jSONObject.optInt("thumbnail_width");
        this.eKA = jSONObject.optInt("thumbnail_height");
        this.eKD = jSONObject.optInt("already_add");
    }
}
