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
public class bt7 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947656580, "Lcom/baidu/tieba/bt7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947656580, "Lcom/baidu/tieba/bt7;");
        }
    }

    public bt7() {
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

    public void a(int i, ws7 ws7Var, int i2, List<Cdo> list, BdTypeRecyclerView bdTypeRecyclerView) {
        List<us7> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), ws7Var, Integer.valueOf(i2), list, bdTypeRecyclerView}) == null) || ws7Var == null || (list2 = ws7Var.a) == null || ListUtils.isEmpty(list2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        c(i, arrayList, list);
        List<us7> list3 = ws7Var.a;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (us7 us7Var : list3) {
            if (us7Var != null && i == us7Var.b.intValue()) {
                List<at7> list4 = us7Var.a;
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
                                xs7 xs7Var = new xs7();
                                xs7Var.n(us7Var.b.intValue());
                                xs7Var.l(recommendForumInfo.avatar);
                                xs7Var.q(recommendForumInfo.forum_id.longValue());
                                xs7Var.r(recommendForumInfo.forum_name);
                                xs7Var.s(recommendForumInfo.member_count.intValue());
                                xs7Var.w(recommendForumInfo.thread_count.intValue());
                                xs7Var.v(recommendForumInfo.slogan);
                                xs7Var.t(false);
                                list.add(i2, xs7Var);
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

    public List<Cdo> b(List<us7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (us7 us7Var : list) {
                if (us7Var != null) {
                    zs7 zs7Var = new zs7();
                    zs7Var.f(us7Var.b.intValue());
                    zs7Var.c(us7Var.d);
                    zs7Var.g(us7Var.c);
                    arrayList.add(zs7Var);
                    List<at7> list2 = us7Var.a;
                    if (list2 != null && list2.size() > 0) {
                        a = 0;
                        for (at7 at7Var : list2) {
                            if (at7Var != null) {
                                if (a >= 4) {
                                    break;
                                }
                                xs7 xs7Var = new xs7();
                                RecommendForumInfo recommendForumInfo = at7Var.a;
                                xs7Var.n(us7Var.b.intValue());
                                xs7Var.o(us7Var.c);
                                xs7Var.l(recommendForumInfo.avatar);
                                xs7Var.q(recommendForumInfo.forum_id.longValue());
                                xs7Var.r(recommendForumInfo.forum_name);
                                xs7Var.s(recommendForumInfo.member_count.intValue());
                                xs7Var.w(recommendForumInfo.thread_count.intValue());
                                xs7Var.v(recommendForumInfo.slogan);
                                arrayList.add(xs7Var);
                                a++;
                            }
                        }
                        ys7 ys7Var = new ys7();
                        ys7Var.f(us7Var.b.intValue());
                        ys7Var.g(us7Var.c);
                        arrayList.add(ys7Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void c(int i, List<Long> list, List<Cdo> list2) {
        xs7 xs7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, list, list2) == null) {
            for (Cdo cdo : list2) {
                if ((cdo instanceof xs7) && (xs7Var = (xs7) cdo) != null && xs7Var.b() == i) {
                    list.add(Long.valueOf(xs7Var.c()));
                }
            }
        }
    }

    public final void d(Cdo cdo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cdo) == null) && (cdo instanceof ys7)) {
            ((ys7) cdo).h(false);
        }
    }
}
