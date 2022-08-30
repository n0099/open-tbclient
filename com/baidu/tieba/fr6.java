package com.baidu.tieba;

import android.app.Activity;
import android.util.LongSparseArray;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gr6 a;
    public LongSparseArray<Integer> b;
    public mm6 c;
    public er6 d;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr6 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(fr6 fr6Var, yr6 yr6Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr6Var, yr6Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr6Var;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yr6 yr6Var = this.a;
                if (yr6Var != null) {
                    yr6Var.o(this.b, this.c);
                }
                TiebaStatic.log(new StatisticItem("c13982").param("fid", this.c).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public fr6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = new gr6();
        this.b = new LongSparseArray<>();
    }

    public int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == 0) {
                return 0;
            }
            Integer num = this.b.get(j);
            if (num == null) {
                this.b.put(j, 1);
                return 1;
            }
            this.b.put(j, Integer.valueOf(num.intValue() + 1));
            return num.intValue() + 1;
        }
        return invokeJ.intValue;
    }

    public void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j == 0) {
            return;
        }
        this.b.remove(j);
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.a.b(str, str2);
        }
    }

    public void d() {
        mm6 mm6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (mm6Var = this.c) == null) {
            return;
        }
        mm6Var.m();
    }

    public gr6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (gr6) invokeV.objValue;
    }

    public void f(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, str2) == null) && activity != null && this.d.c()) {
            if (this.c == null) {
                this.c = new mm6(activity, R.id.obfuscated_res_0x7f090b2c);
            }
            this.c.p(str);
            this.c.q(str2);
            this.c.r();
        }
    }

    public boolean g(String str, String str2) {
        InterceptResult invokeLL;
        gr6 gr6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str2) || "0".equals(str) || "0".equals(str2) || (gr6Var = this.a) == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - gr6Var.f(str, str2);
            if (currentTimeMillis < 3600000) {
                return false;
            }
            if (this.a.e(str, str2) <= 3 || currentTimeMillis >= 2592000000L) {
                long c = this.a.c(str, str2);
                if (c == 0 || System.currentTimeMillis() - c > 604800000) {
                    return this.a.d(str, str2);
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void h(Activity activity, String str, String str2, String str3, yr6 yr6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048583, this, activity, str, str2, str3, yr6Var) == null) || activity == null) {
            return;
        }
        if (this.c == null) {
            this.c = new mm6(activity, R.id.obfuscated_res_0x7f090b30);
        }
        if (!StringUtils.isNull(str3)) {
            this.c.n(str3);
        }
        this.c.o(new a(this, yr6Var, str, str2));
        this.c.s();
        TiebaStatic.log(new StatisticItem("c13894").param("fid", str2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public fr6(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.d = new er6(str, str2);
    }
}
