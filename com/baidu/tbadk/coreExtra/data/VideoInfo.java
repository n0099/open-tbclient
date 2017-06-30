package com.baidu.tbadk.coreExtra.data;

import android.content.Intent;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VideoInfo extends OrmObject implements Serializable {
    public static final String DRAFT_JSON_NAME = "new_video_info";
    public static final int VIDEO_TYPE_RECORD = 1;
    public static final int VIDEO_TYPE_UPLOAD = 2;
    private static final long serialVersionUID = 4168698601975684150L;
    private boolean isCompressedVideo;
    private long thumbId;
    private String thumbPath;
    private int videoDuration;
    private int videoHeight;
    private long videoLength;
    private String videoMd5;
    private String videoPath;
    private int videoType;
    private String videoUrl;
    private int videoWidth;

    public String getVideoPath() {
        return this.videoPath;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public long getThumbId() {
        return this.thumbId;
    }

    public void setThumbId(long j) {
        this.thumbId = j;
    }

    public boolean isCompressedVideo() {
        return this.isCompressedVideo;
    }

    public void setIsCompressedVideo(boolean z) {
        this.isCompressedVideo = z;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public String getVideoMd5() {
        return this.videoMd5;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public void setThumbPath(String str) {
        this.thumbPath = str;
    }

    public long getVideoLength() {
        return this.videoLength;
    }

    public void setVideoLength(long j) {
        this.videoLength = j;
    }

    public void setVideoType(int i) {
        this.videoType = i;
    }

    public int getVideoType() {
        return this.videoType;
    }

    public boolean isAvaliable() {
        return !StringUtils.isNull(this.videoPath) && !StringUtils.isNull(this.thumbPath) && this.videoHeight > 0 && this.videoWidth > 0 && new File(this.videoPath).exists();
    }

    public boolean needUploadVideo() {
        return StringUtils.isNull(this.videoUrl);
    }

    public boolean hasUpload() {
        return (StringUtils.isNull(this.videoUrl) || StringUtils.isNull(this.videoMd5)) ? false : true;
    }

    public boolean needUploadThunmb() {
        return !StringUtils.isNull(this.thumbPath) && this.thumbId <= 0;
    }

    public void parseFromIntent(Intent intent) {
        if (intent != null) {
            this.videoPath = intent.getStringExtra("video");
            this.thumbPath = intent.getStringExtra(TbConfig.TMP_PIC_DIR_NAME);
            this.videoDuration = (int) (intent.getLongExtra("video_l", 8000L) / 1000);
            this.videoHeight = intent.getIntExtra("video_h", 480);
            this.videoWidth = intent.getIntExtra("video_w", 480);
        }
    }

    public void copy(VideoInfo videoInfo) {
        if (videoInfo != null) {
            this.videoPath = videoInfo.videoPath;
            this.thumbPath = videoInfo.thumbPath;
            this.videoDuration = videoInfo.videoDuration;
            this.videoHeight = videoInfo.videoHeight;
            this.videoWidth = videoInfo.videoWidth;
            this.videoMd5 = videoInfo.videoMd5;
            this.videoUrl = videoInfo.videoUrl;
            this.thumbId = videoInfo.thumbId;
            this.videoLength = videoInfo.videoLength;
            this.videoType = videoInfo.videoType;
        }
    }

    public String buildContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("#(movideo,").append(this.thumbId).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoWidth).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoHeight).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoMd5).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoUrl).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoDuration).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoWidth).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoHeight).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoLength).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(this.videoType).append(")");
        return sb.toString();
    }
}
