package com.baidu.tbadk.module.imaibot;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0012HÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010*J®\u0001\u0010H\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u00122\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\tHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR \u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u001a\"\u0004\b(\u0010\u001cR\u001e\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001a\"\u0004\b3\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001a¨\u0006O"}, d2 = {"Lcom/baidu/tbadk/module/imaibot/AibotArgs;", "Ljava/io/Serializable;", "topicText", "", "sugText", "chatPageBgUrl", AiBotChatDispatcher.AI_SINGLE_H5_URL, "personPageBgUrl", AiBotChatDispatcher.AI_SINGLE_PAGE_STATE, "", AiBotChatDispatcher.AI_SINGLE_IS_ANIMATION, AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, AiBotChatDispatcher.AI_SINGLE_FROM, "forumId", "", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "forumPortrait", AiBotChatDispatcher.AI_SINGLE_SHOW_BOT_LIST, "", AiBotChatDispatcher.AI_SINGLE_CAN_SLIDE_BACK, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCanSlideBack", "()Z", "setCanSlideBack", "(Z)V", "getChatPageBgUrl", "()Ljava/lang/String;", "setChatPageBgUrl", "(Ljava/lang/String;)V", "getForumId", "()Ljava/lang/Long;", "setForumId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getForumName", "setForumName", "getForumPortrait", "setForumPortrait", "getH5Url", "setH5Url", "setAnimation", "getPageSource", "()Ljava/lang/Integer;", "setPageSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPageState", "()I", "setPageState", "(I)V", "getPersonPageBgUrl", "setPersonPageBgUrl", "getRequestCode", "setRequestCode", "getShowBotList", "setShowBotList", "getSugText", "getTopicText", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/baidu/tbadk/module/imaibot/AibotArgs;", "equals", "other", "", "hashCode", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AibotArgs implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canSlideBack;
    public String chatPageBgUrl;
    @SerializedName("fid")
    public Long forumId;
    @SerializedName(AiBotChatDispatcher.AI_SINGLE_FORUM_NAME)
    public String forumName;
    @SerializedName(AiBotChatDispatcher.AI_SINGLE_FORUM_PORTRAIT)
    public String forumPortrait;
    public String h5Url;
    public String isAnimation;
    public Integer pageSource;
    public int pageState;
    public String personPageBgUrl;
    public int requestCode;
    public boolean showBotList;
    public final String sugText;
    public final String topicText;

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.topicText : (String) invokeV.objValue;
    }

    public final Long component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumId : (Long) invokeV.objValue;
    }

    public final String component11() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public final String component12() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.forumPortrait : (String) invokeV.objValue;
    }

    public final boolean component13() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.showBotList : invokeV.booleanValue;
    }

    public final boolean component14() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.canSlideBack : invokeV.booleanValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sugText : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.chatPageBgUrl : (String) invokeV.objValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h5Url : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.personPageBgUrl : (String) invokeV.objValue;
    }

    public final int component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.pageState : invokeV.intValue;
    }

    public final String component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.isAnimation : (String) invokeV.objValue;
    }

    public final int component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.requestCode : invokeV.intValue;
    }

    public final Integer component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.pageSource : (Integer) invokeV.objValue;
    }

    public final AibotArgs copy(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, Integer num, Long l, String str7, String str8, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i), str6, Integer.valueOf(i2), num, l, str7, str8, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? new AibotArgs(str, str2, str3, str4, str5, i, str6, i2, num, l, str7, str8, z, z2) : (AibotArgs) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AibotArgs) {
                AibotArgs aibotArgs = (AibotArgs) obj;
                return Intrinsics.areEqual(this.topicText, aibotArgs.topicText) && Intrinsics.areEqual(this.sugText, aibotArgs.sugText) && Intrinsics.areEqual(this.chatPageBgUrl, aibotArgs.chatPageBgUrl) && Intrinsics.areEqual(this.h5Url, aibotArgs.h5Url) && Intrinsics.areEqual(this.personPageBgUrl, aibotArgs.personPageBgUrl) && this.pageState == aibotArgs.pageState && Intrinsics.areEqual(this.isAnimation, aibotArgs.isAnimation) && this.requestCode == aibotArgs.requestCode && Intrinsics.areEqual(this.pageSource, aibotArgs.pageSource) && Intrinsics.areEqual(this.forumId, aibotArgs.forumId) && Intrinsics.areEqual(this.forumName, aibotArgs.forumName) && Intrinsics.areEqual(this.forumPortrait, aibotArgs.forumPortrait) && this.showBotList == aibotArgs.showBotList && this.canSlideBack == aibotArgs.canSlideBack;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String str = this.topicText;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.sugText;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.chatPageBgUrl;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.h5Url;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.personPageBgUrl;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.pageState) * 31;
            String str6 = this.isAnimation;
            int hashCode6 = (((hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.requestCode) * 31;
            Integer num = this.pageSource;
            int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
            Long l = this.forumId;
            int hashCode8 = (hashCode7 + (l == null ? 0 : l.hashCode())) * 31;
            String str7 = this.forumName;
            int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.forumPortrait;
            int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
            boolean z = this.showBotList;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode10 + i) * 31;
            boolean z2 = this.canSlideBack;
            return i2 + (z2 ? 1 : z2 ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return "AibotArgs(topicText=" + this.topicText + ", sugText=" + this.sugText + ", chatPageBgUrl=" + this.chatPageBgUrl + ", h5Url=" + this.h5Url + ", personPageBgUrl=" + this.personPageBgUrl + ", pageState=" + this.pageState + ", isAnimation=" + this.isAnimation + ", requestCode=" + this.requestCode + ", pageSource=" + this.pageSource + ", forumId=" + this.forumId + ", forumName=" + this.forumName + ", forumPortrait=" + this.forumPortrait + ", showBotList=" + this.showBotList + ", canSlideBack=" + this.canSlideBack + ')';
        }
        return (String) invokeV.objValue;
    }

    public AibotArgs(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, Integer num, Long l, String str7, String str8, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, str3, str4, str5, Integer.valueOf(i), str6, Integer.valueOf(i2), num, l, str7, str8, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.topicText = str;
        this.sugText = str2;
        this.chatPageBgUrl = str3;
        this.h5Url = str4;
        this.personPageBgUrl = str5;
        this.pageState = i;
        this.isAnimation = str6;
        this.requestCode = i2;
        this.pageSource = num;
        this.forumId = l;
        this.forumName = str7;
        this.forumPortrait = str8;
        this.showBotList = z;
        this.canSlideBack = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AibotArgs(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, Integer num, Long l, String str7, String str8, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, r7, r8, i, r10, r11, r12, r13, r14, r15, r16, r17);
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        int i4;
        Integer num2;
        Long l2;
        String str15;
        String str16;
        boolean z3;
        boolean z4;
        if ((i3 & 1) != 0) {
            str9 = null;
        } else {
            str9 = str;
        }
        if ((i3 & 2) != 0) {
            str10 = null;
        } else {
            str10 = str2;
        }
        if ((i3 & 4) != 0) {
            str11 = null;
        } else {
            str11 = str3;
        }
        if ((i3 & 8) != 0) {
            str12 = null;
        } else {
            str12 = str4;
        }
        if ((i3 & 16) != 0) {
            str13 = null;
        } else {
            str13 = str5;
        }
        if ((i3 & 64) != 0) {
            str14 = null;
        } else {
            str14 = str6;
        }
        if ((i3 & 128) != 0) {
            i4 = 0;
        } else {
            i4 = i2;
        }
        if ((i3 & 256) != 0) {
            num2 = 0;
        } else {
            num2 = num;
        }
        if ((i3 & 512) != 0) {
            l2 = 0L;
        } else {
            l2 = l;
        }
        if ((i3 & 1024) != 0) {
            str15 = null;
        } else {
            str15 = str7;
        }
        if ((i3 & 2048) != 0) {
            str16 = null;
        } else {
            str16 = str8;
        }
        if ((i3 & 4096) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i3 & 8192) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
    }

    public final boolean getCanSlideBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.canSlideBack;
        }
        return invokeV.booleanValue;
    }

    public final String getChatPageBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.chatPageBgUrl;
        }
        return (String) invokeV.objValue;
    }

    public final Long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.forumId;
        }
        return (Long) invokeV.objValue;
    }

    public final String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public final String getForumPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.forumPortrait;
        }
        return (String) invokeV.objValue;
    }

    public final String getH5Url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.h5Url;
        }
        return (String) invokeV.objValue;
    }

    public final Integer getPageSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.pageSource;
        }
        return (Integer) invokeV.objValue;
    }

    public final int getPageState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.pageState;
        }
        return invokeV.intValue;
    }

    public final String getPersonPageBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.personPageBgUrl;
        }
        return (String) invokeV.objValue;
    }

    public final int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.requestCode;
        }
        return invokeV.intValue;
    }

    public final boolean getShowBotList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.showBotList;
        }
        return invokeV.booleanValue;
    }

    public final String getSugText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.sugText;
        }
        return (String) invokeV.objValue;
    }

    public final String getTopicText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.topicText;
        }
        return (String) invokeV.objValue;
    }

    public final String isAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.isAnimation;
        }
        return (String) invokeV.objValue;
    }

    public final void setAnimation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.isAnimation = str;
        }
    }

    public final void setCanSlideBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.canSlideBack = z;
        }
    }

    public final void setChatPageBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.chatPageBgUrl = str;
        }
    }

    public final void setForumId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, l) == null) {
            this.forumId = l;
        }
    }

    public final void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.forumName = str;
        }
    }

    public final void setForumPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.forumPortrait = str;
        }
    }

    public final void setH5Url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.h5Url = str;
        }
    }

    public final void setPageSource(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, num) == null) {
            this.pageSource = num;
        }
    }

    public final void setPageState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.pageState = i;
        }
    }

    public final void setPersonPageBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.personPageBgUrl = str;
        }
    }

    public final void setRequestCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.requestCode = i;
        }
    }

    public final void setShowBotList(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.showBotList = z;
        }
    }
}
