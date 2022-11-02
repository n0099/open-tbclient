package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.io5;
import com.baidu.tieba.jo5;
import com.baidu.tieba.ko5;
import com.baidu.tieba.no5;
import com.baidu.tieba.oo5;
import com.baidu.tieba.po5;
import com.baidu.tieba.qo5;
import com.baidu.tieba.ro5;
import com.baidu.tieba.sf8;
import com.baidu.tieba.wn;
import com.baidu.tieba.wo5;
import com.baidu.tieba.zq5;
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
            wo5 wo5Var;
            oo5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof wo5) || (c = (wo5Var = (wo5) customResponsedMessage.getData()).c()) == null || !(c instanceof sf8)) {
                return;
            }
            sf8 sf8Var = (sf8) c;
            no5 P0 = c.P0(1);
            if (P0 == null) {
                qo5 a = ro5.b().a(1);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                c.o0(1, P0);
                P0.f(new po5(sf8Var), wo5Var.i());
            }
            if (!(P0 instanceof ko5)) {
                return;
            }
            ko5 ko5Var = (ko5) P0;
            if (wo5Var.a() == 1) {
                List list = (List) wo5Var.f();
                io5.b(ko5Var.d());
                for (BdUniqueId bdUniqueId : io5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(sf8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(sf8Var.o());
                    list.add(frsFeedAdAdapter);
                }
            } else if (wo5Var.a() == 2) {
                ko5Var.k(wo5Var.d());
            } else if (wo5Var.a() == 3) {
                List<wn> o = wo5Var.o();
                List<jo5> d = FrsFeedAdStatic.d(o);
                if (wo5Var.q()) {
                    ko5Var.o(d, FrsFeedAdStatic.d(wo5Var.l()), wo5Var.p(), wo5Var.e());
                } else {
                    ko5Var.i(d, wo5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, wo5Var.i()));
            } else if (wo5Var.a() == 4) {
                ko5Var.a(wo5Var.n());
            } else if (wo5Var.a() == 5) {
                ko5Var.e(FrsFeedAdStatic.d(wo5Var.o()), wo5Var.h(), wo5Var.g(), wo5Var.m(), wo5Var.j(), wo5Var.r(), wo5Var.k());
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

    public static List<wn> c(List<jo5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (jo5 jo5Var : list) {
                    if (jo5Var.c() == 3) {
                        io5 io5Var = new io5();
                        io5Var.h(jo5Var.a());
                        io5Var.j(jo5Var.b());
                        arrayList.add(io5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (jo5Var.a() instanceof wn) {
                        arrayList.add((wn) jo5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<jo5> d(List<wn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (wn wnVar : list) {
                jo5 jo5Var = new jo5();
                if (wnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) wnVar;
                    if (threadData.getIs_top() == 1) {
                        jo5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        jo5Var.f(2);
                    } else {
                        jo5Var.f(4);
                    }
                    jo5Var.d(wnVar);
                } else if (wnVar instanceof io5) {
                    jo5Var.f(3);
                    io5 io5Var = (io5) wnVar;
                    jo5Var.e(io5Var.f());
                    jo5Var.d(io5Var.a());
                } else {
                    jo5Var.f(4);
                    jo5Var.d(wnVar);
                }
                arrayList.add(jo5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (zq5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    zq5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && zq5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                zq5.i().n(list, -1, 2);
            }
        }
    }
}
