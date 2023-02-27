package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ax5;
import com.baidu.tieba.ez5;
import com.baidu.tieba.mw5;
import com.baidu.tieba.nw5;
import com.baidu.tieba.ow5;
import com.baidu.tieba.rw5;
import com.baidu.tieba.sw5;
import com.baidu.tieba.tw5;
import com.baidu.tieba.uw5;
import com.baidu.tieba.vw5;
import com.baidu.tieba.zv8;
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
            ax5 ax5Var;
            sw5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ax5) || (c = (ax5Var = (ax5) customResponsedMessage.getData()).c()) == null || !(c instanceof zv8)) {
                return;
            }
            zv8 zv8Var = (zv8) c;
            rw5 Y0 = c.Y0(1);
            if (Y0 == null) {
                uw5 a = vw5.b().a(1);
                if (a == null) {
                    return;
                }
                Y0 = a.a();
                c.x0(1, Y0);
                Y0.f(new tw5(zv8Var), ax5Var.i());
            }
            if (!(Y0 instanceof ow5)) {
                return;
            }
            ow5 ow5Var = (ow5) Y0;
            if (ax5Var.a() == 1) {
                List list = (List) ax5Var.f();
                mw5.b(ow5Var.d());
                for (BdUniqueId bdUniqueId : mw5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(zv8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(zv8Var.p());
                    list.add(frsFeedAdAdapter);
                }
            } else if (ax5Var.a() == 2) {
                ow5Var.k(ax5Var.d());
            } else if (ax5Var.a() == 3) {
                List<Cdo> o = ax5Var.o();
                List<nw5> d = FrsFeedAdStatic.d(o);
                if (ax5Var.q()) {
                    ow5Var.o(d, FrsFeedAdStatic.d(ax5Var.l()), ax5Var.p(), ax5Var.e());
                } else {
                    ow5Var.i(d, ax5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, ax5Var.i()));
            } else if (ax5Var.a() == 4) {
                ow5Var.a(ax5Var.n());
            } else if (ax5Var.a() == 5) {
                ow5Var.e(FrsFeedAdStatic.d(ax5Var.o()), ax5Var.h(), ax5Var.g(), ax5Var.m(), ax5Var.j(), ax5Var.r(), ax5Var.k());
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

    public static List<Cdo> c(List<nw5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (nw5 nw5Var : list) {
                    if (nw5Var.c() == 3) {
                        mw5 mw5Var = new mw5();
                        mw5Var.h(nw5Var.a());
                        mw5Var.i(nw5Var.b());
                        arrayList.add(mw5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (nw5Var.a() instanceof Cdo) {
                        arrayList.add((Cdo) nw5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<nw5> d(List<Cdo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Cdo cdo : list) {
                nw5 nw5Var = new nw5();
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
                    if (threadData.getIs_top() == 1) {
                        nw5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        nw5Var.f(2);
                    } else {
                        nw5Var.f(4);
                    }
                    nw5Var.d(cdo);
                } else if (cdo instanceof mw5) {
                    nw5Var.f(3);
                    mw5 mw5Var = (mw5) cdo;
                    nw5Var.e(mw5Var.f());
                    nw5Var.d(mw5Var.a());
                } else {
                    nw5Var.f(4);
                    nw5Var.d(cdo);
                }
                arrayList.add(nw5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (ez5.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    ez5.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && ez5.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                ez5.i().n(list, -1, 2);
            }
        }
    }
}
