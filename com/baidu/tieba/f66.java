package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
/* loaded from: classes4.dex */
public final class f66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Set<d66> b;
    public int c;

    public f66(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = new LinkedHashSet();
    }

    public final d66 a(int i, int i2) {
        InterceptResult invokeII;
        d66 d66Var;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            synchronized (this) {
                Iterator<T> it = this.b.iterator();
                while (true) {
                    d66Var = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        d66 d66Var2 = (d66) obj;
                        if (d66Var2.l() >= i && d66Var2.j() >= i2 && d66Var2.l() - i < 5 && d66Var2.j() - i2 < 5) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                d66 d66Var3 = (d66) obj;
                if (d66Var3 != null) {
                    this.b.remove(d66Var3);
                    this.c -= d66Var3.k();
                    d66Var = d66Var3;
                }
            }
            return d66Var;
        }
        return (d66) invokeII.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                for (d66 d66Var : this.b) {
                    d66Var.e();
                }
                this.b.clear();
                this.c = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final boolean c(d66 d66Var) {
        InterceptResult invokeL;
        e66 g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d66Var)) == null) {
            if (d66Var == null) {
                g = null;
            } else {
                g = d66Var.g();
            }
            if (g == null) {
                return true;
            }
            if (this.b.contains(d66Var)) {
                return false;
            }
            if (d66Var.k() + this.c > this.a) {
                BdLog.v("DrawingCache [Release][+] OOM Pool");
                return false;
            }
            synchronized (this) {
                this.b.add(d66Var);
                d66Var.f();
                this.c += d66Var.k();
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
