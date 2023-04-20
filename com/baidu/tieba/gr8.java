package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class gr8 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947803644, "Lcom/baidu/tieba/gr8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947803644, "Lcom/baidu/tieba/gr8;");
        }
    }

    public gr8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(int i, br8 br8Var, int i2, List<in> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<zq8> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), br8Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && br8Var != null && (list2 = br8Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<zq8> list3 = br8Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (zq8 zq8Var : list3) {
                    if (zq8Var != null && i == zq8Var.b.intValue()) {
                        List<fr8> list4 = zq8Var.a;
                        if (list4 != null && list4.size() > 0) {
                            for (int i4 = 0; i4 < list4.size(); i4++) {
                                if (list4.get(i4) != null) {
                                    if (arrayList.size() >= 20) {
                                        d(list.get(i2));
                                        bdTypeRecyclerView.setData(list);
                                        return;
                                    } else if (i3 >= 4) {
                                        bdTypeRecyclerView.setData(list);
                                        return;
                                    } else {
                                        if (i4 == list4.size() - 1) {
                                            d(list.get(i2));
                                        }
                                        RecommendForumInfo recommendForumInfo = list4.get(i4).a;
                                        if (!arrayList.contains(recommendForumInfo.forum_id)) {
                                            cr8 cr8Var = new cr8();
                                            cr8Var.l(zq8Var.b.intValue());
                                            cr8Var.k(recommendForumInfo.avatar);
                                            cr8Var.n(recommendForumInfo.forum_id.longValue());
                                            cr8Var.o(recommendForumInfo.forum_name);
                                            cr8Var.q(recommendForumInfo.member_count.intValue());
                                            cr8Var.u(recommendForumInfo.thread_count.intValue());
                                            cr8Var.s(recommendForumInfo.slogan);
                                            cr8Var.r(false);
                                            list.add(i2, cr8Var);
                                            arrayList.add(recommendForumInfo.forum_id);
                                            i2++;
                                            i3++;
                                        }
                                    }
                                }
                            }
                            bdTypeRecyclerView.setData(list);
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public List<in> b(List<zq8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (zq8 zq8Var : list) {
                    if (zq8Var != null) {
                        er8 er8Var = new er8();
                        er8Var.d(zq8Var.b.intValue());
                        er8Var.c(zq8Var.d);
                        er8Var.e(zq8Var.c);
                        arrayList.add(er8Var);
                        List<fr8> list2 = zq8Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (fr8 fr8Var : list2) {
                                if (fr8Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    cr8 cr8Var = new cr8();
                                    RecommendForumInfo recommendForumInfo = fr8Var.a;
                                    cr8Var.l(zq8Var.b.intValue());
                                    cr8Var.m(zq8Var.c);
                                    cr8Var.k(recommendForumInfo.avatar);
                                    cr8Var.n(recommendForumInfo.forum_id.longValue());
                                    cr8Var.o(recommendForumInfo.forum_name);
                                    cr8Var.q(recommendForumInfo.member_count.intValue());
                                    cr8Var.u(recommendForumInfo.thread_count.intValue());
                                    cr8Var.s(recommendForumInfo.slogan);
                                    arrayList.add(cr8Var);
                                    a++;
                                }
                            }
                            dr8 dr8Var = new dr8();
                            dr8Var.d(zq8Var.b.intValue());
                            dr8Var.e(zq8Var.c);
                            arrayList.add(dr8Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<in> list2) {
        cr8 cr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (in inVar : list2) {
                if ((inVar instanceof cr8) && (cr8Var = (cr8) inVar) != null && cr8Var.b() == i) {
                    list.add(Long.valueOf(cr8Var.c()));
                }
            }
        }
    }

    public final void d(in inVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, inVar) == null) && (inVar instanceof dr8)) {
            ((dr8) inVar).f(false);
        }
    }
}
