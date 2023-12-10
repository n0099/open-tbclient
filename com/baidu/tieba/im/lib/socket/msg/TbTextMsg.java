package com.baidu.tieba.im.lib.socket.msg;

import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a17;
import com.baidu.tieba.av8;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.ot5;
import com.baidu.tieba.sv8;
import com.baidu.tieba.tv8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\f\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/TbTextMsg;", "Lcom/baidu/tieba/im/lib/socket/msg/TbNormalMsg;", "()V", "robotParams", "", "", "", "getRobotParams", "()Ljava/util/Map;", "setRobotParams", "(Ljava/util/Map;)V", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "thumbnailText", "Landroid/text/SpannableStringBuilder;", "getTextContent", "getThumbnailText", "", "Companion", "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class TbTextMsg extends TbNormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a Companion;
    public static final int MSG_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("robot_params")
    @sv8
    public Map<String, ? extends Object> robotParams;
    @tv8
    @sv8
    public String text;
    @ot5(serialize = false)
    public SpannableStringBuilder thumbnailText;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(721678680, "Lcom/baidu/tieba/im/lib/socket/msg/TbTextMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(721678680, "Lcom/baidu/tieba/im/lib/socket/msg/TbTextMsg;");
                return;
            }
        }
        Companion = new a(null);
    }

    @JvmStatic
    public static final TbTextMsg create(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? Companion.a(str) : (TbTextMsg) invokeL.objValue;
    }

    @JvmStatic
    public static final TbTextMsg createRobotGuide(long j, String str, String str2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i), Integer.valueOf(i2)})) == null) ? Companion.b(j, str, str2, i, i2) : (TbTextMsg) invokeCommon.objValue;
    }

    @JvmStatic
    public static final SpannableStringBuilder processThumbnailText(SpannableStringBuilder spannableStringBuilder, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, spannableStringBuilder, str)) == null) ? Companion.c(spannableStringBuilder, str) : (SpannableStringBuilder) invokeLL.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.im.lib.socket.msg.TbTextMsg$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0337a implements a17.i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SpannableStringBuilder a;

            public C0337a(SpannableStringBuilder spannableStringBuilder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {spannableStringBuilder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = spannableStringBuilder;
            }

            @Override // com.baidu.tieba.a17.i
            public void a(SpannableStringBuilder spannableStringBuilder) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                    boolean z2 = true;
                    if (this.a.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (spannableStringBuilder != null && spannableStringBuilder.length() != 0) {
                            z2 = false;
                        }
                        if (!z2) {
                            this.a.append((CharSequence) spannableStringBuilder);
                        }
                    }
                }
            }
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
        public final TbTextMsg a(String text) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, text)) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                TbTextMsg tbTextMsg = new TbTextMsg();
                tbTextMsg.setText(text);
                return tbTextMsg;
            }
            return (TbTextMsg) invokeL.objValue;
        }

        @JvmStatic
        public final TbTextMsg b(long j, String userName, String portrait, int i, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), userName, portrait, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                Intrinsics.checkNotNullParameter(userName, "userName");
                Intrinsics.checkNotNullParameter(portrait, "portrait");
                TbTextMsg tbTextMsg = new TbTextMsg();
                tbTextMsg.setUserId(j);
                tbTextMsg.setUserName(userName);
                tbTextMsg.setPortrait(portrait);
                tbTextMsg.setRobotRole(i);
                tbTextMsg.setForumExt(new TbBaseMsg.c(i2, 0L, 2, null));
                tbTextMsg.setMockSender(true);
                return tbTextMsg;
            }
            return (TbTextMsg) invokeCommon.objValue;
        }

        @JvmStatic
        public final SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, String str) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, str)) == null) {
                boolean z2 = false;
                if (spannableStringBuilder != null && !StringsKt__StringsJVMKt.isBlank(spannableStringBuilder)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return spannableStringBuilder;
                }
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                a17.e(av8.a.e(), str, UtilHelper.getDimenPixelSize(R.dimen.T_X03), new C0337a(spannableStringBuilder2));
                if (spannableStringBuilder2.length() == 0) {
                    z2 = true;
                }
                if (z2) {
                    spannableStringBuilder2.append((CharSequence) str);
                }
                return spannableStringBuilder2;
            }
            return (SpannableStringBuilder) invokeLL.objValue;
        }
    }

    public TbTextMsg() {
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
        this.text = "";
        setType(1);
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbNormalMsg, com.baidu.tieba.im.lib.socket.msg.TbBaseMsg, java.lang.Object
    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public final Map<String, Object> getRobotParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.robotParams;
        }
        return (Map) invokeV.objValue;
    }

    public final String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpannableStringBuilder c = Companion.c(this.thumbnailText, this.text);
            this.thumbnailText = c;
            Intrinsics.checkNotNull(c);
            return c;
        }
        return (CharSequence) invokeV.objValue;
    }

    @JvmName(name = "getTextContent")
    public final String getTextContent() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.text.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.text = new Regex("\r").replace(this.text, "\n");
            }
            return this.text;
        }
        return (String) invokeV.objValue;
    }

    public final void setRobotParams(Map<String, ? extends Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, map) == null) {
            this.robotParams = map;
        }
    }

    public final void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }
}
