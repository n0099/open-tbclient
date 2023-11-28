package com.baidu.tieba.im.biz.aibot.chatslice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.cj;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.module.imaibot.AibotArgs;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.gr8;
import com.baidu.tieba.hr8;
import com.baidu.tieba.ig6;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.biz.aibot.AibotChatRepo;
import com.baidu.tieba.im.biz.aibot.chatslice.ChatSlice;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.ir8;
import com.baidu.tieba.pv4;
import com.baidu.tieba.rd;
import com.baidu.tieba.sdkcode.tts.TtsApi;
import com.baidu.tieba.sdkcode.tts.TtsListener;
import com.baidu.tieba.sdkcode.tts.TtsManager;
import com.baidu.tieba.vq8;
import com.baidu.tieba.vv8;
import com.baidu.tieba.xq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.text.DecimalFormat;
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
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001(\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0004QRSTB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u00102\u001a\u000203H\u0002J\u000e\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\"J\b\u00106\u001a\u000203H\u0002J\b\u00107\u001a\u00020\fH\u0002J\b\u00108\u001a\u00020\fH\u0002J\b\u00109\u001a\u000203H\u0002J\b\u0010:\u001a\u000203H\u0016J\"\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u000203H\u0016J\b\u0010D\u001a\u000203H\u0016J\b\u0010E\u001a\u000203H\u0016J\u0010\u0010F\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020 2\u0006\u0010I\u001a\u00020\fH\u0016J\u001c\u0010J\u001a\u0002032\b\u0010K\u001a\u0004\u0018\u00010<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010L\u001a\u000203H\u0002J\b\u0010M\u001a\u000203H\u0002J\u0012\u0010N\u001a\u0002032\n\b\u0002\u0010O\u001a\u0004\u0018\u00010PR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006U"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "botUk", "", "botPaid", "repo", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "argsData", "Lcom/baidu/tbadk/module/imaibot/AibotArgs;", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;Lcom/baidu/tbadk/module/imaibot/AibotArgs;)V", "canBackToPersonPage", "", "canChatPageStat", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "chatStartTime", "", "h5Sender", "Lcom/baidu/tieba/im/biz/aibot/helper/H5Sender;", "getH5Sender", "()Lcom/baidu/tieba/im/biz/aibot/helper/H5Sender;", "setH5Sender", "(Lcom/baidu/tieba/im/biz/aibot/helper/H5Sender;)V", "initData", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData;", "getInitData", "()Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData;", "initData$delegate", "Lkotlin/Lazy;", "isWebViewReady", "mPageState", "", "mTTSExt", "Lorg/json/JSONObject;", "mTTSHelper", "Lcom/baidu/tieba/sdkcode/tts/TtsApi;", "mTTSListenerAdapter", "Lcom/baidu/tieba/sdkcode/tts/TtsListener$TtsListenerAdapter;", "onWebViewReady", "com/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$onWebViewReady$1", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$onWebViewReady$1;", "getRepo", "()Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "getWebView", "()Lcom/baidu/tieba/browser/TbWebView;", "setWebView", "(Lcom/baidu/tieba/browser/TbWebView;)V", "dealChatPageShow", "", "dealVoiceByMsgInTTS", "params", "initInjectBizData", "isChatPageState", "isPersonPageState", "loadUrl", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, MissionEvent.MESSAGE_PAUSE, "onResume", "onSetChatDetail", "onSetPageState", "state", "refreshPage", "onViewCreated", "view", "statChatPageDuration", "trySetChatDetailToH5", "trySetPageStateToH5", "pageStateExt", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$PageStateExt;", "Companion", "InitData", "PageStateExt", "VisitedBotSet", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatSlice extends Slice implements xq8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a A;
    public static final String z;
    public transient /* synthetic */ FieldHolder $fh;
    public final String j;
    public final String k;
    public final AibotArgs l;
    public TbWebView m;
    public ir8 n;
    public AibotChatDetail o;
    public boolean p;
    public final TtsApi q;
    public JSONObject r;
    public long s;
    public boolean t;
    public boolean u;
    public int v;
    public final d w;
    public final Lazy x;
    public final TtsListener.a y;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001:\u0001!B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJF\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData;", "Ljava/io/Serializable;", "isColdStart", "", "userInfo", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;", "topicText", "", "sugText", AiBotChatDispatcher.AI_SINGLE_FROM, "(ILcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "()I", "getPageSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSugText", "()Ljava/lang/String;", "getTopicText", "getUserInfo", "()Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;", "component1", "component2", "component3", "component4", "component5", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(ILcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData;", "equals", "", "other", "", "hashCode", "toString", "UserInfo", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class InitData implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("is_cold_start")
        public final int isColdStart;
        @SerializedName("page_source")
        public final Integer pageSource;
        @SerializedName("sug_text")
        public final String sugText;
        @SerializedName("topic_text")
        public final String topicText;
        @SerializedName(SourceConstant.SOURCE_USER_INFO)
        public final UserInfo userInfo;

        public static /* synthetic */ InitData copy$default(InitData initData, int i, UserInfo userInfo, String str, String str2, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = initData.isColdStart;
            }
            if ((i2 & 2) != 0) {
                userInfo = initData.userInfo;
            }
            UserInfo userInfo2 = userInfo;
            if ((i2 & 4) != 0) {
                str = initData.topicText;
            }
            String str3 = str;
            if ((i2 & 8) != 0) {
                str2 = initData.sugText;
            }
            String str4 = str2;
            if ((i2 & 16) != 0) {
                num = initData.pageSource;
            }
            return initData.copy(i, userInfo2, str3, str4, num);
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

        public final Integer component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.pageSource : (Integer) invokeV.objValue;
        }

        public final InitData copy(int i, UserInfo userInfo, String str, String str2, Integer num) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), userInfo, str, str2, num})) == null) {
                Intrinsics.checkNotNullParameter(userInfo, "userInfo");
                return new InitData(i, userInfo, str, str2, num);
            }
            return (InitData) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof InitData) {
                    InitData initData = (InitData) obj;
                    return this.isColdStart == initData.isColdStart && Intrinsics.areEqual(this.userInfo, initData.userInfo) && Intrinsics.areEqual(this.topicText, initData.topicText) && Intrinsics.areEqual(this.sugText, initData.sugText) && Intrinsics.areEqual(this.pageSource, initData.pageSource);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int hashCode = ((this.isColdStart * 31) + this.userInfo.hashCode()) * 31;
                String str = this.topicText;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.sugText;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                Integer num = this.pageSource;
                return hashCode3 + (num != null ? num.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return "InitData(isColdStart=" + this.isColdStart + ", userInfo=" + this.userInfo + ", topicText=" + this.topicText + ", sugText=" + this.sugText + ", pageSource=" + this.pageSource + ')';
            }
            return (String) invokeV.objValue;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$InitData$UserInfo;", "Ljava/io/Serializable;", "uk", "", TbEnum.SystemMessage.KEY_USER_NAME, "portrait", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPortrait", "()Ljava/lang/String;", "getUk", "getUserName", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

        public InitData(int i, UserInfo userInfo, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), userInfo, str, str2, num};
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
            this.pageSource = num;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ InitData(int i, UserInfo userInfo, String str, String str2, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, userInfo, r4, r5, (i2 & 16) != 0 ? 0 : num);
            String str3;
            String str4;
            if ((i2 & 4) != 0) {
                str3 = null;
            } else {
                str3 = str;
            }
            if ((i2 & 8) != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
        }

        public final Integer getPageSource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.pageSource;
            }
            return (Integer) invokeV.objValue;
        }

        public final String getSugText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.sugText;
            }
            return (String) invokeV.objValue;
        }

        public final String getTopicText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.topicText;
            }
            return (String) invokeV.objValue;
        }

        public final UserInfo getUserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.userInfo;
            }
            return (UserInfo) invokeV.objValue;
        }

        public final int isColdStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.isColdStart;
            }
            return invokeV.intValue;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice$PageStateExt;", "Ljava/io/Serializable;", "topicText", "", "sugText", "(Ljava/lang/String;Ljava/lang/String;)V", "getSugText", "()Ljava/lang/String;", "getTopicText", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public static final class b implements ig6<Object> {
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
        @Override // com.baidu.tieba.ig6, java.util.concurrent.Callable
        /* renamed from: a */
        public JSONObject call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new JSONObject(DataExt.toJson(this.a.n0()));
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends TtsListener.a {
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

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener.a, com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayError(String speakerId, int i, String errMsg) {
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
                if (this.a.r != null) {
                    JSONObject jSONObject = this.a.r;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.m0().a("handleAudioMsgByTTS", hashMap);
                super.onPlayError(speakerId, i, errMsg);
            }
        }

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener.a, com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayFinish(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("actionStatus", "1005");
                if (this.a.r != null) {
                    JSONObject jSONObject = this.a.r;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.m0().a("handleAudioMsgByTTS", hashMap);
                super.onPlayFinish(speakerId);
            }
        }

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener.a, com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayStart(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("actionStatus", "1002");
                if (this.a.r != null) {
                    JSONObject jSONObject = this.a.r;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.m0().a("handleAudioMsgByTTS", hashMap);
                super.onPlayStart(speakerId);
            }
        }

        @Override // com.baidu.tieba.sdkcode.tts.TtsListener
        public void onPlayStop(String speakerId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, speakerId) == null) {
                Intrinsics.checkNotNullParameter(speakerId, "speakerId");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("actionStatus", "1300");
                if (this.a.r != null) {
                    JSONObject jSONObject = this.a.r;
                    Intrinsics.checkNotNull(jSONObject);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "mTTSExt!!.toString()");
                    hashMap.put("ext", DataExt.toMap(jSONObject2));
                }
                this.a.m0().a("handleAudioMsgByTTS", hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends hr8 {
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

        @Override // com.baidu.tieba.iu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                vq8.a.a("ChatSlice onWebViewReady");
                this.c.p = true;
                this.c.w0();
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
        z = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-main-chatgroup/ai-chat?customfullscreen=1&nonavigationbar=1";
        A = new a();
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.p && this.o != null) {
            ir8 m0 = m0();
            AibotChatDetail aibotChatDetail = this.o;
            if (aibotChatDetail == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                aibotChatDetail = null;
            }
            m0.c("imBizAibotChatDetailData", DataExt.toJson(aibotChatDetail));
            y0(this, null, 1, null);
            vq8.a.a("ChatSlice trySetChatDetailToH5");
        }
    }

    public ChatSlice(String botUk, String botPaid, AibotChatRepo repo, AibotArgs aibotArgs) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {botUk, botPaid, repo, aibotArgs};
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
        Intrinsics.checkNotNullParameter(botPaid, "botPaid");
        Intrinsics.checkNotNullParameter(repo, "repo");
        this.j = botUk;
        this.k = botPaid;
        this.l = aibotArgs;
        this.q = TtsManager.INSTANCE.createTts();
        this.v = 2;
        this.w = new d(this);
        this.x = LazyKt__LazyJVMKt.lazy(new Function0<InitData>(this) { // from class: com.baidu.tieba.im.biz.aibot.chatslice.ChatSlice$initData$2
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
                String str4;
                AibotArgs aibotArgs4;
                Integer num;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    pv4 t = pv4.t();
                    String b2 = vv8.b(t.j());
                    Intrinsics.checkNotNullExpressionValue(b2, "am.currentAccountId.toUk()");
                    String m = t.m();
                    Intrinsics.checkNotNullExpressionValue(m, "am.currentAccountNameShow");
                    String r = t.r();
                    Intrinsics.checkNotNullExpressionValue(r, "am.currentPortrait");
                    ChatSlice.InitData.UserInfo userInfo = new ChatSlice.InitData.UserInfo(b2, m, r);
                    aVar = ChatSlice.A;
                    str = this.this$0.j;
                    if (aVar.a(str)) {
                        i3 = 0;
                    } else {
                        aVar2 = ChatSlice.A;
                        str2 = this.this$0.j;
                        aVar2.b(str2);
                        i3 = 1;
                    }
                    aibotArgs2 = this.this$0.l;
                    if (aibotArgs2 != null) {
                        str3 = aibotArgs2.getTopicText();
                    } else {
                        str3 = null;
                    }
                    aibotArgs3 = this.this$0.l;
                    if (aibotArgs3 != null) {
                        str4 = aibotArgs3.getSugText();
                    } else {
                        str4 = null;
                    }
                    aibotArgs4 = this.this$0.l;
                    if (aibotArgs4 != null) {
                        num = aibotArgs4.getPageSource();
                    } else {
                        num = null;
                    }
                    return new ChatSlice.InitData(i3, userInfo, str3, str4, num);
                }
                return (ChatSlice.InitData) invokeV.objValue;
            }
        });
        this.y = new c(this);
    }

    @Override // com.baidu.tieba.xq8
    public void O(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            try {
                vq8.a.a("ChatSlice setChatDetail");
                this.o = chatDetail;
                s0();
                w0();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public final void t0(ir8 ir8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ir8Var) == null) {
            Intrinsics.checkNotNullParameter(ir8Var, "<set-?>");
            this.n = ir8Var;
        }
    }

    public final void u0(TbWebView tbWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tbWebView) == null) {
            Intrinsics.checkNotNullParameter(tbWebView, "<set-?>");
            this.m = tbWebView;
        }
    }

    public final void k0() {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.s = System.currentTimeMillis();
            if (this.u) {
                gr8 gr8Var = gr8.a;
                String str = this.k;
                AibotArgs aibotArgs = this.l;
                if (aibotArgs != null) {
                    num = aibotArgs.getPageSource();
                } else {
                    num = null;
                }
                gr8Var.b(1, str, num);
            }
        }
    }

    public final ir8 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ir8 ir8Var = this.n;
            if (ir8Var != null) {
                return ir8Var;
            }
            Intrinsics.throwUninitializedPropertyAccessException("h5Sender");
            return null;
        }
        return (ir8) invokeV.objValue;
    }

    public final InitData n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (InitData) this.x.getValue();
        }
        return (InitData) invokeV.objValue;
    }

    public final TbWebView o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TbWebView tbWebView = this.m;
            if (tbWebView != null) {
                return tbWebView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            return null;
        }
        return (TbWebView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            this.q.releaseAll();
            hr8.b.b(this.w);
            o0().onDestroy();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            o0().onPause();
            this.q.pauseAll();
            if (q0() && !this.t) {
                v0();
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            o0().onResume();
            o0().W();
            this.q.resumeAll();
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            vq8.a.a("ChatSlice initInjectBizData");
            o0().I("imBizAibotInitData", new b(this));
        }
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.v == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.v == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.v();
            hr8.b.a(this.w);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            p0();
        }
    }

    public static /* synthetic */ void y0(ChatSlice chatSlice, PageStateExt pageStateExt, int i, Object obj) {
        if ((i & 1) != 0) {
            pageStateExt = null;
        }
        chatSlice.x0(pageStateExt);
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inflater, container, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(container, "container");
            TbWebView tbWebView = new TbWebView(container.getContext());
            tbWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            u0(tbWebView);
            t0(new ir8(tbWebView));
            return tbWebView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.xq8
    public void e2(int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z2)}) == null) {
            this.u = true;
            if (this.v == i) {
                return;
            }
            this.t = r0();
            if (q0()) {
                v0();
            } else if (r0()) {
                this.u = false;
                k0();
            }
            this.v = i;
        }
    }

    public final void l0(JSONObject params) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            params.optString("chatType");
            params.optString("chatId");
            String speakId = params.optString("speakId");
            String optString = params.optString("actionType");
            this.r = params.optJSONObject("ext");
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
            TtsApi ttsApi = this.q;
            Intrinsics.checkNotNullExpressionValue(speakId, "speakId");
            ttsApi.addWeakListener(speakId, this.y);
            if (rd.isEquals(optString, "0")) {
                TtsApi ttsApi2 = this.q;
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(stringBuffer2, "speechText.toString()");
                ttsApi2.speak(speakId, stringBuffer2);
            } else if (rd.isEquals(optString, "1")) {
                this.q.pause(speakId);
            } else if (rd.isEquals(optString, "2")) {
                this.q.resume(speakId);
            } else if (rd.isEquals(optString, "3")) {
                this.q.stop(speakId);
            }
        }
    }

    public final void s0() {
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            AibotArgs aibotArgs = this.l;
            if (aibotArgs == null || (str = aibotArgs.getH5Url()) == null) {
                str = z;
            }
            if (str.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = z;
            }
            if (!rd.isEquals(str, o0().getUrl())) {
                o0().loadUrl(str);
            }
            vq8.a.a("ChatSlice loadUrl", str);
        }
    }

    public final void v0() {
        Integer num;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || !this.u) {
            return;
        }
        String uid = BIMManager.getBdUidFromBdUK(this.j);
        String format = new DecimalFormat(cj.d).format(Float.valueOf(((float) (System.currentTimeMillis() - this.s)) / 1000.0f));
        if (format != null && Float.parseFloat(format) > 0.0f && Float.parseFloat(format) < 259200.0f) {
            gr8 gr8Var = gr8.a;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            AibotArgs aibotArgs = this.l;
            if (aibotArgs != null) {
                num = aibotArgs.getPageSource();
            } else {
                num = null;
            }
            gr8Var.a(uid, num, format);
            this.s = System.currentTimeMillis();
        }
    }

    public final void x0(PageStateExt pageStateExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, pageStateExt) == null) {
            Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(AiBotChatDispatcher.AI_SINGLE_PAGE_STATE, Integer.valueOf(this.v)));
            if (pageStateExt != null) {
                mutableMapOf.put("ext", DataExt.toMap(pageStateExt));
            }
            m0().c("aibotNA.notifyPageState", DataExt.toJson(mutableMapOf));
            if (this.s == 0 && q0()) {
                k0();
            }
        }
    }
}
