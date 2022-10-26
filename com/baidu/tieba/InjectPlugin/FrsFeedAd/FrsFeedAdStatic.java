package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.eo;
import com.baidu.tieba.ie8;
import com.baidu.tieba.jn5;
import com.baidu.tieba.kn5;
import com.baidu.tieba.ln5;
import com.baidu.tieba.on5;
import com.baidu.tieba.pn5;
import com.baidu.tieba.qn5;
import com.baidu.tieba.rn5;
import com.baidu.tieba.sn5;
import com.baidu.tieba.xn5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsFeedAdStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a extends CustomMessageListener {
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
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            xn5 xn5Var;
            pn5 c;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof xn5) || (c = (xn5Var = (xn5) customResponsedMessage.getData()).c()) == null || !(c instanceof ie8)) {
                return;
            }
            ie8 ie8Var = (ie8) c;
            on5 P0 = c.P0(1);
            if (P0 == null) {
                rn5 a = sn5.b().a(1);
                if (a == null) {
                    return;
                }
                P0 = a.a();
                c.o0(1, P0);
                P0.f(new qn5(ie8Var), xn5Var.i());
            }
            if (!(P0 instanceof ln5)) {
                return;
            }
            ln5 ln5Var = (ln5) P0;
            if (xn5Var.a() == 1) {
                List list = (List) xn5Var.f();
                jn5.b(ln5Var.d());
                for (BdUniqueId bdUniqueId : jn5.c()) {
                    FrsFeedAdAdapter frsFeedAdAdapter = new FrsFeedAdAdapter(ie8Var, bdUniqueId);
                    frsFeedAdAdapter.setPageContext(ie8Var.o());
                    list.add(frsFeedAdAdapter);
                }
            } else if (xn5Var.a() == 2) {
                ln5Var.k(xn5Var.d());
            } else if (xn5Var.a() == 3) {
                List o = xn5Var.o();
                List d = FrsFeedAdStatic.d(o);
                if (xn5Var.q()) {
                    ln5Var.o(d, FrsFeedAdStatic.d(xn5Var.l()), xn5Var.p(), xn5Var.e());
                } else {
                    ln5Var.i(d, xn5Var.e());
                }
                o.clear();
                o.addAll(FrsFeedAdStatic.c(d));
            } else if (xn5Var.a() == 4) {
                ln5Var.a(xn5Var.n());
            } else if (xn5Var.a() == 5) {
                ln5Var.e(FrsFeedAdStatic.d(xn5Var.o()), xn5Var.h(), xn5Var.g(), xn5Var.m(), xn5Var.j(), xn5Var.r(), xn5Var.k());
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

    public static List c(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    kn5 kn5Var = (kn5) it.next();
                    if (kn5Var.c() == 3) {
                        jn5 jn5Var = new jn5();
                        jn5Var.h(kn5Var.a());
                        jn5Var.j(kn5Var.b());
                        arrayList.add(jn5Var);
                    } else if (kn5Var.a() instanceof eo) {
                        arrayList.add((eo) kn5Var.a());
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List d(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                kn5 kn5Var = new kn5();
                if (eoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) eoVar;
                    if (threadData.getIs_top() == 1) {
                        kn5Var.f(1);
                    } else if (threadData.getIs_top() == 0) {
                        kn5Var.f(2);
                    } else {
                        kn5Var.f(4);
                    }
                    kn5Var.d(eoVar);
                } else if (eoVar instanceof jn5) {
                    kn5Var.f(3);
                    jn5 jn5Var = (jn5) eoVar;
                    kn5Var.e(jn5Var.f());
                    kn5Var.d(jn5Var.a());
                } else {
                    kn5Var.f(4);
                    kn5Var.d(eoVar);
                }
                arrayList.add(kn5Var);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
