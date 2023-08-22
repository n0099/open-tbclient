package com.baidu.tieba.im.biz.aibot.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.b;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002()BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003Jg\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "Ljava/io/Serializable;", "noPermissionPrompt", "", "userInfo", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$UserInfo;", "defaultSug", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "greetingInfo", "", "", "configData", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$ConfigData;", "switch", "(Ljava/lang/String;Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$UserInfo;Ljava/util/List;Ljava/util/Map;Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$ConfigData;Ljava/util/Map;)V", "getConfigData", "()Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$ConfigData;", "getDefaultSug", "()Ljava/util/List;", "getGreetingInfo", "()Ljava/util/Map;", "getNoPermissionPrompt", "()Ljava/lang/String;", "getSwitch", "getUserInfo", "()Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$UserInfo;", "component1", "component2", "component3", "component4", "component5", "component6", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "ConfigData", "UserInfo", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatDetail implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("config")
    public final ConfigData configData;
    @SerializedName("default_sug")
    public final List<AbilityItem> defaultSug;
    @SerializedName("greeting_info")
    public final Map<String, Object> greetingInfo;
    @SerializedName("no_permission_prompt")
    public final String noPermissionPrompt;

    /* renamed from: switch  reason: not valid java name */
    public final Map<String, Object> f4switch;
    @SerializedName(SourceConstant.SOURCE_USER_INFO)
    public final UserInfo userInfo;

    public static /* synthetic */ AibotChatDetail copy$default(AibotChatDetail aibotChatDetail, String str, UserInfo userInfo, List list, Map map, ConfigData configData, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aibotChatDetail.noPermissionPrompt;
        }
        if ((i & 2) != 0) {
            userInfo = aibotChatDetail.userInfo;
        }
        UserInfo userInfo2 = userInfo;
        List<AbilityItem> list2 = list;
        if ((i & 4) != 0) {
            list2 = aibotChatDetail.defaultSug;
        }
        List list3 = list2;
        Map<String, Object> map3 = map;
        if ((i & 8) != 0) {
            map3 = aibotChatDetail.greetingInfo;
        }
        Map map4 = map3;
        if ((i & 16) != 0) {
            configData = aibotChatDetail.configData;
        }
        ConfigData configData2 = configData;
        Map<String, Object> map5 = map2;
        if ((i & 32) != 0) {
            map5 = aibotChatDetail.f4switch;
        }
        return aibotChatDetail.copy(str, userInfo2, list3, map4, configData2, map5);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.noPermissionPrompt : (String) invokeV.objValue;
    }

    public final UserInfo component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.userInfo : (UserInfo) invokeV.objValue;
    }

    public final List<AbilityItem> component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.defaultSug : (List) invokeV.objValue;
    }

    public final Map<String, Object> component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.greetingInfo : (Map) invokeV.objValue;
    }

    public final ConfigData component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.configData : (ConfigData) invokeV.objValue;
    }

    public final Map<String, Object> component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f4switch : (Map) invokeV.objValue;
    }

    public final AibotChatDetail copy(String str, UserInfo userInfo, List<AbilityItem> list, Map<String, ? extends Object> greetingInfo, ConfigData configData, Map<String, ? extends Object> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, userInfo, list, greetingInfo, configData, map})) == null) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            Intrinsics.checkNotNullParameter(greetingInfo, "greetingInfo");
            Intrinsics.checkNotNullParameter(configData, "configData");
            Intrinsics.checkNotNullParameter(map, "switch");
            return new AibotChatDetail(str, userInfo, list, greetingInfo, configData, map);
        }
        return (AibotChatDetail) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AibotChatDetail) {
                AibotChatDetail aibotChatDetail = (AibotChatDetail) obj;
                return Intrinsics.areEqual(this.noPermissionPrompt, aibotChatDetail.noPermissionPrompt) && Intrinsics.areEqual(this.userInfo, aibotChatDetail.userInfo) && Intrinsics.areEqual(this.defaultSug, aibotChatDetail.defaultSug) && Intrinsics.areEqual(this.greetingInfo, aibotChatDetail.greetingInfo) && Intrinsics.areEqual(this.configData, aibotChatDetail.configData) && Intrinsics.areEqual(this.f4switch, aibotChatDetail.f4switch);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String str = this.noPermissionPrompt;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.userInfo.hashCode()) * 31;
            List<AbilityItem> list = this.defaultSug;
            return ((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.greetingInfo.hashCode()) * 31) + this.configData.hashCode()) * 31) + this.f4switch.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "AibotChatDetail(noPermissionPrompt=" + this.noPermissionPrompt + ", userInfo=" + this.userInfo + ", defaultSug=" + this.defaultSug + ", greetingInfo=" + this.greetingInfo + ", configData=" + this.configData + ", switch=" + this.f4switch + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018¨\u00062"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$ConfigData;", "Ljava/io/Serializable;", "inputBoxPromptText", "", "loadingText", "notFirstGreetingInterval", "", "restartDialogueInterval", "themeColor", "defaultAnswer", "timeout", "msgNumForSug", "chatBackground", "bubbleBgColor", "sugTextColor", "tagColor", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBubbleBgColor", "()Ljava/lang/String;", "getChatBackground", "getDefaultAnswer", "getInputBoxPromptText", "getLoadingText", "getMsgNumForSug", "()I", "getNotFirstGreetingInterval", "getRestartDialogueInterval", "getSugTextColor", "getTagColor", "getThemeColor", "getTimeout", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ConfigData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("bubble_bg_color")
        public final String bubbleBgColor;
        @SerializedName("chat_background")
        public final String chatBackground;
        @SerializedName("default_answer")
        public final String defaultAnswer;
        @SerializedName("inputbox_prompt_text")
        public final String inputBoxPromptText;
        @SerializedName("loading_text")
        public final String loadingText;
        @SerializedName("msg_num_for_sug")
        public final int msgNumForSug;
        @SerializedName("not_first_greeting_interval")
        public final int notFirstGreetingInterval;
        @SerializedName("restart_dialogue_interval")
        public final int restartDialogueInterval;
        @SerializedName("sug_text_color")
        public final String sugTextColor;
        @SerializedName("tag_color")
        public final String tagColor;
        @SerializedName("theme_color")
        public final String themeColor;
        @SerializedName("timeout")
        public final int timeout;

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.inputBoxPromptText : (String) invokeV.objValue;
        }

        public final String component10() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bubbleBgColor : (String) invokeV.objValue;
        }

        public final String component11() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.sugTextColor : (String) invokeV.objValue;
        }

        public final String component12() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.tagColor : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.loadingText : (String) invokeV.objValue;
        }

        public final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.notFirstGreetingInterval : invokeV.intValue;
        }

        public final int component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.restartDialogueInterval : invokeV.intValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.themeColor : (String) invokeV.objValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.defaultAnswer : (String) invokeV.objValue;
        }

        public final int component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.timeout : invokeV.intValue;
        }

        public final int component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.msgNumForSug : invokeV.intValue;
        }

        public final String component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.chatBackground : (String) invokeV.objValue;
        }

        public final ConfigData copy(String inputBoxPromptText, String loadingText, int i, int i2, String themeColor, String defaultAnswer, int i3, int i4, String chatBackground, String bubbleBgColor, String sugTextColor, String tagColor) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{inputBoxPromptText, loadingText, Integer.valueOf(i), Integer.valueOf(i2), themeColor, defaultAnswer, Integer.valueOf(i3), Integer.valueOf(i4), chatBackground, bubbleBgColor, sugTextColor, tagColor})) == null) {
                Intrinsics.checkNotNullParameter(inputBoxPromptText, "inputBoxPromptText");
                Intrinsics.checkNotNullParameter(loadingText, "loadingText");
                Intrinsics.checkNotNullParameter(themeColor, "themeColor");
                Intrinsics.checkNotNullParameter(defaultAnswer, "defaultAnswer");
                Intrinsics.checkNotNullParameter(chatBackground, "chatBackground");
                Intrinsics.checkNotNullParameter(bubbleBgColor, "bubbleBgColor");
                Intrinsics.checkNotNullParameter(sugTextColor, "sugTextColor");
                Intrinsics.checkNotNullParameter(tagColor, "tagColor");
                return new ConfigData(inputBoxPromptText, loadingText, i, i2, themeColor, defaultAnswer, i3, i4, chatBackground, bubbleBgColor, sugTextColor, tagColor);
            }
            return (ConfigData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ConfigData) {
                    ConfigData configData = (ConfigData) obj;
                    return Intrinsics.areEqual(this.inputBoxPromptText, configData.inputBoxPromptText) && Intrinsics.areEqual(this.loadingText, configData.loadingText) && this.notFirstGreetingInterval == configData.notFirstGreetingInterval && this.restartDialogueInterval == configData.restartDialogueInterval && Intrinsics.areEqual(this.themeColor, configData.themeColor) && Intrinsics.areEqual(this.defaultAnswer, configData.defaultAnswer) && this.timeout == configData.timeout && this.msgNumForSug == configData.msgNumForSug && Intrinsics.areEqual(this.chatBackground, configData.chatBackground) && Intrinsics.areEqual(this.bubbleBgColor, configData.bubbleBgColor) && Intrinsics.areEqual(this.sugTextColor, configData.sugTextColor) && Intrinsics.areEqual(this.tagColor, configData.tagColor);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? (((((((((((((((((((((this.inputBoxPromptText.hashCode() * 31) + this.loadingText.hashCode()) * 31) + this.notFirstGreetingInterval) * 31) + this.restartDialogueInterval) * 31) + this.themeColor.hashCode()) * 31) + this.defaultAnswer.hashCode()) * 31) + this.timeout) * 31) + this.msgNumForSug) * 31) + this.chatBackground.hashCode()) * 31) + this.bubbleBgColor.hashCode()) * 31) + this.sugTextColor.hashCode()) * 31) + this.tagColor.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return "ConfigData(inputBoxPromptText=" + this.inputBoxPromptText + ", loadingText=" + this.loadingText + ", notFirstGreetingInterval=" + this.notFirstGreetingInterval + ", restartDialogueInterval=" + this.restartDialogueInterval + ", themeColor=" + this.themeColor + ", defaultAnswer=" + this.defaultAnswer + ", timeout=" + this.timeout + ", msgNumForSug=" + this.msgNumForSug + ", chatBackground=" + this.chatBackground + ", bubbleBgColor=" + this.bubbleBgColor + ", sugTextColor=" + this.sugTextColor + ", tagColor=" + this.tagColor + ')';
            }
            return (String) invokeV.objValue;
        }

        public ConfigData(String inputBoxPromptText, String loadingText, int i, int i2, String themeColor, String defaultAnswer, int i3, int i4, String chatBackground, String bubbleBgColor, String sugTextColor, String tagColor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {inputBoxPromptText, loadingText, Integer.valueOf(i), Integer.valueOf(i2), themeColor, defaultAnswer, Integer.valueOf(i3), Integer.valueOf(i4), chatBackground, bubbleBgColor, sugTextColor, tagColor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(inputBoxPromptText, "inputBoxPromptText");
            Intrinsics.checkNotNullParameter(loadingText, "loadingText");
            Intrinsics.checkNotNullParameter(themeColor, "themeColor");
            Intrinsics.checkNotNullParameter(defaultAnswer, "defaultAnswer");
            Intrinsics.checkNotNullParameter(chatBackground, "chatBackground");
            Intrinsics.checkNotNullParameter(bubbleBgColor, "bubbleBgColor");
            Intrinsics.checkNotNullParameter(sugTextColor, "sugTextColor");
            Intrinsics.checkNotNullParameter(tagColor, "tagColor");
            this.inputBoxPromptText = inputBoxPromptText;
            this.loadingText = loadingText;
            this.notFirstGreetingInterval = i;
            this.restartDialogueInterval = i2;
            this.themeColor = themeColor;
            this.defaultAnswer = defaultAnswer;
            this.timeout = i3;
            this.msgNumForSug = i4;
            this.chatBackground = chatBackground;
            this.bubbleBgColor = bubbleBgColor;
            this.sugTextColor = sugTextColor;
            this.tagColor = tagColor;
        }

        public final String getBubbleBgColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.bubbleBgColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getChatBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.chatBackground;
            }
            return (String) invokeV.objValue;
        }

        public final String getDefaultAnswer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.defaultAnswer;
            }
            return (String) invokeV.objValue;
        }

        public final String getInputBoxPromptText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.inputBoxPromptText;
            }
            return (String) invokeV.objValue;
        }

        public final String getLoadingText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.loadingText;
            }
            return (String) invokeV.objValue;
        }

        public final int getMsgNumForSug() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.msgNumForSug;
            }
            return invokeV.intValue;
        }

        public final int getNotFirstGreetingInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.notFirstGreetingInterval;
            }
            return invokeV.intValue;
        }

        public final int getRestartDialogueInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.restartDialogueInterval;
            }
            return invokeV.intValue;
        }

        public final String getSugTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.sugTextColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getTagColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.tagColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getThemeColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.themeColor;
            }
            return (String) invokeV.objValue;
        }

        public final int getTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.timeout;
            }
            return invokeV.intValue;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u001b\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000bHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jk\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012¨\u0006+"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$UserInfo;", "Ljava/io/Serializable;", "uk", "", "paid", "", "name", "portrait", "gender", "", TaskProcess.keyTags, "", "", "", "dialogNum", "createUname", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/lang/String;)V", "getCreateUname", "()Ljava/lang/String;", "getDialogNum", "()I", "getGender", "getName", "getPaid", "()J", "getPortrait", "getTags", "()Ljava/util/List;", "getUk", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class UserInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("create_uname")
        public final String createUname;
        @SerializedName("dialog_num")
        public final int dialogNum;
        public final int gender;
        public final String name;
        @SerializedName("pa")
        public final long paid;
        public final String portrait;
        public final List<Map<String, Object>> tags;
        public final String uk;

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.uk : (String) invokeV.objValue;
        }

        public final long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.paid : invokeV.longValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.portrait : (String) invokeV.objValue;
        }

        public final int component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.gender : invokeV.intValue;
        }

        public final List<Map<String, Object>> component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.tags : (List) invokeV.objValue;
        }

        public final int component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.dialogNum : invokeV.intValue;
        }

        public final String component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.createUname : (String) invokeV.objValue;
        }

        public final UserInfo copy(String uk, long j, String name, String portrait, int i, List<? extends Map<String, ? extends Object>> tags, int i2, String createUname) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{uk, Long.valueOf(j), name, portrait, Integer.valueOf(i), tags, Integer.valueOf(i2), createUname})) == null) {
                Intrinsics.checkNotNullParameter(uk, "uk");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(portrait, "portrait");
                Intrinsics.checkNotNullParameter(tags, "tags");
                Intrinsics.checkNotNullParameter(createUname, "createUname");
                return new UserInfo(uk, j, name, portrait, i, tags, i2, createUname);
            }
            return (UserInfo) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UserInfo) {
                    UserInfo userInfo = (UserInfo) obj;
                    return Intrinsics.areEqual(this.uk, userInfo.uk) && this.paid == userInfo.paid && Intrinsics.areEqual(this.name, userInfo.name) && Intrinsics.areEqual(this.portrait, userInfo.portrait) && this.gender == userInfo.gender && Intrinsics.areEqual(this.tags, userInfo.tags) && this.dialogNum == userInfo.dialogNum && Intrinsics.areEqual(this.createUname, userInfo.createUname);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (((((((((((((this.uk.hashCode() * 31) + b.a(this.paid)) * 31) + this.name.hashCode()) * 31) + this.portrait.hashCode()) * 31) + this.gender) * 31) + this.tags.hashCode()) * 31) + this.dialogNum) * 31) + this.createUname.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return "UserInfo(uk=" + this.uk + ", paid=" + this.paid + ", name=" + this.name + ", portrait=" + this.portrait + ", gender=" + this.gender + ", tags=" + this.tags + ", dialogNum=" + this.dialogNum + ", createUname=" + this.createUname + ')';
            }
            return (String) invokeV.objValue;
        }

        public UserInfo(String uk, long j, String name, String portrait, int i, List<? extends Map<String, ? extends Object>> tags, int i2, String createUname) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk, Long.valueOf(j), name, portrait, Integer.valueOf(i), tags, Integer.valueOf(i2), createUname};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(portrait, "portrait");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(createUname, "createUname");
            this.uk = uk;
            this.paid = j;
            this.name = name;
            this.portrait = portrait;
            this.gender = i;
            this.tags = tags;
            this.dialogNum = i2;
            this.createUname = createUname;
        }

        public final String getCreateUname() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.createUname;
            }
            return (String) invokeV.objValue;
        }

        public final int getDialogNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.dialogNum;
            }
            return invokeV.intValue;
        }

        public final int getGender() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.gender;
            }
            return invokeV.intValue;
        }

        public final String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public final long getPaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.paid;
            }
            return invokeV.longValue;
        }

        public final String getPortrait() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.portrait;
            }
            return (String) invokeV.objValue;
        }

        public final List<Map<String, Object>> getTags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.tags;
            }
            return (List) invokeV.objValue;
        }

        public final String getUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.uk;
            }
            return (String) invokeV.objValue;
        }
    }

    public AibotChatDetail(String str, UserInfo userInfo, List<AbilityItem> list, Map<String, ? extends Object> greetingInfo, ConfigData configData, Map<String, ? extends Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, userInfo, list, greetingInfo, configData, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        Intrinsics.checkNotNullParameter(greetingInfo, "greetingInfo");
        Intrinsics.checkNotNullParameter(configData, "configData");
        Intrinsics.checkNotNullParameter(map, "switch");
        this.noPermissionPrompt = str;
        this.userInfo = userInfo;
        this.defaultSug = list;
        this.greetingInfo = greetingInfo;
        this.configData = configData;
        this.f4switch = map;
    }

    public final ConfigData getConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.configData;
        }
        return (ConfigData) invokeV.objValue;
    }

    public final List<AbilityItem> getDefaultSug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.defaultSug;
        }
        return (List) invokeV.objValue;
    }

    public final Map<String, Object> getGreetingInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.greetingInfo;
        }
        return (Map) invokeV.objValue;
    }

    public final String getNoPermissionPrompt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.noPermissionPrompt;
        }
        return (String) invokeV.objValue;
    }

    public final Map<String, Object> getSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f4switch;
        }
        return (Map) invokeV.objValue;
    }

    public final UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.userInfo;
        }
        return (UserInfo) invokeV.objValue;
    }
}
