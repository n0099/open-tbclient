package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TbPageContext<?> tbPageContext, @NonNull WriteData writeData) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, tbPageContext, writeData) == null) {
            String str2 = "";
            if (WriteVideoUtil.hasDraft()) {
                if (TextUtils.isEmpty(writeData.getTitle())) {
                    str = "";
                    i = 1;
                } else {
                    str = writeData.getTitle();
                    i = 5;
                }
                if (!TextUtils.isEmpty(writeData.getForumId()) && !TextUtils.isEmpty(writeData.getForumName())) {
                    WriteVideoUtil.openBottomActionSheet(tbPageContext, str, writeData.getContent(), writeData.getForumId(), writeData.getForumName(), 3, Boolean.FALSE, "", "", "");
                    return;
                }
                WriteVideoUtil.openBottomActionSheet(tbPageContext, str, writeData.getContent(), writeData.getForumId(), writeData.getForumName(), i, Boolean.TRUE, "", "", "");
                return;
            }
            if (writeData.getWriteImagesInfo() != null) {
                str2 = writeData.getWriteImagesInfo().toJsonString();
            }
            c(tbPageContext, writeData, str2, writeData.getFrom(), writeData.getDisableAudioMessage(), writeData.isVoiceEnable(), writeData.getPrefixData(), true);
        }
    }

    public static void b(@NonNull TbPageContext<?> tbPageContext, @NonNull WriteData writeData, @NonNull WriteImagesInfo writeImagesInfo, String str, String str2, boolean z, PostPrefixData postPrefixData) {
        String str3;
        JSONObject json;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{tbPageContext, writeData, writeImagesInfo, str, str2, Boolean.valueOf(z), postPrefixData}) == null) {
            String jsonString = writeImagesInfo.toJsonString();
            if (writeData.getType() == 11 && (json = writeImagesInfo.toJson()) != null) {
                try {
                    json.put("maxImagesAllowed", 9 - writeImagesInfo.size());
                    json.put("chosedFiles", (Object) null);
                    jsonString = json.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    str3 = null;
                }
            }
            str3 = jsonString;
            c(tbPageContext, writeData, str3, str, str2, z, postPrefixData, false);
        }
    }

    public static void c(@NonNull TbPageContext<?> tbPageContext, @NonNull WriteData writeData, String str, String str2, String str3, boolean z, PostPrefixData postPrefixData, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{tbPageContext, writeData, str, str2, str3, Boolean.valueOf(z), postPrefixData, Boolean.valueOf(z2)}) == null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(tbPageContext.getPageActivity(), str, true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", writeData.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", writeData.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", str2);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(z2);
            albumFloatActivityConfig.setCanSelectOnlyVideo(z2);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(3);
            albumFloatActivityConfig.setCallFrom(writeData.getCallFrom());
            albumFloatActivityConfig.setStatisticFrom(writeData.getStatisticFrom());
            albumFloatActivityConfig.setFrsTabInfo(writeData.getFrsTabInfoData());
            if (z2) {
                if (!TextUtils.isEmpty(writeData.getTitle())) {
                    albumFloatActivityConfig.setVideoTitle(writeData.getTitle());
                } else {
                    albumFloatActivityConfig.setVideoTitle("");
                }
                albumFloatActivityConfig.setBarName(writeData.getForumName());
                albumFloatActivityConfig.setBarID(writeData.getForumId());
                if (!TextUtils.isEmpty(writeData.getForumId()) && !TextUtils.isEmpty(writeData.getForumName())) {
                    albumFloatActivityConfig.setCanChangeBarName(false);
                } else {
                    albumFloatActivityConfig.setCanChangeBarName(true);
                }
                albumFloatActivityConfig.setVideoAbstract(writeData.getContent());
            }
            AntiData antiData = new AntiData();
            antiData.voice_message = str3;
            antiData.setIfVoice(z);
            albumFloatActivityConfig.setExtraData(antiData, postPrefixData, writeData.getFirstDir(), writeData.getSecondDir());
            tbPageContext.sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public static void d(@NonNull TbPageContext<?> tbPageContext, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, tbPageContext, writeData) == null) {
            int guideStatus = WriteVideoUtil.getGuideStatus();
            if (WriteVideoUtil.isShowGuide(guideStatus)) {
                WriteVideoUtil.jumpWorkVideoGuide(tbPageContext.getPageActivity(), guideStatus, WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_FRS_WRITE);
            } else {
                a(tbPageContext, writeData);
            }
        }
    }
}
