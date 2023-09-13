package com.baidu.tieba.im.biz.aibot.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f¨\u0006%"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/data/AibotArgs;", "Ljava/io/Serializable;", "topicText", "", "sugText", "chatPageBgUrl", AiBotChatDispatcher.AI_SINGLE_H5_URL, "personPageBgUrl", AiBotChatDispatcher.AI_SINGLE_PAGE_STATE, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getChatPageBgUrl", "()Ljava/lang/String;", "getH5Url", "setH5Url", "(Ljava/lang/String;)V", "getPageState", "()I", "setPageState", "(I)V", "getPersonPageBgUrl", "setPersonPageBgUrl", "getSugText", "getTopicText", "component1", "component2", "component3", "component4", "component5", "component6", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotArgs implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String chatPageBgUrl;
    public String h5Url;
    public int pageState;
    public String personPageBgUrl;
    public final String sugText;
    public final String topicText;

    public static /* synthetic */ AibotArgs copy$default(AibotArgs aibotArgs, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aibotArgs.topicText;
        }
        if ((i2 & 2) != 0) {
            str2 = aibotArgs.sugText;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = aibotArgs.chatPageBgUrl;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = aibotArgs.h5Url;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = aibotArgs.personPageBgUrl;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = aibotArgs.pageState;
        }
        return aibotArgs.copy(str, str6, str7, str8, str9, i);
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

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.chatPageBgUrl : (String) invokeV.objValue;
    }

    public final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h5Url : (String) invokeV.objValue;
    }

    public final String component5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.personPageBgUrl : (String) invokeV.objValue;
    }

    public final int component6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pageState : invokeV.intValue;
    }

    public final AibotArgs copy(String str, String str2, String str3, String str4, String str5, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i)})) == null) ? new AibotArgs(str, str2, str3, str4, str5, i) : (AibotArgs) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AibotArgs) {
                AibotArgs aibotArgs = (AibotArgs) obj;
                return Intrinsics.areEqual(this.topicText, aibotArgs.topicText) && Intrinsics.areEqual(this.sugText, aibotArgs.sugText) && Intrinsics.areEqual(this.chatPageBgUrl, aibotArgs.chatPageBgUrl) && Intrinsics.areEqual(this.h5Url, aibotArgs.h5Url) && Intrinsics.areEqual(this.personPageBgUrl, aibotArgs.personPageBgUrl) && this.pageState == aibotArgs.pageState;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String str = this.topicText;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.sugText;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.chatPageBgUrl;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.h5Url;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.personPageBgUrl;
            return ((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.pageState;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "AibotArgs(topicText=" + this.topicText + ", sugText=" + this.sugText + ", chatPageBgUrl=" + this.chatPageBgUrl + ", h5Url=" + this.h5Url + ", personPageBgUrl=" + this.personPageBgUrl + ", pageState=" + this.pageState + ')';
        }
        return (String) invokeV.objValue;
    }

    public AibotArgs(String str, String str2, String str3, String str4, String str5, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AibotArgs(String str, String str2, String str3, String str4, String str5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, r5, r6, r7, i);
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if ((i2 & 1) != 0) {
            str6 = null;
        } else {
            str6 = str;
        }
        if ((i2 & 2) != 0) {
            str7 = null;
        } else {
            str7 = str2;
        }
        if ((i2 & 4) != 0) {
            str8 = null;
        } else {
            str8 = str3;
        }
        if ((i2 & 8) != 0) {
            str9 = null;
        } else {
            str9 = str4;
        }
        if ((i2 & 16) != 0) {
            str10 = null;
        } else {
            str10 = str5;
        }
    }

    public final String getChatPageBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.chatPageBgUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getH5Url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h5Url;
        }
        return (String) invokeV.objValue;
    }

    public final int getPageState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.pageState;
        }
        return invokeV.intValue;
    }

    public final String getPersonPageBgUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.personPageBgUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getSugText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.sugText;
        }
        return (String) invokeV.objValue;
    }

    public final String getTopicText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.topicText;
        }
        return (String) invokeV.objValue;
    }

    public final void setH5Url(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.h5Url = str;
        }
    }

    public final void setPageState(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.pageState = i;
        }
    }

    public final void setPersonPageBgUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.personPageBgUrl = str;
        }
    }
}
