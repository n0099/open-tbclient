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
import org.apache.commons.codec.language.bm.Rule;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo;", "Ljava/io/Serializable;", "()V", "atName", "", "getAtName", "()Ljava/lang/String;", "setAtName", "(Ljava/lang/String;)V", "atPortrait", "getAtPortrait", "setAtPortrait", "atPosition", "", "getAtPosition", "()I", "setAtPosition", "(I)V", "atType", "Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo$AtType;", "getAtType", "()Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo$AtType;", "setAtType", "(Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo$AtType;)V", "atUid", "", "getAtUid", "()J", "setAtUid", "(J)V", "AtType", "Companion", "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TbAtUserInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;
    public String atName;
    public String atPortrait;
    public int atPosition;
    public AtType atType;
    public long atUid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1211965950, "Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1211965950, "Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo;");
                return;
            }
        }
        Companion = new a(null);
    }

    @JvmStatic
    public static final TbAtUserInfo create(AtType atType, long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{atType, Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) ? Companion.a(atType, j, str, str2, i) : (TbAtUserInfo) invokeCommon.objValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo$AtType;", "", "(Ljava/lang/String;I)V", "USER", Rule.ALL, "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AtType {
        public static final /* synthetic */ AtType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AtType ALL;
        public static final AtType USER;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ AtType[] $values() {
            return new AtType[]{USER, ALL};
        }

        public static AtType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (AtType) Enum.valueOf(AtType.class, str) : (AtType) invokeL.objValue;
        }

        public static AtType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (AtType[]) $VALUES.clone() : (AtType[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1700452327, "Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo$AtType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1700452327, "Lcom/baidu/tieba/im/lib/socket/msg/TbAtUserInfo$AtType;");
                    return;
                }
            }
            USER = new AtType("USER", 0);
            ALL = new AtType(Rule.ALL, 1);
            $VALUES = $values();
        }

        public AtType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
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
        public final TbAtUserInfo a(AtType atType, long j, String atName, String atPortrait, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{atType, Long.valueOf(j), atName, atPortrait, Integer.valueOf(i)})) == null) {
                Intrinsics.checkNotNullParameter(atType, "atType");
                Intrinsics.checkNotNullParameter(atName, "atName");
                Intrinsics.checkNotNullParameter(atPortrait, "atPortrait");
                TbAtUserInfo tbAtUserInfo = new TbAtUserInfo();
                tbAtUserInfo.setAtType(atType);
                tbAtUserInfo.setAtUid(j);
                tbAtUserInfo.setAtName(atName);
                tbAtUserInfo.setAtPortrait(atPortrait);
                tbAtUserInfo.setAtPosition(i);
                return tbAtUserInfo;
            }
            return (TbAtUserInfo) invokeCommon.objValue;
        }
    }

    public TbAtUserInfo() {
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
        this.atType = AtType.ALL;
        this.atName = "";
        this.atPortrait = "";
    }

    public final String getAtName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.atName;
        }
        return (String) invokeV.objValue;
    }

    public final String getAtPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.atPortrait;
        }
        return (String) invokeV.objValue;
    }

    public final int getAtPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.atPosition;
        }
        return invokeV.intValue;
    }

    public final AtType getAtType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.atType;
        }
        return (AtType) invokeV.objValue;
    }

    public final long getAtUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.atUid;
        }
        return invokeV.longValue;
    }

    public final void setAtName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.atName = str;
        }
    }

    public final void setAtPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.atPortrait = str;
        }
    }

    public final void setAtPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.atPosition = i;
        }
    }

    public final void setAtType(AtType atType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, atType) == null) {
            Intrinsics.checkNotNullParameter(atType, "<set-?>");
            this.atType = atType;
        }
    }

    public final void setAtUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.atUid = j;
        }
    }
}
