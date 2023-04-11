package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.LayerEvent;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class az0 extends zy0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static int j = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947632338, "Lcom/baidu/tieba/az0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947632338, "Lcom/baidu/tieba/az0;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.tieba.zy0, com.baidu.tieba.tv0
    public void d(su0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_SET_DATA_SOURCE)) {
                boolean z = false;
                this.e = false;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                boolean a = xz0.a(context);
                if (!a) {
                    j = f01.c(getContext());
                }
                if (a != f) {
                    f = a;
                    if (!a && yr0.T() && f01.c(getContext()) > 0) {
                        c01.b("HeadsetPlugin", "恢复操作,静音->非静音");
                        i = false;
                        yr0 i2 = i();
                        if (i2 != null) {
                            i2.s0(false);
                        }
                    }
                }
                yr0 i3 = i();
                if (i3 != null) {
                    z = i3.V();
                }
                this.d = z;
            }
        }
    }

    @Override // com.baidu.tieba.tv0
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new int[]{1, 4};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zy0, com.baidu.tieba.tv0
    public void n(su0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_HEADSET_PLUG)) {
                boolean d = event.d(3);
                h = d;
                if (!g) {
                    p(d);
                }
            } else if (Intrinsics.areEqual(event.c(), SystemEvent.ACTION_BLUETOOTH_HEADSET)) {
                boolean d2 = event.d(6);
                g = d2;
                if (!h) {
                    p(d2);
                }
            }
        }
    }

    public final void p(boolean z) {
        Boolean bool;
        Boolean bool2;
        yr0 i2;
        boolean z2;
        yr0 i3;
        int i4;
        int i5;
        yr0 i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("播放器是否静音isMute= ");
            yr0 i7 = i();
            Boolean bool3 = null;
            if (i7 != null) {
                bool = Boolean.valueOf(i7.V());
            } else {
                bool = null;
            }
            sb.append(bool);
            sb.append(',');
            sb.append(" 播放器是否全局静音sGlobalMute= ");
            sb.append(yr0.T());
            sb.append(',');
            sb.append(" 播放器静音状态(业务复写的方法)isPlayerMute= ");
            yr0 i8 = i();
            if (i8 != null) {
                bool2 = Boolean.valueOf(i8.X());
            } else {
                bool2 = null;
            }
            sb.append(bool2);
            sb.append(',');
            sb.append(" 播放器耳机连接前的音量大小-> ");
            sb.append(j);
            sb.append(',');
            sb.append(" 播放器音量音量焦点-> ");
            yr0 i9 = i();
            if (i9 != null) {
                bool3 = Boolean.valueOf(i9.U());
            }
            sb.append(bool3);
            c01.b("HeadsetPlugin", sb.toString());
            if (z) {
                f = true;
                i = yr0.T();
                yr0 i10 = i();
                if (i10 != null) {
                    z2 = i10.V();
                } else {
                    z2 = false;
                }
                this.d = z2;
                c01.b("HeadsetPlugin", "耳机连接>>> 静音状态,全局=" + i + ", 播放器=" + this.d);
                boolean z3 = this.d;
                if (!z3) {
                    yr0 i11 = i();
                    if (i11 != null && i11.V()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (z3 && (i6 = i()) != null) {
                    i6.s0(false);
                }
                int c = f01.c(getContext());
                if (c == 0) {
                    c = (int) (f01.b(getContext()) * 0.35d);
                }
                f01.d(getContext(), c);
                if (n01.k() && (i3 = i()) != null && i3.W() && this.e) {
                    yr0 i12 = i();
                    if (i12 != null) {
                        i4 = i12.r();
                    } else {
                        i4 = 0;
                    }
                    yr0 i13 = i();
                    if (i13 != null) {
                        i5 = i13.C();
                    } else {
                        i5 = 0;
                    }
                    if (i4 > i5) {
                        this.e = false;
                        yr0 i14 = i();
                        if (i14 != null) {
                            i14.l0();
                        }
                    }
                }
            } else if (f) {
                f = false;
                if (n01.k() && (i2 = i()) != null && i2.Y()) {
                    this.e = true;
                    yr0 i15 = i();
                    if (i15 != null) {
                        i15.f0(4);
                    }
                }
                c01.b("HeadsetPlugin", "耳机断开>>> 恢复之前静音状态,全局=" + i + ", 播放器=" + this.d + StringUtil.ARRAY_ELEMENT_SEPARATOR + "声音=" + j);
                if (j == 0) {
                    f01.d(getContext(), j);
                }
                yr0 i16 = i();
                if (i16 != null) {
                    i16.s0(i);
                }
                yr0 i17 = i();
                if (i17 != null) {
                    i17.w0(this.d);
                }
            } else {
                nz0.c().d(iu0.w(LayerEvent.ACTION_MUTE_SYNC_TO_ALL_PLAYER));
            }
        }
    }
}
