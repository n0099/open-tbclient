package com.baidu.tieba.easteregg.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tieba.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushService;
import com.tencent.connect.share.QzonePublish;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0002QRB\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0014J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010D\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bHÆ\u0003J\u0011\u0010E\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bHÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J©\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\b\u0010M\u001a\u0004\u0018\u00010\bJ\t\u0010N\u001a\u00020\u0005HÖ\u0001J\u0006\u0010O\u001a\u00020JJ\t\u0010P\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001e\"\u0004\b'\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018¨\u0006S"}, d2 = {"Lcom/baidu/tieba/easteregg/data/EasterEggAdData;", "Ljava/io/Serializable;", "validTime", "", "countdown", "", "resType", GameAssistConstKt.KEY_ICONURL, "", "videoUrl", "showStatisticsUrls", "", "clickStatisticsUrls", "isDownload", "jumpLink", "jumpScheme", "downloadInfo", "Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;", "activityId", "mDisplayAdIcon", "(JIILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;Ljava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "getClickStatisticsUrls", "()Ljava/util/List;", "setClickStatisticsUrls", "(Ljava/util/List;)V", "getCountdown", "()I", "setCountdown", "(I)V", "getDownloadInfo", "()Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;", "setDownloadInfo", "(Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;)V", "getIconUrl", "setIconUrl", "setDownload", "getJumpLink", "setJumpLink", "getJumpScheme", "setJumpScheme", "getMDisplayAdIcon", "setMDisplayAdIcon", "getResType", "setResType", "getShowStatisticsUrls", "setShowStatisticsUrls", "getValidTime", "()J", "setValidTime", "(J)V", QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, "getVideoPath", "setVideoPath", "getVideoUrl", "setVideoUrl", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "getUrl", "hashCode", "isValidData", "toString", "Companion", "DownloadInfo", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EasterEggAdData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    @JvmField
    public static final int DEFAULT_COUNT_TIME = 5;
    public static final String KEY_EASTER_EGG_AD = "key_easter_egg_ad";
    public static final int VIDEO = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String activityId;
    public List<String> clickStatisticsUrls;
    public int countdown;
    public DownloadInfo downloadInfo;
    public String iconUrl;
    public int isDownload;
    public String jumpLink;
    public String jumpScheme;
    public String mDisplayAdIcon;
    public int resType;
    public List<String> showStatisticsUrls;
    public long validTime;
    public String videoPath;
    public String videoUrl;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-442515370, "Lcom/baidu/tieba/easteregg/data/EasterEggAdData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-442515370, "Lcom/baidu/tieba/easteregg/data/EasterEggAdData;");
                return;
            }
        }
        Companion = new a(null);
    }

    @JvmStatic
    public static final EasterEggAdData parseJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) ? Companion.b(jSONObject) : (EasterEggAdData) invokeL.objValue;
    }

    public final long component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.validTime : invokeV.longValue;
    }

    public final String component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.jumpScheme : (String) invokeV.objValue;
    }

    public final DownloadInfo component11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.downloadInfo : (DownloadInfo) invokeV.objValue;
    }

    public final String component12() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.activityId : (String) invokeV.objValue;
    }

    public final String component13() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDisplayAdIcon : (String) invokeV.objValue;
    }

    public final int component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.countdown : invokeV.intValue;
    }

    public final int component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.resType : invokeV.intValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.iconUrl : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.videoUrl : (String) invokeV.objValue;
    }

    public final List<String> component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.showStatisticsUrls : (List) invokeV.objValue;
    }

    public final List<String> component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.clickStatisticsUrls : (List) invokeV.objValue;
    }

    public final int component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isDownload : invokeV.intValue;
    }

    public final String component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.jumpLink : (String) invokeV.objValue;
    }

    public final EasterEggAdData copy(long j, int i, int i2, String str, String str2, List<String> list, List<String> list2, int i3, String str3, String str4, DownloadInfo downloadInfo, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, str2, list, list2, Integer.valueOf(i3), str3, str4, downloadInfo, str5, str6})) == null) ? new EasterEggAdData(j, i, i2, str, str2, list, list2, i3, str3, str4, downloadInfo, str5, str6) : (EasterEggAdData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EasterEggAdData) {
                EasterEggAdData easterEggAdData = (EasterEggAdData) obj;
                return this.validTime == easterEggAdData.validTime && this.countdown == easterEggAdData.countdown && this.resType == easterEggAdData.resType && Intrinsics.areEqual(this.iconUrl, easterEggAdData.iconUrl) && Intrinsics.areEqual(this.videoUrl, easterEggAdData.videoUrl) && Intrinsics.areEqual(this.showStatisticsUrls, easterEggAdData.showStatisticsUrls) && Intrinsics.areEqual(this.clickStatisticsUrls, easterEggAdData.clickStatisticsUrls) && this.isDownload == easterEggAdData.isDownload && Intrinsics.areEqual(this.jumpLink, easterEggAdData.jumpLink) && Intrinsics.areEqual(this.jumpScheme, easterEggAdData.jumpScheme) && Intrinsics.areEqual(this.downloadInfo, easterEggAdData.downloadInfo) && Intrinsics.areEqual(this.activityId, easterEggAdData.activityId) && Intrinsics.areEqual(this.mDisplayAdIcon, easterEggAdData.mDisplayAdIcon);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            int a2 = ((((c.a(this.validTime) * 31) + this.countdown) * 31) + this.resType) * 31;
            String str = this.iconUrl;
            int hashCode = (a2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.videoUrl;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<String> list = this.showStatisticsUrls;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            List<String> list2 = this.clickStatisticsUrls;
            int hashCode4 = (((hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31) + this.isDownload) * 31;
            String str3 = this.jumpLink;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.jumpScheme;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            DownloadInfo downloadInfo = this.downloadInfo;
            int hashCode7 = (hashCode6 + (downloadInfo == null ? 0 : downloadInfo.hashCode())) * 31;
            String str5 = this.activityId;
            int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.mDisplayAdIcon;
            return hashCode8 + (str6 != null ? str6.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return "EasterEggAdData(validTime=" + this.validTime + ", countdown=" + this.countdown + ", resType=" + this.resType + ", iconUrl=" + this.iconUrl + ", videoUrl=" + this.videoUrl + ", showStatisticsUrls=" + this.showStatisticsUrls + ", clickStatisticsUrls=" + this.clickStatisticsUrls + ", isDownload=" + this.isDownload + ", jumpLink=" + this.jumpLink + ", jumpScheme=" + this.jumpScheme + ", downloadInfo=" + this.downloadInfo + ", activityId=" + this.activityId + ", mDisplayAdIcon=" + this.mDisplayAdIcon + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;", "Ljava/io/Serializable;", "androidLink", "", PushService.APP_VERSION_CODE, "", "apkVersion", "developerName", "authorityUrl", "privacyUrl", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAndroidLink", "()Ljava/lang/String;", "setAndroidLink", "(Ljava/lang/String;)V", "getApkVersion", "setApkVersion", "getAuthorityUrl", "setAuthorityUrl", "getDeveloperName", "setDeveloperName", "getPrivacyUrl", "setPrivacyUrl", "getVersionCode", "()Ljava/lang/Long;", "setVersionCode", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DownloadInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final a Companion;
        public transient /* synthetic */ FieldHolder $fh;
        public String androidLink;
        public String apkVersion;
        public String authorityUrl;
        public String developerName;
        public String privacyUrl;
        public Long versionCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1848009818, "Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1848009818, "Lcom/baidu/tieba/easteregg/data/EasterEggAdData$DownloadInfo;");
                    return;
                }
            }
            Companion = new a(null);
        }

        public static /* synthetic */ DownloadInfo copy$default(DownloadInfo downloadInfo, String str, Long l, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadInfo.androidLink;
            }
            if ((i & 2) != 0) {
                l = downloadInfo.versionCode;
            }
            Long l2 = l;
            if ((i & 4) != 0) {
                str2 = downloadInfo.apkVersion;
            }
            String str6 = str2;
            if ((i & 8) != 0) {
                str3 = downloadInfo.developerName;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                str4 = downloadInfo.authorityUrl;
            }
            String str8 = str4;
            if ((i & 32) != 0) {
                str5 = downloadInfo.privacyUrl;
            }
            return downloadInfo.copy(str, l2, str6, str7, str8, str5);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.androidLink : (String) invokeV.objValue;
        }

        public final Long component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.versionCode : (Long) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.apkVersion : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.developerName : (String) invokeV.objValue;
        }

        public final String component5() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.authorityUrl : (String) invokeV.objValue;
        }

        public final String component6() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.privacyUrl : (String) invokeV.objValue;
        }

        public final DownloadInfo copy(String str, Long l, String str2, String str3, String str4, String str5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, l, str2, str3, str4, str5})) == null) ? new DownloadInfo(str, l, str2, str3, str4, str5) : (DownloadInfo) invokeCommon.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DownloadInfo) {
                    DownloadInfo downloadInfo = (DownloadInfo) obj;
                    return Intrinsics.areEqual(this.androidLink, downloadInfo.androidLink) && Intrinsics.areEqual(this.versionCode, downloadInfo.versionCode) && Intrinsics.areEqual(this.apkVersion, downloadInfo.apkVersion) && Intrinsics.areEqual(this.developerName, downloadInfo.developerName) && Intrinsics.areEqual(this.authorityUrl, downloadInfo.authorityUrl) && Intrinsics.areEqual(this.privacyUrl, downloadInfo.privacyUrl);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                String str = this.androidLink;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                Long l = this.versionCode;
                int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
                String str2 = this.apkVersion;
                int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.developerName;
                int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.authorityUrl;
                int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.privacyUrl;
                return hashCode5 + (str5 != null ? str5.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                return "DownloadInfo(androidLink=" + this.androidLink + ", versionCode=" + this.versionCode + ", apkVersion=" + this.apkVersion + ", developerName=" + this.developerName + ", authorityUrl=" + this.authorityUrl + ", privacyUrl=" + this.privacyUrl + ')';
            }
            return (String) invokeV.objValue;
        }

        /* loaded from: classes5.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

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
                    }
                }
            }

            public final DownloadInfo a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                    if (jSONObject != null) {
                        return new DownloadInfo(jSONObject.optString("android_link"), Long.valueOf(jSONObject.optLong("version_code")), jSONObject.optString("apk_version"), jSONObject.optString("developer_name"), jSONObject.optString("authority_url"), jSONObject.optString("privacy_url"));
                    }
                    return null;
                }
                return (DownloadInfo) invokeL.objValue;
            }
        }

        public DownloadInfo(String str, Long l, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, l, str2, str3, str4, str5};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.androidLink = str;
            this.versionCode = l;
            this.apkVersion = str2;
            this.developerName = str3;
            this.authorityUrl = str4;
            this.privacyUrl = str5;
        }

        public final String getAndroidLink() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.androidLink;
            }
            return (String) invokeV.objValue;
        }

        public final String getApkVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.apkVersion;
            }
            return (String) invokeV.objValue;
        }

        public final String getAuthorityUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.authorityUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getDeveloperName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.developerName;
            }
            return (String) invokeV.objValue;
        }

        public final String getPrivacyUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.privacyUrl;
            }
            return (String) invokeV.objValue;
        }

        public final Long getVersionCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.versionCode;
            }
            return (Long) invokeV.objValue;
        }

        public final void setAndroidLink(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                this.androidLink = str;
            }
        }

        public final void setApkVersion(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                this.apkVersion = str;
            }
        }

        public final void setAuthorityUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
                this.authorityUrl = str;
            }
        }

        public final void setDeveloperName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                this.developerName = str;
            }
        }

        public final void setPrivacyUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
                this.privacyUrl = str;
            }
        }

        public final void setVersionCode(Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, l) == null) {
                this.versionCode = l;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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
                }
            }
        }

        public final List<String> a(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String optString = jSONArray.optString(i);
                        Intrinsics.checkNotNullExpressionValue(optString, "it.optString(i)");
                        arrayList.add(optString);
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        @JvmStatic
        public final EasterEggAdData b(JSONObject jsonObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsonObject)) == null) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                return new EasterEggAdData(jsonObject.optLong("valid_time"), jsonObject.optInt("countdown", EasterEggAdData.DEFAULT_COUNT_TIME), jsonObject.optInt("is_video"), jsonObject.optString("icon_url"), jsonObject.optString("video_url"), a(jsonObject.optJSONArray("show_statistics_urls")), a(jsonObject.optJSONArray("click_statistics_urls")), jsonObject.optInt("is_download"), jsonObject.optString("jump_link"), jsonObject.optString("jump_scheme"), DownloadInfo.Companion.a(jsonObject.optJSONObject(TiebaMainDatabaseHelper.TABLE_NAME_DOWNLOAD_INFO)), jsonObject.optString("activity_id"), jsonObject.optString("display_ad_icon"));
            }
            return (EasterEggAdData) invokeL.objValue;
        }
    }

    public EasterEggAdData(long j, int i, int i2, String str, String str2, List<String> list, List<String> list2, int i3, String str3, String str4, DownloadInfo downloadInfo, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, str2, list, list2, Integer.valueOf(i3), str3, str4, downloadInfo, str5, str6};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.validTime = j;
        this.countdown = i;
        this.resType = i2;
        this.iconUrl = str;
        this.videoUrl = str2;
        this.showStatisticsUrls = list;
        this.clickStatisticsUrls = list2;
        this.isDownload = i3;
        this.jumpLink = str3;
        this.jumpScheme = str4;
        this.downloadInfo = downloadInfo;
        this.activityId = str5;
        this.mDisplayAdIcon = str6;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ EasterEggAdData(long j, int i, int i2, String str, String str2, List list, List list2, int i3, String str3, String str4, DownloadInfo downloadInfo, String str5, String str6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, i, i2, str, str2, list, list2, i3, str3, str4, downloadInfo, r16, r17);
        String str7;
        String str8;
        if ((i4 & 2048) != 0) {
            str7 = null;
        } else {
            str7 = str5;
        }
        if ((i4 & 4096) != 0) {
            str8 = null;
        } else {
            str8 = str6;
        }
    }

    public final String getActivityId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.activityId;
        }
        return (String) invokeV.objValue;
    }

    public final List<String> getClickStatisticsUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.clickStatisticsUrls;
        }
        return (List) invokeV.objValue;
    }

    public final int getCountdown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.countdown;
        }
        return invokeV.intValue;
    }

    public final DownloadInfo getDownloadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.downloadInfo;
        }
        return (DownloadInfo) invokeV.objValue;
    }

    public final String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getJumpLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.jumpLink;
        }
        return (String) invokeV.objValue;
    }

    public final String getJumpScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.jumpScheme;
        }
        return (String) invokeV.objValue;
    }

    public final String getMDisplayAdIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mDisplayAdIcon;
        }
        return (String) invokeV.objValue;
    }

    public final int getResType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.resType;
        }
        return invokeV.intValue;
    }

    public final List<String> getShowStatisticsUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.showStatisticsUrls;
        }
        return (List) invokeV.objValue;
    }

    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.resType == 1) {
                return this.videoUrl;
            }
            return this.iconUrl;
        }
        return (String) invokeV.objValue;
    }

    public final long getValidTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.validTime;
        }
        return invokeV.longValue;
    }

    public final String getVideoPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.videoPath;
        }
        return (String) invokeV.objValue;
    }

    public final String getVideoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.videoUrl;
        }
        return (String) invokeV.objValue;
    }

    public final int isDownload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.isDownload;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
        if (r0 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
        if (r0 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002b, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002d, code lost:
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isValidData() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.resType == 1) {
                String str = this.videoUrl;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z5 = false;
                } else {
                    z5 = true;
                }
            } else {
                String str2 = this.iconUrl;
                if (str2 != null && !StringsKt__StringsJVMKt.isBlank(str2)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (!z2) {
                return false;
            }
            String str3 = this.jumpLink;
            if (str3 != null && !StringsKt__StringsJVMKt.isBlank(str3)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                String str4 = this.jumpScheme;
                if (str4 != null && !StringsKt__StringsJVMKt.isBlank(str4)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void setActivityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.activityId = str;
        }
    }

    public final void setClickStatisticsUrls(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            this.clickStatisticsUrls = list;
        }
    }

    public final void setCountdown(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.countdown = i;
        }
    }

    public final void setDownload(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.isDownload = i;
        }
    }

    public final void setDownloadInfo(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, downloadInfo) == null) {
            this.downloadInfo = downloadInfo;
        }
    }

    public final void setIconUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.iconUrl = str;
        }
    }

    public final void setJumpLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.jumpLink = str;
        }
    }

    public final void setJumpScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.jumpScheme = str;
        }
    }

    public final void setMDisplayAdIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.mDisplayAdIcon = str;
        }
    }

    public final void setResType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.resType = i;
        }
    }

    public final void setShowStatisticsUrls(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, list) == null) {
            this.showStatisticsUrls = list;
        }
    }

    public final void setValidTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            this.validTime = j;
        }
    }

    public final void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.videoPath = str;
        }
    }

    public final void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.videoUrl = str;
        }
    }
}
