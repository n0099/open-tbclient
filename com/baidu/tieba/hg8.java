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
public class hg8 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947822864, "Lcom/baidu/tieba/hg8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947822864, "Lcom/baidu/tieba/hg8;");
        }
    }

    public hg8() {
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

    public void a(int i, cg8 cg8Var, int i2, List<gn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<ag8> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), cg8Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && cg8Var != null && (list2 = cg8Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<ag8> list3 = cg8Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (ag8 ag8Var : list3) {
                    if (ag8Var != null && i == ag8Var.b.intValue()) {
                        List<gg8> list4 = ag8Var.a;
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
                                            dg8 dg8Var = new dg8();
                                            dg8Var.m(ag8Var.b.intValue());
                                            dg8Var.k(recommendForumInfo.avatar);
                                            dg8Var.o(recommendForumInfo.forum_id.longValue());
                                            dg8Var.p(recommendForumInfo.forum_name);
                                            dg8Var.r(recommendForumInfo.member_count.intValue());
                                            dg8Var.u(recommendForumInfo.thread_count.intValue());
                                            dg8Var.t(recommendForumInfo.slogan);
                                            dg8Var.s(false);
                                            list.add(i2, dg8Var);
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

    public List<gn> b(List<ag8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (ag8 ag8Var : list) {
                    if (ag8Var != null) {
                        fg8 fg8Var = new fg8();
                        fg8Var.f(ag8Var.b.intValue());
                        fg8Var.c(ag8Var.d);
                        fg8Var.g(ag8Var.c);
                        arrayList.add(fg8Var);
                        List<gg8> list2 = ag8Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (gg8 gg8Var : list2) {
                                if (gg8Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    dg8 dg8Var = new dg8();
                                    RecommendForumInfo recommendForumInfo = gg8Var.a;
                                    dg8Var.m(ag8Var.b.intValue());
                                    dg8Var.n(ag8Var.c);
                                    dg8Var.k(recommendForumInfo.avatar);
                                    dg8Var.o(recommendForumInfo.forum_id.longValue());
                                    dg8Var.p(recommendForumInfo.forum_name);
                                    dg8Var.r(recommendForumInfo.member_count.intValue());
                                    dg8Var.u(recommendForumInfo.thread_count.intValue());
                                    dg8Var.t(recommendForumInfo.slogan);
                                    arrayList.add(dg8Var);
                                    a++;
                                }
                            }
                            eg8 eg8Var = new eg8();
                            eg8Var.f(ag8Var.b.intValue());
                            eg8Var.g(ag8Var.c);
                            arrayList.add(eg8Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<gn> list2) {
        dg8 dg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (gn gnVar : list2) {
                if ((gnVar instanceof dg8) && (dg8Var = (dg8) gnVar) != null && dg8Var.b() == i) {
                    list.add(Long.valueOf(dg8Var.c()));
                }
            }
        }
    }

    public final void d(gn gnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, gnVar) == null) && (gnVar instanceof eg8)) {
            ((eg8) gnVar).h(false);
        }
    }
}
