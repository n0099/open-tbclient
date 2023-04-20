package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public ThreadData d;
    public c89 e;
    public String f;
    public boolean g;
    public qn8 h;

    public f89() {
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
        this.a = 0L;
        this.b = 0L;
        this.f = "1";
        this.h = new qn8();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.b > 0) {
                this.a += System.currentTimeMillis() - this.b;
                this.b = 0L;
            }
            k();
            this.a = 0L;
            this.b = 0L;
            this.g = false;
            this.h.a();
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.c;
            float f = ((float) this.a) / ((float) j);
            if (j <= 60000) {
                if (f >= 0.9d) {
                    return true;
                }
                return false;
            } else if (j <= LiveFeedPageSdk.REFRESH_TIME) {
                if (f >= 0.8d) {
                    return true;
                }
                return false;
            } else if (j <= 600000) {
                if (f >= 0.7d) {
                    return true;
                }
                return false;
            } else if (f >= 0.6d) {
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public c89 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (c89) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.b > 0) {
            this.a += System.currentTimeMillis() - this.b;
            this.b = 0L;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.b > 0) {
                this.a += System.currentTimeMillis() - this.b;
                this.b = 0L;
            }
            this.g = false;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h.e();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.b != 0) {
                this.a += System.currentTimeMillis() - this.b;
            }
            this.b = System.currentTimeMillis();
            this.g = true;
            this.h.b();
        }
    }

    public void f(o79 o79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, o79Var) == null) {
            this.h.d(o79Var);
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.c = j;
            this.h.c();
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f = str;
        }
    }

    public void m(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            this.d = threadData;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.c = i;
        }
    }

    public void o(c89 c89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, c89Var) == null) {
            this.e = c89Var;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.a = i;
        }
    }

    public final void k() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            long j = this.a;
            if (j >= 0 && j < 86400000) {
                if (j > 0) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TIME);
                    statisticItem.param(TiebaStatic.Params.OBJ_DURATION, this.a);
                    statisticItem.param("obj_type", this.f);
                    statisticItem.param("playduration", this.c);
                    statisticItem.param("player_type", 1);
                    statisticItem.param("is_finish", a() ? 1 : 0);
                    if (!hi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("task_id", TbadkCoreApplication.getInst().getTaskId());
                    }
                    c89 c89Var = this.e;
                    if (c89Var != null) {
                        c89Var.a(statisticItem);
                    }
                    if (!statisticItem.hasParam(TiebaStatic.Params.OBJ_PARAM5) && (threadData = this.d) != null) {
                        if (threadData.getBaijiahaoData() != null) {
                            if (this.d.getBaijiahaoData().oriUgcType == 2) {
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                            } else if (this.d.getBaijiahaoData().oriUgcType == 4) {
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                            }
                        } else {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
                        }
                    }
                    ThreadData threadData2 = this.d;
                    if (threadData2 != null) {
                        statisticItem.param(TiebaStatic.Params.IS_ZP, threadData2.isWorksInfo() ? 1 : 0);
                    }
                    TiebaStatic.log(statisticItem);
                    r79.d(this.a, this.f, this.e, "", this.c);
                } else if (this.g) {
                    r79.d(j, this.f, this.e, "", this.c);
                }
            }
        }
    }
}
