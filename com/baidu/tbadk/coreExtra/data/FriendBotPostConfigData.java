package com.baidu.tbadk.coreExtra.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006%"}, d2 = {"Lcom/baidu/tbadk/coreExtra/data/FriendBotPostConfigData;", "Ljava/io/Serializable;", "loadingPostContent", "", "loadingPostDefaultContent", "dynamicButtonResource", "dynamicGuideResource", "guideText", "pbFirstFloorBotBubbleShow", "", "pbFirstFloorBotDynamicIconPlay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDynamicButtonResource", "()Ljava/lang/String;", "getDynamicGuideResource", "getGuideText", "getLoadingPostContent", "getLoadingPostDefaultContent", "getPbFirstFloorBotBubbleShow", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPbFirstFloorBotDynamicIconPlay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/baidu/tbadk/coreExtra/data/FriendBotPostConfigData;", "equals", "", "other", "", "hashCode", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendBotPostConfigData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("dynamic_button_resource")
    public final String dynamicButtonResource;
    @SerializedName("dynamic_guide_resource")
    public final String dynamicGuideResource;
    @SerializedName("guide_text")
    public final String guideText;
    @SerializedName("loading_post_content")
    public final String loadingPostContent;
    @SerializedName("loading_post_default_content")
    public final String loadingPostDefaultContent;
    @SerializedName("pb_first_floor_bot_bubble_show")
    public final Integer pbFirstFloorBotBubbleShow;
    @SerializedName("pb_first_floor_bot_dynamic_icon_play")
    public final Integer pbFirstFloorBotDynamicIconPlay;

    public static /* synthetic */ FriendBotPostConfigData copy$default(FriendBotPostConfigData friendBotPostConfigData, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = friendBotPostConfigData.loadingPostContent;
        }
        if ((i & 2) != 0) {
            str2 = friendBotPostConfigData.loadingPostDefaultContent;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = friendBotPostConfigData.dynamicButtonResource;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = friendBotPostConfigData.dynamicGuideResource;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = friendBotPostConfigData.guideText;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            num = friendBotPostConfigData.pbFirstFloorBotBubbleShow;
        }
        Integer num3 = num;
        if ((i & 64) != 0) {
            num2 = friendBotPostConfigData.pbFirstFloorBotDynamicIconPlay;
        }
        return friendBotPostConfigData.copy(str, str6, str7, str8, str9, num3, num2);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.loadingPostContent : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.loadingPostDefaultContent : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.dynamicButtonResource : (String) invokeV.objValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.dynamicGuideResource : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.guideText : (String) invokeV.objValue;
    }

    public final Integer component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pbFirstFloorBotBubbleShow : (Integer) invokeV.objValue;
    }

    public final Integer component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.pbFirstFloorBotDynamicIconPlay : (Integer) invokeV.objValue;
    }

    public final FriendBotPostConfigData copy(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, str4, str5, num, num2})) == null) ? new FriendBotPostConfigData(str, str2, str3, str4, str5, num, num2) : (FriendBotPostConfigData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FriendBotPostConfigData) {
                FriendBotPostConfigData friendBotPostConfigData = (FriendBotPostConfigData) obj;
                return Intrinsics.areEqual(this.loadingPostContent, friendBotPostConfigData.loadingPostContent) && Intrinsics.areEqual(this.loadingPostDefaultContent, friendBotPostConfigData.loadingPostDefaultContent) && Intrinsics.areEqual(this.dynamicButtonResource, friendBotPostConfigData.dynamicButtonResource) && Intrinsics.areEqual(this.dynamicGuideResource, friendBotPostConfigData.dynamicGuideResource) && Intrinsics.areEqual(this.guideText, friendBotPostConfigData.guideText) && Intrinsics.areEqual(this.pbFirstFloorBotBubbleShow, friendBotPostConfigData.pbFirstFloorBotBubbleShow) && Intrinsics.areEqual(this.pbFirstFloorBotDynamicIconPlay, friendBotPostConfigData.pbFirstFloorBotDynamicIconPlay);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.loadingPostContent;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.loadingPostDefaultContent;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.dynamicButtonResource;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.dynamicGuideResource;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.guideText;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num = this.pbFirstFloorBotBubbleShow;
            int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.pbFirstFloorBotDynamicIconPlay;
            return hashCode6 + (num2 != null ? num2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "FriendBotPostConfigData(loadingPostContent=" + this.loadingPostContent + ", loadingPostDefaultContent=" + this.loadingPostDefaultContent + ", dynamicButtonResource=" + this.dynamicButtonResource + ", dynamicGuideResource=" + this.dynamicGuideResource + ", guideText=" + this.guideText + ", pbFirstFloorBotBubbleShow=" + this.pbFirstFloorBotBubbleShow + ", pbFirstFloorBotDynamicIconPlay=" + this.pbFirstFloorBotDynamicIconPlay + ')';
        }
        return (String) invokeV.objValue;
    }

    public FriendBotPostConfigData(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, num, num2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.loadingPostContent = str;
        this.loadingPostDefaultContent = str2;
        this.dynamicButtonResource = str3;
        this.dynamicGuideResource = str4;
        this.guideText = str5;
        this.pbFirstFloorBotBubbleShow = num;
        this.pbFirstFloorBotDynamicIconPlay = num2;
    }

    public final String getDynamicButtonResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.dynamicButtonResource;
        }
        return (String) invokeV.objValue;
    }

    public final String getDynamicGuideResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.dynamicGuideResource;
        }
        return (String) invokeV.objValue;
    }

    public final String getGuideText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.guideText;
        }
        return (String) invokeV.objValue;
    }

    public final String getLoadingPostContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.loadingPostContent;
        }
        return (String) invokeV.objValue;
    }

    public final String getLoadingPostDefaultContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.loadingPostDefaultContent;
        }
        return (String) invokeV.objValue;
    }

    public final Integer getPbFirstFloorBotBubbleShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.pbFirstFloorBotBubbleShow;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getPbFirstFloorBotDynamicIconPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.pbFirstFloorBotDynamicIconPlay;
        }
        return (Integer) invokeV.objValue;
    }
}
