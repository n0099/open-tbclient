package com.baidu.tbadk.coreExtra.data;

import android.content.Intent;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.video.EditVideoData;
import java.io.File;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoInfo extends OrmObject implements Serializable {
    public static final String DRAFT_JSON_NAME = "new_video_info";
    public static final String KEY_VIDEO_DURATION = "video_l";
    public static final String KEY_VIDEO_HEIGHT = "video_h";
    public static final String KEY_VIDEO_PATH = "video";
    public static final String KEY_VIDEO_THUMB_PATH = "image";
    public static final String KEY_VIDEO_WIDTH = "video_w";
    public static final String VIDEO_CONTENT_PREFFIX = "#(movideo,";
    public static final int VIDEO_TYPE_RECORD = 1;
    public static final int VIDEO_TYPE_UPLOAD = 2;
    public static final long serialVersionUID = 4168698601975684150L;
    public EditVideoData editVideoData;
    public boolean isCompressedVideo;
    public List<String> mBeautifyListInfo;
    public List<String> mFilterListInfo;
    public List<String> mMusicListInfo;
    public List<String> mStickListInfo;
    public String thumbId;
    public String thumbPath;
    public String thumbUriStr;
    public int videoDuration;
    public int videoHeight;
    public long videoLength;
    public String videoMd5;
    public String videoPath;
    public int videoType;
    public String videoUriStr;
    public String videoUrl;
    public int videoWidth;

    public String buildContent() {
        return VIDEO_CONTENT_PREFFIX + this.thumbId + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoMd5 + "," + this.videoUrl + "," + this.videoDuration + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoLength + "," + this.videoType + SmallTailInfo.EMOTION_SUFFIX;
    }

    public void copy(VideoInfo videoInfo) {
        if (videoInfo == null) {
            return;
        }
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
        this.mBeautifyListInfo = videoInfo.mBeautifyListInfo;
        this.mFilterListInfo = videoInfo.mFilterListInfo;
        this.mMusicListInfo = videoInfo.mMusicListInfo;
        this.mStickListInfo = videoInfo.mStickListInfo;
        if (videoInfo.editVideoData == null) {
            this.editVideoData = null;
            return;
        }
        EditVideoData editVideoData = new EditVideoData();
        this.editVideoData = editVideoData;
        editVideoData.copy(videoInfo.editVideoData);
    }

    public List<String> getBeautifyListInfo() {
        return this.mBeautifyListInfo;
    }

    public EditVideoData getEditVideoData() {
        return this.editVideoData;
    }

    public List<String> getFilterListInfo() {
        return this.mFilterListInfo;
    }

    public List<String> getMusicListInfo() {
        return this.mMusicListInfo;
    }

    public List<String> getStickListInfo() {
        return this.mStickListInfo;
    }

    public String getThumbId() {
        return this.thumbId;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public String getThumbUriStr() {
        return this.thumbUriStr;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public long getVideoLength() {
        return this.videoLength;
    }

    public String getVideoMd5() {
        return this.videoMd5;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public int getVideoType() {
        return this.videoType;
    }

    public String getVideoUriStr() {
        return this.videoUriStr;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public boolean hasUpload() {
        return (StringUtils.isNull(this.videoUrl) || StringUtils.isNull(this.videoMd5)) ? false : true;
    }

    public boolean isAvaliable() {
        return (StringUtils.isNull(this.videoPath) || StringUtils.isNull(this.thumbPath) || !new File(this.videoPath).exists()) ? false : true;
    }

    public boolean isCompressedVideo() {
        return this.isCompressedVideo;
    }

    public boolean isEditVideoDataLegal() {
        EditVideoData editVideoData = this.editVideoData;
        return editVideoData != null && editVideoData.isLegal();
    }

    public boolean isVideoMixFinished() {
        EditVideoData editVideoData;
        return isAvaliable() && (editVideoData = this.editVideoData) != null && StringHelper.equals(this.videoPath, editVideoData.finalPath);
    }

    public boolean needUploadThunmb() {
        return !StringUtils.isNull(this.thumbPath) && StringUtils.isNull(this.thumbId);
    }

    public boolean needUploadVideo() {
        return StringUtils.isNull(this.videoUrl);
    }

    public void parseFromIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.videoPath = intent.getStringExtra("video");
        this.thumbPath = intent.getStringExtra("image");
        this.videoDuration = (int) (intent.getLongExtra(KEY_VIDEO_DURATION, 8000L) / 1000);
        this.videoHeight = intent.getIntExtra(KEY_VIDEO_HEIGHT, 480);
        this.videoWidth = intent.getIntExtra(KEY_VIDEO_WIDTH, 480);
    }

    public void setBeautifyListInfo(List<String> list) {
        this.mBeautifyListInfo = list;
    }

    public void setEditVideoData(EditVideoData editVideoData) {
        this.editVideoData = editVideoData;
    }

    public void setFilterListInfo(List<String> list) {
        this.mFilterListInfo = list;
    }

    public void setIsCompressedVideo(boolean z) {
        this.isCompressedVideo = z;
    }

    public void setMusicListInfo(List<String> list) {
        this.mMusicListInfo = list;
    }

    public void setStickListInfo(List<String> list) {
        this.mStickListInfo = list;
    }

    public void setThumbId(String str) {
        this.thumbId = str;
    }

    public void setThumbPath(String str) {
        this.thumbPath = str;
    }

    public void setThumbUriStr(String str) {
        this.thumbUriStr = str;
    }

    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public void setVideoLength(long j) {
        this.videoLength = j;
    }

    public void setVideoMd5(String str) {
        this.videoMd5 = str;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVideoType(int i) {
        this.videoType = i;
    }

    public void setVideoUriStr(String str) {
        this.videoUriStr = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }
}
