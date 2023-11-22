package com.baidu.tieba.im.lib.socket.msg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gs8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/TbTextToSpeechMsg;", "Lcom/baidu/tieba/im/lib/socket/msg/TbTextMsg;", "()V", "speakerId", "", "getSpeakerId", "()Ljava/lang/String;", "setSpeakerId", "(Ljava/lang/String;)V", "Companion", "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TbTextToSpeechMsg extends TbTextMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int MSG_TYPE = 103;
    public transient /* synthetic */ FieldHolder $fh;
    @gs8
    @SerializedName("speak_id")
    public String speakerId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-465953739, "Lcom/baidu/tieba/im/lib/socket/msg/TbTextToSpeechMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-465953739, "Lcom/baidu/tieba/im/lib/socket/msg/TbTextToSpeechMsg;");
                return;
            }
        }
        Companion = new a(null);
    }

    @JvmStatic
    public static final TbTextToSpeechMsg create(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Companion.a(str) : (TbTextToSpeechMsg) invokeL.objValue;
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
        public final TbTextToSpeechMsg a(String text) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, text)) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                TbTextToSpeechMsg tbTextToSpeechMsg = new TbTextToSpeechMsg();
                tbTextToSpeechMsg.setText(text);
                return tbTextToSpeechMsg;
            }
            return (TbTextToSpeechMsg) invokeL.objValue;
        }
    }

    public TbTextToSpeechMsg() {
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
        this.speakerId = "";
        setType(103);
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbTextMsg, com.baidu.tieba.im.lib.socket.msg.TbNormalMsg, com.baidu.tieba.im.lib.socket.msg.TbBaseMsg, java.lang.Object
    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public final String getSpeakerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.speakerId;
        }
        return (String) invokeV.objValue;
    }

    public final void setSpeakerId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.speakerId = str;
        }
    }
}
