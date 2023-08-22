package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class db4 extends EventTargetImpl implements ge0 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ab4 b;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947698771, "Lcom/baidu/tieba/db4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947698771, "Lcom/baidu/tieba/db4;");
                return;
            }
        }
        d = nr1.a;
    }

    @Override // com.baidu.tieba.ge0
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            w(DownloadStatisticConstants.UBC_TYPE_PAUSE, this.b);
            fi3 fi3Var = new fi3();
            fi3Var.b = DownloadStatisticConstants.UBC_TYPE_PAUSE;
            wh3.h(fi3Var);
        }
    }

    @Override // com.baidu.tieba.ge0
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w(DownloadStatisticConstants.UBC_TYPE_RESUME, this.b);
            fi3 fi3Var = new fi3();
            fi3Var.b = DownloadStatisticConstants.UBC_TYPE_RESUME;
            wh3.h(fi3Var);
        }
    }

    @Override // com.baidu.tieba.ge0
    public void onStart() {
        Object bb4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = this.a;
            if (i == -1) {
                bb4Var = this.b;
            } else {
                bb4Var = new bb4(i);
            }
            w("start", bb4Var);
            fi3 fi3Var = new fi3();
            fi3Var.b = "start";
            wh3.h(fi3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db4(JSRuntime jSRuntime) {
        super(jSRuntime);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSRuntime};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.b = new ab4();
        eb4.a().b().s(this);
    }

    @Override // com.baidu.tieba.ge0
    public void onError(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (d) {
                Log.d("GameRecorderApi", "onError:" + i);
            }
            w("error", new za4("internal error"));
        }
    }

    @Override // com.baidu.tieba.ge0
    public void v(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            if (d) {
                Log.d("GameRecorderApi", "schemeVideoPath:" + this.c);
            }
            w("stop", new cb4(this.c));
            fi3 fi3Var = new fi3();
            fi3Var.b = "stop";
            fi3Var.a("dura", String.valueOf(i / 1000.0f));
            wh3.h(fi3Var);
        }
    }

    public final void w(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) {
            if (d) {
                Log.i("GameRecorderApi", "dispatchEvent:" + str);
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a = i;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.c = str;
        }
    }
}
