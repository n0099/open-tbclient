package com.baidu.tieba.im.biz.aibot.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.ctrl.model.TaskProcess;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.b;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
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
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0004=>?@B\u0085\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J\u0015\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J\u0015\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J\t\u00106\u001a\u00020\u0010HÆ\u0003J\u0099\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010;\u001a\u00020\u0010HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b,\u0010-R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "Ljava/io/Serializable;", "noPermissionPrompt", "", "userInfoMap", "", "", "topicInfo", "", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$TopicInfo;", "defaultSug", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "greetingInfo", "configDataMap", "switchDataMap", "auditStatus", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;I)V", "getAuditStatus", "()I", "setAuditStatus", "(I)V", "configData", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$ConfigData;", "getConfigData", "()Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$ConfigData;", "configData$delegate", "Lkotlin/Lazy;", "getDefaultSug", "()Ljava/util/List;", "getGreetingInfo", "()Ljava/util/Map;", "getNoPermissionPrompt", "()Ljava/lang/String;", "switchData", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$SwitchData;", "getSwitchData", "()Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$SwitchData;", "switchData$delegate", "getTopicInfo", "setTopicInfo", "(Ljava/util/List;)V", "userInfo", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$UserInfo;", "getUserInfo", "()Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$UserInfo;", "userInfo$delegate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "ConfigData", "SwitchData", "TopicInfo", "UserInfo", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatDetail implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("audit_status")
    public int auditStatus;
    public final Lazy configData$delegate;
    @SerializedName("config")
    public final Map<String, Object> configDataMap;
    @SerializedName("default_sug")
    public final List<AbilityItem> defaultSug;
    @SerializedName("greeting_info")
    public final Map<String, Object> greetingInfo;
    @SerializedName("no_permission_prompt")
    public final String noPermissionPrompt;
    public final Lazy switchData$delegate;
    @SerializedName("switch")
    public final Map<String, Object> switchDataMap;
    @SerializedName("topic_info")
    public List<TopicInfo> topicInfo;
    public final Lazy userInfo$delegate;
    @SerializedName(SourceConstant.SOURCE_USER_INFO)
    public final Map<String, Object> userInfoMap;

    private final Map<String, Object> component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.userInfoMap : (Map) invokeV.objValue;
    }

    private final Map<String, Object> component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.configDataMap : (Map) invokeV.objValue;
    }

    private final Map<String, Object> component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? this.switchDataMap : (Map) invokeV.objValue;
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.noPermissionPrompt : (String) invokeV.objValue;
    }

    public final List<TopicInfo> component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.topicInfo : (List) invokeV.objValue;
    }

    public final List<AbilityItem> component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.defaultSug : (List) invokeV.objValue;
    }

    public final Map<String, Object> component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.greetingInfo : (Map) invokeV.objValue;
    }

    public final int component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.auditStatus : invokeV.intValue;
    }

    public final AibotChatDetail copy(String str, Map<String, ? extends Object> userInfoMap, List<TopicInfo> topicInfo, List<AbilityItem> list, Map<String, ? extends Object> greetingInfo, Map<String, ? extends Object> configDataMap, Map<String, ? extends Object> switchDataMap, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, userInfoMap, topicInfo, list, greetingInfo, configDataMap, switchDataMap, Integer.valueOf(i)})) == null) {
            Intrinsics.checkNotNullParameter(userInfoMap, "userInfoMap");
            Intrinsics.checkNotNullParameter(topicInfo, "topicInfo");
            Intrinsics.checkNotNullParameter(greetingInfo, "greetingInfo");
            Intrinsics.checkNotNullParameter(configDataMap, "configDataMap");
            Intrinsics.checkNotNullParameter(switchDataMap, "switchDataMap");
            return new AibotChatDetail(str, userInfoMap, topicInfo, list, greetingInfo, configDataMap, switchDataMap, i);
        }
        return (AibotChatDetail) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AibotChatDetail) {
                AibotChatDetail aibotChatDetail = (AibotChatDetail) obj;
                return Intrinsics.areEqual(this.noPermissionPrompt, aibotChatDetail.noPermissionPrompt) && Intrinsics.areEqual(this.userInfoMap, aibotChatDetail.userInfoMap) && Intrinsics.areEqual(this.topicInfo, aibotChatDetail.topicInfo) && Intrinsics.areEqual(this.defaultSug, aibotChatDetail.defaultSug) && Intrinsics.areEqual(this.greetingInfo, aibotChatDetail.greetingInfo) && Intrinsics.areEqual(this.configDataMap, aibotChatDetail.configDataMap) && Intrinsics.areEqual(this.switchDataMap, aibotChatDetail.switchDataMap) && this.auditStatus == aibotChatDetail.auditStatus;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            String str = this.noPermissionPrompt;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.userInfoMap.hashCode()) * 31) + this.topicInfo.hashCode()) * 31;
            List<AbilityItem> list = this.defaultSug;
            return ((((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.greetingInfo.hashCode()) * 31) + this.configDataMap.hashCode()) * 31) + this.switchDataMap.hashCode()) * 31) + this.auditStatus;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "AibotChatDetail(noPermissionPrompt=" + this.noPermissionPrompt + ", userInfoMap=" + this.userInfoMap + ", topicInfo=" + this.topicInfo + ", defaultSug=" + this.defaultSug + ", greetingInfo=" + this.greetingInfo + ", configDataMap=" + this.configDataMap + ", switchDataMap=" + this.switchDataMap + ", auditStatus=" + this.auditStatus + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0095\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0006HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a¨\u00068"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$ConfigData;", "Ljava/io/Serializable;", "inputBoxPromptText", "", "loadingText", "notFirstGreetingInterval", "", "restartDialogueInterval", AiBotChatDispatcher.AI_SINGLE_THEME_COLOR, "defaultAnswer", "timeout", "msgNumForSug", "chatBackground", "bubbleBgColor", "sugTextColor", "tagColor", "person_pic", "person_background", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBubbleBgColor", "()Ljava/lang/String;", "getChatBackground", "getDefaultAnswer", "getInputBoxPromptText", "getLoadingText", "getMsgNumForSug", "()I", "getNotFirstGreetingInterval", "getPerson_background", "getPerson_pic", "getRestartDialogueInterval", "getSugTextColor", "getTagColor", "getThemeColor", "getTimeout", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        @SerializedName("person_background")
        public final String person_background;
        @SerializedName("person_pic")
        public final String person_pic;
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

        public final String component13() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.person_pic : (String) invokeV.objValue;
        }

        public final String component14() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.person_background : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.loadingText : (String) invokeV.objValue;
        }

        public final int component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.notFirstGreetingInterval : invokeV.intValue;
        }

        public final int component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.restartDialogueInterval : invokeV.intValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.themeColor : (String) invokeV.objValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.defaultAnswer : (String) invokeV.objValue;
        }

        public final int component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.timeout : invokeV.intValue;
        }

        public final int component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.msgNumForSug : invokeV.intValue;
        }

        public final String component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.chatBackground : (String) invokeV.objValue;
        }

        public final ConfigData copy(String inputBoxPromptText, String loadingText, int i, int i2, String themeColor, String defaultAnswer, int i3, int i4, String chatBackground, String bubbleBgColor, String sugTextColor, String tagColor, String person_pic, String person_background) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{inputBoxPromptText, loadingText, Integer.valueOf(i), Integer.valueOf(i2), themeColor, defaultAnswer, Integer.valueOf(i3), Integer.valueOf(i4), chatBackground, bubbleBgColor, sugTextColor, tagColor, person_pic, person_background})) == null) {
                Intrinsics.checkNotNullParameter(inputBoxPromptText, "inputBoxPromptText");
                Intrinsics.checkNotNullParameter(loadingText, "loadingText");
                Intrinsics.checkNotNullParameter(themeColor, "themeColor");
                Intrinsics.checkNotNullParameter(defaultAnswer, "defaultAnswer");
                Intrinsics.checkNotNullParameter(chatBackground, "chatBackground");
                Intrinsics.checkNotNullParameter(bubbleBgColor, "bubbleBgColor");
                Intrinsics.checkNotNullParameter(sugTextColor, "sugTextColor");
                Intrinsics.checkNotNullParameter(tagColor, "tagColor");
                Intrinsics.checkNotNullParameter(person_pic, "person_pic");
                Intrinsics.checkNotNullParameter(person_background, "person_background");
                return new ConfigData(inputBoxPromptText, loadingText, i, i2, themeColor, defaultAnswer, i3, i4, chatBackground, bubbleBgColor, sugTextColor, tagColor, person_pic, person_background);
            }
            return (ConfigData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ConfigData) {
                    ConfigData configData = (ConfigData) obj;
                    return Intrinsics.areEqual(this.inputBoxPromptText, configData.inputBoxPromptText) && Intrinsics.areEqual(this.loadingText, configData.loadingText) && this.notFirstGreetingInterval == configData.notFirstGreetingInterval && this.restartDialogueInterval == configData.restartDialogueInterval && Intrinsics.areEqual(this.themeColor, configData.themeColor) && Intrinsics.areEqual(this.defaultAnswer, configData.defaultAnswer) && this.timeout == configData.timeout && this.msgNumForSug == configData.msgNumForSug && Intrinsics.areEqual(this.chatBackground, configData.chatBackground) && Intrinsics.areEqual(this.bubbleBgColor, configData.bubbleBgColor) && Intrinsics.areEqual(this.sugTextColor, configData.sugTextColor) && Intrinsics.areEqual(this.tagColor, configData.tagColor) && Intrinsics.areEqual(this.person_pic, configData.person_pic) && Intrinsics.areEqual(this.person_background, configData.person_background);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? (((((((((((((((((((((((((this.inputBoxPromptText.hashCode() * 31) + this.loadingText.hashCode()) * 31) + this.notFirstGreetingInterval) * 31) + this.restartDialogueInterval) * 31) + this.themeColor.hashCode()) * 31) + this.defaultAnswer.hashCode()) * 31) + this.timeout) * 31) + this.msgNumForSug) * 31) + this.chatBackground.hashCode()) * 31) + this.bubbleBgColor.hashCode()) * 31) + this.sugTextColor.hashCode()) * 31) + this.tagColor.hashCode()) * 31) + this.person_pic.hashCode()) * 31) + this.person_background.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                return "ConfigData(inputBoxPromptText=" + this.inputBoxPromptText + ", loadingText=" + this.loadingText + ", notFirstGreetingInterval=" + this.notFirstGreetingInterval + ", restartDialogueInterval=" + this.restartDialogueInterval + ", themeColor=" + this.themeColor + ", defaultAnswer=" + this.defaultAnswer + ", timeout=" + this.timeout + ", msgNumForSug=" + this.msgNumForSug + ", chatBackground=" + this.chatBackground + ", bubbleBgColor=" + this.bubbleBgColor + ", sugTextColor=" + this.sugTextColor + ", tagColor=" + this.tagColor + ", person_pic=" + this.person_pic + ", person_background=" + this.person_background + ')';
            }
            return (String) invokeV.objValue;
        }

        public ConfigData(String inputBoxPromptText, String loadingText, int i, int i2, String themeColor, String defaultAnswer, int i3, int i4, String chatBackground, String bubbleBgColor, String sugTextColor, String tagColor, String person_pic, String person_background) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {inputBoxPromptText, loadingText, Integer.valueOf(i), Integer.valueOf(i2), themeColor, defaultAnswer, Integer.valueOf(i3), Integer.valueOf(i4), chatBackground, bubbleBgColor, sugTextColor, tagColor, person_pic, person_background};
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
            Intrinsics.checkNotNullParameter(person_pic, "person_pic");
            Intrinsics.checkNotNullParameter(person_background, "person_background");
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
            this.person_pic = person_pic;
            this.person_background = person_background;
        }

        public final String getBubbleBgColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.bubbleBgColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getChatBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.chatBackground;
            }
            return (String) invokeV.objValue;
        }

        public final String getDefaultAnswer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.defaultAnswer;
            }
            return (String) invokeV.objValue;
        }

        public final String getInputBoxPromptText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.inputBoxPromptText;
            }
            return (String) invokeV.objValue;
        }

        public final String getLoadingText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.loadingText;
            }
            return (String) invokeV.objValue;
        }

        public final int getMsgNumForSug() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.msgNumForSug;
            }
            return invokeV.intValue;
        }

        public final int getNotFirstGreetingInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.notFirstGreetingInterval;
            }
            return invokeV.intValue;
        }

        public final String getPerson_background() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.person_background;
            }
            return (String) invokeV.objValue;
        }

        public final String getPerson_pic() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.person_pic;
            }
            return (String) invokeV.objValue;
        }

        public final int getRestartDialogueInterval() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return this.restartDialogueInterval;
            }
            return invokeV.intValue;
        }

        public final String getSugTextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.sugTextColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getTagColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.tagColor;
            }
            return (String) invokeV.objValue;
        }

        public final String getThemeColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.themeColor;
            }
            return (String) invokeV.objValue;
        }

        public final int getTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return this.timeout;
            }
            return invokeV.intValue;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006&"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$SwitchData;", "Ljava/io/Serializable;", "enableSug", "", "enableShowNotFirstGreeting", "enableRestartDialogue", "enableLoading", "enableTypewriter", "showHot", "enableNewHomepage", "", "enableHideKeyboard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getEnableHideKeyboard", "()I", "getEnableLoading", "()Ljava/lang/String;", "getEnableNewHomepage", "getEnableRestartDialogue", "getEnableShowNotFirstGreeting", "getEnableSug", "getEnableTypewriter", "getShowHot", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class SwitchData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("enable_hide_keyboard")
        public final int enableHideKeyboard;
        @SerializedName("enable_loading")
        public final String enableLoading;
        @SerializedName("enable_new_homepage")
        public final int enableNewHomepage;
        @SerializedName("enable_restart_dialogue")
        public final String enableRestartDialogue;
        @SerializedName("enable_show_not_first_greeting")
        public final String enableShowNotFirstGreeting;
        @SerializedName("enable_sug")
        public final String enableSug;
        @SerializedName("enable_typewriter")
        public final String enableTypewriter;
        @SerializedName("show_hot")
        public final String showHot;

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.enableSug : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.enableShowNotFirstGreeting : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.enableRestartDialogue : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.enableLoading : (String) invokeV.objValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.enableTypewriter : (String) invokeV.objValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.showHot : (String) invokeV.objValue;
        }

        public final int component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.enableNewHomepage : invokeV.intValue;
        }

        public final int component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.enableHideKeyboard : invokeV.intValue;
        }

        public final SwitchData copy(String enableSug, String enableShowNotFirstGreeting, String enableRestartDialogue, String enableLoading, String enableTypewriter, String showHot, int i, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{enableSug, enableShowNotFirstGreeting, enableRestartDialogue, enableLoading, enableTypewriter, showHot, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                Intrinsics.checkNotNullParameter(enableSug, "enableSug");
                Intrinsics.checkNotNullParameter(enableShowNotFirstGreeting, "enableShowNotFirstGreeting");
                Intrinsics.checkNotNullParameter(enableRestartDialogue, "enableRestartDialogue");
                Intrinsics.checkNotNullParameter(enableLoading, "enableLoading");
                Intrinsics.checkNotNullParameter(enableTypewriter, "enableTypewriter");
                Intrinsics.checkNotNullParameter(showHot, "showHot");
                return new SwitchData(enableSug, enableShowNotFirstGreeting, enableRestartDialogue, enableLoading, enableTypewriter, showHot, i, i2);
            }
            return (SwitchData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SwitchData) {
                    SwitchData switchData = (SwitchData) obj;
                    return Intrinsics.areEqual(this.enableSug, switchData.enableSug) && Intrinsics.areEqual(this.enableShowNotFirstGreeting, switchData.enableShowNotFirstGreeting) && Intrinsics.areEqual(this.enableRestartDialogue, switchData.enableRestartDialogue) && Intrinsics.areEqual(this.enableLoading, switchData.enableLoading) && Intrinsics.areEqual(this.enableTypewriter, switchData.enableTypewriter) && Intrinsics.areEqual(this.showHot, switchData.showHot) && this.enableNewHomepage == switchData.enableNewHomepage && this.enableHideKeyboard == switchData.enableHideKeyboard;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (((((((((((((this.enableSug.hashCode() * 31) + this.enableShowNotFirstGreeting.hashCode()) * 31) + this.enableRestartDialogue.hashCode()) * 31) + this.enableLoading.hashCode()) * 31) + this.enableTypewriter.hashCode()) * 31) + this.showHot.hashCode()) * 31) + this.enableNewHomepage) * 31) + this.enableHideKeyboard : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return "SwitchData(enableSug=" + this.enableSug + ", enableShowNotFirstGreeting=" + this.enableShowNotFirstGreeting + ", enableRestartDialogue=" + this.enableRestartDialogue + ", enableLoading=" + this.enableLoading + ", enableTypewriter=" + this.enableTypewriter + ", showHot=" + this.showHot + ", enableNewHomepage=" + this.enableNewHomepage + ", enableHideKeyboard=" + this.enableHideKeyboard + ')';
            }
            return (String) invokeV.objValue;
        }

        public SwitchData(String enableSug, String enableShowNotFirstGreeting, String enableRestartDialogue, String enableLoading, String enableTypewriter, String showHot, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enableSug, enableShowNotFirstGreeting, enableRestartDialogue, enableLoading, enableTypewriter, showHot, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(enableSug, "enableSug");
            Intrinsics.checkNotNullParameter(enableShowNotFirstGreeting, "enableShowNotFirstGreeting");
            Intrinsics.checkNotNullParameter(enableRestartDialogue, "enableRestartDialogue");
            Intrinsics.checkNotNullParameter(enableLoading, "enableLoading");
            Intrinsics.checkNotNullParameter(enableTypewriter, "enableTypewriter");
            Intrinsics.checkNotNullParameter(showHot, "showHot");
            this.enableSug = enableSug;
            this.enableShowNotFirstGreeting = enableShowNotFirstGreeting;
            this.enableRestartDialogue = enableRestartDialogue;
            this.enableLoading = enableLoading;
            this.enableTypewriter = enableTypewriter;
            this.showHot = showHot;
            this.enableNewHomepage = i;
            this.enableHideKeyboard = i2;
        }

        public final int getEnableHideKeyboard() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.enableHideKeyboard;
            }
            return invokeV.intValue;
        }

        public final String getEnableLoading() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.enableLoading;
            }
            return (String) invokeV.objValue;
        }

        public final int getEnableNewHomepage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.enableNewHomepage;
            }
            return invokeV.intValue;
        }

        public final String getEnableRestartDialogue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.enableRestartDialogue;
            }
            return (String) invokeV.objValue;
        }

        public final String getEnableShowNotFirstGreeting() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.enableShowNotFirstGreeting;
            }
            return (String) invokeV.objValue;
        }

        public final String getEnableSug() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.enableSug;
            }
            return (String) invokeV.objValue;
        }

        public final String getEnableTypewriter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.enableTypewriter;
            }
            return (String) invokeV.objValue;
        }

        public final String getShowHot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.showHot;
            }
            return (String) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$TopicInfo;", "Ljava/io/Serializable;", "topicName", "", "sugList", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getSugList", "()Ljava/util/List;", "setSugList", "(Ljava/util/List;)V", "getTopicName", "()Ljava/lang/String;", "setTopicName", "(Ljava/lang/String;)V", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class TopicInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("sug_list")
        public List<AbilityItem> sugList;
        @SerializedName("name")
        public String topicName;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.im.biz.aibot.data.AibotChatDetail$TopicInfo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TopicInfo copy$default(TopicInfo topicInfo, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = topicInfo.topicName;
            }
            if ((i & 2) != 0) {
                list = topicInfo.sugList;
            }
            return topicInfo.copy(str, list);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.topicName : (String) invokeV.objValue;
        }

        public final List<AbilityItem> component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sugList : (List) invokeV.objValue;
        }

        public final TopicInfo copy(String topicName, List<AbilityItem> sugList) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, topicName, sugList)) == null) {
                Intrinsics.checkNotNullParameter(topicName, "topicName");
                Intrinsics.checkNotNullParameter(sugList, "sugList");
                return new TopicInfo(topicName, sugList);
            }
            return (TopicInfo) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TopicInfo) {
                    TopicInfo topicInfo = (TopicInfo) obj;
                    return Intrinsics.areEqual(this.topicName, topicInfo.topicName) && Intrinsics.areEqual(this.sugList, topicInfo.sugList);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.topicName.hashCode() * 31) + this.sugList.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "TopicInfo(topicName=" + this.topicName + ", sugList=" + this.sugList + ')';
            }
            return (String) invokeV.objValue;
        }

        public TopicInfo(String topicName, List<AbilityItem> sugList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicName, sugList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(topicName, "topicName");
            Intrinsics.checkNotNullParameter(sugList, "sugList");
            this.topicName = topicName;
            this.sugList = sugList;
        }

        public final List<AbilityItem> getSugList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.sugList;
            }
            return (List) invokeV.objValue;
        }

        public final String getTopicName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.topicName;
            }
            return (String) invokeV.objValue;
        }

        public final void setSugList(List<AbilityItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.sugList = list;
            }
        }

        public final void setTopicName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.topicName = str;
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u001b\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000bHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0089\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00064"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$UserInfo;", "Ljava/io/Serializable;", "uk", "", "paid", "", "name", "portrait", "gender", "", TaskProcess.keyTags, "", "", "", "dialogNum", "createUname", "description", "relation", "label", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreateUname", "()Ljava/lang/String;", "getDescription", "getDialogNum", "()I", "getGender", "getLabel", "getName", "getPaid", "()J", "getPortrait", "getRelation", "getTags", "()Ljava/util/List;", "getUk", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class UserInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("create_uname")
        public final String createUname;
        @SerializedName("description")
        public final String description;
        @SerializedName("dialog_num")
        public final int dialogNum;
        public final int gender;
        @SerializedName("label")
        public final String label;
        public final String name;
        @SerializedName("pa")
        public final long paid;
        public final String portrait;
        @SerializedName("relation")
        public final String relation;
        public final List<Map<String, Object>> tags;
        public final String uk;

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.uk : (String) invokeV.objValue;
        }

        public final String component10() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.relation : (String) invokeV.objValue;
        }

        public final String component11() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.label : (String) invokeV.objValue;
        }

        public final long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.paid : invokeV.longValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.name : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.portrait : (String) invokeV.objValue;
        }

        public final int component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.gender : invokeV.intValue;
        }

        public final List<Map<String, Object>> component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.tags : (List) invokeV.objValue;
        }

        public final int component7() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.dialogNum : invokeV.intValue;
        }

        public final String component8() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.createUname : (String) invokeV.objValue;
        }

        public final String component9() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.description : (String) invokeV.objValue;
        }

        public final UserInfo copy(String uk, long j, String name, String portrait, int i, List<? extends Map<String, ? extends Object>> tags, int i2, String createUname, String description, String relation, String label) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{uk, Long.valueOf(j), name, portrait, Integer.valueOf(i), tags, Integer.valueOf(i2), createUname, description, relation, label})) == null) {
                Intrinsics.checkNotNullParameter(uk, "uk");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(portrait, "portrait");
                Intrinsics.checkNotNullParameter(tags, "tags");
                Intrinsics.checkNotNullParameter(createUname, "createUname");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(relation, "relation");
                Intrinsics.checkNotNullParameter(label, "label");
                return new UserInfo(uk, j, name, portrait, i, tags, i2, createUname, description, relation, label);
            }
            return (UserInfo) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UserInfo) {
                    UserInfo userInfo = (UserInfo) obj;
                    return Intrinsics.areEqual(this.uk, userInfo.uk) && this.paid == userInfo.paid && Intrinsics.areEqual(this.name, userInfo.name) && Intrinsics.areEqual(this.portrait, userInfo.portrait) && this.gender == userInfo.gender && Intrinsics.areEqual(this.tags, userInfo.tags) && this.dialogNum == userInfo.dialogNum && Intrinsics.areEqual(this.createUname, userInfo.createUname) && Intrinsics.areEqual(this.description, userInfo.description) && Intrinsics.areEqual(this.relation, userInfo.relation) && Intrinsics.areEqual(this.label, userInfo.label);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? (((((((((((((((((((this.uk.hashCode() * 31) + b.a(this.paid)) * 31) + this.name.hashCode()) * 31) + this.portrait.hashCode()) * 31) + this.gender) * 31) + this.tags.hashCode()) * 31) + this.dialogNum) * 31) + this.createUname.hashCode()) * 31) + this.description.hashCode()) * 31) + this.relation.hashCode()) * 31) + this.label.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                return "UserInfo(uk=" + this.uk + ", paid=" + this.paid + ", name=" + this.name + ", portrait=" + this.portrait + ", gender=" + this.gender + ", tags=" + this.tags + ", dialogNum=" + this.dialogNum + ", createUname=" + this.createUname + ", description=" + this.description + ", relation=" + this.relation + ", label=" + this.label + ')';
            }
            return (String) invokeV.objValue;
        }

        public UserInfo(String uk, long j, String name, String portrait, int i, List<? extends Map<String, ? extends Object>> tags, int i2, String createUname, String description, String relation, String label) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {uk, Long.valueOf(j), name, portrait, Integer.valueOf(i), tags, Integer.valueOf(i2), createUname, description, relation, label};
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
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(relation, "relation");
            Intrinsics.checkNotNullParameter(label, "label");
            this.uk = uk;
            this.paid = j;
            this.name = name;
            this.portrait = portrait;
            this.gender = i;
            this.tags = tags;
            this.dialogNum = i2;
            this.createUname = createUname;
            this.description = description;
            this.relation = relation;
            this.label = label;
        }

        public final String getCreateUname() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.createUname;
            }
            return (String) invokeV.objValue;
        }

        public final String getDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.description;
            }
            return (String) invokeV.objValue;
        }

        public final int getDialogNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.dialogNum;
            }
            return invokeV.intValue;
        }

        public final int getGender() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.gender;
            }
            return invokeV.intValue;
        }

        public final String getLabel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.label;
            }
            return (String) invokeV.objValue;
        }

        public final String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }

        public final long getPaid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.paid;
            }
            return invokeV.longValue;
        }

        public final String getPortrait() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.portrait;
            }
            return (String) invokeV.objValue;
        }

        public final String getRelation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return this.relation;
            }
            return (String) invokeV.objValue;
        }

        public final List<Map<String, Object>> getTags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.tags;
            }
            return (List) invokeV.objValue;
        }

        public final String getUk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                return this.uk;
            }
            return (String) invokeV.objValue;
        }
    }

    public AibotChatDetail(String str, Map<String, ? extends Object> userInfoMap, List<TopicInfo> topicInfo, List<AbilityItem> list, Map<String, ? extends Object> greetingInfo, Map<String, ? extends Object> configDataMap, Map<String, ? extends Object> switchDataMap, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, userInfoMap, topicInfo, list, greetingInfo, configDataMap, switchDataMap, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(userInfoMap, "userInfoMap");
        Intrinsics.checkNotNullParameter(topicInfo, "topicInfo");
        Intrinsics.checkNotNullParameter(greetingInfo, "greetingInfo");
        Intrinsics.checkNotNullParameter(configDataMap, "configDataMap");
        Intrinsics.checkNotNullParameter(switchDataMap, "switchDataMap");
        this.noPermissionPrompt = str;
        this.userInfoMap = userInfoMap;
        this.topicInfo = topicInfo;
        this.defaultSug = list;
        this.greetingInfo = greetingInfo;
        this.configDataMap = configDataMap;
        this.switchDataMap = switchDataMap;
        this.auditStatus = i;
        this.userInfo$delegate = LazyKt__LazyJVMKt.lazy(new Function0<UserInfo>(this) { // from class: com.baidu.tieba.im.biz.aibot.data.AibotChatDetail$userInfo$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AibotChatDetail this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AibotChatDetail.UserInfo invoke() {
                InterceptResult invokeV;
                Map map;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (AibotChatDetail.UserInfo) invokeV.objValue;
                }
                map = this.this$0.userInfoMap;
                return (AibotChatDetail.UserInfo) DataExt.toEntity(map, AibotChatDetail.UserInfo.class);
            }
        });
        this.configData$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ConfigData>(this) { // from class: com.baidu.tieba.im.biz.aibot.data.AibotChatDetail$configData$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AibotChatDetail this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AibotChatDetail.ConfigData invoke() {
                InterceptResult invokeV;
                Map map;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (AibotChatDetail.ConfigData) invokeV.objValue;
                }
                map = this.this$0.configDataMap;
                return (AibotChatDetail.ConfigData) DataExt.toEntity(map, AibotChatDetail.ConfigData.class);
            }
        });
        this.switchData$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SwitchData>(this) { // from class: com.baidu.tieba.im.biz.aibot.data.AibotChatDetail$switchData$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AibotChatDetail this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AibotChatDetail.SwitchData invoke() {
                InterceptResult invokeV;
                Map map;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (AibotChatDetail.SwitchData) invokeV.objValue;
                }
                map = this.this$0.switchDataMap;
                return (AibotChatDetail.SwitchData) DataExt.toEntity(map, AibotChatDetail.SwitchData.class);
            }
        });
    }

    public final void setAuditStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.auditStatus = i;
        }
    }

    public final void setTopicInfo(List<TopicInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.topicInfo = list;
        }
    }

    public final int getAuditStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.auditStatus;
        }
        return invokeV.intValue;
    }

    public final ConfigData getConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (ConfigData) this.configData$delegate.getValue();
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

    public final SwitchData getSwitchData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (SwitchData) this.switchData$delegate.getValue();
        }
        return (SwitchData) invokeV.objValue;
    }

    public final List<TopicInfo> getTopicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.topicInfo;
        }
        return (List) invokeV.objValue;
    }

    public final UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (UserInfo) this.userInfo$delegate.getValue();
        }
        return (UserInfo) invokeV.objValue;
    }
}
