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
/* loaded from: classes5.dex */
public class g29 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947742171, "Lcom/baidu/tieba/g29;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947742171, "Lcom/baidu/tieba/g29;");
        }
    }

    public g29() {
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

    public void a(int i, b29 b29Var, int i2, List<wn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<z19> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), b29Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && b29Var != null && (list2 = b29Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<z19> list3 = b29Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (z19 z19Var : list3) {
                    if (z19Var != null && i == z19Var.b.intValue()) {
                        List<f29> list4 = z19Var.a;
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
                                            c29 c29Var = new c29();
                                            c29Var.l(z19Var.b.intValue());
                                            c29Var.k(recommendForumInfo.avatar);
                                            c29Var.n(recommendForumInfo.forum_id.longValue());
                                            c29Var.o(recommendForumInfo.forum_name);
                                            c29Var.p(recommendForumInfo.member_count.intValue());
                                            c29Var.t(recommendForumInfo.thread_count.intValue());
                                            c29Var.s(recommendForumInfo.slogan);
                                            c29Var.q(false);
                                            list.add(i2, c29Var);
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

    public List<wn> b(List<z19> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (z19 z19Var : list) {
                    if (z19Var != null) {
                        e29 e29Var = new e29();
                        e29Var.d(z19Var.b.intValue());
                        e29Var.c(z19Var.d);
                        e29Var.e(z19Var.c);
                        arrayList.add(e29Var);
                        List<f29> list2 = z19Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (f29 f29Var : list2) {
                                if (f29Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    c29 c29Var = new c29();
                                    RecommendForumInfo recommendForumInfo = f29Var.a;
                                    c29Var.l(z19Var.b.intValue());
                                    c29Var.m(z19Var.c);
                                    c29Var.k(recommendForumInfo.avatar);
                                    c29Var.n(recommendForumInfo.forum_id.longValue());
                                    c29Var.o(recommendForumInfo.forum_name);
                                    c29Var.p(recommendForumInfo.member_count.intValue());
                                    c29Var.t(recommendForumInfo.thread_count.intValue());
                                    c29Var.s(recommendForumInfo.slogan);
                                    arrayList.add(c29Var);
                                    a++;
                                }
                            }
                            d29 d29Var = new d29();
                            d29Var.d(z19Var.b.intValue());
                            d29Var.e(z19Var.c);
                            arrayList.add(d29Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<wn> list2) {
        c29 c29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (wn wnVar : list2) {
                if ((wnVar instanceof c29) && (c29Var = (c29) wnVar) != null && c29Var.b() == i) {
                    list.add(Long.valueOf(c29Var.c()));
                }
            }
        }
    }

    public final void d(wn wnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, wnVar) == null) && (wnVar instanceof d29)) {
            ((d29) wnVar).f(false);
        }
    }
}
