package com.baidu.tbadk.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\u001a\u0010-\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u00100\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#¨\u00068"}, d2 = {"Lcom/baidu/tbadk/data/TopNotifyData;", "Ljava/io/Serializable;", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "chatroomId", "", "getChatroomId", "()J", "setChatroomId", "(J)V", "content", "getContent", "setContent", "cueWord", "getCueWord", "setCueWord", "forumId", "getForumId", "setForumId", "forumName", "getForumName", "setForumName", "jumpUrl", "getJumpUrl", "setJumpUrl", WriteMulitImageActivityConfig.SKIN_TYPE, "", "getSkinType", "()I", "setSkinType", "(I)V", "title", "getTitle", "setTitle", "toastMinuteGap", "getToastMinuteGap", "setToastMinuteGap", "toastShowNumber", "getToastShowNumber", "setToastShowNumber", "toastShowTime", "getToastShowTime", "setToastShowTime", "windowType", "getWindowType", "setWindowType", "parsJson", "", "jsonObject", "Lorg/json/JSONObject;", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopNotifyData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final a Companion;
    public static volatile TopNotifyData instance;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public long chatroomId;
    public String content;
    public String cueWord;
    public long forumId;
    public String forumName;
    public String jumpUrl;
    public int skinType;
    public String title;
    public int toastMinuteGap;
    public int toastShowNumber;
    public int toastShowTime;
    public int windowType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(903092021, "Lcom/baidu/tbadk/data/TopNotifyData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(903092021, "Lcom/baidu/tbadk/data/TopNotifyData;");
                return;
            }
        }
        Companion = new a(null);
    }

    public /* synthetic */ TopNotifyData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes4.dex */
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

        public final TopNotifyData a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TopNotifyData.instance == null) {
                    synchronized (TopNotifyData.class) {
                        if (TopNotifyData.instance == null) {
                            TopNotifyData.instance = new TopNotifyData(null);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return TopNotifyData.instance;
            }
            return (TopNotifyData) invokeV.objValue;
        }
    }

    public TopNotifyData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.avatar = "";
        this.title = "";
        this.content = "";
        this.cueWord = "";
        this.jumpUrl = "";
        this.forumName = "";
        this.skinType = TbadkCoreApplication.getInst().getSkinType();
        this.windowType = 1;
    }

    public final String getAvatar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.avatar;
        }
        return (String) invokeV.objValue;
    }

    public final long getChatroomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.chatroomId;
        }
        return invokeV.longValue;
    }

    public final String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public final String getCueWord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.cueWord;
        }
        return (String) invokeV.objValue;
    }

    public final long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.forumId;
        }
        return invokeV.longValue;
    }

    public final String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public final String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public final int getSkinType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.skinType;
        }
        return invokeV.intValue;
    }

    public final String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.title;
        }
        return (String) invokeV.objValue;
    }

    public final int getToastMinuteGap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.toastMinuteGap;
        }
        return invokeV.intValue;
    }

    public final int getToastShowNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.toastShowNumber;
        }
        return invokeV.intValue;
    }

    public final int getToastShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.toastShowTime;
        }
        return invokeV.intValue;
    }

    public final int getWindowType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.windowType;
        }
        return invokeV.intValue;
    }

    public final void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.avatar = str;
        }
    }

    public final void setChatroomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.chatroomId = j;
        }
    }

    public final void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }
    }

    public final void setCueWord(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cueWord = str;
        }
    }

    public final void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.forumId = j;
        }
    }

    public final void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.forumName = str;
        }
    }

    public final void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpUrl = str;
        }
    }

    public final void setSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.skinType = i;
        }
    }

    public final void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }

    public final void setToastMinuteGap(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.toastMinuteGap = i;
        }
    }

    public final void setToastShowNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.toastShowNumber = i;
        }
    }

    public final void setToastShowTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.toastShowTime = i;
        }
    }

    public final void setWindowType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.windowType = i;
        }
    }

    public final void parsJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("avatar");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"avatar\")");
        this.avatar = optString;
        String optString2 = jSONObject.optString("title");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"title\")");
        this.title = optString2;
        String optString3 = jSONObject.optString("content");
        Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(\"content\")");
        this.content = optString3;
        String optString4 = jSONObject.optString("cue_word");
        Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(\"cue_word\")");
        this.cueWord = optString4;
        String optString5 = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
        Intrinsics.checkNotNullExpressionValue(optString5, "jsonObject.optString(\"jump_url\")");
        this.jumpUrl = optString5;
        this.chatroomId = jSONObject.optLong("chatroom_id");
        this.forumId = jSONObject.optLong("forum_id");
        String optString6 = jSONObject.optString("forum_name");
        Intrinsics.checkNotNullExpressionValue(optString6, "jsonObject.optString(\"forum_name\")");
        this.forumName = optString6;
        this.toastShowTime = jSONObject.optInt("toast_show_time");
        this.toastShowNumber = jSONObject.optInt("toast_show_number");
        this.toastMinuteGap = jSONObject.optInt("toast_minute_gap");
    }
}
