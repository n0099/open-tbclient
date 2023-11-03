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
public class dp9 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947712380, "Lcom/baidu/tieba/dp9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947712380, "Lcom/baidu/tieba/dp9;");
        }
    }

    public dp9() {
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

    public void a(int i, yo9 yo9Var, int i2, List<oi> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<wo9> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), yo9Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) && yo9Var != null && (list2 = yo9Var.a) != null && !ListUtils.isEmpty(list2)) {
            ArrayList arrayList = new ArrayList();
            c(i, arrayList, list);
            List<wo9> list3 = yo9Var.a;
            if (list3 != null && list3.size() > 0) {
                int i3 = 0;
                for (wo9 wo9Var : list3) {
                    if (wo9Var != null && i == wo9Var.b.intValue()) {
                        List<cp9> list4 = wo9Var.a;
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
                                            zo9 zo9Var = new zo9();
                                            zo9Var.l(wo9Var.b.intValue());
                                            zo9Var.i(recommendForumInfo.avatar);
                                            zo9Var.o(recommendForumInfo.forum_id.longValue());
                                            zo9Var.p(recommendForumInfo.forum_name);
                                            zo9Var.q(recommendForumInfo.member_count.intValue());
                                            zo9Var.u(recommendForumInfo.thread_count.intValue());
                                            zo9Var.t(recommendForumInfo.slogan);
                                            zo9Var.s(false);
                                            list.add(i2, zo9Var);
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

    public List<oi> b(List<wo9> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (wo9 wo9Var : list) {
                    if (wo9Var != null) {
                        bp9 bp9Var = new bp9();
                        bp9Var.d(wo9Var.b.intValue());
                        bp9Var.c(wo9Var.d);
                        bp9Var.e(wo9Var.c);
                        arrayList.add(bp9Var);
                        List<cp9> list2 = wo9Var.a;
                        if (list2 != null && list2.size() > 0) {
                            a = 0;
                            for (cp9 cp9Var : list2) {
                                if (cp9Var != null) {
                                    if (a >= 4) {
                                        break;
                                    }
                                    zo9 zo9Var = new zo9();
                                    RecommendForumInfo recommendForumInfo = cp9Var.a;
                                    zo9Var.l(wo9Var.b.intValue());
                                    zo9Var.n(wo9Var.c);
                                    zo9Var.i(recommendForumInfo.avatar);
                                    zo9Var.o(recommendForumInfo.forum_id.longValue());
                                    zo9Var.p(recommendForumInfo.forum_name);
                                    zo9Var.q(recommendForumInfo.member_count.intValue());
                                    zo9Var.u(recommendForumInfo.thread_count.intValue());
                                    zo9Var.t(recommendForumInfo.slogan);
                                    arrayList.add(zo9Var);
                                    a++;
                                }
                            }
                            ap9 ap9Var = new ap9();
                            ap9Var.d(wo9Var.b.intValue());
                            ap9Var.e(wo9Var.c);
                            arrayList.add(ap9Var);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<oi> list2) {
        zo9 zo9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (oi oiVar : list2) {
                if ((oiVar instanceof zo9) && (zo9Var = (zo9) oiVar) != null && zo9Var.b() == i) {
                    list.add(Long.valueOf(zo9Var.c()));
                }
            }
        }
    }

    public final void d(oi oiVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, oiVar) == null) && (oiVar instanceof ap9)) {
            ((ap9) oiVar).f(false);
        }
    }
}
