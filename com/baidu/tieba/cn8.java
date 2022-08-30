package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.AsyncPublishImageStatData;
import com.baidu.tieba.tbadkCore.writeModel.AsyncPublishImagesStatData;
import com.baidu.tieba.tbadkCore.writeModel.AsyncPublishStatData;
import com.baidu.tieba.tbadkCore.writeModel.AsyncPublishVideoStatData;
import com.baidu.tieba.tbadkCore.writeModel.AsyncPublishVoiceStatData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (j <= 0 || j2 <= 0) {
                return -1.0f;
            }
            return (((float) j2) / 1024.0f) / (((float) j) / 1000.0f);
        }
        return invokeCommon.floatValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }

    public static void c(WriteData writeData, ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, writeData, errorData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        if (errorData == null || errorData.getError_code() != 5) {
            AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
            long currentTimeMillis = System.currentTimeMillis();
            asyncPublishStatData.endTime = currentTimeMillis;
            asyncPublishStatData.sendThreadDuration = currentTimeMillis - asyncPublishStatData.startTime;
            if (errorData != null && errorData.getError_code() == 0) {
                asyncPublishStatData.errorCode = 0;
            } else if (errorData != null) {
                asyncPublishStatData.errorCode = errorData.error_code;
                asyncPublishStatData.errorMessage = errorData.error_msg;
            } else {
                asyncPublishStatData.errorCode = -17;
                asyncPublishStatData.errorMessage = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c40);
            }
            f(asyncPublishStatData);
            b("上传结束（endAsyncPublish）: id =" + asyncPublishStatData.startTime + "    endTime = " + asyncPublishStatData.endTime);
        }
    }

    public static void d(WriteData writeData, ImageFileInfo imageFileInfo, ImageUploadResult imageUploadResult) {
        AsyncPublishImageStatData asyncPublishImageStatData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, writeData, imageFileInfo, imageUploadResult) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().imagesData == null || (asyncPublishImageStatData = writeData.getAsyncPublishStatData().imagesData.imageInfo.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        asyncPublishImageStatData.endTime = currentTimeMillis;
        long j = currentTimeMillis - asyncPublishImageStatData.endCompressTime;
        asyncPublishImageStatData.uploadDuration = j;
        if (j <= 0) {
            asyncPublishImageStatData.uploadDuration = 1L;
        }
        asyncPublishImageStatData.uploadRate = (((float) asyncPublishImageStatData.compressSize) / 1024.0f) / (((float) asyncPublishImageStatData.uploadDuration) / 1000.0f);
        if (imageUploadResult != null) {
            UploadedImageInfo uploadedPicInfo = imageUploadResult.getUploadedPicInfo();
            if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                asyncPublishImageStatData.errorCode = 0;
                asyncPublishImageStatData.picId = uploadedPicInfo.toPostString();
            } else {
                asyncPublishImageStatData.errorCode = imageUploadResult.error_code;
                asyncPublishImageStatData.errorMessage = imageUploadResult.error_msg;
            }
        } else {
            asyncPublishImageStatData.errorCode = -52;
            asyncPublishImageStatData.errorMessage = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c40);
        }
        b("结束单张上传图片（endAsyncPublishImage）: path =" + imageFileInfo.getFilePath());
        b("结束单张上传图片（网络耗时）: time = " + (asyncPublishImageStatData.endTime - asyncPublishImageStatData.endCompressTime));
    }

    public static void e(WriteData writeData, ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, writeData, errorData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().imagesData == null) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
        AsyncPublishImagesStatData asyncPublishImagesStatData = asyncPublishStatData.imagesData;
        asyncPublishImagesStatData.endTime = System.currentTimeMillis();
        asyncPublishStatData.haveImage = 1;
        asyncPublishStatData.imageCount = asyncPublishImagesStatData.imageInfo.size();
        long j = 0;
        for (AsyncPublishImageStatData asyncPublishImageStatData : asyncPublishImagesStatData.imageInfo.values()) {
            j += asyncPublishImageStatData.compressSize;
        }
        asyncPublishStatData.imageSize = j;
        long j2 = asyncPublishImagesStatData.endTime - asyncPublishImagesStatData.startTime;
        asyncPublishStatData.imageUploadDuration = j2;
        asyncPublishStatData.imageUploadRate = a(j2, j);
        if (errorData == null) {
            asyncPublishImagesStatData.errorCode = 0;
        } else {
            asyncPublishImagesStatData.errorCode = errorData.error_code;
            asyncPublishImagesStatData.errorMessage = errorData.error_msg;
        }
        asyncPublishStatData.imageErrorCode = asyncPublishImagesStatData.errorCode;
        asyncPublishStatData.imageErrorMessage = asyncPublishImagesStatData.errorMessage;
        b("结束上传多张图片（endAsyncPublishImages）: id =" + asyncPublishImagesStatData.startTime + "    endTime = " + asyncPublishImagesStatData.endTime);
        StringBuilder sb = new StringBuilder();
        sb.append("结束上传多张图片（整体耗时）: time = ");
        sb.append(asyncPublishImagesStatData.endTime - asyncPublishImagesStatData.startTime);
        b(sb.toString());
    }

    public static void f(@NonNull AsyncPublishStatData asyncPublishStatData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, asyncPublishStatData) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", asyncPublishStatData.toEndStatJson());
                uBCManager.onEvent("4259", jSONObject);
                b("【打点】-【结束】endAsyncPublishStat: id = " + asyncPublishStatData.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            k(asyncPublishStatData);
        }
    }

    public static void g(WriteData writeData, VideoFinishResult videoFinishResult) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, writeData, videoFinishResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().videoData == null) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
        AsyncPublishVideoStatData asyncPublishVideoStatData = asyncPublishStatData.videoData;
        asyncPublishVideoStatData.endTime = System.currentTimeMillis();
        asyncPublishStatData.haveVideo = 1;
        if (videoFinishResult == null) {
            asyncPublishVideoStatData.errorCode = -53;
        } else if (videoFinishResult.isSuccess()) {
            asyncPublishVideoStatData.errorCode = 0;
            asyncPublishVideoStatData.md5 = videoFinishResult.getVideoMd5();
            asyncPublishVideoStatData.url = videoFinishResult.getVideoUrl();
        } else {
            asyncPublishVideoStatData.errorCode = videoFinishResult.getErrorNo();
            asyncPublishVideoStatData.errorMessage = videoFinishResult.getUserMessage();
        }
        asyncPublishStatData.videoErrorCode = asyncPublishVideoStatData.errorCode;
        asyncPublishStatData.videoErrorMessage = asyncPublishVideoStatData.errorMessage;
        long j = asyncPublishVideoStatData.endTime - asyncPublishVideoStatData.startTime;
        asyncPublishStatData.videoUploadDuration = j;
        long j2 = asyncPublishVideoStatData.size;
        asyncPublishStatData.videoSize = j2;
        asyncPublishStatData.videoUploadRate = a(j, j2);
        b("上传视频结束（endAsyncPublishVideo）: id =" + asyncPublishVideoStatData.startTime + "    endTime = " + asyncPublishVideoStatData.endTime);
    }

    public static void h(WriteData writeData, ImageUploadResult imageUploadResult) {
        ImageUploadResult.PicDetailedInfo picDetailedInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, writeData, imageUploadResult) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().videoFirstFrame == null) {
            return;
        }
        AsyncPublishImageStatData asyncPublishImageStatData = writeData.getAsyncPublishStatData().videoFirstFrame;
        asyncPublishImageStatData.endTime = System.currentTimeMillis();
        if (imageUploadResult == null) {
            asyncPublishImageStatData.errorCode = -53;
        } else {
            ImageUploadResult.picInfo picinfo = imageUploadResult.picInfo;
            if (picinfo != null && (picDetailedInfo = picinfo.bigPic) != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                asyncPublishImageStatData.errorCode = 0;
                asyncPublishImageStatData.picId = imageUploadResult.picInfo.bigPic.picUrl;
            } else {
                asyncPublishImageStatData.errorCode = imageUploadResult.error_code;
                asyncPublishImageStatData.errorMessage = imageUploadResult.error_msg;
            }
        }
        long j = asyncPublishImageStatData.endTime - asyncPublishImageStatData.startTime;
        asyncPublishImageStatData.uploadDuration = j;
        asyncPublishImageStatData.uploadRate = a(j, asyncPublishImageStatData.originSize);
        b("上传视频首帧结束（endAsyncPublishVideoFirstFrame）: id =" + asyncPublishImageStatData.startTime + "    endTime = " + asyncPublishImageStatData.endTime);
    }

    public static void i(WriteData writeData, fy4 fy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, writeData, fy4Var) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().voiceData == null) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
        AsyncPublishVoiceStatData asyncPublishVoiceStatData = asyncPublishStatData.voiceData;
        asyncPublishVoiceStatData.endTime = System.currentTimeMillis();
        asyncPublishStatData.haveVoice = 1;
        if (fy4Var != null && fy4Var.d()) {
            ey4 a = fy4Var.a();
            if (a != null) {
                asyncPublishVoiceStatData.errorCode = 0;
                asyncPublishVoiceStatData.md5 = a.b();
            } else {
                asyncPublishVoiceStatData.errorCode = fy4Var.b();
                asyncPublishVoiceStatData.errorMessage = fy4Var.c();
            }
        } else if (fy4Var != null) {
            asyncPublishVoiceStatData.errorCode = fy4Var.b();
            asyncPublishVoiceStatData.errorMessage = fy4Var.c();
        } else {
            asyncPublishVoiceStatData.errorCode = TbErrInfo.ERR_VOI_SEND;
        }
        asyncPublishStatData.voiceErrorCode = asyncPublishVoiceStatData.errorCode;
        asyncPublishStatData.voiceErrorMessage = asyncPublishVoiceStatData.errorMessage;
        long j = asyncPublishVoiceStatData.endTime - asyncPublishVoiceStatData.startTime;
        asyncPublishStatData.voiceUploadDuration = j;
        long j2 = asyncPublishVoiceStatData.size;
        asyncPublishStatData.voiceSize = j2;
        asyncPublishStatData.voiceUploadRate = a(j, j2);
        b("上传声音结束（endAsyncPublishVoice）: id =" + asyncPublishVoiceStatData.startTime + "    endTime = " + asyncPublishVoiceStatData.endTime);
    }

    public static void j(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j) {
        AsyncPublishImageStatData asyncPublishImageStatData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j)}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().imagesData == null || (asyncPublishImageStatData = writeData.getAsyncPublishStatData().imagesData.imageInfo.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        asyncPublishImageStatData.endCompressTime = System.currentTimeMillis();
        asyncPublishImageStatData.compressTempPath = str;
        asyncPublishImageStatData.compressWidth = iArr[0];
        asyncPublishImageStatData.compressHeight = iArr[1];
        asyncPublishImageStatData.compressSize = j;
        b("压缩结束（endCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j) / 1048576.0f) + "MB");
    }

    public static void k(@NonNull AsyncPublishStatData asyncPublishStatData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, asyncPublishStatData) == null) {
            try {
                xg statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
                statsItem.b("action", "async_publish_end");
                statsItem.c("extId", Long.valueOf(asyncPublishStatData.id));
                statsItem.c("parentId", Long.valueOf(asyncPublishStatData.parentId));
                statsItem.c(FetchLog.START_TIME, Long.valueOf(asyncPublishStatData.startTime));
                statsItem.c(FetchLog.END_TIME, Long.valueOf(asyncPublishStatData.endTime));
                statsItem.c("errorCode", Integer.valueOf(asyncPublishStatData.errorCode));
                statsItem.b("errorMessage", asyncPublishStatData.errorMessage);
                statsItem.c("sendThreadDuration", Long.valueOf(asyncPublishStatData.sendThreadDuration));
                statsItem.c("haveImage", Integer.valueOf(asyncPublishStatData.haveImage));
                statsItem.c("haveVideo", Integer.valueOf(asyncPublishStatData.haveVideo));
                statsItem.c("haveVoice", Integer.valueOf(asyncPublishStatData.haveVoice));
                if (asyncPublishStatData.imagesData != null) {
                    statsItem.b("imagesData", asyncPublishStatData.imagesData.toJson().toString());
                    statsItem.c("imageErrorCode", Integer.valueOf(asyncPublishStatData.imageErrorCode));
                    statsItem.b("imageErrorMessage", asyncPublishStatData.imageErrorMessage);
                    statsItem.c("imageUploadRate", Float.valueOf(asyncPublishStatData.imageUploadRate));
                    statsItem.c("imageUploadDuration", Long.valueOf(asyncPublishStatData.imageUploadDuration));
                    statsItem.c("imageCount", Integer.valueOf(asyncPublishStatData.imageCount));
                    statsItem.c("imageSize", Long.valueOf(asyncPublishStatData.imageSize));
                    statsItem.c("needImageParallel", Integer.valueOf(asyncPublishStatData.needImageParallel));
                    statsItem.c("imageChunkSize", Integer.valueOf(asyncPublishStatData.imageChunkSize));
                    statsItem.c("imageUploadConcurrency", Integer.valueOf(asyncPublishStatData.imageUploadConcurrency));
                    statsItem.c("imageChunkRetry", Integer.valueOf(asyncPublishStatData.imageChunkRetry));
                }
                if (asyncPublishStatData.voiceData != null) {
                    statsItem.b("voiceData", asyncPublishStatData.voiceData.toJson().toString());
                    statsItem.c("voiceErrorCode", Integer.valueOf(asyncPublishStatData.voiceErrorCode));
                    statsItem.b("voiceErrorMessage", asyncPublishStatData.voiceErrorMessage);
                    statsItem.c("voiceUploadDuration", Long.valueOf(asyncPublishStatData.voiceUploadDuration));
                    statsItem.c("voiceUploadRate", Float.valueOf(asyncPublishStatData.voiceUploadRate));
                }
                if (asyncPublishStatData.videoData != null) {
                    statsItem.b("videoData", asyncPublishStatData.videoData.toJson().toString());
                    statsItem.c("videoErrorCode", Integer.valueOf(asyncPublishStatData.videoErrorCode));
                    statsItem.b("videoErrorMessage", asyncPublishStatData.videoErrorMessage);
                    statsItem.c("videoUploadRate", Float.valueOf(asyncPublishStatData.videoUploadRate));
                    statsItem.c("videoUploadDuration", Long.valueOf(asyncPublishStatData.videoUploadDuration));
                }
                if (asyncPublishStatData.videoFirstFrame != null) {
                    statsItem.b("videoFirstFrame", asyncPublishStatData.videoFirstFrame.toJson().toString());
                }
                BdStatisticsManager.getInstance().performance("thread", statsItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void l(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, writeData) == null) || writeData == null || writeData.startPublishTime() <= 0) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = new AsyncPublishStatData(writeData);
        writeData.setAsyncPublishStatData(asyncPublishStatData);
        b("开始后台上传（startAsyncPublish） id = " + asyncPublishStatData.id + "  parentId = " + asyncPublishStatData.parentId);
        o(asyncPublishStatData);
    }

    public static void m(WriteData writeData, ImageFileInfo imageFileInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, null, writeData, imageFileInfo) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().imagesData == null) {
            return;
        }
        writeData.getAsyncPublishStatData().imagesData.imageInfo.put(Long.valueOf(imageFileInfo.startUploadTime), new AsyncPublishImageStatData(imageFileInfo));
        b("多张图片开始上传(startAsyncPublishImage): path =" + imageFileInfo.getFilePath());
    }

    public static void n(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, writeData) == null) || writeData == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
        asyncPublishStatData.imagesData = new AsyncPublishImagesStatData();
        WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
        if (writeImagesInfo != null) {
            asyncPublishStatData.needImageParallel = writeImagesInfo.needImageParallel ? 1 : 0;
            asyncPublishStatData.imageChunkSize = writeImagesInfo.imageChunkSize;
            asyncPublishStatData.imageUploadConcurrency = writeImagesInfo.imageUploadConcurrency;
            asyncPublishStatData.imageChunkRetry = writeImagesInfo.imageChunkRetry;
        }
        b("多张图片开始上传（startAsyncPublishImages）: startTime = " + asyncPublishStatData.imagesData.startTime);
    }

    public static void o(@NonNull AsyncPublishStatData asyncPublishStatData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, asyncPublishStatData) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ext", asyncPublishStatData.toClickStatJson());
                uBCManager.onEvent("4260", jSONObject);
                b("【打点】-【点击】startAsyncPublishStat: id = " + asyncPublishStatData.id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            t(asyncPublishStatData);
        }
    }

    public static void p(WriteData writeData, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, writeData, videoInfo) == null) || writeData == null || videoInfo == null || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
        AsyncPublishVideoStatData asyncPublishVideoStatData = new AsyncPublishVideoStatData(videoInfo);
        asyncPublishStatData.videoData = asyncPublishVideoStatData;
        asyncPublishVideoStatData.size = FileHelper.getFileSize(videoInfo.getVideoPath());
        b("开始上传视频（startAsyncPublishVideo）: id =" + videoInfo.getVideoPath());
    }

    public static void q(WriteData writeData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, writeData, str) == null) || writeData == null || TextUtils.isEmpty(str) || writeData.getAsyncPublishStatData() == null) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
        AsyncPublishImageStatData asyncPublishImageStatData = new AsyncPublishImageStatData(str);
        asyncPublishStatData.videoFirstFrame = asyncPublishImageStatData;
        asyncPublishImageStatData.originSize = FileHelper.getFileSize(str);
        b("开始上传视频首帧（startAsyncPublishVideoFirstFrame): path =" + asyncPublishStatData.videoFirstFrame.originPath);
    }

    public static void r(WriteData writeData, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65553, null, writeData, j) == null) || writeData == null || writeData.getAsyncPublishStatData() == null || TextUtils.isEmpty(writeData.getVoice())) {
            return;
        }
        AsyncPublishStatData asyncPublishStatData = writeData.getAsyncPublishStatData();
        AsyncPublishVoiceStatData asyncPublishVoiceStatData = new AsyncPublishVoiceStatData(writeData.getVoice());
        asyncPublishVoiceStatData.size = j;
        asyncPublishStatData.voiceData = asyncPublishVoiceStatData;
        b("开始上传声音（startAsyncPublishVoice）: id =" + asyncPublishVoiceStatData.id);
    }

    public static void s(WriteData writeData, ImageFileInfo imageFileInfo, String str, int[] iArr, long j, boolean z, boolean z2, boolean z3, String str2) {
        AsyncPublishImageStatData asyncPublishImageStatData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{writeData, imageFileInfo, str, iArr, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str2}) == null) || writeData == null || imageFileInfo == null || writeData.getAsyncPublishStatData() == null || writeData.getAsyncPublishStatData().imagesData == null || (asyncPublishImageStatData = writeData.getAsyncPublishStatData().imagesData.imageInfo.get(Long.valueOf(imageFileInfo.startUploadTime))) == null) {
            return;
        }
        asyncPublishImageStatData.startCompressTime = System.currentTimeMillis();
        asyncPublishImageStatData.originPath = str;
        asyncPublishImageStatData.originWidth = iArr[0];
        asyncPublishImageStatData.originHeight = iArr[1];
        asyncPublishImageStatData.originSize = j;
        asyncPublishImageStatData.isLongImage = z;
        asyncPublishImageStatData.isHeifImage = z2;
        asyncPublishImageStatData.hasActionsWithoutResize = z3;
        asyncPublishImageStatData.uploadImageType = str2;
        b("开始压缩（startCompressImage）: path =" + str + "\n   w =" + iArr[0] + " h =" + iArr[1] + "  size =" + (((float) j) / 1048576.0f) + "MB\n   isLongImage =" + z + "  isHeifImage =" + z2 + " resize =" + z3 + " uploadStrategy =" + str2);
    }

    public static void t(@NonNull AsyncPublishStatData asyncPublishStatData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, asyncPublishStatData) == null) {
            xg statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
            statsItem.b("action", "async_publish_start");
            statsItem.c("extId", Long.valueOf(asyncPublishStatData.id));
            statsItem.c("parentId", Long.valueOf(asyncPublishStatData.parentId));
            statsItem.c(FetchLog.START_TIME, Long.valueOf(asyncPublishStatData.startTime));
            BdStatisticsManager.getInstance().performance("thread", statsItem);
        }
    }
}
