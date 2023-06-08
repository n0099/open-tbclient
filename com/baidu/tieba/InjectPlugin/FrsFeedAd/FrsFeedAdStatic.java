package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.c46;
import com.baidu.tieba.fm9;
import com.baidu.tieba.h66;
import com.baidu.tieba.o36;
import com.baidu.tieba.p36;
import com.baidu.tieba.q36;
import com.baidu.tieba.t36;
import com.baidu.tieba.u36;
import com.baidu.tieba.v36;
import com.baidu.tieba.vn;
import com.baidu.tieba.w36;
import com.baidu.tieba.x36;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super(2016515);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c46 c46Var;
            u36 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof c46) || (c = (c46Var = (c46) customResponsedMessage.getData()).c()) == null || !(c instanceof fm9)) {
                return;
            }
            fm9 fm9Var = (fm9) c;
            t36 d1 = c.d1(1);
            if (d1 == null) {
                w36 a = x36.b().a(1);
                if (a == null) {
                    return;
                }
                d1 = a.a();
                c.A0(1, d1);
                d1.f(new v36(fm9Var), c46Var.i());
            }
            if (!(d1 instanceof q36)) {
                return;
            }
            q36 q36Var = (q36) d1;
            if (c46Var.a() == 1) {
                List list = (List) c46Var.f();
                o36.b(q36Var.d());
                for (BdUniqueId bdUniqueId : o36.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(fm9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(fm9Var.t());
                    list.add(frsFeedAdAdapter);
                }
            } else if (c46Var.a() == 2) {
                q36Var.k(c46Var.d());
            } else if (c46Var.a() == 3) {
                List<vn> o = c46Var.o();
                List<p36> d = FrsFeedAdStatic.d(o);
                if (c46Var.q()) {
                    q36Var.o(d, FrsFeedAdStatic.d(c46Var.l()), c46Var.p(), c46Var.e());
                } else {
                    q36Var.i(d, c46Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, c46Var.i()));
            } else if (c46Var.a() == 4) {
                q36Var.a(c46Var.n());
            } else if (c46Var.a() == 5) {
                q36Var.e(FrsFeedAdStatic.d(c46Var.o()), c46Var.h(), c46Var.g(), c46Var.m(), c46Var.j(), c46Var.r(), c46Var.k());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1910716457, "Lcom/baidu/tieba/InjectPlugin/FrsFeedAd/FrsFeedAdStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1910716457, "Lcom/baidu/tieba/InjectPlugin/FrsFeedAd/FrsFeedAdStatic;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a());
    }

    public FrsFeedAdStatic() {
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

    public static List<vn> c(List<p36> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (p36 p36Var : list) {
                    if (p36Var.c() == 3) {
                        o36 o36Var = new o36();
                        o36Var.f(p36Var.a());
                        o36Var.h(p36Var.b());
                        arrayList.add(o36Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (p36Var.a() instanceof vn) {
                        arrayList.add((vn) p36Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<p36> d(List<vn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (vn vnVar : list) {
                p36 p36Var = new p36();
                if (vnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) vnVar;
                    if (threadData.getIs_top() == 1) {
                        p36Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        p36Var.f(2);
                    } else {
                        p36Var.f(4);
                    }
                    p36Var.d(vnVar);
                } else if (vnVar instanceof o36) {
                    p36Var.f(3);
                    o36 o36Var = (o36) vnVar;
                    p36Var.e(o36Var.d());
                    p36Var.d(o36Var.a());
                } else {
                    p36Var.f(4);
                    p36Var.d(vnVar);
                }
                arrayList.add(p36Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (h66.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    h66.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && h66.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                h66.i().n(list, -1, 2);
            }
        }
    }
}
