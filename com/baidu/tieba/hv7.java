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
public class hv7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947837248, "Lcom/baidu/tieba/hv7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947837248, "Lcom/baidu/tieba/hv7;");
        }
    }

    public hv7() {
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

    public void a(int i, cv7 cv7Var, int i2, List<xn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<av7> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), cv7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && cv7Var != null && (list2 = cv7Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<av7> list3 = cv7Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (av7 av7Var : list3) {
                    if (av7Var != null && i == av7Var.b.intValue()) {
                        List<gv7> list4 = av7Var.a;
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
                                            dv7 dv7Var = new dv7();
                                            dv7Var.n(av7Var.b.intValue());
                                            dv7Var.l(recommendForumInfo.avatar);
                                            dv7Var.q(recommendForumInfo.forum_id.longValue());
                                            dv7Var.r(recommendForumInfo.forum_name);
                                            dv7Var.s(recommendForumInfo.member_count.intValue());
                                            dv7Var.w(recommendForumInfo.thread_count.intValue());
                                            dv7Var.v(recommendForumInfo.slogan);
                                            dv7Var.t(false);
                                            list.add(i2, dv7Var);
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

    public List<xn> b(List<av7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (av7 av7Var : list) {
                    if (av7Var != null) {
                        fv7 fv7Var = new fv7();
                        fv7Var.f(av7Var.b.intValue());
                        fv7Var.c(av7Var.d);
                        fv7Var.g(av7Var.c);
                        arrayList.add(fv7Var);
                        List<gv7> list2 = av7Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (gv7 gv7Var : list2) {
                                if (gv7Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    dv7 dv7Var = new dv7();
                                    RecommendForumInfo recommendForumInfo = gv7Var.a;
                                    dv7Var.n(av7Var.b.intValue());
                                    dv7Var.o(av7Var.c);
                                    dv7Var.l(recommendForumInfo.avatar);
                                    dv7Var.q(recommendForumInfo.forum_id.longValue());
                                    dv7Var.r(recommendForumInfo.forum_name);
                                    dv7Var.s(recommendForumInfo.member_count.intValue());
                                    dv7Var.w(recommendForumInfo.thread_count.intValue());
                                    dv7Var.v(recommendForumInfo.slogan);
                                    arrayList.add(dv7Var);
                                    a++;
                                }
                            }
                            ev7 ev7Var = new ev7();
                            ev7Var.f(av7Var.b.intValue());
                            ev7Var.g(av7Var.c);
                            arrayList.add(ev7Var);
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
        dv7 dv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (xn xnVar : list2) {
                if ((xnVar instanceof dv7) && (dv7Var = (dv7) xnVar) != null && dv7Var.b() == i) {
                    list.add(Long.valueOf(dv7Var.c()));
                }
            }
        }
    }

    public final void d(xn xnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) && (xnVar instanceof ev7)) {
            ((ev7) xnVar).h(false);
        }
    }
}
