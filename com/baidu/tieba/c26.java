package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class c26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c26 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Integer> a;
    public z16 b;
    public b26 c;
    public List<StatisticItem> d;

    public c26() {
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
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.a = arrayList;
        arrayList.add(1);
        this.a.add(2);
        b26 b26Var = new b26();
        this.c = b26Var;
        this.b = new z16(b26Var, this.a);
        g(SharedPrefHelper.getInstance().getInt("key_abtest_channel", 0));
    }

    public static c26 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (e == null) {
                synchronized (b26.class) {
                    if (e == null) {
                        e = new c26();
                    }
                }
            }
            return e;
        }
        return (c26) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, statisticItem) != null) || statisticItem == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.add(statisticItem);
    }

    public void d(String str) {
        b26 b26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (rd.isEmpty(str) || (b26Var = this.c) == null || !b26Var.g()) {
                irb.d(str);
            }
        }
    }

    public void e(String str) {
        b26 b26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (rd.isEmpty(str) || (b26Var = this.c) == null || !b26Var.g()) {
                irb.e(str);
            }
        }
    }

    public void f(String str) {
        z16 z16Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (z16Var = this.b) != null) {
            z16Var.b(str);
        }
    }

    public void g(int i) {
        b26 b26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (b26Var = this.c) != null) {
            b26Var.k(i);
        }
    }

    public int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            z16 z16Var = this.b;
            if (z16Var == null) {
                return 0;
            }
            return z16Var.a(str, i);
        }
        return invokeLI.intValue;
    }

    public void h(String str, String str2) {
        b26 b26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) && !ListUtils.isEmpty(this.d) && (b26Var = this.c) != null && b26Var.g()) {
            int i = -1;
            for (StatisticItem statisticItem : this.d) {
                if (statisticItem != null) {
                    if (statisticItem.getPosition() == 0) {
                        i(str, str2, statisticItem);
                    } else if (i != statisticItem.getPosition()) {
                        i = statisticItem.getPosition();
                        i(str, str2, statisticItem);
                    }
                }
            }
            this.d.clear();
        }
    }

    public void i(String str, String str2, StatisticItem statisticItem) {
        b26 b26Var;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, statisticItem) == null) && statisticItem != null && (b26Var = this.c) != null && b26Var.g()) {
            HashMap hashMap = new HashMap();
            List<Object> params = statisticItem.getParams();
            if (params != null) {
                int size = params.size();
                for (int i = 0; i < size; i += 2) {
                    Object obj = params.get(i);
                    if (obj == null) {
                        str3 = "";
                    } else {
                        str3 = obj.toString();
                    }
                    Object obj2 = params.get(i + 1);
                    if (obj2 == null) {
                        str4 = "";
                    } else {
                        str4 = obj2.toString();
                    }
                    hashMap.put(str3, str4);
                }
            }
            irb.c(str2 + statisticItem.getKey(), str, "", hashMap);
        }
    }
}
