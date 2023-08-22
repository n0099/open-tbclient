package com.baidu.tieba.im.lib.socket.msg;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006%"}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/TbReMsgInfo;", "Ljava/io/Serializable;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "msgKey", "getMsgKey", "setMsgKey", "msgType", "", "getMsgType", "()I", "setMsgType", "(I)V", "nickname", "getNickname", "setNickname", "sdkMsgType", "getSdkMsgType", "setSdkMsgType", "uid", "getUid", "setUid", "url", "getUrl", "setUrl", "Companion", "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TbReMsgInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public long msgId;
    public String msgKey;
    public int msgType;
    public String nickname;
    public int sdkMsgType;
    public long uid;
    public String url;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(328423184, "Lcom/baidu/tieba/im/lib/socket/msg/TbReMsgInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(328423184, "Lcom/baidu/tieba/im/lib/socket/msg/TbReMsgInfo;");
                return;
            }
        }
        Companion = new a(null);
    }

    @JvmStatic
    public static final TbReMsgInfo create(TbBaseMsg tbBaseMsg, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, tbBaseMsg, str)) == null) ? Companion.a(tbBaseMsg, str) : (TbReMsgInfo) invokeLL.objValue;
    }

    /* loaded from: classes6.dex */
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

        @JvmStatic
        public final TbReMsgInfo a(TbBaseMsg tbMsg, String content) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbMsg, content)) == null) {
                Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
                Intrinsics.checkNotNullParameter(content, "content");
                TbReMsgInfo tbReMsgInfo = new TbReMsgInfo();
                tbReMsgInfo.setMsgType(tbMsg.getType());
                tbReMsgInfo.setSdkMsgType(0);
                tbReMsgInfo.setUid(tbMsg.getUserId());
                tbReMsgInfo.setNickname(tbMsg.getUserName());
                tbReMsgInfo.setMsgId(tbMsg.getMsgId());
                tbReMsgInfo.setMsgKey(tbMsg.getMsgKey());
                tbReMsgInfo.setContent(content);
                return tbReMsgInfo;
            }
            return (TbReMsgInfo) invokeLL.objValue;
        }
    }

    public TbReMsgInfo() {
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
        this.nickname = "";
        this.msgKey = "";
        this.content = "";
    }

    public final String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public final long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.msgId;
        }
        return invokeV.longValue;
    }

    public final String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.msgKey;
        }
        return (String) invokeV.objValue;
    }

    public final int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.msgType;
        }
        return invokeV.intValue;
    }

    public final String getNickname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.nickname;
        }
        return (String) invokeV.objValue;
    }

    public final int getSdkMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.sdkMsgType;
        }
        return invokeV.intValue;
    }

    public final long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.uid;
        }
        return invokeV.longValue;
    }

    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    public final void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }
    }

    public final void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.msgId = j;
        }
    }

    public final void setMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msgKey = str;
        }
    }

    public final void setMsgType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.msgType = i;
        }
    }

    public final void setNickname(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nickname = str;
        }
    }

    public final void setSdkMsgType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.sdkMsgType = i;
        }
    }

    public final void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.uid = j;
        }
    }

    public final void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.url = str;
        }
    }
}
