package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.ot2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes6.dex */
public final class hs2 extends yo2<ot2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final ot2.a h;

    /* loaded from: classes6.dex */
    public class a implements ot2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs2 a;

        public a(hs2 hs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs2Var;
        }

        @Override // com.baidu.tieba.ot2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onNetStatus", str);
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                u12.e().l(str, true);
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, GameAssistConstKt.TYPE_CALLBACK_ERROR, Integer.valueOf(i));
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                u12.e().q(str);
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (!TextUtils.isEmpty(str)) {
                    u12.e().l(str, false);
                }
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onEnded", null);
            }
        }

        @Override // com.baidu.tieba.ot2.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.b != null) {
                this.a.b.onCallback(this.a, "onPrepared", null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947834210, "Lcom/baidu/tieba/hs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947834210, "Lcom/baidu/tieba/hs2;");
                return;
            }
        }
        i = nr1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hs2(@NonNull ot2 ot2Var) {
        super(ot2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ot2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ap2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        ot2Var.g0(aVar);
        u12.e().b(ot2Var);
        this.a.a(new ls2());
        this.a.a(new ms2());
        this.a.a(new ns2());
        this.a.a(new qs2());
        this.a.a(new ps2());
        this.a.a(new os2());
        this.a.a(new rs2());
        this.a.a(new ss2());
        this.a.a(new ts2());
        this.a.a(new us2());
        this.a.a(new ws2());
        this.a.a(new xs2());
        this.a.a(new ys2());
        this.a.a(new zs2());
        this.a.a(new bt2());
        this.a.a(new ct2());
        this.a.a(new ft2());
        this.a.a(new gt2());
        this.a.a(new at2());
        this.a.a(new vs2());
        this.a.a(new et2());
    }

    @Override // com.baidu.tieba.yo2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (i) {
                    Log.d("LiveInlineController", "reject command => " + command.what);
                    return;
                }
                return;
            }
            super.sendCommand(command);
        }
    }

    public final boolean w(ZeusPlugin.Command command) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command)) == null) {
            if (command != null && TextUtils.equals(command.what, xs2.b)) {
                if (i) {
                    Log.d("LiveInlineController", "isRejectCommand: exempt release command");
                }
                return false;
            }
            int a2 = ((ot2) this.c).a();
            if (i && a2 != 1) {
                if (command == null) {
                    str = "";
                } else {
                    str = command.what;
                }
                Log.d("LiveInlineController", "isRejectCommand: authorize type => " + ((ot2) this.c).a() + " command=> " + str);
            }
            if (a2 != 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
