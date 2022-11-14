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
public class gv7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947807457, "Lcom/baidu/tieba/gv7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947807457, "Lcom/baidu/tieba/gv7;");
        }
    }

    public gv7() {
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

    public void a(int i, bv7 bv7Var, int i2, List<xn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<zu7> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), bv7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && bv7Var != null && (list2 = bv7Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<zu7> list3 = bv7Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (zu7 zu7Var : list3) {
                    if (zu7Var != null && i == zu7Var.b.intValue()) {
                        List<fv7> list4 = zu7Var.a;
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
                                            cv7 cv7Var = new cv7();
                                            cv7Var.n(zu7Var.b.intValue());
                                            cv7Var.l(recommendForumInfo.avatar);
                                            cv7Var.q(recommendForumInfo.forum_id.longValue());
                                            cv7Var.r(recommendForumInfo.forum_name);
                                            cv7Var.s(recommendForumInfo.member_count.intValue());
                                            cv7Var.w(recommendForumInfo.thread_count.intValue());
                                            cv7Var.v(recommendForumInfo.slogan);
                                            cv7Var.t(false);
                                            list.add(i2, cv7Var);
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

    public List<xn> b(List<zu7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (zu7 zu7Var : list) {
                    if (zu7Var != null) {
                        ev7 ev7Var = new ev7();
                        ev7Var.f(zu7Var.b.intValue());
                        ev7Var.c(zu7Var.d);
                        ev7Var.g(zu7Var.c);
                        arrayList.add(ev7Var);
                        List<fv7> list2 = zu7Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (fv7 fv7Var : list2) {
                                if (fv7Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    cv7 cv7Var = new cv7();
                                    RecommendForumInfo recommendForumInfo = fv7Var.a;
                                    cv7Var.n(zu7Var.b.intValue());
                                    cv7Var.o(zu7Var.c);
                                    cv7Var.l(recommendForumInfo.avatar);
                                    cv7Var.q(recommendForumInfo.forum_id.longValue());
                                    cv7Var.r(recommendForumInfo.forum_name);
                                    cv7Var.s(recommendForumInfo.member_count.intValue());
                                    cv7Var.w(recommendForumInfo.thread_count.intValue());
                                    cv7Var.v(recommendForumInfo.slogan);
                                    arrayList.add(cv7Var);
                                    a++;
                                }
                            }
                            dv7 dv7Var = new dv7();
                            dv7Var.f(zu7Var.b.intValue());
                            dv7Var.g(zu7Var.c);
                            arrayList.add(dv7Var);
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
        cv7 cv7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (xn xnVar : list2) {
                if ((xnVar instanceof cv7) && (cv7Var = (cv7) xnVar) != null && cv7Var.b() == i) {
                    list.add(Long.valueOf(cv7Var.c()));
                }
            }
        }
    }

    public final void d(xn xnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xnVar) == null) && (xnVar instanceof dv7)) {
            ((dv7) xnVar).h(false);
        }
    }
}
