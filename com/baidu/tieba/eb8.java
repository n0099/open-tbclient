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
public class eb8 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947728686, "Lcom/baidu/tieba/eb8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947728686, "Lcom/baidu/tieba/eb8;");
        }
    }

    public eb8() {
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

    public void a(int i, za8 za8Var, int i2, List<Cdo> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<xa8> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), za8Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && za8Var != null && (list2 = za8Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<xa8> list3 = za8Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (xa8 xa8Var : list3) {
                    if (xa8Var != null && i == xa8Var.b.intValue()) {
                        List<db8> list4 = xa8Var.a;
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
                                            ab8 ab8Var = new ab8();
                                            ab8Var.m(xa8Var.b.intValue());
                                            ab8Var.l(recommendForumInfo.avatar);
                                            ab8Var.o(recommendForumInfo.forum_id.longValue());
                                            ab8Var.q(recommendForumInfo.forum_name);
                                            ab8Var.r(recommendForumInfo.member_count.intValue());
                                            ab8Var.u(recommendForumInfo.thread_count.intValue());
                                            ab8Var.t(recommendForumInfo.slogan);
                                            ab8Var.s(false);
                                            list.add(i2, ab8Var);
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

    public List<Cdo> b(List<xa8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (xa8 xa8Var : list) {
                    if (xa8Var != null) {
                        cb8 cb8Var = new cb8();
                        cb8Var.f(xa8Var.b.intValue());
                        cb8Var.c(xa8Var.d);
                        cb8Var.g(xa8Var.c);
                        arrayList.add(cb8Var);
                        List<db8> list2 = xa8Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (db8 db8Var : list2) {
                                if (db8Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    ab8 ab8Var = new ab8();
                                    RecommendForumInfo recommendForumInfo = db8Var.a;
                                    ab8Var.m(xa8Var.b.intValue());
                                    ab8Var.n(xa8Var.c);
                                    ab8Var.l(recommendForumInfo.avatar);
                                    ab8Var.o(recommendForumInfo.forum_id.longValue());
                                    ab8Var.q(recommendForumInfo.forum_name);
                                    ab8Var.r(recommendForumInfo.member_count.intValue());
                                    ab8Var.u(recommendForumInfo.thread_count.intValue());
                                    ab8Var.t(recommendForumInfo.slogan);
                                    arrayList.add(ab8Var);
                                    a++;
                                }
                            }
                            bb8 bb8Var = new bb8();
                            bb8Var.f(xa8Var.b.intValue());
                            bb8Var.g(xa8Var.c);
                            arrayList.add(bb8Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<Cdo> list2) {
        ab8 ab8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (Cdo cdo : list2) {
                if ((cdo instanceof ab8) && (ab8Var = (ab8) cdo) != null && ab8Var.b() == i) {
                    list.add(Long.valueOf(ab8Var.c()));
                }
            }
        }
    }

    public final void d(Cdo cdo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cdo) == null) && (cdo instanceof bb8)) {
            ((bb8) cdo).h(false);
        }
    }
}
