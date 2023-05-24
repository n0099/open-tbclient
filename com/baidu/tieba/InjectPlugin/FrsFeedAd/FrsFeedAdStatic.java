package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.e26;
import com.baidu.tieba.lz5;
import com.baidu.tieba.mz5;
import com.baidu.tieba.nz5;
import com.baidu.tieba.qz5;
import com.baidu.tieba.rn;
import com.baidu.tieba.rz5;
import com.baidu.tieba.sz5;
import com.baidu.tieba.tf9;
import com.baidu.tieba.tz5;
import com.baidu.tieba.uz5;
import com.baidu.tieba.zz5;
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
            zz5 zz5Var;
            rz5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof zz5) || (c = (zz5Var = (zz5) customResponsedMessage.getData()).c()) == null || !(c instanceof tf9)) {
                return;
            }
            tf9 tf9Var = (tf9) c;
            qz5 c1 = c.c1(1);
            if (c1 == null) {
                tz5 a = uz5.b().a(1);
                if (a == null) {
                    return;
                }
                c1 = a.a();
                c.A0(1, c1);
                c1.f(new sz5(tf9Var), zz5Var.i());
            }
            if (!(c1 instanceof nz5)) {
                return;
            }
            nz5 nz5Var = (nz5) c1;
            if (zz5Var.a() == 1) {
                List list = (List) zz5Var.f();
                lz5.b(nz5Var.d());
                for (BdUniqueId bdUniqueId : lz5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(tf9Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(tf9Var.s());
                    list.add(frsFeedAdAdapter);
                }
            } else if (zz5Var.a() == 2) {
                nz5Var.k(zz5Var.d());
            } else if (zz5Var.a() == 3) {
                List<rn> o = zz5Var.o();
                List<mz5> d = FrsFeedAdStatic.d(o);
                if (zz5Var.q()) {
                    nz5Var.o(d, FrsFeedAdStatic.d(zz5Var.l()), zz5Var.p(), zz5Var.e());
                } else {
                    nz5Var.i(d, zz5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d, zz5Var.i()));
            } else if (zz5Var.a() == 4) {
                nz5Var.a(zz5Var.n());
            } else if (zz5Var.a() == 5) {
                nz5Var.e(FrsFeedAdStatic.d(zz5Var.o()), zz5Var.h(), zz5Var.g(), zz5Var.m(), zz5Var.j(), zz5Var.r(), zz5Var.k());
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

    public static List<rn> c(List<mz5> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (mz5 mz5Var : list) {
                    if (mz5Var.c() == 3) {
                        lz5 lz5Var = new lz5();
                        lz5Var.f(mz5Var.a());
                        lz5Var.h(mz5Var.b());
                        arrayList.add(lz5Var);
                        if (!z) {
                            z = true;
                            e(str, arrayList);
                        }
                    } else if (mz5Var.a() instanceof rn) {
                        arrayList.add((rn) mz5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeLL.objValue;
    }

    public static List<mz5> d(List<rn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (rn rnVar : list) {
                mz5 mz5Var = new mz5();
                if (rnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) rnVar;
                    if (threadData.getIs_top() == 1) {
                        mz5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        mz5Var.f(2);
                    } else {
                        mz5Var.f(4);
                    }
                    mz5Var.d(rnVar);
                } else if (rnVar instanceof lz5) {
                    mz5Var.f(3);
                    lz5 lz5Var = (lz5) rnVar;
                    mz5Var.e(lz5Var.d());
                    mz5Var.d(lz5Var.a());
                } else {
                    mz5Var.f(4);
                    mz5Var.d(rnVar);
                }
                arrayList.add(mz5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void e(String str, List<rn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, list) == null) {
            if ("frs_hot_tab".equals(str)) {
                if (e26.i().p(AbsDataRecorder.Scene.FRS_HOT)) {
                    e26.i().n(list, -1, 3);
                }
            } else if ("frs_new_tab".equals(str) && e26.i().p(AbsDataRecorder.Scene.FRS_NEW)) {
                e26.i().n(list, -1, 2);
            }
        }
    }
}
