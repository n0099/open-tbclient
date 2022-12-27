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
public class gy7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947810340, "Lcom/baidu/tieba/gy7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947810340, "Lcom/baidu/tieba/gy7;");
        }
    }

    public gy7() {
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

    public void a(int i, by7 by7Var, int i2, List<xn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<zx7> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), by7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && by7Var != null && (list2 = by7Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<zx7> list3 = by7Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (zx7 zx7Var : list3) {
                    if (zx7Var != null && i == zx7Var.b.intValue()) {
                        List<fy7> list4 = zx7Var.a;
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
                                            cy7 cy7Var = new cy7();
                                            cy7Var.m(zx7Var.b.intValue());
                                            cy7Var.l(recommendForumInfo.avatar);
                                            cy7Var.p(recommendForumInfo.forum_id.longValue());
                                            cy7Var.q(recommendForumInfo.forum_name);
                                            cy7Var.r(recommendForumInfo.member_count.intValue());
                                            cy7Var.v(recommendForumInfo.thread_count.intValue());
                                            cy7Var.t(recommendForumInfo.slogan);
                                            cy7Var.s(false);
                                            list.add(i2, cy7Var);
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

    public List<xn> b(List<zx7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (zx7 zx7Var : list) {
                    if (zx7Var != null) {
                        ey7 ey7Var = new ey7();
                        ey7Var.f(zx7Var.b.intValue());
                        ey7Var.c(zx7Var.d);
                        ey7Var.g(zx7Var.c);
                        arrayList.add(ey7Var);
                        List<fy7> list2 = zx7Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (fy7 fy7Var : list2) {
                                if (fy7Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    cy7 cy7Var = new cy7();
                                    RecommendForumInfo recommendForumInfo = fy7Var.a;
                                    cy7Var.m(zx7Var.b.intValue());
                                    cy7Var.o(zx7Var.c);
                                    cy7Var.l(recommendForumInfo.avatar);
                                    cy7Var.p(recommendForumInfo.forum_id.longValue());
                                    cy7Var.q(recommendForumInfo.forum_name);
                                    cy7Var.r(recommendForumInfo.member_count.intValue());
                                    cy7Var.v(recommendForumInfo.thread_count.intValue());
                                    cy7Var.t(recommendForumInfo.slogan);
                                    arrayList.add(cy7Var);
                                    a++;
                                }
                            }
                            dy7 dy7Var = new dy7();
                            dy7Var.f(zx7Var.b.intValue());
                            dy7Var.g(zx7Var.c);
                            arrayList.add(dy7Var);
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
        cy7 cy7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (xn xnVar : list2) {
                if ((xnVar instanceof cy7) && (cy7Var = (cy7) xnVar) != null && cy7Var.b() == i) {
                    list.add(Long.valueOf(cy7Var.c()));
                }
            }
        }
    }

    public final void d(xn xnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) && (xnVar instanceof dy7)) {
            ((dy7) xnVar).h(false);
        }
    }
}
