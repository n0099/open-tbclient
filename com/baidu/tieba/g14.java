package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y63 a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ DialogInterface.OnClickListener e;
        public final /* synthetic */ g14 f;

        public a(g14 g14Var, Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g14Var, activity, str, str2, Boolean.valueOf(z), onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = g14Var;
            this.a = activity;
            this.b = str;
            this.c = str2;
            this.d = z;
            this.e = onClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f.a != null && this.f.a.isShowing()) {
                    this.f.a.dismiss();
                }
                Activity activity = this.a;
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                y63.a d = this.f.d(this.a, this.b, this.c, this.d, this.e);
                this.f.a = d.X();
            }
        }
    }

    public g14() {
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

    public void e() {
        y63 y63Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (y63Var = this.a) != null) {
            if (y63Var.isShowing()) {
                this.a.dismiss();
            }
            this.a = null;
        }
    }

    public final y63.a d(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener})) == null) {
            y63.a aVar = new y63.a(activity);
            aVar.x(str);
            aVar.a();
            aVar.n(new cn3());
            aVar.m(z);
            aVar.Q(R.color.obfuscated_res_0x7f06093b);
            aVar.f(true);
            aVar.P(str2, onClickListener);
            return aVar;
        }
        return (y63.a) invokeCommon.objValue;
    }

    public void f(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, str2, Boolean.valueOf(z), onClickListener}) == null) {
            ol3.a0(new a(this, activity, str, str2, z, onClickListener));
        }
    }
}
