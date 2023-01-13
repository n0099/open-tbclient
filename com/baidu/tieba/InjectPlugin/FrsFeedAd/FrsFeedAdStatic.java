package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.bt5;
import com.baidu.tieba.kq5;
import com.baidu.tieba.lq5;
import com.baidu.tieba.mq5;
import com.baidu.tieba.on8;
import com.baidu.tieba.pq5;
import com.baidu.tieba.qq5;
import com.baidu.tieba.rq5;
import com.baidu.tieba.sq5;
import com.baidu.tieba.tq5;
import com.baidu.tieba.yn;
import com.baidu.tieba.yq5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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
            yq5 yq5Var;
            qq5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof yq5) || (c = (yq5Var = (yq5) customResponsedMessage.getData()).c()) == null || !(c instanceof on8)) {
                return;
            }
            on8 on8Var = (on8) c;
            pq5 Y0 = c.Y0(1);
            if (Y0 == null) {
                sq5 a = tq5.b().a(1);
                if (a == null) {
                    return;
                }
                Y0 = a.a();
                c.v0(1, Y0);
                Y0.f(new rq5(on8Var), yq5Var.i());
            }
            if (!(Y0 instanceof mq5)) {
                return;
            }
            mq5 mq5Var = (mq5) Y0;
            if (yq5Var.a() == 1) {
                List list = (List) yq5Var.f();
                kq5.b(mq5Var.d());
                for (BdUniqueId bdUniqueId : kq5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(on8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(on8Var.p());
                    list.add(frsFeedAdAdapter);
                }
            } else if (yq5Var.a() == 2) {
                mq5Var.k(yq5Var.d());
            } else if (yq5Var.a() == 3) {
                List<yn> o = yq5Var.o();
                List<lq5> d = FrsFeedAdStatic.d(o);
                if (yq5Var.q()) {
                    mq5Var.o(d, FrsFeedAdStatic.d(yq5Var.l()), yq5Var.p(), yq5Var.e());
                } else {
                    mq5Var.i(d, yq5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, yq5Var.i()));
            } else if (yq5Var.a() == 4) {
                mq5Var.a(yq5Var.n());
            } else if (yq5Var.a() == 5) {
                mq5Var.e(FrsFeedAdStatic.d(yq5Var.o()), yq5Var.h(), yq5Var.g(), yq5Var.m(), yq5Var.j(), yq5Var.r(), yq5Var.k());
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

    public static List<yn> c(List<lq5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (lq5 lq5Var : list) {
                    if (lq5Var.c() == 3) {
                        kq5 kq5Var = new kq5();
                        kq5Var.h(lq5Var.a());
                        kq5Var.i(lq5Var.b());
                        arrayList.add(kq5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (lq5Var.a() instanceof yn) {
                        arrayList.add((yn) lq5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<lq5> d(List<yn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (yn ynVar : list) {
                lq5 lq5Var = new lq5();
                if (ynVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ynVar;
                    if (threadData.getIs_top() == 1) {
                        lq5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        lq5Var.f(2);
                    } else {
                        lq5Var.f(4);
                    }
                    lq5Var.d(ynVar);
                } else if (ynVar instanceof kq5) {
                    lq5Var.f(3);
                    kq5 kq5Var = (kq5) ynVar;
                    lq5Var.e(kq5Var.f());
                    lq5Var.d(kq5Var.a());
                } else {
                    lq5Var.f(4);
                    lq5Var.d(ynVar);
                }
                arrayList.add(lq5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (bt5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    bt5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && bt5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                bt5.i().n(list, -1, 2);
            }
        }
    }
}
