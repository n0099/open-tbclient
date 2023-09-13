package com.baidu.tieba.im.biz.aibot.chatslice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ad8;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.ei;
import com.baidu.tieba.im.biz.aibot.AibotChatRepo;
import com.baidu.tieba.im.biz.aibot.chatslice.ChatSlice;
import com.baidu.tieba.im.biz.aibot.data.AibotArgs;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.mo8;
import com.baidu.tieba.o05;
import com.baidu.tieba.oc8;
import com.baidu.tieba.qc8;
import com.baidu.tieba.rj6;
import com.baidu.tieba.tya;
import com.baidu.tieba.uya;
import com.baidu.tieba.wya;
import com.baidu.tieba.zc8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001#\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0004HIJKB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001dJ\b\u00100\u001a\u00020.H\u0002J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0016J\"\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020.H\u0016J\b\u0010<\u001a\u00020.H\u0016J\b\u0010=\u001a\u00020.H\u0016J\u0010\u0010>\u001a\u00020.2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u0019H\u0016J\u001c\u0010B\u001a\u00020.2\b\u0010C\u001a\u0004\u0018\u0001042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010D\u001a\u00020.H\u0002J\u0012\u0010E\u001a\u00020.2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010GR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006L"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "botUk", "", "repo", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "argsData", "Lcom/baidu/tieba/im/biz/aibot/data/AibotArgs;", "(Ljava/lang/String;Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;Lcom/baidu/tieba/im/biz/aibot/data/AibotArgs;)V", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "h5Sender", "Lcom/baidu/tieba/im/biz/aibot/helper/H5Sender;", "getH5Sender", "()Lcom/baidu/tieba/im/biz/aibot/helper/H5Sender;", "setH5Sender", "(Lcom/baidu/tieba/im/biz/aibot/helper/H5Sender;)V", "initData", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData;", "getInitData", "()Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData;", "initData$delegate", "Lkotlin/Lazy;", "isWebViewReady", "", "mPageState", "", "mTTSExt", "Lorg/json/JSONObject;", "mTTSHelper", "Lcom/baidu/tieba/voice/tts/TtsApi;", "mTTSListenerAdapter", "Lcom/baidu/tieba/voice/tts/TtsListener$TtsListenerAdapter;", "onWebViewReady", "com/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$onWebViewReady$1", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$onWebViewReady$1;", "getRepo", "()Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "getWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "setWebView", "(Lcom/baidu/tieba/browser/TbWebView;)V", "dealVoiceByMsgInTTS", "", "params", "initInjectBizData", "loadUrl", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "onSetChatDetail", "onSetPageState", "state", "refreshPage", "onViewCreated", "view", "trySetChatDetailToH5", "trySetPageStateToH5", "pageStateExt", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$PageStateExt;", "Companion", "InitData", "PageStateExt", "VisitedBotSet", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatSlice extends Slice implements qc8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String v;
    public static final a w;
    public transient /* synthetic */ FieldHolder $fh;
    public final String j;
    public final AibotArgs k;
    public TbWebView l;
    public ad8 m;
    public AibotChatDetail n;
    public boolean o;
    public final tya p;
    public JSONObject q;
    public int r;
    public final d s;
    public final Lazy t;
    public final uya.a u;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData;", "Ljava/io/Serializable;", "isColdStart", "", "userInfo", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;", "topicText", "", "sugText", "(ILcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;Ljava/lang/String;Ljava/lang/String;)V", "()I", "getSugText", "()Ljava/lang/String;", "getTopicText", "getUserInfo", "()Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "UserInfo", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class InitData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("is_cold_start")
        public final int isColdStart;
        @SerializedName("sug_text")
        public final String sugText;
        @SerializedName("topic_text")
        public final String topicText;
        @SerializedName(SourceConstant.SOURCE_USER_INFO)
        public final UserInfo userInfo;

        public static /* synthetic */ InitData copy$default(InitData initData, int i, UserInfo userInfo, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = initData.isColdStart;
            }
            if ((i2 & 2) != 0) {
                userInfo = initData.userInfo;
            }
            if ((i2 & 4) != 0) {
                str = initData.topicText;
            }
            if ((i2 & 8) != 0) {
                str2 = initData.sugText;
            }
            return initData.copy(i, userInfo, str, str2);
        }

        public final int component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isColdStart : invokeV.intValue;
        }

        public final UserInfo component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.userInfo : (UserInfo) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.topicText : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sugText : (String) invokeV.objValue;
        }

        public final InitData copy(int i, UserInfo userInfo, String str, String str2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), userInfo, str, str2})) == null) {
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                return new InitData(i, userInfo, str, str2);
            }
            return (InitData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof InitData) {
                    InitData initData = (InitData) obj;
                    return this.isColdStart == initData.isColdStart && Intrinsics.areEqual(this.userInfo, initData.userInfo) && Intrinsics.areEqual(this.topicText, initData.topicText) && Intrinsics.areEqual(this.sugText, initData.sugText);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int hashCode = ((this.isColdStart * 31) + this.userInfo.hashCode()) * 31;
                String str = this.topicText;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.sugText;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "InitData(isColdStart=" + this.isColdStart + ", userInfo=" + this.userInfo + ", topicText=" + this.topicText + ", sugText=" + this.sugText + ')';
            }
            return (String) invokeV.objValue;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;", "Ljava/io/Serializable;", "uk", "", TbEnum.SystemMessage.KEY_USER_NAME, "portrait", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPortrait", "()Ljava/lang/String;", "getUk", "getUserName", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class UserInfo implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final String portrait;
            public final String uk;
            @SerializedName("user_name")
            public final String userName;

            public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = userInfo.uk;
                }
                if ((i & 2) != 0) {
                    str2 = userInfo.userName;
                }
                if ((i & 4) != 0) {
                    str3 = userInfo.portrait;
                }
                return userInfo.copy(str, str2, str3);
            }

            public final String component1() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.uk : (String) invokeV.objValue;
            }

            public final String component2() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.userName : (String) invokeV.objValue;
            }

            public final String component3() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.portrait : (String) invokeV.objValue;
            }

            public final UserInfo copy(String uk, String userName, String portrait) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, uk, userName, portrait)) == null) {
                    Intrinsics.checkNotNullParameter(uk, "uk");
                    Intrinsics.checkNotNullParameter(userName, "userName");
                    Intrinsics.checkNotNullParameter(portrait, "portrait");
                    return new UserInfo(uk, userName, portrait);
                }
                return (UserInfo) invokeLLL.objValue;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof UserInfo) {
                        UserInfo userInfo = (UserInfo) obj;
                        return Intrinsics.areEqual(this.uk, userInfo.uk) && Intrinsics.areEqual(this.userName, userInfo.userName) && Intrinsics.areEqual(this.portrait, userInfo.portrait);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((this.uk.hashCode() * 31) + this.userName.hashCode()) * 31) + this.portrait.hashCode() : invokeV.intValue;
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return "UserInfo(uk=" + this.uk + ", userName=" + this.userName + ", portrait=" + this.portrait + ')';
                }
                return (String) invokeV.objValue;
            }

            public UserInfo(String uk, String userName, String portrait) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {uk, userName, portrait};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                Intrinsics.checkNotNullParameter(uk, "uk");
                Intrinsics.checkNotNullParameter(userName, "userName");
                Intrinsics.checkNotNullParameter(portrait, "portrait");
                this.uk = uk;
                this.userName = userName;
                this.portrait = portrait;
            }

            public final String getPortrait() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.portrait;
                }
                return (String) invokeV.objValue;
            }

            public final String getUk() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return this.uk;
                }
                return (String) invokeV.objValue;
            }

            public final String getUserName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.userName;
                }
                return (String) invokeV.objValue;
            }
        }

        public InitData(int i, UserInfo userInfo, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), userInfo, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            this.isColdStart = i;
            this.userInfo = userInfo;
            this.topicText = str;
            this.sugText = str2;
        }

        public /* synthetic */ InitData(int i, UserInfo userInfo, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, userInfo, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2);
        }

        public final String getSugText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.sugText;
            }
            return (String) invokeV.objValue;
        }

        public final String getTopicText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.topicText;
            }
            return (String) invokeV.objValue;
        }

        public final UserInfo getUserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.userInfo;
            }
            return (UserInfo) invokeV.objValue;
        }

        public final int isColdStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.isColdStart;
            }
            return invokeV.intValue;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$PageStateExt;", "Ljava/io/Serializable;", "topicText", "", "sugText", "(Ljava/lang/String;Ljava/lang/String;)V", "getSugText", "()Ljava/lang/String;", "getTopicText", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PageStateExt implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("user_sug")
        public final String sugText;
        @SerializedName("bot_topic")
        public final String topicText;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PageStateExt() {
            this(null, null, 3, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static /* synthetic */ PageStateExt copy$default(PageStateExt pageStateExt, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageStateExt.topicText;
            }
            if ((i & 2) != 0) {
                str2 = pageStateExt.sugText;
            }
            return pageStateExt.copy(str, str2);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.topicText : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.sugText : (String) invokeV.objValue;
        }

        public final PageStateExt copy(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) ? new PageStateExt(str, str2) : (PageStateExt) invokeLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PageStateExt) {
                    PageStateExt pageStateExt = (PageStateExt) obj;
                    return Intrinsics.areEqual(this.topicText, pageStateExt.topicText) && Intrinsics.areEqual(this.sugText, pageStateExt.sugText);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String str = this.topicText;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.sugText;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "PageStateExt(topicText=" + this.topicText + ", sugText=" + this.sugText + ')';
            }
            return (String) invokeV.objValue;
        }

        public PageStateExt(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.topicText = str;
            this.sugText = str2;
        }

        public /* synthetic */ PageStateExt(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getSugText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.sugText;
            }
            return (String) invokeV.objValue;
        }

        public final String getTopicText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.topicText;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<String> a;

        public a() {
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
            this.a = new LinkedHashSet();
        }

        public final boolean a(String botUk) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, botUk)) == null) {
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                return this.a.contains(botUk);
            }
            return invokeL.booleanValue;
        }

        public final void b(String botUk) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, botUk) == null) {
                Intrinsics.checkNotNullParameter(botUk, "botUk");
                this.a.add(botUk);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements rj6<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatSlice a;

        public b(ChatSlice chatSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
        public JSONObject call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new JSONObject(DataExt.toJson(this.a.j0()));
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends uya.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatSlice a;

        public c(ChatSlice chatSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = chatSlice;
        }

        @Override // com.baidu.tieba.uya.a, com.baidu.tieba.uya
        public void a(String speakerId, int i, String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, speakerId, i, errMsg) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                HashMap<String, Object> hashMap = new HashMap<>();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("statusCode", String.valueOf(i));
                hashMap2.put("statusDescription", errMsg);
                hashMap.put("actionStatus", "1200");
                hashMap.put("statusInfo", hashMap2);
                if (this.a.q != null) {
                    JSONObject jSONObject = this.a.q;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.i0().a("handleAudioMsgByTTS", hashMap);
                super.a(speakerId, i, errMsg);
            }
        }

        @Override // com.baidu.tieba.uya.a, com.baidu.tieba.uya
        public void b(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("actionStatus", "1005");
                if (this.a.q != null) {
                    JSONObject jSONObject = this.a.q;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.i0().a("handleAudioMsgByTTS", hashMap);
                super.b(speakerId);
            }
        }

        @Override // com.baidu.tieba.uya.a, com.baidu.tieba.uya
        public void d(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("actionStatus", "1002");
                if (this.a.q != null) {
                    JSONObject jSONObject = this.a.q;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.i0().a("handleAudioMsgByTTS", hashMap);
                super.d(speakerId);
            }
        }

        @Override // com.baidu.tieba.uya
        public void e(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("actionStatus", "1300");
                if (this.a.q != null) {
                    JSONObject jSONObject = this.a.q;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.i0().a("handleAudioMsgByTTS", hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends zc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatSlice c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ChatSlice chatSlice) {
            super("imBizAibotWebviewReady");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = chatSlice;
        }

        @Override // com.baidu.tieba.hz4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                oc8.a.a("ChatSlice onWebViewReady");
                this.c.o = true;
                this.c.p0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-626768225, "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-626768225, "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice;");
                return;
            }
        }
        v = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-main-chatgroup/ai-chat?customfullscreen=1&nonavigationbar=1";
        w = new a();
    }

    public final void m0() {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AibotArgs aibotArgs = this.k;
            if (aibotArgs == null || (str = aibotArgs.getH5Url()) == null) {
                str = v;
            }
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = v;
            }
            k0().loadUrl(str);
            oc8.a.a("ChatSlice loadUrl", str);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.o && this.n != null) {
            ad8 i0 = i0();
            AibotChatDetail aibotChatDetail = this.n;
            if (aibotChatDetail == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                aibotChatDetail = null;
            }
            i0.c("imBizAibotChatDetailData", DataExt.toJson(aibotChatDetail));
            r0(this, null, 1, null);
            oc8.a.a("ChatSlice trySetChatDetailToH5");
        }
    }

    public ChatSlice(String botUk, AibotChatRepo repo, AibotArgs aibotArgs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {botUk, repo, aibotArgs};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(botUk, "botUk");
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.j = botUk;
        this.k = aibotArgs;
        this.p = wya.a.a();
        this.r = 2;
        this.s = new d(this);
        this.t = LazyKt__LazyJVMKt.lazy(new Function0<InitData>(this) { // from class: com.baidu.tieba.im.biz.aibot.chatslice.ChatSlice$initData$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatSlice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
            public final ChatSlice.InitData invoke() {
                InterceptResult invokeV;
                ChatSlice.a aVar;
                String str;
                ChatSlice.a aVar2;
                String str2;
                int i3;
                AibotArgs aibotArgs2;
                String str3;
                AibotArgs aibotArgs3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    o05 t = o05.t();
                    String b2 = mo8.b(t.j());
                    Intrinsics.checkNotNullExpressionValue(b2, "am.currentAccountId.toUk()");
                    String m = t.m();
                    Intrinsics.checkNotNullExpressionValue(m, "am.currentAccountNameShow");
                    String r = t.r();
                    Intrinsics.checkNotNullExpressionValue(r, "am.currentPortrait");
                    ChatSlice.InitData.UserInfo userInfo = new ChatSlice.InitData.UserInfo(b2, m, r);
                    aVar = ChatSlice.w;
                    str = this.this$0.j;
                    if (aVar.a(str)) {
                        i3 = 0;
                    } else {
                        aVar2 = ChatSlice.w;
                        str2 = this.this$0.j;
                        aVar2.b(str2);
                        i3 = 1;
                    }
                    aibotArgs2 = this.this$0.k;
                    String str4 = null;
                    if (aibotArgs2 != null) {
                        str3 = aibotArgs2.getTopicText();
                    } else {
                        str3 = null;
                    }
                    aibotArgs3 = this.this$0.k;
                    if (aibotArgs3 != null) {
                        str4 = aibotArgs3.getSugText();
                    }
                    return new ChatSlice.InitData(i3, userInfo, str3, str4);
                }
                return (ChatSlice.InitData) invokeV.objValue;
            }
        });
        this.u = new c(this);
    }

    @Override // com.baidu.tieba.qc8
    public void B(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            try {
                oc8.a.a("ChatSlice setChatDetail");
                this.n = chatDetail;
                m0();
                p0();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public final void n0(ad8 ad8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ad8Var) == null) {
            Intrinsics.checkNotNullParameter(ad8Var, "<set-?>");
            this.m = ad8Var;
        }
    }

    public final void o0(TbWebView tbWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbWebView) == null) {
            Intrinsics.checkNotNullParameter(tbWebView, "<set-?>");
            this.l = tbWebView;
        }
    }

    public final ad8 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ad8 ad8Var = this.m;
            if (ad8Var != null) {
                return ad8Var;
            }
            Intrinsics.throwUninitializedPropertyAccessException("h5Sender");
            return null;
        }
        return (ad8) invokeV.objValue;
    }

    public final InitData j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (InitData) this.t.getValue();
        }
        return (InitData) invokeV.objValue;
    }

    public final TbWebView k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TbWebView tbWebView = this.l;
            if (tbWebView != null) {
                return tbWebView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            return null;
        }
        return (TbWebView) invokeV.objValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            oc8.a.a("ChatSlice initInjectBizData");
            k0().H("imBizAibotInitData", new b(this));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.p.a();
            zc8.b.b(this.s);
            k0().onDestroy();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            k0().onPause();
            this.p.b();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            k0().onResume();
            k0().V();
            this.p.c();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.r();
            zc8.b.a(this.s);
        }
    }

    @Override // com.baidu.tieba.qc8
    public void A1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || this.r == i) {
            return;
        }
        this.r = i;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void X(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, bundle) == null) {
            super.X(view2, bundle);
            l0();
        }
    }

    public static /* synthetic */ void r0(ChatSlice chatSlice, PageStateExt pageStateExt, int i, Object obj) {
        if ((i & 1) != 0) {
            pageStateExt = null;
        }
        chatSlice.q0(pageStateExt);
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public View R(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            TbWebView tbWebView = new TbWebView(container.getContext());
            tbWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            o0(tbWebView);
            n0(new ad8(tbWebView));
            return tbWebView;
        }
        return (View) invokeLLL.objValue;
    }

    public final void h0(JSONObject params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            params.optString("chatType");
            params.optString("chatId");
            String speakId = params.optString("speakId");
            String optString = params.optString("actionType");
            this.q = params.optJSONObject("ext");
            JSONArray optJSONArray = params.optJSONArray("speechTexts");
            StringBuffer stringBuffer = new StringBuffer();
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    if (optJSONArray.get(i) instanceof String) {
                        Object obj = optJSONArray.get(i);
                        if (obj != null) {
                            stringBuffer.append((String) obj);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                }
            }
            tya tyaVar = this.p;
            Intrinsics.checkNotNullExpressionValue(speakId, "speakId");
            tyaVar.h(speakId, this.u);
            if (ei.isEquals(optString, "0")) {
                tya tyaVar2 = this.p;
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(stringBuffer2, "speechText.toString()");
                tyaVar2.d(speakId, stringBuffer2);
            } else if (ei.isEquals(optString, "1")) {
                this.p.f(speakId);
            } else if (ei.isEquals(optString, "2")) {
                this.p.g(speakId);
            } else if (ei.isEquals(optString, "3")) {
                this.p.e(speakId);
            }
        }
    }

    public final void q0(PageStateExt pageStateExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, pageStateExt) == null) {
            Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(AiBotChatDispatcher.AI_SINGLE_PAGE_STATE, Integer.valueOf(this.r)));
            if (pageStateExt != null) {
                mutableMapOf.put("ext", DataExt.toMap(pageStateExt));
            }
            i0().c("aibotNA.notifyPageState", DataExt.toJson(mutableMapOf));
        }
    }
}
