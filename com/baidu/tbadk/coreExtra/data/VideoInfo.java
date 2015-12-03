package com.baidu.tbadk.coreExtra.data;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class VideoInfo extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    public static final String DRAFT_JSON_NAME = "new_video_info";
    private static final long serialVersionUID = 4168698601975684150L;
    private long thumbId;
    private String thumbPath;
    private int videoDuration;
    private int videoHeight;
    private String videoMd5;
    private String videoPath;
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
        }
    }

    public String buildContent() {
        StringBuilder sb = new StringBuilder();
        sb.append("#(movideo,").append(this.thumbId).append(",");
        sb.append(this.videoWidth).append(",");
        sb.append(this.videoHeight).append(",");
        sb.append(this.videoMd5).append(",");
        sb.append(this.videoUrl).append(",");
        sb.append(this.videoDuration).append(",");
        sb.append(this.videoWidth).append(",");
        sb.append(this.videoHeight).append(")");
        return sb.toString();
    }
}
