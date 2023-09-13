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
public class ag9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947614358, "Lcom/baidu/tieba/ag9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947614358, "Lcom/baidu/tieba/ag9;");
        }
    }

    public ag9() {
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

    public void a(int i, vf9 vf9Var, int i2, List<cn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<tf9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), vf9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && vf9Var != null && (list2 = vf9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<tf9> list3 = vf9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (tf9 tf9Var : list3) {
                    if (tf9Var != null && i == tf9Var.b.intValue()) {
                        List<zf9> list4 = tf9Var.a;
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
                                            wf9 wf9Var = new wf9();
                                            wf9Var.l(tf9Var.b.intValue());
                                            wf9Var.i(recommendForumInfo.avatar);
                                            wf9Var.o(recommendForumInfo.forum_id.longValue());
                                            wf9Var.p(recommendForumInfo.forum_name);
                                            wf9Var.q(recommendForumInfo.member_count.intValue());
                                            wf9Var.u(recommendForumInfo.thread_count.intValue());
                                            wf9Var.t(recommendForumInfo.slogan);
                                            wf9Var.s(false);
                                            list.add(i2, wf9Var);
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

    public List<cn> b(List<tf9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (tf9 tf9Var : list) {
                    if (tf9Var != null) {
                        yf9 yf9Var = new yf9();
                        yf9Var.d(tf9Var.b.intValue());
                        yf9Var.c(tf9Var.d);
                        yf9Var.e(tf9Var.c);
                        arrayList.add(yf9Var);
                        List<zf9> list2 = tf9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (zf9 zf9Var : list2) {
                                if (zf9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    wf9 wf9Var = new wf9();
                                    RecommendForumInfo recommendForumInfo = zf9Var.a;
                                    wf9Var.l(tf9Var.b.intValue());
                                    wf9Var.m(tf9Var.c);
                                    wf9Var.i(recommendForumInfo.avatar);
                                    wf9Var.o(recommendForumInfo.forum_id.longValue());
                                    wf9Var.p(recommendForumInfo.forum_name);
                                    wf9Var.q(recommendForumInfo.member_count.intValue());
                                    wf9Var.u(recommendForumInfo.thread_count.intValue());
                                    wf9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(wf9Var);
                                    a++;
                                }
                            }
                            xf9 xf9Var = new xf9();
                            xf9Var.d(tf9Var.b.intValue());
                            xf9Var.e(tf9Var.c);
                            arrayList.add(xf9Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<cn> list2) {
        wf9 wf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (cn cnVar : list2) {
                if ((cnVar instanceof wf9) && (wf9Var = (wf9) cnVar) != null && wf9Var.b() == i) {
                    list.add(Long.valueOf(wf9Var.c()));
                }
            }
        }
    }

    public final void d(cn cnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cnVar) == null) && (cnVar instanceof xf9)) {
            ((xf9) cnVar).f(false);
        }
    }
}
