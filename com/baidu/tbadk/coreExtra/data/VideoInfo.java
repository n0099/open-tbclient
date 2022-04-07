package com.baidu.tbadk.coreExtra.data;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class VideoInfo extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public EditVideoData editVideoData;
    public boolean isCompressedVideo;
    public List<String> mBeautifyListInfo;
    public List<String> mFilterListInfo;
    public List<String> mMusicListInfo;
    public List<String> mStickListInfo;
    public TbMultiMediaData multiMediaData;
    public String thumbId;
    public String thumbPath;
    public String thumbUriStr;
    public int videoDuration;
    public int videoHeight;
    public long videoLength;
    public String videoMd5;
    public String videoPath;
    public int videoSource;
    public String videoUriStr;
    public String videoUrl;
    public int videoWidth;

    public VideoInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.videoSource = 2;
    }

    public String buildContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "#(movideo," + this.thumbId + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoMd5 + "," + this.videoUrl + "," + this.videoDuration + "," + this.videoWidth + "," + this.videoHeight + "," + this.videoLength + "," + this.videoSource + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public void copy(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoInfo) == null) || videoInfo == null) {
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
        this.videoSource = videoInfo.videoSource;
        this.mBeautifyListInfo = videoInfo.mBeautifyListInfo;
        this.mFilterListInfo = videoInfo.mFilterListInfo;
        this.mMusicListInfo = videoInfo.mMusicListInfo;
        this.mStickListInfo = videoInfo.mStickListInfo;
        if (videoInfo.editVideoData == null) {
            this.editVideoData = null;
        } else {
            EditVideoData editVideoData = new EditVideoData();
            this.editVideoData = editVideoData;
            editVideoData.copy(videoInfo.editVideoData);
        }
        this.multiMediaData = videoInfo.multiMediaData;
    }

    public List<String> getBeautifyListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBeautifyListInfo : (List) invokeV.objValue;
    }

    public EditVideoData getEditVideoData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.editVideoData : (EditVideoData) invokeV.objValue;
    }

    public List<String> getFilterListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFilterListInfo : (List) invokeV.objValue;
    }

    public TbMultiMediaData getMultiMediaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.multiMediaData : (TbMultiMediaData) invokeV.objValue;
    }

    public List<String> getMusicListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMusicListInfo : (List) invokeV.objValue;
    }

    public List<String> getStickListInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mStickListInfo : (List) invokeV.objValue;
    }

    public String getThumbId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.thumbId : (String) invokeV.objValue;
    }

    public String getThumbPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.thumbPath : (String) invokeV.objValue;
    }

    public String getThumbUriStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.thumbUriStr : (String) invokeV.objValue;
    }

    public int getVideoDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.videoDuration : invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.videoHeight : invokeV.intValue;
    }

    public long getVideoLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.videoLength : invokeV.longValue;
    }

    public String getVideoMd5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.videoMd5 : (String) invokeV.objValue;
    }

    public String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.videoPath : (String) invokeV.objValue;
    }

    public int getVideoSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.videoSource : invokeV.intValue;
    }

    public String getVideoUriStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.videoUriStr : (String) invokeV.objValue;
    }

    public String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.videoUrl : (String) invokeV.objValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.videoWidth : invokeV.intValue;
    }

    public boolean hasUpload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (StringUtils.isNull(this.videoUrl) || StringUtils.isNull(this.videoMd5)) ? false : true : invokeV.booleanValue;
    }

    public boolean isAvaliable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (StringUtils.isNull(this.videoPath) || StringUtils.isNull(this.thumbPath) || !new File(this.videoPath).exists()) ? false : true : invokeV.booleanValue;
    }

    public boolean isCompressedVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.isCompressedVideo : invokeV.booleanValue;
    }

    public boolean isEditVideoDataLegal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            EditVideoData editVideoData = this.editVideoData;
            return editVideoData != null && editVideoData.isLegal();
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoMixFinished() {
        InterceptResult invokeV;
        EditVideoData editVideoData;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? isAvaliable() && (editVideoData = this.editVideoData) != null && StringHelper.equals(this.videoPath, editVideoData.finalPath) : invokeV.booleanValue;
    }

    public boolean needUploadThunmb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? !StringUtils.isNull(this.thumbPath) && StringUtils.isNull(this.thumbId) : invokeV.booleanValue;
    }

    public boolean needUploadVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? StringUtils.isNull(this.videoUrl) : invokeV.booleanValue;
    }

    public void parseFromIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, intent) == null) || intent == null) {
            return;
        }
        this.videoPath = intent.getStringExtra("video");
        this.thumbPath = intent.getStringExtra("image");
        this.videoDuration = (int) (intent.getLongExtra("video_l", 8000L) / 1000);
        this.videoHeight = intent.getIntExtra("video_h", 480);
        this.videoWidth = intent.getIntExtra("video_w", 480);
    }

    public void setBeautifyListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            this.mBeautifyListInfo = list;
        }
    }

    public void setEditVideoData(EditVideoData editVideoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, editVideoData) == null) {
            this.editVideoData = editVideoData;
        }
    }

    public void setFilterListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            this.mFilterListInfo = list;
        }
    }

    public void setIsCompressedVideo(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.isCompressedVideo = z;
        }
    }

    public void setMultiMediaData(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, tbMultiMediaData) == null) {
            this.multiMediaData = tbMultiMediaData;
        }
    }

    public void setMusicListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            this.mMusicListInfo = list;
        }
    }

    public void setStickListInfo(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, list) == null) {
            this.mStickListInfo = list;
        }
    }

    public void setThumbId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.thumbId = str;
        }
    }

    public void setThumbPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.thumbPath = str;
        }
    }

    public void setThumbUriStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.thumbUriStr = str;
        }
    }

    public void setVideoDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.videoDuration = i;
        }
    }

    public void setVideoHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.videoHeight = i;
        }
    }

    public void setVideoLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048616, this, j) == null) {
            this.videoLength = j;
        }
    }

    public void setVideoMd5(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.videoMd5 = str;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.videoPath = str;
        }
    }

    public void setVideoSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.videoSource = i;
        }
    }

    public void setVideoUriStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.videoUriStr = str;
        }
    }

    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.videoUrl = str;
        }
    }

    public void setVideoWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.videoWidth = i;
        }
    }
}
