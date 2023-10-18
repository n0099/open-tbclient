package com.baidu.tieba.im.data;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001.B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0086\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\n\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010¨\u0006/"}, d2 = {"Lcom/baidu/tieba/im/data/ChatSysNotifyMsgData;", "Ljava/io/Serializable;", "agree", "", "replyMe", "fans", "gift", "godfeed", "atMe", "feed", "isInvite", "newInviteNum", "lastContent", "Lcom/baidu/tieba/im/data/ChatSysNotifyMsgData$LastContent;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/baidu/tieba/im/data/ChatSysNotifyMsgData$LastContent;)V", "getAgree", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAtMe", "getFans", "getFeed", "getGift", "getGodfeed", "getLastContent", "()Lcom/baidu/tieba/im/data/ChatSysNotifyMsgData$LastContent;", "getNewInviteNum", "getReplyMe", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/baidu/tieba/im/data/ChatSysNotifyMsgData$LastContent;)Lcom/baidu/tieba/im/data/ChatSysNotifyMsgData;", "equals", "", "other", "", "hashCode", "toString", "", "LastContent", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatSysNotifyMsgData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Integer agree;
    @SerializedName("atme")
    public final Integer atMe;
    public final Integer fans;
    public final Integer feed;
    public final Integer gift;
    @SerializedName("godfeed")
    public final Integer godfeed;
    @SerializedName("is_invite")
    public final Integer isInvite;
    @SerializedName("last_content")
    public final LastContent lastContent;
    @SerializedName("new_invite_num")
    public final Integer newInviteNum;
    @SerializedName("replyme")
    public final Integer replyMe;

    public final Integer component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.agree : (Integer) invokeV.objValue;
    }

    public final LastContent component10() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.lastContent : (LastContent) invokeV.objValue;
    }

    public final Integer component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.replyMe : (Integer) invokeV.objValue;
    }

    public final Integer component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.fans : (Integer) invokeV.objValue;
    }

    public final Integer component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.gift : (Integer) invokeV.objValue;
    }

    public final Integer component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.godfeed : (Integer) invokeV.objValue;
    }

    public final Integer component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.atMe : (Integer) invokeV.objValue;
    }

    public final Integer component7() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.feed : (Integer) invokeV.objValue;
    }

    public final Integer component8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isInvite : (Integer) invokeV.objValue;
    }

    public final Integer component9() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.newInviteNum : (Integer) invokeV.objValue;
    }

    public final ChatSysNotifyMsgData copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, LastContent lastContent) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{num, num2, num3, num4, num5, num6, num7, num8, num9, lastContent})) == null) ? new ChatSysNotifyMsgData(num, num2, num3, num4, num5, num6, num7, num8, num9, lastContent) : (ChatSysNotifyMsgData) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChatSysNotifyMsgData) {
                ChatSysNotifyMsgData chatSysNotifyMsgData = (ChatSysNotifyMsgData) obj;
                return Intrinsics.areEqual(this.agree, chatSysNotifyMsgData.agree) && Intrinsics.areEqual(this.replyMe, chatSysNotifyMsgData.replyMe) && Intrinsics.areEqual(this.fans, chatSysNotifyMsgData.fans) && Intrinsics.areEqual(this.gift, chatSysNotifyMsgData.gift) && Intrinsics.areEqual(this.godfeed, chatSysNotifyMsgData.godfeed) && Intrinsics.areEqual(this.atMe, chatSysNotifyMsgData.atMe) && Intrinsics.areEqual(this.feed, chatSysNotifyMsgData.feed) && Intrinsics.areEqual(this.isInvite, chatSysNotifyMsgData.isInvite) && Intrinsics.areEqual(this.newInviteNum, chatSysNotifyMsgData.newInviteNum) && Intrinsics.areEqual(this.lastContent, chatSysNotifyMsgData.lastContent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Integer num = this.agree;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.replyMe;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.fans;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.gift;
            int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.godfeed;
            int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.atMe;
            int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.feed;
            int hashCode7 = (hashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Integer num8 = this.isInvite;
            int hashCode8 = (hashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
            Integer num9 = this.newInviteNum;
            int hashCode9 = (hashCode8 + (num9 == null ? 0 : num9.hashCode())) * 31;
            LastContent lastContent = this.lastContent;
            return hashCode9 + (lastContent != null ? lastContent.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return "ChatSysNotifyMsgData(agree=" + this.agree + ", replyMe=" + this.replyMe + ", fans=" + this.fans + ", gift=" + this.gift + ", godfeed=" + this.godfeed + ", atMe=" + this.atMe + ", feed=" + this.feed + ", isInvite=" + this.isInvite + ", newInviteNum=" + this.newInviteNum + ", lastContent=" + this.lastContent + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/im/data/ChatSysNotifyMsgData$LastContent;", "Ljava/io/Serializable;", "fansContent", "", "replyMeContent", "atMeContent", "agreeContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAgreeContent", "()Ljava/lang/String;", "getAtMeContent", "getFansContent", "getReplyMeContent", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class LastContent implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("agree_content")
        public final String agreeContent;
        @SerializedName("atme_content")
        public final String atMeContent;
        @SerializedName("fans_content")
        public final String fansContent;
        @SerializedName("replyme_content")
        public final String replyMeContent;

        public static /* synthetic */ LastContent copy$default(LastContent lastContent, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = lastContent.fansContent;
            }
            if ((i & 2) != 0) {
                str2 = lastContent.replyMeContent;
            }
            if ((i & 4) != 0) {
                str3 = lastContent.atMeContent;
            }
            if ((i & 8) != 0) {
                str4 = lastContent.agreeContent;
            }
            return lastContent.copy(str, str2, str3, str4);
        }

        public final String component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.fansContent : (String) invokeV.objValue;
        }

        public final String component2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.replyMeContent : (String) invokeV.objValue;
        }

        public final String component3() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.atMeContent : (String) invokeV.objValue;
        }

        public final String component4() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.agreeContent : (String) invokeV.objValue;
        }

        public final LastContent copy(String str, String str2, String str3, String str4) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, str2, str3, str4)) == null) ? new LastContent(str, str2, str3, str4) : (LastContent) invokeLLLL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LastContent) {
                    LastContent lastContent = (LastContent) obj;
                    return Intrinsics.areEqual(this.fansContent, lastContent.fansContent) && Intrinsics.areEqual(this.replyMeContent, lastContent.replyMeContent) && Intrinsics.areEqual(this.atMeContent, lastContent.atMeContent) && Intrinsics.areEqual(this.agreeContent, lastContent.agreeContent);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                String str = this.fansContent;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.replyMeContent;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.atMeContent;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.agreeContent;
                return hashCode3 + (str4 != null ? str4.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return "LastContent(fansContent=" + this.fansContent + ", replyMeContent=" + this.replyMeContent + ", atMeContent=" + this.atMeContent + ", agreeContent=" + this.agreeContent + ')';
            }
            return (String) invokeV.objValue;
        }

        public LastContent(String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.fansContent = str;
            this.replyMeContent = str2;
            this.atMeContent = str3;
            this.agreeContent = str4;
        }

        public final String getAgreeContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.agreeContent;
            }
            return (String) invokeV.objValue;
        }

        public final String getAtMeContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.atMeContent;
            }
            return (String) invokeV.objValue;
        }

        public final String getFansContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.fansContent;
            }
            return (String) invokeV.objValue;
        }

        public final String getReplyMeContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.replyMeContent;
            }
            return (String) invokeV.objValue;
        }
    }

    public ChatSysNotifyMsgData(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, LastContent lastContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, num2, num3, num4, num5, num6, num7, num8, num9, lastContent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.agree = num;
        this.replyMe = num2;
        this.fans = num3;
        this.gift = num4;
        this.godfeed = num5;
        this.atMe = num6;
        this.feed = num7;
        this.isInvite = num8;
        this.newInviteNum = num9;
        this.lastContent = lastContent;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ChatSysNotifyMsgData(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, LastContent lastContent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, lastContent);
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Integer num15;
        Integer num16;
        Integer num17;
        Integer num18;
        if ((i & 1) != 0) {
            num10 = 0;
        } else {
            num10 = num;
        }
        if ((i & 2) != 0) {
            num11 = 0;
        } else {
            num11 = num2;
        }
        if ((i & 4) != 0) {
            num12 = 0;
        } else {
            num12 = num3;
        }
        if ((i & 8) != 0) {
            num13 = 0;
        } else {
            num13 = num4;
        }
        if ((i & 16) != 0) {
            num14 = 0;
        } else {
            num14 = num5;
        }
        if ((i & 32) != 0) {
            num15 = 0;
        } else {
            num15 = num6;
        }
        if ((i & 64) != 0) {
            num16 = 0;
        } else {
            num16 = num7;
        }
        if ((i & 128) != 0) {
            num17 = 0;
        } else {
            num17 = num8;
        }
        if ((i & 256) != 0) {
            num18 = 0;
        } else {
            num18 = num9;
        }
    }

    public final Integer getAgree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.agree;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getAtMe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.atMe;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getFans() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.fans;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getFeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.feed;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getGift() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.gift;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getGodfeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.godfeed;
        }
        return (Integer) invokeV.objValue;
    }

    public final LastContent getLastContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.lastContent;
        }
        return (LastContent) invokeV.objValue;
    }

    public final Integer getNewInviteNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.newInviteNum;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer getReplyMe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.replyMe;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer isInvite() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.isInvite;
        }
        return (Integer) invokeV.objValue;
    }
}
