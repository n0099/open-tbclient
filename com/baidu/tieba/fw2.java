package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class fw2 extends z22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer M0;

    /* loaded from: classes4.dex */
    public class a extends w42 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw2 c;

        public a(fw2 fw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fw2Var;
        }

        @Override // com.baidu.tieba.w42, com.baidu.tieba.z42
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                l02.k("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i);
            }
        }

        @Override // com.baidu.tieba.w42, com.baidu.tieba.z42
        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str != null && str.startsWith("weixin://wap/pay")) {
                    l02.i("SwanAppWxPayFragment", " weixin  url:   " + str);
                    ea3.K("wechatH5Action", "intoPayment", 0);
                    this.c.M0.cancel();
                    this.c.M0 = null;
                    z22.Y2();
                    return false;
                }
                return super.b(str);
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.w42, com.baidu.tieba.z42
        public void c(int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
                String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i + " description = " + str;
                l02.k("SwanAppWxPayFragment", str3);
                ea3.H(false, "wechatH5Action", ea3.m(str2, str3));
            }
        }

        @Override // com.baidu.tieba.w42, com.baidu.tieba.z42
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                l02.k("SwanAppWxPayFragment", "title: " + str);
            }
        }

        @Override // com.baidu.tieba.w42, com.baidu.tieba.z42
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                l02.k("SwanAppWxPayFragment", "url: " + str);
            }
        }

        @Override // com.baidu.tieba.w42, com.baidu.tieba.z42
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                l02.k("SwanAppWxPayFragment", "goBack: ");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw2 a;

        public b(fw2 fw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fw2Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l02.k("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
                ea3.K("wechatH5Action", "outOfTime", 0);
            }
        }
    }

    public fw2() {
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

    @Override // com.baidu.tieba.z22, com.baidu.tieba.r22
    public void U1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            super.U1(view2);
            this.f0.setTitle(getResources().getString(R.string.obfuscated_res_0x7f0f01ec));
            x2(false);
        }
    }

    @Override // com.baidu.tieba.z22
    public void W2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frameLayout) == null) {
            frameLayout.addView((RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d00df, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.tieba.z22
    public z42 Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new a(this) : (z42) invokeV.objValue;
    }

    public Timer i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            l02.k("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
            Timer timer = new Timer();
            try {
                timer.schedule(new b(this), 10000L);
            } catch (Exception e) {
                if (z22.L0) {
                    e.printStackTrace();
                }
                l02.k("SwanAppWxPayFragment", e.getMessage());
            }
            return timer;
        }
        return (Timer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z22
    public up1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.M0 == null) {
                this.M0 = i3();
            }
            return fa2.U().f0().i(getContext());
        }
        return (up1) invokeV.objValue;
    }
}
