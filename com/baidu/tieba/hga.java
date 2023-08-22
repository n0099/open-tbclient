package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class hga {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, jga> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                hga.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947824135, "Lcom/baidu/tieba/hga;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947824135, "Lcom/baidu/tieba/hga;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001011));
        a = new HashMap<>();
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            for (String str : a.keySet()) {
                b(a.get(str), i);
            }
        }
    }

    public static void b(jga jgaVar, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, jgaVar, i) == null) {
            iga igaVar = jgaVar.d;
            iga igaVar2 = jgaVar.e;
            iga igaVar3 = jgaVar.f;
            if (igaVar.b + igaVar2.b + igaVar3.b >= i) {
                BdStatsItem bdStatsItem = new BdStatsItem("dbg");
                bdStatsItem.append("act", jgaVar.c);
                bdStatsItem.append("httpTimeCost", String.valueOf(igaVar.a));
                bdStatsItem.append("httpNum", String.valueOf(igaVar.b));
                bdStatsItem.append("httpFailnum", String.valueOf(igaVar.c));
                bdStatsItem.append("httpSize", String.valueOf(igaVar.d));
                bdStatsItem.append("socketTimeCost", String.valueOf(igaVar2.a));
                bdStatsItem.append("socketNum", String.valueOf(igaVar2.b));
                bdStatsItem.append("socketFailnum", String.valueOf(igaVar2.c));
                bdStatsItem.append("socketSize", String.valueOf(igaVar2.d));
                bdStatsItem.append("abortTimeCost", String.valueOf(igaVar3.a));
                bdStatsItem.append("abortNum", String.valueOf(igaVar3.b));
                bdStatsItem.append("netType", jgaVar.b);
                if (jgaVar.a) {
                    str = "1";
                } else {
                    str = "0";
                }
                bdStatsItem.append("isJson", str);
                BdStatisticsManager.getInstance().debug("frs", bdStatsItem);
                igaVar.a();
                igaVar2.a();
                igaVar3.a();
            }
        }
    }

    public static void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, str2, z) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new jga(str, str2, z));
            }
        }
    }

    public static jga e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new jga(str, str2, z));
            }
            return a.get(str3);
        }
        return (jga) invokeLLZ.objValue;
    }
}
