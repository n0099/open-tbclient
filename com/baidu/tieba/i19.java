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
/* loaded from: classes6.dex */
public class i19 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947800792, "Lcom/baidu/tieba/i19;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947800792, "Lcom/baidu/tieba/i19;");
        }
    }

    public i19() {
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

    public void a(int i, d19 d19Var, int i2, List<vn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<b19> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), d19Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && d19Var != null && (list2 = d19Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<b19> list3 = d19Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (b19 b19Var : list3) {
                    if (b19Var != null && i == b19Var.b.intValue()) {
                        List<h19> list4 = b19Var.a;
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
                                            e19 e19Var = new e19();
                                            e19Var.l(b19Var.b.intValue());
                                            e19Var.k(recommendForumInfo.avatar);
                                            e19Var.n(recommendForumInfo.forum_id.longValue());
                                            e19Var.o(recommendForumInfo.forum_name);
                                            e19Var.p(recommendForumInfo.member_count.intValue());
                                            e19Var.t(recommendForumInfo.thread_count.intValue());
                                            e19Var.s(recommendForumInfo.slogan);
                                            e19Var.q(false);
                                            list.add(i2, e19Var);
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

    public List<vn> b(List<b19> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (b19 b19Var : list) {
                    if (b19Var != null) {
                        g19 g19Var = new g19();
                        g19Var.d(b19Var.b.intValue());
                        g19Var.c(b19Var.d);
                        g19Var.e(b19Var.c);
                        arrayList.add(g19Var);
                        List<h19> list2 = b19Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (h19 h19Var : list2) {
                                if (h19Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    e19 e19Var = new e19();
                                    RecommendForumInfo recommendForumInfo = h19Var.a;
                                    e19Var.l(b19Var.b.intValue());
                                    e19Var.m(b19Var.c);
                                    e19Var.k(recommendForumInfo.avatar);
                                    e19Var.n(recommendForumInfo.forum_id.longValue());
                                    e19Var.o(recommendForumInfo.forum_name);
                                    e19Var.p(recommendForumInfo.member_count.intValue());
                                    e19Var.t(recommendForumInfo.thread_count.intValue());
                                    e19Var.s(recommendForumInfo.slogan);
                                    arrayList.add(e19Var);
                                    a++;
                                }
                            }
                            f19 f19Var = new f19();
                            f19Var.d(b19Var.b.intValue());
                            f19Var.e(b19Var.c);
                            arrayList.add(f19Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<vn> list2) {
        e19 e19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (vn vnVar : list2) {
                if ((vnVar instanceof e19) && (e19Var = (e19) vnVar) != null && e19Var.b() == i) {
                    list.add(Long.valueOf(e19Var.c()));
                }
            }
        }
    }

    public final void d(vn vnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, vnVar) == null) && (vnVar instanceof f19)) {
            ((f19) vnVar).f(false);
        }
    }
}
