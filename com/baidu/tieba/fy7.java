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
public class fy7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947780549, "Lcom/baidu/tieba/fy7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947780549, "Lcom/baidu/tieba/fy7;");
        }
    }

    public fy7() {
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

    public void a(int i, ay7 ay7Var, int i2, List<xn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<yx7> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ay7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && ay7Var != null && (list2 = ay7Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<yx7> list3 = ay7Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (yx7 yx7Var : list3) {
                    if (yx7Var != null && i == yx7Var.b.intValue()) {
                        List<ey7> list4 = yx7Var.a;
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
                                            by7 by7Var = new by7();
                                            by7Var.m(yx7Var.b.intValue());
                                            by7Var.l(recommendForumInfo.avatar);
                                            by7Var.p(recommendForumInfo.forum_id.longValue());
                                            by7Var.q(recommendForumInfo.forum_name);
                                            by7Var.r(recommendForumInfo.member_count.intValue());
                                            by7Var.v(recommendForumInfo.thread_count.intValue());
                                            by7Var.t(recommendForumInfo.slogan);
                                            by7Var.s(false);
                                            list.add(i2, by7Var);
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

    public List<xn> b(List<yx7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (yx7 yx7Var : list) {
                    if (yx7Var != null) {
                        dy7 dy7Var = new dy7();
                        dy7Var.f(yx7Var.b.intValue());
                        dy7Var.c(yx7Var.d);
                        dy7Var.g(yx7Var.c);
                        arrayList.add(dy7Var);
                        List<ey7> list2 = yx7Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (ey7 ey7Var : list2) {
                                if (ey7Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    by7 by7Var = new by7();
                                    RecommendForumInfo recommendForumInfo = ey7Var.a;
                                    by7Var.m(yx7Var.b.intValue());
                                    by7Var.o(yx7Var.c);
                                    by7Var.l(recommendForumInfo.avatar);
                                    by7Var.p(recommendForumInfo.forum_id.longValue());
                                    by7Var.q(recommendForumInfo.forum_name);
                                    by7Var.r(recommendForumInfo.member_count.intValue());
                                    by7Var.v(recommendForumInfo.thread_count.intValue());
                                    by7Var.t(recommendForumInfo.slogan);
                                    arrayList.add(by7Var);
                                    a++;
                                }
                            }
                            cy7 cy7Var = new cy7();
                            cy7Var.f(yx7Var.b.intValue());
                            cy7Var.g(yx7Var.c);
                            arrayList.add(cy7Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<xn> list2) {
        by7 by7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (xn xnVar : list2) {
                if ((xnVar instanceof by7) && (by7Var = (by7) xnVar) != null && by7Var.b() == i) {
                    list.add(Long.valueOf(by7Var.c()));
                }
            }
        }
    }

    public final void d(xn xnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) && (xnVar instanceof cy7)) {
            ((cy7) xnVar).h(false);
        }
    }
}
