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
/* loaded from: classes3.dex */
public class dr7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947714240, "Lcom/baidu/tieba/dr7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947714240, "Lcom/baidu/tieba/dr7;");
        }
    }

    public dr7() {
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

    public void a(int i, yq7 yq7Var, int i2, List<pn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<wq7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), yq7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || yq7Var == null || (list2 = yq7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<wq7> list3 = yq7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (wq7 wq7Var : list3) {
            if (wq7Var != null && i == wq7Var.b.intValue()) {
                List<cr7> list4 = wq7Var.a;
                if (list4 == null || list4.size() <= 0) {
                    return;
                }
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
                                zq7 zq7Var = new zq7();
                                zq7Var.n(wq7Var.b.intValue());
                                zq7Var.l(recommendForumInfo.avatar);
                                zq7Var.q(recommendForumInfo.forum_id.longValue());
                                zq7Var.r(recommendForumInfo.forum_name);
                                zq7Var.s(recommendForumInfo.member_count.intValue());
                                zq7Var.w(recommendForumInfo.thread_count.intValue());
                                zq7Var.v(recommendForumInfo.slogan);
                                zq7Var.t(false);
                                list.add(i2, zq7Var);
                                arrayList.add(recommendForumInfo.forum_id);
                                i2++;
                                i3++;
                            }
                        }
                    }
                }
                bdTypeRecyclerView.setData(list);
            }
        }
    }

    public List<pn> b(List<wq7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (wq7 wq7Var : list) {
                if (wq7Var != null) {
                    br7 br7Var = new br7();
                    br7Var.f(wq7Var.b.intValue());
                    br7Var.c(wq7Var.d);
                    br7Var.g(wq7Var.c);
                    arrayList.add(br7Var);
                    List<cr7> list2 = wq7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (cr7 cr7Var : list2) {
                            if (cr7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                zq7 zq7Var = new zq7();
                                RecommendForumInfo recommendForumInfo = cr7Var.a;
                                zq7Var.n(wq7Var.b.intValue());
                                zq7Var.o(wq7Var.c);
                                zq7Var.l(recommendForumInfo.avatar);
                                zq7Var.q(recommendForumInfo.forum_id.longValue());
                                zq7Var.r(recommendForumInfo.forum_name);
                                zq7Var.s(recommendForumInfo.member_count.intValue());
                                zq7Var.w(recommendForumInfo.thread_count.intValue());
                                zq7Var.v(recommendForumInfo.slogan);
                                arrayList.add(zq7Var);
                                a++;
                            }
                        }
                        ar7 ar7Var = new ar7();
                        ar7Var.f(wq7Var.b.intValue());
                        ar7Var.g(wq7Var.c);
                        arrayList.add(ar7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<pn> list2) {
        zq7 zq7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (pn pnVar : list2) {
                if ((pnVar instanceof zq7) && (zq7Var = (zq7) pnVar) != null && zq7Var.b() == i) {
                    list.add(Long.valueOf(zq7Var.c()));
                }
            }
        }
    }

    public final void d(pn pnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pnVar) == null) && (pnVar instanceof ar7)) {
            ((ar7) pnVar).h(false);
        }
    }
}
