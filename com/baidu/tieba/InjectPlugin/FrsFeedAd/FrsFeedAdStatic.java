package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jh5;
import com.repackage.kh5;
import com.repackage.lh5;
import com.repackage.mh5;
import com.repackage.nn;
import com.repackage.ph5;
import com.repackage.qh5;
import com.repackage.rh5;
import com.repackage.sh5;
import com.repackage.th5;
import com.repackage.u88;
import com.repackage.yh5;
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
            yh5 yh5Var;
            qh5 c;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yh5) && (c = (yh5Var = (yh5) customResponsedMessage.getData()).c()) != null && (c instanceof u88)) {
                u88 u88Var = (u88) c;
                ph5 Q0 = c.Q0(1);
                if (Q0 == null) {
                    sh5 a = th5.b().a(1);
                    if (a == null) {
                        return;
                    }
                    Q0 = a.a();
                    c.p0(1, Q0);
                    Q0.n(new rh5(u88Var));
                }
                if (Q0 instanceof mh5) {
                    mh5 mh5Var = (mh5) Q0;
                    if (yh5Var.a() == 1) {
                        List list = (List) yh5Var.f();
                        kh5.b(mh5Var.c());
                        for (BdUniqueId bdUniqueId : kh5.c()) {
                            jh5 jh5Var = new jh5(u88Var, bdUniqueId);
                            jh5Var.Z(u88Var.o());
                            list.add(jh5Var);
                        }
                    } else if (yh5Var.a() == 2) {
                        mh5Var.i(yh5Var.d());
                    } else if (yh5Var.a() == 3) {
                        List<nn> n = yh5Var.n();
                        List<lh5> d = FrsFeedAdStatic.d(n);
                        if (yh5Var.p()) {
                            mh5Var.m(d, FrsFeedAdStatic.d(yh5Var.k()), yh5Var.o(), yh5Var.e());
                        } else {
                            mh5Var.g(d, yh5Var.e());
                        }
                        n.clear();
                        n.addAll(FrsFeedAdStatic.c(d));
                    } else if (yh5Var.a() == 4) {
                        mh5Var.a(yh5Var.m());
                    } else if (yh5Var.a() == 5) {
                        mh5Var.d(FrsFeedAdStatic.d(yh5Var.n()), yh5Var.h(), yh5Var.g(), yh5Var.l(), yh5Var.i(), yh5Var.q(), yh5Var.j());
                    }
                }
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

    public static List<nn> c(List<lh5> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (lh5 lh5Var : list) {
                if (lh5Var.c() == 3) {
                    kh5 kh5Var = new kh5();
                    kh5Var.h(lh5Var.a());
                    kh5Var.j(lh5Var.b());
                    arrayList.add(kh5Var);
                } else if (lh5Var.a() instanceof nn) {
                    arrayList.add((nn) lh5Var.a());
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<lh5> d(List<nn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (nn nnVar : list) {
                lh5 lh5Var = new lh5();
                if (nnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nnVar;
                    if (threadData.getIs_top() == 1) {
                        lh5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        lh5Var.f(2);
                    } else {
                        lh5Var.f(4);
                    }
                    lh5Var.d(nnVar);
                } else if (nnVar instanceof kh5) {
                    lh5Var.f(3);
                    kh5 kh5Var = (kh5) nnVar;
                    lh5Var.e(kh5Var.f());
                    lh5Var.d(kh5Var.a());
                } else {
                    lh5Var.f(4);
                    lh5Var.d(nnVar);
                }
                arrayList.add(lh5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
