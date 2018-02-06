package com.baidu.tieba.channel.data;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class ChannelInfo implements Serializable {
    public static final int PUSH_CLOSE = 2;
    public static final int PUSH_OPEN = 1;
    private String channelAvatar;
    private String channelCover;
    private long channelId;
    private String channelName;
    private String channelSmallCover;
    private String create_time;
    private String description;
    private int fansCount;
    private String follow_time;
    private int isSubscribe;
    private String portrait;
    private int pushSwitch;
    private long userId;
    private String userName;
    private int videoCount;
    private int videoPlayCount;

    public String getChannelSmallCover() {
        return this.channelSmallCover;
    }

    public void setChannelSmallCover(String str) {
        this.channelSmallCover = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getChannelCover() {
        return this.channelCover;
    }

    public void setChannelCover(String str) {
        this.channelCover = str;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public String getChannelAvatar() {
        return this.channelAvatar;
    }

    public void setChannelAvatar(String str) {
        this.channelAvatar = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public int getVideoCount() {
        return this.videoCount;
    }

    public void setVideoCount(int i) {
        this.videoCount = i;
    }

    public int getFansCount() {
        return this.fansCount;
    }

    public void setFansCount(int i) {
        this.fansCount = i;
    }

    public int getVideoPlayCount() {
        return this.videoPlayCount;
    }

    public void setVideoPlayCount(int i) {
        this.videoPlayCount = i;
    }

    public boolean isSubscribe() {
        return this.isSubscribe == 1;
    }

    public void setIsSubscribe(int i) {
        this.isSubscribe = i;
    }

    public int getPushSwitch() {
        return this.pushSwitch;
    }

    public void setPushSwitch(int i) {
        this.pushSwitch = i;
    }

    public void setPushOpenOrClose(boolean z) {
        this.pushSwitch = z ? 1 : 2;
    }

    public boolean isPushOpen() {
        return this.pushSwitch == 1;
    }

    public static ChannelInfo parse(tbclient.ChannelInfo channelInfo) {
        if (channelInfo == null) {
            return null;
        }
        ChannelInfo channelInfo2 = new ChannelInfo();
        channelInfo2.setChannelId(channelInfo.channel_id.longValue());
        channelInfo2.setChannelName(channelInfo.channel_name);
        channelInfo2.setChannelCover(channelInfo.channel_cover);
        channelInfo2.setChannelSmallCover(channelInfo.channel_small_cover);
        channelInfo2.setChannelAvatar(channelInfo.channel_avatar);
        channelInfo2.setDescription(channelInfo.description);
        channelInfo2.setUserId(channelInfo.user_id.longValue());
        channelInfo2.setUserName(channelInfo.user_name);
        channelInfo2.setVideoPlayCount(channelInfo.video_play_count.intValue());
        channelInfo2.setIsSubscribe(channelInfo.is_subscribe.intValue());
        channelInfo2.setPortrait(channelInfo.portrait);
        channelInfo2.setVideoCount(channelInfo.video_count.intValue());
        channelInfo2.setFansCount(channelInfo.fans_count.intValue());
        channelInfo2.setPushSwitch(channelInfo.push_switch.intValue());
        return channelInfo2;
    }
}
