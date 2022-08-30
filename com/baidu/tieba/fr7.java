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
public class fr7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947773822, "Lcom/baidu/tieba/fr7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947773822, "Lcom/baidu/tieba/fr7;");
        }
    }

    public fr7() {
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

    public void a(int i, ar7 ar7Var, int i2, List<pn> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<yq7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ar7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || ar7Var == null || (list2 = ar7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<yq7> list3 = ar7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (yq7 yq7Var : list3) {
            if (yq7Var != null && i == yq7Var.b.intValue()) {
                List<er7> list4 = yq7Var.a;
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
                                br7 br7Var = new br7();
                                br7Var.n(yq7Var.b.intValue());
                                br7Var.l(recommendForumInfo.avatar);
                                br7Var.q(recommendForumInfo.forum_id.longValue());
                                br7Var.r(recommendForumInfo.forum_name);
                                br7Var.s(recommendForumInfo.member_count.intValue());
                                br7Var.w(recommendForumInfo.thread_count.intValue());
                                br7Var.v(recommendForumInfo.slogan);
                                br7Var.t(false);
                                list.add(i2, br7Var);
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

    public List<pn> b(List<yq7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (yq7 yq7Var : list) {
                if (yq7Var != null) {
                    dr7 dr7Var = new dr7();
                    dr7Var.f(yq7Var.b.intValue());
                    dr7Var.c(yq7Var.d);
                    dr7Var.g(yq7Var.c);
                    arrayList.add(dr7Var);
                    List<er7> list2 = yq7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (er7 er7Var : list2) {
                            if (er7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                br7 br7Var = new br7();
                                RecommendForumInfo recommendForumInfo = er7Var.a;
                                br7Var.n(yq7Var.b.intValue());
                                br7Var.o(yq7Var.c);
                                br7Var.l(recommendForumInfo.avatar);
                                br7Var.q(recommendForumInfo.forum_id.longValue());
                                br7Var.r(recommendForumInfo.forum_name);
                                br7Var.s(recommendForumInfo.member_count.intValue());
                                br7Var.w(recommendForumInfo.thread_count.intValue());
                                br7Var.v(recommendForumInfo.slogan);
                                arrayList.add(br7Var);
                                a++;
                            }
                        }
                        cr7 cr7Var = new cr7();
                        cr7Var.f(yq7Var.b.intValue());
                        cr7Var.g(yq7Var.c);
                        arrayList.add(cr7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<pn> list2) {
        br7 br7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (pn pnVar : list2) {
                if ((pnVar instanceof br7) && (br7Var = (br7) pnVar) != null && br7Var.b() == i) {
                    list.add(Long.valueOf(br7Var.c()));
                }
            }
        }
    }

    public final void d(pn pnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pnVar) == null) && (pnVar instanceof cr7)) {
            ((cr7) pnVar).h(false);
        }
    }
}
